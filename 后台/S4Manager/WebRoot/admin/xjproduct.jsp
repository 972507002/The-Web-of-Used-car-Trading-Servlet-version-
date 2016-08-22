﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<script>
function cardel(id)
{
url="<%=basePath%>MgCar.action?op=dellcar&cid="+id;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>MgCar.action?op=showxj"
}
else
{
alert("删除失败")}
}
}
function cartypedel(id,a)
{url="<%=basePath%>car.action?op=del&cid="+id;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>car.action?op=showcar&type="+a
}
else
{
alert("删除失败")}
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

function sendRequest(sel){
 
  var brand=sel.value;
  var sel2=document.all("sel2");
  var cpp= document.all("cpp");
  
  if(sel.value!="选择品牌"){
   
  cpp.value=sel.options[sel.options.selectedIndex].text;
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
   cpp.value="";
    sel2.options.add(new Option("请先选择品牌","0"))
   
  }
  
} 

function getResult(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
     var data=xmlhttp.responseText;
     var json=eval("("+data+")");
     var sel2=document.all("sel2");
     sel2.length=0;
     sel2.options.add(new Option("请选择","0"))
     for(var i=0;i<json.length;i++){
      sel2.options.add(new Option(json[i].m_name,json[i].m_id));
     }
  }
}

function getcx(sel){
 var ccx= document.all("ccx");
 if(sel.value!="0"){
  ccx.value=sel.options[sel.options.selectedIndex].text;
 }
 else{
    ccx.value="";
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
管理员<a href="/S4Manager/MgUsIn.action?op=showdeauser&uid=${userinfo.u_id }">${userinfo.u_name }</a>您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='16' />，欢迎回到管理后台。	</div>
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
		<h2>下架的商品</h2>
		<div class="manage">
		<form action="/S4Manager/MgCar.action" method="post">
		<input type="hidden" name="op" value="showxjwhere"/>
		 <select id="pp" onchange="sendRequest(this)">
		 <option value="选择品牌">选择品牌</option>
		 <c:forEach var="allbrand" items="${allbrand }">
		 <option value="${allbrand.value.b_id }">${allbrand.value.b_name }</option>
		 </c:forEach>
		 </select>
		 <input type="hidden" id="cpp" name="cpp"/>
		 <select  name="sel2" id="sel2" onchange="getcx(this)" >
                                        <option value="请选择">请先选择品牌</option>
                                    </select>
                                    <input type="submit" value="确定"/>
                                     <input type="hidden" id="ccx" name="ccx"/>
                                    <input type="hidden" name="url" value="admin/allproduct.jsp"/>;
                                    </form>
			<table class="list">
				<tr>
				    <th>卖家ID</th>
					<th>商品ID</th>
					<th>商品名称</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty carMap }">
				<c:forEach var="carMap" items="${carMap }">
				<tr>
				<td>${carMap.u_id }</td>
					<td class="first w4 c">${carMap.c_id }</td>
					<td class="thumb" ><a target="_blank" href="/S4/CarInfo.action?op=showshdea&cid=${carMap.c_id }&uid=${carMap.u_id}"><img src="/S4/${carMap.c_img}" /></a><a target="_blank" href="/S4/CarInfo.action?op=showshdea&cid=${carMap.c_id }&uid=${carMap.u_id}">${carMap.c_brand } ${carMap.c_series } ${carMap.c_id }${carMap.c_type }${carMap.c_model }</a></td>
					<td>${carMap.c_state }</td>
					<td class="w1 c"> <input type="button" value="删除" onclick="cardel(${carMap.c_id})"></input></td>
				</tr>
				</c:forEach>
				</c:if>
				
			</table>
			 <div class="pages" align="center"> <c:if test="${curPage > 1}">
					<a href="/S4Manager/MgCar.action?op=showxjwhere&cpp=${pp }&ccx=${cx}&jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="/S4Manager/MgCar.action?op=showxjwhere&cpp=${pp }&ccx=${cx}&jumpPage=${curPage - 1}&">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="/S4Manager/MgCar.action?op=showxjwhere&cpp=${pp }&ccx=${cx}&jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="/S4Manager/MgCar.action?op=showxjwhere&cpp=${pp }&ccx=${cx}&jumpPage=${maxPage}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</div>
			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
