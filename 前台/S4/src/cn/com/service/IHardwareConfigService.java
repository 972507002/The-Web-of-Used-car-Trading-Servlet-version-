package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;

public interface IHardwareConfigService {
	public Map<Long, HardwareConfig> getAllHardwareConfig();
	public HardwareConfig getHardwareConfigById(CarInfo carInfo);
	public boolean addHardwareConfig(HardwareConfig hardwareConfig);
	public boolean updateHardwareConfig(HardwareConfig hardwareConfig);
}
