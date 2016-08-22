package cn.com.service.impl;

import java.util.*;

import cn.com.bean.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class DistanceServiceImpl implements IDistanceService,IPageDao {
   private DistanceDaoImpl distanceDao=new DistanceDaoImpl();
	
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceByCount();
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
		return distanceDao.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return distanceDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.addDistance(distance)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.deleteDistance(distance)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.updateDistance(distance)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Distance getDistanceById(Distance distance) {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceById(distance);
	}

}
