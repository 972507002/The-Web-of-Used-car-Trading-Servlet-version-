package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SystemConfig;
import cn.com.dao.ISystemConfigDao;
import cn.com.dao.impl.SystemConfigDaoImpl;
import cn.com.service.ISystemConfigService;
/**
 * 
 * 
 * 汽车系统配置信息服务实现类
 * @author lej
 */
public class SystemConfigServiceImpl implements ISystemConfigService{
	//汽车系统配置操作接口的引用
	private ISystemConfigDao systemConfigDao=new SystemConfigDaoImpl();
        /**
	 * 获取所有系统信息
	 * @return Map<Long, SystemConfig>
	 */
	@Override
	public Map<Long, SystemConfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
		return systemConfigDao.getAllSystemConfig();
	}
/**
 * 通过Id获取系统销售信息
 * @param systemConfig
 * @return carInfo
 */
	@Override
	public SystemConfig getSystemConfigById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return systemConfigDao.getSystemConfigById(carInfo);
	}
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return boolean 
 */
	@Override
	public boolean addSystemConfig(SystemConfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.addSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return boolean 
 */
	@Override
	public boolean updateSystemConfig(SystemConfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.updateSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}

}
