<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ attribute name="pageSum" required="true"%>
<%@ attribute name="no" required="true"%>
<%@ attribute name="next" required="true"%>
<%@ attribute name="pre" required="true"%>
<%@ attribute name="url" %>


<div class="green-black">
<c:if test="${pre}"><span ><a href="${url }/${no-1 }"><  Prev</a></span></c:if>
<c:if test="${no<=5}">

<c:forEach begin="1" end="${no}" step="1" var="i">
<c:if test="${no==i}"><span  class="current">${i }</span></c:if>
<c:if test="${no!=i}"><a href="${url }/${i }">${i }</a></c:if>
</c:forEach>
</c:if>

<c:if test="${no>5}">
<a href="${url }/1">1</a><a href="${url }/2">2</a>...<a href="${url }/${no-2 }">${no-2 }</a><a href="${url }/${no-1 }">${no-1 }</a><span  class="current">${no }</span>


</c:if>
<c:if test="${pageSum-no<=5}">
<c:forEach begin="${no+1}" end="${pageSum}" step="1" var="i"><a href="${url }/${i }">${i }</a></c:forEach>
</c:if>
<c:if test="${(pageSum-no)>5}">
<a href="${url }/${no+1 }">${no+1 }</a><a href="${url }/${no+2 }">${no+2 }</a>...<a href="${url }/${pageSum-1 }">${pageSum-1 }</a><a href="${url }/${pageSum }">${pageSum }</a>
</c:if>


<c:if test="${next}">
<a href="${url }/${no+1 }">Next  > </a>
</c:if>
</div>
