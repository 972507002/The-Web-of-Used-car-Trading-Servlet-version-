package cn.com.service.impl;

import java.util.*;

import cn.com.bean.*;

import cn.com.dao.impl.*;
import cn.com.service.*;

public class BasicInfoServiceImpl implements IBasicInfoService{
private BasicInfoDaoImpl basicInfoDaoImpl=new BasicInfoDaoImpl();

@Override
public Map<Long, BasicInfo> getAllBasic() {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasic();
}

@Override
public BasicInfo getAllBasicById(CarInfo carInfo) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasicById(carInfo);
}

@Override
public boolean addBasicInfo(BasicInfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.addBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean updateBasicInfo(BasicInfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.updateBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean deletebasicinfo(BasicInfo b) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.deletebasicinfo(b)>0)
	{
		flag=true;
	}
	
	return flag;
}

@Override
public boolean deletecidbasicinfo(BasicInfo b) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.deletecidbasicinfo(b)>0)
	{
		flag=true;
	}
	
	return flag;
}

@Override
public boolean checkbasicinfo(BasicInfo b) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.checkbasicinfo(b);
}

@Override
public boolean checkcidbasicinfo(BasicInfo b) {
	// TODO Auto-generated method stub
	return  basicInfoDaoImpl.checkcidbasicinfo(b);
}
	
	
}
