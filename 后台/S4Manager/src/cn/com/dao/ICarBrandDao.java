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
   * 添加品牌的方法
   *@return int
   */
  public int addCarBrand(CarBrand carBrand);
  /**
   * 修改品牌的方法
   *@return int
   */
  public int updateCarBrand(CarBrand carBrand);
  /**
   * 删除品牌的方法
   *@return int
   */
  public int deleteCarBrand(CarBrand carBrand);
}
