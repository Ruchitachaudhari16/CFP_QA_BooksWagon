package bs_pages;

import bs_baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp_Page extends Baseclass {
    @FindBy(linkText = "//*[@id=\"ctl00_divLogin\"]/a[2]")
    WebElement Signup;
    @FindBy(name="ctl00$phBody$SignUp$txtName")
    WebElement Name;

    @FindBy(id="ctl00_phBody_SignUp_txtEmail")
    WebElement id;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;


}
