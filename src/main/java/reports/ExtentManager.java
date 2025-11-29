package reports;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

    public synchronized static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportPath = Paths.get(System.getProperty("user.dir"), "target", "extent-report", "index.html").toString();
            
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Selenium POM Report");
            
            extent = new ExtentReports();
            extent.attachReporter(spark);
            
            extent.setSystemInfo("Framework", "Selenium POM");
            extent.setSystemInfo("Author", "Swapnil");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
