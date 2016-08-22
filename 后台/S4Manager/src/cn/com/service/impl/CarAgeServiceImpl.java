package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import cn.com.bean.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarAgeServiceImpl implements ICarAgeService,IPageDao {
  private CarAgeDaoImpl carAgeDao=new CarAgeDaoImpl();
	
	@Override
	public Map<Integer, CarAge> getCarAgeByCount() {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeByCount();
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
		return carAgeDao.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		
		return carAgeDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.addCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.deleteCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.updateCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public CarAge getCarAgeById(CarAge carAge) {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeById(carAge);
	}

}
