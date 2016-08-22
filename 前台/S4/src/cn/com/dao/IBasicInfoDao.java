package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;

public interface IBasicInfoDao {
	/**
	 * 获取车辆信息
	 * @return
	 */
public Map<Long, BasicInfo> getAllBasic();
public BasicInfo getAllBasicById(CarInfo carInfo);
public int addBasicInfo(BasicInfo basicInfo);
public int updateBasicInfo( BasicInfo basicInfo);
}
