package com.killerpc.debuging;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.killerpc.core.ComputerMontor;

public class Debug {
	
	private boolean debugMode = false;
	private boolean loggerMode = false;
	private boolean consoleMode = false;
	private boolean displayMode = false;
	
	private boolean startLogger = true;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private DateFormat fileDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	
	private PrintWriter log;
	
	private int Ticks, FPS;
	private long Memory;
	private String error=null;
	
	public void run(){
		if (!debugMode)return;
		if (loggerMode)Logger();
		if (consoleMode)console();
		if (displayMode)display();
		
		//clean up 
		if(error != null)error=null;
	}
	
	private void console(){
		System.out.println("Ticks "+ Ticks + " | FPS " + FPS + " | " + dateFormat.format(new Date()));
		if(error!=null){
			System.out.println(error);
		}
		
	}
	
	private void Logger(){
		try {
			if (startLogger){
			log = new PrintWriter(fileDateFormat.format(new Date())+".log","UTF-8");
			log.println(new ComputerMontor().getSystemInfo());
			startLogger = false;
			}
			log.println("Ticks "+ Ticks + " | FPS " + FPS + " | " + dateFormat.format(new Date()));
			if(error != null){
				log.println(error);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void display(){
		//display
	}
	
	
	public void Logercleanup(){
		if(startLogger)return;
		log.flush();
		log.close();
	}
	
	public void setDebugData(int Ticks, int FPS, long Memory){
		this.Memory = Memory;
		this.FPS = FPS;
		this.Ticks = Ticks;
		run();
	}
	
	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}
	public void setLoggerMode(boolean loggerMode) {
		this.loggerMode = loggerMode;
	}
	public void setConsoleMode(boolean consoleMode) {
		this.consoleMode = consoleMode;
	}
	public void setDisplayMode(boolean displayMode) {
		this.displayMode = displayMode;
	}
	public void setError(String error) {
		this.error = error;
		run();
	}

	public boolean isDebugMode() {
		return debugMode;
	}

	public boolean isConsoleMode() {
		return consoleMode;
	}

	public boolean isLoggerMode() {
		return loggerMode;
	}
	

}
