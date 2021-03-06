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
 function xzn(){
  var sel1= document.all("sel1");
  var sel2=document.all("sel2");
  var cn=document.all("cn");
  if(sel1.value!="0"){
    sel2.length=0;
    sel2.options.add(new Option("请选择月份","0"));
    for(var i=1;i<13;i++){
    sel2.options.add(new Option(i,i));
    }
    cn.value=sel1.value;
  }
  else{
  sel2.length=0;
    sel2.options.add(new Option("请先选择年份","0"));
    cn.value.length=0;
  }
 }
 function chekyf(){
 var sel1= document.all("sel2");
  var sel2=document.all("sel3");
  var cy=document.all("cy");
  if(sel1.value!="0"){
    sel2.length=0;
    sel2.options.add(new Option("请选择日期","0"));
    for(var i=1;i<32;i++){
    sel2.options.add(new Option(i,i));
    }
    cy.value=sel1.value;
  }
  else{
  sel2.length=0;
    sel2.options.add(new Option("请先选择月份","0"));
    cy.value.length=0;
  }
 
 }
  function cheksub(){
   var sel4=document.all("sel4");
   var div=document.all("d1");
   
   var flag=false;
   if(sel4.value!="0"){
   flag=true;
   }
   else{
   div.innerHTML="<font color='red'>请选择图形</font>";
   div.style.display="inline";
   }
   return flag;
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
		<h2>查询卖出车情况</h2>
		<div class="manage">
		<form action="/S4Manager/price.action" target="_blank"  onsubmit="return cheksub()">
			<table class="list">
				<tr><td>年：</td><td><select name="sel1" id="sel1" onchange="xzn()">
				<option value="0">请选择年份</option>
								 <c:forEach  var="i" begin="2010" end="${2050}">
								 <option value="${i }">${i }</option>
								 </c:forEach>
				</select></td></tr>
				<tr><td>月：</td><td> <select  name="sel2" id="sel2" onchange="chekyf()" >
                                        <option value="0">请先选择月份</option>
                                    </select></td></tr>
                       <tr><td>日：</td><td><select  name="sel3" id="sel3"  >
                                        <option value="0">请选择天</option>
                                    </select></td></tr>    
                                    <tr><td>图形：</td><td><select  name="sel4" id="sel4"  >
                                        <option value="0">请选择图形</option>
                                       
                                        <option value='柱状图'>柱状图</option>
                                        <option value='饼状图'>饼状图</option>
                                        <option value='折线图'>折线图</option>
                                    </select><div id="d1" style="display: none;" ></div></td></tr>  
                                    <tr><td>操作:</td><td><input type="submit" value="查询" /></td></tr> 
			</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
