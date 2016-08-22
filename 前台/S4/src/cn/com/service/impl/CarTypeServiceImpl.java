package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarTypeServiceImpl  implements ICarTypeService{
   private ICarTypeDao carTypeDao=new CarTypeDaoImpl();

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
}
