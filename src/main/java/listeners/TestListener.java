package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.DriverFactory;
import reports.ExtentManager;
import utils.screenshotUtils;


public class TestListener implements ITestListener,IAnnotationTransformer{

	private static ExtentReports extent = ExtentManager.getExtentReports();
	
	private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testThread.set(test);
		testThread.get().info("Test Started: " +result.getMethod().getMethodName());
	}
	

	  public void onTestSuccess(ITestResult result) {
		  testThread.get().pass("Test Passed");
	  }


	  public void onTestFailure(ITestResult result) {
		testThread.get().fail("Test Failed ! "+result.getMethod().getMethodName());
	    testThread.get().fail(result.getThrowable());
	    String screenshot = screenshotUtils.takeScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
	    if(screenshot!= null) {
	    	testThread.get().addScreenCaptureFromPath(screenshot);
	    }
	  }


	  public void onTestSkipped(ITestResult result) {
		  testThread.get().skip("Test skipped");
	  }

	  
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  
	  public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		  annotation.setRetryAnalyzer(RetryAnalyzer.class);
		  }

	  
	  public void onFinish(ITestContext context) {
		  extent.flush();
		  System.out.println("Extent Report generated!");
	  }
	  
	  
	  public static ExtentTest getTest() {
	        return testThread.get();
	    }

	    public static void setTest(ExtentTest test) {
	        testThread.set(test);
	    }

}
