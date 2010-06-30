package cn.vsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitNewsBeanList {

	public static void main(String[] args) {
		/**
		 * 英文的list
		 */
		List<String> enNewslist = new ArrayList<String>();
		/**
		 * 中文的list
		 */
		List<String> zhNewslist = new ArrayList<String>();

		List<NewsBean> newsBeanList = new ArrayList<NewsBean>();

		List<NewsBean> finalNewsBeanList = new ArrayList<NewsBean>();

		Utils utils = new Utils();
		try {

			enNewslist = utils
					.getEnNewsLinks(utils
							.getOneHtml("http://www.echinacities.com/special/shanghai-expo-2010/expo-news/"));

			for (int i = 0; i < enNewslist.size(); i++) {
				newsBeanList.add(utils.getEnNewsBean(utils
						.getOneHtml(enNewslist.get(i))));
			}
			System.out.println("---------------   " + newsBeanList.size()
					+ "  ----  " + newsBeanList.get(2).getEnNewsTitle());

			String s = utils
					.getOneHtml("http://www.sh.chinanews.com.cn/news/news_more.asp?classid=24");
			DealZhNews dealZhNews = new DealZhNews();
			zhNewslist = dealZhNews.getNewsLinks(s);
			String isExpoNews = null;
			for (int j = 0; j < zhNewslist.size(); j++) {
				if((j%2)==0){
					isExpoNews = "false";
				}else{
					isExpoNews = "true";
				}
				finalNewsBeanList.add(dealZhNews.getNewsFromList(utils.getOneHtml(zhNewslist
						.get(j)), newsBeanList.get(j),isExpoNews));
//				System.out.println("zhnewsList size is  " + zhNewslist.get(j)
//						+ "   ************  "
//						+ newsBeanList.get(j).getEnNewsTitle());
			}
			System.out.println(">>>>>>>>>>>"
					+ finalNewsBeanList.get(2).getEnNewsTitle() + "  ---  "
					+ finalNewsBeanList.get(3).getExponews());
		} catch (IOException e) {
			throw new RuntimeException("错误", e);
		}
	}
}
