package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.PriceInterval;
import cn.com.dao.IPriceIntervalDao;
import cn.com.dao.impl.PriceIntervalDaoImpl;
import cn.com.service.IPriceIntervalService;
/**
 * 价格区间服务实现类
 * @author lej
 */
public class PriceIntervalServiceImpl implements IPriceIntervalService{
	//价格区间实现类的引用
   private IPriceIntervalDao intervalDao=new PriceIntervalDaoImpl();
    /**
   * 
   * 按热度获取价格区间信息的服务
   * @return Map<Integer,PriceInterval>
   */
	@Override
	public Map<Integer, PriceInterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalByCount();
	}

}
