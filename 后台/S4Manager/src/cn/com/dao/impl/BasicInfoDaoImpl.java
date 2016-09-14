package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 汽车基本信息操作实现类
 * @author lej
 */
public class BasicInfoDaoImpl implements IBasicInfoDao{
/**
 * 获取所有基本信息的方法
 * @return Map<Long, BasicInfo>
*/
	@Override
	public Map<Long, BasicInfo> getAllBasic() {
		// TODO Auto-generated method stub
		Map<Long, BasicInfo> mapBasicInfo=new HashMap<Long, BasicInfo>();
		String sql="select to_char(aidd,'yyyy-mm') ai,to_char(srdt,'yyyy-mm') sr ,to_char(domf,'yyyy-mm') do, a.* from basicinfo a";
		ResultSet res=DbUtil.executeQuery(sql, null);
		try {
			while(res.next()){
				BasicInfo basicInfo=new BasicInfo();
				basicInfo.setC_id(res.getLong("c_id"));
				basicInfo.setU_id(res.getLong("u_id"));
				basicInfo.setCimd(res.getString("cimd"));
				basicInfo.setAidd(res.getString("ai"));
				basicInfo.setSrdt(res.getString("sr"));
				basicInfo.setBodyColor(res.getString("bodycolor"));
				
				basicInfo.setInteriorColor(res.getString("interiorcolor"));
				basicInfo.setDomf(res.getString("do"));
				basicInfo.setOrgin(res.getString("orgin"));
				mapBasicInfo.put(basicInfo.getC_id(), basicInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapBasicInfo;
	}

/**
 *根据编号获取汽车基本信息的方法 
 *@return BasicInfo
 */
	@Override
	public BasicInfo getAllBasicById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		BasicInfo basicInfo2=null;
		String sql="select to_char(aidd,'yyyy-mm') ai,to_char(srdt,'yyyy-mm') sr ,to_char(domf,'yyyy-mm') do,  a.* from basicinfo a where u_id=? and c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getU_id());
		params.add(carInfo.getC_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next()){
				basicInfo2=new BasicInfo();
				basicInfo2.setC_id(res.getLong("c_id"));
				basicInfo2.setU_id(res.getLong("u_id"));
				basicInfo2.setCimd(res.getString("cimd"));
				basicInfo2.setAidd(res.getString("ai"));
				basicInfo2.setSrdt(res.getString("sr"));
				basicInfo2.setBodyColor(res.getString("bodycolor"));
				basicInfo2.setInteriorColor(res.getString("interiorcolor"));
				basicInfo2.setDomf(res.getString("do"));
				basicInfo2.setOrgin(res.getString("orgin"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basicInfo2;
	}

/**
 * 添加汽车基本信息的方法
 * @return int
 */
	@Override
	public int addBasicInfo(BasicInfo basicInfo) {
		// TODO Auto-generated method stub
		String sql="insert into basicinfo values(?,?,to_date(?,'yyyy/mm'),to_date(?,'yyyy/mm'),?,?,to_date(?,'yyyy/mm'),?,?)";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add( basicInfo.getU_id());
		params.add( basicInfo.getC_id());
		params.add( basicInfo.getAidd());
		params.add( basicInfo.getSrdt());
		params.add( basicInfo.getBodyColor());
		params.add( basicInfo.getInteriorColor());
		params.add( basicInfo.getDomf());
		params.add( basicInfo.getOrgin());
		params.add( basicInfo.getCimd());
		int count=DbUtil.executeUpdate(sql, params);
		return count;
	}

/**
 * 修改汽车基本信息的方法
 * @return int
 */
	@Override
	public int updateBasicInfo(BasicInfo basicInfo) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("update  basicinfo set aidd=to_date(?,'yyyy/mm'),srdt=to_date(?,'yyyy/mm'),bodycolor=?,interiorcolor=?,domf=to_date(?,'yyyy/mm'),orgin=?,cimd=? where u_id=? and c_id=? ");
		//绑定参数
		params.add(basicInfo.getAidd());
		params.add(basicInfo.getSrdt());
		params.add(basicInfo.getBodyColor());
		params.add(basicInfo.getInteriorColor());
		params.add(basicInfo.getDomf());
		params.add(basicInfo.getOrgin());
		params.add(basicInfo.getCimd());
	    params.add(basicInfo.getU_id());
	    params.add(basicInfo.getC_id());

		return DbUtil.executeUpdate(sql.toString(), params);
	}

/**
 * 根据车主编号删除汽车基本信息的方法
 *@return int  
 */
	@Override
	public int deletebasicinfo(BasicInfo b) {
		// TODO Auto-generated method stub
		String sql="delete from basicinfo where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(b.getU_id());
		return DbUtil.executeUpdate(sql, params);
	}

/**
 * 根据车编号删除汽车基本信息的方法
 *@return int  
 */
	@Override
	public int deletecidbasicinfo(BasicInfo b) {
		// TODO Auto-generated method stub
		String sql="delete from basicinfo where c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(b.getC_id());
		return DbUtil.executeUpdate(sql, params);
	}

/**
 * 
 * 检查是否还有与某车主编号关联的汽车基本信息
 * @return boolean
 */	
	@Override
	public boolean checkbasicinfo(BasicInfo b) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from basicinfo where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(b.getU_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;
			      break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

/**
 * 
 * 检查是否还有与某车编号关联的汽车基本信息
 * @return boolean
 */
	@Override
	public boolean checkcidbasicinfo(BasicInfo b) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from basicinfo where c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(b.getC_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
