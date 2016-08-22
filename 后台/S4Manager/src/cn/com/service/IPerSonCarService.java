package cn.com.service;

import java.util.Map;

import cn.com.bean.*;


public interface IPerSonCarService {
	public int getCarCountByWhere(PerSonCar perSonCar);
	public Map<Long, PerSonCar> getPerSonCarMapByWhere(PerSonCar perSonCar);
	public boolean addPerSonCar(PerSonCar perSonCar);
	public boolean deletePerSoncar(PerSonCar perSonCar);
	public boolean updatePerSoncar(PerSonCar perSonCar,String state);
	public Map<Long, PerSonCar> getPersonList(int curPage, int rowsPrePage,PerSonCar perSonCar);
	 public boolean deletepersoncaruser(PerSonCar p);
	 public boolean deletecidpersoncaruser(PerSonCar p);
	 public boolean checkipersoncaruser(PerSonCar p);
	 public boolean checkcidipersoncaruser(PerSonCar p);
	 public boolean deletePersonByAll(PerSonCar perSonCar);
	 public boolean checkcuidperson(PerSonCar p);
	  	public boolean deletecuidperson(PerSonCar p);
}
