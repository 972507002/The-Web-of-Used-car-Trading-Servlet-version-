package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.IPageDao;
import cn.com.dao.IUserInfoDao;
import cn.com.dao.impl.*;
import cn.com.service.*;
/**
 * 用户信息服务实现类
 * @author
 */
public class UserInfoServiceImpl implements IUserInfoService,IPageDao{
	//用户信息操作类的引用
   private UserInfoDaoImpl userInfoDao=new UserInfoDaoImpl();
    /**
   * 登录的服务
   * @return UserInfo
   */
	@Override
	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
		
		
		return userInfoDao.login(userInfo);
	}
  /**
   * 按唯一条件获取用户信息的服务
   *@return UserInfo 
   */
	@Override
	public UserInfo getUserInfoByUnique(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserInfoByUnique(userInfo);
	}
  /**
   * 添加用户信息的服务
   *@return boolean 
   */
	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub4
		boolean flag=false;
		if( userInfoDao.addUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 修改用户信息的服务
   *@return boolean 
   */
	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(userInfoDao.updateUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 修改用户密码的服务
   *@return boolean 
   */
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
	/**
	 *获取用户信息总记录数
	 * 
	 * @return int
	 */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return userInfoDao.queryPersonCarCount(object);
	}
	/**
	 * 分页获取用户信息
	 * @param curPage 当前页
	 * @param rowsPrePage 每页显示记录条数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return userInfoDao.showPersonCarList(curPage, rowsPrePage, object);
	}

}
