/*----ѡ�-----------*/
function setTab(name,cursel,n){
for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
      }
    }
	

/*----�ر���ҳ����-----------*/  
/*----��ҳĬ��ʱ������ƴ�����top��202px��ftm��top��220px��----------*/ 
function closeindexbg(id,citypinyin,ftm)
{
	body.className="";
    document.getElementById(id).style.display="none";
	document.getElementById(citypinyin).style.top="202px";
	document.getElementById(ftm).style.top="220px";
}