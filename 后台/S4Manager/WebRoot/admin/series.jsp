﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<%
String path= request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript" src="js/showtime.js"></script>
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">

var xmlhttp = false;
function CreateXMLHttp(){
        try{
            xmlhttp = new XMLHttpRequest();  //尝试创建 XMLHttpRequest 对象，除 IE 外的浏览器都支持这个方法。
        }
        catch (e){
            try{
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");  //使用较新版本的 IE 创建 IE 兼容的对象（Msxml2.XMLHTTP）
            }
            catch (e){
                try{
                  xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //使用较老版本的 IE 创建 IE 兼容的对象（Microsoft.XMLHTTP）。
                }
                catch (failed){
                      xmlhttp = false;  //如果失败则保证 request 的值仍然为 false。
                }
            }
        }
        return xmlhttp;
}

function sendRequest(sel){
 
  var brand=sel.value;
  var sel2=document.all("sel2");
  
  if(sel.value!="选择品牌"){
  var url = "<%=basePath%>Model.action?brand="+brand+"&op=bindModel&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getResult; 
     xmlhttp.send(null); 
  }
  }
  else{
   sel2.length=0;
    sel2.options.add(new Option("请先选择品牌","请选择"))
    var sel2=document.all("dea");
    sel2.innerHTML="<font color='red'>请选择车系</font>";
  }
} 

function getResult(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
     var data=xmlhttp.responseText;
     var json=eval("("+data+")");
     var sel2=document.all("sel2");
     sel2.length=0;
     sel2.options.add(new Option("请选择","请选择"))
     for(var i=0;i<json.length;i++){
      sel2.options.add(new Option(json[i].m_name,json[i].m_id));
     }
  }
}


</script>
<script type="text/javascript">

var xmlhttp = false;
function CreateXMLHttp(){
        try{
            xmlhttp = new XMLHttpRequest();  //尝试创建 XMLHttpRequest 对象，除 IE 外的浏览器都支持这个方法。
        }
        catch (e){
            try{
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");  //使用较新版本的 IE 创建 IE 兼容的对象（Msxml2.XMLHTTP）
            }
            catch (e){
                try{
                  xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //使用较老版本的 IE 创建 IE 兼容的对象（Microsoft.XMLHTTP）。
                }
                catch (failed){
                      xmlhttp = false;  //如果失败则保证 request 的值仍然为 false。
                }
            }
        }
        return xmlhttp;
}

function sendDea(sel){
 var ser=sel.value;

  if(ser!="请选择"){
  var url = "<%=basePath%>Model.action?s_id="+ser+"&op=getDea&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
  
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getDea; 
     xmlhttp.send(null); 
  } 
  }
  else{
   var sel2=document.all("dea");
    sel2.innerHTML="<font color='red'>请选择车系</font>";
  }
} 

function getDea(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    
   var data=xmlhttp.responseText;
   
     var json=eval("("+data+")");
    
     var sel2=document.all("dea");
     
     for(var i=0;i<json.length;i++){
      sel2.innerHTML="车系编号:"+json[i].m_id+"车系名称:"+json[i].m_name+"<a href='Model.action?op=upser&mid="+json[i].m_id+"'>修改</a><input type='button' onclick='udelete("+json[i].m_id+")' value='删除' >";
     
     }
  }
}
function udelete(a)
{

var url="<%=basePath%>Model.action?op=delser&mid="+a;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>Model.action?op=showseries"
}
else
{
alert("删除失败")}
}
}
</script>
</head>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="/S4/index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li ><a href="/S4Manager/admin/index.jsp">首页</a></li>
			<li><a href="/S4Manager/Manager.action?op=showalluser">用户</a></li>
			<li class="current"><a href="/S4Manager/MgCar.action?op=showlist">商品</a></li>
			<li><a href="/S4Manager/Mgord.action?op=showallord">订单</a></li>
			<li><a href="/S4Manager/Trends.action?op=showcom">留言</a></li>
			<li><a href="/S4Manager/Trends.action?op=showalltrends">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
管理员<a href="/S4Manager/MgUsIn.action?op=showdeauser&uid=${userinfo.u_id }">${userinfo.u_name }</a>您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='16' />，欢迎回到管理后台。</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="/S4Manager/admin/user-add.jsp">新增</a></em><a href="/S4Manager/Manager.action?op=showalluser">所有用户</a></dd>
			    <dd><em><a href="/S4Manager/admin/user-add.jsp">新增</a></em><a href="/S4Manager/Manager.action?op=showuser">普通用户</a></dd>
				<dd><em><a href="/S4Manager/admin/user-add.jsp">新增</a></em><a href="/S4Manager/Manager.action?op=showadmin">管理员</a></dd>
				<dt>汽车信息</dt>
				<dd><em><a href="/S4Manager/admin/brand-add.jsp">新增</a></em><a href="/S4Manager/Model.action?op=showbrand">品牌管理</a></dd>
				<dd><em><a href="/S4Manager/Model.action?op=addseries">新增</a></em><a href="/S4Manager/Model.action?op=showseries">车系管理</a></dd>
				<dd><em><a href="/S4Manager/admin/age-add.jsp">新增</a></em><a href="/S4Manager/Model.action?op=showage">车龄管理</a></dd>
				<dd><em><a href="/S4Manager/admin/price-add.jsp">新增</a></em><a href="/S4Manager/Model.action?op=showprice">车价管理</a></dd>
				<dd><em><a href="/S4Manager/admin/distance-add.jsp">新增</a></em><a href="/S4Manager/Model.action?op=showdistance">行驶距离管理</a></dd>
				<dd><em><a href="/S4Manager/admin/emsi-add.jsp	">新增</a></em><a href="/S4Manager/Model.action?op=showemsi">排放标准管理</a></dd>
				<dd><em><a href="/S4Manager/admin/type-add.jsp">新增</a></em><a href="/S4Manager/Model.action?op=showtype">车型管理</a></dd>				
				<dt>商品管理</dt>
				<dd><a href="/S4Manager/MgCar.action?op=showlist">所有商品</a></dd>
				<dd><a href="/S4Manager/MgCar.action?op=showzs">在售商品</a></dd>
				<dd><a href="/S4Manager/MgCar.action?op=showsh">审核中的商品</a></dd>
				<dd><a href="/S4Manager/MgCar.action?op=showxj">下架的商品</a></dd>
				<dd><a href="/S4Manager/MgCar.action?op=showwtg">审核未通过的商品</a></dd>
				<dt>订单管理</dt>
				<dd><a href="/S4Manager/Mgord.action?op=showallord">所有订单</a></dd>
				<dd><a href="/S4Manager/Mgord.action?op=showzzjy">中止交易申请</a></dd>
				<dd><a href="/S4Manager/Mgord.action?op=showjyz">正在交易</a></dd>
				<dd><a href="/S4Manager/Mgord.action?op=showjywc">出售完成</a></dd>
				<dt>留言管理</dt>
				<dd><a href="/S4Manager/Trends.action?op=showcom">留言管理</a></dd>
				<dt>私人定制</dt>
				<dd><a href="/S4Manager/Manager.action?op=showsrdz">私人定制</a></dd>
				<dd><a href="/S4Manager/Manager.action?op=showclzsrdz">处理中的私人定制</a></dd>
				<dd><a href="/S4Manager/Manager.action?op=showyclsrdz">已处理的私人定制</a></dd>
				<dt>企业动态消息管理</dt>
                <dd><em><a href="/S4Manager/admin/alltrend-add.jsp">新增</a></em><a href="/S4Manager/Trends.action?op=showalltrends">所有动态</a></dd>
				<dd><em><a href="/S4Manager/admin/allnews-add.jsp">新增</a></em><a href="/S4Manager/Trends.action?op=shownewslist">新闻管理</a></dd>
				<dd><em><a href="/S4Manager/admin/active-add.jsp">新增</a></em><a href="/S4Manager/Trends.action?op=showactive">活动管理</a></dd>
			    <dt>业务分析</dt>
			    <dd><a href="/S4Manager/admin/chaxunche.jsp">卖出车情况</a></dd>
			    <dd><a href="/S4Manager/admin/pricechaxun.jsp">交易额情况</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>车系管理</h2>
		<div class="manage">
			<table class="list">
				<tr><td>品牌：</td><td><select name="sel1" id="sel1" onchange="sendRequest(this)">
				<option value="选择品牌">请选择品牌</option>
								  <c:if test="${!empty allbrand }">
                    <c:forEach var="allbrand" items="${allbrand }">
                    <option value=${allbrand.value.b_id }>${allbrand.value.b_name }</option>
                    </c:forEach>
                    </c:if>
				</select></td></tr>
				<tr><td>车系：</td><td> <select  name="sel2" id="sel2" onchange="sendDea(this)" >
                                        <option value="请选择">请先选择品牌</option>
                                    </select></td></tr>
                       <tr><td>详情：</td><td><div id="dea">请选择车系</div></td></tr>    
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
