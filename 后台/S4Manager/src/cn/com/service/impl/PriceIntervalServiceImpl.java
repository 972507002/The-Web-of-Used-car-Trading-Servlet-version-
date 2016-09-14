package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.bean.PriceInterval;
import cn.com.dao.IPageDao;
import cn.com.dao.impl.PriceIntervalDaoImpl;
import cn.com.service.IPriceIntervalService;
/**
 * 价格区间服务实现类
 * @author lej
 */
public class PriceIntervalServiceImpl implements IPriceIntervalService,IPageDao{
	//价格区间操作实现类的引用
   private PriceIntervalDaoImpl intervalDao=new PriceIntervalDaoImpl();
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
     * 获取价格区间信息的记录总条数
     * @return int
     */		
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return intervalDao.queryPersonCarCount(object);
	}
/**
 * 分页获取价格区间信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return intervalDao.showPersonCarList(curPage, rowsPrePage, object);
	}
  /**
   * 
   * 添加价格区间信息的服务
   * @return boolean
   */
	@Override
	public boolean addPriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.addPriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 删除价格区间信息的服务
   * @return boolean
   */
	@Override
	public boolean deletePriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.deletePriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 修改价格区间信息的服务
   * @return boolean
   */
	@Override
	public boolean updatePriceInterval(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.updatePriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 获取价格区间信息的服务
   * @return PriceInterval
   */
	@Override
	public PriceInterval getPriceIntervalById(PriceInterval priceInterval) {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalById(priceInterval);
	}

}
