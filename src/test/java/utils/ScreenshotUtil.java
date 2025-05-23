package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName;

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);

        try {
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        }

        return screenshotPath;
    }
}
