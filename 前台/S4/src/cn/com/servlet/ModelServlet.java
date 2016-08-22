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

public class ModelServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		IModelService modelService=new ModelServiceImpl();
		String op=req.getParameter("op");
		if(op.equals("bindModel")){
		int b_id=Integer.parseInt(req.getParameter("brand"));
		Model model=new Model();
		model.setB_id(b_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	  resp.setContentType("text/html;charset=utf-8");
	  resp.getWriter().println(jsonArray);
		resp.getWriter().flush();//Çå¿Õ»º´æ,Ë¢ÐÂ
		resp.getWriter().close();
		}
		
	}

}
