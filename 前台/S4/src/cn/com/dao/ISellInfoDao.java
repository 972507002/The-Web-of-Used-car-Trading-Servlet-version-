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

}
