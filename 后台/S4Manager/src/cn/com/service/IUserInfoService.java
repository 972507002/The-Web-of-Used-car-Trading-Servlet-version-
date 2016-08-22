package cn.com.service;


import cn.com.bean.*;




public interface IUserInfoService {
	public UserInfo login(UserInfo userInfo);
	public UserInfo getUserInfoByUnique(UserInfo userInfo);
	public boolean addUserInfo(UserInfo userInfo);
	public boolean updateUserInfo(UserInfo userInfo);
	public boolean updateUserPwd(UserInfo userInfo);
	 public boolean deleteuserinfouser(UserInfo u);
}
