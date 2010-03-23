<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ page import="com.easymorse.hotel.*" %>
<% HotelBean hotel = (HotelBean)request.getAttribute("hotels"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<title>hotel book</title>
<link href="css/style1.css" rel="stylesheet" type="text/css" />
<LINK href="<%=request.getContextPath() %>/css/div_css.css" rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath() %>/css/css_new.css" rel="stylesheet" type="text/css">
 
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div id="webbody">
<div id="body1" align="center" >
</div>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><META http-equiv="Content-Type" content="text/html; charset=GBK">


<TITLE></TITLE>
<LINK href="<%=request.getContextPath() %>/pinglun/pinglun1/css_new.css" rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath() %>/pinglun/pinglun1/div_css.css" rel="stylesheet" type="text/css">
<SCRIPT language="javascript" src="<%=request.getContextPath() %>/pinglun/pinglun1/js.js"></SCRIPT>
<SCRIPT language="JavaScript">
<!--
function check(frm)
{
	
	if (frm.comment_content.value==""){
		alert("评论内容不能为空");
		return false
	}
	
		var CS1=0
		var CS2=0
		var CS3=0
		var CS4=0
		for(var j=0;j<5;j++)//酒店评分
		{
			if(document.form1.service1[j].checked==true)
				{
				CS1=CS1+document.form1.service1[j].value
				}
			if(document.form1.environment1[j].checked==true)
				{		
				CS2=CS2+document.form1.environment1[j].value
				}
			if(document.form1.facility1[j].checked==true)
				{		
				CS3=CS3+document.form1.facility1[j].value
				}
			if(document.form1.price1[j].checked==true)
				{		
				CS4=CS4+document.form1.price1[j].value
				}
		}
	if(CS1==0)
		{
		document.form1.service1[0].focus();
		alert('请对此酒店服务进行评分！')	
		return false
		}	
	if(CS2==0)
		{
		document.form1.environment1[0].focus();
		alert('请对此酒店环境进行评分！')	
		return false
		}	
	if(CS3==0)
		{
		document.form1.facility1[0].focus();
		alert('请对此酒店设施进行评分！')	
		return false
		}	
	if(CS4==0)
		{
		document.form1.price1[0].focus();
		alert('请对此酒店价格评分！')	
		return false
		}
	
	
}

function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</SCRIPT>

<STYLE type="text/css">
.h4{ font-size:18px;}
</STYLE>
</HEAD><BODY>

<DIV class="Container">
     <TABLE width="954" border="0" cellspacing="0" cellpadding="0">
       <TBODY><TR>
         <TD width="208" valign="top" class="left_bg">
		 	   
		   
		   
		   
<DIV class="left_in">
    
    </DIV>
	
	
		   </TD>
         <TD width="746" valign="top">
		   <DIV class="hotelcity">
		     <DIV id="shoucangjia_box"><DIV class="massage">


</DIV></DIV>
<DIV id="mask"></DIV>

<DIV class="hotelintro_top">
			 
			  <DIV class="hotelintro_title">
			   <UL><LI><IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/icon01.gif" alt="金牌酒店">&nbsp;
			   <SPAN class="span18"><%=hotel.getHotelName() %></SPAN></LI>
				<LI><SPAN class="cheng">  ★★★★</SPAN></LI>
				</UL>
			  </DIV>
			  <DIV class="hotelintro_top_com"></DIV>
			 
			
			  <DIV class="hotelintro_menu">
			   
			  </DIV>
			 </DIV>
			 

			  <FORM name="form1" method="post" action="criticism_submit.do" onsubmit="return check(this);">
			 <DIV class="hotelintro_main">
			   <DIV style="margin:10px;">
                

<DIV class="comment_Score"><UL>
  <LI>服务 <IMG style="BACKGROUND-POSITION: 94.35px 50%; BACKGROUND-IMAGE: url(/image/rbar.gif); BACKGROUND-REPEAT: no-repeat; BACKGROUND-COLOR:#FB7904" height="7" src="<%=request.getContextPath() %>/pinglun/pinglun1/reviewBar.png" width="111"> 4.25</LI>
  <LI>卫生 <IMG style="BACKGROUND-POSITION: 96.126px 50%; BACKGROUND-IMAGE: url(/image/rbar.gif); BACKGROUND-REPEAT: no-repeat; BACKGROUND-COLOR:#FB7904" height="7" src="<%=request.getContextPath() %>/pinglun/pinglun1/reviewBar.png" width="111"> 4.33</LI> 
  <LI>设施 <IMG style="BACKGROUND-POSITION: 94.35px 50%; BACKGROUND-IMAGE: url(/image/rbar.gif); BACKGROUND-REPEAT: no-repeat; BACKGROUND-COLOR:#FB7904" height="7" src="<%=request.getContextPath() %>/pinglun/pinglun1/reviewBar.png" width="111"> 4.25</LI>
  <LI>价格 <IMG style="BACKGROUND-POSITION: 100.344px 50%; BACKGROUND-IMAGE: url(/image/rbar.gif); BACKGROUND-REPEAT: no-repeat; BACKGROUND-COLOR:#FB7904" height="7" src="<%=request.getContextPath() %>/pinglun/pinglun1/reviewBar.png" width="111"> 4.52</LI>
</UL>
</DIV>
<DIV style="text-align:center;">
<A href=#dian><IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/btn_comment.gif" border="0" class="comment_btn"></A></DIV>
<DIV class="clear"></DIV>
             </DIV>
			
<c:forEach items="${criticismlist}" var="item">

	<!---------------点评内容--------------->
        <DIV class="comment_con_box">
			 <DIV class="comment_con_ti">
			   
					  <SPAN class="bold"> 住户</SPAN>
					  于${item.criticismTime } 对<A href="" ><%=hotel.getHotelName() %></A>的点评 </DIV>
			   <TABLE width="100%" border="0" cellspacing="0" cellpadding="10">
                 <TBODY><TR>
                   <TD width="18%" valign="top">  
				    
					
					 <DIV class="comment_con_Score">
			 <UL>
			      <LI>综合 <IMG style="BACKGROUND-POSITION: 52.25px 50%; BACKGROUND-IMAGE: url(/image/rbar.gif); BACKGROUND-REPEAT: no-repeat; BACKGROUND-COLOR:#FB7904;" height="7" src="<%=request.getContextPath() %>/pinglun/pinglun1/reviewBar.png" width="55">
						
						<SPAN class="cheng_bold">4.8</SPAN></LI>
                  <LI>服务 <IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/Score_5.gif"> 5</LI>
                  <LI>卫生 <IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/Score_5.gif"> 5</LI>
				  <LI>设施 <IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/Score_4.gif"> 4</LI>
				  <LI>价格 <IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/Score_5.gif"> 5</LI>
			 </UL>
			 </DIV>	
			 				   </TD>
                   <TD width="82%" valign="top" class="comment_con_td">
                     <DIV style="padding:1px; line-height:18px; text-align:justify; text-justify:inter-ideograph">${item.criticism }</DIV>				   </TD>
                 </TR>
               </TBODY></TABLE>
			 </DIV>
			 
			    

</c:forEach>   
	
		
			 
			    
		
		
		<!---------------点评内容--------------->
        <DIV class="comment_con_box">
			
			 
			   
			   <DIV class="margin8"></DIV>
		       <!----------------页码---------------->
			   <DIV class="yema">
			 

			    <DIV class="yema_title">
				  <UL>
				<LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><SPAN class="color_blue">首页</SPAN></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><SPAN class="color_blue">上页</SPAN></LI><LI class="current">1</LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_2.html">2</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_3.html">3</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_4.html">4</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_5.html">5</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_6.html">6</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_7.html">7</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_8.html">8</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_2.html">下页</A></LI><LI onmouseover="this.className=&#39;hover&#39;;" onmouseout="this.className=&#39;&#39;;"><A href="http://www.51booking.cn/hotel/comment_1218_100246069_74.html">尾页</A></LI>
					<LI style="padding:0px 8px 0px 8px;"><SPAN class="color_blue">1/74</SPAN></LI>
					
				 </UL>
				  <DIV class="clear"></DIV>
				</DIV>
		
				
			 <DIV class="clear"></DIV>
			 </DIV>
			 <DIV class="bottom_title">&nbsp;<IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/icon25.gif"><A name="dian" id="dian"></A>&nbsp;
			 
			   
			   您还没有登录 当前是匿名发表    <A href="http://www.51booking.cn/login/index.asp">我要登录</A> 
			   <A href="">免费注册会员</A></DIV>
			 
			 
			 <DIV>
			
               <DIV style="margin:10px; float:left; display:inline;">
                 <TEXTAREA name="criticism" cols="50" rows="8" style="width:426px;"></TEXTAREA>
                 <BR>
 <INPUT name="id" type="hidden" id="id" value="<%=hotel.getId() %>">
               </DIV>
			   	<DIV style="margin:10px; float:left">
               <DIV class="pingfen">
			     <UL>
				   <LI>评分</LI><LI>5</LI><LI>4</LI><LI>3</LI><LI>2</LI><LI>1</LI>
				 </UL>
			     <DIV class="clear"></DIV>
			   </DIV>
				<DIV class="pingfen2">
				<UL>
				 <LI>服务</LI>
				   <LI><INPUT type="radio" value="5" name="service1"></LI>
				   <LI><INPUT type="radio" value="4" name="service1"></LI>
				   <LI><INPUT type="radio" value="3" name="service1"></LI>
				   <LI><INPUT type="radio" value="2" name="service1"></LI>
				   <LI><INPUT type="radio" value="1" name="service1"></LI>
				 </UL>
				 <DIV class="clear"></DIV>
			   </DIV>
			   
			   <DIV class="pingfen">
				<UL>
				 <LI>卫生</LI>
				   <LI><INPUT type="radio" value="5" name="environment1"></LI>
				   <LI><INPUT type="radio" value="4" name="environment1"></LI>
				   <LI><INPUT type="radio" value="3" name="environment1"></LI>
				   <LI><INPUT type="radio" value="2" name="environment1"></LI>
				   <LI><INPUT type="radio" value="1" name="environment1"></LI>
				 </UL>
				 <DIV class="clear"></DIV>
			   </DIV>

			   	<DIV class="pingfen2">
				<UL>
				 <LI>设施</LI>
				   <LI><INPUT type="radio" value="5" name="facility1"></LI>
				   <LI><INPUT type="radio" value="4" name="facility1"></LI>
				   <LI><INPUT type="radio" value="3" name="facility1"></LI>
				   <LI><INPUT type="radio" value="2" name="facility1"></LI>
				   <LI><INPUT type="radio" value="1" name="facility1"></LI>
			   </UL>
				 <DIV class="clear"></DIV>
				 </DIV>
				 
				 
				 
				 			   	<DIV class="pingfen">
				<UL>
				 <LI>价格</LI>
				   <LI><INPUT type="radio" value="5" name="price1"></LI>
				   <LI><INPUT type="radio" value="4" name="price1"></LI>
				   <LI><INPUT type="radio" value="3" name="price1"></LI>
				   <LI><INPUT type="radio" value="2" name="price1"></LI>
				   <LI><INPUT type="radio" value="1" name="price1"></LI>
			   </UL>
				 <DIV class="clear"></DIV>
				 </DIV>
                </DIV>
				<DIV class="clear"></DIV>
				
							     <TABLE width="90%" border="0" cellspacing="0" cellpadding="0">
                   <TBODY><TR>
                     <TD width="2%">&nbsp;</TD>
                     <TD width="7%">验证码</TD>
                     <TD width="17%"><INPUT size="5" name="validatecode">
                     <IMG src="<%=request.getContextPath() %>/pinglun/pinglun1/validatecode.asp" align="absmiddle" border="0"></TD>
                     <TD width="19%"><INPUT type="image" src="<%=request.getContextPath() %>/pinglun/pinglun1/btn_tjpl.jpg" name="Submit"></TD>
                     <TD width="55%">&nbsp;</TD>
                   </TR>
                 </TBODY></TABLE>
			   </DIV>

				 <DIV class="margin8"></DIV>
			 </DIV>
			 </FORM>
<DIV class="margin8"></DIV>
           </DIV>	     </TD>
       </TR>
     </TBODY></TABLE>
</DIV>
<DIV id="bottom"><DIV class="content"><SPAN class="blue"></DIV>
</DIV>

<DIV style="DISPLAY: none">

</DIV>


</BODY></HTML>

</div>
</body>
</html>