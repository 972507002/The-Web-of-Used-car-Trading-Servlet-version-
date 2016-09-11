package cn.com.dao;

import java.util.*;

import cn.com.bean.*;
/**
 * 公司动态消息操作接口
 * @author
 */
public interface ITrendsDao {
       /**
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
       public List<Trends>  getITrendsByTime(Trends trends,int rows);
           /**
        * 按编号获取动态消息
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
       public Trends getTrendsByWhere(Trends trends);
}
