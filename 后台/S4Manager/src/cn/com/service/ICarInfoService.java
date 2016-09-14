package cn.com.service;

import cn.com.bean.*;

import java.util.*;

/**
 * 汽车概要信息服务接口
 * @author lej
 */
public interface ICarInfoService {
/**
 * 按热度获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByCountDesc(CarInfo carInfo);
/**
 * 按热度和品牌获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByBrandCountDesc(CarInfo carInfo);
/**
 * 按上架时间获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoBySjTime(CarInfo carInfo);
/**
 * 获取四辆最新上架的汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getFourthCarInfoBySjTime(CarInfo carInfo);
/**
 * 按热度和车型获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo>  getCarInfoByTypeCountDesc(CarInfo carInfo);
/**
 * 按品牌获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByBrand(CarInfo carInfo);
/**
 * 按车型获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarInfoByType(CarInfo carInfo);
/**
 * 按条件获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, CarInfo> getCarByWhere(CarInfo carInfo);
  /**
   * 修改汽车概要信息的服务
   * @parma carInfo
   * @return boolean
   */
	public boolean updateCarInfo(CarInfo carInfo);
  /**
   * 添加汽车概要信息的服务
   * @parma carInfo
   * @return boolean
   */
	public boolean addCarInfo(CarInfo carInfo);
/**
 * 按唯一条件获取汽车概要信息的服务
 * @parma carInfo
 * @return   CarInfo
 */
	public CarInfo getCarInfoByUMN(CarInfo carInfo);
  /**
   * 修改汽车所有概要信息的服务
   * @parma carInfo
   * @return boolean
   */
	public boolean updateCarAll(CarInfo carInfo);
/**
 * 根据车主编号删除汽车概要信息的服务
 *@return boolean  
 */
	 public boolean deletecarinfouser(CarInfo c);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车概要信息的服务
 * @return boolean
 */
	 public boolean checkcarinfouser(CarInfo c);
 /**
 * 根据车编号删除汽车概要信息的服务
 *@return boolean  
 */
	 public boolean deletecarinfo(CarInfo c) ;
}
