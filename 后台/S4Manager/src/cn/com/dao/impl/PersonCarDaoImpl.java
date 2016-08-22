package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
public class PersonCarDaoImpl implements IPersonCarDao,IPageDao {
    private ICarInfoDao carInfoDao=new CarInfoDaoImpl();
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

	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		PerSonCar perSonCar=(PerSonCar) object;
		return getCarCountByWhere(perSonCar);
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		
		// TODO Auto-generated method stub
		PerSonCar perSonCar=(PerSonCar) object;
		Map<Long, Object> carMap=new HashMap<Long, Object>();
   Map<Long, PerSonCar>	perSonMap=	getPersonList(curPage,rowsPrePage,perSonCar);
   for(Long key:perSonMap.keySet()){
	   CarInfo carInfo=new CarInfo();
	   carInfo.setC_id(perSonMap.get(key).getC_id());
	   carInfo.setU_id(perSonMap.get(key).getC_uid());
	   carMap.put(carInfo.getC_id(), carInfoDao.getCarByWhere(carInfo).get(carInfo.getC_id()));
   }
		return carMap;
	}

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
	public int addPerSonCar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("insert into personcar(u_id,c_uid,c_id,p_state,p_id) values(?,?,?,?,seq_personcar.nextval)");
		List<Object> params=new ArrayList<Object>();
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_uid());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql.toString(), params);
	}

	@Override
	public int deletePerSoncar(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("delete from personcar where u_id=? and c_id=? and c_uid=? and p_state=?");
		List<Object> params=new ArrayList<Object>();
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getC_uid());
		
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql.toString(), params);
	}

	@Override
	public int updatePerSoncar(PerSonCar perSonCar,String state) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update  personcar set  p_state=? where u_id=? and c_id=? and c_uid=? and p_state=?");
		List<Object> params=new ArrayList<Object>();
		params.add(state);
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getC_uid());
		
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql.toString(), params);
	}

	@Override
	public int deletepersoncaruser(PerSonCar u) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where u_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(u.getU_id());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public int deletecidpersoncaruser(PerSonCar u) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where c_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(u.getC_id());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean checkipersonuser(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from personcar where u_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getU_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean checkcidipersonuser(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from personcar where c_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deletePersonByAll(PerSonCar perSonCar) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where u_id=? and c_id=? and c_uid=? and p_state=?";
		List<Object> params=new ArrayList<Object>();
		params.add(perSonCar.getU_id());
		params.add(perSonCar.getC_id());
		params.add(perSonCar.getC_uid());
		params.add(perSonCar.getP_state());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean checkcuidperson(PerSonCar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from personcar where c_uid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_uid());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deletecuidperson(PerSonCar p) {
		// TODO Auto-generated method stub
		String sql="delete from personcar where c_uid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_uid());
		return DbUtil.executeUpdate(sql, params);
	}

}
