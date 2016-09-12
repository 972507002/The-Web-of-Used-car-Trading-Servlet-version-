package cn.com.servlet;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import cn.com.bean.*;
import cn.com.service.*;
import cn.com.service.impl.*;
import cn.com.util.DbUtil;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;
/**
 * 用户信息处理引擎
 * 
 * 
 */
public class UserInfoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		IUserInfoService userInfoService=new UserInfoServiceImpl();
		String op= req.getParameter("op");//操作符
	
		String _url=req.getParameter("url");
		deleteYzm(session);//删除验证码
		//跳转页面参数绑定
		if(req.getParameter("bname")!=null){
			req.setAttribute("bname", req.getParameter("bname"));
		}
		if(req.getParameter("tname")!=null){
			req.setAttribute("tname", req.getParameter("tname"));
		}
		if(req.getParameter("cesr")!=null){
			req.setAttribute("cesr", req.getParameter("cesr"));
		}
		if(req.getParameter("price")!=null){
			req.setAttribute("price", req.getParameter("price"));
		}
		if(req.getParameter("distance")!=null){
			req.setAttribute("distance", req.getParameter("distance"));
		}
		if(req.getParameter("age")!=null){
			req.setAttribute("age", req.getParameter("age"));
		}
		if(req.getParameter("emsi")!=null){
			req.setAttribute("emsi", req.getParameter("emsi"));
		}
		if(req.getParameter("bid")!=null){
			req.setAttribute("bid", req.getParameter("bid"));
		}
		if(req.getParameter("cid")!=null){
			req.setAttribute("cid", req.getParameter("cid"));
		}
		//登录操作
		 if(op.equals("login")){
			 if(session.getAttribute("userinfo")==null){	 
		long u_tel=Long.parseLong(req.getParameter("username"));
		
		String u_pwd=req.getParameter("userpwd");
		
		UserInfo userInfo=new UserInfo();
		userInfo.setU_tel(u_tel);
		userInfo.setU_pwd(u_pwd);
		UserInfo _userInfo=userInfoService.login(userInfo);
		DbUtil.closeAll();
		
		if(_userInfo!=null){
			Date date=new Date();
			 DateFormat dateFormat=new SimpleDateFormat("HH");
			 if(req.getParameterValues("checkbox")!=null){//判断用户是否选择保存账户
			 //将账户保存至cookie中
				 Cookie cookie=new Cookie("bzUserName", Long.toString(_userInfo.getU_tel()));
				 cookie.setMaxAge(365*24*60*60);
				 resp.addCookie(cookie);
			 }
			 else{
			 	//否则删除原cookie中保存的账户
				 Cookie[] cookises= req.getCookies();
				  
				   if(cookises!=null){
					   for(int i=0;i<cookises.length;i++){
						   if(cookises[i]!=null&&cookises[i].getName().equals("bzUserName")){
							
						  cookises[i].setMaxAge(0);
							  resp.addCookie(cookises[i]);
							  break;
						   }
					   }
				   }
			 }
		
	   
			session.setAttribute("time",dateFormat.format(date) );
			session.setAttribute("userinfo", _userInfo);
			req.getRequestDispatcher(_url).forward(req, resp);
		}
		else{
			userInfo.setU_pwd(null);
			String loginmessage=null;
			 if(userInfoService.getUserInfoByUnique(userInfo)==null){
				 DbUtil.closeAll();
				 loginmessage="该用户不存在";
				 String sRand= getYZM(session);
				    session.setAttribute("sRand", sRand);
			 }
			 else{
				 loginmessage="用户名或密码错误,请重新输入";
				 String sRand= getYZM(session);
				 session.setAttribute("sRand", sRand);
			 }
			 req.setAttribute("loginmessage", loginmessage);
			req.getRequestDispatcher(_url).forward(req, resp);

		}
		 }
			 else{
				 String	 loginmessage="你已经登陆过一个账户了";
				 String sRand= getYZM(session);
				 session.setAttribute("sRand", sRand);
				 req.setAttribute("loginmessage", loginmessage);
				 req.getRequestDispatcher(_url).forward(req, resp);	 
			 }
			 }
			 //用户需要登录的操作
		 if(op.equals("needLogin")){
			    String sRand= getYZM(session);
			    session.setAttribute("sRand", sRand);
			    //判断cookie中是否有用户保存的账户,有则显示
			   Cookie[] cookises= req.getCookies();
			  
			   if(cookises!=null){
				   for(int i=0;i<cookises.length;i++){
					   if(cookises[i]!=null&&cookises[i].getName().equals("bzUserName")){
						   
						   sRand+=","+cookises[i].getValue().trim();
						  break;
					   }
				   }
			   }
			    resp.setContentType("text/html;charset=utf-8");
				 
				  resp.getWriter().println(sRand);
					resp.getWriter().flush();//清空缓存,刷新
					resp.getWriter().close();
			  
			    
		 }
		 //用户需要注册的操作
		 if(op.equals("needreg")){
			 String sRand= getYZM(session);
			 session.setAttribute("sRand", sRand);
			 resp.setContentType("text/html;charset=utf-8");
			
			  resp.getWriter().println(sRand);
				resp.getWriter().flush();//清空缓存,刷新
				resp.getWriter().close();
			 
		 }
		 //确认注册的操作
		 if(op.equals("reguser")){
			
		long regname=Long.parseLong(req.getParameter("regname"));
		String realname=req.getParameter("realname");
		String sex=req.getParameter("gender");
	     String regpwd=  req.getParameter("regpwd");
	     String regmessage=null;
	     UserInfo userInfo=new UserInfo();
	     userInfo.setU_tel(regname);
	     //判断用户是否已存在
	     if(userInfoService.getUserInfoByUnique(userInfo)!=null){
	    	 DbUtil.closeAll();
	    	 regmessage="此手机号已被注册,请进入登录面板试试找回密码吧";
	    	 String sRand= getYZM(session);
	    	 session.setAttribute("sRand", sRand);
	    	 
	     }
	     else{
	    	 userInfo.setU_name(realname);
		     userInfo.setU_pwd(regpwd);
		     userInfo.setU_sex(sex);
		     userInfo.setU_admin("普通用户");
		     if(userInfoService.addUserInfo(userInfo)){
		    	 DbUtil.closeAll();
		    String	 loginmessage="注册成功,现在就开始登录吧";
		    String sRand= getYZM(session);
	    	 session.setAttribute("sRand", sRand);
		    req.setAttribute("loginmessage", loginmessage);
		     }
		     else{
		    	 DbUtil.closeAll();
		    	 regmessage="注册失败";
		    	 String sRand= getYZM(session);
		    	 session.setAttribute("sRand", sRand);
		     }
	     }
	     req.setAttribute("regmessage", regmessage);
			req.getRequestDispatcher(_url).forward(req, resp);

		 }
		 //注销操作
		 if(op.equals("zhuxiao")){
			 session.removeAttribute("userinfo");
			 
			 req.getRequestDispatcher(_url).forward(req, resp);
		 }
		 //更改用户信息操作
		 if(op.equals("update")){
			
			 String card=req.getParameter("card");
			 String email=req.getParameter("email");
			 String qq=req.getParameter("qq");
			 String realname=req.getParameter("realname");
			 String adr=req.getParameter("adr");
			 String sex=req.getParameter("gender");
			 
		UserInfo  userInfo=	 (UserInfo) session.getAttribute("userinfo");
			 userInfo.setU_name(realname);
			 userInfo.setU_sex(sex);
			 if(card!=null&&!card.equals("")){
				 userInfo.setU_card(Long.parseLong(card));
			 }
			 if(qq!=null&&!qq.equals("")){
				 userInfo.setU_qq(Long.parseLong(qq));
			 }
			 if(email!=null&&!email.equals("")){
				 userInfo.setU_email(email);
			 }
			 if(adr!=null&&!adr.equals("")){
				 userInfo.setU_adr(adr);
			 }
			 if(userInfoService.updateUserInfo(userInfo)){
				 session.setAttribute("userinfo", userInfo);
				 resp.sendRedirect("admin/memberMyAccount.jsp");
			 }
			 
		 }
		 //更改密码操作
		 if(op.equals("updatepwd")){
		UserInfo userInfo=(UserInfo) session.getAttribute("userinfo");
		String opwd=	 req.getParameter("opwd");
		  userInfo.setU_pwd(opwd);
		  if(userInfoService.login(userInfo)!=null){
			  String npwd=req.getParameter("npwd");
			  userInfo.setU_pwd(npwd);
			if(userInfoService.updateUserPwd(userInfo)){
				 String updatemessage="密码修改成功";
				  req.setAttribute("updatemessage", updatemessage);
				  req.getRequestDispatcher("admin/memberMyAccount.jsp").forward(req, resp);
			}
		  }
		  else{
			  String updatemessage="当前密码错误,请重新输入";
			  req.setAttribute("updatemessage", updatemessage);
			  req.getRequestDispatcher("admin/memberMyAccount.jsp").forward(req, resp);
			  
		  }
		 }
		 //换验证码操作
		 if(op.equals("updateyzm")){
			 String sRand= getYZM(session);
			 resp.setContentType("text/html;charset=utf-8");
			 session.setAttribute("sRand", sRand);
			  resp.getWriter().println(sRand);
				resp.getWriter().flush();//清空缓存,刷新
				resp.getWriter().close();
		 }
		 //回到首页操作
		 if(op.equals("hsy")){
			 String sRand= getYZM(session);
	    	 session.setAttribute("sRand", sRand);
			 String loginmessage="k";
			 req.setAttribute("loginmessage", loginmessage);
			 req.getRequestDispatcher(_url).forward(req, resp);
		 }
		
	}
	/**
	 *验证码背景颜色设置的方法
	 * 
	 */
	private   Color getRandColor(int fc,int bc){  
	        Random random = new Random();  
	        if(fc > 255){  
	            fc = 255;  
	        }  
	        if(bc < 255){  
	            bc = 255;  
	        }  
	        int r = fc +random.nextInt(bc-fc);  
	        int g = fc +random.nextInt(bc-fc);  
	        int b = fc +random.nextInt(bc-fc);  
	        return new Color(r,g,b);  
	    }  
	   /**
	    * 生成验证码图片的方法
	    */
    private String getYZM(HttpSession session){
    	 int width = 60;  
		    int height = 40;  
		    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
		    //创建图象  
		    Graphics g = image.getGraphics();  
		    //生成随机对象  
		    Random random = new Random();  
		    //设置背景色  
		    g.setColor(getRandColor(200,250));  
		    g.fillRect(0,0,width,height);  
		    //设置字体  
		    g.setFont(new Font("Tines Nev Roman",Font.PLAIN,18));  
		    //随机产生干扰线  
		    g.setColor(getRandColor(160,200));  
		    for(int i = 0; i < 255; i++){  
		        int x = random.nextInt(width);  
		        int y = random.nextInt(height);  
		        int x1 = random.nextInt(12);  
		        int y1 = random.nextInt(12); 
		        g.drawLine(x,y,x-x1,y-y1);
		    }  
		    //随机产生认证码,4位数字  
		    String sRand = "";  
		    for(int i = 0; i < 4; i++){  
		        String rand = String.valueOf(random.nextInt(10));  
		        sRand  += rand;  
		        //将认证码显示到图象中  
		        g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));  
		        g.drawString(rand,13*i+6,16);  
		    }  
		    //图像生效  
		    g.dispose();  
		    //输出图像到页面  
		    String url=session.getServletContext().getRealPath("/images")+"/"+sRand+".jpg";
		   FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(url, false);
			  ImageIO.write(image, "jpg", fileOutputStream);
			    fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		    return sRand;
    }
    /**
     * 
     * 删除验证码的方法
     */
    private void deleteYzm(HttpSession session){
    String	sRand=(String) session.getAttribute("sRand");
	    String url=session.getServletContext().getRealPath("/images")+"/"+sRand+".jpg";
    File file=new File(url);
   
    if(file.exists()){
    	file.delete();
    	
    }
    }
}
