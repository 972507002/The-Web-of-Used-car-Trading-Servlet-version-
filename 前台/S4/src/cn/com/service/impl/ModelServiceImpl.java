package cn.com.service.impl;

import java.util.*;


import cn.com.bean.*;

import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
/**
 * 车系信息服务实现类
 * @author lej
 */
public class ModelServiceImpl implements IModelService{
	//车系信息服务接口的引用
  private IModelDao modelDao=new ModelDaoImpl();
      /**
       * 按条件获取车系信息的服务
       * @parma model
       *@return List<Model> 
       */
@Override
public List<Model> getModelByWhere(Model model) {
	// TODO Auto-generated method stub
	return modelDao.getModelByWhere(model);
}
}
