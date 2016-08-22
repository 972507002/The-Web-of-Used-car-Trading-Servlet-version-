package cn.com.dao;
import java.util.Map;

import cn.com.bean.*;

public interface IUserInfoDao {
  public UserInfo login(UserInfo userInfo);
  public UserInfo getUserInfoByUnique(UserInfo userInfo);
  public int addUserInfo(UserInfo userInfo);
  public int updateUserInfo(UserInfo userInfo);
  public int updateUserPwd(UserInfo userInfo);
}
