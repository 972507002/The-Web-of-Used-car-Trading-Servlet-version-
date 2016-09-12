package cn.com.dao;

import java.util.Map;

import cn.com.bean.Comment;
/**
 * 评论操作接口
 * @author lej
 */
public interface ICommentDao {
          /**
           * 添加评论的方法
           * @parma comment
           * @return int
           */
          public int addComment(Comment comment);
          /**
           * 删除评论的方法
           * @parma comment
           * @return int
           */
          public int deleteComment(Comment comment);
          /**
           * 获取评论的方法
           * @parma comment
           * @return Comment
           */
          public Comment getComment(Comment comment);
          /**
           * 获取两条最新的评论的方法
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment>
           */
          public Map<Long, Comment> getTheTowComment(Comment  comment,int min,int max);
        
}
