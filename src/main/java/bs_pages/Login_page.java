package bs_pages;

import bs_baseclass.Baseclass;
import com.google.common.util.concurrent.ServiceManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;


public class Login_page extends Baseclass {
    Login_page loginPage;
    @FindBy(xpath = "//*[@id=\"ctl00_lblUser\"]")
    static WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_txtEmail\"]")
  static   WebElement mobileNumber;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
   static WebElement password;


    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_btnLogin\"]")
  static   WebElement loginbutton;

//Initialisation of Page Objects
public Login_page()
{
    PageFactory.initElements(driver,this);
}
//Actions
public String validateinPageOfTitle()
{
    return driver.getTitle();
}
public void  login(String mobileNo,String pass) throws InterruptedException {
    myAccount.click();
    Thread.sleep(2000);
    mobileNumber.sendKeys(mobileNo);
    password.sendKeys(pass);
    loginbutton.click();
}
public static void  multipleLogin(String mobile, String passw) throws InterruptedException {
    myAccount.click();
    Thread.sleep(2000);
    mobileNumber.sendKeys(mobile);
    password.sendKeys(passw);
    loginbutton.click();

}
}
