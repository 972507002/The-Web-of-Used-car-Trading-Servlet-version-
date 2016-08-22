package cn.com.dao;
import java.util.*;
public interface IPageDao {

	/**
	 * ��ȡ�ܼ�¼����
	 * @return int
	 */
	public int queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge);

	/**
	 * ����������ȡ��¼����
	 * @param curPage ��ǰҳ
	 * @param rowsPrePage ÿҳ���¼��
	 * @return Map<Integer,Object>
	 */
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge);
	
	public int queryPersonCarCount(Object object);

	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,Object object);


}
