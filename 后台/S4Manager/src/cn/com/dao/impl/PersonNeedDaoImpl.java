package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import cn.com.util.*;
import cn.com.bean.*;
import cn.com.dao.*;

/**
 * 个人需求信息操作实现类
 *@author 
 */
public class PersonNeedDaoImpl implements IPersonNeedDao,IPageDao{

 /**
   * 
   * 添加个人需求信息的方法
   *@return int 
   */
	@Override
	public int addPersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		String sql="insert into personneed values(seq_personneed.nextval,?,?,?,?,?,to_date(?,'yyyy-mm'),?,?,to_date(?,'yyyy-mm-dd HH24:mi:ss'))";
		//绑定参数
		params.add(personNeed.getU_id());
		params.add(personNeed.getP_brand());
		params.add(personNeed.getP_series());
		params.add(personNeed.getP_age());
		params.add(personNeed.getP_price());
		params.add(personNeed.getP_time());
		params.add(personNeed.getP_miaoshu());
		params.add(personNeed.getP_state());
		params.add(personNeed.getP_tjtime());
		int count=DbUtil.executeUpdate(sql, params);
		return count;
	}
 /**
   * 
   * 删除个人需求信息的方法
   *@return int 
   */
	@Override
	public int deletePersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("delete from personneed where 1=1");
		//动态绑定参数和延伸Sql语句
		if(personNeed.getP_id()!=0){
			sql.append(" and p_id=?");
			params.add(personNeed.getP_id());
		}
		if(personNeed.getU_id()!=0){
			sql.append(" and u_id=?");
			params.add(personNeed.getU_id());
		}
		int count=DbUtil.executeUpdate(sql.toString(), params); //获取受影响的行数
		return count;
	}
  /**
   * 
   * 获取个人需求信息的方法
   *@return PersonNeed
   */
	@Override
	public PersonNeed getPerSonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		 PersonNeed _PersonNeed=null;
		StringBuffer sql=new StringBuffer("select * from personneed where 1=1 ");
		//动态绑定参数和延伸Sql语句
		List<Object> parmas=new ArrayList<Object>();
		if(personNeed.getU_id()!=0){
			sql.append(" and u_id=? ");
			parmas.add(personNeed.getU_id());
		}
		if(personNeed.getP_brand()!=null){
			sql.append(" and p_brand=? ");
			parmas.add(personNeed.getP_brand());
		}
if(personNeed.getP_age()!=null){
	sql.append(" and p_age=? ");
	parmas.add(personNeed.getP_age());
		}
if(personNeed.getP_series()!=null){
	sql.append(" and p_series=? ");
	parmas.add(personNeed.getP_series());
}
if(personNeed.getP_miaoshu()!=null&&!personNeed.getP_miaoshu().equals("")){
	sql.append(" and p_miaoshu=? ");
	parmas.add(personNeed.getP_miaoshu());
}
if(personNeed.getP_time()!=null){
	sql.append(" and p_time=to_date(?,'yyyy-mm') ");
	parmas.add(personNeed.getP_time());
}
if(personNeed.getP_price()!=null){
	sql.append(" and p_price=? ");
	parmas.add(personNeed.getP_price());
}
if(personNeed.getP_state()!=null){
	sql.append(" and p_state=? ");
	parmas.add(personNeed.getP_state());
}
//获取结果集
       ResultSet res=  DbUtil.executeQuery(sql.toString(), parmas);
		try {
			while(res.next()){
				_PersonNeed=new PersonNeed();
				_PersonNeed.setP_id(res.getLong("p_id"));
				_PersonNeed.setU_id(res.getLong("u_id"));
				_PersonNeed.setP_brand(res.getString("p_brand"));
				_PersonNeed.setP_series(res.getString("p_series"));
				_PersonNeed.setP_price(res.getString("p_price"));
				_PersonNeed.setP_time(res.getString("p_time"));
				_PersonNeed.setP_age(res.getString("p_age"));
				_PersonNeed.setP_state(res.getString("p_state"));
				_PersonNeed.setP_miaoshu(res.getString("p_miaoshu"));
				_PersonNeed.setP_tjtime(res.getString("p_tjtime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return _PersonNeed;
	}

	@Override
	public int queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * 获取符合条件的个人需求信息的记录总条数
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		int count=0;
		 PersonNeed personNeed=(PersonNeed) object;
		StringBuffer sql=new StringBuffer("select count(*) from personneed where 1=1");
		//动态绑定参数和延伸sql语句
		List<Object> parmas=new ArrayList<Object>();
		if(personNeed.getU_id()!=0){
			sql.append(" and u_id=?");
			parmas.add(personNeed.getU_id());
		}
		if(personNeed.getP_state()!=null){
			sql.append(" and p_state=? ");
			parmas.add(personNeed.getP_state());
		}
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), parmas);
	try {
		while(res.next()){
		count=	res.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return count;
	}
/**
 * 分页获取符合条件的个人需求信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		PersonNeed personNeed=(PersonNeed) object;
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select  to_char(p_tjtime,'yyyy-mm-dd') y, to_char(p_time,'yyyy-mm') n,  a.* from personneed  a  where 1=1");
		 Map<Long, Object> personNeedMap=new HashMap<Long, Object>();
		   //动态绑定参数和延伸sql语句
			List<Object> params=new ArrayList<Object>();
			if(personNeed.getU_id()!=0){
				sql.append(" and u_id=?");
				params.add(personNeed.getU_id());
			}
			if(personNeed.getP_state()!=null){
				sql.append(" and p_state=? ");
				params.add(personNeed.getP_state());
			}
			
			sql.append(" order by p_tjtime desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			//获取结果集
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
			
		    try {
				while(res.next()){
				PersonNeed	_PersonNeed=new PersonNeed();
					_PersonNeed.setP_id(res.getLong("p_id"));
					_PersonNeed.setU_id(res.getLong("u_id"));
					_PersonNeed.setP_brand(res.getString("p_brand"));
					_PersonNeed.setP_series(res.getString("p_series"));
					_PersonNeed.setP_price(res.getString("p_price"));
					_PersonNeed.setP_time(res.getString("n"));
					_PersonNeed.setP_age(res.getString("p_age"));
					_PersonNeed.setP_state(res.getString("p_state"));
					_PersonNeed.setP_miaoshu(res.getString("p_miaoshu"));
					_PersonNeed.setP_tjtime(res.getString("y"));
					personNeedMap.put(_PersonNeed.getP_id(),_PersonNeed);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return personNeedMap;
	}
    /**
   * 
   * 修改个人需求信息的方法
   *@return int 
   */
	@Override
	public int updatePersonNeed(PersonNeed personNeed) {
		// TODO Auto-generated method stub
		String sql="update personneed set p_state=? where p_id=?";
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(personNeed.getP_state());
		parmas.add(personNeed.getP_id());
		return DbUtil.executeUpdate(sql, parmas);
	}
/**
 * 
 * 检查是否还有与某用户编号关联的个人需求信息
 * @return boolean
 */
	@Override
	public boolean chekUidPerson(PersonNeed personneed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from personneed where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(personneed.getU_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true; //若结果集存在，则返回为真
				break; //跳出循环
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
/**
 * 根据用户编号删除个人需求信息的方法
 *@return int  
 */;
	@Override
	public int deleteUidPerson(PersonNeed personneed) {
		// TODO Auto-generated method stub
		String sql="delete from personneed where u_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(personneed.getU_id());
		return DbUtil.executeUpdate(sql, params);
	}

}
