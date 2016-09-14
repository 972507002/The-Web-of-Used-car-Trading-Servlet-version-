package cn.com.service;

import java.util.Map;

import cn.com.bean.Comment;
/**
 * 评论服务接口
 * @author lej
 */
public interface ICommentService {
	 /**
           * 添加评论的服务
           * @parma comment
           * @return int
           */
	public boolean addComment(Comment comment) ;
	 /**
           * 删除评论的服务
           * @parma comment
           * @return int
           */
	public boolean deleteComment(Comment comment);
	  /**
           * 获取评论的服务
           * @parma comment
           * @return Comment
           */
	public Comment getComment(Comment comment);
	  /**
           * 获取两条最新的评论的服务
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment>
           */
	public Map<Long, Comment> getTheTowComment(Comment comment,int min,int max);
	  /**
           * 修改评论的服务
           * @parma comment
           * @return int
           */
	public boolean updateComment(Comment comment);
}
