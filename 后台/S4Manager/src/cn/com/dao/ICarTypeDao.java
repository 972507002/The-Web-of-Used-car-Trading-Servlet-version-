package cn.com.dao;

import java.util.*;
import cn.com.bean.*;
/**
 * 车型操作接口
 * @author
 */
public interface ICarTypeDao {
	/**
	 * 按热度获取车型信息的方法
	 * @return Map<Integer,CarType>
	 */
	public Map<Integer, CarType> getCarTypeByCount();
	/**
	 * 获取所有车型信息的方法
	 * @return  Map<Integer,CarType>
	 */
	public Map<Integer, CarType> getAllCarType();
/**
 * 添加车型的方法
 * @return int
 */
	public int addCarType(CarType carType);
/**
 * 删除车型的方法
 * @return int
 */
	public int deleteCarType(CarType carType);
/**
 * 修改车型的方法
 * @return int
 */
	public int updateType(CarType carType);、/**
 * 获取车型的方法
 * @return CarType
 */
	public CarType getCarType(CarType carType);
}
