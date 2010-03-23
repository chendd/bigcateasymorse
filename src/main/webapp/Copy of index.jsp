<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<title>hotel book</title>
<link href="css/style1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
  function  findCityHotel(id){
	  
	document.getElementById("hotelmsg").innerHTML+="<label>酒店星级 </label>"+
		"<label style='font-size: 13px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>五星级 </a>&nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>四星级</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>三星级</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>二星级</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>经济型</a> &nbsp;&nbsp;&nbsp;&nbsp;</label>"+
		"<br /><label>行政区域 </label>"+
		"<label style='font-size: 13px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>朝阳 </a>&nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>海淀</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>东城</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>西城</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>顺义</a> &nbsp;&nbsp;&nbsp;&nbsp;</label>"+
		"<br /><label>热门商业区 </label>"+
		"<label style='font-size: 13px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>亚运村、奥运村商圈</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>马甸地区 </a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>上地、中关村地区</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>国贸商圈</a> &nbsp;&nbsp;&nbsp;&nbsp;"+
		"<a href=''>燕莎商业区</a> &nbsp;&nbsp;&nbsp;&nbsp;</label>";
	
  }
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="webbody">

<div id="body1" align="center" >

<table width="85%" height="340" border="1">

  <tr align="center" height="50%">
    <td width="75%"><br />
	<form id="form1" name="form1" method="post" action="">
      <label>入住城市:
        <input type="text" size="10" name="textfield" />
        </label>
      <label>入住日期:
      <input type="text" size="8" name="textfield2" />
      </label>
	  <label>退房日期:
	  <input type="text" size="8" name="textfield3" />
	  </label> <br /><br />
	  <label>价格范围:
	  <select name="select">
	    <option value="100">100以下</option>
	    <option value="200">100-200</option>
	    <option value="500">200-500</option>
	    <option value="0">不限</option>
	    </select>
	  </label>
	  <label>&nbsp;&nbsp;星级:
	  <select name="select2">
	    <option value="1">一星</option>
	    </select>
	  </label>
	  <label>酒店名称:
	  <input type="text" name="textfield4" /><br />
	  </label>
	  <label align="right">
	<div align="right"> <a  href=""><img src="images/button_czjd.jpg" alt="" /></a></div>
	  </label>
	</form>
    </td>
    <td  rowspan="2" style="margin-left: 0">&nbsp;
    <div>热门城市酒店
<ul> 
<li><img src="images/arrow_1.jpg" alt="" /><A href="http://hotel.elong.com/beijing_1.htm">北京998家</A></li>
<li><img src="images/arrow_1.jpg" alt="" /><A href="http://hotel.elong.com/shanghai_1.htm">上海850家</A> </li>
<li><img src="images/arrow_1.jpg" alt="" /><A href="http://hotel.elong.com/guangzhou_1.htm">广州245家</A> </li>
<li><img src="images/arrow_1.jpg" alt="" /><A href="http://hotel.elong.com/shenzhen_1.htm">深圳292家</A> </li>
<li><img src="images/arrow_1.jpg" alt="" /><A href="http://hotel.elong.com/nanjing_1.htm">南京206家</A> </li>
<li><img src="images/arrow_1.jpg" alt="" /><A href="http://hotel.elong.com/wuhan_1.htm">武汉190家</A> </li>
<li><img src="images/arrow_1.jpg" alt="" /><A href="http://hotel.elong.com/sanya_1.htm">三亚92家</A> </li>

</ul><br />
<img src="images/TheSt.Regis.jpg" alt="" />
</div>

</td>
  </tr>
  <tr>
    <td  bgcolor="#F3F3F3">&nbsp;
    <label><img src="images/thjdyd_logo.jpg" width="150"></img></label>
    	<table width="100%"  >
        <tr align="center">
          <td >&nbsp;宝宇荣耀时尚公寓</td>
          <td >&nbsp;158 元/间</td>
          <td >&nbsp;<img src="images/button_ljyd.jpg"></img></td>
        </tr>
        <tr align="center">
          <td >&nbsp;宝宇荣耀时尚公寓</td>
          <td >&nbsp;158 元/间</td>
          <td >&nbsp;<img src="images/button_ljyd.jpg"></img></td>
        </tr>
        <tr align="center">
          <td >&nbsp;宝宇荣耀时尚公寓</td>
          <td >&nbsp;158 元/间</td>
          <td >&nbsp;<img src="images/button_ljyd.jpg"></img></td>
        </tr>
         <tr align="center">
          <td >&nbsp;宝宇荣耀时尚公寓</td>
          <td >&nbsp;158 元/间</td>
          <td >&nbsp;<img src="images/button_ljyd.jpg"></img></td>
        </tr>
        
      </table>
     <div align="right"> <a href=""><h5>更多>></h5></a></div>
    </td>
  </tr>
</table>
</div>
<div  align="center">
<table width="85%" border="1">

  <tr  >
    <td width="75%">&nbsp;<label>热门城市酒店</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <label  style="font-size: 13px">
    <a href="javascript:findCityHotel(1);">北京</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">上海</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">天津</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">广州</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">杭州</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">杭州</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">南京</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">成都</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">武汉</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">哈尔滨</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="">三亚</a>&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
    <td  rowspan="3" align="center" >&nbsp;<img src="images/quxiao100203.jpg" alt="取消" /> <br />
    	<p  style="background-color: #DDEEF0;" >出行帮助</p><br />
	<a href="">常见问题</a><br />
	<a href="">预订须知</a><br />
	<a href="">信息安全措施</a>
    </td>
  </tr>
  <tr align="center">
          <td >宝宇荣耀时尚公寓
        &nbsp; &nbsp; &nbsp;158 元/间&nbsp;&nbsp; &nbsp; &nbsp;<img src="images/button_ljyd.jpg"></img><br />
        	宝宇荣耀时尚公寓
        &nbsp; &nbsp; &nbsp;158 元/间&nbsp;&nbsp; &nbsp; &nbsp;<img src="images/button_ljyd.jpg"></img><br /></td>
        </tr>
  <tr>
    <td>&nbsp;<div id="hotelmsg"></div></td>
    </tr>
</table>

</div>
<div id="liansuo" align="center">

<table width="85%" border="1">
   <caption >
    品牌酒店推荐
  </caption>
  <tr>
    <td>&nbsp;<img src="images/1.gif" alt=""  width="50" height="50"/><br />富豪酒店</td>
    <td>&nbsp;<img src="images/2.gif" alt="" width="70" height="60" /><br />富豪酒店</td>
    <td>&nbsp;<img src="images/3.gif" alt="" /><br />富豪酒店</td>
    <td>&nbsp;<img src="images/4.gif" alt="" /><br />富豪酒店</td>
    <td>&nbsp;<img src="images/5.jpg" alt="" /><br />富豪酒店</td>
    <td>&nbsp;<img src="images/6.gif" alt="" /><br />富豪酒店</td>
    <td>&nbsp;<img src="images/7.gif" alt="" /><br />富豪酒店</td>
    <td>&nbsp;<img src="images/8.gif" alt="" /><br />富豪酒店</td>
  </tr>
</table>









</div>
</div>
</body>
</html>