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
	if(object!=null){
		UserInfo userInfo=(UserInfo) object;
		if(userInfo.getU_admin().equals("����Ա")){
			arg2.doFilter(arg0, arg1);
		}
		else{
         resp.sendRedirect("/S4Manager/UserInfo.action?op=needLogin");
		}
	}
	else{
		resp.sendRedirect("/S4Manager/UserInfo.action?op=needLogin");
	}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
