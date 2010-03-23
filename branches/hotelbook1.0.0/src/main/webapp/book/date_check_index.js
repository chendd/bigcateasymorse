function setCheckInDate(d)
{
	document.getElementById("intime").value=d;
	//document.getElementById("outtime").value="";
	showCalendar('dimg2',false,'outtime','intime');
	
}
function setCheckInDate22(d)
{
	document.getElementById("intime").value=d;
	showCalendar('dimg2',false,'outtime','intime','repage');
	
}

function setCheckInDate11(d)
{
	document.getElementById("intime11").value=d;
	//document.getElementById("outtime11").value="";
	showCalendar('dimg22',false,'outtime11','intime11');
	
}

function check(frm)
{
if (lenStr(frm.hotel_name.value)==0 || frm.hotel_name.value=="如：喜来登" ){
	if (frm.intime.value=="" || frm.outtime.value==""){
		alert("日期不能为空!");
		return false;}
	if (!CheckDate(frm.intime.value) || !CheckDate(frm.outtime.value)){
		alert("日期格式不正确！");
		return false;}
		
	if (OrtCompareDate(frm.outtime.value,frm.intime.value)!=1){
		alert("离店日期不能早于入住日期！");
		return false;}
	}
	
	  if (frm.city_name.value=="" || frm.city_name.value=="中文/拼音" )
	  {
  	alert("请输入宾馆所在城市！例如：广州、Guangzhou或GZ。");
	return false;
  }
	
	
}


function check_details()
{
	return true;

if (document.form2.intime11.value=="" || document.form2.outtime11.value=="")
	{
		alert("日期不能为空!");
		return false;}
		
	
		
	


	
}




function check_details1(frm)
{

	if (!CheckDate(document.form2.intime11.value) || !CheckDate(document.form2.outtime11.value))
	{
		alert("日期格式不正确！");
		return false;}
	alert(document.form2.intime11.value)	
	//alert(frm.outtime11.value)
	
	
	if (OrtCompareDate(document.form2.outtime11.value,document.form2.intime11.value)!=1)
	{
		alert("离店日期不能早于入住日期！");
		return false;}
	
	

	
}


