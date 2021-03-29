package com.aegismanager.utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    private WebDriver driver;
    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }
    public void saveScreenShot(String path, String shotName) {
        Logger log = Logger.getLogger(ScreenShot.class);
        //TakesScreenshot接口是依赖于具体的浏览器API操作的，所以在HTMLUnit Driver中并不支持该操作
        TakesScreenshot tScreenshot = (TakesScreenshot)driver;
        // 截图
        File photo = tScreenshot.getScreenshotAs(OutputType.FILE);
        File shotFile = new File(path+shotName);
        try{
            // 将截图复制到指定目录
            FileUtils.copyFile(photo, shotFile);
        }catch (IOException e){
            log.error(getClass() + " 保存截图失败");
            e.printStackTrace();
        }
    }


}
