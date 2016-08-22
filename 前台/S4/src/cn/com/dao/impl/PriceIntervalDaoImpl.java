package cn.com.dao.impl;

import java.sql.*;
import java.util.*;
import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;

public class PriceIntervalDaoImpl implements IPriceIntervalDao{

	@Override
	public Map<Integer, PriceInterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		Map<Integer, PriceInterval> priceIntervalMap=new HashMap<Integer, PriceInterval>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from priceinterval  a order by p_count desc) b  where rownum<5)");
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
			PriceInterval priceInterval=new PriceInterval();
			priceInterval.setP_id(res.getInt("p_id"));
			priceInterval.setP_name(res.getString("p_name"));
			priceInterval.setP_count(res.getLong("p_count"));
			priceIntervalMap.put(priceInterval.getP_id(),priceInterval);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return priceIntervalMap;
	}

}
