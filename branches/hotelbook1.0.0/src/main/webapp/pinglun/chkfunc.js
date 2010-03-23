function trimStr(Str)
{
	var Strings="";
	var i,j;
	if (Str.length==0)
		return (Strings);
	for (i=0;i<=Str.length-1;i++){
		if (Str.charAt(i)!=" ")
			break;
	}
	for (j=Str.length-1;j>=0;j--){
		if (Str.charAt(j)!=" ")
			break;
	}
	if (i>j)
		return (Strings);
	Strings=Str.substring(i,j+1);
	return (Strings);
}
function lenStr(str)
{
	var len=0;
	str=trimStr(str);
	for (var i=0;i<str.length;i++){
		if (str.charCodeAt(i)>255)
			len=len+2;
		else
			len++;
	}
	return (len);
}
function CheckInput(strBox,checkStr)
{
	var boxStr=strBox.length;
	for (var i=0;i<boxStr;i++){
		var str=strBox.charAt(i);
		for (var j=0;j<checkStr.length;j++){
			if (str==checkStr.charAt(j))
				break;}
		if (j==checkStr.length){
			return (false);
			break;}
	}
	return (true);
}
function CheckRange(strBox,num1,num2)
{
	if (num2==0){
		if (lenStr(strBox)>num1)
			return (false);
	}else{
		if (lenStr(strBox)<num1 || lenStr(strBox)>num2)
			return (false);
	}
	return (true);
}
function CheckEmail (strEmail)
{
    var reVal;
    strEmail = (OrtTrimString (strEmail));
    if (strEmail.length == 0)
        return (false);
    reVal = /^[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+@[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+(\.[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+)+$/;
    return (reVal.test (strEmail));
}
function OrtTrimString (strVal)
{
    var reVal;
    var strTmp;
    strTmp = strVal + "";
    if (strTmp.length == 0)
        return (strTmp);
    reVal = /^(\s|¡¡)*/;
    strTmp = strTmp.replace (reVal, '');
    reVal = /(\s|¡¡)*$/;
    return (strTmp.replace (reVal, ''));
}
function CheckDate (strDate)
{
    var nStart;
    var nEnd;
    var nYear;
    var nMonth;
    var nDay;
    var nFact;
    var arrDay = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    var reVal;
    strDate = (OrtTrimString (strDate));
    if (strDate.length == 0)
        return (false);
    reVal = /^([1-2]\d{3})[\/|\-](0?[1-9]|10|11|12)[\/|\-](0?[1-9]|1[0-9]|2[0-9]|30|31)$/;
    if (!reVal.test (strDate))
        return (false);
    if ((nStart = strDate.indexOf ("/", 0)) < 0)
    {
        if ((nStart = strDate.indexOf ("-", 0)) < 0)
            return (false);
        if ((nEnd = strDate.indexOf ("-", nStart + 1)) < 0)
            return (false);
    }
    else
    {
        if ((nEnd = strDate.indexOf ("/", nStart + 1)) < 0)
            return (false);
    }
    nYear = eval (strDate.substring (0, nStart));
    nMonth = eval (strDate.substring (nStart + 1, nEnd));
    nDay = eval (strDate.substring (nEnd + 1, strDate.length));
    nFact = arrDay[nMonth - 1];
    if (nMonth == 2)
    {
        if ((nYear % 4 == 0 && nYear %100 != 0) || (nYear % 400 == 0))
            nFact ++;
    };
    if (nDay > nFact)
        return (false);

    return (true);
}
function OrtCompareDate (strDate1, strDate2)
{
    var nStart1;
    var nEnd1;
    var nYear1;
    var nMonth1;
    var nDay1;
    var nStart2;
    var nEnd2;
    var nYear2;
    var nMonth2;
    var nDay2;
    strDate1 = (OrtTrimString (strDate1));
    strDate2 = (OrtTrimString (strDate2));
    if ((nStart1 = strDate1.indexOf ("/", 0)) < 0)
    {
        nStart1 = strDate1.indexOf ("-", 0);
        nEnd1 = strDate1.indexOf ("-", nStart1 + 1);
    }
    else
    {
        nEnd1 = strDate1.indexOf ("/", nStart1 + 1);
    }
    nYear1 = eval (strDate1.substring (0, nStart1));
    nMonth1 = eval (strDate1.substring (nStart1 + 1, nEnd1));
    nDay1 = eval (strDate1.substring (nEnd1 + 1, strDate1.length));
    if ((nStart2 = strDate2.indexOf ("/", 0)) < 0)
    {
        nStart2 = strDate2.indexOf ("-", 0);
        nEnd2 = strDate2.indexOf ("-", nStart2 + 1);
    }
    else
    {
        nEnd2 = strDate2.indexOf ("/", nStart2 + 1);
    }
    nYear2 = eval (strDate2.substring (0, nStart2));
    nMonth2 = eval (strDate2.substring (nStart2 + 1, nEnd2));
    nDay2 = eval (strDate2.substring (nEnd2 + 1, strDate2.length));
    if (nYear1 > nYear2)
        return (1);
    else if (nYear1 < nYear2)
        return (-1);
    else
    {
	    if (nMonth1 > nMonth2)
		    return (1);
		else if (nMonth1 < nMonth2)
		    return (-1);
		else
		{
		    if (nDay1 > nDay2)
		        return (1);
		    else if (nDay1 < nDay2)
		    	return (-1);
		    else
		    	return (0);
		};
	};
}
function Trimstring(strtrim)
{
	if (strtrim.length==0)
		return (false);
	for (var i=0;i<=strtrim.length-1;i++){
		if (strtrim.charAt(i)!=" ")
			break;
	}
	if (i==strtrim.length)
		return (false);
	return (true);
}