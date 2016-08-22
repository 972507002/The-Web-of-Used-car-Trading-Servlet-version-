package cn.com.dao;
import java.util.*;

import cn.com.bean.*;

public interface IPersonCarDao {
       public int getCarCountByWhere(PerSonCar perSonCar);
       public Map<Long, PerSonCar> getPerSonCarMapByWhere(PerSonCar perSonCar);
       public int addPerSonCar(PerSonCar perSonCar);
       public int deletePerSoncar(PerSonCar perSonCar);
       public int updatePerSoncar(PerSonCar perSonCar,String state);
}
