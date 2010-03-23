<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.easymorse.room.*" %>
<%
HotelRoom bean = (HotelRoom)request.getAttribute("rooms");

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
<DIV class="hotelintro_title"><UL><LI><SPAN class="span18"></SPAN></LI>
<LI><SPAN class="cheng"></SPAN></LI></UL></DIV>
<DIV class="hotelintro_top_com" id="comment1"></DIV>
<DIV class="clear"></DIV>
<DIV class="hotelintro_pinyin">
</DIV>
<DIV class="hotelintro_menu">  </DIV></DIV>
  <form method="post" action="book_submit_confirm.do">
			 <DIV class="hotelintro_main">
               <DIV class="hotel_address">
			     <UL>
				    <LI><SPAN class="bold12">房间单价：</SPAN>&nbsp;<%=bean.getRoomPrice() %></LI>
					<LI><SPAN class="bold12">预定：<select name="shuliang">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					
					</select>间</SPAN></LI>
					
				
					
				 </UL>
			   </DIV>
			  <DIV class="hotel_address2">
			 </DIV>
               <DIV class="clear"></DIV>
			   <A name="price"></A>   <!--修改日期后刷新到这个位置，锚。-->
			   <DIV class="margin2"></DIV>
			   <DIV class="hotel_intro">
			   <DIV style="font-size:12px;width:570;text-align:justify; text-justify:inter-ideograph"> 
			   <SPAN class="duanluo">
&nbsp;&nbsp;&nbsp;&nbsp;fdaf
</SPAN></DIV>			   </DIV>
			
			   <DIV class="clear"></DIV>
			   <DIV class="div_margin20"></DIV>
			   
			 <DIV id="room_1" class="fangxing"></DIV>   
			   
			  
			 <DIV class="div_margin20"></DIV>
			 
			 <DIV class="fangxing" style="padding-bottom:8px;">
		       <DIV class="fangxing_title"><SPAN>相关信息</SPAN></DIV>
			
			 <DIV  class="fangxing_intro2">
                 
                   联系人: <input type="text" name="people" />
          <br /> 联系电话<input type="text" name="phone" /> 
          <input type="hidden" name="roomId" value="<%=bean.getId() %>"/>  
          <input type="submit" value="提交订单"/>        
                   </form>
				 <DIV class="clear"></DIV>
			   </DIV>
			 
			
				 
			  
			   
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