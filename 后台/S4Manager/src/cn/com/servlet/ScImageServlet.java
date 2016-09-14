package cn.com.servlet;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 图片上传引擎
 * @author lej
 */
public class ScImageServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {


	  public ScImageServlet() {
	    super();
	  }     

	  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request,response);
	  }     
	  
	  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  HttpSession session=request.getSession();
		  bancfsc(request,session); //禁止重复上传
		  String filepath =session.getServletContext().getRealPath("/tepimages")+"/"; //获取文件保存路径
	      String filename = "";  
	      String type="";  
	      ServletInputStream in = request.getInputStream();   //获取上传读取流
	      
	      byte[] buf = new byte[4048];  
	      int len = in.readLine(buf, 0, buf.length);   //标识符字节流
	      String f = new String(buf, 0, len - 1);   
	      while ((len = in.readLine(buf, 0, buf.length)) != -1) {  
	          filename = new String(buf, 0, len);  
	          int j = filename.lastIndexOf("\"");  
	          int p = filename.lastIndexOf(".");   
	        //文件类型
	          type=filename.substring(p,j);     
	           //文件名称  
	          filename = System.currentTimeMillis()+type;    
	          DataOutputStream fileStream = new DataOutputStream(  
	          new BufferedOutputStream(new FileOutputStream(filepath+ filename))  
	          );   //创建一个将数据写入指定输出流out的数据输出流

	          len = in.readLine(buf, 0, buf.length);    //标识符字节流
	          len = in.readLine(buf, 0, buf.length);    //标识符字节流
	          while ((len = in.readLine(buf, 0, buf.length)) != -1) {  
	              String tempf = new String(buf, 0, len - 1);   //判断读取是否为标识符
	              if (tempf.equals(f) || tempf.equals(f + "--")) {  
	                  break;      
	              }  
	              else{  
	           // 写入
	                   fileStream.write(buf, 0, len);  
	              }  
	          }  
	          fileStream.close();
	        session.setAttribute("sctname", filename);
	      }  
	      //异步返回结果
	      PrintWriter out=response.getWriter();  
	      String result = filename ;  
	      out.print(result);  
	      out.close();  
	      in.close();  
	  }
	   /**
	   * 检测重复上传的方法
	   * 
	   * 
	   */
	  private void bancfsc(HttpServletRequest request,HttpSession session){
		  String	sctname=request.getParameter("sctname");
			 if(sctname!=null&&!sctname.equals(""))  {String url=session.getServletContext().getRealPath("/tepimages")+"/"+sctname;
			    File file=new File(url);
			    if(file.exists()){
			    	file.delete(); //若存在则删除
			    }
			   }
	  }
}
