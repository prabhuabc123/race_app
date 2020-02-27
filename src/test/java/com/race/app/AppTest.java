package com.race.app;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
//import java.lang.*;

/**
 * Unit test for simple App.
 */

import com.race.app.App; //not source.main.java.com.race...

public class AppTest {    
	//check input file name
	@Test    
	public void createNewRace_in(){ App myApp = new App("racedata.csv","results.csv");
	assertEquals("racedata.csv",  myApp.getInFile());    
	}

	//check output file name
	@Test    
	public void createNewRace_out(){ App myApp = new App("racedata.csv","results.csv");
	assertEquals("results.csv",  myApp.getOutFile());    
	}

	//check output file name
	@Test    
	public void createNewRace_checker(){ App myApp = new App("racedata.csv","results.csv");
	assertEquals("results.csv",  myApp.getOutFile());    
	}

	//read data from correct file
	@Test
	public void readHashMapFilePresent() {
        App myApp = new App("/home/bodhi/racedata.csv", "results.csv");	
	assertEquals("fine", myApp.r());
	}

	//file is missing or has incorrect format
	@Test
	public void readHashMapFileIncorrect() {
        App myApp = new App("/home/bodhi/racedata.csv", "results.csv");	
	assertEquals(0, myApp.readData());
	}

	@Test
	public void showDriver() {
        App myApp = new App("/home/bodhi/racedata.csv", "results.csv");	
	myApp.readData();
	assertEquals("Alonzo", myApp.showDriver());
	}
	/*
	@Test    
	public void checkWeight(){ App myApp = new App("Jimmy", "Beagle");
	assertEquals(5,  myApp.getWeight());    
	}
	*/
}
