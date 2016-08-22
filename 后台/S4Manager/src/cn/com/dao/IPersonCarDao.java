package cn.com.dao;
import java.util.*;

import cn.com.bean.*;


public interface IPersonCarDao {
       public int getCarCountByWhere(PerSonCar perSonCar);
       public Map<Long, PerSonCar> getPerSonCarMapByWhere(PerSonCar perSonCar);
       public int addPerSonCar(PerSonCar perSonCar);
       public int deletePerSoncar(PerSonCar perSonCar);
       public int updatePerSoncar(PerSonCar perSonCar,String state);
       public Map<Long, PerSonCar> getPersonList(int curPage, int rowsPrePage,PerSonCar perSonCar);
       public int deletepersoncaruser(PerSonCar u);
  	 public int deletecidpersoncaruser(PerSonCar u);
  	 public boolean checkipersonuser(PerSonCar p);
  	 public boolean checkcidipersonuser(PerSonCar p);
  	 public int deletePersonByAll(PerSonCar perSonCar);
  	public boolean checkcuidperson(PerSonCar p);
  	public int deletecuidperson(PerSonCar p);
}
