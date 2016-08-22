package cn.com.dao;

import cn.com.bean.*;

public interface IPersonNeedDao {
public int addPersonNeed(PersonNeed personNeed);
public int deletePersonNeed(PersonNeed personNeed);
public PersonNeed getPerSonNeed(PersonNeed personNeed);
public int updatePersonNeed(PersonNeed personNeed);
public boolean chekUidPerson(PersonNeed personneed);
public int deleteUidPerson(PersonNeed personneed);
}
