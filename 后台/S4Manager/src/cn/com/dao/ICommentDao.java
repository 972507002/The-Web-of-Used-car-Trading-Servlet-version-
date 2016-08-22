package cn.com.dao;

import java.util.Map;

import cn.com.bean.Comment;

public interface ICommentDao {
          public int addComment(Comment comment);
          public int deleteComment(Comment comment);
          public Comment getComment(Comment comment);
          public Map<Long, Comment> getTheTowComment(Comment  comment,int min,int max);
        public int updateComment(Comment comment);
}
