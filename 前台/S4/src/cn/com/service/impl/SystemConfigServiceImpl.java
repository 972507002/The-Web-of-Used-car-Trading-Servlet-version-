package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SystemConfig;
import cn.com.dao.ISystemConfigDao;
import cn.com.dao.impl.SystemConfigDaoImpl;
import cn.com.service.ISystemConfigService;

public class SystemConfigServiceImpl implements ISystemConfigService{
	private ISystemConfigDao systemConfigDao=new SystemConfigDaoImpl();
	/**
	 * ��ȡ����SystemConfig��ϵ�ҵ��
	 * @return
	 */
	@Override
	public Map<Long, SystemConfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
		return systemConfigDao.getAllSystemConfig();
	}
	/**
	 * ͨ��u��ID��ȡSystemConfig
	 * @param systemConfig
	 * @return
	 */
	@Override
	public SystemConfig getSystemConfigById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return systemConfigDao.getSystemConfigById(carInfo);
	}
	@Override
	public boolean addSystemConfig(SystemConfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.addSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}
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
