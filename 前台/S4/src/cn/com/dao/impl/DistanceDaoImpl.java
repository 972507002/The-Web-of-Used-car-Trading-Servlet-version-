package cn.com.dao.impl;
import java.sql.*;
import java.util.*;
import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;

public class DistanceDaoImpl implements IDistanceDao {

	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Distance> distanceMap=new HashMap<Integer, Distance>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from distance  a order by d_count desc) b  where rownum<5)");
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
			Distance distance=new Distance();
			distance.setD_id(res.getInt("d_id"));
			distance.setD_name(res.getString("d_name"));
			distance.setD_count(res.getLong("d_count"));
			distanceMap.put(distance.getD_id(),distance);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return distanceMap;
	}

}
