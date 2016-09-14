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
	//个人需求操作实现类的引用
private PersonNeedDaoImpl personNeedDao=new PersonNeedDaoImpl();
  /**
   * 
   * 添加个人需求信息的服务
   *@return boolean 
   */
	@Override
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
	@Override
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
     * 获取符合条件的个人需求信息的记录总条数
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personNeedDao.queryPersonCarCount(object);
	}
/**
 * 分页获取符合条件的个人需求信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personNeedDao.showPersonCarList(curPage, rowsPrePage, object);
	}
  /**
   * 
   * 修改个人需求信息的服务
   *@return boolean 
   */
	@Override
	public boolean updatePersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.updatePersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 
 * 检查是否还有与某用户编号关联的个人需求的服务
 * @return boolean
 */
	@Override
	public boolean chekUidPerson(PersonNeed personneed) {
		// TODO Auto-generated method stub
		return personNeedDao.chekUidPerson(personneed);
	}
/**
 * 根据用户编号删除个人需求信息的服务
 *@return boolean  
 */
	@Override
	public boolean deleteUidPerson(PersonNeed personneed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.deleteUidPerson(personneed)>0){
			flag=true;
		}
		return flag;
	}

}
