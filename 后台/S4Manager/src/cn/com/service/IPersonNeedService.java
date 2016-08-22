package cn.com.service;

import cn.com.bean.*;


public interface IPersonNeedService {
	public boolean addPersonNeed(PersonNeed personNeed);
	public boolean deletePersonNeed(PersonNeed personNeed);
	public PersonNeed getPerSonNeed(PersonNeed personNeed);
	public boolean updatePersonNeed(PersonNeed personNeed);
	public boolean chekUidPerson(PersonNeed personneed);
	public boolean deleteUidPerson(PersonNeed personneed);
}
