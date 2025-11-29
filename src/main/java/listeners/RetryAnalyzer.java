package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	private int retryCount = 0;
    private final int maxRetryCount = 2;  // retry twice

    @Override
    public boolean retry(ITestResult result) {
        Object currentClass = result.getInstance();
        String testMethod = result.getMethod().getMethodName();

        if (retryCount < maxRetryCount) {
            retryCount++;

            TestListener.getTest().warning(
                "Retrying test: " + testMethod +
                " (Attempt " + retryCount + "/" + maxRetryCount + ")"
            );

            return true;
        }
        return false;
    }
}
