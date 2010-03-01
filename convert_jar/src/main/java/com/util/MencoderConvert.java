package com.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class MencoderConvert {
	

	Process proc = null;
	BufferedReader stdout = null;
	BufferedReader stderr = null;
	Vector<String> outputLines;
	int exitVal;
	boolean outputAllowed;
	/**use for executing mplayer and mencoder and maybe others.. */ 
	public  boolean executeM(String command) { 
	//showGUI(); 
	//MainGUI.procProgressBar.setValue(0); 
		
	try { 
	proc = Runtime.getRuntime().exec(command); 

	InputStream is = proc.getInputStream(); 
	 stdout = new BufferedReader(new InputStreamReader(is)); 
	is = proc.getErrorStream(); 
	 stderr = new BufferedReader(new InputStreamReader(is)); 
	 outputLines = new Vector<String>(); 
	//this deals with the output from the process in it's own thread 
	Thread stdoutThread = new Thread() { 
	public void run() { 
	try {
	int l; 
	String line; 
	for (l = 0; (line = stdout.readLine()) != null;) { 
	if (line.length() > 0) { 
	l++; 
	outputLines.addElement(line); 
	// if (line.matches("Starting playback...")) 
	outputAllowed = true; 
	} 
	System.out.print(outputAllowed ? line +"\n": "."); 


	} 
	System.out.println("\nRead " + l 
	+ " lines from stdout."); 
	stdout.close(); 

	} catch (IOException ie) { 
	System.out.println("IO exception on stdout: " + ie); 
	} 
	} 
	}; 
	stdoutThread.start(); 

	Thread stderrThread = new Thread() { 
	public void run() { 
	try { 
	int l; 
	String line; 
	for (l = 0; (line = stderr.readLine()) != null;) { 
	if (line.length() > 0) 
	l++; 
	System.out.print(","); 
	} 
	System.out.println("\nRead " + l 
	+ " lines from stderr."); 
	stderr.close(); 
	} catch (IOException ie) { 
	System.out.println("IO exception on stderr: " + ie); 
	throw new RuntimeException(ie);
	} 
	} 
	}; 
	stderrThread.start(); 

	System.out.println("About to waitfor"); 
	try { 
	exitVal = proc.waitFor(); 
	} catch (InterruptedException e) { 
	// TODO Auto-generated catch block 
	e.printStackTrace(); 
	} 
	System.out.println("Done."); 

	} catch (IOException e) { 
	e.printStackTrace(); 
	System.out.println("Exec failed. Exiting"); 
	System.exit(0); 
	throw new RuntimeException(e);
	} 
	return true;
	}
	
	

}
