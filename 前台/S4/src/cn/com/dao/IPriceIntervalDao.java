package cn.com.dao;

import java.util.Map;
import cn.com.bean.*;
public interface IPriceIntervalDao {
  public Map<Integer,PriceInterval> getPriceIntervalByCount();
}
