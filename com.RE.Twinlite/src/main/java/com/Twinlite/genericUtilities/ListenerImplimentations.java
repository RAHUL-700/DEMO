package com.Twinlite.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentations implements ITestListener{

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		
		String testname=result.getMethod().getMethodName();
		System.out.println("i am listening-----");
		TakesScreenshot ts= (TakesScreenshot)BaseClass.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime ldtime=LocalDateTime.now();
		String cDateTime=ldtime.toString().replace(" ", "_").replace(":", "_");
		File dest=new File("./screenshots/"+testname+" "+cDateTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}
