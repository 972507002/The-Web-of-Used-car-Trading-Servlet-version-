package cn.com.service;

import java.util.Map;

import cn.com.bean.PriceInterval;
/**
 * 价格区间服务接口
 * @author lej
 */
public interface IPriceIntervalService {
  /**
   * 
   * 按热度获取价格区间信息的服务
   * @return Map<Integer,PriceInterval>
   */
	public Map<Integer, PriceInterval> getPriceIntervalByCount();
  /**
   * 
   * 添加价格区间信息的服务
   * @return boolean
   */
	public boolean addPriceInterval(PriceInterval priceInterval);
  /**
   * 
   * 删除价格区间信息的服务
   * @return boolean
   */
	  public boolean deletePriceInterval(PriceInterval priceInterval);
  /**
   * 
   * 修改价格区间信息的服务
   * @return boolean
   */
	  public boolean updatePriceInterval(PriceInterval priceInterval);
  /**
   * 
   * 获取价格区间信息的服务
   * @return PriceInterval
   */
	  public PriceInterval getPriceIntervalById(PriceInterval priceInterval);
}
