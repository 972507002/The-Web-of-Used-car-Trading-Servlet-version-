package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;

public interface ISellInfoService {
	/**
	 * 获取所有销售信息业务
	 */
	public Map<Long, SellInfo> getAllSellInfo();
	/**
	 * 根据车编号获取销售情况业务
	 */
	public SellInfo getSellInfoById(CarInfo carInfo);
	/**
	 * 增加销售情况业务
	 */
	public boolean addSellInfo(SellInfo sellInfo);
	/**
	 * 删除销售情况业务
	 */
	public int deleteSellInfo(SellInfo sellInfo);
	public boolean updateSellInfo(SellInfo sellInfo);
	public boolean deletesellinfouser(SellInfo s);
	 public boolean deletecidsellinfouser(SellInfo s);
	 public boolean checksellinfouser(SellInfo s);
	 public boolean checkcidsellinfouser(SellInfo s);
}
