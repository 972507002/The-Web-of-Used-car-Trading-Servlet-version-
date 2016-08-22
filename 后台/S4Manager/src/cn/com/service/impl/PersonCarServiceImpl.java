package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import cn.com.bean.*;
import cn.com.dao.IPageDao;
import cn.com.dao.impl.*;
import cn.com.service.*;

public class PersonCarServiceImpl implements IPerSonCarService,IPageDao {
   private PersonCarDaoImpl personCarDao=new PersonCarDaoImpl();
	@Override
	public int getCarCountByWhere(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getCarCountByWhere(perSonCar);
	}
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
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personCarDao.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personCarDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addPerSonCar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.addPerSonCar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deletePerSoncar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePerSoncar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updatePerSoncar(PerSonCar perSonCar, String state) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.updatePerSoncar(perSonCar, state)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Map<Long, PerSonCar> getPersonList(int curPage, int rowsPrePage,
			PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersonList(curPage, rowsPrePage, perSonCar);
	}
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
	@Override
	public boolean checkipersoncaruser(PerSonCar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkipersonuser(p);
	}
	@Override
	public boolean checkcidipersoncaruser(PerSonCar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcidipersonuser(p);
	}
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
	@Override
	public boolean checkcuidperson(PerSonCar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcuidperson(p);
	}
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
