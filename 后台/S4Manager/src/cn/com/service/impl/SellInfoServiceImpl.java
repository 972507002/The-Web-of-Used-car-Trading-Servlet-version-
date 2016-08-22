package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;
import cn.com.dao.ISellInfoDao;
import cn.com.dao.impl.SellInfoDaoImpl;
import cn.com.service.ISellInfoService;

public class SellInfoServiceImpl implements ISellInfoService{
private ISellInfoDao sellInfoDao=new SellInfoDaoImpl();
	@Override
	/**
	 * 获取所有销售信息业务
	 */
	public Map<Long, SellInfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		return sellInfoDao.getAllSellInfo();
	}

	@Override
	/**
	 * 根据车编号获取销售情况业务
	 */
	public SellInfo getSellInfoById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.getSellInfoById(carInfo);
	}
	/**
	 * 增加销售情况业务
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
	 * 删除销售情况业务
	 */
	@Override
	public int deleteSellInfo(SellInfo sellInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.deleteSellInfo(sellInfo);
	}

	@Override
	public boolean updateSellInfo(SellInfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.updateSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}

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

	@Override
	public boolean checksellinfouser(SellInfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checksellinfouser(s);
	}

	@Override
	public boolean checkcidsellinfouser(SellInfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checkcidsellinfouser(s);
	}

}
