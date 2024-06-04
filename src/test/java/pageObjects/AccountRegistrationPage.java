package pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountRegistrationPage extends BasePage {
    WebDriver driver;
    public JavascriptExecutor js;

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (driver instanceof JavascriptExecutor) {
            this.js = (JavascriptExecutor) driver;
        } else {
            throw new IllegalStateException("This driver does not support JavaScript execution.");
        }
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastname;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

   // @FindBy(xpath = "//input[@id='input-telephone']")
   // WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

  //  @FindBy(xpath = "//input[@id='input-confirm']")
  //  WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setFirstName(String fname) {
        txtFirstname.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastname.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

   
    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

   
    public void setPrivacyPolicy() {
        try {
            chkdPolicy.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", chkdPolicy);
        }
    }
    
    public void clickContinue() {
    	try {
    		btnContinue.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();",btnContinue );
        }
            }

    public String getConfirmationMsg() {
        try {
            return msgConfirmation.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
