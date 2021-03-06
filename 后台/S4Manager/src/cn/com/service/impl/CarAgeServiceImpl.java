package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import cn.com.bean.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
/**
 * 车龄信息服务实现类
 *@author  lej 
 */
public class CarAgeServiceImpl implements ICarAgeService,IPageDao {
	//车辆信息操作实现类的引用
  private CarAgeDaoImpl carAgeDao=new CarAgeDaoImpl();
	/**
	 * 按热度获取车龄信息的服务
	 * @return Map<Integer,CarAge>
	 */
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
    /**
     * 获取车龄信息的记录总条数的服务
     * @return int
     */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return carAgeDao.queryPersonCarCount(object);
	}
/**
 * 分页获取车龄信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		
		return carAgeDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	/**
	 * 添加车龄信息的服务
	 * @return   boolean
	 */
	@Override
	public boolean addCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.addCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 删除车龄信息的服务
	 * @return   boolean
	 */
	@Override
	public boolean deleteCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.deleteCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 修改车龄信息的服务
	 * @return   boolean
	 */
	@Override
	public boolean updateCarAge(CarAge carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.updateCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
        /**
	 * 获取车龄信息的服务
	 * @return CarAge
	 */
	@Override
	public CarAge getCarAgeById(CarAge carAge) {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeById(carAge);
	}

}
