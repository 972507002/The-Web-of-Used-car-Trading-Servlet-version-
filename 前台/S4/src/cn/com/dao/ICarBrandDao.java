package cn.com.dao;
import java.util.*;
import cn.com.bean.*;
public interface ICarBrandDao {
  public Map<Integer, CarBrand> getCarBrandByCount();
  public Map<Integer, CarBrand> getAllBrand();
  public CarBrand getBrandByID(CarBrand carBrand);
  public CarBrand getBrandByName(CarBrand carBrand);
}
