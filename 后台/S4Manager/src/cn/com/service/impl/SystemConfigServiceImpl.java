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
	 * 获取所有系统信息的服务
	 * @return Map<Long, SystemConfig>
	 */
	@Override
	public Map<Long, SystemConfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
		return systemConfigDao.getAllSystemConfig();
	}
/**
 * 通过Id获取系统销售信息的服务
 * @param carInfo
 * @return SystemConfig
 */
	@Override
	public SystemConfig getSystemConfigById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return systemConfigDao.getSystemConfigById(carInfo);
	}
/**
 * 添加汽车系统配置信息的服务
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
 * 修改汽车系统配置信息的服务
 * @param systemConfig
 *@return boolean 
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
/**
 * 根据车主编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletesystemconfiguser(SystemConfig s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(systemConfigDao.deletesystemconfiguser(s)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecidsystemconfiguser(SystemConfig s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(systemConfigDao.deletecidsystemconfiguser(s)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	@Override
	public boolean checksystemconfiguser(SystemConfig s) {
		// TODO Auto-generated method stub
		return systemConfigDao.checksystemconfiguser(s);
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidsystemconfiguser(SystemConfig s) {
		// TODO Auto-generated method stub
		return systemConfigDao.checkcidsystemconfiguser(s);
	}

}
