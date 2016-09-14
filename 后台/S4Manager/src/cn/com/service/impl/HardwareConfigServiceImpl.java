package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;
import cn.com.service.IHardwareConfigService;
import cn.com.dao.impl.*;
/**
 * 汽车硬件配置信息服务实现类
 *@author lej 
 */
public class HardwareConfigServiceImpl implements IHardwareConfigService{
	//汽车硬件配置信息操作实现类的引用
	private HardwareConfigDaoImpl hardwareConfigDaoImpl=new HardwareConfigDaoImpl();
  /**
   * 
   * 获取所有汽车硬件配置信息的服务
   *@return Map<Long,HardwareConfig> 
   */
	@Override
	public Map<Long, HardwareConfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getAllHardwareConfig();
	}
/**
 * 按编号获取汽车硬件配置信息的服务
 * @parma carInfo
 * @return HardwareConfig 
 */
	@Override
	public HardwareConfig getHardwareConfigById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getHardwareConfigById(carInfo);
	}
/**
 * 添加汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	@Override
	public boolean addHardwareConfig(HardwareConfig hardwareConfig) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.addHardwareConfig(hardwareConfig)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 修改汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	@Override
	public boolean updateHardwareConfig(HardwareConfig hardwareConfig) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.updateHardwareConfig(hardwareConfig)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 根据车主编号删除汽车硬件配置信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletehardwareconfiguser(HardwareConfig h) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.deletehardwareconfiguser(h)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车编号删除汽车硬件配置信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecidhardwareconfiguser(HardwareConfig h) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.deletecidhardwareconfiguser(h)>0)
		{
			flag=true;
		}
		
		return flag;
	}
 /**
 * 
 * 检查是否还有与某车主编号关联的汽车硬件配置信息的服务
 * @return boolean
 */
	@Override
	public boolean checkhardwareconfig(HardwareConfig h) {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.checkhardwareconfig(h);
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车硬件配置信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidhardwareconfig(HardwareConfig h) {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.checkcidhardwareconfig(h);
	}

}
