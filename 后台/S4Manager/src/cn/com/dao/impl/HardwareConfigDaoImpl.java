package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;
import cn.com.dao.IHardwareConfig;
import cn.com.util.DbUtil;
/**
 * 汽车硬件配置信息操作实现类
 *@author lej 
 */
public class HardwareConfigDaoImpl implements IHardwareConfig {
  /**
   * 
   * 获取所有汽车硬件配置信息的方法
   *@return Map<Long,HardwareConfig> 
   */
	@Override
	public Map<Long, HardwareConfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
		String sql = "select * from hardwareconfig";
		Map<Long, HardwareConfig> hardMap = new HashMap<Long, HardwareConfig>();
		//获取结果集
		ResultSet res = DbUtil.executeQuery(sql, null);
		try {
			while (res.next()) {
			
				HardwareConfig hardwareConfig = new HardwareConfig();
				hardwareConfig.setU_id(res.getLong("u_id"));
				hardwareConfig.setC_id(res.getLong("c_id"));
				hardwareConfig.setConsoleLceScreen(res
						.getString("consoleLceScreen"));
				hardwareConfig.setAutoLight(res.getString("autoLight"));
				hardwareConfig.setHeadLights(res.getString("headLights"));
				hardwareConfig.setLightWash(res.getString("lightWash"));
				hardwareConfig.setEfgv(res.getString("efgv"));
				hardwareConfig.setSeatNumber(res.getInt("seatNumber"));
				hardwareConfig.setFuelForm(res.getString("fuelForm"));
				hardwareConfig.setCvt(res.getString("cvt"));
				hardwareConfig.setDrivingMethod(res.getString("drivingMethod"));
				hardwareConfig.setPke(res.getString("pke"));
				hardwareConfig.setKeyLessgo(res.getString("keyLessgo"));
				hardwareConfig.setSunRoof(res.getString("sunRoof"));
				hardwareConfig.setLeatherSeat(res.getString("leatherSeat"));
				hardMap.put(hardwareConfig.getU_id(), hardwareConfig);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hardMap;
	}
/**
 * 按编号获取汽车硬件配置信息的方法
 * @parma carInfo
 * @return HardwareConfig 
 */
	@Override
	public HardwareConfig getHardwareConfigById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		HardwareConfig hardwareConfig2 = null;
		String sql = "select * from hardwareconfig where u_id=? and c_id=?";
		//绑定参数
		List<Object> params = new ArrayList<Object>();
		params.add(carInfo.getU_id());
		params.add(carInfo.getC_id());
		//获取结果集
		ResultSet res = DbUtil.executeQuery(sql, params);
		try {
			while (res.next()) {
				hardwareConfig2 = new HardwareConfig();
				hardwareConfig2.setU_id(res.getLong("u_id"));
				hardwareConfig2.setC_id(res.getLong("c_id"));
				hardwareConfig2.setConsoleLceScreen(res
						.getString("consoleLcdScreen"));
				hardwareConfig2.setAutoLight(res.getString("autoLight"));
				hardwareConfig2.setHeadLights(res.getString("headLights"));
				hardwareConfig2.setLightWash(res.getString("lightWash"));
				hardwareConfig2.setEfgv(res.getString("efgv"));
				hardwareConfig2.setSeatNumber(res.getInt("seatNumber"));
				hardwareConfig2.setFuelForm(res.getString("fuelForm"));
				hardwareConfig2.setCvt(res.getString("cvt"));
				hardwareConfig2
						.setDrivingMethod(res.getString("drivingMethod"));
				hardwareConfig2.setPke(res.getString("pke"));
				hardwareConfig2.setKeyLessgo(res.getString("keyLessgo"));
				hardwareConfig2.setSunRoof(res.getString("sunRoof"));
				hardwareConfig2.setLeatherSeat(res.getString("leatherSeat"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hardwareConfig2;
	}
/**
 * 添加汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
	@Override
	public int addHardwareConfig(HardwareConfig hardwareConfig) {
		// TODO Auto-generated method stub
		String sql = "insert into hardwareconfig values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//绑定参数
		List<Object> params = new ArrayList<Object>();
		params.add(hardwareConfig.getU_id());
		params.add(hardwareConfig.getC_id());
		params.add(hardwareConfig.getConsoleLceScreen());
		params.add(hardwareConfig.getAutoLight());
		params.add(hardwareConfig.getHeadLights());
		params.add(hardwareConfig.getLightWash());
		params.add(hardwareConfig.getEfgv());
		params.add(hardwareConfig.getSeatNumber());
		params.add(hardwareConfig.getFuelForm());
		params.add(hardwareConfig.getCvt());
		params.add(hardwareConfig.getDrivingMethod());
		params.add(hardwareConfig.getPke());
		params.add(hardwareConfig.getKeyLessgo());
		params.add(hardwareConfig.getSunRoof());
		params.add(hardwareConfig.getLeatherSeat());

		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 修改汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
	@Override
	public int updateHardwareConfig(HardwareConfig hardwareConfig) {
		// TODO Auto-generated method stub
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				"update  hardwareconfig set consoleLcdScreen=?,autoLight=?,headLights=?,lightWash=?,efgv=?,seatNumber=?,fuelForm=?,cvt=?,drivingMethod=?,pke=?,keyLessgo=?,sunRoof=?,leatherSeat=? where u_id=? and c_id=?");
	    //绑定参数
		params.add(hardwareConfig.getConsoleLceScreen());
		params.add(hardwareConfig.getAutoLight());
		params.add(hardwareConfig.getHeadLights());
		params.add(hardwareConfig.getLightWash());
		params.add(hardwareConfig.getEfgv());
		params.add(hardwareConfig.getSeatNumber());
		params.add(hardwareConfig.getFuelForm());
		params.add(hardwareConfig.getCvt());
		params.add(hardwareConfig.getDrivingMethod());
		params.add(hardwareConfig.getPke());
		params.add(hardwareConfig.getKeyLessgo());
		params.add(hardwareConfig.getSunRoof());
		params.add(hardwareConfig.getLeatherSeat());

		params.add(hardwareConfig.getU_id());

		params.add(hardwareConfig.getC_id());

		return DbUtil.executeUpdate(sql.toString(), params);

	}
/**
 * 根据车主编号删除汽车硬件配置信息的方法
 *@return int  
 */
	@Override
	public int deletehardwareconfiguser(HardwareConfig h) {
		// TODO Auto-generated method stub
		String sql="delete from hardwareconfig where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(h.getU_id());
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 根据车编号删除汽车硬件配置信息的方法
 *@return int  
 */
	@Override
	public int deletecidhardwareconfiguser(HardwareConfig h) {
		// TODO Auto-generated method stub
		String sql="delete from hardwareconfig where c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(h.getC_id());
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车硬件配置信息
 * @return boolean
 */
	@Override
	public boolean checkhardwareconfig(HardwareConfig h) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from hardwareconfig where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(h.getU_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;  //若存在，则返回真
				break;//跳出循环
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车硬件配置信息
 * @return boolean
 */
	@Override
	public boolean checkcidhardwareconfig(HardwareConfig h) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from hardwareconfig where c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(h.getC_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true; //若存在结果集，则返回真
				break; //跳出循环
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
