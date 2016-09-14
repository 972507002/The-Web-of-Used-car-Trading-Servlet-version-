package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SystemConfig;
/**
 * 
 * 
 * 汽车系统配置信息服务接口
 * @author lej
 */
public interface ISystemConfigService {
        /**
	 * 获取所有系统信息的服务
	 * @return Map<Long, SystemConfig>
	 */
	public Map<Long, SystemConfig> getAllSystemConfig();
/**
 * 通过Id获取系统销售信息的服务
 * @param carInfo
 * @return SystemConfig
 */
	public SystemConfig getSystemConfigById(CarInfo carInfo);
/**
 * 添加汽车系统配置信息的服务
 * @param systemConfig
 *@return boolean 
 */
	public boolean addSystemConfig(SystemConfig systemConfig);
/**
 * 修改汽车系统配置信息的服务
 * @param systemConfig
 *@return boolean 
 */
	public boolean updateSystemConfig(SystemConfig systemConfig);
/**
 * 根据车主编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	 public boolean deletesystemconfiguser(SystemConfig s);
/**
 * 根据车编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	 public boolean deletecidsystemconfiguser(SystemConfig s);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	 public boolean checksystemconfiguser(SystemConfig s);
/**
 * 
 * 检查是否还有与某车编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	 public boolean checkcidsystemconfiguser(SystemConfig s);
}
