package cn.com.dao;

import cn.com.bean.*;
/**
 * 个人需求信息操作接口
 *@author 
 */
public interface IPersonNeedDao {
  /**
   * 
   * 添加个人需求信息的方法
   *@return int 
   */
public int addPersonNeed(PersonNeed personNeed);
 /**
   * 
   * 删除个人需求信息的方法
   *@return int 
   */
public int deletePersonNeed(PersonNeed personNeed);
 /**
   * 
   * 获取个人需求信息的方法
   *@return PersonNeed
   */
public PersonNeed getPerSonNeed(PersonNeed personNeed);
}
