package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class ModelDaoImpl implements IModelDao {

	@Override
	public List<Model> getModelByWhere(Model model) {
		// TODO Auto-generated method stub
		List<Model> modelMap=new ArrayList<Model>();
		StringBuffer sql=new StringBuffer("select * from model where 1=1 ");
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

	@Override
	public int addModel(Model model) {
		// TODO Auto-generated method stub
		String sql="insert into model values(seq_model.nextval,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(model.getB_id());
		params.add(model.getM_name());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public int updateModel(Model model) {
		// TODO Auto-generated method stub
		String sql="update model set b_id=? ,m_name=? where m_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(model.getB_id());
		params.add(model.getM_name());
		params.add(model.getM_id());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public int deleteModel(Model model) {
		// TODO Auto-generated method stub
		String sql="delete from model where m_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(model.getM_id());
		return DbUtil.executeUpdate(sql, params);
		
	}

}
