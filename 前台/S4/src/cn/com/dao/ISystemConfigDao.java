package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;


public interface ISystemConfigDao {
	/**
	 * 获取所有系统信息
	 * @return
	 */
public Map<Long, SystemConfig> getAllSystemConfig();
/**
 * 通过Id获取系统销售信息
 * @param systemConfig
 * @return
 */
public SystemConfig getSystemConfigById(CarInfo carInfo);
public int addSystemConfig(SystemConfig systemConfig);
public int updateSystemConfig(SystemConfig systemConfig);

}
