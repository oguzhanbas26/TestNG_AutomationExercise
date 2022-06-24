package tests.t06_ContactusForm;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AEPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class C01_ContactUsForm {

    AEPage aePage = new AEPage();

    @Test
    public void test01() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationUrl"));
//        3. Verify that home page is visible successfully
        String URL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(URL,ConfigReader.getProperty("automationUrl"));
//        4. Click on 'Contact Us' button
        aePage.contactusButton.click();
//        5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(aePage.getInTouchText.isDisplayed());
//        6. Enter name, email, subject and message
        aePage.NameTextBox.sendKeys(ConfigReader.getProperty("name"));
        aePage.EmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        aePage.SubjectTextBox.sendKeys("Problem");
        aePage.MessageTextBox.sendKeys("There is a problem...");

//        7. Upload file
        String filePath ="C:\\Users\\OGUZHAN\\Desktop\\logo.jpeg";
        aePage.ChooseFileButton.sendKeys(filePath);

//        8. Click 'Submit' button
        aePage.SubmitButton.click();

//        9. Click OK button
        Driver.getDriver().switchTo().alert().accept();
//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(aePage.SuccessMessage.isDisplayed());
//        11. Click 'Home' button and verify that landed to home page successfully
        aePage.HomeButtontoReturn.click();
        String URL_return = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(URL_return,ConfigReader.getProperty("automationUrl"));


    }
}
