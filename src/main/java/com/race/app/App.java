package com.race.app;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class App {
   private String inFile;
   private String outFile;
   private HashMap<String, ArrayList<Double>> driver_data;
   public App(String pFile1, String pFile2) { 
	this.inFile = pFile1;
	this.outFile = pFile2;
   }
   public String getInFile() { return inFile; }
   public String getOutFile() { return outFile; }

   public int ParseLine(String pLine) {
	   String tokens[] = pLine.split(",");
	   if (tokens.length < 2)
		   return 0;

	   String drivername = tokens[0];
	   Double laptiming = Double.valueOf(tokens[1]);
	   if (laptiming <= 0)
		   return 0;

	   if (driver_data.get(drivername) == null) {
		   driver_data.put(drivername, new ArrayList<Double>());
	   }
	   driver_data.get(drivername).add(laptiming);
	   return 1;
   }

   public String r() {
	BufferedReader bReader = null;
	int retval = 1;
	try {
              String line = "";
	      bReader = new BufferedReader(new FileReader(inFile));
	     }
	catch (IOException e) { e.printStackTrace(); return "bad";}
	return "fine";
    }
   public int readData() {
	BufferedReader bReader = null;
	int retval = 1;
	try {
              String line = "";
	      bReader = new BufferedReader(new FileReader(inFile));
	      while ((line = bReader.readLine()) != null)  {
		   String tokens[] = line.split(",");
		   if (tokens.length < 2)
			   return 0;

		   String drivername = tokens[0];
		   Double laptiming = Double.valueOf(tokens[1]);
		   if (laptiming <= 0)
			   return 0;

		   if (driver_data.get(drivername) == null) {
			   driver_data.put(drivername, new ArrayList<Double>());
		   }
		   driver_data.get(drivername).add(laptiming);
	      }
	}
	catch (Exception e) { e.printStackTrace(); return 0;}  
	try { bReader.close(); } 
	catch (IOException e) { e.printStackTrace(); return 0; }
   	return retval;
    }

    public String showDriver() {
         String a = "others";
   	 int i = 0;
	for (HashMap.Entry<String,ArrayList<Double>> entry: driver_data.entrySet()) {
	String key = entry.getKey();
	List<Double> values = entry.getValue();
	if (i == 0) { return key; }
	}
    	return a;
    }
}
