package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.IPageDao;
import cn.com.dao.IUserInfoDao;
import cn.com.dao.impl.*;
import cn.com.service.*;
public class UserInfoServiceImpl implements IUserInfoService,IPageDao{
   private UserInfoDaoImpl userInfoDao=new UserInfoDaoImpl();
	@Override
	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
		
		
		return userInfoDao.login(userInfo);
	}
	@Override
	public UserInfo getUserInfoByUnique(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserInfoByUnique(userInfo);
	}
	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub4
		boolean flag=false;
		if( userInfoDao.addUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(userInfoDao.updateUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateUserPwd(UserInfo userInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(userInfoDao.updateUserPwd(userInfo)>0){
			flag=true;
		}
		return flag;
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
		return userInfoDao.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return userInfoDao.showPersonCarList(curPage, rowsPrePage, object);
	}

}
