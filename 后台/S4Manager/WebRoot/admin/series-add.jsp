﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript">
function chekexz(){
var sel1=document.all("sel1");
var spp=document.all("spp");
var cpp=document.all("cpp");
var flag=false;
 if(sel1.value!="选择品牌"){
     flag=true;
     cpp.value=sel1.value;
     spp.style.display="none";
 
 }
 else{
 spp.innerHTML="<font color='red'>请选择所属品牌</font>"
 spp.style.display="inline";
 }
 return flag;
}
function chek(){
 var flag=false;
 var name=document.all("name");
 var dea=document.all("dea");
 if(name.value.length>0){
     flag=true;
     dea.style.display="none";
 }
else{
dea.innerHTML="<font color='red'>请输入车系名称</font>"
 dea.style.display="inline";

}
return flag;
}
function chekSub(){
 var flag=false;
 if(chek()&&chekexz()){
 flag=true;
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
			<li><a href="/S4Manager/admin/index.jsp">首页</a></li>
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
		<form action="Model.action" method="post" onsubmit="return chekSub()">
			<table class="list">
				<tr><td>品牌：<input type="hidden" name="op" value="addser" /></td><td><select name="sel1" id="sel1" onchange="chekexz()" >
				<option value="选择品牌">请选择品牌</option>
								  <c:if test="${!empty allbrand }">
                    <c:forEach var="allbrand" items="${allbrand }">
                    <option value=${allbrand.value.b_id }>${allbrand.value.b_name }</option>
                    </c:forEach>
                    </c:if>
				</select><div id="spp" style="display: none;" ></div><input type="hidden" name="cpp" id="cpp" /></td></tr>
				<tr><td>车系：</td><td> <input type="text" id="name" name="name"  onblur="chek()" /><div id="dea" >${mea }</div></td></tr>
			   <tr><td>操作：</td><td><input type="submit" value="提交" /></td></tr>
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
