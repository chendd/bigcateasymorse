<!--简单搜索----显示更多搜索条件------start--->
			function Special(sp)
			{
				if (sp)
				{
					document.getElementById("more").style.display = "none";
					document.getElementById("simple").style.display = "block";
/*					document.getElementById("txtDetailCdt").value="1";*/
				}
				else
				{
					document.getElementById("more").style.display = "block";
					document.getElementById("simple").style.display = "none";
/*					document.getElementById("txtDetailCdt").value="";*/
				}
			}
			
			
						
			function morelist(list)
			{
				if (list==1)
				{   document.getElementById("btn1").style.display = "none";
					document.getElementById("btn2").style.display = "block";
					document.getElementById("teshutxt").style.display = "block";

				}
				else if(list==2)
				{
					document.getElementById("btn1").style.display = "block";
					document.getElementById("btn2").style.display = "none";
					document.getElementById("teshutxt").style.display = "none";
				}
			}
			
			
<!--简单搜索----显示更多搜索条件------End--->

/*----选项卡-----------*/
function setTab(name,cursel,n){
for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
      }
    }