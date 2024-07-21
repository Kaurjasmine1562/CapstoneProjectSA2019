package Scenario1;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshotUtility {
	 public static void capture(WebDriver driver, String screenshotName) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
	    }

}
