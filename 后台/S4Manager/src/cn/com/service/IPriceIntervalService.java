package cn.com.service;

import java.util.Map;

import cn.com.bean.PriceInterval;

public interface IPriceIntervalService {
	public Map<Integer, PriceInterval> getPriceIntervalByCount();
	public boolean addPriceInterval(PriceInterval priceInterval);
	  public boolean deletePriceInterval(PriceInterval priceInterval);
	  public boolean updatePriceInterval(PriceInterval priceInterval);
	  public PriceInterval getPriceIntervalById(PriceInterval priceInterval);
}
