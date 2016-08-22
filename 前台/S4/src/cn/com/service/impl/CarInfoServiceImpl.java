package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarInfoServiceImpl implements ICarInfoService,IPageDao  {
   private CarInfoDaoImpl carInfoDao=new CarInfoDaoImpl();
	@Override
	public Map<Long, CarInfo> getCarInfoByCountDesc(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByCountDesc(carInfo);
	}
	@Override
	public Map<Long, CarInfo> getCarInfoByBrandCountDesc(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByBrandCountDesc(carInfo);
	}
	@Override
	public Map<Long, CarInfo> getCarInfoBySjTime(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoBySjTime(carInfo);
	}
	@Override
	public Map<Long, CarInfo> getFourthCarInfoBySjTime(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getFourthCarInfoBySjTime(carInfo);
	}
	@Override
	public Map<Long, CarInfo> getCarInfoByTypeCountDesc(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByTypeCountDesc(carInfo);
	}
	@Override
	public Map<Long, CarInfo> getCarInfoByBrand(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByBrand(carInfo);
	}
	@Override
	public Map<Long, CarInfo> getCarInfoByType(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByType(carInfo);
	}
	@Override
	public Map<Long, CarInfo> getCarByWhere(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarByWhere(carInfo);
	}
	@Override
	public int queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		return carInfoDao.queryMsgCount(object,minPrice,maxPrice,minDis,maxDis,minAge,maxAge);
	}
	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		return carInfoDao.showMsgInfoList(curPage, rowsPrePage, object,order,minPrice,maxPrice,minDis,maxDis,minAge,maxAge);
	}
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateCarInfo(CarInfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.updateCarInfo(carInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean addCarInfo(CarInfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.addCarInfo(carInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public CarInfo getCarInfoByUMN(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByUMN(carInfo);
	}
	@Override
	public boolean updateCarAll(CarInfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.updateCarAll(carInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public List<CarInfo> getTenCount(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getTenCount(carInfo);
	}
	@Override
	public List<CarInfo> getTenBrandCar(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getTenBrandCar(carInfo);
	}

}
