package cn.com.service.impl;

import java.util.*;


import cn.com.bean.*;

import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class ModelServiceImpl implements IModelService{
  private IModelDao modelDao=new ModelDaoImpl();

@Override
public List<Model> getModelByWhere(Model model) {
	// TODO Auto-generated method stub
	return modelDao.getModelByWhere(model);
}

@Override
public boolean addModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.addModel(model)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean updateModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.updateModel(model)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean deleteModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.deleteModel(model)>0){
		flag=true;
	}
	return flag;
}
}
