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
public class CarTypeDaoImpl implements ICarTypeDao,IPageDao {
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
/**
 * 添加车型的方法
 * @return int
 */
	@Override
	public int addCarType(CarType carType) {
		// TODO Auto-generated method stub
		String sql="insert into cartype values(seq_type.nextval,?,?,?,?)";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(carType.getT_name());
		params.add(carType.getT_img());
		params.add(carType.getT_count());
		params.add(carType.getT_class());
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 删除车型的方法
 * @return int
 */
	@Override
	public int deleteCarType(CarType carType) {
		// TODO Auto-generated method stub
		String sql="delete from cartype where t_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(carType.getT_id());
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 修改车型的方法
 * @return int
 */
	@Override
	public int updateType(CarType carType) {
		// TODO Auto-generated method stub
		String sql="update cartype set t_name=?,t_count=?,t_class=? where t_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(carType.getT_name());
		params.add(carType.getT_count());
		params.add(carType.getT_class());
		params.add(carType.getT_id());
		return DbUtil.executeUpdate(sql, params);
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
     * 获取车型信息的记录总条数
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
int count=0;
		
		
		StringBuffer sql=new StringBuffer("select count(*) from cartype where 1=1");
		
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
 * 分页获取车型信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select   a.* from cartype  a  where 1=1");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
			
			sql.append(" order by t_count desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			//获取结果集
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), null);
			
		    try {
				while(res.next()){
					CarType carType=new CarType();
					carType.setT_name(res.getString("t_name"));
					carType.setT_id(res.getInt("t_id"));
					carType.setT_img(res.getString("t_img"));
					carType.setT_count(res.getLong("t_count"));
					carType.setT_class(res.getString("t_class"));
					  brandMap.put((long)carType.getT_id(),carType);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return brandMap;
	}
/**
 * 获取车型的方法
 * @return CarType
 */
	@Override
	public CarType getCarType(CarType carType) {
		// TODO Auto-generated method stub
		CarType _CarType=null;
		String sql="select * from cartype where t_id=? ";
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carType.getT_id());
		//获取结果集
		ResultSet res=	 DbUtil.executeQuery(sql.toString(), parmas);
		
	    try {
			while(res.next()){
			 _CarType=new CarType();
			 _CarType.setT_name(res.getString("t_name"));
			 _CarType.setT_id(res.getInt("t_id"));
			 _CarType.setT_img(res.getString("t_img"));
			 _CarType.setT_count(res.getLong("t_count"));
			 _CarType.setT_class(res.getString("t_class"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return _CarType;
	}

}
