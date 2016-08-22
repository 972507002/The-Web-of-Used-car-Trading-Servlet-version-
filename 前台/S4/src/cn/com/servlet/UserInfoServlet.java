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
public class UserInfoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		IUserInfoService userInfoService=new UserInfoServiceImpl();
		String op= req.getParameter("op");
	
		String _url=req.getParameter("url");
		deleteYzm(session);
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
			 if(req.getParameterValues("checkbox")!=null){
				 Cookie cookie=new Cookie("bzUserName", Long.toString(_userInfo.getU_tel()));
				 cookie.setMaxAge(365*24*60*60);
				 resp.addCookie(cookie);
			 }
			 else{
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
				 loginmessage="���û�������";
				 String sRand= getYZM(session);
				    session.setAttribute("sRand", sRand);
			 }
			 else{
				 loginmessage="�û������������,����������";
				 String sRand= getYZM(session);
				 session.setAttribute("sRand", sRand);
			 }
			 req.setAttribute("loginmessage", loginmessage);
			req.getRequestDispatcher(_url).forward(req, resp);

		}
		 }
			 else{
				 String	 loginmessage="���Ѿ���½��һ���˻���";
				 String sRand= getYZM(session);
				 session.setAttribute("sRand", sRand);
				 req.setAttribute("loginmessage", loginmessage);
				 req.getRequestDispatcher(_url).forward(req, resp);	 
			 }
			 }
		 if(op.equals("needLogin")){
			    String sRand= getYZM(session);
			    session.setAttribute("sRand", sRand);
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
					resp.getWriter().flush();//��ջ���,ˢ��
					resp.getWriter().close();
			  
			    
		 }
		 if(op.equals("needreg")){
			 String sRand= getYZM(session);
			 session.setAttribute("sRand", sRand);
			 resp.setContentType("text/html;charset=utf-8");
			
			  resp.getWriter().println(sRand);
				resp.getWriter().flush();//��ջ���,ˢ��
				resp.getWriter().close();
			 
		 }
		 if(op.equals("reguser")){
			
		long regname=Long.parseLong(req.getParameter("regname"));
		String realname=req.getParameter("realname");
		String sex=req.getParameter("gender");
	     String regpwd=  req.getParameter("regpwd");
	     String regmessage=null;
	     UserInfo userInfo=new UserInfo();
	     userInfo.setU_tel(regname);
	     if(userInfoService.getUserInfoByUnique(userInfo)!=null){
	    	 DbUtil.closeAll();
	    	 regmessage="���ֻ����ѱ�ע��,������¼��������һ������";
	    	 String sRand= getYZM(session);
	    	 session.setAttribute("sRand", sRand);
	    	 
	     }
	     else{
	    	 userInfo.setU_name(realname);
		     userInfo.setU_pwd(regpwd);
		     userInfo.setU_sex(sex);
		     userInfo.setU_admin("��ͨ�û�");
		     if(userInfoService.addUserInfo(userInfo)){
		    	 DbUtil.closeAll();
		    String	 loginmessage="ע��ɹ�,���ھͿ�ʼ��¼��";
		    String sRand= getYZM(session);
	    	 session.setAttribute("sRand", sRand);
		    req.setAttribute("loginmessage", loginmessage);
		     }
		     else{
		    	 DbUtil.closeAll();
		    	 regmessage="ע��ʧ��";
		    	 String sRand= getYZM(session);
		    	 session.setAttribute("sRand", sRand);
		     }
	     }
	     req.setAttribute("regmessage", regmessage);
			req.getRequestDispatcher(_url).forward(req, resp);

		 }
		 if(op.equals("zhuxiao")){
			 session.removeAttribute("userinfo");
			 
			 req.getRequestDispatcher(_url).forward(req, resp);
		 }
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
		 if(op.equals("updatepwd")){
		UserInfo userInfo=(UserInfo) session.getAttribute("userinfo");
		String opwd=	 req.getParameter("opwd");
		  userInfo.setU_pwd(opwd);
		  if(userInfoService.login(userInfo)!=null){
			  String npwd=req.getParameter("npwd");
			  userInfo.setU_pwd(npwd);
			if(userInfoService.updateUserPwd(userInfo)){
				 String updatemessage="�����޸ĳɹ�";
				  req.setAttribute("updatemessage", updatemessage);
				  req.getRequestDispatcher("admin/memberMyAccount.jsp").forward(req, resp);
			}
		  }
		  else{
			  String updatemessage="��ǰ�������,����������";
			  req.setAttribute("updatemessage", updatemessage);
			  req.getRequestDispatcher("admin/memberMyAccount.jsp").forward(req, resp);
			  
		  }
		 }
		 if(op.equals("updateyzm")){
			 String sRand= getYZM(session);
			 resp.setContentType("text/html;charset=utf-8");
			 session.setAttribute("sRand", sRand);
			  resp.getWriter().println(sRand);
				resp.getWriter().flush();//��ջ���,ˢ��
				resp.getWriter().close();
		 }
		 if(op.equals("hsy")){
			 String sRand= getYZM(session);
	    	 session.setAttribute("sRand", sRand);
			 String loginmessage="k";
			 req.setAttribute("loginmessage", loginmessage);
			 req.getRequestDispatcher(_url).forward(req, resp);
		 }
		
	}
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
	   
    private String getYZM(HttpSession session){
    	 int width = 60;  
		    int height = 40;  
		    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
		    //����ͼ��  
		    Graphics g = image.getGraphics();  
		    //�����������  
		    Random random = new Random();  
		    //���ñ���ɫ  
		    g.setColor(getRandColor(200,250));  
		    g.fillRect(0,0,width,height);  
		    //��������  
		    g.setFont(new Font("Tines Nev Roman",Font.PLAIN,18));  
		    //�������������  
		    g.setColor(getRandColor(160,200));  
		    for(int i = 0; i < 255; i++){  
		        int x = random.nextInt(width);  
		        int y = random.nextInt(height);  
		        int x1 = random.nextInt(12);  
		        int y1 = random.nextInt(12); 
		        g.drawLine(x,y,x-x1,y-y1);
		    }  
		    //���������֤��,4λ����  
		    String sRand = "";  
		    for(int i = 0; i < 4; i++){  
		        String rand = String.valueOf(random.nextInt(10));  
		        sRand  += rand;  
		        //����֤����ʾ��ͼ����  
		        g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));  
		        g.drawString(rand,13*i+6,16);  
		    }  
		    //ͼ����Ч  
		    g.dispose();  
		    //���ͼ��ҳ��  
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
    private void deleteYzm(HttpSession session){
    String	sRand=(String) session.getAttribute("sRand");
	    String url=session.getServletContext().getRealPath("/images")+"/"+sRand+".jpg";
    File file=new File(url);
   
    if(file.exists()){
    	file.delete();
    	
    }
    }
}
