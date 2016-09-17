package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
/**
 * 车型服务实现类
 * @author
 */
public class CarTypeServiceImpl  implements ICarTypeService,IPageDao{
	//车型操作实现类的引用
   private CarTypeDaoImpl carTypeDao=new CarTypeDaoImpl();

        /**
	 * 按热度获取车型信息的服务
	 * @return Map<Integer,CarType>
	 */
@Override
public Map<Integer, CarType> getCarTypeByCount() {
	// TODO Auto-generated method stub
	return carTypeDao.getCarTypeByCount();
}

        /**
	 * 获取所有车型信息的服务
	 * @return  Map<Integer,CarType>
	 */
@Override
public Map<Integer, CarType> getAllCarType() {
	// TODO Auto-generated method stub
	return carTypeDao.getAllCarType();
}
/**
 * 添加车型的服务
 * @return boolean
 */
@Override
public boolean addCarType(CarType carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.addCarType(carType)>0){
		flag=true;
	}
	return flag;
}
/**
 * 删除车型的服务
 * @return boolean
 */
@Override
public boolean deleteCarType(CarType carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.deleteCarType(carType)>0){
		flag=true;
	}
	return flag;
}
/**
 * 修改车型的服务
 * @return boolean
 */
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

    /**
     * 获取车型信息的记录总条数的服务
     * @return int
     */	
@Override
public int queryPersonCarCount(Object object) {
	// TODO Auto-generated method stub
	return carTypeDao.queryPersonCarCount(object);
}

/**
 * 分页获取车型信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
@Override
public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
		Object object) {
	// TODO Auto-generated method stub
	return carTypeDao.showPersonCarList(curPage, rowsPrePage, object);
}

/**
 * 获取车型的服务
 * @return CarType
 */
@Override
public CarType getCarType(CarType carType) {
	// TODO Auto-generated method stub
	return carTypeDao.getCarType(carType);
}
}
