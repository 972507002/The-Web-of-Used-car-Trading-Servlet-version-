package cn.com.service;

import cn.com.bean.*;

import java.util.*;


public interface ICarTypeService {
	public Map<Integer, CarType> getCarTypeByCount();
	public Map<Integer, CarType> getAllCarType();
	public boolean addCarType(CarType carType);
	public boolean deleteCarType(CarType carType);
	public boolean updateType(CarType carType);
	public CarType getCarType(CarType carType);
}
