package cn.com.servlet;


import java.io.BufferedInputStream;
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

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;



public class ScImageServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {


	  public ScImageServlet() {
	    super();
	  }     

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request,response);
	  }     
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  HttpSession session=request.getSession();
		  bancfsc(request,session);
		  String filepath =session.getServletContext().getRealPath("/tepimages")+"/";
	      String filename = "";  
	      String type="";  
	      ServletInputStream in = request.getInputStream(); 
	      
	      byte[] buf = new byte[4048];  
	      int len = in.readLine(buf, 0, buf.length);  
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
	          );  

	          len = in.readLine(buf, 0, buf.length);   
	          len = in.readLine(buf, 0, buf.length);   
	          while ((len = in.readLine(buf, 0, buf.length)) != -1) {  
	              String tempf = new String(buf, 0, len - 1);  
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
	      PrintWriter out=response.getWriter();  
	      String result = filename ;  
	      out.print(result);  
	      out.close();  
	      in.close();  
	  }
	  private void bancfsc(HttpServletRequest request,HttpSession session){
		  String	sctname=(String)  request.getParameter("sctname");
		 if(sctname!=null&&!sctname.equals(""))  {String url=session.getServletContext().getRealPath("/tepimages")+"/"+sctname;
		    File file=new File(url);
		    if(file.exists()){
		    	file.delete();
		    }
		   }
	  }
}