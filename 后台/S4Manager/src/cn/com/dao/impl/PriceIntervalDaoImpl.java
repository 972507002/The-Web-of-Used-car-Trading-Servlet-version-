package cn.com.dao.impl;

import java.sql.*;
import java.util.*;

import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 价格区间操作实现类
 * @author lej
 */
public class PriceIntervalDaoImpl implements IPriceIntervalDao,IPageDao{

  /**
   * 
   * 按热度获取价格区间信息的方法
   * @return Map<Integer,PriceInterval>
   */
	@Override
	public Map<Integer, PriceInterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		Map<Integer, PriceInterval> priceIntervalMap=new HashMap<Integer, PriceInterval>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from priceinterval  a order by p_count desc) b  where rownum<5)");
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
			PriceInterval priceInterval=new PriceInterval();
			priceInterval.setP_id(res.getInt("p_id"));
			priceInterval.setP_name(res.getString("p_name"));
			priceInterval.setP_count(res.getLong("p_count"));
			priceIntervalMap.put(priceInterval.getP_id(),priceInterval);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return priceIntervalMap;
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
     * 获取价格区间信息的记录总条数
     * @return int
     */		
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
                  int count=0;
		
		
		StringBuffer sql=new StringBuffer("select count(*) from priceinterval where 1=1");
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
 * 分页获取价格区间信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select   a.* from priceinterval  a  where 1=1");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
			
			sql.append(" order by p_count desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			//获取结果集
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), null);
			
		    try {
				while(res.next()){
					PriceInterval priceInterval=new PriceInterval();
					priceInterval.setP_id(res.getInt("p_id"));
					priceInterval.setP_name(res.getString("p_name"));
					priceInterval.setP_count(res.getLong("p_count"));
					brandMap.put((long)priceInterval.getP_id(),priceInterval);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return brandMap;
	}
   /**
   * 
   * 添加价格区间信息的方法
   * @return int
   */	
	@Override
	public int addPriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		String sql="insert into priceinterval values(seq_price.nextval,?,?)";
			//绑定参数
		List<Object> params=new ArrayList<Object>();
		
		params.add(priceInterval.getP_name());
		params.add(priceInterval.getP_count());
		return DbUtil.executeUpdate(sql, params);
	}
 /**
   * 
   * 删除价格区间信息的方法
   * @return int
   */
	@Override
	public int deletePriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		String sql="delete from priceinterval where p_id=?";
			//绑定参数
		params.add(priceInterval.getP_id());
		return DbUtil.executeUpdate(sql, params);
	}
  /**
   * 
   * 修改价格区间信息的方法
   * @return int
   */
	@Override
	public int updatePriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		String sql="update priceinterval set p_name=?,p_count=? where p_id=?";
			//绑定参数
		params.add(priceInterval.getP_name());
		params.add(priceInterval.getP_count());
		params.add(priceInterval.getP_id());
		return DbUtil.executeUpdate(sql, params);
	}

  /**
   * 
   * 获取价格区间信息的方法
   * @return PriceInterval
   */
	@Override
	public PriceInterval getPriceIntervalById(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
	 PriceInterval	_priceInterval=null;
		String sql="select * from priceinterval where p_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(priceInterval.getP_id());
		//获取结果集
		ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
		
	    try {
			while(res.next()){
				 _priceInterval=new PriceInterval();
				 _priceInterval.setP_id(res.getInt("p_id"));
				 _priceInterval.setP_name(res.getString("p_name"));
				 _priceInterval.setP_count(res.getLong("p_count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _priceInterval ;
	}

}
