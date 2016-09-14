package cn.com.dao.impl;

import java.sql.*;
import java.util.*;
import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 汽车图片信息操作实现类
 * @author lej
 */
public class CarImagesInfoDaoImpl implements ICarImagesInfoDao{
/**
   * 根据编号获取汽车照片的方法
   * @parma carInfo
   * @return Map<Integer,String>
   */
	
	@Override
	public Map<Integer, String> getCarImagesInfoByID(CarInfo carInfo ) {
		// TODO Auto-generated method stub
		String sql="select * from imagesinfo where c_id=? and u_id=?";
		Map<Integer, String> imgMap=new HashMap<Integer, String>();
		//参数绑定
		List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getC_id());
		params.add(carInfo.getU_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next()){
				if(res.getString("image1")!=null&&!res.getString("image1").equals("")){
					imgMap.put(1, res.getString("image1"));
				}
				if(res.getString("image2")!=null&&!res.getString("image2").equals("")){
					imgMap.put(2, res.getString("image2"));
				}
				if(res.getString("image3")!=null&&!res.getString("image3").equals("")){
					imgMap.put(3, res.getString("image3"));
				}
				if(res.getString("image4")!=null&&!res.getString("image4").equals("")){
					imgMap.put(4, res.getString("image4"));
				}
				if(res.getString("image5")!=null&&!res.getString("image5").equals("")){
					imgMap.put(5, res.getString("image5"));
				}
				if(res.getString("image6")!=null&&!res.getString("image6").equals("")){
					imgMap.put(6, res.getString("image6"));
				}
				if(res.getString("image7")!=null&&!res.getString("image7").equals("")){
					imgMap.put(7, res.getString("image7"));
				}
				if(res.getString("image8")!=null&&!res.getString("image8").equals("")){
					imgMap.put(8, res.getString("image8"));
				}
				if(res.getString("image9")!=null&&!res.getString("image9").equals("")){
					imgMap.put(9, res.getString("image9"));
				}
				if(res.getString("image10")!=null&&!res.getString("image10").equals("")){
					imgMap.put(10, res.getString("image10"));
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgMap;
	}

/**
 * 添加照片信息的方法
 * @parma carImagesInfo
 *@reutn int 
 */
@Override
public int addCarImagesInfo(CarImagesInfo carImagesInfo) {
	// TODO Auto-generated method stub
	String sql="insert into imagesinfo values(?,?,?,?,?,?,?,?,?,?,?,?)";
	//参数绑定
	List<Object> params=new ArrayList<Object>();
	params.add(carImagesInfo.getC_id());
	params.add(carImagesInfo.getU_id());
	params.add(carImagesInfo.getImage1());
	params.add(carImagesInfo.getImage2());
	params.add(carImagesInfo.getImage3());
	params.add(carImagesInfo.getImage4());
	params.add(carImagesInfo.getImage5());
	params.add(carImagesInfo.getImage6());
	params.add(carImagesInfo.getImage7());
	params.add(carImagesInfo.getImage8());
	params.add(carImagesInfo.getImage9());
	params.add(carImagesInfo.getImage10());
	
	return DbUtil.executeUpdate(sql, params);
}

/**
 *修改照片信息的方法 
 * @parmas
 * @return int
 */
@Override
public int updateCarImagesInfo(CarImagesInfo carImagesInfo) {
	// TODO Auto-generated method stub
	List<Object> params=new ArrayList<Object>();
	StringBuffer sql=new StringBuffer("update  imagesinfo set image1=?,image2=?,image3=?,image4=?,image5=?,image6=?,image7=?,image8=?,image9=?,image10=? where u_id=? and c_id=?");
	//参数绑定
	params.add(carImagesInfo.getImage1());
	params.add(carImagesInfo.getImage2());
	params.add(carImagesInfo.getImage3());
	params.add(carImagesInfo.getImage4());
	params.add(carImagesInfo.getImage5());
	params.add(carImagesInfo.getImage6());
	params.add(carImagesInfo.getImage7());
	params.add(carImagesInfo.getImage8());
	params.add(carImagesInfo.getImage9());
	params.add(carImagesInfo.getImage10());
	
		params.add(carImagesInfo.getU_id());
	
	
		params.add(carImagesInfo.getC_id());
	
	
	return DbUtil.executeUpdate(sql.toString(), params);
}

/**
 * 根据车主编号删除汽车照片信息的方法
 *@return int  
 */
@Override
public int deleteimagesinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	String sql="delete from imagesinfo where u_id=?";
	//参数绑定
	List<Object> params=new ArrayList<Object>();
	params.add(c.getU_id());
	return DbUtil.executeUpdate(sql, params);
}

/**
 * 根据车编号删除汽车照片信息的方法
 *@return int  
 */
@Override
public int deletecidimagesinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	String sql="delete from imagesinfo where c_id=?";
	//参数绑定
	List<Object> params=new ArrayList<Object>();
	params.add(c.getC_id());
	return DbUtil.executeUpdate(sql, params);
}

/**
 * 
 * 检查是否还有与某车主编号关联的汽车照片信息
 * @return boolean
 */
@Override
public boolean checkimageinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	boolean flag=false;
	String sql="select * from imagesinfo where u_id=?";
	//绑定参数
	List<Object> params=new ArrayList<Object>();
	params.add(c.getU_id());
	//获取结果集
	ResultSet res=DbUtil.executeQuery(sql, params);
	try {
		while(res.next())
		{
			flag=true;  //若存在结果则返回真
			break; //跳出循环
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}

/**
 * 
 * 检查是否还有与某车编号关联的汽车照片信息
 * @return boolean
 */
@Override
public boolean checkcidimageinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	boolean flag=false;
	String sql="select * from imagesinfo where c_id=?";
	//参数绑定
	List<Object> params=new ArrayList<Object>();
	params.add(c.getC_id());
	//获取结果集
	ResultSet res=DbUtil.executeQuery(sql, params);
	try {
		while(res.next())
		{
			flag=true;  //若存在结果，则返回真
			break; //跳出循环
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}


	
	

}
