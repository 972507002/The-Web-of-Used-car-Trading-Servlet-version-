package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.PriceInterval;
import cn.com.dao.IPriceIntervalDao;
import cn.com.dao.impl.PriceIntervalDaoImpl;
import cn.com.service.IPriceIntervalService;

public class PriceIntervalServiceImpl implements IPriceIntervalService{
   private IPriceIntervalDao intervalDao=new PriceIntervalDaoImpl();
	@Override
	public Map<Integer, PriceInterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalByCount();
	}

}
