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
 /**
   * 
   * 修改个人需求信息的方法
   *@return int 
   */
public int updatePersonNeed(PersonNeed personNeed);
/**
 * 
 * 检查是否还有与某用户编号关联的个人需求信息
 * @return boolean
 */
public boolean chekUidPerson(PersonNeed personneed)
/**
 * 根据用户编号删除个人需求信息的方法
 *@return int  
 */;
public int deleteUidPerson(PersonNeed personneed);
}
