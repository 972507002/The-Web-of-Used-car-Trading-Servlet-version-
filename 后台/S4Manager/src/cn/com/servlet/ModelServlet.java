package cn.com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import cn.com.bean.CarAge;
import cn.com.bean.CarBrand;
import cn.com.bean.CarType;
import cn.com.bean.Distance;
import cn.com.bean.Emissionstandard;
import cn.com.bean.Model;
import cn.com.bean.PriceInterval;
import cn.com.service.ICarBrandService;
import cn.com.service.IModelService;
import cn.com.service.impl.CarAgeServiceImpl;
import cn.com.service.impl.CarBrandServiceImpl;
import cn.com.service.impl.CarTypeServiceImpl;
import cn.com.service.impl.DistanceServiceImpl;
import cn.com.service.impl.EmissionstandardServiceImpl;
import cn.com.service.impl.ModelServiceImpl;
import cn.com.service.impl.PriceIntervalServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

public class ModelServlet extends HttpServlet{
     
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		IModelService modelService=new ModelServiceImpl();
		String op=req.getParameter("op");
		HttpSession httpSession=req.getSession();
		if(op.equals("bindModel")){
			
		int b_id=Integer.parseInt(req.getParameter("brand"));
		Model model=new Model();
		model.setB_id(b_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	  resp.setContentType("text/html;charset=utf-8");
	  resp.getWriter().println(jsonArray);
		resp.getWriter().flush();//清空缓存,刷新
		resp.getWriter().close();
		}
		if(op.equals("getDea")){
			int s_id=Integer.parseInt(req.getParameter("s_id"));
			Model model=new Model();
			model.setM_id(s_id);
			List<Model> modelMap=modelService.getModelByWhere(model);
		  DbUtil.closeAll();
		  
		 
		   JSONArray jsonArray= JSONArray.fromObject(modelMap);
		  resp.setContentType("text/html;charset=utf-8");
		  resp.getWriter().println(jsonArray);
			resp.getWriter().flush();//清空缓存,刷新
			resp.getWriter().close();
		}
		if(op.equals("showbrand")){
	        CarBrand carBrand=new CarBrand();
	        this.fenye(req, resp, carBrand);
	        req.getRequestDispatcher("admin/brand.jsp").forward(req, resp);
		}
		if(op.equals("showage")){
			CarAge carAge=new CarAge();
			this.fenyeage(req, resp, carAge);
			 req.getRequestDispatcher("admin/age.jsp").forward(req, resp);
	         
	       
		}
		if(op.equals("showtype")){
			CarType carType=new CarType();
			this.fenyeety(req, resp, carType);
			req.getRequestDispatcher("admin/type.jsp").forward(req, resp);
		}
		
		if(op.equals("showdistance")){
			Distance distance=new Distance();
			this.fenyedis(req, resp, distance);
	        req.getRequestDispatcher("admin/distance.jsp").forward(req, resp);
		}
		if(op.equals("showemsi")){
			 Emissionstandard emissionstandard=new Emissionstandard();
			 this.fenyeemsi(req, resp, emissionstandard);
	        req.getRequestDispatcher("admin/emsi.jsp").forward(req, resp);
		}
		if(op.equals("showprice")){
			PriceInterval priceInterval=new PriceInterval();
			this.fenyeprice(req, resp, priceInterval);
	        req.getRequestDispatcher("admin/price.jsp").forward(req, resp);
		}
		if(op.equals("showseries")){
			ICarBrandService brandService=new CarBrandServiceImpl();
		Map<Integer, CarBrand> brandMap=	brandService.getAllBrand();
		req.setAttribute("allbrand", brandMap);
		req.getRequestDispatcher("admin/series.jsp").forward(req, resp);
		}
		if(op.equals("addseries")){
			ICarBrandService brandService=new CarBrandServiceImpl();
		Map<Integer, CarBrand> brandMap=	brandService.getAllBrand();
		req.setAttribute("allbrand", brandMap);
		req.getRequestDispatcher("admin/series-add.jsp").forward(req, resp);
		}
		if(op.equals("addbrand")){
			ICarBrandService brandService=new CarBrandServiceImpl();
            String bname=req.getParameter("maxAge");
            String bcount=req.getParameter("count");
            String bimg=req.getParameter("ttp");
            String zm=req.getParameter("zm");
            CarBrand carBrand=new CarBrand();
               carBrand.setB_name(bname);
               carBrand.setB_count(0);
               carBrand.setB_img("");
               carBrand.setB_szm(zm.toUpperCase());
            if(bimg!=null&&!bimg.equals("")){
              carBrand.setB_img("tepimages/"+bimg);
            }
            if(bcount!=null&&!bcount.equals("")){
                carBrand.setB_count(Long.parseLong(bcount));
              }
            if(brandService.addCarBrand(carBrand)){
            	
            	req.setAttribute("meag", "添加成功");
            		req.getRequestDispatcher("admin/brand-add.jsp").forward(req, resp);
            }
		}
		if(op.equals("upbrand")){
			String bid=req.getParameter("bid");
			CarBrand brand=new CarBrand();
			brand.setB_id(Integer.parseInt(bid));
		
			CarBrandServiceImpl brandServiceImpl=new CarBrandServiceImpl();
	 CarBrand carBrand=		brandServiceImpl.getBrandByID(brand);
			
			httpSession.setAttribute("brand", carBrand);
      resp.sendRedirect("admin/brand-up.jsp");
		}
		if(op.equals("tjupbr")){
			ICarBrandService brandService=new CarBrandServiceImpl();
			String bid=req.getParameter("bid");
            String bname=req.getParameter("maxAge");
            String bcount=req.getParameter("count");
            String bimg=req.getParameter("ttp");
            String zm=req.getParameter("zm");
            CarBrand carBrand=new CarBrand();
               carBrand.setB_name(bname);
               carBrand.setB_count(0);
               carBrand.setB_img(req.getParameter("qtp"));
               carBrand.setB_szm(zm.toUpperCase());
               carBrand.setB_id(Integer.parseInt(bid));
            if(bimg!=null&&!bimg.equals("")){
        
            	
              carBrand.setB_img("tepimages/"+bimg);
            }
            if(bcount!=null&&!bcount.equals("")){
                carBrand.setB_count(Long.parseLong(bcount));
              }
            if(brandService.updateCarBrand(carBrand)){
            	
            	httpSession.setAttribute("upbrand", "修改成功");
            	httpSession.setAttribute("brand", carBrand);
            	 resp.sendRedirect("admin/brand-up.jsp");
            }
		}
		if(op.equals("delbrand")){
			ICarBrandService brandService=new CarBrandServiceImpl();
			String bid=req.getParameter("bid");
			 CarBrand carBrand=new CarBrand();
			 carBrand.setB_id(Integer.parseInt(bid));
			 if(brandService.deleteCarBrand(carBrand)){
				 resp.getWriter().print(1);
			 }
		}
		if(op.equals("addser")){
			String bid=req.getParameter("cpp");
			String sname=req.getParameter("name");
			Model model=new Model();
			model.setB_id(Integer.parseInt(bid));
			model.setM_name(sname);
			
			if(modelService.addModel(model)){
				req.setAttribute("mea", "添加成功");
				req.getRequestDispatcher("admin/series-add.jsp").forward(req, resp);
			}
		}
		if(op.equals("upser")){
			String mid=req.getParameter("mid");
			Model model=new Model();
			model.setM_id(Integer.parseInt(mid));
		List<Model>  m=	modelService.getModelByWhere(model);
		req.setAttribute("model", m.get(0));
		ICarBrandService brandService=new CarBrandServiceImpl();
		Map<Integer, CarBrand> brandMap=	brandService.getAllBrand();
		req.setAttribute("allbrand", brandMap);
		req.getRequestDispatcher("admin/series-up.jsp").forward(req, resp);
			
		}
		if(op.equals("tjupser")){
			String mid=req.getParameter("mid");
			String bid=req.getParameter("cpp");
			String sname=req.getParameter("name");
			Model model=new Model();
			model.setB_id(Integer.parseInt(bid));
			model.setM_name(sname);
			model.setM_id(Integer.parseInt(mid.trim()));
			if(modelService.updateModel(model)){
				ICarBrandService brandService=new CarBrandServiceImpl();
				Map<Integer, CarBrand> brandMap=	brandService.getAllBrand();
				req.setAttribute("allbrand", brandMap);
				req.setAttribute("model", model);
				req.setAttribute("mea", "修改成功");
				req.getRequestDispatcher("admin/series-up.jsp").forward(req, resp);
			}
		}
		if(op.equals("delser")){
			String mid=req.getParameter("mid");
			Model model=new Model();
			model.setM_id(Integer.parseInt(mid.trim()));
			if(modelService.deleteModel(model)){
				 resp.getWriter().print(1);
			}
		}
		if(op.equals("addage")){
			String aname=req.getParameter("cAge");
			String acount=req.getParameter("count");
			CarAge carAge=new CarAge();
			carAge.setA_name(aname);
			carAge.setA_count(0);
			 if(acount!=null&&!acount.equals("")){
				 carAge.setA_count(Long.parseLong(acount));
	              }
			 CarAgeServiceImpl ageServiceImpl=new CarAgeServiceImpl();
			 if(ageServiceImpl.addCarAge(carAge)){
				 req.setAttribute("mea", "添加成功");
					req.getRequestDispatcher("admin/age-add.jsp").forward(req, resp);
			 }
		}
		if(op.equals("upage")){
			String a_id=req.getParameter("aid");
			CarAge carAge=new CarAge();
			carAge.setA_id(Integer.parseInt(a_id));
			CarAgeServiceImpl ageServiceImpl=new CarAgeServiceImpl();
		CarAge age=	ageServiceImpl.getCarAgeById(carAge);
		req.setAttribute("age", age);
		req.getRequestDispatcher("admin/age-up.jsp").forward(req, resp);
		}
		if(op.equals("tjupage")){
			String aname=req.getParameter("cAge");
			String acount=req.getParameter("count");
			String a_id=req.getParameter("aid");
			CarAge carAge=new CarAge();
			carAge.setA_id(Integer.parseInt(a_id));
			carAge.setA_name(aname);
			carAge.setA_count(0);
			 if(acount!=null&&!acount.equals("")){
				 carAge.setA_count(Long.parseLong(acount));
	              }
				CarAgeServiceImpl ageServiceImpl=new CarAgeServiceImpl();

				if(ageServiceImpl.updateCarAge(carAge)){
					req.setAttribute("age", carAge);
					req.setAttribute("mea", "修改成功");
					req.getRequestDispatcher("admin/age-up.jsp").forward(req, resp);
				
				}
			 
		}
		if(op.equals("delage")){
			String aid=req.getParameter("aid");
			CarAge carAge=new CarAge();
			carAge.setA_id(Integer.parseInt(aid.trim()));
			CarAgeServiceImpl ageServiceImpl=new CarAgeServiceImpl();

			if(ageServiceImpl.deleteCarAge(carAge)){
				 resp.getWriter().print(1);
			}
		}
		if(op.equals("addprice")){
			String aname=req.getParameter("cAge");
			String acount=req.getParameter("count");
			PriceInterval priceInterval=new PriceInterval();
			priceInterval.setP_name(aname);
			priceInterval.setP_count((long) 0);
			 if(acount!=null&&!acount.equals("")){
				 priceInterval.setP_count(Long.parseLong(acount));
	              }
			 PriceIntervalServiceImpl intervalServiceImpl=new PriceIntervalServiceImpl();
			 if(intervalServiceImpl.addPriceInterval(priceInterval)){
				 req.setAttribute("mea", "添加成功");
					req.getRequestDispatcher("admin/price-add.jsp").forward(req, resp);
			 }
		}
		if(op.equals("upprice")){
			String pid=req.getParameter("pid");
			PriceInterval priceInterval=new PriceInterval();
			priceInterval.setP_id(Integer.parseInt(pid));
			 PriceIntervalServiceImpl intervalServiceImpl=new PriceIntervalServiceImpl();

		PriceInterval interval=	 intervalServiceImpl.getPriceIntervalById(priceInterval);
		req.setAttribute("price", interval);
		req.getRequestDispatcher("admin/price-up.jsp").forward(req, resp);
		
		}
		if(op.equals("tjupprice")){
			String pid=req.getParameter("pid");
			String aname=req.getParameter("cAge");
			String acount=req.getParameter("count");
			PriceInterval priceInterval=new PriceInterval();
			priceInterval.setP_id(Integer.parseInt(pid));
			priceInterval.setP_name(aname);
			priceInterval.setP_count((long) 0);
			 if(acount!=null&&!acount.equals("")){
				 priceInterval.setP_count(Long.parseLong(acount));
	              }
			 PriceIntervalServiceImpl intervalServiceImpl=new PriceIntervalServiceImpl();
       if(intervalServiceImpl.updatePriceInterval(priceInterval)){
    	   req.setAttribute("mea", "修改成功");
    	   req.setAttribute("price", priceInterval);
			req.getRequestDispatcher("admin/price-up.jsp").forward(req, resp);
       }
		}
		if(op.equals("delprice")){
			String pid=req.getParameter("pid");
			PriceInterval priceInterval=new PriceInterval();
			priceInterval.setP_id(Integer.parseInt(pid.trim()));
			 PriceIntervalServiceImpl intervalServiceImpl=new PriceIntervalServiceImpl();
   if(intervalServiceImpl.deletePriceInterval(priceInterval)){
	   resp.getWriter().print(1);
   }
		 
		}
		if(op.equals("adddis")){
			String aname=req.getParameter("cAge");
			String acount=req.getParameter("count");
			Distance distance=new Distance();
			distance.setD_name(aname);
			distance.setD_count(0);
			 if(acount!=null&&!acount.equals("")){
				 distance.setD_count(Long.parseLong(acount));
	              }
			 DistanceServiceImpl distanceServiceImpl=new DistanceServiceImpl();
			 if(distanceServiceImpl.addDistance(distance)){
				 req.setAttribute("mea", "添加成功");
				 req.getRequestDispatcher("admin/distance-add.jsp").forward(req, resp);
			 }
		}
		if(op.equals("updis")){
			String did=req.getParameter("did");
			Distance distance=new Distance();
			distance.setD_id(Integer.parseInt(did.trim()));
			DistanceServiceImpl distanceServiceImpl=new DistanceServiceImpl();
		Distance dis=	distanceServiceImpl.getDistanceById(distance);
		  req.setAttribute("distance", dis);
		  req.getRequestDispatcher("admin/distance-up.jsp").forward(req, resp);
		}
		if(op.equals("tjupdis")){
			String aname=req.getParameter("cAge");
			String acount=req.getParameter("count");
			String did=req.getParameter("did");
			Distance distance=new Distance();
			distance.setD_id(Integer.parseInt(did.trim()));
			distance.setD_name(aname);
			distance.setD_count(0);
			 if(acount!=null&&!acount.equals("")){
				 distance.setD_count(Long.parseLong(acount));
	              }
			 DistanceServiceImpl distanceServiceImpl=new DistanceServiceImpl();
			 if(distanceServiceImpl.updateDistance(distance)){
				 req.setAttribute("mea", "修改成功");
				 req.setAttribute("distance", distance);
				 req.getRequestDispatcher("admin/distance-up.jsp").forward(req, resp);
			 }
		}
		if(op.equals("deldis")){
			String did=req.getParameter("did");
			Distance distance=new Distance();
			distance.setD_id(Integer.parseInt(did.trim()));
			 DistanceServiceImpl distanceServiceImpl=new DistanceServiceImpl();

			 if(distanceServiceImpl.deleteDistance(distance)){
				 resp.getWriter().print(1);
			 }
		}
		if(op.equals("addemsi")){
			String name=req.getParameter("name");
			String acount=req.getParameter("count");
			Emissionstandard emissionstandard=new Emissionstandard();
			emissionstandard.setE_name(name);
			emissionstandard.setE_count(0);
			 if(acount!=null&&!acount.equals("")){
				 emissionstandard.setE_count(Long.parseLong(acount));
	              }
			 EmissionstandardServiceImpl emissionstandardServiceImpl=new EmissionstandardServiceImpl();
			 if(emissionstandardServiceImpl.addEmissionstandard(emissionstandard)){
				 req.setAttribute("mea", "添加成功");
				 req.getRequestDispatcher("admin/emsi-add.jsp").forward(req, resp);
			 }
		}
		if(op.equals("upemsi")){
			String eid=req.getParameter("eid");
			Emissionstandard emissionstandard=new Emissionstandard();
			emissionstandard.setE_id(Integer.parseInt(eid));
			 EmissionstandardServiceImpl emissionstandardServiceImpl=new EmissionstandardServiceImpl();
       Emissionstandard emsi=   emissionstandardServiceImpl.getEmissionstandard(emissionstandard);
		req.setAttribute("emsi", emsi);
		req.getRequestDispatcher("admin/emsi-up.jsp").forward(req, resp);
		}
		if(op.equals("tjemsi")){
			String eid=req.getParameter("eid");
			String name=req.getParameter("name");
			String acount=req.getParameter("count");
			Emissionstandard emissionstandard=new Emissionstandard();
			emissionstandard.setE_id(Integer.parseInt(eid));
			emissionstandard.setE_name(name);
			emissionstandard.setE_count(0);
			 if(acount!=null&&!acount.equals("")){
				 emissionstandard.setE_count(Long.parseLong(acount));
	              }
			 EmissionstandardServiceImpl emissionstandardServiceImpl=new EmissionstandardServiceImpl();
		if(emissionstandardServiceImpl.updateEmissionstandard(emissionstandard)){
			req.setAttribute("mea", "修改成功");
			req.setAttribute("emsi", emissionstandard);
			req.getRequestDispatcher("admin/emsi-up.jsp").forward(req, resp);
		}
		}
		if(op.equals("delemsi")){
			String eid=req.getParameter("eid");
			Emissionstandard emissionstandard=new Emissionstandard();
			emissionstandard.setE_id(Integer.parseInt(eid));
			 EmissionstandardServiceImpl emissionstandardServiceImpl=new EmissionstandardServiceImpl();
           if(emissionstandardServiceImpl.deleteEmissionstandard(emissionstandard)){
        	   resp.getWriter().print(1);
           }
		}
		if(op.equals("addtype")){
			 String bname=req.getParameter("maxAge");
	            String bcount=req.getParameter("count");
	            String bimg=req.getParameter("ttp");
	            CarType carType=new CarType();
	            carType.setT_name(bname);
	            carType.setT_count(0);
	            carType.setT_class("");
	            carType.setT_img("");
	            if(bimg!=null&&!bimg.equals("")){
	            	carType.setT_class("tepimages/"+bimg);
	              }
	              if(bcount!=null&&!bcount.equals("")){
	            	  carType.setT_count(Long.parseLong(bcount));
	             }
	             CarTypeServiceImpl carTypeServiceImpl=new CarTypeServiceImpl();
	           if(  carTypeServiceImpl.addCarType(carType)){
	        	   req.setAttribute("mea", "添加成功");
	        	   req.getRequestDispatcher("admin/type-add.jsp").forward(req, resp);
	           }
	            
		}
		if(op.equals("uptype")){
		   String tid=req.getParameter("tid");
		   CarType carType=new CarType();
		   carType.setT_id(Integer.parseInt(tid));
		    CarTypeServiceImpl carTypeServiceImpl=new CarTypeServiceImpl();
		  CarType _cartype=  carTypeServiceImpl.getCarType(carType);
		  httpSession.setAttribute("upcartype", _cartype);
		  resp.sendRedirect("admin/type-up.jsp");
		}
		if(op.equals("tjuptype")){
			 String tid=req.getParameter("tid");
			 String bname=req.getParameter("maxAge");
	            String bcount=req.getParameter("count");
	            String bimg=req.getParameter("ttp");
			   CarType carType=new CarType();
			   carType.setT_id(Integer.parseInt(tid));
			   carType.setT_name(bname);
	            carType.setT_count(0);
	            carType.setT_class(req.getParameter("qtp"));
	            if(bcount!=null&&!bcount.equals("")){
	            	  carType.setT_count(Long.parseLong(bcount));
	             }
	            if(bimg!=null&&!bimg.equals("")){
	              
	                     carType.setT_class("tepimages/"+bimg);
	                   }
			   CarTypeServiceImpl carTypeServiceImpl=new CarTypeServiceImpl();
			   if(carTypeServiceImpl.updateType(carType)){
				   httpSession.setAttribute("upcartype", carType);
				   httpSession.setAttribute("upbrand", "修改成功");
				   resp.sendRedirect("admin/type-up.jsp");
			   }
		}
		if(op.equals("deltype")){
			 String tid=req.getParameter("tid");
			 CarType carType=new CarType();
			   carType.setT_id(Integer.parseInt(tid));
			   CarTypeServiceImpl carTypeServiceImpl=new CarTypeServiceImpl();
       if(carTypeServiceImpl.deleteCarType(carType)){
    	   resp.getWriter().print(1);
       }
			   
		}
	}
private void fenye(HttpServletRequest req, HttpServletResponse resp,CarBrand carBrand){
		
	 CarBrandServiceImpl brandServiceImpl=new CarBrandServiceImpl();
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 int maxRowsCount=brandServiceImpl.queryPersonCarCount(carBrand);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(8, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=brandServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carBrand);
		DbUtil.closeAll();
		Map<Long, CarBrand> _brandMap=new HashMap<Long, CarBrand>();
		for(Long key:trendsMap.keySet()){
			CarBrand _carBrand=(CarBrand) trendsMap.get(key);
			_brandMap.put((long) _carBrand.getB_id() ,_carBrand);
		}
		
		req.setAttribute("brandMap", _brandMap);
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
private void fenyeage(HttpServletRequest req, HttpServletResponse resp,CarAge carAge){
	
	CarAgeServiceImpl ageServiceImpl=new CarAgeServiceImpl();
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
  
	 int maxRowsCount=ageServiceImpl.queryPersonCarCount(carAge);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(8, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=ageServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carAge);
		DbUtil.closeAll();
		Map<Long, CarAge> _brandMap=new HashMap<Long, CarAge>();
		for(Long key:trendsMap.keySet()){
			CarAge _carBrand=(CarAge) trendsMap.get(key);
			_brandMap.put((long) _carBrand.getA_id() ,_carBrand);
		}
		
		req.setAttribute("brandMap", _brandMap);
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
private void fenyeprice(HttpServletRequest req, HttpServletResponse resp,PriceInterval priceInterval){
	
	 PriceIntervalServiceImpl ageServiceImpl=new PriceIntervalServiceImpl();
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
  
	 int maxRowsCount=ageServiceImpl.queryPersonCarCount(priceInterval);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(8, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=ageServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), priceInterval);
		DbUtil.closeAll();
		Map<Long, PriceInterval> _brandMap=new HashMap<Long, PriceInterval>();
		for(Long key:trendsMap.keySet()){
			PriceInterval _carBrand=(PriceInterval) trendsMap.get(key);
			_brandMap.put((long) _carBrand.getP_id() ,_carBrand);
		}
		
		req.setAttribute("brandMap", _brandMap);
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
private void fenyedis(HttpServletRequest req, HttpServletResponse resp,Distance distance){
	
	 DistanceServiceImpl ageServiceImpl=new DistanceServiceImpl();
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
 
	 int maxRowsCount=ageServiceImpl.queryPersonCarCount(distance);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(8, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=ageServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), distance);
		DbUtil.closeAll();
		Map<Long, Distance> _brandMap=new HashMap<Long, Distance>();
		for(Long key:trendsMap.keySet()){
			Distance _carBrand=(Distance) trendsMap.get(key);
			_brandMap.put((long) _carBrand.getD_id() ,_carBrand);
		}
		
		req.setAttribute("brandMap", _brandMap);
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
private void fenyeemsi(HttpServletRequest req, HttpServletResponse resp,Emissionstandard emissionstandard){
	
	 EmissionstandardServiceImpl ageServiceImpl=new EmissionstandardServiceImpl();
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		

	 int maxRowsCount=ageServiceImpl.queryPersonCarCount(emissionstandard);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(8, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=ageServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), emissionstandard);
		DbUtil.closeAll();
		Map<Long, Emissionstandard> _brandMap=new HashMap<Long, Emissionstandard>();
		for(Long key:trendsMap.keySet()){
			Emissionstandard _carBrand=(Emissionstandard) trendsMap.get(key);
			_brandMap.put((long) _carBrand.getE_id() ,_carBrand);
		}
		
		req.setAttribute("brandMap", _brandMap);
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
private void fenyeety(HttpServletRequest req, HttpServletResponse resp,CarType carType){
	
	 CarTypeServiceImpl ageServiceImpl=new CarTypeServiceImpl();
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		

	 int maxRowsCount=ageServiceImpl.queryPersonCarCount(carType);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(8, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=ageServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carType);
		DbUtil.closeAll();
		Map<Long, CarType> _brandMap=new HashMap<Long, CarType>();
		for(Long key:trendsMap.keySet()){
			CarType _carBrand=(CarType) trendsMap.get(key);
			_brandMap.put((long) _carBrand.getT_id() ,_carBrand);
		}
		
		req.setAttribute("brandMap", _brandMap);
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
}
