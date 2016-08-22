package cn.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.bean.UserInfo;

import cn.com.service.impl.UserInfoServiceImpl;
import cn.com.util.DbUtil;
import cn.com.bean.*;
import cn.com.service.*;
import cn.com.service.impl.*;
public class MgUserInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserInfoServiceImpl userInfoServiceImpl=new UserInfoServiceImpl();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
	String op=req.getParameter("op");
	if(op.equals("uptadeuser")){
		String uid=req.getParameter("uid");
		UserInfo userInfo=new UserInfo();
		userInfo.setU_id(Long.parseLong(uid));
	UserInfo info=	userInfoServiceImpl.getUserInfoByUnique(userInfo);
	req.setAttribute("getuser",info );
	req.getRequestDispatcher("admin/user-modify.jsp").forward(req, resp);
	}
	 if(op.equals("update")){
			
		 String card=req.getParameter("card");
		 String email=req.getParameter("email");
		 String qq=req.getParameter("qq");
		 String realname=req.getParameter("realname");
		 String adr=req.getParameter("adr");
		 String sex=req.getParameter("gender");
		 String uid=req.getParameter("uid");
		
	UserInfo  userInfo=	 new UserInfo();
	   userInfo.setU_id(Long.parseLong(uid));
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
		 if(userInfoServiceImpl.updateUserInfo(userInfo)){
			
		UserInfo info=	userInfoServiceImpl.getUserInfoByUnique(userInfo);
		 req.setAttribute("getuser", info);
		 req.getRequestDispatcher("admin/user-modify.jsp").forward(req, resp);
			 
		 }
		 
	 }
	 if(op.equals("reguser")){
			
			long regname=Long.parseLong(req.getParameter("mobile"));
			String realname=req.getParameter("realname");
			String sex=req.getParameter("sex");
		     String regpwd=  req.getParameter("npwd");
		     String admin=req.getParameter("admin");
		     String regmessage=null;
		     UserInfo userInfo=new UserInfo();
		     userInfo.setU_tel(regname);
		     if(userInfoServiceImpl.getUserInfoByUnique(userInfo)!=null){
		    	 DbUtil.closeAll();
		    	 regmessage="该用户已存在";
		    	
		    	 
		     }
		     else{
		    	 userInfo.setU_name(realname);
			     userInfo.setU_pwd(regpwd);
			     userInfo.setU_sex(sex);
			     userInfo.setU_admin(admin);
			     if(userInfoServiceImpl.addUserInfo(userInfo)){
			    	 DbUtil.closeAll();
			    	 regmessage="添加成功";
			   
			    req.setAttribute("regmessage", regmessage);
			     }
			     else{
			    	 DbUtil.closeAll();
			    	 regmessage="添加失败";
			    	
			     }
		     }
		     req.setAttribute("regmessage", regmessage);
				req.getRequestDispatcher("admin/user-add.jsp").forward(req, resp);

			 }
	 if(op.equals("del"))//删除
		{  
		 IBasicInfoService iBasicInfoService=new BasicInfoServiceImpl();
			IHardwareConfigService iHardwareConfigService=new HardwareConfigServiceImpl();
			ICarImagesInfoService iCarImagesInfoService=new CarImagesInfoServiceImpl();
			IPerSonCarService iPerSonCarService=new PersonCarServiceImpl();
			ISellInfoService iSellInfoService=new SellInfoServiceImpl();
			ISystemConfigService iSystemConfigService=new SystemConfigServiceImpl();
			IProcedureInfoService iProcedureInfoService=new ProcedureInfoServiceImpl();
			IUserInfoService iUserinfoService=new UserInfoServiceImpl();
			ICarInfoService iCarInfoService=new CarInfoServiceImpl();
			IPersonNeedService iPersonNeedService=new PersonNeedServiceImpl();
			long uid=Long.parseLong(req.getParameter("id"));
			UserInfo userinfo=new UserInfo();
			userinfo.setU_id(uid);
			BasicInfo basicInfo=new BasicInfo();
			basicInfo.setU_id(uid);
			HardwareConfig hardwareConfig=new HardwareConfig();
			hardwareConfig.setU_id(uid);
			CarImagesInfo carImagesInfo=new CarImagesInfo();
			carImagesInfo.setU_id(uid);
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setU_id(uid);
		perSonCar.setC_uid(uid);
			PersonNeed personneed=new PersonNeed();
			personneed.setU_id(uid);
			SellInfo sellInfo=new SellInfo();
			sellInfo.setU_id(uid);
			SystemConfig systemConfig=new SystemConfig();
			systemConfig.setU_id(uid);
			ProcedureInfo procedureInfo=new ProcedureInfo();
			procedureInfo.setU_id(uid);
			CarInfo carInfo=new CarInfo();
			carInfo.setU_id(uid);
			boolean dbflag=false;
			boolean dhflag=false;
			boolean diflag=false;
			boolean dpcflag=false;
			boolean dsflag=false;
			boolean dscflag=false;
			boolean dpflag=false;
			boolean dcflag=false;
			 boolean dcuidflag=false;
			   boolean dupnflag=false;
			if(iBasicInfoService.checkbasicinfo(basicInfo))
			{
				 dbflag=	iBasicInfoService.deletebasicinfo( basicInfo);
			}
			else
			{
				dbflag=true;
			}
			if(iHardwareConfigService.checkhardwareconfig(hardwareConfig))
			{
				 dhflag=	iHardwareConfigService.deletehardwareconfiguser(hardwareConfig);
			}
			else
			{
				dhflag=true;
			}
			if(iCarImagesInfoService.checkimageinfouser(carImagesInfo))
			{
				 diflag=	iCarImagesInfoService.deleteimagesinfouser(carImagesInfo);
			}
			else
			{
				diflag=true;
			}
			if(iPerSonCarService.checkipersoncaruser(perSonCar))
			{
				 dpcflag=	iPerSonCarService.deletepersoncaruser( perSonCar);
			}
			else
			{
				dpcflag=true;
			}
			if(iPerSonCarService.checkcuidperson(perSonCar)){
				dcuidflag=	iPerSonCarService.deletecuidperson( perSonCar);
			}
			else{
				dcuidflag=true;
			}
			if(iPersonNeedService.chekUidPerson(personneed)){
				dupnflag=iPersonNeedService.deleteUidPerson(personneed);
			}
			else{
				dupnflag=true;
			}
			if(iSellInfoService.checksellinfouser(sellInfo))
			{
				 dsflag=	iSellInfoService.deletesellinfouser( sellInfo);
			}
			else
			{
				dsflag=true;
			}
			if(iSystemConfigService.checksystemconfiguser(systemConfig))
			{
				 dscflag =iSystemConfigService.deletesystemconfiguser( systemConfig);
			}
			else
			{dscflag=true;
				
			}
			if(iProcedureInfoService.checkprocedureinfouser(procedureInfo))
			{
				 dpflag=iProcedureInfoService.deleteprocedureinfouser( procedureInfo);
			}
			else
			{
				dpflag=true;
			}
			if(iCarInfoService.checkcarinfouser(carInfo))
			{
				 dcflag =iCarInfoService. deletecarinfouser( carInfo);
			}
			else
			{ dcflag=true;
				
			}
			if(dbflag&&dhflag&&diflag&&dpcflag&&dscflag&&dsflag&&dcflag&&dpflag&&dcuidflag&&dupnflag)
			{
			boolean flag= iUserinfoService. deleteuserinfouser( userinfo);
			if(flag)
			{
				resp.getWriter().print(1);
			}
			else
			{
				resp.getWriter().print(0);
			}
			}
			else
			{
				resp.getWriter().print(0);
			}
		}
	 if(op.equals("showdeauser")){
		 String uid=req.getParameter("uid");
		 UserInfo info=new UserInfo();
		 info.setU_id(Long.parseLong(uid));
	info=	 userInfoServiceImpl.getUserInfoByUnique(info);
	req.setAttribute("info", info);
	req.getRequestDispatcher("admin/showuser.jsp").forward(req, resp);
	 }
	}

}
