/**
 * 
 */
package com.mypro.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mypro.base.BaseClass;

/**
 * @author DELL
 *
 */
public class EventList implements ITestListener {
	
	public void onTestFailure (ITestResult result) {
		File src=((TakesScreenshot)(BaseClass.driver)).getScreenshotAs(OutputType.FILE);
		File dest=new File("Screenshots/"+System.currentTimeMillis()+".png");
		String path=dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		}catch (Exception e) {
			e.printStackTrace();
		}
	//Test case failedjava.lang.AssertionError: expected [false] but found [true] ...>this Exception will display if we use the above.
		//BaseClass.test.fail("Test case failed"+result.getThrowable());											//11
		
	//If in case we want failed script screen shot in our extent report then,
		//BaseClass.test.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());			//12
		
	//To print both logs and Screenshot
		BaseClass.test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
