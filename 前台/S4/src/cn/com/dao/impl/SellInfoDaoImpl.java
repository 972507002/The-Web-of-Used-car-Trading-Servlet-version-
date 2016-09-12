package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;
import cn.com.dao.ISellInfoDao;
import cn.com.util.DbUtil;
 /**
  * 
  * 销售信息操作实现类
  * @author lej
  */
public class SellInfoDaoImpl implements ISellInfoDao{
        /**
	 * 获取所有销售信息
	 * @return   Map<Long, SellInfo>
	 */
	@Override
	public Map<Long, SellInfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		String sql="select * from sellinfo";
		Map<Long, SellInfo> sellInfoMap=new HashMap<Long, SellInfo>();
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, null);
		try {
			while(res.next()){
				SellInfo sellInfo=new SellInfo();
				sellInfo.setU_id(res.getLong("u_id"));
				sellInfo.setC_id(res.getLong("c_id"));
				sellInfo.setPriceType(res.getString("priceType"));
				sellInfo.setTransferFee(res.getString("transferFee"));
				sellInfo.setStage(res.getString("stage"));
				sellInfoMap.put(sellInfo.getU_id(), sellInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellInfoMap;
	}
/**
 * 根据车编号获取销售信息
 * @return SellInfo
 */
	@Override
	public SellInfo getSellInfoById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		SellInfo sellInfo2=null;
		String sql="select * from sellInfo where u_id=? and c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add( carInfo.getU_id());
		params.add(carInfo.getC_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next()){
				sellInfo2=new SellInfo();
				sellInfo2.setU_id(res.getLong("u_id"));
				sellInfo2.setC_id(res.getLong("c_id"));
				sellInfo2.setPriceType(res.getString("priceType"));
				sellInfo2.setTransferFee(res.getString("transferFee"));
				sellInfo2.setStage(res.getString("stage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellInfo2;
	}
/**
 * 增加销售信息
 * @param sellInfo
 * @return int
 */
	@Override
	public int addSellInfo(SellInfo sellInfo) {
		// TODO Auto-generated method stub
		String sql="insert into sellinfo values(?,?,?,?,?)";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add( sellInfo.getU_id());
		params.add( sellInfo.getC_id());
		params.add( sellInfo.getPriceType());
		params.add( sellInfo.getTransferFee());
		params.add( sellInfo.getStage());
		
		return DbUtil.executeUpdate(sql, params);
	}
/**
 * 删除销售信息
 * @param sellInfo
 * @return int
 */
	@Override
	public int deleteSellInfo(SellInfo sellInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("delete * from sellinfo where 1=1");
		//动态绑定参数和延伸sql语句
		List<Object> params=new ArrayList<Object>();
		if(sellInfo.getU_id()!=0){
			sql.append(" and u_id=?");
			params.add( sellInfo.getU_id());
		}
		if(sellInfo.getC_id()!=0&&sellInfo.getU_id()==0){
			sql.append(" and c_id=?");
			params.add( sellInfo.getC_id());
		}
		int count=DbUtil.executeUpdate(sql.toString(), params);
		return count;
	}
/**
 * 修改销售信息
 * @param sellInfo
 * @return int
 */
@Override
public int updateSellInfo(SellInfo sellInfo) {
	// TODO Auto-generated method stub
	List<Object> params=new ArrayList<Object>();
	StringBuffer sql=new StringBuffer("update  sellinfo set priceType=?,transferFee=?,stage=? where u_id=? and c_id=?");
	//绑定参数
	params.add(sellInfo.getPriceType());
	params.add(sellInfo.getTransferFee());
	params.add(sellInfo.getStage());
	
	
		params.add(sellInfo.getU_id());
	
	
		params.add(sellInfo.getC_id());
	
	
	return DbUtil.executeUpdate(sql.toString(), params);
}

}
