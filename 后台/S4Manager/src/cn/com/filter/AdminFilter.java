package cn.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.bean.UserInfo;

/**
 * 权限过滤器
 * 
 * @author lej
 */
public class AdminFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) arg0;
		 HttpServletResponse resp=(HttpServletResponse) arg1;
		 HttpSession session=req.getSession();
		Object object=  session.getAttribute("userinfo");
	if(object!=null){   //获取session中的用户对象并检验是否为空
		UserInfo userInfo=(UserInfo) object;
		if(userInfo.getU_admin().equals("管理员")){ //判断对象的权限是否为管理员
			arg2.doFilter(arg0, arg1);  //是则通过请求
		}
		else{
         resp.sendRedirect("/S4Manager/UserInfo.action?op=needLogin");   //否则转向登陆页面
		}
	}
	else{
		resp.sendRedirect("/S4Manager/UserInfo.action?op=needLogin"); //否则转向登陆页面
	}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
