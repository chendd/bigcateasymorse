package com.util;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Convert {

	
	public  boolean ffmpeg(String cmd){
		String[] cmds = {"/bin/sh","-c",cmd};
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmds);
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			FileOutputStream out=new FileOutputStream("/var/www/log.txt");
			PrintStream p=new PrintStream(out);
			System.out.println("<ERROR>");
			p.println("<ERROR>");
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);
				p.println(line);
			}
			System.out.println("</ERROR>");
			p.println("</ERROR>");
			while (true) {
				if (proc.waitFor() == 0)
					break;
			}
			// System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			throw new RuntimeException(t);
			
		}

		return true;
		
		
	}

}
