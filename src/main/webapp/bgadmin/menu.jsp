<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="<%=request.getContextPath() %>/bgcss/css/admin.css" type="text/css" rel="stylesheet">
<SCRIPT language=javascript>
	function expand(el)
	{
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none')
		{
			childObj.style.display = 'block';
		}
		else
		{
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</HEAD>
<BODY>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170 
background=<%=request.getContextPath() %>/bgcss/images/menu_bg.jpg border=0>
  <TR>
    <TD vAlign=top align=middle>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        
        <TR>
          <TD height=10></TD></TR></TABLE>

      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=request.getContextPath() %>/bgcss/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(2) 
            href="javascript:void(0);">合作酒店管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=request.getContextPath() %>/hotel/managerhotel.do" 
            target=main>酒店信息</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=request.getContextPath() %>/hotel/managerroom.do" 
            target=main>酒店房屋情况</A></TD></TR>
       </TABLE>
       <%if(!"酒店合作伙伴".equals(session.getAttribute("loginusertype"))){ %>
       
      
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=request.getContextPath() %>/bgcss/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(3) 
            href="javascript:void(0);">审核中心</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=request.getContextPath() %>/hotel/checkup.do" 
            target=main>审核新申请</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="#" 
            target=main>最新产品</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="#" 
            target=main>分类管理</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="#" 
            target=main>子类管理</A></TD></TR>
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=request.getContextPath() %>/bgcss/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(4) 
            href="javascript:void(0);">客户服务</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="#" 
            target=main>客户服务</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="#" 
            target=main>分类管理</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="#" 
            target=main>子类管理</A></TD></TR>
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>
     
    
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=request.getContextPath() %>/bgcss/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(7) 
            href="javascript:void(0);">系统管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child7 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
    
     
      
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=request.getContextPath() %>/webadmin/addadminuser.do" 
            target=main>管理员增加</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="" 
            target=main>修改管理员</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=request.getContextPath() %>/webadmin/adminuserlist.do" 
            target=main>管理员列表</A></TD></TR>
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>
          
           <%} %>
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=request.getContextPath() %>/bgcss/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(0) 
            href="javascript:void(0);">个人管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child0 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=request.getContextPath() %>/webadmin/updateadminuser.do" 
            target=main>修改口令</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=request.getContextPath() %>/bgcss/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            onclick="if (confirm('确定要退出吗？')) return true; else return false;" 
            href="<%=request.getContextPath() %>/webadmin/adminlogin.do" 
            target=_top>退出系统</A></TD></TR></TABLE></TD>
    <TD width=1 bgColor=#d1e6f7></TD></TR></TABLE></BODY></HTML>
