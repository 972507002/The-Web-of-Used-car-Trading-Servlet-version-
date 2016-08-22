package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarTypeServiceImpl  implements ICarTypeService,IPageDao{
   private CarTypeDaoImpl carTypeDao=new CarTypeDaoImpl();


@Override
public Map<Integer, CarType> getCarTypeByCount() {
	// TODO Auto-generated method stub
	return carTypeDao.getCarTypeByCount();
}


@Override
public Map<Integer, CarType> getAllCarType() {
	// TODO Auto-generated method stub
	return carTypeDao.getAllCarType();
}

@Override
public boolean addCarType(CarType carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.addCarType(carType)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean deleteCarType(CarType carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.deleteCarType(carType)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean updateType(CarType carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.updateType(carType)>0){
		flag=true;
	}
	return flag;
}


@Override
public int queryMsgCount(Object object, int minPrice, int maxPrice, int minDis,
		int maxDis, int minAge, int maxAge) {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
		Object object, String order, int minPrice, int maxPrice, int minDis,
		int maxDis, int minAge, int maxAge) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public int queryPersonCarCount(Object object) {
	// TODO Auto-generated method stub
	return carTypeDao.queryPersonCarCount(object);
}


@Override
public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
		Object object) {
	// TODO Auto-generated method stub
	return carTypeDao.showPersonCarList(curPage, rowsPrePage, object);
}


@Override
public CarType getCarType(CarType carType) {
	// TODO Auto-generated method stub
	return carTypeDao.getCarType(carType);
}
}
