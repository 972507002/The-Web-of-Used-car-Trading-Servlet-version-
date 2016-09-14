package cn.com.service;


import cn.com.bean.*;



/**
 * 用户信息服务接口
 * @author
 */
public interface IUserInfoService {
  /**
   * 登录的服务
   * @return UserInfo
   */
	public UserInfo login(UserInfo userInfo);
  /**
   * 按唯一条件获取用户信息的服务
   *@return UserInfo 
   */
	public UserInfo getUserInfoByUnique(UserInfo userInfo);
  /**
   * 添加用户信息的服务
   *@return boolean 
   */
	public boolean addUserInfo(UserInfo userInfo);
  /**
   * 修改用户信息的服务
   *@return boolean 
   */
	public boolean updateUserInfo(UserInfo userInfo);
  /**
   * 修改用户密码的服务
   *@return boolean 
   */
	public boolean updateUserPwd(UserInfo userInfo);
  /**
   * 删除用户信息的服务
   *@return boolean 
   */
	 public boolean deleteuserinfouser(UserInfo u);
}
