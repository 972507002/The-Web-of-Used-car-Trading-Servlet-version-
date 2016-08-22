package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;

public interface IBasicInfoDao {
	/**
	 * ��ȡ������Ϣ
	 * @return
	 */
public Map<Long, BasicInfo> getAllBasic();
public BasicInfo getAllBasicById(CarInfo carInfo);
public int addBasicInfo(BasicInfo basicInfo);
public int updateBasicInfo( BasicInfo basicInfo);
}
