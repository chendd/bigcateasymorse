<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.easymorse.hotel.*" %>
<%
HotelBean bean = (HotelBean)request.getAttribute("theHotel");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=request.getContextPath()%>/book/css_new.css" rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath()%>/book/div_css.css" rel="stylesheet" type="text/css">
<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/book/prototype.js"></SCRIPT>
<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/book/x.js"></SCRIPT>
<SCRIPT language="javascript" src="<%=request.getContextPath()%>/book/js.js"></SCRIPT>
<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/book/getprice.js"></SCRIPT>
<SCRIPT language="javascript" src="<%=request.getContextPath()%>/book/calendar_div.js"></SCRIPT>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<SCRIPT language="javascript" src="<%=request.getContextPath()%>/book/date_check_index.js"></SCRIPT>
<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/book/getprice.js"></SCRIPT>
<STYLE type="text/css">
.h4{ font-size:18px;}
</STYLE>



<DIV id="head">

<DIV class="Container">
     <TABLE width="954" border="0" cellspacing="0" cellpadding="0">
       <TBODY><TR>
         <TD width="208" valign="top" class="left_bg">		   
	</TD>
         <TD width="746" valign="top">
		   <DIV class="hotelcity">
		      
		   
<DIV id="mask"></DIV>
<DIV class="hotelintro_top"><DIV class="hotelintro_daoxiang"> </DIV>
<DIV class="hotelintro_title"><UL><LI><SPAN class="span18"><%=bean.getHotelName() %></SPAN></LI>
<LI><SPAN class="cheng">★★★</SPAN></LI></UL></DIV>
<DIV class="hotelintro_top_com" id="comment1"></DIV>
<DIV class="clear"></DIV>
<DIV class="hotelintro_pinyin">
</DIV>
<DIV class="hotelintro_menu">  </DIV></DIV>
			 <DIV class="hotelintro_main">
               <DIV class="hotel_address">
			     <UL><!------循环 li------>
				    <LI><SPAN class="bold12">酒店地址：</SPAN><%=bean.getHotelAddress() %>&nbsp;</LI>
					<LI><SPAN class="bold12">预订电话：</SPAN><%=bean.getHotelPhone() %></LI>
					<LI><SPAN class="bold12">酒店区域：</SPAN>&nbsp;&nbsp; 
				</LI>
				
					<LI ><SPAN class="bold12">开业时间：</SPAN>
					1991年开业&nbsp;&nbsp;2003年装修</LI>
					<LI></LI>
				
					<LI ><SPAN class="bold12">房间数量：</SPAN>355 间</LI>
					
				 </UL>
			   </DIV>
			  <DIV class="hotel_address2">
			  <UL><LI><SPAN class="bold12">交通信息</SPAN></LI>
			  <LI>距离机场（公里）：20 </LI>
			  <LI>距离火车站（公里）：5</LI>
			  <LI>距离市中心（公里）：1</LI></UL></DIV>
               <DIV class="clear"></DIV>
			   <A name="price"></A>   <!--修改日期后刷新到这个位置，锚。-->
			   <DIV class="margin2"></DIV>
			   <DIV class="hotel_intro">
			   <DIV style="font-size:12px;width:570;text-align:justify; text-justify:inter-ideograph"> 
			   <SPAN class="duanluo">
&nbsp;&nbsp;&nbsp;&nbsp;
<%=bean.getHotelDetail() %>
</SPAN></DIV>			   </DIV>
			
			   <DIV class="clear"></DIV>
			   <DIV class="div_margin20"></DIV>
			   
			 <DIV id="room_1" class="fangxing"></DIV>   
			   
			  
			 <DIV class="div_margin20"></DIV>
			 
			 <DIV class="fangxing" style="padding-bottom:8px;">
		       <DIV class="fangxing_title"><SPAN>相关信息</SPAN></DIV>
			 <c:forEach items="${hotels}" var="item">
			 <DIV  class="fangxing_intro2">
                    <UL>
					  <LI><DIV class="title">房间： </DIV></LI>
					  <LI class="xiangguan">房间型号： <SPAN class="cheng">${item.roomName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</SPAN>
					 房间价钱：RMB <SPAN class="cheng">${item.roomPrice }</SPAN>
					 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <span><a href="<%=request.getContextPath()%>/book_submit.do?id=${item.id}">
					 <img alt="预定" src="<%=request.getContextPath()%>/book/b_book.gif"></img>
					 </a></span></LI> 
					
					</UL>
				 <DIV class="clear"></DIV>
			   </DIV>
			 
			 </c:forEach>
				 
			  
			   
			 </DIV>
			 </DIV>
			 
			 <DIV class="margin8"></DIV>
		   </DIV></TD>
       </TR>
     </TBODY></TABLE>
</DIV>
<DIV id="showPrice" style="position:absolute; display:none; width:300px;"></DIV>
<DIV id="showDetail"></DIV>
	

</DIV>

<DIV style="display:none">
</DIV>




<SCRIPT language="vbscript" src="<%=request.getContextPath()%>/book/getdate.vbs"></SCRIPT>




</body>
</html>