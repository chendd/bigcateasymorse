<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- prototype -->
<script type="text/javascript" src="js/window/prototype.js"></script>

<!--prototype window -->
<script type="text/javascript" src="js/window/effects.js"></script>
<script type="text/javascript" src="js/window/window.js"></script>
<script type="text/javascript" src="js/window/window_effects.js"></script>
<link href="themes/default.css" rel="stylesheet" type="text/css"></link>
<link href="themes/spread.css" rel="stylesheet" type="text/css"></link>
<link href="themes/lighting.css" rel="stylesheet" type="text/css"></link>
<link href="themes/alphacube.css" rel="stylesheet" type="text/css"></link>
<link href="themes/alert.css" rel="stylesheet" type="text/css"></link>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>

<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script language="JavaScript" type="text/javascript">  
var did = "0";
function cleanWhitespace(element) {   
 //遍历element的子结点   
 for (var i = 0; i < element.childNodes.length; i++) {   
  var node = element.childNodes[i];   
  //判断是否是空白文本结点，如果是，则删除该结点   
  if (node.nodeType == 3 && !/\S/.test(node.nodeValue))    
  node.parentNode.removeChild(node);   
 }   
}   
//获得表格对象   
var _table=document.getElementById("table1");   
cleanWhitespace(_table);   
//使表格行上移，接收参数为链接对象   
function moveUp(_a){   
 //通过链接对象获取表格行的引用   
 var _row=_a.parentNode.parentNode;   
 //如果不是第一行，则与上一行交换顺序   
 if(_row.previousSibling)swapNode(_row,_row.previousSibling);   
}   
//使表格行下移，接收参数为链接对象   
function moveDown(_a){   
 //通过链接对象获取表格行的引用   
 var _row=_a.parentNode.parentNode;   
 //如果不是最后一行，则与下一行交换顺序   
 if(_row.nextSibling)swapNode(_row,_row.nextSibling);   
}   
//定义通用的函数交换两个结点的位置   
function swapNode(node1,node2){   
 //获取父结点   
 var _parent=node1.parentNode;   
 //获取两个结点的相对位置   
 var _t1=node1.nextSibling;   
 var _t2=node2.nextSibling;   
 //将node2插入到原来node1的位置   
 if(_t1)_parent.insertBefore(node2,_t1);   
 else _parent.appendChild(node2);   
 //将node1插入到原来node2的位置   
 if(_t2)_parent.insertBefore(node1,_t2);   
 else _parent.appendChild(node1);   
}   


function getStr(){
	alert(document.getElementsByTagName("*")["mytable"].rows.length   );
}

function removeRow(obj)
{
     var clickedRow = obj;

     while(clickedRow.tagName != "TR")
     {
         clickedRow = clickedRow.parentNode;
     }

     clickedRow.parentNode.removeChild(clickedRow);
}


function addRow(vid)
{
    

	
	var objTable = document.getElementsByTagName("*")["mytable"];
	var rowNum = objTable.rows.length+1;
	var newRow = document.createElement("tr"); //新建一个row 

	for ( var i = 0; i < 6; i++) {
		var newCell = document.createElement("td"); //新建一个cell 
		if (i == 0) //第一格 
		{

			
			var newText = document.createTextNode(rowNum);
			newCell.appendChild(newText);

		} else if (i == 1) //第二格 
		{
			var txtInput = '待填';
			var newText2 = document.createTextNode(txtInput);
			newCell.appendChild(newText2);
		} else if(i == 2){
			//创建第三个CELL的innerHTML 
			var innerHTML = vid;
			newCell.innerHTML = innerHTML;
		}
		else if(i==3){
			var innerHTML5="<img src='<%=application.getAttribute("IMAGE_URL")%>/${video.imageUrl }'/>";
			newCell.innerHTML = innerHTML5;

			}
		else if(i == 4){
			var innerHTML2="<a href='javascript:void(0)' onclick='removeRow(this)'>删除</a> <a href='#'>修改</a>";
			newCell.innerHTML = innerHTML2;
			}
		else {
			var innerHTML3="<img src='images/up.gif' onclick='moveDown(this)'> <img src='images/down.gif' onclick='moveUp(this)'>";
			newCell.innerHTML = innerHTML3;
			}
		newRow.appendChild(newCell); //把新建的一个cell附加到row 

	}

	objTable.getElementsByTagName("tbody")[0].appendChild(newRow); //把新建的row附加到table 

}


function infoTimeout() {

	  Dialog.closeInfo()
	}

	          





	function savedata(){
		
		t=document.getElementById("mytable"); 
	    row_num=t.rows.length; 
	    cell_num=t.rows[0].cells.length; 
	    var str=new String("0"); 
	    var str2=new String("0"); 
	    for(i=row_num-1;i>=0;i--) 
	    { 
	          str=str+','+t.rows[i].cells[0].innerHTML; 
	          str2=str2+','+t.rows[i].cells[2].innerHTML; 
	    } 
	    str = str.substring(2);
	    str2 = str2.substring(2);
		Dialog.info("Saving........",
	            {width:100, height:50, showProgress: true});
		var url = 'updateMayLikeVideo.do';
		var pars = "type=ajax&ids="+str+"&vids="+str2;
	
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :saveok
		});
		
	}

	function saveok(originalRequest){
		
		jsonRaw = originalRequest.responseText;

		
		if(jsonRaw=='ok'){
			setTimeout(infoTimeout, 1000)
		
		}
		
	}

//----------------------
var winn=null;

function getVideos(pageNo){
	if(winn == null){
		winn= new Window({className: "dialog",  width:450, height:500, zIndex: 100, resizable: true, title: "用户列表", showEffect:Effect.BlindDown, hideEffect: Effect.SwitchOff, draggable:true, wiredDrag: true})
		}	
	
	winn.getContent().innerHTML= "<img src='images/loading.gif' />";
	winn.setStatusBar("Status bar info");
	winn.showCenter();  
	
	 var url = 'getCandidateVideoes.do';
    
	  var pars = 'type=ajax&pageNo='+pageNo;

	 	
	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse1 });
	      
	            
             
             }

function showResponse1(originalRequest){
	jsonRaw = originalRequest.responseText;
	 pagination = eval("(" + jsonRaw + ")");

	 var val = "<table  width='430' border='0'><tr style='color: red;'><td width='30'></td><td width='100'>ID</td><td width='100'>视频名称</td><td width='200'>推荐理由</td></tr>";
	 for (i = 0; i < pagination.results.length; i++) {
		 val = val +"<tr><td><input type='radio' name='pid' value='"+pagination.results[i].videoId+"'/></td><td>"+pagination.results[i].id+"</td><td>"+pagination.results[i].videoName+"</td><td>"+pagination.results[i].sake+"</td></tr>";
		 }
	 val=val+"</table><br />";

	 if(pagination.next){
	
		 val=val+'<a href="#" onclick="getPlayBills('+"'"+(Number(pagination.no)+1)+"'"+')">下一页</a> ';
		 }
	 if(pagination.previous){
		 val=val+'<a href="#" onclick="getPlayBills('+"'"+(Number(pagination.no)-1)+"'"+')">上一页</a> ';
		 }
	 val = val+'<br /><button onclick="addit()">确定</button>';
	 winn.getContent().innerHTML= val;

	
	 
 		}




function addit(){
	
	var vid='';
	
	 var pids = document.getElementsByName('pid');
	  for (var j=0; j<pids.length; j++){
		  if(pids[j].checked){
			  vid = pids[j].value;
			  }
		
		  }
	  did = did+","+vid;
	  addRow(vid);
		  winn.close();
			winn = null;
		 
	 
	
}




	

</script>  
<style type="text/css">  
<!--  
td  { text-align:center;font-size:12px;padding:3px;}  
-->  
</style> 
<div class="module">
<div class="title">
<span><a href="javascript:void(0)" onclick="getVideos('1');">添加</a> <a href="javascript:void(0)" onclick="savedata();">保存</a></span>
<h2>首页最受欢迎视频推荐</h2>
</div>
<div class="reDiv">
<form action="" method="post" name="form">

<table width="711" height="22" border="0">
  <tr>
    <td width="58"><div align="center">顺序</div></td>
    <td width="88"><div align="center">显示名称</div></td>
    <td width="118"><div align="center">对应视频ID</div></td>
<td width="100"><div align="center">显示图片</div></td>
    <td width="148"><div align="center">操作</div></td>
    <td width="165"><div align="center">排序</div></td>
  </tr>
</table>
<table width="711" height="22" border="0" id="mytable">
<c:forEach items="${mayLikeVideoes}" var="video">
  <tr>
    <td width="58">${video.id }</td>
    <td width="88">${video.name}</td>
    <td width="118">${video.video.id }</td>
<td width="100"><img src="<%=application.getAttribute("IMAGE_URL")%>/${video.imageUrl }"/></td>
    <td width="148"><a href="javascript:void(0)" onclick="removeRow(this)">删除</a> <a href="getMayLikeVideo.do?id=${video.id }">修改</a></td>
    <td width="165"><img src="images/up.gif" onclick="moveDown(this)"/> <img src="images/down.gif" onclick="moveUp(this)"/> </td>
  </tr>
</c:forEach>
</table>

</form>

</div>
</div>

</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>
</html>