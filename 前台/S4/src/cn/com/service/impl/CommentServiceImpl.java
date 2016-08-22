package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.bean.Comment;
import cn.com.dao.IPageDao;
import cn.com.dao.impl.CommentDaoImpl;
import cn.com.service.ICommentService;

public class CommentServiceImpl implements ICommentService,IPageDao {
  private CommentDaoImpl commentDao=new CommentDaoImpl();
	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.addComment(comment)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.deleteComment(comment)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Comment getComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.getComment(comment);
	}

	@Override
	public Map<Long, Comment> getTheTowComment(Comment comment, int min, int max) {
		// TODO Auto-generated method stub
		return commentDao.getTheTowComment(comment, min, max);
	}

	@Override
	public int queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return commentDao.queryPersonCarCount(object);
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return commentDao.showPersonCarList(curPage, rowsPrePage, object);
	}

}
