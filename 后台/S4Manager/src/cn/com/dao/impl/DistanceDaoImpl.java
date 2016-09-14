package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 行驶距离操作实现类
 *@author lej 
 */
public class DistanceDaoImpl implements IDistanceDao,IPageDao {

   /**
    * 
    * 按热度获取行驶距离信息的方法
    *@return Map<Integer,Distance> 
    */
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Distance> distanceMap=new HashMap<Integer, Distance>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from distance  a order by d_count desc) b  where rownum<5)");
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
			Distance distance=new Distance();
			distance.setD_id(res.getInt("d_id"));
			distance.setD_name(res.getString("d_name"));
			distance.setD_count(res.getLong("d_count"));
			distanceMap.put(distance.getD_id(),distance);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return distanceMap;
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
     * 获取行驶距离信息的记录总条数
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
int count=0;
		
		
		StringBuffer sql=new StringBuffer("select count(*) from distance where 1=1");
		//获取结果集
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

/**
 * 分页获取行驶距离信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select   a.* from distance  a  where 1=1");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
			
			sql.append(" order by d_count desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
		    //获取结果集
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), null);
			
		    try {
				while(res.next()){
					Distance distance=new Distance();
					distance.setD_id(res.getInt("d_id"));
					distance.setD_name(res.getString("d_name"));
					distance.setD_count(res.getLong("d_count"));
					
					brandMap.put((long)distance.getD_id(),distance);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return brandMap;
	}
	/**
           * 添加行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int addDistance(Distance distance) {
		// TODO Auto-generated method stub
		String sql="insert into distance values(seq_dis.nextval,?,?)";
		//参数绑定
		List<Object> params=new ArrayList<Object>();
		
		params.add(distance.getD_name());
		params.add(distance.getD_count());
		return DbUtil.executeUpdate(sql, params);
	}
          /**
           * 删除行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int deleteDistance(Distance distance) {
		// TODO Auto-generated method stub
		//参数绑定
		List<Object> params=new ArrayList<Object>();
		String sql="delete from distance where d_id=?";
		params.add(distance.getD_id());
		return DbUtil.executeUpdate(sql, params);
	}
          /**
           * 修改行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		String sql="update distance set d_name=?,d_count=? where d_id=?";
		//参数绑定
		params.add(distance.getD_name());
		params.add(distance.getD_count());
		params.add(distance.getD_id());
		return DbUtil.executeUpdate(sql, params);
	}
    /**
    * 
    * 按编号获取行驶距离信息的方法
    *@return Distance
    */
	@Override
	public Distance getDistanceById(Distance distance) {
		// TODO Auto-generated method stub
		String sql="select * from distance where d_id=?";
		Distance _Distance=null;
		//参数绑定
		List<Object> params=new ArrayList<Object>();
		params.add(distance.getD_id());
		//获取结果集
		ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
		
	    try {
			while(res.next()){
				_Distance=new Distance();
				_Distance.setD_id(res.getInt("d_id"));
				_Distance.setD_name(res.getString("d_name"));
				_Distance.setD_count(res.getLong("d_count"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _Distance;
	}

}
