package cn.com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import cn.com.bean.Model;
import cn.com.service.IModelService;
import cn.com.service.impl.ModelServiceImpl;
import cn.com.util.DbUtil;
/**
 * 车系操作引擎类
 * 
 */
public class ModelServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//车系服务的引用
		IModelService modelService=new ModelServiceImpl();
		String op=req.getParameter("op");//操作命令符
		//获取某品牌下的车系的操作
		if(op.equals("bindModel")){
		int b_id=Integer.parseInt(req.getParameter("brand"));
		Model model=new Model();
		model.setB_id(b_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	    //list json转换
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	  resp.setContentType("text/html;charset=utf-8");//设置上下文编码，格式
	  resp.getWriter().println(jsonArray);
		resp.getWriter().flush()//清空缓存，刷新
		resp.getWriter().close();
		}
		
	}

}
