package cn.com.service.impl;
import java.util.List;
import java.util.Map;
import cn.com.bean.CarBrand;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
/**
 * 品牌信息服务实现类
 * @author lej
 */
public class CarBrandServiceImpl implements ICarBrandService,IPageDao {
	//品牌信息操作实现类的引用
  private CarBrandDaoImpl brandDao= new CarBrandDaoImpl();
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
     * 获取品牌信息的记录总条数的服务
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return brandDao.queryPersonCarCount(object);
	}
 /**
 * 分页获取品牌信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return brandDao.showPersonCarList(curPage, rowsPrePage, object);
	}
  /**
   * 添加品牌的服务
   *@return boolean
   */
	@Override
	public boolean addCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.addCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 修改品牌的服务
   *@return boolean
   */
	@Override
	public boolean updateCarBrand(CarBrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.updateCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 删除品牌的服务
   *@return boolean
   */
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
