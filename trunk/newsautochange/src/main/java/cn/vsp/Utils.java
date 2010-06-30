package cn.vsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	
	
	
	/**
	 * 通过给定的url得到网页的信息
	 * @param htmlurl
	 * @return
	 * @throws IOException
	 */
	public String getOneHtml(String htmlurl) throws IOException {
		URL url;
		String temp;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(htmlurl);
			BufferedReader in = new BufferedReader(new InputStreamReader(url
					.openStream(), "gb2312"));// 读取网页全部内容
			while ((temp = in.readLine()) != null) {
				sb.append(temp + "\n");
			}
			in.close();
		} catch (MalformedURLException me) {
			System.out.println("你输入的URL格式有问题！请仔细输入");
			me.getMessage();
			throw me;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}
/**
 * 通过正则表达式找到英文新闻连接
 * @param s
 */
	public List<String> getEnNewsLinks(String s) {
		List<String> newsList = new ArrayList<String>();
		String regex;
		String title = "";
		List<String> list = new ArrayList<String>();
		regex = "<a href=\"/special/shanghai-expo-2010/Content.aspx[^>]*\">";
		Pattern pa = Pattern.compile(regex);
		Matcher ma = pa.matcher(s);
		while (ma.find()) {
			///System.out.println(">>>>"+ma.group());
			newsList.add("http://www.echinacities.com"+ma.group().split("href=\"")[1].split("\"")[0]);
			if(newsList.size()>=10){
				break;
			}
			//list.add(ma.group());
		}
		return newsList;

	}

	/**
	 * 匹配具体的新闻网页
	 * 并将取得的结果赋值给NewsBean
	 */
	public NewsBean getEnNewsBean(String s) {
		List<NewsBean> newsBeanList = new ArrayList<NewsBean>();
		NewsBean newBean = new NewsBean();
		String regex;
		String title = "";
		List<String> list = new ArrayList<String>();
		regex = "<h1 id=\"divTitle\">.*</h1>";
		//regex = "\"/special/shanghai-expo-2010/Content.aspx[^>]*\"";
		Pattern pa = Pattern.compile(regex);
		Matcher ma = pa.matcher(s);
		while (ma.find()) {
			//System.out.println(">>>>"+ma.group().split("id=\"divTitle\">")[1].split("<")[0]);
			newBean.setEnNewsTitle(ma.group().split("id=\"divTitle\">")[1].split("<")[0]);
			//newsList.add(ma.group().split("href")[1]);
			//list.add(ma.group());
		}
		//记录时间
		regex = "<div id=\"divDateTime\" class=\"divDateTime\">.*<br>";
		//regex = "\"/special/shanghai-expo-2010/Content.aspx[^>]*\"";
		Pattern pa1 = Pattern.compile(regex);
		Matcher ma1 = pa1.matcher(s);
		while (ma1.find()) {
			//System.out.println("-------------"+ma1.group().split("class=\"divDateTime\">")[1].split("<")[0]);
			newBean.setNewsDate(ma1.group().split("class=\"divDateTime\">")[1].split("<")[0]);
			//newsList.add(ma.group().split("href")[1]);
			//list.add(ma.group());
		}

		//记录时间
		regex = "<div id=\"divContent\" class=\"tentcon\">.*</P>";
		//regex = "\"/special/shanghai-expo-2010/Content.aspx[^>]*\"";
		Pattern pa2 = Pattern.compile(regex);
		Matcher ma2 = pa2.matcher(s);
		while (ma2.find()) {
			//System.out.println("-------------"+ma2.group().split("<P>")[1].split("</P>")[0]);
			newBean.setEnNewsContent(ma2.group().split("<P>")[1].split("</P>")[0]);
			
			//newsList.add(ma.group().split("href")[1]);
			//list.add(ma.group());
		}
		//newBean.set
		return newBean;
		//newsBeanList.add(newBean);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Test tests = new Test();
//
//		try {
//			tests.getNewsLinks(tests.getOneHtml("http://www.echinacities.com/special/shanghai-expo-2010/expo-news/"));
//			for(int i=0;i<tests.newsList.size();i++){
//				System.out.println(tests.newsList.get(4));
//				
//				tests.getNewsTitle(tests.getOneHtml(tests.newsList.get(i)));
//			}
//			System.out.println("=============="+tests.newsBeanList.get(6).getEnNewsContent());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	}
}
