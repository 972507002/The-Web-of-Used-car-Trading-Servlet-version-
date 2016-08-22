package cn.com.service.impl;
import java.util.Map;
import cn.com.bean.CarBrand;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarBrandServiceImpl implements ICarBrandService {
  private ICarBrandDao brandDao= new CarBrandDaoImpl();
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
	public CarBrand getBrandByName(CarBrand carBrand) {
		// TODO Auto-generated method stub
		return  brandDao.getBrandByName(carBrand);
	}

}
