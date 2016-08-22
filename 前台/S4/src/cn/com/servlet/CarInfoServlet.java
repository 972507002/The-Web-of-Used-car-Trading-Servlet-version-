package cn.com.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import cn.com.bean.*;
import cn.com.service.*;
import cn.com.service.impl.*;
import cn.com.util.*;


public class CarInfoServlet  extends HttpServlet{
	CarInfoServiceImpl carInfoService=new CarInfoServiceImpl();
	ICarBrandService carBrandService=new CarBrandServiceImpl();
	ICarTypeService carTypeService=new CarTypeServiceImpl();
	ITrendsService trendsService=new TrendsServiceImpl();
	  IPriceIntervalService priceIntervalService=new PriceIntervalServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String op=req.getParameter("op");
		//�����۸�
	    	 Map<Integer, PriceInterval> priceMap= priceIntervalService.getPriceIntervalByCount();
	    	 DbUtil.closeAll();  
	   	  req.setAttribute("priceMap", priceMap);
		CarInfo carInfo=new CarInfo();
		//����Ʒ��
		carInfo.setC_state("����");
		Map<Integer, CarBrand> showBrandMap=	carBrandService.getCarBrandByCount();
		DbUtil.closeAll();
		//��������
		  
		  Map<Integer, CarType> showType= carTypeService.getCarTypeByCount();

		  DbUtil.closeAll();
		  req.setAttribute("showType", showType);
		req.setAttribute("showbrand", showBrandMap);
	//��������
 	   ICarAgeService carAgeService=new CarAgeServiceImpl();

		Map<Integer, CarAge> ageMap= carAgeService.getCarAgeByCount();
	   	 DbUtil.closeAll();  
	  	  req.setAttribute("ageMap", ageMap);
		if(op.equals("show")){
			
			//�����Ƽ�
			Map<Long, CarInfo>  showCarMap=	carInfoService.getCarInfoByCountDesc(carInfo);
			DbUtil.closeAll();
			session.setAttribute("showcar", showCarMap);
			
			
			
			//Ʒ��չʾ
			  Map<Integer, CarBrand> allBrandMap= carBrandService.getAllBrand();
			  DbUtil.closeAll();
			session.setAttribute("allbrand", allBrandMap);
	
		
	//����Ʒ���µ���������
	Map<Long,CarInfo> carMap=new HashMap<Long, CarInfo>();
	for(Integer key:showBrandMap.keySet()){
		clerCarAtr(carInfo);
		carInfo.setC_brand(showBrandMap.get(key).getB_name());
	Map<Long, CarInfo> brandCar=carInfoService.getCarInfoByBrandCountDesc(carInfo);
	
	DbUtil.closeAll();
	
	for(Long key1:brandCar.keySet()){
		carMap.put(key1,brandCar.get(key1));
	} 
	}
	req.setAttribute("brandcar",carMap );
	//���µ���
  Map<Long, CarInfo> newCarMap=	carInfoService.getCarInfoBySjTime(carInfo);
  DbUtil.closeAll();
  req.setAttribute("newcar", newCarMap);
  Map<Long, CarInfo> fourthCarMap=	carInfoService.getFourthCarInfoBySjTime(carInfo);
  DbUtil.closeAll();
  req.setAttribute("fourthcar", fourthCarMap);
  
  List<String> leftszm=new ArrayList<String>();
  List<String> rightszm=new ArrayList<String>();
  for(Integer key :allBrandMap.keySet()){
	  if(leftszm.size()<9){
	  if(!leftszm.contains(allBrandMap.get(key).getB_szm())){
		  leftszm.add( allBrandMap.get(key).getB_szm());
		  
	  }
	  }
	  else{
		  if(!leftszm.contains(allBrandMap.get(key).getB_szm())){
			  if(!rightszm.contains(allBrandMap.get(key).getB_szm())){
				  rightszm.add(allBrandMap.get(key).getB_szm());
			  }
			  
		  }
	  }
  }
  Collections.sort(leftszm);
  Collections.sort(rightszm);
  req.setAttribute("leftszm", leftszm);
  req.setAttribute("rightszm", rightszm);

 Map<Long,CarInfo> typeCarMap=new HashMap<Long, CarInfo>();
	for(Integer key:showType.keySet()){
		clerCarAtr(carInfo);
		carInfo.setC_type(showType.get(key).getT_name());
		
	Map<Long, CarInfo> typeCar=carInfoService.getCarInfoByTypeCountDesc(carInfo);
	
	DbUtil.closeAll();
	for(Long key1:typeCar.keySet()){
		typeCarMap.put(key1,typeCar.get(key1));
	} 
	} 
	Comment comment=new Comment();
	comment.setC_admin("��ҳչʾ");
	CommentServiceImpl commentServiceImpl=new CommentServiceImpl();
	req.setAttribute("com1", commentServiceImpl.getTheTowComment(comment, 0, 2));
	req.setAttribute("com2", commentServiceImpl.getTheTowComment(comment, 2, 4));
	req.setAttribute("com3", commentServiceImpl.getTheTowComment(comment, 4, 6));

	
	  Trends trends=new Trends();
	  trends.setTr_type("ָ��");
		
		 List<Trends> trendsList1=   trendsService.getITrendsByTime(trends,6);
		 session.setAttribute("zhinan", trendsList1);
		
		  trends.setTr_type("��ŵ");
			
			 List<Trends> trendsList2=   trendsService.getITrendsByTime(trends,6);
			 session.setAttribute("chennuo", trendsList2);
	  trends.setTr_type("�");
	
	 List<Trends> trendsList=   trendsService.getITrendsByTime(trends,5);
	 for(int i=0;i<trendsList.size();i++){
		 req.setAttribute("active"+(i+1)+"", trendsList.get(i));
	 }
	 trends.setTr_type("����");
		
	 List<Trends> newsList=   trendsService.getITrendsByTime(trends,11);
	 List<Trends> news1=new ArrayList<Trends>();
	 List<Trends> news2=new ArrayList<Trends>();
	 for(int i=0;i<newsList.size();i++){
		 if(i<5){
		 if(i==0){
			 req.setAttribute("new1", newsList.get(i));
		 }
		 news1.add(newsList.get(i));
	 }
		 else{
		 if(i==5){
			 req.setAttribute("new6", newsList.get(i));
		 }
		 news2.add(newsList.get(i));
		 }
	 }
	     req.setAttribute("news1", news1);
	     req.setAttribute("news2", news2);
	   req.setAttribute("typecar",typeCarMap );
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		if(op.equals("showlist")){
			clerCarAtr(carInfo);
			bindWhere(req, resp);
			fenye(req, resp, carInfo);
			req.getRequestDispatcher("maiche_list.jsp").forward(req, resp);
		}
		
		if(op.equals("showdetails")){
		Map<Long, CarInfo> detailsMap=getdea(req, resp, carInfo);
     CarInfo _carInfo=detailsMap.get(carInfo.getC_id());
  Map<Long, CarInfo> bcar=   carInfoService.getCarInfoByBrandCountDesc(_carInfo);
  bcar.remove(_carInfo.getC_id());
  req.setAttribute("bcar", bcar);
     _carInfo.setC_count(_carInfo.getC_count()+1);
    if(carInfoService.updateCarInfo(_carInfo)){
 req.getRequestDispatcher("maiche_show.jsp").forward(req, resp);
		}
		}
		if(op.equals("showshdea")){
			carInfo.setC_state(null);
			getdea(req, resp, carInfo);
		    
		 req.getRequestDispatcher("admin/maiche_show.jsp").forward(req, resp);
				
		}
		if(op.equals("showsrdz")){
			req.setAttribute("ageMap", ageMap);
			 req.getRequestDispatcher("admin/srdz.jsp").forward(req, resp);

		}
		if(op.equals("showCompare")){
			  IBasicInfoService basicInfoService=new BasicInfoServiceImpl();
			IHardwareConfigService hardwareConfigService=new HardwareConfigServiceImpl();
			IProcedureInfoService procedureInfoService=new ProcedureInfoServiceImpl();
			ISellInfoService sellInfoService=new SellInfoServiceImpl();
			ISystemConfigService systemConfigService=new SystemConfigServiceImpl();
			this.setID(req, resp, carInfo);
			
			Map<Long, CarInfo> detailsMap=carInfoService.getCarByWhere(carInfo);
		
			 DbUtil.closeAll();
		
				BasicInfo    basicInfo=   basicInfoService.getAllBasicById(carInfo);
	     DbUtil.closeAll();
	     HardwareConfig   hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
	 DbUtil.closeAll();
	 ProcedureInfo   procedureInfo= procedureInfoService.getProcedureInfoById(carInfo);
	 DbUtil.closeAll();
	 SystemConfig  systemConfig= systemConfigService.getSystemConfigById(carInfo);
	 DbUtil.closeAll();
	 SellInfo sellInfo=sellInfoService.getSellInfoById(carInfo);
	 DbUtil.closeAll();        
			 Object pareCar=   session.getAttribute("pareCarInfo");
        Object pareSys=   session.getAttribute("pareSystemConfig");
        Object pareSell=   session.getAttribute("pareSellInfo");
        Object pareHar=   session.getAttribute("pareHardwareConfig");
        Object parePro=   session.getAttribute("pareProcedureInfo");
        Object pareBas=   session.getAttribute("pareBasic");
        
        Map<Integer, CarInfo> pareCarInfo=null;
        Map<Integer, SystemConfig> pareSystemConfig=null;
        Map<Integer, SellInfo> pareSellInfo=null;
        Map<Integer, HardwareConfig> pareHardwareConfig=null;
        Map<Integer, ProcedureInfo> pareProcedureInfo=null;
        Map<Integer, BasicInfo> pareBasic=null;
        boolean flag=false;
       
        if(pareCar==null){
            pareCarInfo=new HashMap<Integer, CarInfo>();
            pareCarInfo.put(1, detailsMap.get(carInfo.getC_id()));
        }
        if(pareCar!=null){
        	
            pareCarInfo=(Map<Integer, CarInfo>) pareCar;
           
          flag=  pareCarInfo.containsValue(detailsMap.get(carInfo.getC_id()));
         
          if(flag==false){
            if(pareCarInfo.size()==1){
            	 pareCarInfo.put(2, detailsMap.get(carInfo.getC_id()));
            }
            else if(pareCarInfo.size()==2){
            	 pareCarInfo.put(3, detailsMap.get(carInfo.getC_id()));
            }
            else{
            	pareCarInfo.put(1, pareCarInfo.get(2));
            	pareCarInfo.put(2, pareCarInfo.get(3));
            	 pareCarInfo.put(3, detailsMap.get(carInfo.getC_id()));
            }
        }
        }
        if(pareSys==null){
            pareSystemConfig=new HashMap<Integer, SystemConfig>();
           pareSystemConfig.put(1, systemConfig);
        }
        if(pareSys!=null){
        	
        	pareSystemConfig=(Map<Integer, SystemConfig>) pareSys;
        	if(flag==false){
            if(pareSystemConfig.size()==1){
            	pareSystemConfig.put(2, systemConfig);
            }
            else if(pareSystemConfig.size()==2){
            	pareSystemConfig.put(3,systemConfig);
            }
            else{
            	pareSystemConfig.put(1, pareSystemConfig.get(2));
            	pareSystemConfig.put(2, pareSystemConfig.get(3));
            	pareSystemConfig.put(3, systemConfig);
            }
        	}
        }
        if(pareSell==null){
             pareSellInfo=new HashMap<Integer, SellInfo>();
            pareSellInfo.put(1,sellInfo );
        }
        if(pareSell!=null){
        	
         pareSellInfo=(Map<Integer, SellInfo>) pareSell;
         if(flag==false){
            if(pareSellInfo.size()==1){
            	pareSellInfo.put(2, sellInfo);
            }
            else if(pareSellInfo.size()==2){
            	pareSellInfo.put(3,sellInfo);
            }
            else{
            	pareSellInfo.put(1, pareSellInfo.get(2));
            	pareSellInfo.put(2, pareSellInfo.get(3));
            	pareSellInfo.put(3, sellInfo);
            }
        	}
        }
        if(pareHar==null){
           pareHardwareConfig=new HashMap<Integer, HardwareConfig>();
            pareHardwareConfig.put(1, hardwareConfig);
        }
        if(pareHar!=null){
        
        	 pareHardwareConfig=(Map<Integer, HardwareConfig>) pareHar;
        	 if(flag==false){
            if(pareHardwareConfig.size()==1){
            	pareHardwareConfig.put(2, hardwareConfig);
            }
            else if(pareHardwareConfig.size()==2){
            	pareHardwareConfig.put(3,hardwareConfig);
            }
            else{
            	pareHardwareConfig.put(1, pareHardwareConfig.get(2));
            	pareHardwareConfig.put(2, pareHardwareConfig.get(3));
            	pareHardwareConfig.put(3, hardwareConfig);
            
        	 }
        	}
        }
        if(parePro==null){
             pareProcedureInfo=new HashMap<Integer, ProcedureInfo>();
            pareProcedureInfo.put(1, procedureInfo);
        }
        if(parePro!=null){
        	
        	 pareProcedureInfo=(Map<Integer, ProcedureInfo>) parePro;
        	 if(flag==false){
            if(pareProcedureInfo.size()==1){
            	pareProcedureInfo.put(2, procedureInfo);
            }
            else if(pareProcedureInfo.size()==2){
            	pareProcedureInfo.put(3,procedureInfo);
            }
            else{
            	pareProcedureInfo.put(1, pareProcedureInfo.get(2));
            	pareProcedureInfo.put(2, pareProcedureInfo.get(3));
            	pareProcedureInfo.put(3, procedureInfo);
            
        	 }
        	}
        }
        if(pareBas==null){
             pareBasic=new HashMap<Integer, BasicInfo>();
            pareBasic.put(1, basicInfo);
        }
        if(pareBas!=null){
        	
        	 pareBasic=(Map<Integer, BasicInfo>) pareBas;
        	 if(flag==false){
            if(pareBasic.size()==1){
            	pareBasic.put(2, basicInfo);
            }
            else if(pareBasic.size()==2){
            	pareBasic.put(3,basicInfo);
            }
            else{
            	pareBasic.put(1, pareBasic.get(2));
            	pareBasic.put(2, pareBasic.get(3));
            	pareBasic.put(3, basicInfo);
            
        	 }
        	}
        }
        req.setAttribute("cid", carInfo.getC_id());
        req.setAttribute("uid", carInfo.getU_id());
         session.setAttribute("pareCarInfo", pareCarInfo);
         session.setAttribute("pareSystemConfig", pareSystemConfig);
         session.setAttribute("pareSellInfo", pareSellInfo);
         session.setAttribute("pareHardwareConfig", pareHardwareConfig);
         session.setAttribute("pareProcedureInfo", pareProcedureInfo);
         session.setAttribute("pareBasic", pareBasic);
        req.getRequestDispatcher("compareCar.jsp").forward(req, resp);
		}
		if(op.equals("zjbj")){
			 Object pareCar=   session.getAttribute("pareCarInfo");
		        Object pareSys=   session.getAttribute("pareSystemConfig");
		        Object pareSell=   session.getAttribute("pareSellInfo");
		        Object pareHar=   session.getAttribute("pareHardwareConfig");
		        Object parePro=   session.getAttribute("pareProcedureInfo");
		        Object pareBas=   session.getAttribute("pareBasic");
		        Map<Long, CarInfo> car=(Map<Long, CarInfo>) pareCar;
		 Object[] cars=     car.values().toArray();
		 CarInfo _carInfo=(CarInfo) cars[cars.length-1];
		 
		 req.setAttribute("cid",_carInfo.getC_id());
		 req.setAttribute("uid", _carInfo.getU_id());
		        session.setAttribute("pareCarInfo", pareCar);
		         session.setAttribute("pareSystemConfig", pareSys);
		         session.setAttribute("pareSellInfo", pareSell);
		         session.setAttribute("pareHardwareConfig", pareHar);
		         session.setAttribute("pareProcedureInfo", parePro);
		         session.setAttribute("pareBasic", pareBas);
		        req.getRequestDispatcher("compareCar.jsp").forward(req, resp);
		}
		if(op.equals("djbd")){
	 List<CarInfo>	tencar=	carInfoService.getTenCount(carInfo);
	 req.setAttribute("trends", tencar);
	 req.getRequestDispatcher("count_list.jsp").forward(req, resp);
		}
		if(op.equals("jybd")){
			List<CarInfo>	tencar=	carInfoService.getTenBrandCar(carInfo);
			List<CarBrand> tenBrand=new ArrayList<CarBrand>();
			for(CarInfo c:tencar){
				CarBrand brand=new CarBrand();
				brand.setB_name(c.getC_brand());
				tenBrand.add(carBrandService.getBrandByName(brand));
				
			}
			req.setAttribute("trends", tencar);
			req.setAttribute("tenBrand", tenBrand);
			req.getRequestDispatcher("jy_list.jsp").forward(req, resp);
		}
	}
    
	private void fenye(HttpServletRequest req, HttpServletResponse resp,CarInfo carInfo){
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		//���þ������
		String distance=null;
		if(req.getParameter("distance")!=null){
			distance = new String(req.getParameter("distance").getBytes("ISO8859-1"),"utf-8");
			}
	   Map<String, Integer> distanceMap=setDistance(distance);
		//���ü۸����
	   String price = null;
		if(req.getParameter("price")!=null){
			price = new String(req.getParameter("price").getBytes("ISO8859-1"),"utf-8");
		}
      Map<String, Integer> priceMap=setPrice(price);
      //���ó������
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
		//�����ҳ�߼�<=>����
		PageUtil pageUtil=new PageUtil(7, maxRowsCount);
		// ����ҳ���߼�
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
       private  void bindWhere(HttpServletRequest req, HttpServletResponse resp){
    	   IDistanceService distanceService=new DistanceServiceImpl();
    	  IEmissionstandardService emissionstandardService=new EmissionstandardServiceImpl();
    	   Map<Integer, Distance> distanceMap= distanceService.getDistanceByCount();
          DbUtil.closeAll();  
    	  req.setAttribute("distanceMap", distanceMap);
   	 
  	
	
  Map<Integer,Emissionstandard> emisMap=emissionstandardService.getEmissionstandardByCount();
    DbUtil.closeAll();
    req.setAttribute("emisMap", emisMap);
       }
       /**
        * ���þ�������ķ���
        * @param distance
        * @return
        */
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
        * ���ü۸�����ķ���
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
        * ���ó�������ķ���
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
       /**
        * ��������ID�ķ����ķ���
        * @param req
        * @param resp
        * @param carInfo
        */
       private void setID(HttpServletRequest req,HttpServletResponse resp,CarInfo carInfo){
    	 
    	   int c_id=Integer.parseInt(req.getParameter("cid"));
    		int u_id=Integer.parseInt(req.getParameter("uid"));
    		clerCarAtr(carInfo);
    		
    		carInfo.setC_id(c_id);
    		carInfo.setU_id(u_id);
    	   }
       
       /**
        * �ÿ�carinfo������
        * @param carInfo
        */
       private void clerCarAtr(CarInfo carInfo){
    	   carInfo.setC_brand(null);
    	   carInfo.setC_type(null);
       }
       
      
  private Map<Long, CarInfo> getdea(HttpServletRequest req,HttpServletResponse resp,CarInfo carInfo){
	  IBasicInfoService basicInfoService=new BasicInfoServiceImpl();
	    ICarImagesInfoService carImagesInfoService=new CarImagesInfoServiceImpl();
	    IHardwareConfigService hardwareConfigService=new HardwareConfigServiceImpl();
		IProcedureInfoService procedureInfoService=new ProcedureInfoServiceImpl();
		ISellInfoService sellInfoService=new SellInfoServiceImpl();
		ISystemConfigService systemConfigService=new SystemConfigServiceImpl();
	    this.setID(req, resp, carInfo);
 
 Map<Integer, String> carImagesInfo=      carImagesInfoService.getCarImagesInfoByID(carInfo);
DbUtil.closeAll();
req.setAttribute("carImagesInfo", carImagesInfo);
Map<Long, CarInfo> detailsMap=carInfoService.getCarByWhere(carInfo);
DbUtil.closeAll();
req.setAttribute("detailsMap", detailsMap);
	BasicInfo    basicInfo=   basicInfoService.getAllBasicById(carInfo);
DbUtil.closeAll();
HardwareConfig   hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
DbUtil.closeAll();
ProcedureInfo   procedureInfo= procedureInfoService.getProcedureInfoById(carInfo);
DbUtil.closeAll();
SystemConfig  systemConfig= systemConfigService.getSystemConfigById(carInfo);
DbUtil.closeAll();
SellInfo sellInfo=sellInfoService.getSellInfoById(carInfo);
DbUtil.closeAll();
req.setAttribute("cid", carInfo.getC_id());
req.setAttribute("uid", carInfo.getU_id());
req.setAttribute("sellInfo", sellInfo);
 req.setAttribute("systemConfig", systemConfig);
 req.setAttribute("procedureInfo", procedureInfo);
  req.setAttribute("hardwareConfig", hardwareConfig);
  req.setAttribute("basicInfo", basicInfo);
	  return detailsMap;
  }
       
     
}
