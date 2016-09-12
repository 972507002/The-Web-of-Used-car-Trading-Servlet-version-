package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 车系信息操作实现类
 * @author lej
 */
public class ModelDaoImpl implements IModelDao {
      /**
       * 按条件获取车系信息的方法
       * @parma model
       *@return List<Model> 
       */
	@Override
	public List<Model> getModelByWhere(Model model) {
		// TODO Auto-generated method stub
		List<Model> modelMap=new ArrayList<Model>();
		StringBuffer sql=new StringBuffer("select * from model where 1=1 ");
		//动态绑定参数和延伸SQL语句
		List<Object> parmas=new ArrayList<Object>();
		if(model.getB_id()!=0){
			sql.append("and b_id=?");
			parmas.add(model.getB_id());
		}
		if(model.getM_id()!=0){
			sql.append("and m_id=?");
			parmas.add(model.getM_id());
		}
		if(model.getM_name()!=null){
			sql.append("and m_name=?");
			parmas.add(model.getM_name());
		}
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), parmas);
	try {
		while(res.next()){
			Model _Model=new  Model();
			_Model.setB_id(res.getInt("b_id"));
			_Model.setM_id(res.getInt("m_id"));
			_Model.setM_name(res.getString("m_name"));
			modelMap.add( _Model);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelMap;
	}

}
