package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 车龄信息操作实现类
 *@author  lej 
 */
public class CarAgeDaoImpl implements ICarAgeDao{
  	/**
	 * 按热度获取车龄信息的方法
	 * @return Map<Integer,CarAge>
	 */
	@Override
	public Map<Integer, CarAge> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, CarAge> carAgeMap=new HashMap<Integer, CarAge>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from carage  a order by a_count desc) b  where rownum<6)");
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
			CarAge carAge=new CarAge();
			carAge.setA_id(res.getInt("a_id"));
			carAge.setA_name(res.getString("a_name"));
			carAge.setA_count(res.getLong("a_count"));
			carAgeMap.put(carAge.getA_id(),carAge);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return carAgeMap;
	}

}
