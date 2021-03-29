package com.aegismanager.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGListener extends TestListenerAdapter {
    private static WebDriver driver;
    Logger log;

    public TestNGListener() {
        log = Logger.getLogger(TestNGListener.class);
    }

    public static void setDriver(WebDriver driver){
        TestNGListener.driver = driver;
    }

    @Override
    public void onTestSuccess(ITestResult tr){
        log.info("Test Success");
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr){
        log.error("Test Failure");
        super.onTestFailure(tr);
        ScreenShot screenShot = new ScreenShot(driver);
        //获取当前project目录
        String path = System.getProperty("user.dir").replace("\\", "/");
        //加上时间戳以区分截图
        String curTime = TimeUtil.getCurTimeString();
        screenShot.saveScreenShot(path + "/img/", "testFail" + curTime + ".png");
    }
    @Override
    public void onTestSkipped(ITestResult tr) {
        log.error("Test Skipped");
        super.onTestSkipped(tr);
    }

    @Override
    public void onStart(ITestContext testContext){
        log.info("Test Start");
        super.onStart(testContext);
    }

    public void onFinish(ITestContext testContext){
        log.info("Test Finish");
        super.onFinish(testContext);
    }
}
