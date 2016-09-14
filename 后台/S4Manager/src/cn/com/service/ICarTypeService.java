package cn.com.service;

import cn.com.bean.*;

import java.util.*;

/**
 * 车型服务接口
 * @author
 */
public interface ICarTypeService {
	/**
	 * 按热度获取车型信息的服务
	 * @return Map<Integer,CarType>
	 */
	public Map<Integer, CarType> getCarTypeByCount();
	/**
	 * 获取所有车型信息的服务
	 * @return  Map<Integer,CarType>
	 */
	public Map<Integer, CarType> getAllCarType();
/**
 * 添加车型的服务
 * @return boolean
 */
	public boolean addCarType(CarType carType);
/**
 * 删除车型的服务
 * @return boolean
 */
	public boolean deleteCarType(CarType carType);
/**
 * 修改车型的服务
 * @return boolean
 */
	public boolean updateType(CarType carType);
/**
 * 获取车型的服务
 * @return CarType
 */
	public CarType getCarType(CarType carType);
}
