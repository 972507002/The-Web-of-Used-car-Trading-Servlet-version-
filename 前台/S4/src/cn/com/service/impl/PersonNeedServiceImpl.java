package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.bean.*;
import cn.com.service.*;
import cn.com.dao.*;
import cn.com.dao.impl.*;
/**
 * 个人需求信息服务实现类
 *@author 
 */
public class PersonNeedServiceImpl implements IPersonNeedService,IPageDao{
	//个人需求操作类的引用
private PersonNeedDaoImpl personNeedDao=new PersonNeedDaoImpl();
 /**
   * 
   * 添加个人需求信息的服务
   *@return boolean 
   */
	public boolean addPersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.addPersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 删除个人需求信息的服务
   *@return boolean 
   */
	public boolean deletePersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.deletePersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 获取个人需求信息的服务
   *@return PersonNeed
   */
	@Override
	public PersonNeed getPerSonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		return personNeedDao.getPerSonNeed(personNeed);
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
	 * 获取个人需求总记录条数
	 * 
	 *@return int
	 */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personNeedDao.queryPersonCarCount(object);
	}
	/**
	 * 分页获取个人需求信息
	 * @param curPage 当前页
	 * @param rowsPrePage 每页显示记录条数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personNeedDao.showPersonCarList(curPage, rowsPrePage, object);
	}

}
