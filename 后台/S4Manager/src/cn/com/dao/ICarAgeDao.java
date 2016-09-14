package cn.com.dao;
import java.util.Map;

import cn.com.bean.*;
/**
 * 车龄信息操作接口
 *@author  lej 
 */
public interface ICarAgeDao {
	/**
	 * 按热度获取车龄信息的方法
	 * @return Map<Integer,CarAge>
	 */
	public Map<Integer,CarAge> getCarAgeByCount();
	/**
	 * 添加车龄信息的方法
	 * @return   int
	 */
	public int addCarAge(CarAge carAge);
	/**
	 * 删除车龄信息的方法
	 * @return   int
	 */
	public int deleteCarAge(CarAge carAge);
	/**
	 * 修改车龄信息的方法
	 * @return   int
	 */
	public int updateCarAge(CarAge carAge);
	/**
	 * 获取车龄信息的方法
	 * @return CarAge
	 */
	public CarAge getCarAgeById(CarAge carAge);
}
