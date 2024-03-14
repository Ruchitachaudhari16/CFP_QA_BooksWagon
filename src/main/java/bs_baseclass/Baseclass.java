package bs_baseclass;

import bs_utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Baseclass {

  public static WebDriver driver;

  public static Properties properties;
  protected ExtentReports extent=new ExtentReports();
  public ExtentSparkReporter spark =new ExtentSparkReporter("C:\\Users\\www.abcom.in\\IdeaProjects\\Bookswagon\\src\\main\\java\\ExtenReport\\Extentfile.html");
    public Baseclass()
    {
        try {
            properties = new Properties();
            FileInputStream  ip=new FileInputStream("C:\\Users\\www.abcom.in\\IdeaProjects\\Bookswagon\\src\\main\\java\\bs_config_properties\\config.properties");

        properties.load(ip);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
       e.printStackTrace();
        }
    }
    public static  void initialisation()
    {
      String browsername=properties.getProperty("browser");
      if(browsername.equals("chrome"))
      {
          driver=new ChromeDriver();
      } else if (browsername.equals("firefox"))
      {
       driver=new FirefoxDriver();
      }
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
//      driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
//      driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT,TimeUnit.SECONDS);

      driver.get(properties.getProperty("url"));
    }

}
