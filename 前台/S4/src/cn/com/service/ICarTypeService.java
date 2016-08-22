package cn.com.service;

import cn.com.bean.*;

import java.util.*;


public interface ICarTypeService {
	public Map<Integer, CarType> getCarTypeByCount();
	public Map<Integer, CarType> getAllCarType();
}
