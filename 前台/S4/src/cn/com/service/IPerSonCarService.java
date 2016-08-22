package cn.com.service;

import java.util.Map;

import cn.com.bean.*;

public interface IPerSonCarService {
	public int getCarCountByWhere(PerSonCar perSonCar);
	public Map<Long, PerSonCar> getPerSonCarMapByWhere(PerSonCar perSonCar);
	public boolean addPerSonCar(PerSonCar perSonCar);
	public boolean deletePerSoncar(PerSonCar perSonCar);
	public boolean updatePerSoncar(PerSonCar perSonCar,String state);
}
