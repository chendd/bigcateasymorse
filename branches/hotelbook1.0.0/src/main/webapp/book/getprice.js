// JavaScript Document

getFirstPrice = function(){
	for(var i=1;i<=45;i++){
		var Obj = document.getElementById("f"+i);
		if(Obj){
			var rid = Obj.getAttribute("rid");
			var request = Ajax.getTransport();
			request.open("GET", "/hotel/hotel_price_firstday.asp?roomid="+rid+"&d="+(new Date()).getTime(), false);
			request.send();
			Obj.innerHTML = request.responseText;
		}
		else{
			break;
		}
	}
}

getTradePrice = function(){
	for(var i=0;i<=60;i++){
		var Obj = document.getElementById("f"+i);
		if(Obj){
			var rid = Obj.getAttribute("rid");
			var request = Ajax.getTransport();
			request.open("GET", "/hotel/hotel_price_Tradeday.asp?roomid="+rid+"&d="+(new Date()).getTime(), false);
			request.send();
			Obj.innerHTML = request.responseText;
		}
		else{
			break;
		}
	}
}

getTradePrice_new = function()
{
			var request = Ajax.getTransport();
			request.open("GET", "/hotel/hotel_price_Tradeday_new.asp?d="+(new Date()).getTime(), false);
			request.send();
		
		
}


//citylist.asp价格

getcitylistPrice = function(){
	for(var i=0;i<=49;i++){
		var Obj = document.getElementById("f"+i);
		if(Obj){
			var rid = Obj.getAttribute("rid");
			var request = Ajax.getTransport();
			request.open("GET", "/hotel/hotel_price_citylist.asp?id="+rid+"&d="+(new Date()).getTime(), false);
			request.send();
			Obj.innerHTML = request.responseText;
		}
		else{
			break;
		}
	}
}



//map.html
getTradetime = function(){

			var request = Ajax.getTransport();
			request.open("GET", "/hotel/hotel_price_Tradetime.asp?"+"d="+(new Date()).getTime(), false);
			request.send();
			
	
}




hidePrice = function(Obj){
	$(Obj).style.display = 'none';
}


getPrice = function(_inTime, _outTime, _roomId, Obj){
	
	var request = Ajax.getTransport();

	request.open("GET", "/hotel/hotel_price.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&d="+(new Date()).getTime(), false);
	request.send();
	var c = request.responseText;
	var doc = c.split("|");
	//alert(doc[0]);
	
	var content;
	content = '<table width="245" border="0" cellspacing="1" cellpadding="3" class="p_tb_title">';
	content += '<tr>';
	content += '<td class="p_td_title"><strong>周日</strong></td>';
	content += '<td class="p_td_title"><strong>周一</strong></td>';
	content += '<td class="p_td_title"><strong>周二</strong></td>';
	content += '<td class="p_td_title"><strong>周三</strong></td>';
	content += '<td class="p_td_title"><strong>周四</strong></td>';
	content += '<td class="p_td_title"><strong>周五</strong></td>';
	content += '<td class="p_td_title"><strong>周六</strong></td>';
	content += '</tr>';
	content += '<tr>';
	
	var t1 = doc[0].split("-");
	var t2 = doc[1].split("-");
	var d1 = new Date(t1[0], parseInt(t1[1])-1, t1[2]);
	var d2 = new Date(t2[0], parseInt(t2[1])-1, t2[2]);
	var p = doc[2].split(" ");
	var z = doc[3].split(" ");
	var i,j;
	for(j=1;j<=d1.getDay();j++){
    	content += '<td class="p_td_content">&nbsp;</td>';
	}
	for(i=0;i<p.length;i++){
		if(p[i]<=0){
			content += '<td class="p_td_content" title="满房"><span class="cheng"><strong>×</strong></span></td>';
		}
		else{
	    	content += '<td class="p_td_content"><span>'+p[i]+'</span><br />'+(z[i]==0?"无早":z[i]==1?"单早":z[i]==2?"双早":z[i]==3?"三早":z[i]==4?"四早":z[i]==5?"五早":z[i]==6?"六早":"")+'</td>';
		}
		if((i+j)%7==0){
			content += '</tr><tr>';
		}/**/
	}
	if((i+j-1)%7!=0){
		for(var k=(i+j-1)%7;k<7;k++){
			content += '<td class="p_td_content">&nbsp;</td>';
		}
	}
	//alert(i+j);
  	content += '</tr>';
	content += '</table>';
	$(Obj).innerHTML = content;
	xLeft(Obj, event.x);
	xTop(Obj, event.y + document.body.scrollTop);
	$(Obj).style.display = 'block';
}



hidePrice = function(Obj){
	$(Obj).style.display = 'none';
}


getPrice_new = function(_inTime, _outTime, _roomId, Obj){
	
	var request = Ajax.getTransport();

	request.open("GET", "/hotel/hotel_price.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&d="+(new Date()).getTime(), false);
	request.send();
	var c = request.responseText;
	var doc = c.split("|");
	//alert(doc[0]);
	
	var content;
	content = '<table width="245" border="0" cellspacing="1" cellpadding="3" class="p_tb_title">';
	content += '<tr>';
	content += '<td class="p_td_title"><strong>周日</strong></td>';
	content += '<td class="p_td_title"><strong>周一</strong></td>';
	content += '<td class="p_td_title"><strong>周二</strong></td>';
	content += '<td class="p_td_title"><strong>周三</strong></td>';
	content += '<td class="p_td_title"><strong>周四</strong></td>';
	content += '<td class="p_td_title"><strong>周五</strong></td>';
	content += '<td class="p_td_title"><strong>周六</strong></td>';
	content += '</tr>';
	content += '<tr>';
	
	var t1 = doc[0].split("-");
	var t2 = doc[1].split("-");
	var d1 = new Date(t1[0], parseInt(t1[1])-1, t1[2]);
	var d2 = new Date(t2[0], parseInt(t2[1])-1, t2[2]);
	var p = doc[2].split(" ");
	var z = doc[3].split(" ");
	var i,j;
	for(j=1;j<=d1.getDay();j++){
    	content += '<td class="p_td_content">&nbsp;</td>';
	}
	for(i=0;i<p.length;i++){
		if(p[i]<=0){
			content += '<td class="p_td_content" title="满房"><span class="cheng"><strong>×</strong></span></td>';
		}
		else{
	    	content += '<td class="p_td_content"><span>'+p[i]+'</span><br />'+(z[i]==0?"无早":z[i]==1?"单早":z[i]==2?"双早":z[i]==3?"三早":z[i]==4?"四早":z[i]==5?"五早":z[i]==6?"六早":"")+'</td>';
		}
		if((i+j)%7==0){
			content += '</tr><tr>';
		}/**/
	}
	if((i+j-1)%7!=0){
		for(var k=(i+j-1)%7;k<7;k++){
			content += '<td class="p_td_content">&nbsp;</td>';
		}
	}
	//alert(i+j);
  	content += '</tr>';
	content += '</table>';
	$(Obj).innerHTML = content;
	xLeft(Obj, event.x);
	xTop(Obj, event.y + document.documentElement.scrollTop);
	$(Obj).style.display = 'block';
}


getDetail = function(_area, _floor, _net, _detail, Obj){
	var content = "";
	if(_area!="") content += "面积："+_area; 
	if(_floor!="") content += "平方米，楼层："+_floor;
	if(_net!="") content += "层，"+_net;
	if(_detail!="") content += "，"+_detail;
	$(Obj).innerHTML = content;
	xLeft(Obj, event.x);
	xTop(Obj, event.y + document.body.scrollTop);
	$(Obj).style.display = 'block';
}
hideDetail = function(Obj){
	$(Obj).style.display = 'none';
}



getDetail_div = function(_area, _floor, _net, _detail, Obj){
	var content = "";
	if(_area!="") content += "面积："+_area; 
	if(_floor!="") content += "平方米，楼层："+_floor;
	if(_net!="") content += "层，"+_net;
	if(_detail!="") content += "，"+_detail;
	$(Obj).innerHTML = content;
	xLeft(Obj, event.x);
	xTop(Obj, event.y + document.documentElement.scrollTop);
	$(Obj).style.display = 'block';
}
hideDetail = function(Obj){
	$(Obj).style.display = 'none';
}


//******************************

getPrice2 = function(_inTime, _outTime, _roomId, Obj,Obj2,Obj3){
	
	var request = Ajax.getTransport();

	request.open("GET", "/hotel/hotel_price_date2.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&d="+(new Date()).getTime(), false);
	request.send();
	var c = request.responseText;
	
	var doc = c.split("|");
	//alert(doc[0]);
	
	var content;
	content = '<table  width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td width="63" height="22">入住日期：</td><td width="104" height="22"><span class="cheng bold">'+_inTime+'</span></td><td width="60">离店日期：</td><td width="103"><span class="cheng bold">'+_outTime+'</span></td><td width="79">共 <span class="cheng bold"><div id="day_1" style="display:inline" ></div></span>&nbsp;晚&nbsp;</td><td>&nbsp;</td></tr><table>';
	
	content += '<table width="650" border="0" cellspacing="1" cellpadding="3" class="p_tb_title">';
	content += '<tr>';
	content += '<td class="p_td_title"><strong>星期日</strong></td>';
	content += '<td class="p_td_title"><strong>星期一</strong></td>';
	content += '<td class="p_td_title"><strong>星期二</strong></td>';
	content += '<td class="p_td_title"><strong>星期三</strong></td>';
	content += '<td class="p_td_title"><strong>星期四</strong></td>';
	content += '<td class="p_td_title"><strong>星期五</strong></td>';
	content += '<td class="p_td_title"><strong>星期六</strong></td>';
	content += '</tr>';
	content += '<tr>';
	
	var t1 = doc[0].split("-");
	var t2 = doc[1].split("-");
	var d1 = new Date(t1[0], parseInt(t1[1])-1, t1[2]);
	var d2 = new Date(t2[0], parseInt(t2[1])-1, t2[2]);
	var p = doc[2].split(" ");
	var z = doc[3].split(" ");
	var date_str = doc[4].split(" ");
	var day_all = doc[5]
		var money_all ='<strong ><font color=#666>单间总额&nbsp;</font><span style="font-size:14px;font-family:sans-serif;letter-spacing:1px;">'+ doc[6]+'</span></strong><font color=#999999></font>'
	var i,j;
	for(j=1;j<=d1.getDay();j++){
    	content += '<td class="p_td_content">&nbsp;</td>';
	}
	for(i=0;i<p.length;i++){
		if(p[i]<=0){
			content += '<td class="p_td_content" title="满房"><span class="cheng"><strong>×</strong></span></td>';
		}
		else{
	    	content += '<td class="p_td_content"><span>'+p[i]+'</span>  '+(z[i]==0?"无早":z[i]==1?"单早":z[i]==2?"双早":z[i]==3?"三早":z[i]==4?"四早":z[i]==5?"五早":z[i]==6?"六早":"")+'<br><font color=#999999>'+date_str[i]+'</font></td>';
		}
		if((i+j)%7==0){
			content += '</tr><tr>';
		}/**/
	}
	if((i+j-1)%7!=0){
		for(var k=(i+j-1)%7;k<7;k++){
			content += '<td class="p_td_content">&nbsp;</td>';
		}
	}
	//alert(i+j);
  	content += '</tr>';
	content += '</table>';
	$(Obj).innerHTML = content;
	$(Obj).style.display = 'block';
	$(Obj2).innerHTML = day_all;
	//$(Obj2).style.display = 'block';
		$(Obj3).innerHTML = money_all;
	//$(Obj3).style.display = 'block';
	
}
//********************************************************
getPrice3 = function(_inTime, _outTime, _roomId, Obj,Obj2,Obj3){
	
	var request = Ajax.getTransport();

	request.open("GET", "/hotel/hotel_price_date2.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&d="+(new Date()).getTime(), false);
	request.send();
	var c = request.responseText;
	
	var doc = c.split("|");

	
	var content;
	content = '<table  width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td width="63" height="22">入住日期：</td><td width="104" height="22"><span class="cheng bold">'+_inTime+'</span></td><td width="60">离店日期：</td><td width="103"><span class="cheng bold">'+_outTime+'</span></td><td width="79">共 <span class="cheng bold"><div id="day_1" style="display:inline" ></div></span>&nbsp;晚&nbsp;</td><td>&nbsp;</td></tr><table>';
	
	content += '<table width="650" border="0" cellspacing="1" cellpadding="3" class="p_tb_title">';
	content += '<tr>';
	content += '<td class="p_td_title"><strong>星期日</strong></td>';
	content += '<td class="p_td_title"><strong>星期一</strong></td>';
	content += '<td class="p_td_title"><strong>星期二</strong></td>';
	content += '<td class="p_td_title"><strong>星期三</strong></td>';
	content += '<td class="p_td_title"><strong>星期四</strong></td>';
	content += '<td class="p_td_title"><strong>星期五</strong></td>';
	content += '<td class="p_td_title"><strong>星期六</strong></td>';
	content += '</tr>';
	content += '<tr>';
	
	var t1 = doc[0].split("-");
	var t2 = doc[1].split("-");
	var d1 = new Date(t1[0], parseInt(t1[1])-1, t1[2]);
	var d2 = new Date(t2[0], parseInt(t2[1])-1, t2[2]);
	var p = doc[2].split(" ");
	var z = doc[3].split(" ");
	var date_str = doc[4].split(" ");
	var day_all = doc[5]
		var money_all ='<strong><font color=#666>单间总额&nbsp;</font><span style="font-size:14px;font-family:sans-serif;letter-spacing:1px;">'+ doc[6]+'</span></strong>'
	var i,j;
	for(j=1;j<=d1.getDay();j++){
    	content += '<td class="p_td_content">&nbsp;</td>';
	}
	document.getElementById("tijiao").style.display='block';
	document.getElementById("tishi").style.display='none';
		
			
	for(i=0;i<p.length;i++){
		if(p[i]<=0){
			content += '<td class="p_td_content" title="满房"><span class="cheng"><strong>×</strong></span></td>';
			document.getElementById("tijiao").style.display='none';
			document.getElementById("tishi").style.display='block';
		}
		else{
	    	content += '<td class="p_td_content"><span>'+p[i]+'</span>  '+(z[i]==0?"无早":z[i]==1?"单早":z[i]==2?"双早":z[i]==3?"三早":z[i]==4?"四早":z[i]==5?"五早":z[i]==6?"六早":"")+'<br><font color=#999999>'+date_str[i]+'</font></td>';
		}
		if((i+j)%7==0){
			content += '</tr><tr>';
		}/**/
	}
	if((i+j-1)%7!=0){
		for(var k=(i+j-1)%7;k<7;k++){
			content += '<td class="p_td_content">&nbsp;</td>';
		}
	}
	//alert(i+j);
  	content += '</tr>';
	content += '</table>';
	$(Obj).innerHTML = content;
	$(Obj).style.display = 'block';
	$(Obj2).innerHTML = day_all;
	//$(Obj2).style.display = 'block';
		$(Obj3).innerHTML = money_all;
	//$(Obj3).style.display = 'block';
	
}

//*********************************************************************************
getPrice_htm = function(Obj,Obj2,Obj3,Obj4,Obj5){
	
	var request = Ajax.getTransport();

	request.open("GET", "/hotel/hotel_price_htm.asp?d="+(new Date()).getTime(), false);
	request.send();
	var c = request.responseText;
	
	var doc = c.split("|");
	//alert(doc[0]);
	
	var content;
	content = '<table width="650" border="0" cellspacing="1" cellpadding="3" class="p_tb_title">';
	content += '<tr>';
	content += '<td class="p_td_title"><strong>星期日</strong></td>';
	content += '<td class="p_td_title"><strong>星期一</strong></td>';
	content += '<td class="p_td_title"><strong>星期二</strong></td>';
	content += '<td class="p_td_title"><strong>星期三</strong></td>';
	content += '<td class="p_td_title"><strong>星期四</strong></td>';
	content += '<td class="p_td_title"><strong>星期五</strong></td>';
	content += '<td class="p_td_title"><strong>星期六</strong></td>';
	content += '</tr>';
	content += '<tr>';
	
	var t1 = doc[0].split("-");
	var t2 = doc[1].split("-");
	var d1 = new Date(t1[0], parseInt(t1[1])-1, t1[2]);
	var d2 = new Date(t2[0], parseInt(t2[1])-1, t2[2]);
	var p = doc[2].split(" ");
	var z = doc[3].split(" ");
	var date_str = doc[4].split(" ");
	var day_all = doc[5]
	var money_all = '<span style="font-size:14px;font-family:sans-serif;letter-spacing:1px;">'+doc[6];
	var i,j;
	for(j=1;j<=d1.getDay();j++){
    	content += '<td class="p_td_content">&nbsp;</td>';
	}
	for(i=0;i<p.length;i++){
		if(p[i]<=0){
			content += '<td class="p_td_content" title="无房">×</td>';
		}
		else{
	    	content += '<td class="p_td_content"><span>'+p[i]+'</span>  '+(z[i]==0?"无早":z[i]==1?"单早":z[i]==2?"双早":z[i]==3?"三早":z[i]==4?"四早":z[i]==5?"五早":z[i]==6?"六早":"")+'<br><font color=#999999>'+date_str[i]+'</font></td>';
		}
		if((i+j)%7==0){
			content += '</tr><tr>';
		}/**/
	}
	if((i+j-1)%7!=0){
		for(var k=(i+j-1)%7;k<7;k++){
			content += '<td class="p_td_content">&nbsp;</td>';
		}
	}
	//alert(i+j);
  	content += '</tr>';
	content += '</table>';
	$(Obj).innerHTML = content;
	$(Obj).style.display = 'block';
	$(Obj2).innerHTML = day_all;
	//$(Obj2).style.display = 'block';
		$(Obj3).innerHTML = money_all;
	//$(Obj3).style.display = 'block';
	
	$(Obj4).innerHTML = doc[0];
	$(Obj5).innerHTML = doc[1];
	
}


//后台订单*****************************************************************************

getPrice_order = function(_inTime, _outTime, _roomId,Obj,Obj2,Obj3,Obj4,Obj5,order_id,fill_id,goback,roomnum){
//prompt("请输入名字：","/hotel/hotel_price_order.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&order_id="+order_id+"&d="+(new Date()).getTime());   
	var request = Ajax.getTransport();

		request.open("GET", "/hotel/hotel_price_order.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&order_id="+order_id+"&d="+(new Date()).getTime(), false);
	request.send();
	var c = request.responseText;
		
	var doc = c.split("|");
	//alert(doc[0]);
	
	var content;
	content = '<table  width="650" border="0" cellspacing="1" cellpadding="3" class="p_tb_title">';
	content += '<tr>';
	content += '<td class="p_td_title"><strong>星期日</strong></td>';
	content += '<td class="p_td_title"><strong>星期一</strong></td>';
	content += '<td class="p_td_title"><strong>星期二</strong></td>';
	content += '<td class="p_td_title"><strong>星期三</strong></td>';
	content += '<td class="p_td_title"><strong>星期四</strong></td>';
	content += '<td class="p_td_title"><strong>星期五</strong></td>';
	content += '<td class="p_td_title"><strong>星期六</strong></td>';
	content += '</tr>';
	content += '<tr >';
	
	var t1 = doc[0].split("-");
	var t2 = doc[1].split("-");
	var d1 = new Date(t1[0], parseInt(t1[1])-1, t1[2]);
	var d2 = new Date(t2[0], parseInt(t2[1])-1, t2[2]);
	var p = doc[2].split(" ");
	var z = doc[3].split(" ");
	var date_str = doc[4].split(" ");
	var day_all = doc[5]
	var money_all = doc[6]
	var pInside = doc[7].split(" ");
	var order_price = doc[8].split(" ");
	var order_lprice = doc[9].split(" ");
	var order_zaocan = doc[10].split(" ");
	var i,j,price2,lprice2,zaocan2;
	for(j=1;j<=d1.getDay();j++){
    	content += '<td class="p_td_content">&nbsp;</td>';
	}
	money_all=0;
	
	
	for(i=0;i<p.length;i++){
		
		if(p[i]<=0 && (order_price[i]==0 || order_price[i]==null)){
			content += '<td class="p_td_content" title="无房">×</td>';
		}
		else{
		//	if (typeof(order_price[i])=="undefined") )
		
		if (order_price[i]!=0 && i<order_price.length)
		      {
			   price2=order_price[i];
			   lprice2=order_lprice[i];
			   zaocan2=order_zaocan[i];
			  }
			  else
			  {price2=p[i];
			   lprice2=pInside[i];
			   zaocan2=z[i];
			  }
			  
	
			
			  
			  money_all=parseFloat(money_all)+parseFloat(price2)
			  
			  //根据供应商号设置底价
			  
			//alert(fill_id)
			if (fill_id==10)
			{lprice2=price2-25;}
			
				if (fill_id==9)
			{lprice2=Math.round(price2*0.92);}
			
			
					if (fill_id==17)
			{lprice2=Math.round(price2*0.94);
			    if (price2>600)
				{lprice2=price2-36;}
			
			}
			
				if (fill_id==51)
			{lprice2=Math.round(price2*0.9);
			  if (price2<250 && price2>0)
			    { lprice2=price2-25;  }
		    			}
				
				
			if (fill_id==52)
			{lprice2=Math.round(price2*0.9);}
			
			//取已录入的底价
				if (order_lprice[i]!=0 && i<order_price.length && goback==0)
				 {lprice2=order_lprice[i];}
				
	    	content += '<td class="p_td_content_left"><font color=red>'+date_str[i]+'</font><br><span>卖价：<input maxlength=4 type=text name=pp'+ i +' value='+price2+' size=4></span>  <br>早餐：<input type=text name=zz'+ i +' value='+zaocan2+' size=1 maxlength=1><br>'+'<font color=#999999>底价：</font><input type=text name=lp'+ i +' value='+lprice2+' size=4 maxlength=4></td>';
		}
		if((i+j)%7==0){
			content += '</tr><tr>';
		}/**/
	}
	if((i+j-1)%7!=0){
		for(var k=(i+j-1)%7;k<7;k++){
			content += '<td class="p_td_content">&nbsp;</td>';
		}
	}
	//alert(i+j);
  	content += '</tr>';
	content += '</table>';
	$(Obj).innerHTML = content;
	$(Obj).style.display = 'block';
	$(Obj2).innerHTML = day_all;
	//$(Obj2).style.display = 'block';
		$(Obj3).innerHTML = money_all*roomnum;
	//$(Obj3).style.display = 'block';
	
	$(Obj4).innerHTML = doc[0];
	$(Obj5).innerHTML = doc[1];
	
}

//前台会员
//member_no
getPrice_member = function(_inTime, _outTime, _roomId,Obj,Obj2,Obj3,Obj4,Obj5,order_id){
//prompt("请输入名字：","/hotel/hotel_price_order.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&order_id="+order_id+"&d="+(new Date()).getTime());   
	var request = Ajax.getTransport();

		request.open("GET", "/hotel/hotel_price_order.asp?intime="+_inTime+"&outtime="+_outTime+"&roomid="+_roomId+"&order_id="+order_id+"&d="+(new Date()).getTime(), false);
	request.send();
	var c = request.responseText;
		
	var doc = c.split("|");
	//alert(doc[0]);
	
	var content;
	content = '<table  width="450" border="0" cellspacing="1" cellpadding="3" class="p_tb_title">';
	content += '<tr>';
	content += '<td class="p_td_title"><strong>星期日</strong></td>';
	content += '<td class="p_td_title"><strong>星期一</strong></td>';
	content += '<td class="p_td_title"><strong>星期二</strong></td>';
	content += '<td class="p_td_title"><strong>星期三</strong></td>';
	content += '<td class="p_td_title"><strong>星期四</strong></td>';
	content += '<td class="p_td_title"><strong>星期五</strong></td>';
	content += '<td class="p_td_title"><strong>星期六</strong></td>';
	content += '</tr>';
	content += '<tr >';
	
	var t1 = doc[0].split("-");
	var t2 = doc[1].split("-");
	var d1 = new Date(t1[0], parseInt(t1[1])-1, t1[2]);
	var d2 = new Date(t2[0], parseInt(t2[1])-1, t2[2]);
	var p = doc[2].split(" ");
	var z = doc[3].split(" ");
	var date_str = doc[4].split(" ");
	var day_all = doc[5]
	var money_all = doc[6]
	var pInside = doc[7].split(" ");
	var order_price = doc[8].split(" ");
	var order_lprice = doc[9].split(" ");
	var order_zaocan = doc[10].split(" ");
	var i,j,price2,lprice2,zaocan2;
	for(j=1;j<=d1.getDay();j++){
    	content += '<td class="p_td_content">&nbsp;</td>';
	}
	money_all=0;
	for(i=0;i<p.length;i++){
		if(p[i]<=0){
			content += '<td class="p_td_content" title="无房">×</td>';
		}
		else{
		//	if (typeof(order_price[i])=="undefined") )
			
		if (order_price[i]!=0 && i<order_price.length)
		      {
			   price2=order_price[i];
			   lprice2=order_lprice[i];
			   zaocan2=order_zaocan[i];
			  }
			  else
			  {price2=p[i];
			   lprice2=pInside[i];
			   zaocan2=z[i];
			  }
	
			  money_all=parseFloat(money_all)+parseFloat(price2)
			  
						
	    	content += '<td class="p_td_content_left"><font color=red>'+date_str[i]+'</font><br><span>价格：<span class=cheng>'+ price2 +'</font></span>  <br>早餐：'+ zaocan2 +' 份 <br></td>';
		}
		if((i+j)%7==0){
			content += '</tr><tr>';
		}/**/
	}
	if((i+j-1)%7!=0){
		for(var k=(i+j-1)%7;k<7;k++){
			content += '<td class="p_td_content">&nbsp;</td>';
		}
	}
	//alert(i+j);
  	content += '</tr>';
	content += '</table>';
	$(Obj).innerHTML = content;
	$(Obj).style.display = 'block';
	$(Obj2).innerHTML = day_all;
	//$(Obj2).style.display = 'block';
		$(Obj3).innerHTML = money_all;
	//$(Obj3).style.display = 'block';
	
	$(Obj4).innerHTML = doc[0];
	$(Obj5).innerHTML = doc[1];
	
}
