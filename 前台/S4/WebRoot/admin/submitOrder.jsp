<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${ydcarr.c_brand }${ydcarr.c_series } ${ydcarr.c_releaseyear } 款 ${ydcarr.c_volume }T ${ydcarr.c_gearType } ${ydcarr.c_code } ${ydcarr.c_model }</title>
    
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
<link rel="stylesheet" type="text/css" href="css/pro.css">
<link rel="stylesheet" type="text/css" href="css/sell.css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>

<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
<script>
        DD_belatedPNG.fix('*');
    </script>
<![endif]--> 
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

function sendFk(c_id,c_uid,nop){
 var url = "/S4/MemberCenter.action?op="+nop+"&cid="+c_id+"&uid="+c_uid+"&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getFk; 
     xmlhttp.send(null); 
  } 
} 


function getFk(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    var data=xmlhttp.responseText;
    alert(data)
  
    showDiv(data);
    if(data=="恭喜!:订车成功,去会员中心-我的需求-我的订单中看看吧"){
         window.location.href="/S4/MemberCenter.action?op=showmenberOrder";
         
    }
  }
}

</script>
<script type="text/javascript">
function showDiv(data){
var strs=new Array();
strs=data.split(":");

 var a =document.getElementById("popDiv");
 a.style.display="block";
 a.innerHTML=""+strs[0]+"<br/><a href='MemberCenter.action?op=showmenberMc'>"+strs[1]+"</a><br/><a href='javascript:closeDiv()'>关闭窗口</a>";
 var b=document.getElementById("popIframe")
b.style.display="block";
var c=document.getElementById("bg")
c.style.display="block";
}
function closeDiv(){
document.getElementById("popDiv").style.display="none";
document.getElementById("bg").style.display="none";
document.getElementById("popIframe").style.display="none";

}

</script>
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
			<a href="#" class="logo left" style="margin-top:0px;"><img src="images/logo.png"/></a>
			<div class="nav left dInline" id="headerMenu">
      <a  href="CarInfo.action?op=show">首页</a>
      <a href="about.jsp">关于亿金</a>
      <a href="CarInfo.action?op=showlist">我要买车</a>
      <a href="wymc.jsp">我要卖车</a>
      <a href="CarInfo.action?op=showsrdz">私人定制</a>
      <!--<a href="shfw.html">售后服务</a>-->
<c:if test="${!empty userinfo }"> <a id="MemberMenuChange" href="MemberCenter.action?op=showmenber" target="_self">会员中心</a></c:if>
          <c:if test="${empty userinfo }"> <a id="MemberMenuChange" onclick="sendLogin()">会员中心</a></c:if>
           </div>
			<span class="right" id="rightMenuHtml">
 <c:if test="${empty userinfo }"><a href="UserInfo.action?op=needLogin&url=CarInfo.action?op=show"   >登录</a>|<a  href="UserInfo.action?op=needreg&url=CarInfo.action?op=show" >注册</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>
      <c:if test="${!empty userinfo }"> <c:if test="${time<12 }">上午好！</c:if><c:if test="${time>=12 }">  下午好！ </c:if> <a href="MemberCenter.action?op=showmenber"  class="b-login" >
    ${userinfo.u_name } 
   
      </a>|<a  href="UserInfo.action?op=zhuxiao&url=CarInfo.action?op=show"  id="b-regist">注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>			</span>
		</div>
	</div>
	<div class="head-search">
		<div class="wrap clearfix">
			<form class="clearfix left" action="CarInfo.action" method="get" >
				<input type="hidden" name="op" value="showlist">
				<input type="text" name="bname" placeholder="请输入您想要的品牌搜索" style="width:439px;" class="left" />
				<input type="submit" value="搜 索" class="right" />
			</form>
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
	<div class="mTags">
    	<div class="wrap">
			<a href="index.jsp">亿金名车广场</a>><a href="memberMyNeed.jsp">立即抢订</a>><a>别克 君威 2015 款 1.6T 自动 精英技术型</a>
        </div>
	</div>
	<div id="xDan" class="wrap clearfix">
		<div class="xdImg left dInline">
        	<div class="car_bg"> </div>
			<a href="#"><img src=" ${ydcarr.c_img }" width="400" /></a>
		</div>
		<div class="buyTxt right dInline">
		<c:if test="${!empty ydcarr }">
			<h1>${ydcarr.c_brand }${ydcarr.c_series } ${ydcarr.c_releaseyear } 款 ${ydcarr.c_volume }T ${ydcarr.c_gearType } ${ydcarr.c_code } ${ydcarr.c_model }</h1>
			<div class="byDl clearfix byDl_tab">
				<span class="left byPrice bItem">
					亿金
寄售
                    价<br/>
					<b>${ydcarr.c_price }</b> 万元
				</span>
				<span class="left bItem">
					上牌时间
					<p>${ydcarr.c_licencetime }</p>
				</span>
				<span class="left bItem">
					行驶里程
					<p>${ydcarr.c_distance }万公里</p>
				</span>
				<span class="left bItem">
					排量
					<p>${ydcarr.c_volume }T</p>
				</span>
                <span class="left bItem">
					排放标准
					<p>${ydcarr.c_emissionstandard }</p>
				</span>
			</div>
			<div class="byPay clearfix">
				<span class="left">
					预付定金：<strong>￥<fmt:formatNumber value="${ydcarr.c_price/10 }" pattern="#,###.##"></fmt:formatNumber></strong>万元
				</span>
				<!--<span class="right">
					<select>
						<option>让我的销售顾问杨荔波继续为我服务此订单</option>
					</select>
				</span>-->
			</div>
                
                <a class="payBtn"  onclick="sendFk(${ydcarr.c_id },${ydcarr.u_id },'fukuan')">
                    确认提交
                </a>
           </c:if>
		</div>

	</div>
</div>

<!--footer部分开始-->

<div id="footer">
	<div class="foot-a1">
		<div class="wrap">
			<ul class="clearfix">
            	<li>
                	<img src="images/db1.png"/>
                    <p>365项检测认证</p>
                </li>
                <li>
                	<img src="images/db2.png"/>
                    <p>5000公里无需保养</p>
                </li>
                <li>
                	<img src="images/db3.png"/>
                    <p>1年或两万公里无忧质保</p>
                </li>
                <li>
                	<img src="images/db4.png"/>
                    <p>7天无忧退换</p>
                </li>
                <li>
                	<img src="images/db5.png"/>
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
	<div class="popCont">
		<a class="p_closed">关闭</a>
		<div class="p-tab">
			<a>会员登录<i></i></a><a>会员注册<i></i></a>
		</div>
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
			            <a href="/Meet/editPass">忘记登录密码？</a>
			        </div>
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
			                <input type="radio" checked="" name="gender" value="M" /> 男&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="F" /> 女 
			            </li>
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
<div id="popDiv" class="mydiv" style="display:none;">
</div>
<div id="bg" class="bg" style="display:none;"></div>
<iframe id='popIframe' class='popIframe' frameborder='0' ></iframe>
<script type="text/javascript" src="js/miniBar.js"></script>
<script type="text/javascript" src="js/lg_reg.js"></script>
<script type="text/javascript">
$(function(){
	//表单选择
   $(".select").click(function(e){
        e.stopPropagation();
        $(".select-open").addClass("hide");
        $(this.parentNode).find(".select-open").removeClass("hide");
    });
    $(document.body).click(function() {
        $(".select-open").addClass("hide");
    });
    $('.brand-cata li').click(function(){
    	var index=$(this).index();
    	var t=$('#choose-brand .choose-box');
    	var $sH=t.scrollTop()+($('.cont-tit').eq(index).offset().top-t.offset().top);
    	$('#choose-brand .choose-box').animate({scrollTop:$sH},500);
    })
  	$('.car-select').each(function(){
  		 var sTxt=$(this).find('.display-text');
  		 $(this).find('.choose-cont').click(function(){
	    	sTxt.text($(this).text());
	    	$(this).find('.select-open').addClass("hide");
	    });
  	})
 	$('.carSutl_top').click(function(){
 		$('.carSutl_top').removeClass('cur')
 		$(this).addClass('cur');
 		$(this).parent('li').find('.con').stop(true,true).slideDown();
 		$(this).parent('li').siblings().find('.con').stop(true,true).slideUp();
 	})
})
function Orderpost(){
	var url='/Cars/Order';
	var carid=Order.carid.value;//手机号
	$.ajax({
		type: "POST",
		url: url,
		data: {carid:carid},
		dataType: "json",
		success: function(data){
			alert(data.msg);
			if(data.status=='1'){
				location.href = '/Member/need/channel/7/list/11';
			}
		}
	 });
	 return false;
}
</script>

  </body>
</html>
