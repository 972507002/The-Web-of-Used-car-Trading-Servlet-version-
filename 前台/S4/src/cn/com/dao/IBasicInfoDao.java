package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;
/**
 * 汽车基本信息操作接口
 * @author lejs
 */
public interface IBasicInfoDao {
/**
 * 获取所有基本信息的方法
 * @return Map<Long, BasicInfo>
*/
public Map<Long, BasicInfo> getAllBasic();
/**
 *根据编号获取汽车基本信息的方法 
 *@return BasicInfo
 */
public BasicInfo getAllBasicById(CarInfo carInfo);
/**
 * 添加汽车基本信息的方法
 * @return int
 */
public int addBasicInfo(BasicInfo basicInfo);
/**
 * 修改汽车基本信息的方法
 * @return int
 */
public int updateBasicInfo( BasicInfo basicInfo);
}
