package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;
import cn.com.service.IHardwareConfigService;
import cn.com.dao.impl.*;

public class HardwareConfigServiceImpl implements IHardwareConfigService{
	private HardwareConfigDaoImpl hardwareConfigDaoImpl=new HardwareConfigDaoImpl();
	@Override
	public Map<Long, HardwareConfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getAllHardwareConfig();
	}

	@Override
	public HardwareConfig getHardwareConfigById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getHardwareConfigById(carInfo);
	}

	@Override
	public boolean addHardwareConfig(HardwareConfig hardwareConfig) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.addHardwareConfig(hardwareConfig)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateHardwareConfig(HardwareConfig hardwareConfig) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.updateHardwareConfig(hardwareConfig)>0){
			flag=true;
		}
		return flag;
	}

}
