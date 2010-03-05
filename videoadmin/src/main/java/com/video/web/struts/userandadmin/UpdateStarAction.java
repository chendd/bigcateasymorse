package com.video.web.struts.userandadmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.connection.Star;
import com.video.web.struts.BaseAction;

public class UpdateStarAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String male = request.getParameter("male");
		String female = request.getParameter("female");

		if (male != null && !male.trim().isEmpty()) {
			
			Long male_id = new Long(0);
			try{
				male_id = Long.parseLong(male);
			}
			catch(Exception e){
				
			}
			Star star1 = new Star();
			star1.setId(1);
			star1.setUser_id(male_id);
			getAllDao().updateStar(star1);
		}

		if (female != null && !female.trim().isEmpty()) {
			Long female_id = new Long(0);
			try{
				female_id = Long.parseLong(female);
			}
			catch(Exception e){
				
			}
			Star star2 = new Star();
			star2.setId(2);
			star2.setUser_id(female_id);
			getAllDao().updateStar(star2);
			
		}
		return mapping.findForward("success");
	}

}
