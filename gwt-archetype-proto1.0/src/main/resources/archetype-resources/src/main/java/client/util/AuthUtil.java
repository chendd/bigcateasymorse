#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AuthUtil {
	
	private static Map<String,List<Map<String,List>>> authMap = new HashMap<String,List<Map<String,List>>>();
	
	static{
		List authList = new ArrayList();
		authList.add("数据查询");
		Map<String,List> authMaps = new HashMap<String,List>();
		authMaps.put("数据管理", authList);
		
		List authList1 = new ArrayList();
		authList1.add("个人信息管理");
		Map<String,List> authMaps1 = new HashMap<String,List>();
		authMaps1.put("用户管理", authList1);
		
		List list = new ArrayList();
		list.add(authMaps);
		list.add(authMaps1);
		
		authMap.put("普通用户",list );
		
		
		List authList2 = new ArrayList();
		authList2.add("数据查询");
		authList2.add("数据维护");
		Map<String,List> authMaps2 = new HashMap<String,List>();
		authMaps2.put("数据管理", authList2);
		
		List authList3 = new ArrayList();
		authList3.add("个人信息管理");
		authList3.add("帐号管理");
		Map<String,List> authMaps3 = new HashMap<String,List>();
		authMaps3.put("用户管理", authList3);
		List list1 = new ArrayList();
		list1.add(authMaps2);
		list1.add(authMaps3);
		
		authMap.put("管理员",list1 );
	}

	public static Map<String, List<Map<String, List>>> getAuthMap() {
		return authMap;
	}

	public static void setAuthMap(Map<String, List<Map<String, List>>> authMap) {
		AuthUtil.authMap = authMap;
	}
	


	


}
