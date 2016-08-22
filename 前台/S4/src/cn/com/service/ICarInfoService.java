package cn.com.service;

import cn.com.bean.*;

import java.util.*;


public interface ICarInfoService {
	public Map<Long, CarInfo> getCarInfoByCountDesc(CarInfo carInfo);
	public Map<Long, CarInfo> getCarInfoByBrandCountDesc(CarInfo carInfo);
	public Map<Long, CarInfo> getCarInfoBySjTime(CarInfo carInfo);
	public Map<Long, CarInfo> getFourthCarInfoBySjTime(CarInfo carInfo);
	public Map<Long, CarInfo>  getCarInfoByTypeCountDesc(CarInfo carInfo);
	public Map<Long, CarInfo> getCarInfoByBrand(CarInfo carInfo);
	public Map<Long, CarInfo> getCarInfoByType(CarInfo carInfo);
	public Map<Long, CarInfo> getCarByWhere(CarInfo carInfo);
	public boolean updateCarInfo(CarInfo carInfo);
	public boolean addCarInfo(CarInfo carInfo);
	public CarInfo getCarInfoByUMN(CarInfo carInfo);
	public boolean updateCarAll(CarInfo carInfo);
	public List<CarInfo> getTenCount(CarInfo carInfo);
	public List<CarInfo> getTenBrandCar(CarInfo carInfo);
}
