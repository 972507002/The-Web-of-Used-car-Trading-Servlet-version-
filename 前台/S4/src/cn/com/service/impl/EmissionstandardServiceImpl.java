package cn.com.service.impl;
import java.util.*;

import cn.com.bean.*;

import cn.com.dao.IEmissionstandardDao;
import cn.com.dao.impl.*;
import cn.com.service.*;

public class EmissionstandardServiceImpl implements IEmissionstandardService {
    private IEmissionstandardDao emissionstandardDao=new EmissionstandardDaoImpl();
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandardByCount();
	}

}
