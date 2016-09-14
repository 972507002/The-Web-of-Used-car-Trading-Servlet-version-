package cn.com.dao;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;
 /**
  * 
  * 销售信息操作接口
  * @author lej
  */
public interface ISellInfoDao {
        /**
	 * 获取所有销售信息
	 * @return   Map<Long, SellInfo>
	 */
public Map<Long, SellInfo> getAllSellInfo();
/**
 * 根据车编号获取销售信息
 * @return SellInfo
 */
public SellInfo getSellInfoById(CarInfo carInfo);
/**
 * 增加销售信息
 * @param sellInfo
 * @return int
 */
public int addSellInfo(SellInfo sellInfo);
/**
 * 删除销售信息
 * @param sellInfo
 * @return int
 */
public int deleteSellInfo(SellInfo sellInfo);
/**
 * 修改销售信息
 * @param sellInfo
 * @return int
 */
public int updateSellInfo(SellInfo sellInfo);
/**
 * 根据车主编号删除销售信息的方法
 *@return int  
 */
public int deletesellinfouser(SellInfo s);
/**
 * 根据车编号删除销售信息的方法
 *@return int  
 */
public int deletecidsellinfouser(SellInfo s);
/**
 * 
 * 检查是否还有与某车主编号关联的销售信息
 * @return boolean
 */
public boolean checksellinfouser(SellInfo s);
/**
 * 
 * 检查是否还有与某车编号关联的销售信息
 * @return boolean
 */
public boolean checkcidsellinfouser(SellInfo s);

}
