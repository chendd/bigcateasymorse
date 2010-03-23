// JavaScript Document
//为了各浏览器的兼�?对所有涉及浏览器问题的一些函数方法进行判�?
//对对象增加事�?

var xGecko,xNN4,xOp7,xOp5or6,xIE4Up,xIE4,xIE5,xMac,xSafari
var xUA=navigator.userAgent.toLowerCase();
if (window.opera){
  	xOp7=(xUA.indexOf('opera 7')!=-1 || xUA.indexOf('opera/7')!=-1);
  	if (!xOp7) xOp5or6=(xUA.indexOf('opera 5')!=-1 || xUA.indexOf('opera/5')!=-1 || xUA.indexOf('opera 6')!=-1 || xUA.indexOf('opera/6')!=-1);
}
else if (document.all && xUA.indexOf('msie')!=-1) {
	xIE4Up=parseInt(navigator.appVersion)>=4;
	xIE4=xUA.indexOf('msie 4')!=-1;
	xIE5=xUA.indexOf('msie 5')!=-1;
}
else if (document.layers) {
	xNN4=true;
}
else if (navigator.product != null && navigator.product.toLowerCase() == 'gecko')
        xGecko=true;
xMac=xUA.indexOf('mac')!=-1;
xSafari=xUA.indexOf('safari')!=-1;
// Safari claims its Gecko
if (xGecko && xSafari)
    xGecko = false;

function xGetElementById(e) {
	if(typeof(e)!='string') return e;
	if(document.getElementById) e=document.getElementById(e);
	else if(document.all) e=document.all[e];
	else e=null;
	return e;
}

function xParent(e,bNode){
	if (!(e=xGetElementById(e))) return null;
	var p=null;
	if (!bNode && xDef(e.offsetParent)) p=e.offsetParent;
	else if (xDef(e.parentNode)) p=e.parentNode;
	else if (xDef(e.parentElement)) p=e.parentElement;
	return p;
}
function xDef() {
	for(var i=0; i<arguments.length; ++i){
		if(typeof(arguments[i])=='undefined') return false;
	}
	return true;
}
function xStr(s) {
	for(var i=0; i<arguments.length; ++i){
	  if(typeof(arguments[i])!='string') 
	  return false;
	}
	return true;
}
function xNum(n) {
	for(var i=0; i<arguments.length; ++i){
		if(typeof(arguments[i])!='number') return false;
	}
	return true;
}
function xShow(e) {
	if(!(e=xGetElementById(e))) return;
	if(e.style && xDef(e.style.visibility)) e.style.visibility='visible';
}
function xHide(e) {
	if(!(e=xGetElementById(e))) return;
	if(e.style && xDef(e.style.visibility)) e.style.visibility='hidden';
}
function xIsVisible(e) {
        if(!(e=xGetElementById(e))) return;
        // if no style object just return true
        if(!e.style || !xDef(e.style.visibility))
                return true;
        return (e.style.visibility == "visible");
}
function xZIndex(e,uZ) {
	if(!(e=xGetElementById(e))) return 0;
	if(e.style && xDef(e.style.zIndex)) {
	if(xNum(uZ)) e.style.zIndex=uZ;
		uZ=parseInt(e.style.zIndex);
	}
	return uZ;
}
function xColor(e,sColor) {
	if(!(e=xGetElementById(e))) return '';
	var c='';
	if(e.style && xDef(e.style.color)) {
	if(xStr(sColor)) e.style.color=sColor;
		c=e.style.color;
	}
	return c;
}
function xBackground(e,sColor,sImage) {
	if(!(e=xGetElementById(e))) return '';
	var bg='';
	if(e.style) {
		if(xStr(sColor)) {
			if(!xOp5or6) e.style.backgroundColor=sColor;
			else e.style.background=sColor;
		}
		if(xStr(sImage)) e.style.backgroundImage=(sImage!='')? 'url('+sImage+')' : null;
		if(!xOp5or6) bg=e.style.backgroundColor;
		else bg=e.style.background;
	}
	return bg;
}
function xMoveTo(e,iX,iY) {
  xLeft(e,iX);
  xTop(e,iY);
}
function xLeft(e,iX) {
	if(!(e=xGetElementById(e))) return 0;
	var css=xDef(e.style);
	if (css && xStr(e.style.left)) {
		if(xNum(iX)) e.style.left=iX+'px';
	else {
	  iX=parseInt(e.style.left);
	  if(isNaN(iX)) iX=0;
	}
	}
	else if(css && xDef(e.style.pixelLeft)) {
		if(xNum(iX)) e.style.pixelLeft=iX;
		else iX=e.style.pixelLeft;
	}
	return iX;
}
function xTop(e,iY) {
	if(!(e=xGetElementById(e))) return 0;
	var css=xDef(e.style);
	if(css && xStr(e.style.top)) {
		if(xNum(iY)) e.style.top=iY+'px';
		else {
		  iY=parseInt(e.style.top);
		  if(isNaN(iY)) iY=0;
		}
	}
	else if(css && xDef(e.style.pixelTop)) {
		if(xNum(iY)) e.style.pixelTop=iY;
		else iY=e.style.pixelTop;
	}
	return iY;
}

function xPageX(e) {
  if (!(e=xGetElementById(e))) return 0;
  var x = 0;
  while (e) {
    if (xDef(e.offsetLeft)) x += e.offsetLeft;
    e = xDef(e.offsetParent) ? e.offsetParent : null;
  }
  return x;
}
function xPageY(e) {
	if (!(e=xGetElementById(e))) return 0;
	var y = 0;
	while (e) {
		if (xDef(e.offsetTop)) y += e.offsetTop;
		e = xDef(e.offsetParent) ? e.offsetParent : null;
	}
	//  if (xOp7) return y - document.body.offsetTop; 
	// v3.14, temporary hack for opera bug 130324
	return y;
}

function xOffsetLeft(e) {
  if (!(e=xGetElementById(e))) return 0;
  if (xDef(e.offsetLeft)) return e.offsetLeft;
  else return 0;
}
function xOffsetTop(e) {
  if (!(e=xGetElementById(e))) return 0;
  if (xDef(e.offsetTop)) return e.offsetTop;
  else return 0;
}
//FIXME: Test More
function xOffsetWidth(e, includePaddingBorder) {
	if(!(e=xGetElementById(e))) return 0;
	if (xDef(includePaddingBorder) == false)
			includePaddingBorder = true;

	var width = e.offsetWidth;
	if (xDef(document.compatMode)) {
		if ((document.compatMode == "BackCompat" && xIE4Up)	|| xIE4 || xIE5) {
		// these browsers leave out the padding, which is incorrect
			var padding = xToPixelInt(xGetComputedStyle(e, "padding-left")) +
						xToPixelInt(xGetComputedStyle(e, "padding-right"));
			width = width + padding;
		}
	}
    if (!includePaddingBorder) {
         // calculate the padding and border and subtract it
         var padding = xToPixelInt(xGetComputedStyle(e, "padding-left")) +
                       xToPixelInt(xGetComputedStyle(e, "padding-right"));
         var border = xToPixelInt(xGetComputedStyle(e, "border-left-width")) +
                      xToPixelInt(xGetComputedStyle(e, "border-right-width"));

         width = width - padding - border;
    }
    return width;
}
//FIXME: Test More
function xOffsetHeight(e, includePaddingBorder) {
	if(!(e=xGetElementById(e))) return 0;
	if (xDef(includePaddingBorder) == false)
			includePaddingBorder = true;

	var height = e.offsetHeight;
	if (xDef(document.compatMode)) {
		if ((document.compatMode == "BackCompat" && xIE4Up)	|| xIE4 || xIE5) {
		// these browsers leave out the padding, which is incorrect
			var padding = xToPixelInt(xGetComputedStyle(e, "padding-top")) +
						  xToPixelInt(xGetComputedStyle(e, "padding-bottom"));
			height = height + padding;
		}
	}
	if (!includePaddingBorder) {
			// calculate the padding and border and subtract it
		var padding = xToPixelInt(xGetComputedStyle(e, "padding-top")) +
					  xToPixelInt(xGetComputedStyle(e, "padding-bottom"));
		var border = xToPixelInt(xGetComputedStyle(e, "border-top-width")) +
					 xToPixelInt(xGetComputedStyle(e, "border-bottom-width"));
		height = height - padding - border;
	}
	return height;
}
function xScrollLeft(e) {
	var offset=0;
	if (!(e=xGetElementById(e))) {
		if(document.documentElement && document.documentElement.scrollLeft) 
			offset=document.documentElement.scrollLeft;
		else if(document.body && xDef(document.body.scrollLeft)) 
			offset=document.body.scrollLeft;
	}
	else { 
		if (xNum(e.scrollLeft)) offset = e.scrollLeft; 
	}
	return offset;
}
function xScrollTop(e) {
	var offset=0;
	if (!(e=xGetElementById(e))) {
		if(document.documentElement && document.documentElement.scrollTop) 
			offset=document.documentElement.scrollTop;
		else if(document.body && xDef(document.body.scrollTop)) 
			offset=document.body.scrollTop;
	}
	else { 
		if (xNum(e.scrollTop)) offset = e.scrollTop; 
	}
	return offset;
}
function xHasPoint(ele, iLeft, iTop, iClpT, iClpR, iClpB, iClpL) {
	if (!xNum(iClpT)){iClpT=iClpR=iClpB=iClpL=0;}
	else if (!xNum(iClpR)){iClpR=iClpB=iClpL=iClpT;}
	else if (!xNum(iClpB)){iClpL=iClpR; iClpB=iClpT;}
	var thisX = xPageX(ele), thisY = xPageY(ele);
	return (iLeft >= thisX + iClpL && iLeft <= thisX + xWidth(ele) - iClpR &&
		  iTop >=thisY + iClpT && iTop <= thisY + xHeight(ele) - iClpB );
}
function xResizeTo(e,uW,uH) {
	xWidth(e,uW);
	xHeight(e,uH);
}
function xWidth(e,uW) {
	if(!(e=xGetElementById(e))) return 0;
	if (xNum(uW)) {
		if (uW<0) uW = 0;
		else uW=Math.round(uW);
	}
	else uW=-1;
	var css=xDef(e.style);
	if(css && xDef(e.offsetWidth) && xStr(e.style.width)) {
		if(uW>=0) xSetCW(e, uW);
		uW=e.offsetWidth;
	}
	else if(css && xDef(e.style.pixelWidth)) {
		if(uW>=0) e.style.pixelWidth=uW;
		uW=e.style.pixelWidth;
	}
	return uW;
}
function xHeight(e,uH) {
	if(!(e=xGetElementById(e))) return 0;
	if (xNum(uH)) {
		if (uH<0) uH = 0;
		else uH=Math.round(uH);
	}
	else uH=-1;
	var css=xDef(e.style);
	if(css && xDef(e.offsetHeight) && xStr(e.style.height)) {
		if(uH>=0) xSetCH(e, uH);
		uH=e.offsetHeight;
	}
	else if(css && xDef(e.style.pixelHeight)) {
		if(uH>=0) e.style.pixelHeight=uH;
		uH=e.style.pixelHeight;
	}
	return uH;
}
function xGetCS(ele,sP){
    return document.defaultView.getComputedStyle(ele,'').getPropertyValue(sP);
}
function xSetCW(ele,uW){
	var pl=0,pr=0,bl=0,br=0;
	if(xDef(document.defaultView) && xDef(document.defaultView.getComputedStyle)){
		pl=xGetCS(ele,'padding-left');
		pr=xGetCS(ele,'padding-right');
		bl=xGetCS(ele,'border-left-width');
		br=xGetCS(ele,'border-right-width');
	}
	else if(xDef(ele.currentStyle,document.compatMode)){
		if(document.compatMode=='CSS1Compat'){
			pl=parseInt(ele.currentStyle.paddingLeft);
			pr=parseInt(ele.currentStyle.paddingRight);
			bl=parseInt(ele.currentStyle.borderLeftWidth);
			br=parseInt(ele.currentStyle.borderRightWidth);
		}
	}
	else if(xDef(ele.offsetWidth,ele.style.width)){ // ?
		ele.style.width=uW+'px';
		pl=ele.offsetWidth-uW;
	}
	if(isNaN(pl)) pl=0; if(isNaN(pr)) pr=0; if(isNaN(bl)) bl=0; if(isNaN(br)) br=0;
	var cssW=uW-(pl+pr+bl+br);
	if(isNaN(cssW)||cssW<0) return;
	else ele.style.width=cssW+'px';
}
function xSetCH(ele,uH){
	var pt=0,pb=0,bt=0,bb=0;
	if(xDef(document.defaultView) && xDef(document.defaultView.getComputedStyle)){
		pt=xGetCS(ele,'padding-top');
		pb=xGetCS(ele,'padding-bottom');
		bt=xGetCS(ele,'border-top-width');
		bb=xGetCS(ele,'border-bottom-width');
	}
	else if(xDef(ele.currentStyle,document.compatMode)){
	if(document.compatMode=='CSS1Compat'){
		pt=parseInt(ele.currentStyle.paddingTop);
		pb=parseInt(ele.currentStyle.paddingBottom);
		bt=parseInt(ele.currentStyle.borderTopWidth);
		bb=parseInt(ele.currentStyle.borderBottomWidth);
	}
	}
	else if(xDef(ele.offsetHeight,ele.style.height)){ // ?
		ele.style.height=uH+'px';
		pt=ele.offsetHeight-uH;
	}
	if(isNaN(pt)) pt=0; 
	if(isNaN(pb)) pb=0; 
	if(isNaN(bt)) bt=0; 
	if(isNaN(bb)) bb=0;
	var cssH=uH-(pt+pb+bt+bb);
	if(isNaN(cssH)||cssH<0) return;
	else ele.style.height=cssH+'px';
}
function xClip(e,iTop,iRight,iBottom,iLeft) {
	if(!(e=xGetElementById(e))) return;
	if(e.style) {
		if (xNum(iLeft)) e.style.clip='rect('+iTop+'px '+iRight+'px '+iBottom+'px '+iLeft+'px)';
		else e.style.clip='rect(0 '+parseInt(e.style.width)+'px '+parseInt(e.style.height)+'px 0)';
	}
}
function xClientWidth() {
	var w=0;
	if(xOp5or6) 
		w=window.innerWidth;
	else if(!window.opera && document.documentElement && document.documentElement.clientWidth)
		w=document.documentElement.clientWidth;
	else if(document.body && document.body.clientWidth)
		w=document.body.clientWidth;
	else if(xDef(window.innerWidth,window.innerHeight,document.height)) {
		w=window.innerWidth;
		if(document.height>window.innerHeight) w-=16;
	}
	return w;
}
function xClientHeight() {
	var h=0;
	if(xOp5or6) h=window.innerHeight;
	else if(!window.opera && document.documentElement && document.documentElement.clientHeight)
		h=document.documentElement.clientHeight;
	else if(document.body && document.body.clientHeight)
		h=document.body.clientHeight;
	else if(xDef(window.innerWidth,window.innerHeight,document.width)) {
		h=window.innerHeight;
		if(document.width>window.innerWidth) h-=16;
	}
	return h;
}
function xInnerHtml(e, sHtml) {
  if(!(e=xGetElementById(e))) return '';
  if (xStr(e.innerHTML)) {
    if (xStr(sHtml)) e.innerHTML = sHtml;
    else return e.innerHTML;
  }
}

function xToPixelInt(value) {
	if (xDef(value) == false)
			return null;

	if (xNum(value))
			return value;

	var matches = value.match(/\D*(\d*)\D*/);

	if (matches.length > 1)
			return parseInt(matches[1]);
	else
			return null;
}

function xToPixelString(value) {
	if (xNum(value))
		return parseInt(value) + "px";
	else {
		if (xStr(value)) {
			var matches = value.match(/^(\d*)px$/);
			if (matches.length > 1) {
				return parseInt(matches[1]);
			}
		}
	}

	return null;
}
function xTrim(s) {
    if (!xDef(s) || s == null)
        return s;

    // Remove leading spaces and carriage returns
    while (s.substring(0, 1) == ' ' || s.substring(0, 1) == '\n' ||
           s.substring(0, 1) == '\r') {
        s = s.substring(1, s.length);
    }

    // Remove trailing spaces and carriage returns
    while (s.substring(s.length-1, s.length) == ' ' ||
           s.substring(s.length-1, s.length) == '\n' ||
           s.substring(s.length-1, s.length) == '\r') {
        s = s.substring(0, s.length-1);
    }

    return s;
}

function xAddEventListener(e,eventType,eventListener,useCapture) {
  	if(!(e=xGetElementById(e))) return;
  	eventType=eventType.toLowerCase();
  	if((!xIE4Up && !xOp7) && e==window) {
    	if(eventType=='resize') { 
			window.xPCW=xClientWidth(); 
			window.xPCH=xClientHeight(); 
			window.xREL=eventListener; 
			xResizeEvent(); 
			return; 
		}
    	if(eventType=='scroll') { 
			window.xPSL=xScrollLeft(); 
			window.xPST=xScrollTop(); 
			window.xSEL=eventListener; 
			xScrollEvent(); 
			return; 
		}
  	}
  	var eh='e.on'+eventType+'=eventListener';
  //判断浏览器决定执行哪�?
  	if(e.addEventListener) e.addEventListener(eventType,eventListener,useCapture);
  	else if(e.attachEvent) e.attachEvent('on'+eventType,eventListener);
  	else eval(eh);
}
//移除对象所拥有的监�?
function xRemoveEventListener(e,eventType,eventListener,useCapture) {
	if(!(e=xGetElementById(e))) return;
	eventType=eventType.toLowerCase();
	if((!xIE4Up && !xOp7) && e==window) {
		if(eventType=='resize') { 
			window.xREL=null; 
			return; 
		}
		if(eventType=='scroll') { 
			window.xSEL=null; return; 
		}
	}
	var eh='e.on'+eventType+'=null';
	if(e.removeEventListener) e.removeEventListener(eventType,eventListener,useCapture);
	else if(e.detachEvent) e.detachEvent('on'+eventType,eventListener);
	else eval(eh);
}
//获取鼠标点击对象信息
function xEvent(evt) {
	this.type = ''; 
	this.target = null;
	this.pageX = 0; 
	this.pageY = 0;
	this.offsetX = 0; 
	this.offsetY = 0;
	this.keyCode = 0;
	var e = evt || window.event;
	if(!e) return;
	this.event = e;
	if(e.type) this.type = e.type;
	if(e.target) this.target = e.target;
	else if(e.srcElement) this.target = e.srcElement;
  	if(xOp5or6) { 
  		this.pageX = e.clientX; 
		this.pageY = e.clientY; 
	}
  	else if(xDef(e.clientX,e.clientY)) { 
		this.pageX = e.clientX + xScrollLeft(); 
		this.pageY = e.clientY + xScrollTop(); 
	}

	if (!window.eventDebugMode) {//
  		if(xDef(e.offsetX,e.offsetY)) {
			this.offsetX = e.offsetX;
			this.offsetY = e.offsetY;
			if (xIE4Up && xMac) {
			  //window.status = 'ie mac';///////////////
			  this.offsetX += xScrollLeft();
			  this.offsetY += xScrollTop();
			}
  		}
  		else {
			this.offsetX = this.pageX - xPageX(this.target);
			this.offsetY = this.pageY - xPageY(this.target);
  		}
	} else if (window.eventDebugMode == 1) {//
		if(xDef(e.offsetX,e.offsetY) && !(xIE4Up && xMac)) {
			this.offsetX = e.offsetX;
			this.offsetY = e.offsetY;
		}
		else {
			this.offsetX = this.pageX - xPageX(this.target);
			this.offsetY = this.pageY - xPageY(this.target);
		}
	}// end eventDebugMode

  	if (e.keyCode) { 
		this.keyCode = e.keyCode; 
	} // for moz/fb, if keyCode==0 use which
  	else if (xDef(e.which)) { 
		this.keyCode = e.which; 
	}
}
//对对象执行的取消
xEvent.prototype.cancel = function() {
	this.event.cancelBubble = true;
  this.event.returnValue = false;
  
  if (window.event && window.event.cancelBubble)
    window.event.cancelBubble = true;
    
  if (window.event && window.event.returnValue)
    window.event.returnValue = false;

  if (this.event.preventDefault)
    this.event.preventDefault();
    
  if (this.event.stopPropagation)
    this.event.stopPropagation();
                
  return false;
}

function xResizeEvent() {
	if (window.xREL) setTimeout('xResizeEvent()', 250);
	var cw = xClientWidth(), ch = xClientHeight();
	if (window.xPCW != cw || window.xPCH != ch) { 
		window.xPCW = cw; 
		window.xPCH = ch; 
		if (window.xREL) window.xREL(); 
	}
}

function xScrollEvent() {
	if (window.xSEL) setTimeout('xScrollEvent()', 250);
	var sl = xScrollLeft(), st = xScrollTop();
	if (window.xPSL != sl || window.xPST != st) {
		window.xPSL = sl; window.xPST = st; 
		if (window.xSEL) window.xSEL(); 
	}
}


if (Node == null || Node == undefined) {
	var Node = new Object();
		
    Node.ELEMENT_NODE                   = 1;
    Node.ATTRIBUTE_NODE                 = 2;
    Node.TEXT_NODE                      = 3;
    Node.CDATA_SECTION_NODE             = 4;
    Node.ENTITY_REFERENCE_NODE          = 5;
    Node.ENTITY_NODE                    = 6;
    Node.PROCESSING_INSTRUCTION_NODE    = 7;
    Node.COMMENT_NODE                   = 8;
    Node.DOCUMENT_NODE                  = 9;
    Node.DOCUMENT_TYPE_NODE             = 10;
    Node.DOCUMENT_FRAGMENT_NODE         = 11;
    Node.NOTATION_NODE                  = 12;
}

function xWalkTree(oNode, fnVisit){
  if (oNode) {
    if (oNode.nodeType == 1) {fnVisit(oNode);}
    for (var c = oNode.firstChild; c; c = c.nextSibling) {
      xWalkTree(c, fnVisit);
    }
  }
}

function xGetComputedStyle(oEle, sProp){
	var p = 0;
	if(document.defaultView && document.defaultView.getComputedStyle){
		p = document.defaultView.getComputedStyle(oEle,'').getPropertyValue(sProp)
	}
	else if(oEle.currentStyle) {
		// convert css property name to object property name for IE
		var a = sProp.split('-');
		sProp = a[0];
		for (var i=1; i<a.length; ++i) {
		  c = a[i].charAt(0);
		  sProp += a[i].replace(c, c.toUpperCase());
		}
		p = oEle.currentStyle[sProp];
	}
	return parseInt(p) || 0;
}
function xGetElementsByClassName(clsName, parentEle, tagName, fn){
	var found = new Array();
	var re = new RegExp('\\b'+clsName+'\\b', 'i');
	var list = xGetElementsByTagName(tagName, parentEle);
	for (var i = 0; i < list.length; ++i) {
	if (list[i].className.search(re) != -1) {
	  found[found.length] = list[i];
	  if (fn) fn(list[i]);
	}
	}
	return found;
}
/** Walks this elements parent hierarchy until it comes to one that has
    the given class name.  It returns the one parent element that has this
    name.
  */
xGetParentElementByClassName = function(target, className) {
    var tg = target;
    while (tg && xHasClassName(tg, className) == false) {
        tg = tg.parentNode;
    }

    return tg;
}
/** Gets just the first element that has the given class name.  If no element
    with that name exists then null is returned.
  */
xGetSingleElementByClassName = function(target, className, tagName) {
    var results = xGetElementsByClassName(className, target, tagName);
    if (results == null || results.length == 0) {
        return null;
    }
    else {
        return results[0];
    }
}
function xGetElementsByTagName(tagName, parentEle){
  var list = null;
  tagName = tagName || '*';
  parentEle = parentEle || document;
  if (xIE4 || xIE5) {
    if (tagName == '*') list = parentEle.all;
    else list = parentEle.all.tags(tagName);
  }
  else if (parentEle.getElementsByTagName) list = parentEle.getElementsByTagName(tagName);
  return list || new Array();
}
function xGetElementsByAttribute(sTag, sAtt, sRE, fn) {
	var a, list, found = new Array(), re = new RegExp(sRE, 'i');
	list = xGetElementsByTagName(sTag);
	for (var i = 0; i < list.length; ++i) {
		a = list[i].getAttribute(sAtt);
		if (!a) {a = list[i][sAtt];}
		if (typeof(a)=='string' && a.search(re) != -1) {
		  found[found.length] = list[i];
		  if (fn) fn(list[i]);
		}
	}
	return found;
}

function xCreateElement(sTag) {
  if (document.createElement) return document.createElement(sTag);
  else return null;
}

function xAppendChild(oParent, oChild) {
  if (oParent.appendChild) return oParent.appendChild(oChild);
  else return null;
}

function xRemoveNode(oParent, oNode) {
  return oParent.removeChild(oNode);
}

function xAjaxGetContent(xUrl,xMethod,xPara){
	var request = Ajax.getTransport();
	request.open("GET", xUrl, false);
	request.send(null);
	return request.responseText;
}

if( document.implementation.hasFeature("XPath", "3.0")){
// prototying the XMLDocument
	XMLDocument.prototype.selectNodes = function(cXPathString, xNode){
		if( !xNode ) { xNode = this; } 
		var oNSResolver = this.createNSResolver(this.documentElement)
		var aItems = this.evaluate(cXPathString, xNode, oNSResolver, 
		XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null)
		var aResult = [];
		for( var i = 0; i < aItems.snapshotLength; i++)	{
			aResult[i] = aItems.snapshotItem(i);
		}
	return aResult;
	}

// prototying the Element
	Element.prototype.selectNodes = function(cXPathString){
		if(this.ownerDocument.selectNodes){
 			return this.ownerDocument.selectNodes(cXPathString, this);
		}
		else{throw "For XML Elements Only";}
	}
}

// check for XPath implementation
if(document.implementation.hasFeature("XPath", "3.0")){
	// prototying the XMLDocument
	XMLDocument.prototype.selectSingleNode = function(cXPathString, xNode){
		if( !xNode ) { xNode = this; } 
		var xItems = this.selectNodes(cXPathString, xNode);
		if( xItems.length > 0 )	{
			return xItems[0];
		}
		else{
			return null;
		}
	}
	
	// prototying the Element
	Element.prototype.selectSingleNode = function(cXPathString)	{ 
	if(this.ownerDocument.selectSingleNode)	{
			return this.ownerDocument.selectSingleNode(cXPathString, this);
		}
		else{throw "For XML Elements Only";}
	}
}

function getNode(doc, xpath) {
	var retval = "";
	var value = doc.selectSingleNode(xpath);
	if (value.text) retval = value.text;
	else if(value.firstChild.nodeValue)retval = value.firstChild.nodeValue;
	//else(value.textContent)retval = value.textContent;
	return retval;
}

var StringBuilder = Class.create();
StringBuilder.prototype ={
	initialize: function(){
		this.tmp = new Array();
	},
	append:function(value){
		this.tmp.push(value);
		return this;
	},
	clear:function(){
    	this.tmp.length=1;
	},
	toString:function(){
    	return this.tmp.join('');
	}
}
