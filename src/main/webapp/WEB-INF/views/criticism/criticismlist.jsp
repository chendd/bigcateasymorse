<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0032)http://www.51booking.cn/comment/ -->
<HTML><HEAD><META http-equiv="Content-Type" content="text/html; charset=GBK">
<TITLE>东莞酒店点评_东莞宾馆评论_中国商务订房网</TITLE>

<SCRIPT language="javascript" src="<%=request.getContextPath() %>/pinglun/changeclass.js"></SCRIPT>
<SCRIPT language="javascript" src="<%=request.getContextPath() %>/pinglun/chkfunc.js"></SCRIPT>
<SCRIPT language="javascript" src="<%=request.getContextPath() %>/pinglun/calendar.js"></SCRIPT></HEAD><BODY><IFRAME id="CalFrame" name="CalFrame" frameborder="0" src="<%=request.getContextPath() %>/pinglun/calendar.htm" style="display:none;position:absolute;z-index:100" width="144" height="192"></IFRAME>
<SCRIPT language="javascript" src="<%=request.getContextPath() %>/pinglun/xuanxiangka.js"></SCRIPT>
<SCRIPT language="javascript" src="<%=request.getContextPath() %>/pinglun/js.js"></SCRIPT>
<SCRIPT language="javascript">

function setCheckInDate(d)
{
	document.getElementById("intime").value=d;
	document.getElementById("outtime").value="";
	if(document.getElementById("outtime").value.length==0)
	{
		showCalendar('dimg2',false,'outtime','intime');
	}
}
function check(frm)
{

	if (frm.city1.value=="" )
	{
		alert("请选择城市!");
		return false;}

}

</SCRIPT>
<LINK href="<%=request.getContextPath() %>/pinglun/css_new.css" type="text/css" rel="stylesheet">
<LINK href="<%=request.getContextPath() %>/pinglun/comment.css" type="text/css" rel="stylesheet">
<LINK href="<%=request.getContextPath() %>/pinglun/div_css.css" type="text/css" rel="stylesheet">



<DIV id="head">
<DIV id="top">
 
 
 
  <DIV class="clear"></DIV>
</DIV>
<DIV id="nav">
  <DIV id="navbox">
  </DIV>
</DIV>
</DIV>

<DIV class="Container">
<TABLE style="MARGIN-LEFT: 1px" cellspacing="0" cellpadding="0" width="954" align="center" border="0">
  
  <TBODY><TR>
    <TD class="left_bg" valign="top" width="208" style="color:#0058B0">
     <DIV class="left_in">
	   
  

            <DIV class="left_in">
		     <DIV class="left_in_in">

    
    
    </DIV>
		   </DIV>
			<DIV class="left_in">
		     
		   
			  
			  <TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
          <TBODY><TR>
                                            
        </TBODY></TABLE>
		   </DIV>
      </TD>
   
    <TD valign="top" width="746">
      <DIV class="hotelcity">
      <DIV class="comment_search">
      
     
		</DIV>
<DIV class="maincontent">

<DIV style="width:100%">
 

<c:forEach items="${hotellist}" var="item">

<DIV class="hoteltitle"><A  href="" target="blank">${item.hotelName}</A></DIV>
<DIV class="dianping_box">
                  <UL>
                    <LI>地址：&nbsp;&nbsp;${item.hotelAddress}</LI>
					 
                    <LI>评论：忘了morning call  第一次遇到有酒店竟然忘了给morning call,还好客...
					
					</LI>
					 
                    <LI><SPAN><A  href="<%=request.getContextPath()%>/addcriticism.do?id=${item.id}" target="blank">[查看详细]</A></SPAN><SPAN style="color:#999999">点评时间：</SPAN></LI>
					<LI>
					<LI><IMG src="<%=request.getContextPath() %>/pinglun/icon11.gif"> <SPAN><A  href="" target="blank">查看30条点评</A></SPAN>
					<SPAN><IMG src="<%=request.getContextPath() %>/pinglun/icon6.gif">
					 <A  href="<%=request.getContextPath()%>/addcriticism.do?id=${item.id}" target="blank">我要点评</A></SPAN>
					 <SPAN><IMG src="<%=request.getContextPath() %>/pinglun/icon10.gif">
					  <A  href="<%=request.getContextPath()%>/bookhotel.do?id=${item.id}" target="blank">我要预订</A></SPAN></LI><LI>
                  </UL>
              </DIV>
<DIV class="dianping_box_right">
<UL>
<LI><SPAN>卫生:3.70</SPAN></LI>
<LI><SPAN>服务:3.67</SPAN></LI>
<LI><SPAN>设施:3.57</SPAN></LI>
<LI><SPAN>价格:3.73</SPAN></LI>
</UL></DIV>
<DIV class="clear"></DIV>
</c:forEach>




 
</DIV>   
</DIV>

<DIV style="FONT-SIZE: 12px" align="right">


			    <DIV class="yema_title">
				
				  <DIV class="clear"></DIV>
				</DIV>
		
				
      <DIV class="clear"></DIV><BR></DIV></DIV></TD></TR></TBODY></TABLE>
</DIV>


<DIV style="display:none"></DIV>
<DIV id="bottom2">
</DIV>

</BODY></HTML>
</body>
</html>