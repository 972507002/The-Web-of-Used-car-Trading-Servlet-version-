package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;
/**
 * 汽车基本信息操作接口
 * @author lej
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
/**
 * 根据车主编号删除汽车基本信息的方法
 *@return int  
 */
public int deletebasicinfo(BasicInfo b);
/**
 * 根据车编号删除汽车基本信息的方法
 *@return int  
 */
public int deletecidbasicinfo(BasicInfo b);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车基本信息
 * @return boolean
 */
public boolean checkbasicinfo(BasicInfo b);
/**
 * 
 * 检查是否还有与某车编号关联的汽车基本信息
 * @return boolean
 */
public boolean checkcidbasicinfo(BasicInfo b);
}
