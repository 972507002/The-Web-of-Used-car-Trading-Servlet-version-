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
	 * @return Map<Integer,CarType>
	 */
	public Map<Integer, CarType> getAllCarType();
}
