/*----选项卡-----------*/
function setTab(name,cursel,n){
for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
      }
    }
	

/*----关闭首页背景-----------*/  
/*----首页默认时参数：拼音框的top：202px；ftm框top：220px；----------*/ 
function closeindexbg(id,citypinyin,ftm)
{
	body.className="";
    document.getElementById(id).style.display="none";
	document.getElementById(citypinyin).style.top="202px";
	document.getElementById(ftm).style.top="220px";
}