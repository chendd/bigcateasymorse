package cn.vsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealZhNews {

	

	/**
	 * 通过正则表达式找到中文的 新闻连接
	 * 
	 * @param s
	 */
	public List<String>  getNewsLinks(String s) {
		 List<String> zhnewsList = new ArrayList<String>();
		String regex;
		String title = "";
		List<String> list = new ArrayList<String>();
		regex = "<a href=\"../PageUrl.*\" target=";
		Pattern pa = Pattern.compile(regex);
		Matcher ma = pa.matcher(s);
		// System.out.println("ddddd");
		while (ma.find()) {

			zhnewsList.add("http://www.sh.chinanews.com.cn/"
					+ ma.group().split("href=\"../")[1].split("\"")[0]);
			if (zhnewsList.size() >= 10) {
				break;
			}
		
		}
		return zhnewsList;
	}

	/**
	 *将网页中的信息抓去。赋值给newsbean
	 */
	public NewsBean getNewsFromList(String s,NewsBean newsBean,String isExpoNews) {
		String regex;
		String title = "";
		List<String> list = new ArrayList<String>();
		regex = "\"left_4\">[\\s\\S]*</P></div>";
		Pattern pa = Pattern.compile(regex);
		Matcher ma = pa.matcher(s);
		 //System.out.println("ddddd");
		while (ma.find()) {
			newsBean.setNewsContent(ma.group().split("left_4\">")[1].split("</div>")[0]);
		//	System.out.println("----  "+ma.group().split("left_4\">")[1].split("</div>")[0]);

		}
		
		regex = "<div class=\"left_2_1\">[^<]*</div>";
		Pattern pa1 = Pattern.compile(regex);
		Matcher ma1 = pa1.matcher(s);
		// System.out.println("ddddd");
		while (ma1.find()) {
		//	System.out.println("----  "+ma1.group());
			newsBean.setNewsTitle(ma1.group().split("\"left_2_1\">")[1].split("</div>")[0]);

		}
		newsBean.setNewsUrl("上海新闻网");
		newsBean.setExponews(isExpoNews);
		return newsBean;
	}


	
}
