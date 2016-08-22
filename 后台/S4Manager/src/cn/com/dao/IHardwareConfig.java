package cn.com.dao;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.HardwareConfig;

public interface IHardwareConfig {
public Map<Long, HardwareConfig> getAllHardwareConfig();
public HardwareConfig getHardwareConfigById(CarInfo carInfo);
public int addHardwareConfig(HardwareConfig hardwareConfig);
public int updateHardwareConfig(HardwareConfig hardwareConfig);
public int deletehardwareconfiguser(HardwareConfig h);
public int deletecidhardwareconfiguser(HardwareConfig h);
public boolean checkhardwareconfig(HardwareConfig h);
public boolean checkcidhardwareconfig(HardwareConfig h);
}
