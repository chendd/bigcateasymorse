package com.video.domain.data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlTest {
	
	
	
	public static void main(String[] args) {
		File file =new File (new XmlTest().getClass().getResource("/").getPath()+"/com/video/domain/data/event2.xml");
		file.delete();
		
		/** 建立document对象 */
	       Document document = DocumentHelper.createDocument();
	       /** 建立XML文档的根note */
	       Element noteElement = document.addElement("note");
	
	      
	       Element eventElement = noteElement.addElement("event");
	     
	
	       Element userIdElement = eventElement.addElement("userId");
	       Element realNameElement = eventElement.addElement("realName");
	       Element descriptionElement = eventElement.addElement("description");
	       Element urlElement = eventElement.addElement("url");
	
	       userIdElement.setText("1");
	       realNameElement.setText("三角板");
	       descriptionElement.setText("发表了新话题");
	       urlElement.setText("rrrr");
	     
	       
	      
	       
	       try{
	           /** 将document中的内容写入文件中 */
	           XMLWriter writer = new XMLWriter(new FileWriter(new File(new XmlTest().getClass().getResource("/").getPath()+"/com/video/domain/data/event2.xml")));
	           writer.write(document);
	           writer.flush();
	           writer.close();
	           /** 执行成功,需返回1 */
	         
	       }catch(Exception ex){
	           ex.printStackTrace();
	       }
		
		
	

	}

}
