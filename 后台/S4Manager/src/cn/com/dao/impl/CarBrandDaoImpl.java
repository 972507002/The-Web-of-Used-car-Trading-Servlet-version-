package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class CarBrandDaoImpl implements ICarBrandDao,IPageDao {

	
	@Override
	public Map<Integer, CarBrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
	   Map<Integer, CarBrand> carBrandMap=new HashMap<Integer, CarBrand>();
	   StringBuffer sql= new StringBuffer("select rownum,b.*  from");
	   sql.append("(select * from carbrand order by b_count desc)b ");
	   sql.append("where rownum<8");
	  ResultSet res= DbUtil.executeQuery(sql.toString(), null);
	  try {
		while(res.next()){
			  CarBrand carBrand=new CarBrand();
			  carBrand.setB_id(res.getInt("b_id"));
			  carBrand.setB_name(res.getString("b_name"));
			  carBrand.setB_count(res.getLong("b_count"));
			  carBrand.setB_img(res.getString("b_img"));
			  carBrand.setB_szm(res.getString("b_szm"));
			  carBrandMap.put(carBrand.getB_id(), carBrand);
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return carBrandMap;
	}


	@Override
	public Map<Integer, CarBrand> getAllBrand() {
		// TODO Auto-generated method stub
		 Map<Integer, CarBrand> carBrandMap=new HashMap<Integer, CarBrand>();
		   StringBuffer sql= new StringBuffer("select * from carbrand");
		  ResultSet res= DbUtil.executeQuery(sql.toString(), null);
		  try {
			while(res.next()){
				  CarBrand carBrand=new CarBrand();
				  carBrand.setB_id(res.getInt("b_id"));
				  carBrand.setB_name(res.getString("b_name"));
				  carBrand.setB_count(res.getLong("b_count"));
				  carBrand.setB_img(res.getString("b_img"));
				  carBrand.setB_szm(res.getString("b_szm"));
				  carBrandMap.put(carBrand.getB_id(), carBrand);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return carBrandMap;
	}

	
	@Override
	public CarBrand getBrandByID(CarBrand carBrand) {
		// TODO Auto-generated method stub
		   CarBrand _carBrand=null;
		   StringBuffer sql= new StringBuffer("select * from carbrand where b_id=? ");
		   List<Object> parmas=new ArrayList<Object>();
		   parmas.add(carBrand.getB_id());
		  ResultSet res= DbUtil.executeQuery(sql.toString(), parmas);
		  try {
			while(res.next()){
				 _carBrand=new CarBrand();
				  _carBrand.setB_id(res.getInt("b_id"));
				  _carBrand.setB_name(res.getString("b_name"));
				  _carBrand.setB_count(res.getLong("b_count"));
				  _carBrand.setB_img(res.getString("b_img"));
				  _carBrand.setB_szm(res.getString("b_szm"));
				
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return _carBrand;
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
		
		
		StringBuffer sql=new StringBuffer("select count(*) from carbrand where 1=1");
		
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
		
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select   a.* from carbrand  a  where 1=1");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
			
			sql.append(" order by b_count desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), null);
			
		    try {
				while(res.next()){
				CarBrand	 _carBrand=new CarBrand();
					  _carBrand.setB_id(res.getInt("b_id"));
					  _carBrand.setB_name(res.getString("b_name"));
					  _carBrand.setB_count(res.getLong("b_count"));
					  _carBrand.setB_img(res.getString("b_img"));
					  _carBrand.setB_szm(res.getString("b_szm"));
					  brandMap.put((long)_carBrand.getB_id(),_carBrand);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return brandMap;
	}

//	private int b_id;
//	 private String b_name;
//	 private long b_count;
//	 private String b_img;
//	 private String b_szm;
	@Override
	public int addCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		String sql="insert into carbrand values(seq_brand.nextval,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
	
		params.add(carBrand.getB_name());
		params.add(carBrand.getB_count());
		params.add(carBrand.getB_img());
		params.add(carBrand.getB_szm());
		
		return DbUtil.executeUpdate(sql, params);
	}


	@Override
	public int updateCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		String sql="update carbrand set b_name=?,b_count=?,b_img=?,b_szm=? where b_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(carBrand.getB_name());
		params.add(carBrand.getB_count());
		params.add(carBrand.getB_img());
		params.add(carBrand.getB_szm());
		params.add(carBrand.getB_id());
		return DbUtil.executeUpdate(sql, params);
	}


	@Override
	public int deleteCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		String sql="delete from carbrand where b_id=?";
		params.add(carBrand.getB_id());
		
		return DbUtil.executeUpdate(sql, params);
	}
 
}
