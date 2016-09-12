package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.bean.Comment;
import cn.com.dao.IPageDao;
import cn.com.dao.impl.CommentDaoImpl;
import cn.com.service.ICommentService;
/**
 * 评论服务实现类
 * @author lej
 */
public class CommentServiceImpl implements ICommentService,IPageDao {
	//评论操作接口的引用
  private CommentDaoImpl commentDao=new CommentDaoImpl();
          /**
           * 添加评论的服务
           * @parma comment
           * @return boolean
           */
	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.addComment(comment)>0){
			flag=true;
		}
		return flag;
	}
         /**
           * 删除评论的服务
           * @parma comment
           * @return boolean
           */
	@Override
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.deleteComment(comment)>0){
			flag=true;
		}
		return flag;
	}
          /**
           * 获取评论的服务
           * @parma comment
           * @return Comment
           */
	@Override
	public Comment getComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.getComment(comment);
	}
            /**
           * 获取两条最新的评论的服务
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment>
           */
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
      /**
      *获取评论的总记录条数 
      * @param curPage当前页
      * @param rowsPrePage
      * @return List<Object>
      */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return commentDao.queryPersonCarCount(object);
	}
       /**
      *分页获取评论
      * @param curPage当前页
      * @param rowsPrePage
      * @return Map<Long, Object>
      */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return commentDao.showPersonCarList(curPage, rowsPrePage, object);
	}

}
