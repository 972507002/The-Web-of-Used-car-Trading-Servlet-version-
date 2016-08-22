package cn.com.service;

import java.util.Map;

import cn.com.bean.BasicInfo;
import cn.com.bean.CarInfo;

public interface IBasicInfoService {
	public Map<Long, BasicInfo> getAllBasic();
	public BasicInfo getAllBasicById(CarInfo carInfo);
	public boolean addBasicInfo(BasicInfo basicInfo);
	public boolean updateBasicInfo(BasicInfo basicInfo);
	 public boolean deletebasicinfo(BasicInfo b);
	 public boolean deletecidbasicinfo(BasicInfo b);
	 public boolean checkbasicinfo(BasicInfo b);
	 public boolean checkcidbasicinfo(BasicInfo b);
}
