package cn.com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bean.BasicInfo;
import cn.com.bean.CarImagesInfo;
import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;
import cn.com.bean.PerSonCar;
import cn.com.bean.ProcedureInfo;
import cn.com.bean.SellInfo;
import cn.com.bean.SystemConfig;
import cn.com.service.impl.BasicInfoServiceImpl;
import cn.com.service.impl.CarBrandServiceImpl;
import cn.com.service.impl.CarImagesInfoServiceImpl;
import cn.com.service.impl.CarInfoServiceImpl;
import cn.com.service.impl.HardwareConfigServiceImpl;
import cn.com.service.impl.PersonCarServiceImpl;
import cn.com.service.impl.ProcedureInfoServiceImpl;
import cn.com.service.impl.SellInfoServiceImpl;
import cn.com.service.impl.SystemConfigServiceImpl;
import cn.com.util.CarAgeUtil;
import cn.com.util.DbUtil;
import cn.com.util.DistanceUtil;
import cn.com.util.PageUtil;
import cn.com.util.PriceUtil;

public class MgCarInfoServlet extends HttpServlet{
  CarInfoServiceImpl carInfoService=new CarInfoServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String op=req.getParameter("op");
		if(op.equals("showlist")){
			CarInfo carInfo=new CarInfo();
			fenye(req, resp, carInfo);
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
		req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			req.getRequestDispatcher("admin/allproduct.jsp").forward(req, resp);
		}
		if(op.equals("showzs")){
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("在售");
			fenye(req, resp, carInfo);
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			req.getRequestDispatcher("admin/zaishouproduct.jsp").forward(req, resp);
		
		}
		if(op.equals("showsh")){
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("审核中");
			fenye(req, resp, carInfo);
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			req.getRequestDispatcher("admin/shproduct.jsp").forward(req, resp);
		
		}
		if(op.equals("showxj")){
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("下架");
			fenye(req, resp, carInfo);
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			req.getRequestDispatcher("admin/xjproduct.jsp").forward(req, resp);
		
		}
		if(op.equals("showwtg")){
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("未通过");
			fenye(req, resp, carInfo);
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			req.getRequestDispatcher("admin/wtgproduct.jsp").forward(req, resp);
		
		}
		if(op.equals("showwhere")){
			String pp=req.getParameter("cpp");
			String cx=req.getParameter("ccx");
		
			CarInfo carInfo=new CarInfo();
			if(cx!=null&&!cx.equals("")){
				carInfo.setC_series(cx);
			}
			if(pp!=null&&!pp.equals("")){
				carInfo.setC_brand(pp);
			}
			
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			fenye(req, resp, carInfo);
			req.setAttribute("pp", pp);
			req.setAttribute("cx", cx);
			req.getRequestDispatcher("admin/allproduct.jsp").forward(req, resp);

		}
		if(op.equals("showzswhere")){
			String pp=req.getParameter("cpp");
			String cx=req.getParameter("ccx");
		
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("在售");
			if(cx!=null&&!cx.equals("")){
				carInfo.setC_series(cx);
			}
			if(pp!=null&&!pp.equals("")){
				carInfo.setC_brand(pp);
			}
			
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			fenye(req, resp, carInfo);
			req.setAttribute("pp", pp);
			req.setAttribute("cx", cx);
			req.getRequestDispatcher("admin/zaishouproduct.jsp").forward(req, resp);

		}
		if(op.equals("showshwhere")){
			String pp=req.getParameter("cpp");
			String cx=req.getParameter("ccx");
		
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("审核中");
			if(cx!=null&&!cx.equals("")){
				carInfo.setC_series(cx);
			}
			if(pp!=null&&!pp.equals("")){
				carInfo.setC_brand(pp);
			}
			
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			fenye(req, resp, carInfo);
			req.setAttribute("pp", pp);
			req.setAttribute("cx", cx);
			req.getRequestDispatcher("admin/shproduct.jsp").forward(req, resp);

		}
		if(op.equals("showxjwhere")){
			String pp=req.getParameter("cpp");
			String cx=req.getParameter("ccx");
		
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("下架");
			if(cx!=null&&!cx.equals("")){
				carInfo.setC_series(cx);
			}
			if(pp!=null&&!pp.equals("")){
				carInfo.setC_brand(pp);
			}
			
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			fenye(req, resp, carInfo);
			req.setAttribute("pp", pp);
			req.setAttribute("cx", cx);
			req.getRequestDispatcher("admin/xjproduct.jsp").forward(req, resp);

		}
		if(op.equals("showwtgwhere")){
			String pp=req.getParameter("cpp");
			String cx=req.getParameter("ccx");
		
			CarInfo carInfo=new CarInfo();
			carInfo.setC_state("未通过");
			if(cx!=null&&!cx.equals("")){
				carInfo.setC_series(cx);
			}
			if(pp!=null&&!pp.equals("")){
				carInfo.setC_brand(pp);
			}
			
			CarBrandServiceImpl  brandServiceImpl=new CarBrandServiceImpl();
			req.setAttribute("allbrand", brandServiceImpl.getAllBrand());
			fenye(req, resp, carInfo);
			req.setAttribute("pp", pp);
			req.setAttribute("cx", cx);
			req.getRequestDispatcher("admin/wtgproduct.jsp").forward(req, resp);

		}
		if(op.equals("jjtg")){
			String cid=req.getParameter("cid");
			String uid=req.getParameter("uid");
			
			
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_uid(Long.parseLong(uid));
			perSonCar.setP_state("审核中");
			PersonCarServiceImpl personCarServiceImpl=new PersonCarServiceImpl();
			
			CarInfo carInfo=new CarInfo();
			carInfo.setC_id(Long.parseLong(cid));
			carInfo.setC_state("未通过");
			CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
			if(personCarServiceImpl.updatePerSoncar(perSonCar, "未通过")&&carInfoServiceImpl.updateCarInfo(carInfo)){
				resp.getWriter().print(1);
			}
			
		}
		if(op.equals("yxtg")){
			String cid=req.getParameter("cid");
			String uid=req.getParameter("uid");
			
			
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_uid(Long.parseLong(uid));
			perSonCar.setP_state("审核中");
			PersonCarServiceImpl personCarServiceImpl=new PersonCarServiceImpl();
		
			String newprice=req.getParameter("newprice");
		
			CarInfo carInfo=new CarInfo();
			carInfo.setC_id(Long.parseLong(cid));
			carInfo.setC_state("在售");
			carInfo.setNewprice(Double.parseDouble(newprice));
			CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
			if(personCarServiceImpl.updatePerSoncar(perSonCar, "出售")&&carInfoServiceImpl.updateCarInfo(carInfo)){
				resp.getWriter().print(1);
			}
		}
		if(op.equals("dellcar")){
			String cid=req.getParameter("cid");
			HardwareConfigServiceImpl hardwareConfigServiceImpl=new HardwareConfigServiceImpl();
			
			HardwareConfig hardwareConfig=new HardwareConfig();
			hardwareConfig.setC_id(Long.parseLong(cid));
			if(hardwareConfigServiceImpl.deletecidhardwareconfiguser(hardwareConfig)){
				ProcedureInfo procedureInfo=new ProcedureInfo();
				procedureInfo.setC_id(Long.parseLong(cid));
				ProcedureInfoServiceImpl procedureInfoServiceImpl=new ProcedureInfoServiceImpl();
				if(procedureInfoServiceImpl.deletecidprocedureinfouser(procedureInfo)){
					SystemConfig systemConfig=new SystemConfig();
					systemConfig.setC_id(Long.parseLong(cid));
					SystemConfigServiceImpl systemConfigServiceImpl=new SystemConfigServiceImpl();
					if(systemConfigServiceImpl.deletecidsystemconfiguser(systemConfig)){
						SellInfo sellInfo=new SellInfo();
						sellInfo.setC_id(Long.parseLong(cid));
						SellInfoServiceImpl sellInfoServiceImpl=new SellInfoServiceImpl();
						if(sellInfoServiceImpl.deletecidsellinfouser(sellInfo)){
							CarImagesInfo carImagesInfo=new CarImagesInfo();
							carImagesInfo.setC_id(Long.parseLong(cid));
							CarImagesInfoServiceImpl carImagesInfoServiceImpl=new CarImagesInfoServiceImpl();
							if(carImagesInfoServiceImpl.deletecidimagesinfouser(carImagesInfo)){
								BasicInfo basicInfo=new BasicInfo();
								basicInfo.setC_id(Long.parseLong(cid));
								BasicInfoServiceImpl basicInfoServiceImpl=new BasicInfoServiceImpl();
								if(basicInfoServiceImpl.deletecidbasicinfo(basicInfo)){
									CarInfo carInfo=new CarInfo();
									carInfo.setC_id(Long.parseLong(cid));
									CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
									if(carInfoServiceImpl.deletecarinfo(carInfo)){
										PerSonCar perSonCar=new PerSonCar();
										perSonCar.setC_id(Long.parseLong(cid));
										PersonCarServiceImpl carServiceImpl=new PersonCarServiceImpl();
										if(carServiceImpl.deletecidpersoncaruser(perSonCar)){
											resp.getWriter().print(1);
										}
									}
								}
							}
						}
					}
				}
			}
			
			
			
			
			
		}
	}
	private void fenye(HttpServletRequest req, HttpServletResponse resp,CarInfo carInfo){
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		//设置距离参数
		String distance=null;
		if(req.getParameter("distance")!=null){
			distance = new String(req.getParameter("distance").getBytes("ISO8859-1"),"utf-8");
			}
	   Map<String, Integer> distanceMap=setDistance(distance);
		//设置价格参数
	   String price = null;
		if(req.getParameter("price")!=null){
			price = new String(req.getParameter("price").getBytes("ISO8859-1"),"utf-8");
		}
      Map<String, Integer> priceMap=setPrice(price);
      //设置车龄参数
      String age = null;
		if(req.getParameter("age")!=null){
			age = new String(req.getParameter("age").getBytes("ISO8859-1"),"utf-8");
		}
		
    Map<String, Integer> ageMap=setAge(age);
    if(req.getParameter("bname")!=null&&!req.getParameter("bname").equals("")){
    	carInfo.setC_brand(new String(req.getParameter("bname").getBytes("ISO8859-1"),"utf-8"));
    }	
	 if(req.getParameter("cser")!=null&&!req.getParameter("cser").equals("")){
		 carInfo.setC_series(new String(req.getParameter("cser").getBytes("ISO8859-1"),"utf-8"));
	 }	
	 if(req.getParameter("tname")!=null&&!req.getParameter("tname").equals("")){
		 carInfo.setC_type(new String(req.getParameter("tname").getBytes("ISO8859-1"),"utf-8"));
	 }
	 if(req.getParameter("emsi")!=null&&!req.getParameter("emsi").equals("")){
		 carInfo.setC_emissionstandard(new String(req.getParameter("emsi").getBytes("ISO8859-1"),"utf-8"));
	 }
	 int maxRowsCount=carInfoService.queryMsgCount(carInfo,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(7, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		String order=null;
		String _order=req.getParameter("order");
		if(_order!=null&&!_order.equals("")){
			order=_order;
		}
		
		List<Object> carMap=carInfoService.showMsgInfoList(pageUtil.getCurPage(), pageUtil.getRowsPrePage(), carInfo,order,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
		DbUtil.closeAll();
		List<Object> _carMap=new ArrayList<Object>();
		for(Object o:carMap){
		CarInfo _carInfo=(CarInfo) o;
		_carMap.add( _carInfo);
		}
		req.setAttribute("bname", carInfo.getC_brand());
		req.setAttribute("tname", carInfo.getC_type());
		req.setAttribute("cser", carInfo.getC_series());
		req.setAttribute("order", order);
		req.setAttribute("age", age);
		req.setAttribute("price", price);
		req.setAttribute("distance", distance);
		req.setAttribute("emsi", carInfo.getC_emissionstandard());
		req.setAttribute("carMap", _carMap);
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
	 private Map<String, Integer> setDistance(String distance){
		   Map<String, Integer> distanceMap=new HashMap<String, Integer>();
	    DistanceUtil distanceUtil=null;
	    int minDis=0;
	    int maxDis=0;
		if(distance!=null&&!distance.equals("")){
			 distanceUtil=new DistanceUtil(distance);
			 minDis=distanceUtil.getMinDis();
			 maxDis=distanceUtil.getMaxDis();
		}
		  distanceMap.put("minDis", Integer.valueOf(minDis));
		  distanceMap.put("maxDis", Integer.valueOf(maxDis));
  	   return distanceMap;
     }
     /**
      * 设置价格参数的方法
      * @param price
      * @return
      */
     private Map<String, Integer> setPrice(String price){
		   Map<String, Integer> priceMap=new HashMap<String, Integer>();
  	   PriceUtil priceUtil=null;
  	    int minPrice=0;
  	    int maxPrice=0;
  		
  		if(price!=null&&!price.equals("")){
  			priceUtil=new PriceUtil(price);
  			minPrice=priceUtil.getMinPrice();
  			maxPrice=priceUtil.getMaxPrice();
  		}
  		priceMap.put("minPrice", Integer.valueOf(minPrice));
  		priceMap.put("maxPrice", Integer.valueOf(maxPrice));
  		return priceMap;
     }
     /**
      * 设置车龄参数的方法
      * @param age
      * @return
      */
     private Map<String, Integer> setAge(String age){
  	   Map<String, Integer> ageMap=new HashMap<String, Integer>();
  	   CarAgeUtil ageUtil=null;
  	    int minAge=0;
  	    int maxAge=0;
  		
  		if(age!=null&&!age.equals("")){
  			ageUtil=new CarAgeUtil(age);
  			minAge=ageUtil.getMinAge();
  			maxAge=ageUtil.getMaxAge();
  		}
  		ageMap.put("minAge", Integer.valueOf(minAge));
  		ageMap.put("maxAge", Integer.valueOf(maxAge));
  		return ageMap;
     }
}
