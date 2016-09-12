package cn.com.service.impl;
import java.util.List;
import java.util.Map;
import cn.com.bean.CarBrand;
import cn.com.bean.Trends;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
/**
 * 公司动态消息服务实现类
 * @author
 */
public class TrendsServiceImpl implements ITrendsService,IPageDao{
	//公司动态消息操作接口的引用
 private  TrendsDaoImpl trendsDao=new TrendsDaoImpl();
       /**
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
	@Override
	public List<Trends> getITrendsByTime(Trends trends,int rows) {
		// TODO Auto-generated method stub
		return trendsDao.getITrendsByTime(trends,rows);
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
	 * 获取公司动态消息总记录数
	 * @return int
	 */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return trendsDao.queryPersonCarCount(object);
	}
	/**
	 * 分页获取公司动态消息
	 * @param curPage 当前页
	 *@param rowsPrePage
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return trendsDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	 /**
        * 按条件获取动态消息
        * 
        * Trends
        */
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		return trendsDao.getTrendsByWhere(trends);
	}

}
