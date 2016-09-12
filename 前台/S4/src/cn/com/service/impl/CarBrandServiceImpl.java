package cn.com.service.impl;
import java.util.Map;
import cn.com.bean.CarBrand;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
/**
 * 品牌信息服务实现类
 * @author lej
 */
public class CarBrandServiceImpl implements ICarBrandService {
	//品牌信息操作接口的引用
  private ICarBrandDao brandDao= new CarBrandDaoImpl();
   /**
   * 按热度获取品牌信息的服务
   * @return  Map<Integer, CarBrand>
   */
	@Override
	public Map<Integer, CarBrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
		return brandDao.getCarBrandByCount();
	}
  /**
   * 获取所有品牌信息的服务
   * @return Map<Integer,CarBrand>
   */
	@Override
	public Map<Integer, CarBrand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandDao.getAllBrand();
	}
  /**
   * 根据品牌编号获取品牌信息的服务
   * @param carBrand
   * @return CarBrand
   */
	@Override
	public CarBrand getBrandByID(CarBrand carBrand) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByID(carBrand);
	}
  /**
   * 根据品牌名称获取品牌的服务
   *@return CarBrand 
   */
	@Override
	public CarBrand getBrandByName(CarBrand carBrand) {
		// TODO Auto-generated method stub
		return  brandDao.getBrandByName(carBrand);
	}

}
