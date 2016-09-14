package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.IPageDao;
import cn.com.dao.impl.*;
import cn.com.service.*;
/**
 * 
 * 排放标准服务实现类
 *@author  lej
 */
public class EmissionstandardServiceImpl implements IEmissionstandardService,IPageDao {
	//排放标准操作实现类的引用
    private EmissionstandardDaoImpl emissionstandardDao=new EmissionstandardDaoImpl();
        /**
	 * 按热度获取排放标准信息的服务
	 * @return Map<Integer,Emissionstandard>
	 */
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
    /**
     * 获取排放标准信息的记录总条数的服务
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return emissionstandardDao.queryPersonCarCount(object);
	}
/**
 * 分页获取排放标准信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return emissionstandardDao.showPersonCarList(curPage, rowsPrePage, object);
	}
	 /**
           * 添加排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	@Override
	public boolean addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.addEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	  /**
           * 修改排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	@Override
	public boolean updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.updateEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	 /**
           * 删除排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	@Override
	public boolean deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.deleteEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 获取排放标准信息的服务
	 * @return Emissionstandard
	 */
	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandard(emissionstandard);
	}

}
