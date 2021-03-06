package cn.com.dao;
import java.util.*;
import cn.com.bean.*;
/**
 * 品牌信息操作接口
 * @author lej
 */
public interface ICarBrandDao {
  /**
   * 按热度获取品牌信息的方法
   * @return  Map<Integer, CarBrand>
   */
  public Map<Integer, CarBrand> getCarBrandByCount();
  /**
   * 获取所有品牌信息的方法
   * @return Map<Integer,CarBrand>
   */
  public Map<Integer, CarBrand> getAllBrand();
  /**
   * 根据品牌编号获取品牌信息的方法
   * @param carBrand
   * @return CarBrand
   */
  public CarBrand getBrandByID(CarBrand carBrand);
  /**
   * 根据品牌名称获取品牌的方法
   *@return CarBrand 
   */
  public CarBrand getBrandByName(CarBrand carBrand);
}
