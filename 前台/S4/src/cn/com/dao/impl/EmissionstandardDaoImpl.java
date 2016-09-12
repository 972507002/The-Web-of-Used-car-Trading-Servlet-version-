package cn.com.dao.impl;
import java.sql.*;
import java.util.*;
import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 
 * 排放标准操作实现类
 *@author  lej
 */
public class EmissionstandardDaoImpl implements IEmissionstandardDao {
        /**
	 * 按热度获取排放标准信息的方法
	 * @Map<Integer,Emissionstandard>
	 */
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  a.* from emissionstandard  a order by e_count desc) b  where rownum<6)");
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), null);
	try {
		while(res.next()){
			Emissionstandard emissionstandard=new Emissionstandard();
			emissionstandard.setE_id(res.getInt("e_id"));
			emissionstandard.setE_name(res.getString("e_name"));
			emissionstandard.setE_count(res.getLong("e_count"));
			emissionstandardMap.put(emissionstandard.getE_id(),emissionstandard);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return emissionstandardMap;
	}

}
