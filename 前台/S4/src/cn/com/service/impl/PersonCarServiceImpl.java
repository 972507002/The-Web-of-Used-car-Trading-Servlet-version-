package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import cn.com.bean.*;
import cn.com.dao.IPageDao;
import cn.com.dao.impl.*;
import cn.com.service.*;
/**
 * 个人汽车订单信息服务实现类
 * @author lej
 */
public class PersonCarServiceImpl implements IPerSonCarService,IPageDao {
	//个人汽车订单信息操作类的引用
   private PersonCarDaoImpl personCarDao=new PersonCarDaoImpl();
    /**
        * 根据条件获取用户订单信息数量
        * @return int
        */
	@Override
	public int getCarCountByWhere(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getCarCountByWhere(perSonCar);
	}
	 /**
        * 根据条件获取用户订单信息集合
        * @return  Map<Long, PerSonCar>
        */
	@Override
	public Map<Long, PerSonCar> getPerSonCarMapByWhere(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getPerSonCarMapByWhere(perSonCar);
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
	 * 获取个人汽车订单的总记录数
	 *@return int 
	 */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personCarDao.queryPersonCarCount(object);
	}
	/**
	 * 分页获取个人汽车订单信息
	 *@param curPage
	 * @param rowsPrePage
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personCarDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	 /**
        *  添加用户订单信息
        * @return boolean
        */
	@Override
	public boolean addPerSonCar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.addPerSonCar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	 /**
        *  删除用户订单信息
        * @return boolean
        */
	@Override
	public boolean deletePerSoncar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePerSoncar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	 /**
        *  修改用户订单信息
        * @return boolean
        */
	@Override
	public boolean updatePerSoncar(PerSonCar perSonCar, String state) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.updatePerSoncar(perSonCar, state)>0){
			flag=true;
		}
		return flag;
	}

}
