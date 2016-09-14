package cn.com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bean.CarInfo;
import cn.com.bean.PerSonCar;
import cn.com.bean.PersonNeed;
import cn.com.service.impl.CarInfoServiceImpl;
import cn.com.service.impl.PersonCarServiceImpl;
import cn.com.service.impl.PersonNeedServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;
/**
 * 订单管理引擎
 * 
 */
public class MgorderServlet extends HttpServlet{
      PersonCarServiceImpl perSonCarService=new PersonCarServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8"); //设置请求编码
		resp.setCharacterEncoding("utf-8"); //设置响应编码
		String op=req.getParameter("op");  //命令操作符
		//展示暂停交易的订单
		if(op.equals("showzzjy")){
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setP_state("暂停交易");
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/zzjy.jsp").forward(req, resp);
		}
		//展示交易中的订单
		if(op.equals("showjyz")){
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setP_state("已定");
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/jyz.jsp").forward(req, resp);
		}
		//展示交易完成的订单
		if(op.equals("showjywc")){
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setP_state("交易完成");
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/jywc.jsp").forward(req, resp);
		}
		//展示所有订单
		if(op.equals("showallord")){
			PerSonCar perSonCar=new PerSonCar();
			
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/allorder.jsp").forward(req, resp);
		}
		//通过取消交易请求
		if(op.equals("tgzz")){
			
			String uid=req.getParameter("uid");
			String cuid=req.getParameter("cuid");
			String cid=req.getParameter("cid");
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setC_uid(Long.parseLong(cuid));
			perSonCar.setP_state("暂停交易");
			CarInfo carInfo=new CarInfo();
			carInfo.setC_id(Long.parseLong(cid));
			carInfo.setC_state("在售");
			PerSonCar _PerSonCar=new PerSonCar();
			_PerSonCar.setU_id(Long.parseLong(cuid));
			_PerSonCar.setC_id(Long.parseLong(cid));
			_PerSonCar.setC_uid(Long.parseLong(cuid));
			_PerSonCar.setP_state("暂停交易");
			CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
			if(perSonCarService.updatePerSoncar(_PerSonCar, "出售")&&perSonCarService.deletePersonByAll(perSonCar)&&carInfoServiceImpl.updateCarInfo(carInfo)){
				resp.getWriter().print(1);
			}
		}
		//强制中止操作
if(op.equals("qzzz")){
			
			String uid=req.getParameter("uid");
			String cuid=req.getParameter("cuid");
			String cid=req.getParameter("cid");
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setC_uid(Long.parseLong(cuid));
			perSonCar.setP_state("已定");
			CarInfo carInfo=new CarInfo();
			carInfo.setC_id(Long.parseLong(cid));
			carInfo.setC_state("在售");
			PerSonCar _PerSonCar=new PerSonCar();
			_PerSonCar.setU_id(Long.parseLong(cuid));
			_PerSonCar.setC_id(Long.parseLong(cid));
			_PerSonCar.setC_uid(Long.parseLong(cuid));
			_PerSonCar.setP_state("被定");
			CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
			if(perSonCarService.updatePerSoncar(_PerSonCar, "出售")&&perSonCarService.deletePersonByAll(perSonCar)&&carInfoServiceImpl.updateCarInfo(carInfo)){
				resp.getWriter().print(1);
			}
		}
		//拒绝中止操作
		if(op.equals("jjzz")){
			String uid=req.getParameter("uid");
			String cuid=req.getParameter("cuid");
			String cid=req.getParameter("cid");
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setC_uid(Long.parseLong(cuid));
			perSonCar.setP_state("暂停交易");
			PerSonCar _PerSonCar=new PerSonCar();
			_PerSonCar.setU_id(Long.parseLong(cuid));
			_PerSonCar.setC_id(Long.parseLong(cid));
			_PerSonCar.setC_uid(Long.parseLong(cuid));
			_PerSonCar.setP_state("暂停交易");
			if(perSonCarService.updatePerSoncar(_PerSonCar, "被定")&&perSonCarService.updatePerSoncar(perSonCar, "已定")){
				resp.getWriter().print(1);
			}
		}
		//展示已处理个人需求信息
		if(op.equals("yclsrdz")){
			String id=req.getParameter("pid");
			PersonNeed personNeed=new PersonNeed();
			personNeed.setP_id(Long.parseLong(id));
			personNeed.setP_state("已处理");
			PersonNeedServiceImpl personNeedServiceImpl=new PersonNeedServiceImpl();
			if(personNeedServiceImpl.updatePersonNeed(personNeed)){
				resp.getWriter().print(1);
			}
		}
		//删除个人需求信息
		if(op.equals("delsrdz")){
			String id=req.getParameter("pid");
			PersonNeed personNeed=new PersonNeed();
			personNeed.setP_id(Long.parseLong(id));
			PersonNeedServiceImpl needServiceImpl=new PersonNeedServiceImpl();
			
			if(needServiceImpl.deletePersonNeed(personNeed) ){
				resp.getWriter().print(1);
			}
		}
	}
	/**
	 * 分页展示个人汽车订单的方法
	 * 
	 */
private void fenye(HttpServletRequest req, HttpServletResponse resp,PerSonCar perSonCar){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 int maxRowsCount=perSonCarService.queryPersonCarCount(perSonCar);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(9, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, PerSonCar> perMap=perSonCarService.getPersonList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), perSonCar);
		CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
		Map<Long, CarInfo> carMap=new HashMap<Long, CarInfo>();
		
		for(Long key :perMap.keySet()){
			if(perMap.get(key).getC_uid()!=perMap.get(key).getU_id()){
				CarInfo carInfo=new CarInfo();
				carInfo.setC_id(perMap.get(key).getC_id());
			carInfo=	carInfoServiceImpl.getCarByWhere(carInfo).get(carInfo.getC_id());
				carMap.put(carInfo.getC_id(), carInfo);
			}
			
		}
		
		DbUtil.closeAll();
		
		req.setAttribute("szCar", perMap);
		req.setAttribute("car", carMap);
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
