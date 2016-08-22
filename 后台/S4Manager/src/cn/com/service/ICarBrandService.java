package cn.com.service;
import cn.com.bean.*;

import java.util.*;

public interface ICarBrandService {
	public Map<Integer, CarBrand> getCarBrandByCount();
	public Map<Integer, CarBrand> getAllBrand();
	public CarBrand getBrandByID(CarBrand carBrand);
	 public boolean addCarBrand(CarBrand carBrand);
	  public boolean updateCarBrand(CarBrand carBrand);
	  public boolean deleteCarBrand(CarBrand carBrand);
}
