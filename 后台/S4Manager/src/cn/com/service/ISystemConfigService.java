package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SystemConfig;

public interface ISystemConfigService {
	/**
	 * ��ȡ����SystemConfig��ϵ�ҵ��
	 * @return
	 */
	public Map<Long, SystemConfig> getAllSystemConfig();
	/**
	 * ͨ��u��ID��ȡSystemConfig
	 * @param systemConfig
	 * @return
	 */
	public SystemConfig getSystemConfigById(CarInfo carInfo);
	public boolean addSystemConfig(SystemConfig systemConfig);
	public boolean updateSystemConfig(SystemConfig systemConfig);
	 public boolean deletesystemconfiguser(SystemConfig s);
	 public boolean deletecidsystemconfiguser(SystemConfig s);
	 public boolean checksystemconfiguser(SystemConfig s);
	 public boolean checkcidsystemconfiguser(SystemConfig s);
}
