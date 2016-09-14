package cn.com.service.impl;

import java.util.*;

import cn.com.bean.*;

import cn.com.dao.impl.*;
import cn.com.service.*;
/**
 * 汽车基本信息服务实现类
 * @author lej
 */
public class BasicInfoServiceImpl implements IBasicInfoService{
	//汽车基础信息操作实现类的引用
private BasicInfoDaoImpl basicInfoDaoImpl=new BasicInfoDaoImpl();
/**
 * 获取所有基本信息的服务
 * @return Map<Long, BasicInfo>
 */
@Override
public Map<Long, BasicInfo> getAllBasic() {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasic();
}
/**
 *根据编号获取汽车基本信息的服务
 *@return BasicInfo
 */
@Override
public BasicInfo getAllBasicById(CarInfo carInfo) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasicById(carInfo);
}
/**
 * 添加汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean addBasicInfo(BasicInfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.addBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}
/**
 * 修改汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean updateBasicInfo(BasicInfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.updateBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}
/**
 * 根据车主编号删除汽车基本信息的服务
 *@return boolean  
 */
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
/**
 * 根据车编号删除汽车基本信息的服务
 *@return boolean  
 */
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
/**
 * 检查是否还有与某车主编号关联的汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean checkbasicinfo(BasicInfo b) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.checkbasicinfo(b);
}
/**
 * 检查是否还有与某车编号关联的汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean checkcidbasicinfo(BasicInfo b) {
	// TODO Auto-generated method stub
	return  basicInfoDaoImpl.checkcidbasicinfo(b);
}
	
	
}
