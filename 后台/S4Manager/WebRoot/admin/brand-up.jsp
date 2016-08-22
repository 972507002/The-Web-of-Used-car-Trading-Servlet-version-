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
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/checkuser.js"></script>
<script type="text/javascript">

/*
用途：检查输入字符串是否符合正整数格式
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/
function isNumber(s) {
var regu = "^[0-9]+$";
var re = new RegExp(regu);
if (s.search(re) != -1) {
return true;
} else {
return false;
}
} 

function chek(){
 var flag=false;
 var name=document.all("maxAge");
 var dea=document.all("chekAge");
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
 function chekCount(){
  var count=document.all("count");
 
  var div=document.all("d2");

  var flag=false;
  if(count.value.length>0){
    if( isNumber(count.value)){
  
      flag=true;
      div.style.display="none";
    }
    else{
    div.innerHTML="<font color='red'>请输入正整数</font>"
     div.style.display="inline";
    }
  }
  else{
  flag=true;
  div.style.display="none";
  }
  return flag;
 }
 
/*
用途：检查输入字符串是否是数字
输入：
str：字符串
返回：
如果通过验证返回true,否则返回false
*/

function isNum(str) 
{         
    var reg = /^\d+$/;
    if (reg.test(str))
       return true; 
    else  
       return false; 
}
/*
用途：检查输入字符串是否只由汉字组成
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/

function isZh(str){
 var reg = /^[\u4e00-\u9fa5]+$/;
 if (reg.test(str)) return true;
 return false; 
} 

function chekSzm(){
   var zm=document.all("zm");
   var flag=false;
   var div=document.all("chekZm");
   if(zm.value.length>0){
       if(isNum(zm.value)){
       div.innerHTML="<font color='red'>请输入一个英文字母</font>";
      div.style.display="inline";
       }
       else if(isZh(zm.value)){
       div.innerHTML="<font color='red'>请输入一个英文字母</font>";
      div.style.display="inline";
       }
       else{
       if(zm.value.length>1){
        div.innerHTML="<font color='red'>请输入一个英文字母</font>";
      div.style.display="inline";
      }
      else{
      flag=true;
        div.style.display="none";
      }
       }
   }
   else{
   div.innerHTML="<font color='red'>不能为空</font>";
      div.style.display="inline";
   }
 return flag;
}
 function chekSub(){
  var flag=false;
  if(chek()&&chekCount()&&chekSzm()){
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
		<h2>新增品牌</h2>
		<div class="manage">
			<form action="/S4Manager/Model.action" method="post" onsubmit="return chekSub()">
				<input type="hidden" name="op" value="tjupbr"/>
				<input type="hidden" name="bid" value="${brand.b_id }"/>
				<input type="hidden" name="qtp" value="${brand.b_img }" />
				<table class="form">
				<tr><td>品牌名</td><td><input type="text" id="maxAge" name="maxAge"  value="${brand.b_name }" onblur="chek()"/><div id="chekAge" >${upbrand }</div></td></tr>
				<tr><td>名称首字母</td><td><input type="text" id="zm" value="${brand.b_szm }" name="zm"  onblur="chekSzm()"/><div id="chekZm" style="display: none;"></div></td></tr>
				<tr><td>热度</td><td colspan="4"><input type="text" id="count" name="count" value="${brand.b_count }" onblur="chekCount()" /><div id="d2" style="display: none;"></div></td><td></td></tr>
				<tr><td>品牌Logo</td><td ><div align="center" style="height:200;border:5px solid red; " id="fa1"><img src="/S4Manager/${brand.b_img }"/></div><div style=" height:0px; overflow:hidden; position:absolute;" ><input type="file" id="filePath" name="filePath" onchange="fileupload('filePath','fa1','ttp')"/></div>
           <input type="button" onclick="document.getElementById('filePath').click();" value="上传" /></td></tr>
				<tr><td>注</td><td>热度高的会在前台优先展示,不输入则记为0</td></tr>	
				
					<tr>
						<td> <input type="hidden" name="ttp"  />	<input type="hidden" id="cAge" name="cAge"/></td>
						<td><label class="ui-blue"><input type="submit"  value="提交"  /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
	
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>  
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>    
    <script type="text/javascript">  
        function fileupload(str,div1,str2){
        var str1=document.all(str);
        var div=document.all(div1); 
       var str3=document.all(str2);
             
            if(str1.value.length==0){  
                alert("上传文件不能为空!");  
                return false;  
            }  
            $.ajaxFileUpload({  
                    url:"<%=basePath %>ScImage.action?sctname="+str3.value+"",  
                   
                    secureuri:false,  
                    fileElementId:str,  
                    dataType: 'text/xml', 
                    type:'post',            
                    success: function (msg) {
                    
                        var start = msg.indexOf(">");
                      if (start != -1) {
                          var end = msg.indexOf("<", start + 1);
                          }
                          if (end != -1) {
                              msg = msg.substring(start + 1, end);
                          }
                         
                         div.innerHTML="<img src='/S4Manager/tepimages/"+msg+"'>";
                         str3.value=msg;
                    },error: function (data, status, e){  
                        alert("fail");  
                    }  
                }  
            );  
        }  
        
    </script>  
</body>
</html>
