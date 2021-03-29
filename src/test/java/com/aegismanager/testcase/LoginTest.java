package com.aegismanager.testcase;

import com.aegismanager.action.Login;
import com.aegismanager.object.BasePage;
import com.aegismanager.utils.BrowserUtil;
import com.aegismanager.utils.TestNGListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestNGListener.class})
public class LoginTest {
    private WebDriver driver;
    private Login login;

    @DataProvider(name = "loginParams")
    public Object[][] loginParams() {
        return new Object[][]{{"l5214337054", "", "请输入密码"}};
    }

    @BeforeClass
    @Parameters({"browserDriverUrl", "url"})
    public void beforeClass(String browserDriverUrl, String url) {
        driver = BrowserUtil.chrome(browserDriverUrl, 30);
        driver.get(url);
    }

    @BeforeMethod
    public void BeforeMethod() {
        login = new Login(driver);
        TestNGListener.setDriver(driver);
    }

    @Test(dataProvider = "loginParams", description = "异常用户信息登录")
    public void login02(String username, String pwd, String expectedTip) throws Exception {
        login.login(username, pwd);
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-message el-message--error']//p[@class='el-message__content']")));
        String tip = new BasePage(driver, "loginPage").getText("必填项提示");
        Assert.assertEquals(tip, expectedTip);
    }

    @Test(dependsOnMethods = "login02", description = "正常用户登录")
    @Parameters({"username", "pwd"})
    //创建正常场景（登陆成功）测试方法
    public void login(String username, String pwd) throws Exception {
        login.login(username, pwd);
        String tip = new BasePage(driver, "mainPage").getText("小法管理");
        Assert.assertEquals(tip, "小法管理");
    }

    @AfterClass
    public void afterClass() {

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
