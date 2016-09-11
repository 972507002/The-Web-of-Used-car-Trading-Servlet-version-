package cn.com.dao;
import java.util.*;
/**
 * 分页处理操作接口
 *@author lej 
 */
public interface IPageDao {

	/**
	 * 获取总记录条数
	 * @return int
	 */
	public int queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge);

	/**
	 * 根据条件获取记录集合
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Integer,Object>
	 */
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge);
	/**
	 * 获取总记录条数
	 * @return int
	 */
	public int queryPersonCarCount(Object object);
        /**
	 * 根据条件获取记录集合
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Integer,Object>
	 */
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,Object object);


}
