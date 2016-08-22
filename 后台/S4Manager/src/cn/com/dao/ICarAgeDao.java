package cn.com.dao;
import java.util.Map;

import cn.com.bean.*;
public interface ICarAgeDao {
	public Map<Integer,CarAge> getCarAgeByCount();
	public int addCarAge(CarAge carAge);
	public int deleteCarAge(CarAge carAge);
	public int updateCarAge(CarAge carAge);
	public CarAge getCarAgeById(CarAge carAge);
}
