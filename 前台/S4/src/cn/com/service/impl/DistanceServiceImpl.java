package cn.com.service.impl;

import java.util.*;

import cn.com.bean.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class DistanceServiceImpl implements IDistanceService {
   private IDistanceDao distanceDao=new DistanceDaoImpl();
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceByCount();
	}

}
