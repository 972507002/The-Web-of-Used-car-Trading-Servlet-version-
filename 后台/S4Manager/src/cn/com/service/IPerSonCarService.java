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
	/**
	 * 根据条件分页获取记录集合
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,PerSonCar>
	 */
	public Map<Long, PerSonCar> getPersonList(int curPage, int rowsPrePage,PerSonCar perSonCar);
/**
 * 根据用户编号删除用户订单信息的方法
 *@return boolean  
 */
	 public boolean deletepersoncaruser(PerSonCar p);
/**
 * 根据车编号删除用户订单信息的方法
 *@return boolean  
 */
	 public boolean deletecidpersoncaruser(PerSonCar p);
/**
 * 
 * 检查是否还有与某用户编号关联的用户订单信息
 * @return boolean
 */
	 public boolean checkipersoncaruser(PerSonCar p);
/**
 * 
 * 检查是否还有与某车编号关联的用户订单信息
 * @return boolean
 */
	 public boolean checkcidipersoncaruser(PerSonCar p);
/**
 * 根据所有字段删除用户订单信息的方法
 *@return boolean  
 */
	 public boolean deletePersonByAll(PerSonCar perSonCar);
/**
 * 
 * 检查是否还有与某车主编号关联的用户订单信息
 * @return boolean
 */
	 public boolean checkcuidperson(PerSonCar p);
 /**
 * 根据车主编号删除用户订单信息的方法
 *@return boolean  
 */
	  	public boolean deletecuidperson(PerSonCar p);
}
