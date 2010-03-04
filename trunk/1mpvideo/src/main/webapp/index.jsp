<%
	String url = request.getContextPath();
	request.getRequestDispatcher(url + "/index/").forward(request,
			response);
%>