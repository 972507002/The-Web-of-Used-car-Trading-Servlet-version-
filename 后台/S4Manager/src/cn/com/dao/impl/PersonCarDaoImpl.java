package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 个人汽车订单信息操作实现类
 * @author lej
 */
public class PersonCarDaoImpl implements IPersonCarDao,IPageDao {
	//汽车概要信息操作接口的引用
    private ICarInfoDao carInfoDao=new CarInfoDaoImpl();
       /**
        * 根据条件获取用户订单信息数量
        * @return int
        */
	@Override
	public int getCarCountByWhere(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		int count=0;
		StringBuffer sql=new StringBuffer("select count(*) from personcar where u_id<>c_uid");
		List<Object> params=new ArrayList<Object>();
		if(perSonCar.getU_id()!=0){
			sql.append(" and u_id=? ");
			params.add(perSonCar.getU_id());
		}
		if(perSonCar.getP_state()!=null){
			sql.append(" and p_state=?");
			params.add(perSonCar.getP_state());
		}
ResultSet res=		DbUtil.executeQuery(sql.toString(), params);
		try {
			while(res.next()){
				count=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
      /**
        * 根据条件获取用户订单信息集合
        * @return  Map<Long, PerSonCar>
        */
	@Override
	public Map<Long, PerSonCar> getPerSonCarMapByWhere(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select * from personcar where 1=1");
		List<Object> params=new ArrayList<Object>();
		Map<Long, PerSonCar> perSonMap=new HashMap<Long, PerSonCar>();
		if(perSonCar.getU_id()!=0){
			sql.append(" and u_id=? ");
			params.add(perSonCar.getU_id());
		}
		if(perSonCar.getP_state()!=null){
			sql.append(" and p_state=?");
			params.add(perSonCar.getP_state());
		}
		if(perSonCar.getC_uid()!=0){
			sql.append(" and c_uid=? ");
			params.add(perSonCar.getC_uid());
		}
		if(perSonCar.getC_id()!=0){
			sql.append(" and c_id=? ");
			params.add(perSonCar.getC_id());
		}
	ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
    try {
		while(res.next()){
			PerSonCar _PerSonCar=new PerSonCar();
			_PerSonCar.setU_id(res.getLong("u_id"));
			_PerSonCar.setC_uid(res.getLong("c_uid"));
			_PerSonCar.setC_id(res.getLong("c_id"));
			_PerSonCar.setP_state(res.getString("p_state"));
			_PerSonCar.setP_id(res.getLong("p_id"));
			perSonMap.put(_PerSonCar.getP_id(),_PerSonCar);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return perSonMap;
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
        * 根据条件获取用户订单信息数量
        * @return int
        */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		PerSonCar perSonCar=(PerSonCar) object;  //强制转型
		return getCarCountByWhere(perSonCar);     //调用getCarCountByWhere(perSonCar) 方法
	}
        /**
	 * 根据条件分页获取用户订车详情集合
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		
		// TODO Auto-generated method stub
		PerSonCar perSonCar=(PerSonCar) object;
		Map<Long, Object> carMap=new HashMap<Long, Object>();
   Map<Long, PerSonCar>	perSonMap=	getPersonList(curPage,rowsPrePage,perSonCar);   //获取个人汽车订单集合
    //获取该用户所订车的详细信息
   for(Long key:perSonMap.keySet()){
	   CarInfo carInfo=new CarInfo();
	   carInfo.setC_id(perSonMap.get(key).getC_id());
	   carInfo.setU_id(perSonMap.get(key).getC_uid());
	   carMap.put(carInfo.getC_id(), carInfoDao.getCarByWhere(carInfo).get(carInfo.getC_id()));
   }
		return carMap;
	}
        /**
	 * 根据条件分页获取记录集合
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,PerSonCar>
	 */
	@Override
	public Map<Long, PerSonCar> getPersonList(int curPage, int rowsPrePage,PerSonCar perSonCar){
		 StringBuffer sql=new StringBuffer("select * from (select rownum rn , b. * from (select rownum  ,a.* from  (select * from personcar where u_id<>c_uid");
		 Map<Long, PerSonCar> perSonMap=new HashMap<Long, PerSonCar>();
			List<Object> params=new ArrayList<Object>();

			if(perSonCar.getU_id()!=0){
				sql.append(" and u_id=? ");
				params.add(perSonCar.getU_id());
			}
			if(perSonCar.getP_state()!=null){
				sql.append(" and p_state=?");
				params.add(perSonCar.getP_state());
			}
			sql.append(") a where rownum<=("+curPage+")*("+rowsPrePage+")) b) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
		         //获取结果集
		      	ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
		    try {
				while(res.next()){
					PerSonCar _PerSonCar=new PerSonCar();
					_PerSonCar.setU_id(res.getLong("u_id"));
					_PerSonCar.setC_uid(res.getLong("c_uid"));
					_PerSonCar.setC_id(res.getLong("c_id"));
					_PerSonCar.setP_state(res.getString("p_state"));
					_PerSonCar.setP_id(res.getLong("p_id"));
					perSonMap.put(_PerSonCar.getP_id(),_PerSonCar);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
			return perSonMap;
	}
       /**
        *  添加用户订单信息
        * @return int
        */
	@Override
	public int addPerSonCar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("insert into personcar(u_id,c_uid,c_id,p_state,p_id) values(?,?,?,?,seq_personcar.nextval)");
		 	//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_uid());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql.toString(), params);
	}
       /**
        *  删除用户订单信息
        * @return int
        */
	@Override
	public int deletePerSoncar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("delete from personcar where u_id=? and c_id=? and c_uid=? and p_state=?");
	        	//绑定参数
	    	List<Object> params=new ArrayList<Object>();
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getC_uid());
		
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql.toString(), params);
	}
       /**
        *  修改用户订单信息
        * @return int
        */
	@Override
	public int updatePerSoncar(PerSonCar perSonCar,String state) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update  personcar set  p_state=? where u_id=? and c_id=? and c_uid=? and p_state=?");
	      	//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(state);
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getC_uid());
		
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql.toString(), params);
	}
/**
 * 根据用户编号删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletepersoncaruser(PerSonCar u) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where u_id=?";
			//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(u.getU_id());
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 根据车编号删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletecidpersoncaruser(PerSonCar u) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where c_id=?";
			//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(u.getC_id());
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 
 * 检查是否还有与某用户编号关联的用户订单信息
 * @return boolean
 */
	@Override
	public boolean checkipersonuser(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from personcar where u_id=?";
			//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(p.getU_id()); 
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;  //若结果集存在，则返回为真
				break; //跳出循环
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
 /**
 * 
 * 检查是否还有与某车编号关联的用户订单信息
 * @return boolean
 */
	@Override
	public boolean checkcidipersonuser(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from personcar where c_id=?";
			//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;  //若结果集存在，则返回为真
				break; //跳出循环
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
 /**
 * 根据所有字段删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletePersonByAll(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where u_id=? and c_id=? and c_uid=? and p_state=?";
			//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getC_uid());
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 
 * 检查是否还有与某车主编号关联的用户订单信息
 * @return boolean
 */
	@Override
	public boolean checkcuidperson(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from personcar where c_uid=?";
			//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_uid());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;  //若结果集存在，则返回为真
				break;  //跳出循环
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
/**
 * 根据车主编号删除用户订单信息的方法
 *@return int  
 */
	@Override
	public int deletecuidperson(PerSonCar p) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where c_uid=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_uid());
		return DbUtil.executeUpdate(sql, params);
	}

}
