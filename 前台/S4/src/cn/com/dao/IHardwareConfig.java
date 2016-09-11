package cn.com.dao;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;
/**
 * 汽车硬件配置信息操作接口
 *@author lej 
 */
public interface IHardwareConfig {
  /**
   * 
   * 获取所有汽车硬件配置信息的方法
   *@return Map<Long,HardwareConfig> 
   */
public Map<Long, HardwareConfig> getAllHardwareConfig();
/**
 * 按编号获取汽车硬件配置信息的方法
 * @parma carInfo
 * @return HardwareConfig 
 */
public HardwareConfig getHardwareConfigById(CarInfo carInfo);
/**
 * 添加汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
public int addHardwareConfig(HardwareConfig hardwareConfig);
/**
 * 修改汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
public int updateHardwareConfig(HardwareConfig hardwareConfig);
}
