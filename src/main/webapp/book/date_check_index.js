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
if (lenStr(frm.hotel_name.value)==0 || frm.hotel_name.value=="�磺ϲ����" ){
	if (frm.intime.value=="" || frm.outtime.value==""){
		alert("���ڲ���Ϊ��!");
		return false;}
	if (!CheckDate(frm.intime.value) || !CheckDate(frm.outtime.value)){
		alert("���ڸ�ʽ����ȷ��");
		return false;}
		
	if (OrtCompareDate(frm.outtime.value,frm.intime.value)!=1){
		alert("������ڲ���������ס���ڣ�");
		return false;}
	}
	
	  if (frm.city_name.value=="" || frm.city_name.value=="����/ƴ��" )
	  {
  	alert("������������ڳ��У����磺���ݡ�Guangzhou��GZ��");
	return false;
  }
	
	
}


function check_details()
{
	return true;

if (document.form2.intime11.value=="" || document.form2.outtime11.value=="")
	{
		alert("���ڲ���Ϊ��!");
		return false;}
		
	
		
	


	
}




function check_details1(frm)
{

	if (!CheckDate(document.form2.intime11.value) || !CheckDate(document.form2.outtime11.value))
	{
		alert("���ڸ�ʽ����ȷ��");
		return false;}
	alert(document.form2.intime11.value)	
	//alert(frm.outtime11.value)
	
	
	if (OrtCompareDate(document.form2.outtime11.value,document.form2.intime11.value)!=1)
	{
		alert("������ڲ���������ס���ڣ�");
		return false;}
	
	

	
}


