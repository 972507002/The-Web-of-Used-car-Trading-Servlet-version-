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

import cn.com.bean.Comment;
import cn.com.bean.Trends;
import cn.com.service.impl.CommentServiceImpl;
import cn.com.service.impl.TrendsServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;
 /**
  * 公司动态消息管理引擎
  * 
  */
public class TrendsServlet  extends HttpServlet{
	//公司动态消息服务实现类的引用
     TrendsServiceImpl trendsServiceImpl=new TrendsServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8"); //设置请求编码
		resp.setCharacterEncoding("utf-8"); //设置响应编码
	String op=req.getParameter("op");  //命令操作物
	  //展示新闻列表
	if(op.equals("shownewslist")){
		Trends trends=new Trends();
		trends.setTr_type("新闻");
		fenye(req, resp, trends);
		req.getRequestDispatcher("admin/news.jsp").forward(req, resp);
	}
	 //展示新闻详情
	if(op.equals("showtei")){
	String tr_id=	req.getParameter("tr_id");
	Trends trends=new Trends();
	trends.setTr_id(Long.parseLong(tr_id));
 Trends _Trends=	 trendsServiceImpl.getTrendsByWhere(trends);
    req.setAttribute("_trends", _Trends);
    req.getRequestDispatcher("news_show.jsp").forward(req, resp);
	}
	 //展示活动列表
	if(op.equals("showactive")){
		Trends trends=new Trends();
		trends.setTr_type("活动");
		fenye(req, resp, trends);
		req.getRequestDispatcher("admin/active.jsp").forward(req, resp);
	}
	//展示活动详情
	if(op.equals("showteia")){
		String tr_id=	req.getParameter("tr_id");
		Trends trends=new Trends();
		trends.setTr_id(Long.parseLong(tr_id));
	 Trends _Trends=	 trendsServiceImpl.getTrendsByWhere(trends);
	    req.setAttribute("_trends", _Trends);
	    req.getRequestDispatcher("active_show.jsp").forward(req, resp);
		}
		//展示所有动态消息
	if(op.equals("showalltrends")){
		Trends trends=new Trends();
		
		fenye(req, resp, trends);
		req.getRequestDispatcher("admin/alltrends.jsp").forward(req, resp);
	}
	//添加动态消息
	if(op.equals("addtrends")){
		String title=req.getParameter("maxAge");
		String text=req.getParameter("zm");
		String type=req.getParameter("sel1");
		String img=req.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTr_title(title);
		trends.setTr_text(text);
		trends.setTr_type(type);
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date=new Date();
	   trends.setTr_date(dateFormat.format(date));
	   trends.setTr_img("");
	   if(img!=null&&!img.equals("")){
		   trends.setTr_img("tepimages/"+img);
         }
	   if(trendsServiceImpl.addTrends(trends)){
		   req.setAttribute("mea", "添加成功");
		   req.getRequestDispatcher("admin/alltrend-add.jsp").forward(req, resp);
	   }
	    
	}
	//请求修改动态消息
	if(op.equals("uptrends")){
		String id=req.getParameter("tid");
		Trends trends=new Trends();
		trends.setTr_id(Long.parseLong(id));
	trends=	trendsServiceImpl.getTrendsByWhere(trends);
	
	session.setAttribute("utrends",trends );
	resp.sendRedirect("admin/alltrend-up.jsp");
	}
	//提交修改动态消息
	if(op.equals("tjuptrends")){
		String id=req.getParameter("tid");
		
		String title=req.getParameter("maxAge");
		String text=req.getParameter("zm");
		String type=req.getParameter("sel1");
		String img=req.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTr_title(title);
		trends.setTr_text(text);
		trends.setTr_type(type);
		trends.setTr_id(Long.parseLong(id));
		
	   trends.setTr_img(req.getParameter("qtp"));
	   if(img!=null&&!img.equals("")){
		 
          
	           
			   trends.setTr_img("tepimages/"+img);
		
         }
	   if(trendsServiceImpl.updateTrends(trends)){
		   session.setAttribute("utrends",trends );
		   session.setAttribute("tmea","修改成功" );
			resp.sendRedirect("admin/alltrend-up.jsp");
	   }
	}
	//删除动态消息
	if(op.equals("deltrends")){
		String id=req.getParameter("tid");
		Trends trends=new Trends();
		trends.setTr_id(Long.parseLong(id));
		if(trendsServiceImpl.deleteTrends(trends)){
			resp.getWriter().print(1);
		}
	}
	//添加新闻
	if(op.equals("addnews")){
		String title=req.getParameter("maxAge");
		String text=req.getParameter("zm");
		
		String img=req.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTr_title(title);
		trends.setTr_text(text);
		trends.setTr_type("新闻");
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date=new Date();
	   trends.setTr_date(dateFormat.format(date));
	   trends.setTr_img("");
	   if(img!=null&&!img.equals("")){
		   trends.setTr_img("tepimages/"+img);
         }
	   if(trendsServiceImpl.addTrends(trends)){
		   req.setAttribute("mea", "添加成功");
		   req.getRequestDispatcher("admin/allnews-add.jsp").forward(req, resp);
	   }
	}
	//请求修改新闻
	if(op.equals("upnews")){
		String id=req.getParameter("tid");
		Trends trends=new Trends();
		trends.setTr_id(Long.parseLong(id));
	trends=	trendsServiceImpl.getTrendsByWhere(trends);
	
	session.setAttribute("utrends",trends );
	resp.sendRedirect("admin/allnews-up.jsp");
	}
	//提交修改新闻
	if(op.equals("tjupnews")){
		String id=req.getParameter("tid");
		
		String title=req.getParameter("maxAge");
		String text=req.getParameter("zm");
		
		String img=req.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTr_title(title);
		trends.setTr_text(text);
		trends.setTr_type("新闻");
		trends.setTr_id(Long.parseLong(id));
		
		   trends.setTr_img(req.getParameter("qtp"));
	   if(img!=null&&!img.equals("")){
		 
         
           
		   trends.setTr_img("tepimages/"+img);
         }
	   if(trendsServiceImpl.updateTrends(trends)){
		   session.setAttribute("utrends",trends );
		   session.setAttribute("tmea","修改成功" );
			resp.sendRedirect("admin/allnews-up.jsp");
	   }
	}
	//添加活动
	if(op.equals("addactive")){
		String title=req.getParameter("maxAge");
		String text=req.getParameter("zm");
		
		String img=req.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTr_title(title);
		trends.setTr_text(text);
		trends.setTr_type("活动");
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date=new Date();
	   trends.setTr_date(dateFormat.format(date));
	   trends.setTr_img("");
	   if(img!=null&&!img.equals("")){
		   trends.setTr_img("tepimages/"+img);
         }
	   if(trendsServiceImpl.addTrends(trends)){
		   req.setAttribute("mea", "添加成功");
		   req.getRequestDispatcher("admin/active-add.jsp").forward(req, resp);
	   }
	}
	//请求修改活动
	if(op.equals("upactive")){
		String id=req.getParameter("tid");
		Trends trends=new Trends();
		trends.setTr_id(Long.parseLong(id));
	trends=	trendsServiceImpl.getTrendsByWhere(trends);
	
	session.setAttribute("utrends",trends );
	resp.sendRedirect("admin/active-up.jsp");
	}
	//提交修改活动
	if(op.equals("tjupactive")){
		String id=req.getParameter("tid");
		
		String title=req.getParameter("maxAge");
		String text=req.getParameter("zm");
		
		String img=req.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTr_title(title);
		trends.setTr_text(text);
		trends.setTr_type("活动");
		trends.setTr_id(Long.parseLong(id));
		
		   trends.setTr_img(req.getParameter("qtp"));
	   if(img!=null&&!img.equals("")){
		
         
           
		   trends.setTr_img("tepimages/"+img);
         }
	   if(trendsServiceImpl.updateTrends(trends)){
		   session.setAttribute("utrends",trends );
		   session.setAttribute("tmea","修改成功" );
			resp.sendRedirect("admin/active-up.jsp");
	   }
	}
	//展示评价
	if(op.equals("showcom")){
		Comment comment=new Comment();
		fenyec(req, resp, comment);
		req.getRequestDispatcher("admin/comment.jsp").forward(req, resp);
	}
	//修改评价
	if(op.equals("upcom")){
		String cid=req.getParameter("cid");
		Comment comment=new Comment();
		comment.setCid(Long.parseLong(cid));
		CommentServiceImpl commentServiceImpl=new CommentServiceImpl();
		comment=commentServiceImpl.getComment(comment);
		session.setAttribute("ucomment", comment);
		
		resp.sendRedirect("admin/comment-up.jsp");
	}
	//提交修改评价
	if(op.equals("tjupcom")){
		String cid=req.getParameter("cid");
		String bt=req.getParameter("maxAge");
		String admin=req.getParameter("sel1");
		Comment comment=new Comment();
		comment.setCid(Long.parseLong(cid));
		comment.setC_bt(bt);
		comment.setC_admin(admin);
		comment.setC_img(req.getParameter("qtp"));	
		String img=req.getParameter("ttp");
	   if(img!=null&&!img.equals("")){     
		   comment.setC_img("tepimages/"+img);
         }
	   CommentServiceImpl commentServiceImpl=new CommentServiceImpl();
	   if(commentServiceImpl.updateComment(comment)){
		   session.setAttribute("ucomment", comment);
		   session.setAttribute("cmea", "修改成功");
			resp.sendRedirect("admin/comment-up.jsp");
	   }
	}
	//删除评价
	if(op.equals("delcom")){
		String cid=req.getParameter("cid");
		Comment comment=new Comment();
		comment.setCid(Long.parseLong(cid));
		CommentServiceImpl commentServiceImpl=new CommentServiceImpl();
		if(commentServiceImpl.deleteComment(comment)){
			resp.getWriter().print(1);
		}
	}
	}
	/**
	 * 分页展示动态消息的方法
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
		PageUtil pageUtil=new PageUtil(3, maxRowsCount);
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
	  * 分页展示评价的方法
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
	PageUtil pageUtil=new PageUtil(9, maxRowsCount);
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
