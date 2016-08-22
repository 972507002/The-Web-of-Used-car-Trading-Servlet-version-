package cn.com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bean.PersonNeed;
import cn.com.bean.UserInfo;
import cn.com.service.impl.PersonNeedServiceImpl;
import cn.com.service.impl.UserInfoServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

public class ManagerServlet extends HttpServlet {
         UserInfoServiceImpl userInfoServiceImpl=new UserInfoServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
	String op=req.getParameter("op");
	if(op.equals("showalluser")){
		UserInfo userInfo=new UserInfo();
		fenye(req, resp, userInfo);
		req.setAttribute("titile", "所有用户");
		req.getRequestDispatcher("admin/user.jsp").forward(req, resp);
	}
	if(op.equals("showadmin")){
		UserInfo userInfo=new UserInfo();
		userInfo.setU_admin("管理员");
		fenye(req, resp, userInfo);
		req.setAttribute("titile", "管理员");
		req.getRequestDispatcher("admin/admin.jsp").forward(req, resp);
	}
	if(op.equals("showuser")){
		UserInfo userInfo=new UserInfo();
		userInfo.setU_admin("普通用户");
		fenye(req, resp, userInfo);
		req.setAttribute("titile", "普通用户");
		req.getRequestDispatcher("admin/putong.jsp").forward(req, resp);
	}
	if(op.equals("showsrdz")){
		PersonNeed personNeed=new PersonNeed();
		
		this.fenyepn(req, resp, personNeed);
		DbUtil.closeAll();
		req.getRequestDispatcher("admin/srdz.jsp").forward(req, resp);
		
	}
	if(op.equals("showclzsrdz")){
		PersonNeed personNeed=new PersonNeed();
		personNeed.setP_state("处理中");
		this.fenyepn(req, resp, personNeed);
		DbUtil.closeAll();
		req.getRequestDispatcher("admin/clz.jsp").forward(req, resp);
		
	}
	if(op.equals("showyclsrdz")){
		PersonNeed personNeed=new PersonNeed();
		personNeed.setP_state("已处理");
		this.fenyepn(req, resp, personNeed);
		DbUtil.closeAll();
		req.getRequestDispatcher("admin/ycl.jsp").forward(req, resp);
		
	}
	
	}
private void fenye(HttpServletRequest req, HttpServletResponse resp,UserInfo userInfo){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 int maxRowsCount=userInfoServiceImpl.queryPersonCarCount(userInfo);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(6, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=userInfoServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), userInfo);
		DbUtil.closeAll();
		Map<Long, UserInfo> _usersMap=new HashMap<Long, UserInfo>();
		for(Long key:trendsMap.keySet()){
			UserInfo _userInfo=(UserInfo) trendsMap.get(key);
			_usersMap.put(_userInfo.getU_id() ,_userInfo);
		}
		req.setAttribute("showuser", _usersMap);
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
}
