package cn.com.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bean.BasicInfo;
import cn.com.bean.CarImagesInfo;
import cn.com.bean.CarInfo;
import cn.com.bean.CarType;
import cn.com.bean.HardwareConfig;
import cn.com.bean.PerSonCar;
import cn.com.bean.PersonNeed;
import cn.com.bean.ProcedureInfo;
import cn.com.bean.SellInfo;
import cn.com.bean.SystemConfig;
import cn.com.bean.UserInfo;
import cn.com.service.IBasicInfoService;
import cn.com.service.ICarImagesInfoService;
import cn.com.service.ICarInfoService;
import cn.com.service.ICarTypeService;
import cn.com.service.IHardwareConfigService;
import cn.com.service.IProcedureInfoService;
import cn.com.service.ISellInfoService;
import cn.com.service.ISystemConfigService;
import cn.com.service.impl.BasicInfoServiceImpl;
import cn.com.service.impl.CarImagesInfoServiceImpl;
import cn.com.service.impl.CarInfoServiceImpl;
import cn.com.service.impl.CarTypeServiceImpl;
import cn.com.service.impl.HardwareConfigServiceImpl;
import cn.com.service.impl.PersonCarServiceImpl;
import cn.com.service.impl.PersonNeedServiceImpl;
import cn.com.service.impl.ProcedureInfoServiceImpl;
import cn.com.service.impl.SellInfoServiceImpl;
import cn.com.service.impl.SystemConfigServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

public class MemberCenterServlet extends HttpServlet {
  private PersonCarServiceImpl perSonCarService = new PersonCarServiceImpl();
  ICarInfoService carInfoService=new CarInfoServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
         req.setCharacterEncoding("UTF-8");
         resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		Object object = session.getAttribute("userinfo");
		if (object != null) {
			UserInfo userInfo=(UserInfo) object;
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String op = req.getParameter("op");
			PerSonCar perSonCar = new PerSonCar();
			if (op.equals("showmenber")) {
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("收藏");
		 int scCount=perSonCarService.getCarCountByWhere(perSonCar);
	
		 perSonCar.setP_state("已定");
		 int ydCount=perSonCarService.getCarCountByWhere(perSonCar);
	
		 req.setAttribute("scCount", scCount);
		 req.setAttribute("ydCount", ydCount);
		 req.getRequestDispatcher("admin/menber.jsp").forward(req, resp);
			}
			if(op.equals("showmenberSc")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("收藏");
	  fenye(req, resp, perSonCar);
	  
	  
	   
	   req.getRequestDispatcher("admin/memberMySc.jsp").forward(req, resp);
			}
			if(op.equals("showmenberOrder")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("已定");
				 fenye(req, resp, perSonCar);
	         
	  
	   req.getRequestDispatcher("admin/memberMyOrder.jsp").forward(req, resp);
			}
			if(op.equals("showmenberMc")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("出售");
				 fenye(req, resp, perSonCar);
		           DbUtil.closeAll();
		           req.getRequestDispatcher("admin/memberMyMc.jsp").forward(req, resp);
			}
             if(op.equals("showmenberYbcar")){
            	 perSonCar.setU_id(userInfo.getU_id());
 				perSonCar.setP_state("交易完成");
 				 fenye(req, resp, perSonCar);
 		           DbUtil.closeAll();
 		           req.getRequestDispatcher("admin/memberMyCar.jsp").forward(req, resp);
			}
			if(op.equals("showmenberSh")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("审核中");
				 fenye(req, resp, perSonCar);
		           DbUtil.closeAll();
		           req.getRequestDispatcher("admin/memberMyRz.jsp").forward(req, resp);
			}
			
			if(op.equals("showmenberbjj")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("未通过");
				 fenye(req, resp, perSonCar);
		           DbUtil.closeAll();
		           req.getRequestDispatcher("admin/memberMyBjj.jsp").forward(req, resp);
			}
			if(op.equals("showmenberJyz")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("被定");
				 fenye(req, resp, perSonCar);
		           DbUtil.closeAll();
		           req.getRequestDispatcher("admin/memberMyJyz.jsp").forward(req, resp);
			}
			if(op.equals("showmenberymw")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("卖出完成");
				 fenye(req, resp, perSonCar);
		           DbUtil.closeAll();
		           req.getRequestDispatcher("admin/memberMyYmc.jsp").forward(req, resp);
			}
			if(op.equals("showmenberXj")){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("下架");
				 fenye(req, resp, perSonCar);
		           DbUtil.closeAll();
		           req.getRequestDispatcher("admin/memberMyXj.jsp").forward(req, resp);
			}
			if(op.equals("showmenberSj")){
           	 CarInfo carInfo=new CarInfo();

				this.finishop(req, perSonCar, userInfo,carInfo);
			   perSonCar.setP_state("下架");
			   carInfo.setC_state("在售");
				if(perSonCarService.updatePerSoncar(perSonCar, "出售")){
					if(carInfoService.updateCarInfo(carInfo)){
					resp.sendRedirect("MemberCenter.action?op=showmenberMc");
				}
				}
			}
			if(op.equals("qxsc")){

				this.finishop(req, perSonCar, userInfo,null);
				perSonCar.setP_state("收藏");
				if(perSonCarService.deletePerSoncar(perSonCar)){
					resp.sendRedirect("MemberCenter.action?op=showmenberSc");
				}
			}
			if(op.equals("qrsh")){
				CarInfo carInfo=new CarInfo();
                    
				this.finishop(req, perSonCar, userInfo,carInfo);
			   perSonCar.setP_state("已定");
			   carInfo.setC_state("交易完成");
			   DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			    Date date=new Date();
			   carInfo.setC_mcsj( dateFormat.format(date));
				if(perSonCarService.updatePerSoncar(perSonCar, "交易完成")){
					if(carInfoService.updateCarInfo(carInfo)){
						perSonCar.setU_id(perSonCar.getC_uid());
						perSonCar.setP_state("被定");
						if(perSonCarService.updatePerSoncar(perSonCar, "卖出完成")){
					resp.sendRedirect("MemberCenter.action?op=showmenberYbcar");
						}
				}
				}
			}
            
             if(op.equals("tjbjj")){
            	 CarInfo carInfo=new CarInfo();
            	 this.finishop(req, perSonCar, userInfo,carInfo);
                 perSonCar.setP_state("未通过");
                 carInfo.setC_state("审核中");
                 if(perSonCarService.updatePerSoncar(perSonCar, "审核中")){
 					if(carInfoService.updateCarInfo(carInfo)){
                	 resp.sendRedirect("MemberCenter.action?op=showmenberSh");
 					}
                 }
             }
			if(op.equals("needsc")){
		String c_uid=req.getParameter("c_uid");
		String c_id=req.getParameter("c_id");
			perSonCar.setC_uid(Long.parseLong(c_uid));
			perSonCar.setC_id(Long.parseLong(c_id));
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setP_state("收藏");
				CarInfo carInfo=new CarInfo();
				carInfo.setC_id(Long.parseLong(c_id));
				carInfo.setU_id(Long.parseLong(c_uid));
			Map<Long, CarInfo> car=	carInfoService.getCarByWhere(carInfo);
			 CarInfo _car=car.get(carInfo.getC_id());
			 _car.setC_sccount(_car.getC_sccount()+1);
			 String scmessage=null;
			if(userInfo.getU_id()!=carInfo.getU_id())
			 {if(perSonCarService.getPerSonCarMapByWhere(perSonCar).size()>0){
				 scmessage="抱歉!:你已经收藏过这辆车了,去会员中心-我的需求-我的收藏中看看吧";
			}
			else{ 
			if(perSonCarService.addPerSonCar(perSonCar)&&carInfoService.updateCarInfo(_car)){
				 scmessage="恭喜!:收藏成功,去会员中心-我的需求-我的收藏中看看吧";
				
			 }
			}
			}
			else{
				scmessage="不允许收藏自己的车";
			}
			resp.setContentType("text/html;charset=utf-8");
			 
			  resp.getWriter().println(scmessage);
				resp.getWriter().flush();//清空缓存,刷新
				resp.getWriter().close();
			}
			if(op.equals("needdg")){
				String c_uid=req.getParameter("c_uid");
				String c_id=req.getParameter("c_id");
						CarInfo carInfo=new CarInfo();
						carInfo.setC_id(Long.parseLong(c_id));
						carInfo.setU_id(Long.parseLong(c_uid));
					Map<Long, CarInfo> car=	carInfoService.getCarByWhere(carInfo);
					 CarInfo _car=car.get(carInfo.getC_id());
				           
					 String scmessage=null;
					if(userInfo.getU_id()!=carInfo.getU_id())
					 {
						scmessage="pass";
					   session.setAttribute("ydcarr", _car);
					   
					
					}
					else{
						scmessage="不允许购买自己的车";
					}
					resp.setContentType("text/html;charset=utf-8");
					 
					  resp.getWriter().print(scmessage);
						resp.getWriter().flush();//清空缓存,刷新
						resp.getWriter().close();
				
			}
			
			if(op.equals("fukuan")){
				String uid=req.getParameter("uid");
				String cid=req.getParameter("cid");
				ICarInfoService carInfoService=new CarInfoServiceImpl();
				String meeag=null;
				CarInfo carInfo1=new CarInfo();
				carInfo1.setC_id(Long.parseLong(cid));
				carInfo1.setU_id(Long.parseLong(uid));
				if(carInfoService.getCarByWhere(carInfo1).get(carInfo1.getC_id()).getC_state()=="在售"){
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setC_uid(Long.parseLong(uid));
				perSonCar.setC_id(Long.parseLong(cid));
				perSonCar.setP_state("已定");
				
				carInfo1.setC_state("已定");
				
				PerSonCar _PerSonCar=new PerSonCar();
			 _PerSonCar.setU_id(Long.parseLong(uid));
			 _PerSonCar.setC_id(Long.parseLong(cid));
			 _PerSonCar.setC_uid(Long.parseLong(uid));
			 _PerSonCar.setP_state("出售");
				if(perSonCarService.addPerSonCar(perSonCar)&&perSonCarService.updatePerSoncar(_PerSonCar, "被定")){
					if(carInfoService.updateCarInfo(carInfo1)){
						meeag="恭喜!:订车成功,去会员中心-我的需求-我的订单中看看吧";
					}
					else{
						meeag="产生错误了";
					}
				}
				}
				else{
				
					meeag="该车已经被别人抢先订单啦,再看看别的车吧!";
				}
				 resp.getWriter().print(meeag);
					resp.getWriter().flush();//清空缓存,刷新
					resp.getWriter().close();
				
			}
			if(op.equals("needxj")){
				String uid=req.getParameter("uid");
				String cid=req.getParameter("cid");
				
				perSonCar.setU_id(userInfo.getU_id());
				perSonCar.setC_uid(Long.parseLong(uid));
				perSonCar.setC_id(Long.parseLong(cid));
				perSonCar.setP_state("出售");
				String state="下架";
				CarInfo carInfo1=new CarInfo();
				carInfo1.setC_id(Long.parseLong(cid));
				carInfo1.setU_id(Long.parseLong(uid));
				carInfo1.setC_state("下架");
				String meeag=null;
				if(perSonCarService.updatePerSoncar(perSonCar, state)){
					
					if(carInfoService.updateCarInfo(carInfo1)){
						meeag="提示:下架成功,去会员中心-我的车-下架的车看看吧";					}
					else{
						meeag="产生错误了";
					}
			
					
					
				}
				 resp.getWriter().print(meeag);
					resp.getWriter().flush();//清空缓存,刷新
					resp.getWriter().close();
				
			}
			if(op.equals("needmaiche")){
				ICarTypeService carTypeService=new CarTypeServiceImpl();
		  Map<Integer, CarType> typeMap=		 carTypeService.getAllCarType();
		  req.setAttribute("cartype", typeMap);
		  req.getRequestDispatcher("admin/wymc.jsp").forward(req, resp);
			}
			if(op.equals("logincar")){
				String brand=req.getParameter("selq");
				String cx=req.getParameter("ccx");
				String cxi=req.getParameter("ccxi");
				String sptime=req.getParameter("buytime");
				String dis=req.getParameter("mialval");
				req.setAttribute("brad", brand);
				req.setAttribute("cx", cx);
				req.setAttribute("cxi", cxi);
				req.setAttribute("sptime", sptime);
				req.setAttribute("dis", dis);
				req.getRequestDispatcher("admin/logincarinfo.jsp").forward(req, resp);
				
				
			}
			if(op.equals("tjmc")){
	 ICarInfoService carInfoService=new CarInfoServiceImpl();
				//carinfo
				CarInfo carInfo=new CarInfo();
				carInfo.setU_id(userInfo.getU_id());
				carInfo.setC_sccount(0);
				carInfo.setC_state("审核中");
				carInfo.setC_count(0);
				DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			    Date date=new Date();
				carInfo.setC_sjtime(dateFormat.format(date));
				
		String brand=		req.getParameter("brad");
		carInfo.setC_brand(brand);
		String series=req.getParameter("cx");
		carInfo.setC_series(series);
		String releaseyear=req.getParameter("fxn");
		carInfo.setC_releaseyear(Integer.parseInt(releaseyear));
		String volume=req.getParameter("dis");
		carInfo.setC_volume(Double.parseDouble(volume));
		String geartype=req.getParameter("speed");
		carInfo.setC_gearType(geartype);
		String code=req.getParameter("carbh");
		carInfo.setC_code(code);
		String model=req.getParameter("carxh");
		carInfo.setC_model(model);
		String licencetime=req.getParameter("stime");
		carInfo.setC_licencetime(licencetime);
		String distance=req.getParameter("travel");
		carInfo.setC_distance(Double.parseDouble(distance));
		String emissonstandard=req.getParameter("stan");
		carInfo.setC_emissionstandard(emissonstandard);
		String price=req.getParameter("price");
		carInfo.setC_price(Double.parseDouble(price));
		String img=req.getParameter("ttp");
		carInfo.setC_img("tepimages/"+img+"");
		String type=req.getParameter("cxi");
		carInfo.setC_type(type);
		String czzx=req.getParameter("txta");
		carInfo.setC_czzx(czzx);
		if(carInfoService.addCarInfo(carInfo)){
			//basicinfo
	CarInfo _carInfo=	  carInfoService.getCarInfoByUMN(carInfo);
	IBasicInfoService basicInfoService=new BasicInfoServiceImpl();		
	BasicInfo basicInfo=new BasicInfo();
			basicInfo.setU_id(userInfo.getU_id());
			basicInfo.setC_id(_carInfo.getC_id());
			String aidd=req.getParameter("ytime");
			basicInfo.setAidd(aidd);
			String srdt=req.getParameter("ytime1");
			basicInfo.setSrdt(srdt);
			String bodycolor=req.getParameter("carcolor");
			basicInfo.setBodyColor(bodycolor);
			String interiorcolor=req.getParameter("carincolor");
			basicInfo.setInteriorColor(interiorcolor);
			String domf=req.getParameter("data");
			basicInfo.setDomf(domf);
			String orgin=req.getParameter("area");
			basicInfo.setOrgin(orgin);
			String cimd=req.getParameter("duedate");
			basicInfo.setCimd(cimd);
		  if(	basicInfoService.addBasicInfo(basicInfo)){
			  //hardware
			  IHardwareConfigService hardwareConfigService=new HardwareConfigServiceImpl();
			  HardwareConfig hardwareConfig=new HardwareConfig();
			  hardwareConfig.setU_id(userInfo.getU_id());
			  hardwareConfig.setC_id(_carInfo.getC_id());
			  String  consolelcdscreen=req.getParameter("rad1");
			  hardwareConfig.setConsoleLceScreen(consolelcdscreen);
			  String   autolight=req.getParameter("rad2");
			  hardwareConfig.setAutoLight(autolight);
			  String   headlights=req.getParameter("rad8");
			  hardwareConfig.setHeadLights(headlights);
			  String  lightwash=req.getParameter("rad-2");
			  hardwareConfig.setLightWash(lightwash);
			  String  efgv=req.getParameter("rad-3");
			  hardwareConfig.setEfgv(efgv);
			  String   seatnumber=req.getParameter("sate");
			  hardwareConfig.setSeatNumber(Integer.parseInt(seatnumber));
			  String   fuelform=req.getParameter("fuel");
			  hardwareConfig.setFuelForm(fuelform);
			  String  cvt=req.getParameter("speed");
			  hardwareConfig.setCvt(cvt);
			  String   drivingmethod=req.getParameter("method");
			  hardwareConfig.setDrivingMethod(drivingmethod);
			  String  pke=req.getParameter("rad-key");
			  hardwareConfig.setPke(pke);
			  String  keylessgo=req.getParameter("rad-5");
			  hardwareConfig.setKeyLessgo(keylessgo);
			  String  sunroof=req.getParameter("rad-6");
			  hardwareConfig.setSunRoof(sunroof);
			  String  leatherseat=req.getParameter("rad-7");
			  hardwareConfig.setLeatherSeat(leatherseat);
			if(  hardwareConfigService.addHardwareConfig(hardwareConfig)){
				SystemConfig systemConfig=new SystemConfig();
				ISystemConfigService systemConfigService=new SystemConfigServiceImpl();
				systemConfig.setU_id(userInfo.getU_id());
				systemConfig.setC_id(_carInfo.getC_id());
				String  guidancesystem=req.getParameter("rad");
				systemConfig.setGuidanceSystem(guidancesystem);
				String alb=req.getParameter("rad5");
				systemConfig.setAlb(alb);
				String fpg=req.getParameter("rad6");
				systemConfig.setFpg(fpg);
				String rpg=req.getParameter("rad7");
				systemConfig.setRpg(rpg);
				String rcpa=req.getParameter("rad9");
				systemConfig.setRcpa(rcpa);
				String dsea=req.getParameter("rad0");
				systemConfig.setDsea(dsea);
				String fsea=req.getParameter("rad-1");
				systemConfig.setFsea(fsea);
				String dlcc=req.getParameter("rad-4");
				systemConfig.setDlcc(dlcc);
				String hfs=req.getParameter("rad-8");
				systemConfig.setHfs(hfs);
				String hrs=req.getParameter("rad-9");
				systemConfig.setHrs(hrs);
				String fsv=req.getParameter("rad-qtf");
				systemConfig.setFsv(fsv);
				String rsv=req.getParameter("rad-htf");
				systemConfig.setRsv(rsv);
				String fsm=req.getParameter("rad-0");
				systemConfig.setFsm(fsm);
				String rsm=req.getParameter("rad-hjy");
				systemConfig.setRsm(rsm);
				String rvmh=req.getParameter("rad3");
				systemConfig.setRvmh(rvmh);
				String ess=req.getParameter("rad4");
			    systemConfig.setEss(ess);
			  if(  systemConfigService.addSystemConfig(systemConfig)){
				  ProcedureInfo procedureInfo=new ProcedureInfo();
				  IProcedureInfoService procedureInfoService=new ProcedureInfoServiceImpl();
				  procedureInfo.setU_id(userInfo.getU_id());
				  procedureInfo.setC_id(_carInfo.getC_id());
				  String purchasetax=req.getParameter("buy");
				  procedureInfo.setPurchaseTax(purchasetax);
				  String drivinglicense =req.getParameter("rad-a");
				  procedureInfo.setDrivingLicense(drivinglicense);
				  String ncw=req.getParameter("xczb");
				  procedureInfo.setNcw(ncw);
				  String registration =req.getParameter("rad-b");
				  procedureInfo.setRegistration(registration);
				  String newinvoice =req.getParameter("rad-c");
				  procedureInfo.setNewInvoice(newinvoice);
				  String key=req.getParameter("key");
				  procedureInfo.setKey(Integer.parseInt(key));
				  String transfertimes =req.getParameter("numm");
				  procedureInfo.setTransferTimes(Integer.parseInt(transfertimes));
				  String transgerticket =req.getParameter("ghp");
				  procedureInfo.setTransferTicket(transgerticket);
				  if(procedureInfoService.addProcedureInfo(procedureInfo)){
					  SellInfo sellInfo=new SellInfo();
					  ISellInfoService sellInfoService=new SellInfoServiceImpl();
					  sellInfo.setU_id(userInfo.getU_id());
					  sellInfo.setC_id(_carInfo.getC_id());
					  String pricetype=req.getParameter("p-type");
					  sellInfo.setPriceType(pricetype);
					  String transferfee =req.getParameter("rad-d");
					  sellInfo.setTransferFee(transferfee);
					  String stage=req.getParameter("rad-f");
					  sellInfo.setStage(stage);
					  if(sellInfoService.addSellInfo(sellInfo)){
						  CarImagesInfo carImagesInfo=new CarImagesInfo();
						  ICarImagesInfoService carImagesInfoService=new CarImagesInfoServiceImpl();
						  carImagesInfo.setU_id(userInfo.getU_id());
						  carImagesInfo.setC_id(_carInfo.getC_id());
						  String image1=req.getParameter("ftp1");
						  if(image1!=null&&!image1.equals("")){
							  carImagesInfo.setImage1("tepimages/"+image1+"");
						  }
						  String image2=req.getParameter("ftp2");
						  if(image2!=null&&!image2.equals("")){
							  carImagesInfo.setImage2("tepimages/"+image2+"");
						  }
						  String image3=req.getParameter("ftp3");
						  if(image3!=null&&!image3.equals("")){
							  carImagesInfo.setImage3("tepimages/"+image3+"");
						  }
						  String image4=req.getParameter("ftp4");
						  if(image4!=null&&!image4.equals("")){
							  carImagesInfo.setImage4("tepimages/"+image4+"");
						  }
						  String image5=req.getParameter("ftp5");
						  if(image5!=null&&!image5.equals("")){
							  carImagesInfo.setImage5("tepimages/"+image5+"");
						  }
						  String image6=req.getParameter("ftp6");
						  if(image6!=null&&!image6.equals("")){
							  carImagesInfo.setImage6("tepimages/"+image6+"");
						  }
						  String image7=req.getParameter("ftp7");
						  if(image7!=null&&!image7.equals("")){
							  carImagesInfo.setImage7("tepimages/"+image7+"");
						  }
						  String image8=req.getParameter("ftp8");
						  if(image8!=null&&!image8.equals("")){
							  carImagesInfo.setImage8("tepimages/"+image8+"");
						  }
						  String image9=req.getParameter("ftp9");
						  if(image9!=null&&!image9.equals("")){
							  carImagesInfo.setImage9("tepimages/"+image9+"");
						  }
						  String image10=req.getParameter("ftp10");
						  if(image10!=null&&!image10.equals("")){
							  carImagesInfo.setImage10("tepimages/"+image10+"");
						  }
						  if(carImagesInfoService.addCarImagesInfo(carImagesInfo)){
							  perSonCar.setP_state("审核中");
							  perSonCar.setU_id(userInfo.getU_id());
							  perSonCar.setC_uid(userInfo.getU_id());
							  perSonCar.setC_id(_carInfo.getC_id());
							  if(perSonCarService.addPerSonCar(perSonCar)){
								  req.setAttribute("xiaoxi", "提交成功,我们将会马上对您提供的信息进行审核,可进入<a href='MemberCenter.action?op=showmenberSh'>会员中心-我的需求-审核中的车进行查看</a>");
								  req.getRequestDispatcher("CarInfo.action?op=showshdea&cid="+perSonCar.getC_id()+"&uid="+perSonCar.getU_id()+"").forward(req, resp);
							  }
						  }
					  }
				  }
			  }
			}
		  }
		}
			}
			if(op.equals("uptj")){
				 ICarInfoService carInfoService=new CarInfoServiceImpl();
							//carinfo
							CarInfo carInfo=new CarInfo();
							carInfo.setC_id(Long.parseLong(req.getParameter("cid")));
							
							
							
							
					String brand=		req.getParameter("brad");
					carInfo.setC_brand(brand);
					String series=req.getParameter("cx");
					carInfo.setC_series(series);
					String releaseyear=req.getParameter("fxn");
					carInfo.setC_releaseyear(Integer.parseInt(releaseyear));
					String volume=req.getParameter("dis");
					carInfo.setC_volume(Double.parseDouble(volume));
					String geartype=req.getParameter("speed");
					carInfo.setC_gearType(geartype);
					String code=req.getParameter("carbh");
					carInfo.setC_code(code);
					String model=req.getParameter("carxh");
					carInfo.setC_model(model);
					String licencetime=req.getParameter("stime");
					carInfo.setC_licencetime(licencetime);
					String distance=req.getParameter("travel");
					carInfo.setC_distance(Double.parseDouble(distance));
					String emissonstandard=req.getParameter("stan");
					carInfo.setC_emissionstandard(emissonstandard);
					String price=req.getParameter("price");
					carInfo.setC_price(Double.parseDouble(price));
					String img=req.getParameter("ttp");
					carInfo.setC_img(img);
					String type=req.getParameter("cxi");
					carInfo.setC_type(type);
					String czzx=req.getParameter("txta");
					carInfo.setC_czzx(czzx);
					if(carInfoService.updateCarAll(carInfo)){
						//basicinfo
				
				IBasicInfoService basicInfoService=new BasicInfoServiceImpl();		
				BasicInfo basicInfo=new BasicInfo();
						basicInfo.setU_id(userInfo.getU_id());
						basicInfo.setC_id(carInfo.getC_id());
						String aidd=req.getParameter("ytime");
						basicInfo.setAidd(aidd);
						String srdt=req.getParameter("ytime1");
						basicInfo.setSrdt(srdt);
						String bodycolor=req.getParameter("carcolor");
						basicInfo.setBodyColor(bodycolor);
						String interiorcolor=req.getParameter("carincolor");
						basicInfo.setInteriorColor(interiorcolor);
						String domf=req.getParameter("data");
						basicInfo.setDomf(domf);
						String orgin=req.getParameter("area");
						basicInfo.setOrgin(orgin);
						String cimd=req.getParameter("duedate");
						basicInfo.setCimd(cimd);
					  if(	basicInfoService.updateBasicInfo(basicInfo)){
						  //hardware
						  IHardwareConfigService hardwareConfigService=new HardwareConfigServiceImpl();
						  HardwareConfig hardwareConfig=new HardwareConfig();
						  hardwareConfig.setU_id(userInfo.getU_id());
						  hardwareConfig.setC_id(carInfo.getC_id());
						  String  consolelcdscreen=req.getParameter("rad1");
						  hardwareConfig.setConsoleLceScreen(consolelcdscreen);
						  String   autolight=req.getParameter("rad2");
						  hardwareConfig.setAutoLight(autolight);
						  String   headlights=req.getParameter("rad8");
						  hardwareConfig.setHeadLights(headlights);
						  String  lightwash=req.getParameter("rad-2");
						  hardwareConfig.setLightWash(lightwash);
						  String  efgv=req.getParameter("rad-3");
						  hardwareConfig.setEfgv(efgv);
						  String   seatnumber=req.getParameter("sate");
						  hardwareConfig.setSeatNumber(Integer.parseInt(seatnumber));
						  String   fuelform=req.getParameter("fuel");
						  hardwareConfig.setFuelForm(fuelform);
						  String  cvt=req.getParameter("speed");
						  hardwareConfig.setCvt(cvt);
						  String   drivingmethod=req.getParameter("method");
						  hardwareConfig.setDrivingMethod(drivingmethod);
						  String  pke=req.getParameter("rad-key");
						  hardwareConfig.setPke(pke);
						  String  keylessgo=req.getParameter("rad-5");
						  hardwareConfig.setKeyLessgo(keylessgo);
						  String  sunroof=req.getParameter("rad-6");
						  hardwareConfig.setSunRoof(sunroof);
						  String  leatherseat=req.getParameter("rad-7");
						  hardwareConfig.setLeatherSeat(leatherseat);
						if(  hardwareConfigService.updateHardwareConfig(hardwareConfig)){
							SystemConfig systemConfig=new SystemConfig();
							ISystemConfigService systemConfigService=new SystemConfigServiceImpl();
							systemConfig.setU_id(userInfo.getU_id());
							systemConfig.setC_id(carInfo.getC_id());
							String  guidancesystem=req.getParameter("rad");
							systemConfig.setGuidanceSystem(guidancesystem);
							String alb=req.getParameter("rad5");
							systemConfig.setAlb(alb);
							String fpg=req.getParameter("rad6");
							systemConfig.setFpg(fpg);
							String rpg=req.getParameter("rad7");
							systemConfig.setRpg(rpg);
							String rcpa=req.getParameter("rad9");
							systemConfig.setRcpa(rcpa);
							String dsea=req.getParameter("rad0");
							systemConfig.setDsea(dsea);
							String fsea=req.getParameter("rad-1");
							systemConfig.setFsea(fsea);
							String dlcc=req.getParameter("rad-4");
							systemConfig.setDlcc(dlcc);
							String hfs=req.getParameter("rad-8");
							systemConfig.setHfs(hfs);
							String hrs=req.getParameter("rad-9");
							systemConfig.setHrs(hrs);
							String fsv=req.getParameter("rad-qtf");
							systemConfig.setFsv(fsv);
							String rsv=req.getParameter("rad-htf");
							systemConfig.setRsv(rsv);
							String fsm=req.getParameter("rad-0");
							systemConfig.setFsm(fsm);
							String rsm=req.getParameter("rad-hjy");
							systemConfig.setRsm(rsm);
							String rvmh=req.getParameter("rad3");
							systemConfig.setRvmh(rvmh);
							String ess=req.getParameter("rad4");
						    systemConfig.setEss(ess);
						  if(  systemConfigService.updateSystemConfig(systemConfig)){
							  ProcedureInfo procedureInfo=new ProcedureInfo();
							  IProcedureInfoService procedureInfoService=new ProcedureInfoServiceImpl();
							  procedureInfo.setU_id(userInfo.getU_id());
							  procedureInfo.setC_id(carInfo.getC_id());
							  String purchasetax=req.getParameter("buy");
							  procedureInfo.setPurchaseTax(purchasetax);
							  String drivinglicense =req.getParameter("rad-a");
							  procedureInfo.setDrivingLicense(drivinglicense);
							  String ncw=req.getParameter("xczb");
							  procedureInfo.setNcw(ncw);
							  String registration =req.getParameter("rad-b");
							  procedureInfo.setRegistration(registration);
							  String newinvoice =req.getParameter("rad-c");
							  procedureInfo.setNewInvoice(newinvoice);
							  String key=req.getParameter("key");
							  procedureInfo.setKey(Integer.parseInt(key));
							  String transfertimes =req.getParameter("numm");
							  procedureInfo.setTransferTimes(Integer.parseInt(transfertimes));
							  String transgerticket =req.getParameter("ghp");
							  procedureInfo.setTransferTicket(transgerticket);
							  if(procedureInfoService.updateProcedureInfo(procedureInfo)){
								  SellInfo sellInfo=new SellInfo();
								  ISellInfoService sellInfoService=new SellInfoServiceImpl();
								  sellInfo.setU_id(userInfo.getU_id());
								  sellInfo.setC_id(carInfo.getC_id());
								  String pricetype=req.getParameter("p-type");
								  sellInfo.setPriceType(pricetype);
								  String transferfee =req.getParameter("rad-d");
								  sellInfo.setTransferFee(transferfee);
								  String stage=req.getParameter("rad-f");
								  sellInfo.setStage(stage);
								  if(sellInfoService.updateSellInfo(sellInfo)){
									  CarImagesInfo carImagesInfo=new CarImagesInfo();
									  ICarImagesInfoService carImagesInfoService=new CarImagesInfoServiceImpl();
									  carImagesInfo.setU_id(userInfo.getU_id());
									  carImagesInfo.setC_id(carInfo.getC_id());
									  String image1=req.getParameter("ftp1");
									  if(image1!=null&&!image1.equals("")){
										  carImagesInfo.setImage1(image1);
									  }
									  String image2=req.getParameter("ftp2");
									  if(image2!=null&&!image2.equals("")){
										  carImagesInfo.setImage2(image2);
									  }
									  String image3=req.getParameter("ftp3");
									  if(image3!=null&&!image3.equals("")){
										  carImagesInfo.setImage3(image3);
									  }
									  String image4=req.getParameter("ftp4");
									  if(image4!=null&&!image4.equals("")){
										  carImagesInfo.setImage4(image4);
									  }
									  String image5=req.getParameter("ftp5");
									  if(image5!=null&&!image5.equals("")){
										  carImagesInfo.setImage5(image5);
									  }
									  String image6=req.getParameter("ftp6");
									  if(image6!=null&&!image6.equals("")){
										  carImagesInfo.setImage6(image6);
									  }
									  String image7=req.getParameter("ftp7");
									  if(image7!=null&&!image7.equals("")){
										  carImagesInfo.setImage7(image7);
									  }
									  String image8=req.getParameter("ftp8");
									  if(image8!=null&&!image8.equals("")){
										  carImagesInfo.setImage8(image8);
									  }
									  String image9=req.getParameter("ftp9");
									  if(image9!=null&&!image9.equals("")){
										  carImagesInfo.setImage9(image9);
									  }
									  String image10=req.getParameter("ftp10");
									  if(image10!=null&&!image10.equals("")){
										  carImagesInfo.setImage10(image10);
									  }
									  if(carImagesInfoService.updateCarImagesInfo(carImagesInfo)){
										  req.setAttribute("xiaoxi", "修改成功,请进入<a href='MemberCenter.action?op=showmenberbjj'>会员中心-我的车-审核未通过的车再次提交吧</a>");
											req.getRequestDispatcher("CarInfo.action?op=showshdea&cid="+carInfo.getC_id()+"&uid="+userInfo.getU_id()+"").forward(req, resp);
										  
									  }
								  }
							  }
						  }
						}
					  }
					}
						}
			if(op.equals("showdea")){
		String cid=		req.getParameter("cid");
		String uid=		req.getParameter("uid");
				req.getRequestDispatcher("CarInfo.action?op=showshdea&cid="+cid+"&uid="+uid+"").forward(req, resp);
			}
			if(op.equals("upmc")){
				CarInfo carInfo=new CarInfo();
				carInfo.setU_id(userInfo.getU_id());
				carInfo.setC_id(Long.parseLong(req.getParameter("cid")));
				ICarInfoService carInfoService=new CarInfoServiceImpl();
		CarInfo _carInfo=carInfoService.getCarByWhere(carInfo).get(carInfo.getC_id());
		 req.setAttribute("car", _carInfo);
		 IBasicInfoService basicInfoService=new BasicInfoServiceImpl();
		BasicInfo basicInfo= basicInfoService.getAllBasicById(carInfo);
		req.setAttribute("bas", basicInfo); 
		IHardwareConfigService hardwareConfigService=new HardwareConfigServiceImpl();
		 HardwareConfig hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
		 req.setAttribute("hard", hardwareConfig); 
		 SystemConfigServiceImpl systemConfigServiceImpl=new SystemConfigServiceImpl();
		 
		 SystemConfig systemConfig= systemConfigServiceImpl.getSystemConfigById(carInfo);
		 req.setAttribute("sys", systemConfig);
		 SellInfoServiceImpl sellInfoServiceImpl=new SellInfoServiceImpl();
		 SellInfo sellInfo= sellInfoServiceImpl.getSellInfoById(carInfo);
		 req.setAttribute("sell", sellInfo); 
		 ProcedureInfoServiceImpl procedureInfoServiceImpl=new ProcedureInfoServiceImpl();
		 ProcedureInfo procedureInfo=  procedureInfoServiceImpl.getProcedureInfoById(carInfo);
		 req.setAttribute("proce", procedureInfo); 
		 CarImagesInfoServiceImpl carImagesInfoServiceImpl=new CarImagesInfoServiceImpl();
		Map<Integer, String> imgMap= carImagesInfoServiceImpl.getCarImagesInfoByID(carInfo); 
		for(Integer key:imgMap.keySet()){
			req.setAttribute("k"+key.toString(), imgMap.get(key));
		}
		
		req.getRequestDispatcher("admin/upcarinfo.jsp").forward(req, resp);
			}
			if(op.equals("comment")){
				PersonNeed personNeed=new PersonNeed();
				personNeed.setU_id(userInfo.getU_id());
				String p_brand=new String(req.getParameter("sel1").getBytes("ISO8859-1"),"UTF-8");
				String p_series=new String(req.getParameter("ccx").getBytes("ISO8859-1"),"UTF-8");
				String p_age=new String(req.getParameter("ccxi").getBytes("ISO8859-1"),"UTF-8");
				String p_price=new String(req.getParameter("cprice").getBytes("ISO8859-1"),"UTF-8");
				String p_time=new String(req.getParameter("buytime").getBytes("ISO8859-1"),"UTF-8");
				String p_miaoshu=new String(req.getParameter("content").getBytes("ISO8859-1"),"UTF-8");
				personNeed.setP_age(p_age);
				personNeed.setP_brand(p_brand);
		        personNeed.setP_miaoshu(p_miaoshu);
		        personNeed.setP_price(p_price);
		        personNeed.setP_time(p_time);
		        personNeed.setP_series(p_series);
		        personNeed.setP_state("处理中");
		        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			    Date date=new Date();
			    personNeed.setP_tjtime(dateFormat.format(date));
			  String message=null;
			  PersonNeedServiceImpl personNeedServiceImpl=new PersonNeedServiceImpl();
			  if(personNeedServiceImpl.getPerSonNeed(personNeed)==null){
			  if(personNeedServiceImpl.addPersonNeed(personNeed)){
				  message="恭喜：提交成功,进入会员中心—我的需求-私人定制看看吧";
			  }
			  else{
				  message="抱歉：发生了一个错误";
			  }
			}
			  else{
				  message="请不要重复提交";
			  }
			  resp.getWriter().print(message);
				resp.getWriter().flush();//清空缓存,刷新
				resp.getWriter().close();
			}
			if(op.equals("showsrdz")){
				PersonNeed personNeed=new PersonNeed();
				personNeed.setU_id(userInfo.getU_id());
				this.fenyepn(req, resp, personNeed);
				DbUtil.closeAll();
				req.getRequestDispatcher("admin/memberMySr.jsp").forward(req, resp);
				
			}
				
		}
		else{
			resp.sendRedirect("admin/menber.jsp");
		}
	}
	private void fenye(HttpServletRequest req, HttpServletResponse resp,PerSonCar perSonCar){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 int maxRowsCount=perSonCarService.queryPersonCarCount(perSonCar);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(4, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> carMap=perSonCarService.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), perSonCar);
		DbUtil.closeAll();
		Map<Long, CarInfo> _carMap=new HashMap<Long, CarInfo>();
		for(Long key:carMap.keySet()){
		CarInfo _carInfo=(CarInfo) carMap.get(key);
		_carMap.put(_carInfo.getC_id() ,_carInfo);
		}
		req.setAttribute("szCar", _carMap);
		req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
		req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
		req.setAttribute("maxPage", pageUtil.getMaxPage());
		req.setAttribute("jumpPage", curPage);
		req.setAttribute("curPage", pageUtil.getCurPage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	 }
private void fenyepn(HttpServletRequest req, HttpServletResponse resp,PersonNeed personNeed){
		PersonNeedServiceImpl personNeedServiceImpl=new PersonNeedServiceImpl();
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 int maxRowsCount=personNeedServiceImpl.queryPersonCarCount(personNeed);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(4, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> carMap=personNeedServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), personNeed);
		DbUtil.closeAll();
		Map<Long, PersonNeed> _carMap=new HashMap<Long, PersonNeed>();
		for(Long key:carMap.keySet()){
		PersonNeed _PersonNeed=(PersonNeed) carMap.get(key);
		_carMap.put( _PersonNeed.getP_id(),_PersonNeed);
		}
		req.setAttribute("szCar", _carMap);
		req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
		req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
		req.setAttribute("maxPage", pageUtil.getMaxPage());
		req.setAttribute("jumpPage", curPage);
		req.setAttribute("curPage", pageUtil.getCurPage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	 }
	private void finishop(HttpServletRequest req,PerSonCar perSonCar,UserInfo userInfo,CarInfo carInfo){
		String uid=req.getParameter("uid");
		String cid=req.getParameter("cid");
		
		perSonCar.setU_id(userInfo.getU_id());
		perSonCar.setC_uid(Long.parseLong(uid));
		perSonCar.setC_id(Long.parseLong(cid));
		if(carInfo!=null){
		carInfo.setC_id(Long.parseLong(cid));
		carInfo.setU_id(Long.parseLong(uid));
		}
	}

}
