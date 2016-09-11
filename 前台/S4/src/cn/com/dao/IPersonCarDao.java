package cn.com.dao;
import java.util.*;

import cn.com.bean.*;
/**
 * 个人汽车订单信息操作接口
 * @author lej
 */
public interface IPersonCarDao {
       /**
        * 根据条件获取用户订单信息数量
        * @return int
        */
       public int getCarCountByWhere(PerSonCar perSonCar);
       /**
        * 根据条件获取用户订单信息集合
        * @return  Map<Long, PerSonCar>
        */
       public Map<Long, PerSonCar> getPerSonCarMapByWhere(PerSonCar perSonCar);
       /**
        *  添加用户订单信息
        * @return int
        */
       public int addPerSonCar(PerSonCar perSonCar);
       /**
        *  删除用户订单信息
        * @return int
        */
       public int deletePerSoncar(PerSonCar perSonCar);
       /**
        *  修改用户订单信息
        * @return int
        */
       public int updatePerSoncar(PerSonCar perSonCar,String state);
}
