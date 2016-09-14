package cn.com.service;
import java.util.Map;

import cn.com.bean.*;
/**
 * 车龄信息服务接口
 *@author  lej 
 */
public interface ICarAgeService {
	/**
	 * 按热度获取车龄信息的服务
	 * @return Map<Integer,CarAge>
	 */
	public Map<Integer,CarAge> getCarAgeByCount();
	/**
	 * 添加车龄信息的服务
	 * @return   int
	 */
	public boolean addCarAge(CarAge carAge);
	/**
	 * 删除车龄信息的服务
	 * @return   int
	 */
	public boolean deleteCarAge(CarAge carAge);
	/**
	 * 修改车龄信息的服务
	 * @return   int
	 */
	public boolean updateCarAge(CarAge carAge);
	/**
	 * 获取车龄信息的服务
	 * @return CarAge
	 */
	public CarAge getCarAgeById(CarAge carAge);
}
