package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.bean.Comment;
import cn.com.dao.ICommentDao;
import cn.com.dao.IPageDao;
import cn.com.util.DbUtil;

public class CommentDaoImpl implements ICommentDao,IPageDao{

	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		String sql="insert into comment1 values(?,?,to_date(?,'yyyy-mm-dd HH24:mi:ss'),seq_com.nextval,null,null,null)";
		List<Object> params=new ArrayList<Object>();
		params.add(comment.getUid());
		params.add(comment.getC_text());
		params.add(comment.getC_date());
		
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public int deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		String sql="delete from comment1 where c_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(comment.getCid());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public Comment getComment(Comment comment) {
		// TODO Auto-generated method stub
		Comment _comment=null;
		String sql="select * from comment1 where c_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(comment.getCid());
	ResultSet res=	DbUtil.executeQuery(sql, params);
	try {
		while(res.next()){
			_comment=new Comment();
			_comment.setCid(res.getLong("c_id"));
			_comment.setUid(res.getLong("u_id"));
			_comment.setC_text(res.getString("c_text"));
			_comment.setC_date(res.getString("c_date"));
			_comment.setC_img(res.getString("c_img"));
			_comment.setC_bt(res.getString("c_bt"));
			_comment.setC_admin(res.getString("c_admin"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return _comment;
	}

	@Override
	public Map<Long, Comment> getTheTowComment(Comment comment,int min,int max) {
		// TODO Auto-generated method stub
		Map<Long, Comment> comMap=new HashMap<Long, Comment>();
		
		StringBuffer sql=new StringBuffer();
		sql.append("select * from(select rownum rn , b.* from(select  to_char(c_date,'yyyy-mm-dd  HH24:mi:ss') y, a.* from comment1  a ");
		sql.append("where c_admin=? ");
		sql.append(" order by c_date desc ) b  where rownum<="+max+") where rn>"+min+"");
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(comment.getC_admin());
	ResultSet res=	DbUtil.executeQuery(sql.toString(),parmas );
	try {
		while(res.next()){
			Comment _comment=new Comment();
			_comment.setCid(res.getLong("c_id"));
			_comment.setUid(res.getLong("u_id"));
			_comment.setC_text(res.getString("c_text"));
			_comment.setC_date(res.getString("y"));
			_comment.setC_img(res.getString("c_img"));
			_comment.setC_bt(res.getString("c_bt"));
			_comment.setC_admin(res.getString("c_admin"));
			comMap.put(_comment.getCid(), _comment);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return comMap;
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
		int count=0;
		
		StringBuffer sql=new StringBuffer("select count(*) from comment1 where 1=1");
		
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
		count=	res.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select  to_char(c_date,'yyyy-mm-dd HH24:mi:ss') y, a.* from comment1  a  where 1=1");
		 Map<Long, Object> trendsMap=new HashMap<Long, Object>();
			

			
			sql.append(" order by c_date desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), null);
			
		    try {
				while(res.next()){
					Comment _comment=new Comment();
					_comment.setCid(res.getLong("c_id"));
					_comment.setUid(res.getLong("u_id"));
					_comment.setC_text(res.getString("c_text"));
					_comment.setC_date(res.getString("y"));
					_comment.setC_img(res.getString("c_img"));
					_comment.setC_bt(res.getString("c_bt"));
					_comment.setC_admin(res.getString("c_admin"));
					trendsMap.put(_comment.getCid(),_comment);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trendsMap;
	}

	@Override
	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		String sql="update comment1 set c_bt=?,c_img=?,c_admin=? where c_id=?" ;
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(comment.getC_bt());
		parmas.add(comment.getC_img());
		parmas.add(comment.getC_admin());
		parmas.add(comment.getCid());
		return DbUtil.executeUpdate(sql, parmas);
	}

	
}
