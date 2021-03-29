package com.aegismanager.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserUtil {
    private static WebDriver driver;

    /**
     *  启动chrome浏览器
     * @param browserDriverUrl
     *  浏览器驱动路径
     * @param sec
     *  所有页面操作的等待超时时长
     * @return
     */
    public static WebDriver chrome(String browserDriverUrl, long sec) {
        System.setProperty("webdriver.chrome.driver", browserDriverUrl);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        return driver;
    }

    /**
     *  启动edge浏览器
     * @param browserDriverUrl
     *  浏览器驱动路径
     * @param sec
     *  所有页面操作的等待超时时长
     * @return
     */
    public static WebDriver edge(String browserDriverUrl, long sec) {
        System.setProperty("webdriver.edge.driver", browserDriverUrl);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        return driver;
    }



}

