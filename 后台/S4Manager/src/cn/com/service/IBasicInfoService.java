package cn.com.service;

import java.util.Map;

import cn.com.bean.BasicInfo;
import cn.com.bean.CarInfo;
/**
 * 汽车基本信息服务接口
 * @author lej
 */
public interface IBasicInfoService {
/**
 * 获取所有基本信息的服务
 * @return Map<Long, BasicInfo>
 */
	public Map<Long, BasicInfo> getAllBasic();
/**
 *根据编号获取汽车基本信息的服务
 *@return BasicInfo
 */
	public BasicInfo getAllBasicById(CarInfo carInfo);
/**
 * 添加汽车基本信息的服务
 * @return int
 */
	public boolean addBasicInfo(BasicInfo basicInfo);
/**
 * 修改汽车基本信息的服务
 * @return int
 */
	public boolean updateBasicInfo(BasicInfo basicInfo);
/**
 * 根据车主编号删除汽车基本信息的服务
 *@return int  
 */
	 public boolean deletebasicinfo(BasicInfo b);
/**
 * 根据车编号删除汽车基本信息的服务
 *@return int  
 */
	 public boolean deletecidbasicinfo(BasicInfo b);
/**
 * 检查是否还有与某车主编号关联的汽车基本信息的服务
 * @return boolean
 */
	 public boolean checkbasicinfo(BasicInfo b);
/**
 * 检查是否还有与某车编号关联的汽车基本信息的服务
 * @return boolean
 */
	 public boolean checkcidbasicinfo(BasicInfo b);
}
