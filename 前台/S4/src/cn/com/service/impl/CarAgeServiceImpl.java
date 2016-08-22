package cn.com.service.impl;
import java.util.Map;

import cn.com.bean.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarAgeServiceImpl implements ICarAgeService {
  private ICarAgeDao carAgeDao=new CarAgeDaoImpl();
	@Override
	public Map<Integer, CarAge> getCarAgeByCount() {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeByCount();
	}

}
