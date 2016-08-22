package cn.com.service;
import cn.com.bean.*;

import java.util.*;

public interface ICarBrandService {
	public Map<Integer, CarBrand> getCarBrandByCount();
	public Map<Integer, CarBrand> getAllBrand();
	public CarBrand getBrandByID(CarBrand carBrand);
	public CarBrand getBrandByName(CarBrand carBrand);
}
