package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.bean.*;
import cn.com.service.*;
import cn.com.dao.*;
import cn.com.dao.impl.*;

public class PersonNeedServiceImpl implements IPersonNeedService,IPageDao{
private PersonNeedDaoImpl personNeedDao=new PersonNeedDaoImpl();
	public boolean addPersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.addPersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
	public boolean deletePersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.deletePersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
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
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personNeedDao.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personNeedDao.showPersonCarList(curPage, rowsPrePage, object);
	}

}
