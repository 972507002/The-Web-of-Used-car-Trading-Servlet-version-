package cn.com.service;

import cn.com.bean.*;

/**
 * 个人需求信息服务接口
 *@author 
 */
public interface IPersonNeedService {
  /**
   * 
   * 添加个人需求信息的服务
   *@return boolean 
   */
	public boolean addPersonNeed(PersonNeed personNeed);
  /**
   * 
   * 删除个人需求信息的服务
   *@return boolean 
   */
	public boolean deletePersonNeed(PersonNeed personNeed);
  /**
   * 
   * 获取个人需求信息的服务
   *@return PersonNeed
   */
	public PersonNeed getPerSonNeed(PersonNeed personNeed);
  /**
   * 
   * 修改个人需求信息的服务
   *@return boolean 
   */
	public boolean updatePersonNeed(PersonNeed personNeed);
/**
 * 
 * 检查是否还有与某用户编号关联的个人需求的服务
 * @return boolean
 */
	public boolean chekUidPerson(PersonNeed personneed);
/**
 * 根据用户编号删除个人需求信息的服务
 *@return boolean  
 */;
	public boolean deleteUidPerson(PersonNeed personneed);
}
