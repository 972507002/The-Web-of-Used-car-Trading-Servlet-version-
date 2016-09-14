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
	//个人汽车订单操作实现类的引用
   private PersonCarDaoImpl personCarDao=new PersonCarDaoImpl();
       /**
        * 根据条件获取用户订单信息数量的服务
        * @return int
        */
	@Override
	public int getCarCountByWhere(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getCarCountByWhere(perSonCar);
	}
       /**
        * 根据条件获取用户订单信息集合的服务
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
        * 根据条件获取用户订单信息数量的服务
        * @return int
        */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personCarDao.queryPersonCarCount(object);
	}
	/**
	 * 根据条件分页获取用户订车详情集合的服务
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personCarDao.showPersonCarList(curPage, rowsPrePage, object);
	}
       /**
        *  添加用户订单信息的服务
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
        *  删除用户订单信息的服务
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
        *  修改用户订单信息的服务
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
	/**
	 * 根据条件分页获取记录集合的服务
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,PerSonCar>
	 */
	@Override
	public Map<Long, PerSonCar> getPersonList(int curPage, int rowsPrePage,
			PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersonList(curPage, rowsPrePage, perSonCar);
	}
/**
 * 根据用户编号删除用户订单信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletepersoncaruser(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletepersoncaruser(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车编号删除用户订单信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecidpersoncaruser(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletecidpersoncaruser(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 
 * 检查是否还有与某用户编号关联的用户订单信息的服务
 * @return boolean
 */
	@Override
	public boolean checkipersoncaruser(PerSonCar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkipersonuser(p);
	}
/**
 * 
 * 检查是否还有与某车编号关联的用户订单信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidipersoncaruser(PerSonCar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcidipersonuser(p);
	}
/**
 * 根据所有字段删除用户订单信息的方法的服务
 *@return boolean  
 */
	@Override
	public boolean deletePersonByAll(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePersonByAll(perSonCar)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 
 * 检查是否还有与某车主编号关联的用户订单信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcuidperson(PerSonCar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcuidperson(p);
	}
 /**
 * 根据车主编号删除用户订单信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecuidperson(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletecuidperson(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}

}
