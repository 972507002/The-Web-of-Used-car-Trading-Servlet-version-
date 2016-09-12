package cn.com.dao.impl;
import cn.com.bean.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 公司动态消息操作实现类
 * @author
 */
public class TrendsDaoImpl  implements ITrendsDao,IPageDao {
       /**
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
	@Override
	public List<Trends> getITrendsByTime(Trends trends,int rows) {
		// TODO Auto-generated method stub
		List<Trends> trendsMap=new ArrayList<Trends>();
		StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from");
		sql.append("(select  to_char(tr_date,'yyyy-mm-dd') y, a.* from trends  a  where a.tr_type=? order by tr_date desc ) b  where rownum<"+rows+")");
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(trends.getTr_type());
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), parmas);
		try {
			while(res.next()){
				Trends _Trends=new Trends();
				_Trends.setTr_date(res.getString("y"));
				_Trends.setTr_id(res.getLong("tr_id"));
				_Trends.setTr_text(res.getString("tr_text"));
				_Trends.setTr_title(res.getString("tr_title"));
				_Trends.setTr_type(res.getString("tr_type"));
				_Trends.setTr_img(res.getString("tr_img"));
				trendsMap.add(_Trends);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return trendsMap;
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
 * 获取公司动态消息记录的总条数
 * 
 * @return int
 */
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		int count=0;
		Trends trends=(Trends) object;
		List<Object> parmas=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("select count(*) from trends where 1=1");
		if(trends.getTr_type()!=null){
			sql.append(" and tr_type=?");
			parmas.add(trends.getTr_type());
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
   * 分页获取公司动态消息
   * @param curPage 当前页
   * @param rowsPrePage 每页显示记录条数
   * @return Map<Long,Object>
   */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Trends trends=(Trends) object;
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select  to_char(tr_date,'yyyy-mm-dd') y, a.* from trends  a  where 1=1");
		 Map<Long, Object> trendsMap=new HashMap<Long, Object>();
		 //动态绑定参数和延伸sql语句
			List<Object> params=new ArrayList<Object>();

			if(trends.getTr_type()!=null){
				sql.append(" and tr_type=?");
				params.add(trends.getTr_type());
			}
			sql.append(" order by tr_date desc ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			//获取结果集
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
			
		    try {
				while(res.next()){
					Trends _Trends=new Trends();
					_Trends.setTr_date(res.getString("y"));
					_Trends.setTr_id(res.getLong("tr_id"));
					_Trends.setTr_text(res.getString("tr_text"));
					_Trends.setTr_title(res.getString("tr_title"));
					_Trends.setTr_type(res.getString("tr_type"));
					_Trends.setTr_img(res.getString("tr_img"));
					trendsMap.put(_Trends.getTr_id(),_Trends);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trendsMap;
	}
       /**
        * 按编号获取动态消息
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		Trends _Trends=null;
		List<Trends> trendsMap=new ArrayList<Trends>();
		StringBuffer sql=new StringBuffer("select  to_char(tr_date,'yyyy-mm-dd') y, a.* from trends  a  where 1=1 ");
		List<Object> parmas=new ArrayList<Object>();
		//动态绑定参数和延伸sql语句
		if(trends.getTr_id()!=0){
			sql.append(" and tr_id=?");
			parmas.add(trends.getTr_id());
		}
		//获取结果集
		ResultSet res=  DbUtil.executeQuery(sql.toString(), parmas);
		try {
			while(res.next()){
				_Trends=new Trends();
				_Trends.setTr_date(res.getString("y"));
				_Trends.setTr_id(res.getLong("tr_id"));
				_Trends.setTr_text(res.getString("tr_text"));
				_Trends.setTr_title(res.getString("tr_title"));
				_Trends.setTr_type(res.getString("tr_type"));
				_Trends.setTr_img(res.getString("tr_img"));
				trendsMap.add(_Trends);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return _Trends;
	}

} 
