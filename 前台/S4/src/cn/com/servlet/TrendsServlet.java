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
import cn.com.bean.Comment;
import cn.com.bean.PerSonCar;
import cn.com.bean.Trends;
import cn.com.service.impl.CommentServiceImpl;
import cn.com.service.impl.TrendsServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;
/**
 * 公司动态消息引擎
 * @author lej
 */
public class TrendsServlet  extends HttpServlet{
	//公司动态消息服务的引用
     TrendsServiceImpl trendsServiceImpl=new TrendsServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");//请求编码设置
		resp.setCharacterEncoding("utf-8");//响应编码设置
	String op=req.getParameter("op");//操作符
	//展示新闻列表操作
	if(op.equals("shownewslist")){
		Trends trends=new Trends();
		trends.setTr_type("新闻");
		fenye(req, resp, trends);
		req.getRequestDispatcher("news_list.jsp").forward(req, resp);
	}
	//展示新闻详情操作
	if(op.equals("showtei")){
	String tr_id=	req.getParameter("tr_id");
	Trends trends=new Trends();
	trends.setTr_id(Long.parseLong(tr_id));
 Trends _Trends=	 trendsServiceImpl.getTrendsByWhere(trends);
    req.setAttribute("_trends", _Trends);
    req.getRequestDispatcher("news_show.jsp").forward(req, resp);
	}
	//展示活动列表操作
	if(op.equals("showactive")){
		Trends trends=new Trends();
		trends.setTr_type("活动");
		fenye(req, resp, trends);
		req.getRequestDispatcher("active_list.jsp").forward(req, resp);
	}
	//展示活动详细操作
	if(op.equals("showteia")){
		String tr_id=	req.getParameter("tr_id");
		Trends trends=new Trends();
		trends.setTr_id(Long.parseLong(tr_id));
	 Trends _Trends=	 trendsServiceImpl.getTrendsByWhere(trends);
	    req.setAttribute("_trends", _Trends);
	    req.getRequestDispatcher("active_show.jsp").forward(req, resp);
		}
		//展示评论列表操作
	if(op.equals("showcom")){
		Comment comment=new Comment();
		fenyec(req, resp, comment);
		req.getRequestDispatcher("comment_list.jsp").forward(req, resp);
	}
	//展示评论详情
	if(op.equals("showcomd")){
		String tr_id=	req.getParameter("cid");
		Comment comment=new Comment();
		comment.setCid(Long.parseLong(tr_id));
		CommentServiceImpl commentServiceImpl=new CommentServiceImpl();
	comment=	commentServiceImpl.getComment(comment);
	req.setAttribute("_trends", comment);
    req.getRequestDispatcher("comment_show.jsp").forward(req, resp);
	}
	
	}
	/**
	 * 分页处理公司动态消息的方法
	 * 
	 * 
	 */
private void fenye(HttpServletRequest req, HttpServletResponse resp,Trends trends){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 int maxRowsCount=trendsServiceImpl.queryPersonCarCount(trends);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(2, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=trendsServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), trends);
		DbUtil.closeAll();
		Map<Long, Trends> _trendsMap=new HashMap<Long, Trends>();
		for(Long key:trendsMap.keySet()){
			Trends _trends=(Trends) trendsMap.get(key);
		_trendsMap.put(_trends.getTr_id() ,_trends);
		}
		req.setAttribute("trends", _trendsMap);
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
	 /**
	  * 分页处理评论信息的方法
	  * 
	  */
private void fenyec(HttpServletRequest req, HttpServletResponse resp,Comment comment){
	CommentServiceImpl commentServiceImpl=new CommentServiceImpl();
	
	try {
	int curPage=0;
	if(req.getParameter("jumpPage")!=null){
	 curPage =Integer.parseInt(req.getParameter("jumpPage"));
 }
	
	

 int maxRowsCount=commentServiceImpl.queryPersonCarCount(comment);
	//处理分页逻辑<=>调用
	PageUtil pageUtil=new PageUtil(2, maxRowsCount);
	// 处理页码逻辑
	if (curPage <= 1) {

		pageUtil.setCurPage(1);
	} else if (curPage >= pageUtil.getMaxPage()) {

		pageUtil.setCurPage(pageUtil.getMaxPage());
	} else {
		pageUtil.setCurPage(curPage);
	}
	
	
	Map<Long, Object> trendsMap=commentServiceImpl.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), comment);
	DbUtil.closeAll();
	Map<Long, Comment> _trendsMap=new HashMap<Long, Comment>();
	for(Long key:trendsMap.keySet()){
		Comment _trends=(Comment) trendsMap.get(key);
	_trendsMap.put(_trends.getCid() ,_trends);
	}
	req.setAttribute("trends", _trendsMap);
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
