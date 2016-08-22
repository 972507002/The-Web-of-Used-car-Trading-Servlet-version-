package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.*;

import cn.com.dao.ICarImagesInfoDao;
import cn.com.dao.impl.CarImagesInfoDaoImpl;
import cn.com.service.ICarImagesInfoService;

public class CarImagesInfoServiceImpl implements ICarImagesInfoService{
private ICarImagesInfoDao carImagesInfoDao=new CarImagesInfoDaoImpl();
/**
 * 通过c_id来查询车辆照片信息的业务
 */	
@Override
	public Map<Integer, String> getCarImagesInfoByID(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carImagesInfoDao.getCarImagesInfoByID( carInfo);
	}
@Override
public boolean addCarImagesInfo(CarImagesInfo carImagesInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.addCarImagesInfo(carImagesInfo)>0){
		flag=true;
	}
	return flag;
}
@Override
public boolean updateCarImagesInfo(CarImagesInfo carImagesInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.updateCarImagesInfo(carImagesInfo)>0){
		flag=true;
	}
	return flag;
}
@Override
public boolean deleteimagesinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.deleteimagesinfouser(c)>0)
	{
		flag=true;
	}
	
	return flag;
}
@Override
public boolean deletecidimagesinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.deletecidimagesinfouser(c)>0)
	{
		flag=true;
	}
	
	return flag;
}
@Override
public boolean checkimageinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	return carImagesInfoDao.checkimageinfouser(c);
}
@Override
public boolean checkcidimageinfouser(CarImagesInfo c) {
	// TODO Auto-generated method stub
	return carImagesInfoDao.checkcidimageinfouser(c);
}

}
