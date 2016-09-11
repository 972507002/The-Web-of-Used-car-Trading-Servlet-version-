package cn.com.service;

import java.util.Map;

import cn.com.bean.*;
/**
 * 个人汽车订单信息服务接口
 * @author lej
 */
public interface IPerSonCarService {
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
        * @return boolean
        */
	public boolean addPerSonCar(PerSonCar perSonCar);
	 /**
        *  删除用户订单信息
        * @return boolean
        */
	public boolean deletePerSoncar(PerSonCar perSonCar);
	 /**
        *  修改用户订单信息
        * @return boolean
        */
	public boolean updatePerSoncar(PerSonCar perSonCar,String state);
}
