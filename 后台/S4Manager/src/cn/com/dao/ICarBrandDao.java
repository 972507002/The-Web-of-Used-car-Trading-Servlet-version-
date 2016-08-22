package cn.com.dao;
import java.util.*;
import cn.com.bean.*;
public interface ICarBrandDao {
  public Map<Integer, CarBrand> getCarBrandByCount();
  public Map<Integer, CarBrand> getAllBrand();
  public CarBrand getBrandByID(CarBrand carBrand);
  public int addCarBrand(CarBrand carBrand);
  public int updateCarBrand(CarBrand carBrand);
  public int deleteCarBrand(CarBrand carBrand);
}
