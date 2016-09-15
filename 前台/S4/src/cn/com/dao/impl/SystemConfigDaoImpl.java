package cn.com.dao.impl;

import java.util.*;
import java.sql.*;

import cn.com.bean.CarInfo;
import cn.com.bean.SystemConfig;
import cn.com.dao.ISystemConfigDao;
import cn.com.util.DbUtil;
/**
 * 
 * 
 * 汽车系统配置信息操作实现类
 * @author lej
 */
public class SystemConfigDaoImpl implements ISystemConfigDao{
        /**
	 * 获取所有系统信息
	 * @return Map<Long, SystemConfig>
	 */
	@Override
	public Map<Long, SystemConfig> getAllSystemConfig() {
		// TODO Auto-generated method stub

		Map<Long, SystemConfig> systemConfigMap=new HashMap<Long, SystemConfig>();
		String sql="select * from systemconfig";
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, null);
		try {
			while(res.next()){
				SystemConfig systemConfig=new SystemConfig();
				systemConfig.setU_id(res.getLong("u_id"));
				systemConfig.setC_id(res.getLong("c_id"));
				systemConfig.setGuidanceSystem(res.getString("guidanceSystem"));
				systemConfig.setAlb(res.getString("alb"));
				systemConfig.setFpg(res.getString("fpg"));
				systemConfig.setRpg(res.getString("rpg"));
				systemConfig.setRcpa(res.getString("rcpa"));
				systemConfig.setDsea(res.getString("dsea"));
				systemConfig.setFsea(res.getString("fsea"));
				systemConfig.setDlcc(res.getString("dlcc"));
				systemConfig.setHfs(res.getString("hfs"));
				systemConfig.setHrs(res.getString("hrs"));
				systemConfig.setFsv(res.getString("fsv"));
				systemConfig.setRsv(res.getString("rsv"));
				systemConfig.setFsm(res.getString("fsm"));
				systemConfig.setRsm(res.getString("rsm"));
				systemConfig.setRvmh(res.getString("rvmh"));
				systemConfig.setEss(res.getString("ess"));
				systemConfigMap.put(systemConfig.getU_id(), systemConfig);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemConfigMap;
	}
/**
 * 通过Id获取系统信息
 * @param systemConfig
 * @return carInfo
 */
	@Override
	public SystemConfig getSystemConfigById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		SystemConfig systemConfig2=null;
		String sql="select * from systemconfig where u_id=? and c_id=?";
	       //绑定参数
	       	List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getU_id());
		params.add(carInfo.getC_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next()){
				systemConfig2=new SystemConfig();
				systemConfig2.setU_id(res.getLong("u_id"));
				systemConfig2.setC_id(res.getLong("c_id"));
				systemConfig2.setGuidanceSystem(res.getString("guidanceSystem"));
				systemConfig2.setAlb(res.getString("alb"));
				systemConfig2.setFpg(res.getString("fpg"));
				systemConfig2.setRpg(res.getString("rpg"));
				systemConfig2.setRcpa(res.getString("rcpa"));
				systemConfig2.setDsea(res.getString("dsea"));
				systemConfig2.setFsea(res.getString("fsea"));
				systemConfig2.setDlcc(res.getString("dlcc"));
				systemConfig2.setHfs(res.getString("hfs"));
				systemConfig2.setHrs(res.getString("hrs"));
				systemConfig2.setFsv(res.getString("fsv"));
				systemConfig2.setRsv(res.getString("rsv"));
				systemConfig2.setFsm(res.getString("fsm"));
				systemConfig2.setRsm(res.getString("rsm"));
				systemConfig2.setRvmh(res.getString("rvmh"));
				systemConfig2.setEss(res.getString("ess"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemConfig2;
	}
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return int 
 */
@Override
public int addSystemConfig(SystemConfig systemConfig) {
	// TODO Auto-generated method stub
	String sql="insert into systemconfig values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//绑定参数
	List< Object> params=new ArrayList< Object>();
	params.add(systemConfig.getU_id());
	params.add( systemConfig.getC_id());
	params.add( systemConfig.getGuidanceSystem());
	params.add( systemConfig.getAlb());
	params.add( systemConfig.getFpg());
	params.add( systemConfig.getRpg());
	params.add( systemConfig.getRcpa());
	params.add( systemConfig.getDsea());
	params.add( systemConfig.getFsea());
	params.add( systemConfig.getDlcc());
	params.add( systemConfig.getHfs());
	params.add( systemConfig.getHrs());
	params.add( systemConfig.getFsv());
	params.add( systemConfig.getRsv());
	params.add( systemConfig.getFsm());
	params.add( systemConfig.getRsm());
	params.add( systemConfig.getRvmh());
	params.add( systemConfig.getEss());
    
	return DbUtil.executeUpdate(sql, params);
}
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return int 
 */
@Override
public int updateSystemConfig(SystemConfig systemConfig) {
	// TODO Auto-generated method stub
	List<Object> params=new ArrayList<Object>();
	StringBuffer sql=new StringBuffer("update  systemconfig set guidanceSystem=?,alb=?,fpg=?,rpg=?,rcpa=?,dsea=?,fsea=?,dlcc=?,hfs=?,hrs=?,fsv=?,rsv=?,fsm=?,rsm=?,rvmh=?,ess=? where u_id=? and c_id=? ");
       //绑定参数
      	params.add(systemConfig.getGuidanceSystem());
	params.add(systemConfig.getAlb());
	params.add(systemConfig.getFpg());
	params.add(systemConfig.getRpg());
	params.add(systemConfig.getRcpa());
	params.add(systemConfig.getDsea());
	params.add(systemConfig.getFsea());
	params.add(systemConfig.getDlcc());
	params.add(systemConfig.getHfs());
	params.add(systemConfig.getHrs());
	params.add(systemConfig.getFsv());
	params.add(systemConfig.getRsv());
	params.add(systemConfig.getFsm());
	params.add(systemConfig.getRsm());
	params.add(systemConfig.getRvmh());
	params.add(systemConfig.getEss());
	
		params.add(systemConfig.getU_id());
	
	
		params.add(systemConfig.getC_id());
	
	return DbUtil.executeUpdate(sql.toString(), params);
}

}
