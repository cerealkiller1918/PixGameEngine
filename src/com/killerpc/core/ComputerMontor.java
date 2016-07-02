package com.killerpc.core;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class ComputerMontor {
	
	private OperatingSystemMXBean os;
	
	public  ComputerMontor(){
		os = ManagementFactory.getOperatingSystemMXBean();
	}
	
	
	public String getSystemInfo(){
		String output = "";
		output += os.getName();
		output += " ";
		output += os.getArch();
		return  output;		
	}

}
