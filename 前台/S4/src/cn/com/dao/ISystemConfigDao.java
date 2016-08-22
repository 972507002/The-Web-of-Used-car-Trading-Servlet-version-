package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;


public interface ISystemConfigDao {
	/**
	 * ��ȡ����ϵͳ��Ϣ
	 * @return
	 */
public Map<Long, SystemConfig> getAllSystemConfig();
/**
 * ͨ��Id��ȡϵͳ������Ϣ
 * @param systemConfig
 * @return
 */
public SystemConfig getSystemConfigById(CarInfo carInfo);
public int addSystemConfig(SystemConfig systemConfig);
public int updateSystemConfig(SystemConfig systemConfig);

}
