package cn.com.dao;
import java.util.Map;

import cn.com.bean.*;
/**
 * 用户信息操作接口
 * @author
 */
public interface IUserInfoDao {
  /**
   * 登录的方法
   * @return UserInfo
   */
  public UserInfo login(UserInfo userInfo);
  /**
   * 按唯一条件获取用户信息的方法
   *@return UserInfo 
   */
  public UserInfo getUserInfoByUnique(UserInfo userInfo);
   /**
   * 添加用户信息的方法
   *@return int 
   */
  public int addUserInfo(UserInfo userInfo);
   /**
   * 修改用户信息的方法
   *@return int 
   */
  public int updateUserInfo(UserInfo userInfo);
   /**
   * 修改用户密码的方法
   *@return int 
   */
  public int updateUserPwd(UserInfo userInfo);
}
