package cn.com.service.impl;
import java.util.List;
import java.util.Map;
import cn.com.bean.Trends;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class TrendsServiceImpl implements ITrendsService,IPageDao{
 private  TrendsDaoImpl trendsDao=new TrendsDaoImpl();
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
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return trendsDao.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return trendsDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		return trendsDao.getTrendsByWhere(trends);
	}
	@Override
	public boolean addTrends(Trends trends) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(trendsDao.addTrends(trends)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteTrends(Trends trends) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(trendsDao.deleteTrends(trends)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateTrends(Trends trends) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(trendsDao.updateTrends(trends)>0){
			flag=true;
		}
		return flag;
	}

}
