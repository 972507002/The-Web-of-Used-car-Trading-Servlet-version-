package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.bean.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 用户信息操作实现类
 * @author
 */
public class UserInfoDaoImpl implements IUserInfoDao ,IPageDao {
  /**
   * 登录的方法
   * @return UserInfo
   */
	@Override
	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
		UserInfo _userInfo=null;
		StringBuffer sql=new StringBuffer("select * from userinfo3 ");
		sql.append("where u_tel=? and u_pwd=?");
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(userInfo.getU_tel());
		parmas.add(userInfo.getU_pwd());
		//获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), parmas);
	try {
		while(res.next()){
			 _userInfo=new UserInfo();
			_userInfo.setU_id(res.getLong("u_id"));
			_userInfo.setU_tel(res.getLong("u_tel"));
			_userInfo.setU_pwd(res.getString("u_pwd"));
			_userInfo.setU_card(res.getLong("u_card"));
			_userInfo.setU_adr(res.getString("u_adr"));
			_userInfo.setU_qq(res.getLong("u_qq"));
			_userInfo.setU_email(res.getString("u_email"));
			_userInfo.setU_name(res.getString("u_name"));
			_userInfo.setU_sex(res.getString("u_sex"));
			_userInfo.setU_admin(res.getString("u_admin"));
	  
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return _userInfo;
	}
  /**
   * 按唯一条件获取用户信息的方法
   *@return UserInfo 
   */
	@Override
	public UserInfo getUserInfoByUnique(UserInfo userInfo) {
		// TODO Auto-generated method stub
		UserInfo _userInfo=null;
		StringBuffer sql=new StringBuffer("select * from userinfo3 ");
		sql.append("where 1=1 ");
		//动态绑定参数并延伸sql语句
		List<Object> parmas=new ArrayList<Object>();
	  if(userInfo.getU_tel()!=0){
		  sql.append(" and u_tel=? ");
		  parmas.add(userInfo.getU_tel());
	  }
	  if(userInfo.getU_id()!=0){
		  sql.append(" and u_id=? ");
		  parmas.add(userInfo.getU_id());
	  }
	  //获取结果集
	ResultSet res=	DbUtil.executeQuery(sql.toString(), parmas);
	try {
		while(res.next()){
			 _userInfo=new UserInfo();
			_userInfo.setU_id(res.getLong("u_id"));
			_userInfo.setU_tel(res.getLong("u_tel"));
			_userInfo.setU_pwd(res.getString("u_pwd"));
			_userInfo.setU_card(res.getLong("u_card"));
			_userInfo.setU_adr(res.getString("u_adr"));
			_userInfo.setU_qq(res.getLong("u_qq"));
			_userInfo.setU_email(res.getString("u_email"));
			_userInfo.setU_name(res.getString("u_name"));
			_userInfo.setU_sex(res.getString("u_sex"));
			_userInfo.setU_admin(res.getString("u_admin"));

	  
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return _userInfo;
	}
  /**
   * 添加用户信息的方法
   *@return int 
   */
	@Override
	public int addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("insert into userinfo3(u_id,u_tel,u_name,u_pwd,u_sex,u_admin) values(seq_userinfo3.nextval,?,?,?,?,?)");
		//绑定参数
		List<Object> parmas=new ArrayList<Object>();
		parmas.add(userInfo.getU_tel());
		parmas.add(userInfo.getU_name());
		parmas.add(userInfo.getU_pwd());
		parmas.add(userInfo.getU_sex());
		parmas.add(userInfo.getU_admin());
		
		return DbUtil.executeUpdate(sql.toString(), parmas);
	}
  /**
   * 修改用户信息的方法
   *@return int 
   */
	@Override
	public int updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update  userinfo3 set u_id=? ");
		List<Object> params=new ArrayList<Object>();
		//动态绑定参数和延伸sql语句
		params.add(userInfo.getU_id());
		if(userInfo.getU_name()!=null){
			sql.append(" , u_name=?");
			params.add(userInfo.getU_name());
		}
		if(userInfo.getU_sex()!=null){
			sql.append(" , u_sex=?");
			params.add(userInfo.getU_sex());
		}
		if(userInfo.getU_card()!=0){
			sql.append(" , u_card=?");
			params.add(userInfo.getU_card());
		}
		if(userInfo.getU_adr()!=null){
			sql.append(" , u_adr=?");
			params.add(userInfo.getU_adr());
		}
		if(userInfo.getU_qq()!=0){
			sql.append(" , u_qq=?");
			params.add(userInfo.getU_qq());
		}
		if(userInfo.getU_email()!=null){
			sql.append(" , u_email=?");
			params.add(userInfo.getU_email());
		}
		
		sql.append(" where u_id=?");
		params.add(userInfo.getU_id());
		
		return DbUtil.executeUpdate(sql.toString(), params);
	}
  /**
   * 修改用户密码的方法
   *@return int 
   */
	@Override
	public int updateUserPwd(UserInfo userInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("update userinfo3 set u_pwd=? where u_id=?");
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(userInfo.getU_pwd());
		params.add(userInfo.getU_id());
		return DbUtil.executeUpdate(sql.toString(), params);
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
     * 按条件获取用户信息的记录总条数
     * @return int
     */	
	@Override
	public int queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		int count=0;
		UserInfo userInfo=(UserInfo) object;
		List<Object> parmas=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("select count(*) from userinfo3 where 1=1");
			//动态绑定参数和延伸sql语句
		if(userInfo.getU_admin()!=null){
			sql.append(" and u_admin=?");
			parmas.add(userInfo.getU_admin());
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
 * 按条件分页获取用户信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		UserInfo userInfo=(UserInfo) object;
		 StringBuffer sql=new StringBuffer("select * from(select rownum rn , b.* from(select  a.* from userinfo3  a  where 1=1");
		 Map<Long, Object> userMap=new HashMap<Long, Object>();
			List<Object> params=new ArrayList<Object>();
                   	//动态绑定参数和延伸sql语句
			if(userInfo.getU_admin()!=null){
				sql.append(" and u_admin=?");
				params.add(userInfo.getU_admin());
			}
			sql.append("  ) b  where rownum<=("+curPage+")*("+rowsPrePage+")) where rn>(("+curPage+")-1)*("+rowsPrePage+")");
			//获取结果集
			ResultSet res=	 DbUtil.executeQuery(sql.toString(), params);
			
		    try {
				while(res.next()){
				UserInfo	 _userInfo=new UserInfo();
						_userInfo.setU_id(res.getLong("u_id"));
						_userInfo.setU_tel(res.getLong("u_tel"));
						_userInfo.setU_pwd(res.getString("u_pwd"));
						_userInfo.setU_card(res.getLong("u_card"));
						_userInfo.setU_adr(res.getString("u_adr"));
						_userInfo.setU_qq(res.getLong("u_qq"));
						_userInfo.setU_email(res.getString("u_email"));
						_userInfo.setU_name(res.getString("u_name"));
						_userInfo.setU_sex(res.getString("u_sex"));
						_userInfo.setU_admin(res.getString("u_admin"));

						userMap.put(_userInfo.getU_id(),_userInfo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userMap;
	}
 /**
   * 删除用户信息的方法
   *@return int 
   */
	@Override
	public int deleteuserinfouser(UserInfo u) {
		// TODO Auto-generated method stub
		String sql="delete from userinfo3 where U_ID=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(u.getU_id());
		int count=DbUtil.executeUpdate(sql, params);
		return count;
	}
   
}
