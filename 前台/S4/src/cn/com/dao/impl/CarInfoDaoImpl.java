package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;

/**
 * 汽车概要信息操作实现类
 * @author lej
 */
public class CarInfoDaoImpl implements ICarInfoDao,IPageDao{

/**
 * 按热度获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByCountDesc(CarInfo _carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select to_char(C_licencetime,'yyyy-mm') y, a.* from carinfo  a where a.c_state=? order by c_count desc) b  where rownum<5)");
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(_carInfo.getC_state());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				CarInfo carInfo=new CarInfo();
				carInfo.setU_id(res.getLong("u_id"));
				carInfo.setC_id(res.getLong("c_id"));
				carInfo.setC_brand(res.getString("c_brand"));
				carInfo.setC_series(res.getString("c_series"));
				carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				carInfo.setC_volume(res.getDouble("c_volume"));
				carInfo.setC_gearType(res.getString("c_gearType"));
				carInfo.setC_code(res.getString("c_code"));
				carInfo.setC_model(res.getString("c_model"));
				carInfo.setC_licencetime(res.getString("y"));
				carInfo.setC_distance(res.getDouble("c_distance"));
				carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				carInfo.setC_price(res.getDouble("c_price"));
				carInfo.setC_count(res.getLong("c_count"));
				carInfo.setC_img(res.getString("c_img"));
				carInfo.setC_type(res.getString("c_type"));
				carInfo.setC_state(res.getString("c_state"));
				carInfo.setC_sccount(res.getLong("c_sccount"));
				carInfo.setC_czzx(res.getString("c_czzx"));
				carInfo.setNewprice(res.getDouble("newprice"));
				carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(carInfo.getC_id(), carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

/**
 * 按热度和品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByBrandCountDesc(CarInfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select to_char(C_licencetime,'yyyy-mm') y, a.* from carinfo  a where a.c_brand=? and a.c_state=? order by c_count desc) b  where rownum<5)");
		//绑定参数
		 List<Object> params=new ArrayList<Object>();
		params.add( carInfo.getC_brand());
		params.add(carInfo.getC_state());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				CarInfo _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("y"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(_carInfo.getC_id(), _carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

  /**
 * 按上架时间获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoBySjTime(CarInfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  to_char(C_licencetime,'yyyy-mm') y, a.* from carinfo  a  where a.c_state=? order by c_sjtime desc ) b  where rownum<4)");
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carInfo.getC_state());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), parmas);
		try {
			while(res.next()){
				CarInfo _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("y"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(_carInfo.getC_id(), _carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

	 /**
 * 获取四辆最新上架的汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getFourthCarInfoBySjTime(CarInfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();
		StringBuffer sql=new StringBuffer("select  rownum rn ,b.* from(");
		sql.append("select * from(select rownum rn , b.* from(select to_char(C_licencetime,'yyyy-mm') y, a.* from carinfo  a where a.c_state=? order by c_sjtime desc) b  where rownum<5))b where rn>3");
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carInfo.getC_state());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), parmas);
		try {
			while(res.next()){
				CarInfo _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("y"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(_carInfo.getC_id(), _carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

 /**
 * 按热度和车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByTypeCountDesc(CarInfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();
		StringBuffer sql=new StringBuffer("select * from(select  rownum rn , b.* from");
		sql.append("(select to_char(C_licencetime,'yyyy-mm') y, a.* from carinfo  a where a.c_type=? and a.c_state=? order by c_count desc) b  where rownum<5)");
		//绑定参数
		 List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getC_type());
		params.add(carInfo.getC_state());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				CarInfo _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("y"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(_carInfo.getC_id(), _carInfo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

	 /**
 * 按品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByBrand(CarInfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();
		StringBuffer sql=new StringBuffer("select to_char(C_licencetime,'yyyy-mm') y, a.* from carinfo where a c_brand=?");
		 //绑定参数
		 List<Object> params=new ArrayList<Object>();
		params.add( carInfo.getC_brand());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				CarInfo _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("y"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(_carInfo.getC_id(), _carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

	/**
 * 按车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByType(CarInfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();
		StringBuffer sql=new StringBuffer("select to_char(C_licencetime,'yyyy-mm') y, a.* from carinfo a where c_type=?");
		 //绑定参数
		 List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getC_type());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				CarInfo _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("y"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(_carInfo.getC_id(), _carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

	/**
 * 按条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarByWhere(CarInfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, CarInfo> carInfoMap=new HashMap<Long, CarInfo>();

		StringBuffer sql=new StringBuffer("select to_char(C_licencetime,'yyyy-mm') y,a.* from carinfo a where 1=1 ");
		//动态绑定参数和修改sql语句
		List<Object> params=new ArrayList<Object>();
		if(carInfo.getC_brand()!=null){
			sql.append("and c_brand=?");
			params.add(carInfo.getC_brand());
		}
		if(carInfo.getC_series()!=null){
			sql.append("and c_series=?");
			params.add(carInfo.getC_series());
		}
		if(carInfo.getC_id()!=0){
			sql.append("and c_id=?");
			params.add(carInfo.getC_id());
		}
		if(carInfo.getU_id()!=0){
			sql.append("and u_id=?");
			params.add(carInfo.getU_id());
		}
		if(carInfo.getC_state()!=null){
			sql.append(" and c_state=?");
			params.add(carInfo.getC_state());
		}
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				CarInfo _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("y"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carInfoMap.put(_carInfo.getC_id(), _carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return carInfoMap;
	}

	/**
 * 获取符合条件的汽车概要信息记录条数
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @return   Map<Long, CarInfo>
 */
	public int queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		int count=0;
		CarInfo carInfo=(CarInfo)object;
		StringBuffer sql=new StringBuffer("select count(*) from carinfo where 1=1 ");
		//动态绑定参数和延伸sql语句
		List<Object> params=new ArrayList<Object>();
		if(carInfo.getC_brand()!=null){
			sql.append("and c_brand=?");
			params.add(carInfo.getC_brand());
		}
		if(carInfo.getC_series()!=null){
			sql.append("and c_series=?");
			params.add(carInfo.getC_series());
		}
		if(carInfo.getC_type()!=null){
			sql.append("and c_type=?");
			params.add(carInfo.getC_type());
		}
		if(carInfo.getC_state()!=null){
			sql.append(" and c_state=?");
			params.add(carInfo.getC_state());
		}
		if(carInfo.getC_emissionstandard()!=null){
			sql.append(" and c_emissionstandard=? ");
			params.add(carInfo.getC_emissionstandard());
		}
		if(minPrice!=0){
			sql.append(" and c_price>"+minPrice+"");
		}
		if(maxPrice!=0){
			sql.append(" and c_price<"+maxPrice+"");
		}
		if(minDis!=0){
			sql.append(" and c_distance>"+minDis+"");
		}
		if(maxDis!=0){
			sql.append(" and c_distance<"+maxDis+"");
		}
		if(minAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(C_licencetime,'yyyy.mm'))>"+minAge+"");
		}
		if(maxAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(C_licencetime,'yyyy.mm'))<"+maxAge+"");

		}
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), params);
	
	try {
		while(res.next()){
			count=res.getInt(1);
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
	}

		/**
 * 获取符合条件的汽车概要信息
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @parma curPage   当前页
 * @parma rowsPrePage   页面展示条数
 * @return   Map<Long, CarInfo>
 */
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		List<Object>  carMap=new ArrayList<Object>();
		CarInfo carInfo=(CarInfo) object;
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select * from( select to_char(C_licencetime,'yyyy-mm') y,a.*,rownum rn from  ");
		sql.append("(select * from carinfo where 1=1 ");
		//动态绑定参数和延伸SQL语句
		List<Object> params=new ArrayList<Object>();
		if(carInfo.getC_brand()!=null){
			sql.append(" and c_brand=?");
			params.add(carInfo.getC_brand());
		}
		if(carInfo.getC_series()!=null){
			sql.append(" and c_series=?");
			params.add(carInfo.getC_series());
		}
		if(carInfo.getC_type()!=null){
			sql.append(" and c_type=?");
			params.add(carInfo.getC_type());
		}
		if(carInfo.getC_state()!=null){
			sql.append(" and c_state=?");
			params.add(carInfo.getC_state());
		}
		if(carInfo.getC_emissionstandard()!=null){
			sql.append(" and c_emissionstandard=? ");
			params.add(carInfo.getC_emissionstandard());
		}
		if(minPrice!=0){
			sql.append(" and c_price>"+minPrice+"");
		}
		if(maxPrice!=0){
			sql.append(" and c_price<"+maxPrice+"");
		}
		if(minDis!=0){
			sql.append(" and c_distance>"+minDis+"");
		}
		if(maxDis!=0){
			sql.append(" and c_distance<"+maxDis+"");
		}
		if(minAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(C_licencetime,'yyyy.mm'))>"+minAge+"");
		}
		if(maxAge!=0){
			sql.append(" and to_number(to_char(sysdate,'yyyy.mm'))-to_number(to_char(C_licencetime,'yyyy.mm'))<"+maxAge+"");

		}
		if(order!=null){
			sql.append(" order by "+order+" ");
			if(order.equals("c_count")){
				sql.append(" desc");
			}
			if(order.equals("c_sccount")){
				sql.append(" desc");
			}
		}
		//获取结果集
		sql.append(")a where rownum<=("+curPage*rowsPrePage+"))");
		sql.append("where rn>("+curPage+"-1)*"+rowsPrePage+"");
		
	ResultSet res=	DbUtil.executeQuery(sql.toString(), params);
	
	try {
		while(res.next()){
			CarInfo _carInfo=new CarInfo();
			_carInfo.setU_id(res.getLong("u_id"));
			_carInfo.setC_id(res.getLong("c_id"));
			_carInfo.setC_brand(res.getString("c_brand"));
			_carInfo.setC_series(res.getString("c_series"));
			_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
			_carInfo.setC_volume(res.getDouble("c_volume"));
			_carInfo.setC_gearType(res.getString("c_gearType"));
			_carInfo.setC_code(res.getString("c_code"));
			_carInfo.setC_model(res.getString("c_model"));
			_carInfo.setC_licencetime(res.getString("y"));
			_carInfo.setC_distance(res.getDouble("c_distance"));
			_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
			_carInfo.setC_price(res.getDouble("c_price"));
			_carInfo.setC_count(res.getLong("c_count"));
			_carInfo.setC_img(res.getString("c_img"));
			_carInfo.setC_type(res.getString("c_type"));
			_carInfo.setC_state(res.getString("c_state"));
			_carInfo.setC_sccount(res.getLong("c_sccount"));
			_carInfo.setC_czzx(res.getString("c_czzx"));
			_carInfo.setNewprice(res.getDouble("newprice"));
			_carInfo.setC_mcsj(res.getString("c_mcsj"));
			carMap.add( _carInfo);
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return carMap;
	}

	
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	 /**
   * 修改汽车概要信息的方法
   * @parma carInfo
   * @return int
   */
	public int updateCarInfo(CarInfo carInfo) {
		// TODO Auto-generated method stub
		
		StringBuffer sql=new StringBuffer("update carinfo set c_id=? ");
		//动态绑定参数和延伸SQL语句
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carInfo.getC_id());
		if(carInfo.getC_count()!=0){
			sql.append(" ,c_count=?");
			parmas.add(carInfo.getC_count());
		}
		if(carInfo.getC_sccount()!=0){
			sql.append(" ,c_sccount=?");
			parmas.add(carInfo.getC_sccount());
		}
		if(carInfo.getC_state()!=null){
			sql.append(" ,c_state=?");
			parmas.add(carInfo.getC_state());
		}
		if(carInfo.getC_mcsj()!=null){
			sql.append(" , c_mcsj=to_date(?,'yyyy-mm-dd HH24:mi:ss')");
			parmas.add(carInfo.getC_mcsj());
		}
		sql.append("where c_id=? ");
		parmas.add(carInfo.getC_id());
		
		return DbUtil.executeUpdate(sql.toString(), parmas);
	}

	 /**
   * 添加汽车概要信息的方法
   * @parma carInfo
   * @return int
   */
	public int addCarInfo(CarInfo carInfo) {
		// TODO Auto-generated method stub
		String sql="insert into carinfo values(seq_carinfo.nextval,?,?,?,?,?,?,?,?,to_date(?,'yyyy/mm'),?,?,?,?,?,to_date(?,'yyyy/mm/dd HH24:mi:ss'),?,?,?,?,0,null)";
	      //绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(carInfo.getU_id());
		parmas.add(carInfo.getC_brand());
		parmas.add(carInfo.getC_series());
		parmas.add(carInfo.getC_releaseyear());
		parmas.add(carInfo.getC_volume());
		parmas.add(carInfo.getC_gearType());
		parmas.add(carInfo.getC_code());
		parmas.add(carInfo.getC_model());
		parmas.add(carInfo.getC_licencetime());
		
		parmas.add(carInfo.getC_distance());
		parmas.add(carInfo.getC_emissionstandard());
		parmas.add(carInfo.getC_price());
		parmas.add(carInfo.getC_count());
		parmas.add(carInfo.getC_img());
		parmas.add(carInfo.getC_sjtime());
		
		parmas.add(carInfo.getC_type());
		parmas.add(carInfo.getC_state());
		parmas.add(carInfo.getC_sccount());
		parmas.add(carInfo.getC_czzx());
		return DbUtil.executeUpdate(sql, parmas);
	}

	 /**
 * 按唯一条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   CarInfo
 */
	public CarInfo getCarInfoByUMN(CarInfo carInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from carinfo  a where a.u_id=? order by c_sjtime desc) b  where rownum<2)");
		 //绑定参数
		 List<Object> parmas=new ArrayList<Object>();
		 parmas.add(carInfo.getU_id());
		 CarInfo _carInfo=null;
		 //获取结果集
		ResultSet res= DbUtil.executeQuery(sql.toString(), parmas);
		 try {
				while(res.next()){
					 _carInfo=new CarInfo();
					_carInfo.setU_id(res.getLong("u_id"));
					_carInfo.setC_id(res.getLong("c_id"));
					_carInfo.setC_brand(res.getString("c_brand"));
					_carInfo.setC_series(res.getString("c_series"));
					_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
					_carInfo.setC_volume(res.getDouble("c_volume"));
					_carInfo.setC_gearType(res.getString("c_gearType"));
					_carInfo.setC_code(res.getString("c_code"));
					_carInfo.setC_model(res.getString("c_model"));
					_carInfo.setC_licencetime(res.getString("c_licencetime"));
					_carInfo.setC_distance(res.getDouble("c_distance"));
					_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
					_carInfo.setC_price(res.getDouble("c_price"));
					_carInfo.setC_count(res.getLong("c_count"));
					_carInfo.setC_img(res.getString("c_img"));
					_carInfo.setC_type(res.getString("c_type"));
					_carInfo.setC_state(res.getString("c_state"));
					_carInfo.setC_sccount(res.getLong("c_sccount"));
					_carInfo.setC_czzx(res.getString("c_czzx"));
					_carInfo.setNewprice(res.getDouble("newprice"));
					_carInfo.setC_mcsj(res.getString("c_mcsj"));
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return _carInfo;
	}

 /**
   * 修改汽车所有概要信息的方法
   * @parma carInfo
   * @return int
   */
	public int updateCarAll(CarInfo carInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update carinfo set c_brand=?,c_series=?,c_releaseyear=?,c_volume=?,c_geartype=?,c_code=?,c_model=?,c_licencetime=to_date(?,'yyyy/mm'),c_distance=?,c_emissionstandard=?,c_price=?,c_img=?,c_type=?,c_czzx=? where c_id=?");
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		
		parmas.add(carInfo.getC_brand());
		parmas.add(carInfo.getC_series());
		parmas.add(carInfo.getC_releaseyear());
		parmas.add(carInfo.getC_volume());
		parmas.add(carInfo.getC_gearType());
		parmas.add(carInfo.getC_code());
		parmas.add(carInfo.getC_model());
		parmas.add(carInfo.getC_licencetime());
		
		parmas.add(carInfo.getC_distance());
		parmas.add(carInfo.getC_emissionstandard());
		parmas.add(carInfo.getC_price());
		parmas.add(carInfo.getC_img());
		
		parmas.add(carInfo.getC_type());
		parmas.add(carInfo.getC_czzx());
		parmas.add(carInfo.getC_id());
		return DbUtil.executeUpdate(sql.toString(), parmas);
	}

	 /**
   * 根据用户编号删除汽车概要信息
   * @parma carInfo
   * @return int
   */
	public int deletecarinfouser(CarInfo u) {
		// TODO Auto-generated method stub
		String sql="delete from carinfo where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(u.getU_id());
		return DbUtil.executeUpdate(sql, params);
	}

  /**
   * 感觉汽车编号删除汽车概要信息
   * @parma carInfo
   * @return int
   */
	public int deletecarinfo(CarInfo c) {
		// TODO Auto-generated method stub
		String sql="delete from carinfo where c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(c.getC_id());
		
		
		return DbUtil.executeUpdate(sql, params);
	}

 /**
   * 检查某用户编号是否有与其相关的汽车概要信息
   * @parma carInfo
   * @return int
   */
	public boolean checkcarinfouser(CarInfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from carinfo where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(c.getU_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			if(res.next())  //如果有则为真
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

  /**
   * 获取热度最高的10辆车
   * @parma carInfo
   * @return List<CarInfo>
   */
	@Override
	public List<CarInfo> getTenCount(CarInfo carInfo) {
		// TODO Auto-generated method stub
		String sql="select * from (select  rownum ,a.* from carinfo a  where c_state='在售'  order by c_count desc ) where rownum <11";
		List<CarInfo> carMap=new ArrayList<CarInfo>(); 
	ResultSet res=	DbUtil.executeQuery(sql, null);
	try {
		while(res.next()){
		CarInfo	 _carInfo=new CarInfo();
				_carInfo.setU_id(res.getLong("u_id"));
				_carInfo.setC_id(res.getLong("c_id"));
				_carInfo.setC_brand(res.getString("c_brand"));
				_carInfo.setC_series(res.getString("c_series"));
				_carInfo.setC_releaseyear(res.getInt("c_releaseyear"));
				_carInfo.setC_volume(res.getDouble("c_volume"));
				_carInfo.setC_gearType(res.getString("c_gearType"));
				_carInfo.setC_code(res.getString("c_code"));
				_carInfo.setC_model(res.getString("c_model"));
				_carInfo.setC_licencetime(res.getString("c_licencetime"));
				_carInfo.setC_distance(res.getDouble("c_distance"));
				_carInfo.setC_emissionstandard(res.getString("c_emissionstandard"));
				_carInfo.setC_price(res.getDouble("c_price"));
				_carInfo.setC_count(res.getLong("c_count"));
				_carInfo.setC_img(res.getString("c_img"));
				_carInfo.setC_type(res.getString("c_type"));
				_carInfo.setC_state(res.getString("c_state"));
				_carInfo.setC_sccount(res.getLong("c_sccount"));
				_carInfo.setC_czzx(res.getString("c_czzx"));
				_carInfo.setNewprice(res.getDouble("newprice"));
				_carInfo.setC_mcsj(res.getString("c_mcsj"));
				carMap.add(_carInfo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return carMap;
	}

/**
   * 获取销量最高10个品牌
   * @parma carInfo
   * @return List<CarInfo>
   */
	@Override
	public List<CarInfo> getTenBrandCar(CarInfo carInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select rownum, a.* from( select  count(*) c,c_brand from carinfo b where c_state='交易完成' group by c_brand ) ");
		sql.append("  a where rownum<11 ");
		List<CarInfo> carMap=new ArrayList<CarInfo>(); 
		ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
		try {
			while(res.next()){
			CarInfo	 _carInfo=new CarInfo();
					
					_carInfo.setC_brand(res.getString("c_brand"));
					
					_carInfo.setC_count(res.getLong("c"));
					
					carMap.add(_carInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return carMap;
	}
  
}
