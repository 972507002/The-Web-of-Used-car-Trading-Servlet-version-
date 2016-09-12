package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 车型操作实现类
 * @author
 */
public class CarTypeDaoImpl implements ICarTypeDao {
        /**
	 * 按热度获取车型信息的方法
	 * @return Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, CarType> getCarTypeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, CarType> carTypeMap=new HashMap<Integer, CarType>();
		 StringBuffer sql= new StringBuffer("select rownum,b.*  from");
		   sql.append("(select * from cartype order by t_count desc)b ");
		   sql.append("where rownum<7");
		      //获取结果集
		ResultSet res=   DbUtil.executeQuery(sql.toString(), null);
		try {
			while(res.next()){
				CarType carType=new CarType();
				carType.setT_name(res.getString("t_name"));
				carType.setT_id(res.getInt("t_id"));
				carType.setT_img(res.getString("t_img"));
				carType.setT_count(res.getLong("t_count"));
				carType.setT_class(res.getString("t_class"));
				carTypeMap.put(carType.getT_id(), carType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return carTypeMap;
	}

	/**
	 * 获取所有车型信息的方法
	 * @return  Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, CarType> getAllCarType() {
		// TODO Auto-generated method stub
		Map<Integer, CarType> carTypeMap=new HashMap<Integer, CarType>();
		 StringBuffer sql= new StringBuffer("select * from cartype where 1=1 ");
		   
		   //获取结果集
		ResultSet res=   DbUtil.executeQuery(sql.toString(), null);
		try {
			while(res.next()){
				CarType carType=new CarType();
				carType.setT_name(res.getString("t_name"));
				carType.setT_id(res.getInt("t_id"));
				carType.setT_img(res.getString("t_img"));
				carType.setT_count(res.getLong("t_count"));
				carType.setT_class(res.getString("t_class"));
				carTypeMap.put(carType.getT_id(), carType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return carTypeMap;
	}

}
