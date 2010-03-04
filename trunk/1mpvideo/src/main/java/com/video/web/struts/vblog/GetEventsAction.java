package com.video.web.struts.vblog;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Event;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class GetEventsAction extends BaseAction{
	
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	HttpSession session = request.getSession();
    User user = (User)session.getAttribute("sessionUser");
    if(user !=null){
    	String pageNo = request.getParameter("pageNo");
    	int no = UtilMethod.intFormat(pageNo);
    	int size = 10;
    	Pagination<Event> pagination = new Pagination<Event>();
    	pagination.setNo(no);
    	pagination.setSize(size);
    	pagination.setCondition(user);
    	getAllService().getEvents(pagination);
    	System.out.println(pagination.getSize());
    	for(Event event:pagination.getResults()){
    		System.out.println(event.getDescription());
    	}
    	JSONObject object = JSONObject.fromObject(pagination);

		response.getWriter().print(object);

		return null;
    	
    	
    }
	return super.execute(mapping, form, request, response);
}
	
	

}
