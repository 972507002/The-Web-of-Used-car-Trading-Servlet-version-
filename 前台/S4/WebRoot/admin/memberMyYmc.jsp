<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员中心-郑州高品质二手车专家_河南亿金名车广场</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="郑州二手车,河南二手车,郑州二手名车">
	<meta http-equiv="description" content="亿金汽车">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/layout.css">
<link rel="stylesheet" type="text/css" href="css/hurst.css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
<script>
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
<script type="text/javascript">
function cheklynull(){

 var a= document.all("bankAuthSrc").value;

 var flag=false;
 if(a.length==0){
 alert("留言内容不能为空")
 }
 else{
 flag=true;
 }
 return flag;
}
function udelete()
{

if(cheklynull()){
 var a= document.all("bankAuthSrc").value;
 var b= document.all("bankAuthSrc");
var url="<%=basePath%>MemberCenter.action?op=liuyan&text="+a;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("留言成功")
 b.value="";
}
else
{
alert("留言失败")}
}
}
}
</script>
  </head>
  
  <body>
   <div id="header">
	<div class="top">
		<div class="wrap clearfix">
			<a href="#" class="logo left"><img src="images/logo.png"/></a>
	  <div class="nav left dInline" id="headerMenu">
      <a  href="CarInfo.action?op=show">首页</a>
      <a href="about.jsp">关于亿金</a>
      <a href="CarInfo.action?op=showlist">我要买车</a>
<a href="MemberCenter.action?op=needmaiche">我要卖车</a>
      <a href="CarInfo.action?op=showsrdz">私人定制</a>
      <!--<a href="shfw.html">售后服务</a>-->
      <a id="MemberMenuChange" class="b-login" href="MemberCenter.action?op=showmenber" target="_self">会员中心</a>
      </div>
			<span class="right" id="rightMenuHtml">
  <c:if test="${!empty userinfo }">
       <c:if test="${time<12 }">
          上午好！
      </c:if>
      <c:if test="${time>12 }">
          下午好！
      </c:if>
      <a href="MemberCenter.action?op=showmenber" class="b-login" id="b-login">
      ${userinfo.u_name }
      </a>|<a  href="UserInfo.action?op=zhuxiao&url=CarInfo.action?op=show" >注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>			</span>
		</div>
	</div>
	<div class="head-search">
		<div class="wrap clearfix">
			<div class="yjxj clearfix left" action="/index/keyword/" method="post" enctype="multipart/form-data">
         <form action="CarInfo.action" method="get">
        <input type="hidden" name="op" value="showlist">
        <input type="text" name="bname" placeholder="请输入您想要的品牌搜索" class="left" />
        <input type="submit" value="搜 索" class="right" />
        </form>
      </div>
			<div class="hotWords left dInline">
				热门品牌：
<c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
                        <a href="CarInfo.action?op=showlist&bname=${ showcar.value.c_brand}&cser=${showcar.value.c_series}" >${ showcar.value.c_brand}${showcar.value.c_series}</a>
            
            </c:forEach>
            </c:if>			</div>
		</div>
	</div>
</div>

<div id="about">
  <div class="mTags wrap"> <a href="index.jsp">亿金名车广场</a>><a href="menber.jsp">会员中心</a>><a >我的车</a> </div>
  <div class="mebBox">
    <div class="meb-cont clearfix wrap">
      <div class="meb-nav left dInline">
        <ul class="clearfix">
					<li><a href="MemberCenter.action?op=showmenber">会员中心</a></li>
                    <li><a href="MemberCenter.action?op=showmenberOrder">我的需求</a></li>
                    <li class="on"><a href="MemberCenter.action?op=showmenberYbcar">我的车</a></li>
                    <li><a href="admin/memberMyAccount.jsp">账户管理</a></li>				
                </ul>
      </div>
      <div class="meb-right right dInline">
        <div class="mr-top">
          <div class="mr-top-div clearfix"> <span class="left"> <img src="images/photo.png"/> </span>
            <div class="mr-infor left dInline">
                      <h2>  <c:if test="${time<12 }">
          上午好！
      </c:if>
      <c:if test="${time>12 }">
          下午好！
      </c:if>，尊敬的会员 <b> ${userinfo.u_name }</b></h2>
            <p>
                手机： ${userinfo.u_tel}   邮箱：
                
                <c:if test="${userinfo.u_email!=null }">
                ${userinfo.u_email }
                </c:if>
                <c:if test="${userinfo.u_email==null }">
                                       未填写
                </c:if>
                   [ <a href="admin/memberMyAccount.jsp">管理账户信息</a> ]
            </p>
            </div>
          </div>
        </div>
        <div class="mr-detail">
          <div class="mr-tab clearfix"> <a  href="MemberCenter.action?op=showmenberYbcar" >我购买的车</a> 
            <!--<a>售后历史</a>-->
            <a href="MemberCenter.action?op=showmenberXj" >我下架的车</a> 
            <a href="MemberCenter.action?op=showmenberbjj">审核未通过的车</a> 
            <a href="MemberCenter.action?op=showmenberJyz">被订购的车</a>
              <a class="on" href="MemberCenter.action?op=showmenberymw">出售成功的车</a>
          </div>
          <div class="me-box me-box1">
          <div class="me-dl" >
          </div>
          <div class="me-dl" >
          </div>
          <div class="me-dl" >
          </div>
          <div class="me-dl" >
          </div>
            <div class="me-dl"  style="display:block;">
							<div class="me-one" id="me-four">
							<c:if test="${!empty szCar }">
							<c:forEach var="szCar" items="${szCar }">
							<ul class="cs-list"><li class="clearfix" style="position: relative;">	<span class="carImg left dInline"><a href="MemberCenter.action?op=showdea&cid=${szCar.value.c_id}&uid=${szCar.value.u_id}" target="_blank"><div class="car_bg"> </div>		<img src="${szCar.value.c_img}" onerror="this.src='images/pro4.jpg'" width="300" /></a>	</span>	<div class="carTxt right dInline">		<h2><a href="MemberCenter.action?op=showdea&cid=${szCar.value.c_id}&uid=${szCar.value.u_id}" target="_blank">${szCar.value.c_brand }${szCar.value.c_series}  ${szCar.value.c_releaseyear}款   ${szCar.value.c_volume}T ${szCar.value.c_gearType} ${szCar.value.c_code}${szCar.value.c_model}</a></h2>		<p>			<span>上牌时间：${szCar.value.c_releaseyear}</span> 
							<span>行驶里程：${szCar.value.c_distance}万公里</span>
							<span>排量：${szCar.value.c_volume}T</span><span>
							排放标准：${szCar.value.c_emissionstandard}</span>
							</p><div class="price clearfix" style="margin:5px 0;"><div class="left dInline pNum">	<font>一口价</font><br/><span class="num nBlue">${szCar.value.c_price}</span><font> 万元</font>			 </div>			<span class="num1 left" style="height:43px;padding-top:10px;"><em></em><br/>						</span>		</div>		<div class="cs_bt clearfix">			</div>	</div></li></ul><div class="hPages">    </div>
							</c:forEach>
							</c:if>
								</div>
								 <div class="pages"> <c:if test="${curPage > 1}">
					<a href="MemberCenter.action?op=showmenberYbcar&jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="MemberCenter.action?op=showmenberYbcar&jumpPage=${curPage - 1}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="MemberCenter.action?op=showmenberYbcar&jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="MemberCenter.action?op=showmenberYbcar&jumpPage=${maxPage}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</div>
						</div>
         
          
             
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!--footer部分开始-->

<div id="footer">
  <div class="foot-a1">
    <div class="wrap">
      <ul class="clearfix">
        <li> <img src="images/db1.png"/>
          <p>365项检测认证</p>
        </li>
        <li> <img src="images/db2.png"/>
          <p>5000公里无需保养</p>
        </li>
        <li> <img src="images/db3.png"/>
          <p>1年或两万公里无忧质保</p>
        </li>
        <li> <img src="images/db4.png"/>
          <p>7天无忧退换</p>
        </li>
        <li> <img src="images/db5.png"/>
          <p> 置换有增值</p>
        </li>
      </ul>
    </div>
  </div>
  <div class="foot-a">
    <div class="wrap clearfix">
      <div class="fDl left dInline "> <strong>亿金承诺</strong>
        <ul>
        <c:if test="${!empty chennuo }">
        <c:forEach var="chennuo" items="${chennuo }">
        <li><a href="Trends.action?op=showtei&tr_id=${chennuo.tr_id }" target="_blank">${chennuo.tr_title }</a></li>
        </c:forEach>
        </c:if>
         
        </ul>
      </div>
      <div class="fDl left dInline "> <strong>买卖二手车指南</strong>
        <ul>
        <c:if test="${!empty zhinan }">
        <c:forEach var="zhinan" items="${zhinan }">
        <li><a href="Trends.action?op=showtei&tr_id=${zhinan.tr_id }" target="_blank">${zhinan.tr_title }</a></li>
        </c:forEach>
        </c:if>
         
        </ul>
      </div>
      <div class="fDl left dInline "> <strong>售后服务</strong>
        <ul>
          <li><a href="shfw.jsp">24小时道路救援</a></li>
          <li><a href="shfw.jsp">豪车凹陷修复</a></li>
          <li><a href="shfw.jsp">定期上门维修保养服务</a></li>
          <li><a href="shfw.jsp">预约保养工时优惠</a></li>
        </ul>
      </div>
      <div class="fDl left dInline "> <strong>关于亿金</strong>
        <ul>
        <li><a href="about.jsp" target="_blank">亿金简介</a></li>
        <li><a href="Trends.action?op=shownewslist" target="_blank">亿金动态</a></li>
        <li><a href="Trends.action?op=showactive" target="_blank">活动中心</a></li>
          
        <li><a href="contact.jsp" target="_blank">联系亿金</a></li>
          
        </ul>
      </div>
     
      <div class="fDl left dInline fDl1">
        <div class="dLx"> <img src="images/dLx.jpg"/> </div>
        <div style="height:50px;"></div>
      </div>
    </div>
  </div>
  <div class="foot-b"> Copyright © 2015 qcauto All Rights Reserved 河南亿金有限公司 版权所有 豫ICP备123456789号<br/>
    地址：郑州市管城区紫荆山东大街裕鸿花园 服务热线：400-888-6666<br/>
     </div>
</div>

<!--footer部分结束-->
<!--右侧内容的开始-->
<c:if test="${!empty userinfo }">
<div id="miniBus" style="right:-270px;">
	<div class="mini-bar">
		<div class="mini-barlist">
			<ul>
			
				
				<li class="callItem">
					<div class="mini-mi callback">
						<i class="mini-ease"></i>
						<code></code>
						<span>意见反馈</span>
					</div>
				</li>
				<li class="miItem">
					<div class="mini-mi shopping">
						<i class="mini-ease"></i>
						<code></code>
						<span>对比车辆</span>
						
					</div>
				</li>
			</ul>
		</div>
		<a class="mini-gotop"></a>
		<a class="wx1"><img src="images/wx_1.png"></a>
		<div class="wmImg hide">
			<img src="images/wx_2.png">
		</div>
	</div>
	<div class="mini-cont">
		<div class="mini-contlist">
			
		
			<!--<div class="mini-ni">
				<div class="mini-h clearfix">
					<a class="mini-close mini-ease lf-fl"></a>
					<span class="lf-fr"><code>在线客服</code></span>
				</div>
			</div>-->
			<div class="mini-ni" id="shopping">
				<div class="mini-h clearfix">
					<a class="mini-close mini-ease lf-fl"></a>
					<span class="lf-fr"><code>对比车辆</code></span>
                    <span class="lf-fr" style="margin:auto 10px; font-size:26px; font-weight:bolder" id="deletealldb"><a><code>×</code></a></span>
				</div>
                <div class="miList" id="Carduibi">
					<ul>
											</ul>
					
					 <c:if test="${!empty pareCarInfo }">
					 <a href="CarInfo.action?op=zjbj" class="mini-fav">立即对比</a>
					 <c:forEach var="pareCarInfo" items="${ pareCarInfo }">
					 <a href="CarInfo.action?op=showdetails&uid=${pareCarInfo.value.u_id }&cid=${pareCarInfo.value.c_id }" target="_blank">${pareCarInfo.value.c_brand }${pareCarInfo.value.c_series } ${pareCarInfo.value.c_releaseyear } 款 ${pareCarInfo.value.c_volume }L ${pareCarInfo.value.c_gearType } ${pareCarInfo.value.c_code } ${pareCarInfo.value.c_model }</a><br>
					 </c:forEach>
					 </c:if>
					 <c:if test="${empty pareCarInfo }">
					 您还没有添加要比较的车辆哦~
					 </c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="lf-view" id="lf-view">
    	<form onsubmit="return Lmessage();" enctype="multipart/form-data" method="post" name="leaveMess" id="leaveMess">
		<b>您对我们的看法~</b>
		<div>
			<textarea placeholder="您的声音对我们很重要哟(必填)~" id="bankAuthSrc" name="bankAuthSrc"></textarea>
		</div>
		<div>
			<a id="viewSubmit" onclick="udelete()"></a>
            		</div>
        </form>
		<a id="viewClose"></a>
		<i id="viewIcon"></i>
		<p id="viewSign"></p>
	</div>
</div>
</c:if>
<!--右侧内容的结束-->
<div id="popBox">
  <div class="popCont"> <a class="p_closed">关闭</a>
    <div class="p-tab"> <a>会员登录<i></i></a><a>会员注册<i></i></a> </div>
    <div class="p-detail">
      <div class="p-dl">
        <form onsubmit="return check();" enctype="multipart/form-data" method="post" name="form" id="form">
          <ul class="login-items">
            <li>
              <label>用户名(手机号)</label>
              <input class="input" type="text" value="" maxlength="32"  name="username" placeholder="请输入您的手机号">
            </li>
            <li>
              <label>密码</label>
              <input class="input" type="password" value="" maxlength="16"  name="password">
            </li>
          </ul>
          <div class="login-check">
            <input type="checkbox" name="checkbox" style=" width:auto;" />
            <label>记住我</label>
            <a href="/Meet/editPass">忘记登录密码？</a> </div>
          <div class="login-button">
            <input type="hidden" value="" name="carid" class="ordercarid" />
            <input type="hidden" value="" name="carstatus" class="orderstatus" />
            <input type="button"  value="登&nbsp;&nbsp;&nbsp;&nbsp;陆" class="fM" onclick="$('#form').submit()" />
          </div>
          <!--<div class="security-pro">
			            <i class="icons ver-green-down"></i>
			            <b>您的信息已通过256位SGC加密保护，数据传输安全</b>
			        </div>-->
        </form>
      </div>
      <div class="p-dl">
        <form class="registForm" onsubmit="return regcheck();" enctype="multipart/form-data" method="post" name="reg" id="reg">
          <ul class="login-items">
            <li class="clearfix">
              <input class="input" name="mobile" id="mobile" type="text" value="" placeholder="手机号码（登录帐号）">
            </li>
            <li class="clearfix">
              <input class="input left" type="text" value=""  name="verify" placeholder="输入验证码" style="width:100px;" />
              <div id="send"><a href="#" class="send_code right">获取验证码</a></div>
            </li>
            <li class="clearfix">
              <input class="input" type="text" value=""  name="realname" placeholder="姓名">
            </li>
            <li class="clearfix sex">
              <input type="radio" checked="" name="gender" value="M" />
              男&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="gender" value="F" />
              女 </li>
            <li class="clearfix">
              <input id="" class="input" type="password" name="password" value="" placeholder="输入密码（六位字符）">
            </li>
          </ul>
          <div class="login-button">
            <input type="hidden" value="" name="carid" class="ordercarid" />
            <input type="hidden" value="" name="carstatus" class="orderstatus" />
            <input type="button"  value="立即注册" class="fM" onclick="$('#reg').submit()" />
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="js/miniBar.js"></script> 
<script type="text/javascript" src="js/lg_reg.js"></script> 
<script type="text/javascript">
$(function(){
	$('.mr-tab a').each(function(index){
		$(this).click(function(){
			$(this).addClass('on').siblings().removeClass('on');
			$('.me-dl').eq(index).show().siblings().hide();
		})
	});
})
</script> 
<script type="text/javascript"> var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://"); document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Faa70c6792578150b40ad413464080efa' type='text/javascript'%3E%3C/script%3E")) </script>
  </body>
</html>
