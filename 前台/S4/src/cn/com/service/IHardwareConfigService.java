package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;
/**
 * 汽车硬件配置信息服务接口
 *@author lej 
 */
public interface IHardwareConfigService {
  /**
   * 
   * 获取所有汽车硬件配置信息的服务
   *@return Map<Long,HardwareConfig> 
   */
	public Map<Long, HardwareConfig> getAllHardwareConfig();
/**
 * 按编号获取汽车硬件配置信息的服务
 * @parma carInfo
 * @return HardwareConfig 
 */
	public HardwareConfig getHardwareConfigById(CarInfo carInfo);
/**
 * 添加汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	public boolean addHardwareConfig(HardwareConfig hardwareConfig);
/**
 * 修改汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	public boolean updateHardwareConfig(HardwareConfig hardwareConfig);
}
