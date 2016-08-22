package cn.com.dao;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;

public interface ISellInfoDao {
	/**
	 * 获取所有销售信息
	 * @return
	 */
public Map<Long, SellInfo> getAllSellInfo();
/**
 * 根据车编号获取销售情况
 * @return
 */
public SellInfo getSellInfoById(CarInfo carInfo);
/**
 * 增加销售情况
 * @param sellInfo
 * @return
 */
public int addSellInfo(SellInfo sellInfo);
/**
 * 删除销售情况
 * @param sellInfo
 * @return
 */
public int deleteSellInfo(SellInfo sellInfo);
public int updateSellInfo(SellInfo sellInfo);

}
