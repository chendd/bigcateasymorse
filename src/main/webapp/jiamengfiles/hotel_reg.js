// JavaScript Document

function check(frm)
{ 	//alert(document.getElementById("hotel_beizhu").value.length)

   



	if (isNaN(frm.hotel_distance_1.value)&&frm.hotel_distance_1.value!='')
		{
		alert("距离请输入数值！");
		frm.hotel_distance_1.focus();
		return false;
		}

	if (isNaN(frm.hotel_distance_1.value)&&frm.hotel_distance_1.value!='')
		{
		alert("距离请输入数值！");
		frm.hotel_distance_1.focus();
		return false;
		}


	if (isNaN(frm.hotel_distance_2.value)&&frm.hotel_distance_1.value!='')
		{
		alert("距离请输入数值！");
		frm.hotel_distance_2.focus();
		return false;
		}

	if (isNaN(frm.hotel_distance_3.value)&&frm.hotel_distance_1.value!='')
		{
		alert("距离请输入数值！");
		frm.hotel_distance_3.focus();
		return false;
		}

	if (isNaN(frm.hotel_distance_4.value)&&frm.hotel_distance_1.value!='')
		{
		alert("距离请输入数值！");
		frm.hotel_distance_4.focus();
		return false;
		}

	if (isNaN(frm.hotel_distance_5.value)&&frm.hotel_distance_1.value!='')
		{
		alert("距离请输入数值！");
		frm.hotel_distance_5.focus();
		return false;
		}

	if (isNaN(frm.hotel_distance_6.value)&&frm.hotel_distance_1.value!='')
		{
		alert("距离请输入数值！");
		frm.hotel_distance_6.focus();
		return false;
		}


if (document.getElementById("hotel_name").value=='')
		
		{
			alert("请输入酒店名称");
		document.getElementById("hotel_name").focus();
		return false;
		}
		
		if (document.getElementById("hotel_name").value.length<5)
		{alert("酒店名称不能太短!");
		document.getElementById("hotel_name").focus();
		return false;
		}
		
		if (document.getElementById("link_name").value=='')
		{alert("请输入联系人名称");
		document.getElementById("link_name").focus();
		return false;
		}
		
		
			if (document.getElementById("link_tel").value=='')
		{alert("请输入联系人电话");
		document.getElementById("link_tel").focus();
		return false;
		}
		
		
		if (document.getElementById("hotel_star").value==0)
		{alert("请选择星级");
		document.getElementById("hotel_star").focus();
		return false;
		}
		
		
		
			if (document.getElementById("city").value==0)
	{alert("请选择城市");
		document.getElementById("city").focus();
		return false;
		}
		if (document.getElementById("hotel_address").value==0)
		{alert("请添加酒店地址");
		document.getElementById("hotel_address").focus();
		return false;
		}
		if (document.getElementById("hotel_tel").value==0)
		{alert("请添加酒店电话");
		document.getElementById("hotel_tel").focus();
		return false;
		}
		
		
		
		
		
		if (document.getElementById("hotel_around").value==0)
		{alert("请填写周边景观");
		document.getElementById("hotel_around").focus();
		return false;
		}
		
		
	var   flag=false;  
 for(i=0;i<frm.hotel_Services.length;i++)   
          if(frm.hotel_Services[i].checked)   
          {     
            
              flag=true;     
              break;   
          }   
   if(!flag)   
        {  alert("请选择服务项目!");   
      return flag;   }
	  
	  
	
		if (document.getElementById("hotel_resume").value==0)
		{alert("请添加酒店介绍");
		document.getElementById("hotel_resume").focus();
		return false;
		}
		if (document.getElementById("hotel_beizhu").value==0)
		{alert("请添加简单简介");
		document.getElementById("hotel_beizhu").focus();
		return false;
		}	
	
		if (document.getElementById("hotel_beizhu").value.length>80)
		{alert("简单简介不能超过80个字符");
		document.getElementById("hotel_beizhu").focus();
		return false;
		}	
		
		
	
		
}

	function winopen(value1)
	{var url1
	alert(value1)
	url1='checkhotel.asp?hotel_name='+value1
	window.open (url1, 'newwindow', 'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no')
//	window.open()"
	}


function gethotelname(){
	
	for(var i=1;i<=45;i++){
		var Obj = document.getElementById("str2");
		if(Obj){
			var rid = document.getElementById("hotel_name").value;
			var request = Ajax.getTransport();
			request.open("GET", "hotelnametest.action?hotel_name="+rid+"&d="+(new Date()).getTime(), false);
			request.send();
			var r1=request.responseText;
					if (r1=='y'){
					Obj.innerHTML = "<font color=red>·此酒店未有加盟合作,可以申请!</font>";}
				}
				if (r1=='n'){
					Obj.innerHTML = "<font color=red>·此酒店已存在,请进行搜索查核!</font>";}
				
				if (r1=='s'){
					Obj.innerHTML = "<font color=red>·您输入的酒店名称太短!</font>";}
			
		else{
			break;
		}
	}
}

//全选
function selectall(frm,flag)
{
	var l=frm.length;
	if(l==null)
		l=1;
	if(l==1){
		frm.checked = flag;
	}else{
	for(i=0;i<=frm.length;i++){
		if(frm[i]!=null)
    		frm[i].checked = flag;}
	}
}
