package cn.com.service;
import cn.com.bean.*;

import java.util.*;
/**
 * 品牌信息服务接口
 * @author lej
 */
public interface ICarBrandService {
  /**
   * 按热度获取品牌信息的服务
   * @return  Map<Integer, CarBrand>
   */
	public Map<Integer, CarBrand> getCarBrandByCount();
  /**
   * 获取所有品牌信息的服务
   * @return Map<Integer,CarBrand>
   */
	public Map<Integer, CarBrand> getAllBrand();
  /**
   * 根据品牌编号获取品牌信息的服务
   * @param carBrand
   * @return CarBrand
   */
	public CarBrand getBrandByID(CarBrand carBrand);
  /**
   * 添加品牌的服务
   *@return boolean
   */
	 public boolean addCarBrand(CarBrand carBrand);
  /**
   * 修改品牌的服务
   *@return boolean
   */
	  public boolean updateCarBrand(CarBrand carBrand);
  /**
   * 删除品牌的服务
   *@return boolean
   */
	  public boolean deleteCarBrand(CarBrand carBrand);
}
