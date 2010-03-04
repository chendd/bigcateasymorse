package com.video.web.struts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.connection.MsnUser;
import com.video.util.MsnHelper;

public class GetMsnFriendsAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msnCount = request.getParameter("msnCount");
		String msnPass = request.getParameter("msnPass");
		List<String> friends = new ArrayList<String>();
		List<MsnUser> list = new ArrayList<MsnUser>();
		if(msnCount!=null&&!msnCount.trim().isEmpty()&&msnPass!=null&&!msnPass.trim().isEmpty()){
			friends = MsnHelper.getMsnFriendList(msnCount, msnPass);
		}
		
		if(friends.size()>0){
			for(String friend:friends){
				String[] ff = friend.split("\t\t\t\t\t\t\t\t\t\t");
				if(ff.length>1){
					MsnUser msnUser = new MsnUser();
					msnUser.setName(ff[0]);
					msnUser.setEmail(ff[1]);
					list.add(msnUser);
				}
				
			}
			
		}
	JSONArray array = JSONArray.fromObject(list);
	
	response.getWriter().print(array);
		return null;
	
	}

}
