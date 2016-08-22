package cn.com.service.impl;
import java.util.List;
import java.util.Map;
import cn.com.bean.CarBrand;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarBrandServiceImpl implements ICarBrandService,IPageDao {
  private CarBrandDaoImpl brandDao= new CarBrandDaoImpl();

	@Override
	public Map<Integer, CarBrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
		return brandDao.getCarBrandByCount();
	}
	
	@Override
	public Map<Integer, CarBrand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandDao.getAllBrand();
	}
	
	@Override
	public CarBrand getBrandByID(CarBrand carBrand) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByID(carBrand);
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
		return brandDao.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return brandDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.addCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.updateCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.deleteCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}

}
