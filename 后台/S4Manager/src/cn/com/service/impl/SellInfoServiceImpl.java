package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;
import cn.com.dao.ISellInfoDao;
import cn.com.dao.impl.SellInfoDaoImpl;
import cn.com.service.ISellInfoService;
/**
  * 
  * 销售信息服务实现类
  * @author lej
  */
public class SellInfoServiceImpl implements ISellInfoService{
	//销售信息操作接口的引用
private ISellInfoDao sellInfoDao=new SellInfoDaoImpl();
        /**
	 * 获取所有销售信息的服务
	 * @return   Map<Long, SellInfo>
	 */
	@Override
	public Map<Long, SellInfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		return sellInfoDao.getAllSellInfo();
	}
/**
 * 根据车编号获取销售信息的服务
 * @return SellInfo
 */
	@Override
	public SellInfo getSellInfoById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.getSellInfoById(carInfo);
	}
/**
 * 增加销售信息的服务
 * @param sellInfo
 * @return int
 */
	@Override
	public boolean addSellInfo(SellInfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.addSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 删除销售信息的服务
 * @param sellInfo
 * @return int 成功返回1 否则返回0
 */
	@Override
	public int deleteSellInfo(SellInfo sellInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.deleteSellInfo(sellInfo);
	}
/**
 * 修改销售信息的服务
 * @param sellInfo
 * @return boolean
 */
	@Override
	public boolean updateSellInfo(SellInfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.updateSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 根据车主编号删除销售信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletesellinfouser(SellInfo s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.deletesellinfouser(s)>0	)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车编号删除销售信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecidsellinfouser(SellInfo s) {
		// TODO Auto-generated method stub\
		boolean flag=false;
		if(sellInfoDao.deletecidsellinfouser(s)>0	)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 
 * 检查是否还有与某车主编号关联的销售信息的服务
 * @return boolean
 */
	@Override
	public boolean checksellinfouser(SellInfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checksellinfouser(s);
	}
 /**
 * 
 * 检查是否还有与某车编号关联的销售信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidsellinfouser(SellInfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checkcidsellinfouser(s);
	}

}
