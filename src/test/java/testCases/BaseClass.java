package testCases;

import org.apache.logging.log4j.LogManager;
import org. apache. logging. log4j. Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public Logger logger;  //setup for log4j, creating variable of logger class
    public Properties p; // for setup config.properties file we are creating variable of properties class


    @BeforeMethod(groups = {"Sanity" , "Regression"})
    @Parameters({"browser"}) //receiving two parameter from testng.xml file
    void browserSetup(String br) throws IOException {
        //browserSetup -> This is the method that runs before each test case, Its primary job is to "Initialize the WebDriver"(Decide which browser to use (Chrome, Firefox, Edge, etc.)),
        //                "Maximize the Window", "Add Implicitly Wait", "Navigate to the Base URL"

        //Loading config.properties file that we created inside resource directory
        FileReader file = new FileReader(".//src//test//resources//config.properties");
        p= new Properties();
        p.load(file);

        //Loading log4j2.xml file in BaseClass for generating log
        logger = LogManager.getLogger(this.getClass());  //it fetch log4j2 file and load into logger variable and  this logger is used to generate the log

        //for cross browser testing, this method(LaunchingBrowser()) is responsible for launching te browser so this methodLaunchingBrowser(String os, String br) will receive the browser parameter from testng.xml file
        switch (br.toLowerCase())
        {
            case "chrome" :  driver = new ChromeDriver();
            break;
            case "firefox" : driver = new FirefoxDriver();
            break;
            case "edge" : driver = new EdgeDriver();
            break;
            default: System.out.println("Invalid browser");
            return; // here return will exit from 'browserSetup' and below code will not get executed, Note:-if we use break here then it will only exit from switch case.
        }

        driver.manage().deleteAllCookies(); // It is used to delete all cookies from the webpage
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("url"));
        //driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod(groups = {"Sanity" , "Regression"})
    void  tearDown()
//  tearDown-> This is the method that runs after each test case, whether the test get passed or failed. Its important job is to close the browser.
//  1)driver.quit(): Recommended. Closes all associate browser windows and it is more safe. 2)driver.close(): Closes only the current window and it is less safe

    {
        driver.quit(); // recommended
        //driver.close();
    }

//    public String randomeString()
//    {
//        String generatedString=RandomStringUtils.randomAlphabetic(5);
//        return generatedString;
//    }
//
//    public String randomeNumber()
//    {
//        String generatedString=RandomStringUtils.randomNumeric(10);
//        return generatedString;
//    }
//
//    public String randomAlphaNumeric()
//    {
//        String str=RandomStringUtils.randomAlphabetic(3);
//        String num=RandomStringUtils.randomNumeric(3);
//
//        return (str+"@"+num);
//    }

    //when test method get failed then this method will execute and take the screen shoot of the webpage and store in screenshot folder(targetFilePath) and return the path of the screen shoot(targetFilePath) that is used in the extent report class for attaching the screen shoot in the report
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  //taking screen shoot with time stamp format yyyyMMddhhmmss

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
