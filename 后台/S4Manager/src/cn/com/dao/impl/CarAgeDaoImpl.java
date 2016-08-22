package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class CarAgeDaoImpl implements ICarAgeDao,IPageDao{
  
	
	@Override
	public Map<Integer, CarAge> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, CarAge> carAgeMap=new HashMap<Integer, CarAge>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from carage  a order by a_count desc) b  where rownum<6)");
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
		
		
		StringBuffer sql=new StringBuffer("select count(*) from carage where 1=1");
		
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
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select   a.* from carage  a  where 1=1");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
			
			sql.append(" order by a_count desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), null);
			
		    try {
				while(res.next()){
					CarAge carAge=new CarAge();
					carAge.setA_id(res.getInt("a_id"));
					carAge.setA_name(res.getString("a_name"));
					carAge.setA_count(res.getLong("a_count"));
					brandMap.put((long)carAge.getA_id(),carAge);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return brandMap;
	}

//	private int a_id;
//	 private String a_name;
//	 private long a_count;
	@Override
	public int addCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		String sql="insert into carage values(seq_age.nextval,?,?)";
		List<Object> params=new ArrayList<Object>();
		
		params.add(carAge.getA_name());
		params.add(carAge.getA_count());
		return DbUtil.executeUpdate(sql, params);
	}


	@Override
	public int deleteCarAge(CarAge carAge) {
		// TODO Auto-generated method stub 
		String sql="delete from carage where a_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(carAge.getA_id());
		return DbUtil.executeUpdate(sql, params);
	}


	@Override
	public int updateCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		String sql="update carage set a_name=?,a_count=? where a_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(carAge.getA_name());
		params.add(carAge.getA_count());
		params.add(carAge.getA_id());
		return DbUtil.executeUpdate(sql, params);
	}


	@Override
	public CarAge getCarAgeById(CarAge carAge) {
		// TODO Auto-generated method stub
		CarAge _CarAge=null;
		String sql="select * from carage where a_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(carAge.getA_id());
		ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
		
	    try {
			while(res.next()){
				 _CarAge=new CarAge();
				 _CarAge.setA_id(res.getInt("a_id"));
				 _CarAge.setA_name(res.getString("a_name"));
				 _CarAge.setA_count(res.getLong("a_count"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _CarAge;
	}

}
