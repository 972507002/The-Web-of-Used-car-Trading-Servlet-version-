package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SystemConfig;
/**
 * 
 * 
 * 汽车系统配置信息服务接口
 * @author lej
 * /
public interface ISystemConfigService {
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
 *@return boolean 
 */
	public boolean addSystemConfig(SystemConfig systemConfig);
	/**
 * 删除汽车系统配置信息的方法
 *  @param systemConfig
 * @return boolean 
 */
	public boolean updateSystemConfig(SystemConfig systemConfig);
}
