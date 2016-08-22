package cn.com.service;

import java.util.Map;

import cn.com.bean.Comment;

public interface ICommentService {
	public boolean addComment(Comment comment) ;
	public boolean deleteComment(Comment comment);
	public Comment getComment(Comment comment);
	public Map<Long, Comment> getTheTowComment(Comment comment,int min,int max);
}
