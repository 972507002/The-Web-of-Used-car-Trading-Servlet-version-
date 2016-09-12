package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;

/**
 * 
 * 
 * 汽车系统配置信息操作接口
 * @author lej
 * /
public interface ISystemConfigDao {
	/**
	 * 获取所有系统信息
	 * @return Map<Long, SystemConfig>
	 */
public Map<Long, SystemConfig> getAllSystemConfig();
/**
 * 通过Id获取系统销售信息
 * @param systemConfig
 * @return carInfo
 */
public SystemConfig getSystemConfigById(CarInfo carInfo);
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return int 
 */
public int addSystemConfig(SystemConfig systemConfig);
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return int 
 */
public int updateSystemConfig(SystemConfig systemConfig);

}
