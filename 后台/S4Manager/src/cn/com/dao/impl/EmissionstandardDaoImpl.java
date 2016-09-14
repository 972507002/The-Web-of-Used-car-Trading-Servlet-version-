package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 
 * 排放标准操作实现类
 *@author  lej
 */
public class EmissionstandardDaoImpl implements IEmissionstandardDao,IPageDao {
        /**
	 * 按热度获取排放标准信息的方法
	 * @return Map<Integer,Emissionstandard>
	 */
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from emissionstandard  a order by e_count desc) b  where rownum<6)");
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
			Emissionstandard emissionstandard=new Emissionstandard();
			emissionstandard.setE_id(res.getInt("e_id"));
			emissionstandard.setE_name(res.getString("e_name"));
			emissionstandard.setE_count(res.getLong("e_count"));
			emissionstandardMap.put(emissionstandard.getE_id(),emissionstandard);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return emissionstandardMap;
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
     * 获取排放标准信息的记录总条数
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
int count=0;
		
		
		StringBuffer sql=new StringBuffer("select count(*) from emissionstandard where 1=1");
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
 * 分页获取排放标准信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select   a.* from emissionstandard  a  where 1=1");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
			
			sql.append(" order by e_count desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			//获取结果集
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), null);
			
		    try {
				while(res.next()){
					Emissionstandard emissionstandard=new Emissionstandard();
					emissionstandard.setE_id(res.getInt("e_id"));
					emissionstandard.setE_name(res.getString("e_name"));
					emissionstandard.setE_count(res.getLong("e_count"));
					brandMap.put((long)emissionstandard.getE_id(),emissionstandard);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return brandMap;
	}
          /**
           * 添加排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		String sql="insert into  emissionstandard values(seq_emis.nextval,?,?)";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(emissionstandard.getE_name());
		params.add(emissionstandard.getE_count());
	return	DbUtil.executeUpdate(sql, params);
	}
          /**
           * 删除排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		String sql="delete from emissionstandard where e_id=? ";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(emissionstandard.getE_id());
		return DbUtil.executeUpdate(sql, params);
	}
          /**
           * 修改排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		String sql="update emissionstandard set e_name=?,e_count=? where e_id=? ";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(emissionstandard.getE_name());
		params.add(emissionstandard.getE_count());
		params.add(emissionstandard.getE_id());
	return	DbUtil.executeUpdate(sql, params);
	}
        /**
	 * 获取排放标准信息的方法
	 * @return Emissionstandard
	 */
	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		Emissionstandard _Emissionstandard=null;
		String sql="select * from emissionstandard where e_id=? ";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(emissionstandard.getE_id());
		//获取结果集
		ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
		
	    try {
			while(res.next()){
				 _Emissionstandard=new Emissionstandard();
				 _Emissionstandard.setE_id(res.getInt("e_id"));
				 _Emissionstandard.setE_name(res.getString("e_name"));
				 _Emissionstandard.setE_count(res.getLong("e_count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _Emissionstandard;
	}

}
