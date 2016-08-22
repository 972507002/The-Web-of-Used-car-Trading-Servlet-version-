package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.IPageDao;
import cn.com.dao.impl.*;
import cn.com.service.*;

public class EmissionstandardServiceImpl implements IEmissionstandardService,IPageDao {
    private EmissionstandardDaoImpl emissionstandardDao=new EmissionstandardDaoImpl();
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandardByCount();
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
		return emissionstandardDao.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return emissionstandardDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.addEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.updateEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.deleteEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandard(emissionstandard);
	}

}
