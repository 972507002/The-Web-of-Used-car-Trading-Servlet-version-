package cn.com.dao;

import java.util.Map;
import cn.com.bean.*;
public interface IPriceIntervalDao {
  public Map<Integer,PriceInterval> getPriceIntervalByCount();
  public int addPriceInterval(PriceInterval priceInterval);
  public int deletePriceInterval(PriceInterval priceInterval);
  public int updatePriceInterval(PriceInterval priceInterval);
  public PriceInterval getPriceIntervalById(PriceInterval priceInterval);
  
}
