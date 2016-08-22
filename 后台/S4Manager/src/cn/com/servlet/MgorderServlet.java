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

public class MgorderServlet extends HttpServlet{
      PersonCarServiceImpl perSonCarService=new PersonCarServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String op=req.getParameter("op");
		if(op.equals("showzzjy")){
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setP_state("��ͣ����");
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/zzjy.jsp").forward(req, resp);
		}
		if(op.equals("showjyz")){
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setP_state("�Ѷ�");
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/jyz.jsp").forward(req, resp);
		}
		if(op.equals("showjywc")){
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setP_state("�������");
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/jywc.jsp").forward(req, resp);
		}
		if(op.equals("showallord")){
			PerSonCar perSonCar=new PerSonCar();
			
			this.fenye(req, resp, perSonCar);
			req.getRequestDispatcher("admin/allorder.jsp").forward(req, resp);
		}
		if(op.equals("tgzz")){
			
			String uid=req.getParameter("uid");
			String cuid=req.getParameter("cuid");
			String cid=req.getParameter("cid");
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setC_uid(Long.parseLong(cuid));
			perSonCar.setP_state("��ͣ����");
			CarInfo carInfo=new CarInfo();
			carInfo.setC_id(Long.parseLong(cid));
			carInfo.setC_state("����");
			PerSonCar _PerSonCar=new PerSonCar();
			_PerSonCar.setU_id(Long.parseLong(cuid));
			_PerSonCar.setC_id(Long.parseLong(cid));
			_PerSonCar.setC_uid(Long.parseLong(cuid));
			_PerSonCar.setP_state("��ͣ����");
			CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
			if(perSonCarService.updatePerSoncar(_PerSonCar, "����")&&perSonCarService.deletePersonByAll(perSonCar)&&carInfoServiceImpl.updateCarInfo(carInfo)){
				resp.getWriter().print(1);
			}
		}
if(op.equals("qzzz")){
			
			String uid=req.getParameter("uid");
			String cuid=req.getParameter("cuid");
			String cid=req.getParameter("cid");
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setC_uid(Long.parseLong(cuid));
			perSonCar.setP_state("�Ѷ�");
			CarInfo carInfo=new CarInfo();
			carInfo.setC_id(Long.parseLong(cid));
			carInfo.setC_state("����");
			PerSonCar _PerSonCar=new PerSonCar();
			_PerSonCar.setU_id(Long.parseLong(cuid));
			_PerSonCar.setC_id(Long.parseLong(cid));
			_PerSonCar.setC_uid(Long.parseLong(cuid));
			_PerSonCar.setP_state("����");
			CarInfoServiceImpl carInfoServiceImpl=new CarInfoServiceImpl();
			if(perSonCarService.updatePerSoncar(_PerSonCar, "����")&&perSonCarService.deletePersonByAll(perSonCar)&&carInfoServiceImpl.updateCarInfo(carInfo)){
				resp.getWriter().print(1);
			}
		}
		if(op.equals("jjzz")){
			String uid=req.getParameter("uid");
			String cuid=req.getParameter("cuid");
			String cid=req.getParameter("cid");
			PerSonCar perSonCar=new PerSonCar();
			perSonCar.setU_id(Long.parseLong(uid));
			perSonCar.setC_id(Long.parseLong(cid));
			perSonCar.setC_uid(Long.parseLong(cuid));
			perSonCar.setP_state("��ͣ����");
			PerSonCar _PerSonCar=new PerSonCar();
			_PerSonCar.setU_id(Long.parseLong(cuid));
			_PerSonCar.setC_id(Long.parseLong(cid));
			_PerSonCar.setC_uid(Long.parseLong(cuid));
			_PerSonCar.setP_state("��ͣ����");
			if(perSonCarService.updatePerSoncar(_PerSonCar, "����")&&perSonCarService.updatePerSoncar(perSonCar, "�Ѷ�")){
				resp.getWriter().print(1);
			}
		}
		if(op.equals("yclsrdz")){
			String id=req.getParameter("pid");
			PersonNeed personNeed=new PersonNeed();
			personNeed.setP_id(Long.parseLong(id));
			personNeed.setP_state("�Ѵ���");
			PersonNeedServiceImpl personNeedServiceImpl=new PersonNeedServiceImpl();
			if(personNeedServiceImpl.updatePersonNeed(personNeed)){
				resp.getWriter().print(1);
			}
		}
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
private void fenye(HttpServletRequest req, HttpServletResponse resp,PerSonCar perSonCar){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 int maxRowsCount=perSonCarService.queryPersonCarCount(perSonCar);
		//�����ҳ�߼�<=>����
		PageUtil pageUtil=new PageUtil(9, maxRowsCount);
		// ����ҳ���߼�
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
