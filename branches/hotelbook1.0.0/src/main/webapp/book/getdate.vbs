Function bytes2BSTR(vIn) 
  strReturn = ""
   For iiii = 1 To LenB(vIn) 
    ThisCharCode = AscB(MidB(vIn,iiii,1)) 
    If ThisCharCode < &H80 Then 
      strReturn = strReturn & Chr(ThisCharCode) 
    Else 
      NextCharCode = AscB(MidB(vIn,iiii+1,1)) 
      strReturn = strReturn & Chr(CLng(ThisCharCode) * &H100 + CInt(NextCharCode)) 
      iiii = iiii + 1 
    End If 
  Next 
  bytes2BSTR = strReturn 
End Function 

Function viewSource2() 
dim XmlHttp 
set XmlHttp = CreateObject("Microsoft.XMLHTTP") 
XmlHttp.Open "GET", "/ajax/getselectdate.asp?datenow="& now(), false 
XmlHttp.setRequestHeader "Content-Type","text/XML" 
XmlHttp.Send 

dim html
html = split(bytes2BSTR(XmlHttp.responseBody),",")


document.form1.elements("intime").value=html(0)
document.form1.elements("outtime").value=html(1)
End Function 

viewSource2()