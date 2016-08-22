package cn.com.service;

import java.util.Map;

import cn.com.bean.PriceInterval;

public interface IPriceIntervalService {
	public Map<Integer, PriceInterval> getPriceIntervalByCount();
}
