package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.bean.PriceInterval;
import cn.com.dao.IPageDao;
import cn.com.dao.impl.PriceIntervalDaoImpl;
import cn.com.service.IPriceIntervalService;

public class PriceIntervalServiceImpl implements IPriceIntervalService,IPageDao{
   private PriceIntervalDaoImpl intervalDao=new PriceIntervalDaoImpl();
	
	@Override
	public Map<Integer, PriceInterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalByCount();
	}

	@Override
	public int queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return intervalDao.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return intervalDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addPriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.addPriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deletePriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.deletePriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updatePriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.updatePriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public PriceInterval getPriceIntervalById(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalById(priceInterval);
	}

}
