package cn.com.dao;

import java.util.Map;
import cn.com.bean.*;
/**
 * 价格区间操作接口
 * @author lej
 */
public interface IPriceIntervalDao {
  /**
   * 
   * 按热度获取价格区间信息的方法
   * @return Map<Integer,PriceInterval>
   */
  public Map<Integer,PriceInterval> getPriceIntervalByCount();
   /**
   * 
   * 添加价格区间信息的方法
   * @return int
   */
  public int addPriceInterval(PriceInterval priceInterval);
   /**
   * 
   * 删除价格区间信息的方法
   * @return int
   */
  public int deletePriceInterval(PriceInterval priceInterval);
   /**
   * 
   * 修改价格区间信息的方法
   * @return int
   */
  public int updatePriceInterval(PriceInterval priceInterval);
   /**
   * 
   * 获取价格区间信息的方法
   * @return PriceInterval
   */
  public PriceInterval getPriceIntervalById(PriceInterval priceInterval);
  
}
