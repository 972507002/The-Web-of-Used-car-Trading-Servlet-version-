package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;
/**
  * 
  * 销售信息服务接口
  * @author lej
  */
public interface ISellInfoService {
        /**
	 * 获取所有销售信息的服务
	 * @return   Map<Long, SellInfo>
	 */
	public Map<Long, SellInfo> getAllSellInfo();
/**
 * 根据车编号获取销售信息的服务
 * @return SellInfo
 */
	public SellInfo getSellInfoById(CarInfo carInfo);
/**
 * 增加销售信息的服务
 * @param sellInfo
 * @return int
 */
	public boolean addSellInfo(SellInfo sellInfo);
/**
 * 删除销售信息的服务
 * @param sellInfo
 * @return int 成功返回1 否则返回0
 */
	public int deleteSellInfo(SellInfo sellInfo);
/**
 * 修改销售信息的服务
 * @param sellInfo
 * @return boolean
 */
	public boolean updateSellInfo(SellInfo sellInfo);
/**
 * 根据车主编号删除销售信息的服务
 *@return boolean  
 */
	public boolean deletesellinfouser(SellInfo s);
/**
 * 根据车编号删除销售信息的服务
 *@return boolean  
 */
	 public boolean deletecidsellinfouser(SellInfo s);
/**
 * 
 * 检查是否还有与某车主编号关联的销售信息的服务
 * @return boolean
 */
	 public boolean checksellinfouser(SellInfo s);
 /**
 * 
 * 检查是否还有与某车编号关联的销售信息的服务
 * @return boolean
 */
	 public boolean checkcidsellinfouser(SellInfo s);

}
