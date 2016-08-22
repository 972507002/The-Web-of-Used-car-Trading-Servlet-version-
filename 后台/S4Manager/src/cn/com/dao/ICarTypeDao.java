package cn.com.dao;

import java.util.*;
import cn.com.bean.*;

public interface ICarTypeDao {
	public Map<Integer, CarType> getCarTypeByCount();
	public Map<Integer, CarType> getAllCarType();
	public int addCarType(CarType carType);
	public int deleteCarType(CarType carType);
	public int updateType(CarType carType);
	public CarType getCarType(CarType carType);
}
