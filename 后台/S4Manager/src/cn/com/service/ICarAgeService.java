package cn.com.service;
import java.util.Map;

import cn.com.bean.*;

public interface ICarAgeService {
	public Map<Integer,CarAge> getCarAgeByCount();
	public boolean addCarAge(CarAge carAge);
	public boolean deleteCarAge(CarAge carAge);
	public boolean updateCarAge(CarAge carAge);
	public CarAge getCarAgeById(CarAge carAge);
}
