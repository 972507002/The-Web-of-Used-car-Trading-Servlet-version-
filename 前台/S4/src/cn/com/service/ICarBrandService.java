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
   * 根据品牌名称获取品牌的服务
   *@return CarBrand 
   */
	public CarBrand getBrandByName(CarBrand carBrand);
}
