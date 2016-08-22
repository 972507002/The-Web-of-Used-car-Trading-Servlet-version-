package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SystemConfig;

public interface ISystemConfigService {
	/**
	 * 获取所有SystemConfig结合的业务
	 * @return
	 */
	public Map<Long, SystemConfig> getAllSystemConfig();
	/**
	 * 通过u—ID获取SystemConfig
	 * @param systemConfig
	 * @return
	 */
	public SystemConfig getSystemConfigById(CarInfo carInfo);
	public boolean addSystemConfig(SystemConfig systemConfig);
	public boolean updateSystemConfig(SystemConfig systemConfig);
}
