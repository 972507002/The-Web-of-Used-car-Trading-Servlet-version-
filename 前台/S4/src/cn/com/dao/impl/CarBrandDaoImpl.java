package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class CarBrandDaoImpl implements ICarBrandDao {

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
		  ResultSet res= DbUtil.executeQuery(sql.toString(), null);
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
	public CarBrand getBrandByName(CarBrand carBrand) {
		// TODO Auto-generated method stub
		 CarBrand _carBrand=null;
		   StringBuffer sql= new StringBuffer("select * from carbrand where b_name=? ");
		   List<Object> parmas=new ArrayList<Object>();
		   parmas.add(carBrand.getB_name());
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
 
}
