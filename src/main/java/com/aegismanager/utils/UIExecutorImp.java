package com.aegismanager.utils;

import com.aegismanager.object.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * UIExecutor接口实现类
 * @author Johnny
 */
public class UIExecutorImp implements UIExecutor{
    private WebDriver driver;
    public Logger log;
    public UIExecutorImp(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 点击元素
     *
     * @author Johnny
     * @param locator
     */
    public void click(Locator locator) {
        WebElement element = getElement(locator);
        element.click();
    }

    /**
     * 输入文本
     * @param locator
     * @param value
     */
    public void sendKey(Locator locator, String value) {
        WebElement element = getElement(locator);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        element.clear();
        element.sendKeys(value);
    }

    /**
     * 获取文本
     * @param locator
     * @return
     */
    public String getText(Locator locator) {
        WebElement element = getElement(locator);
        return element.getText();
    }

    /**
     * 获取元素
     *
     * @param locator
     * @return
     */
    public WebElement getElement(Locator locator) {
        WebElement element = null;
        String address = locator.getAddress();
        switch (locator.getByType()) {


            case xpath:
                element = driver.findElement(By.xpath(address));
                break;
            case id:
                element = driver.findElement(By.id(address));
                break;
            case className:
                element = driver.findElement(By.className(address));
                break;
            case linkText:
                element = driver.findElement(By.linkText(address));
                break;
            default:
                break;
        }
        return element;
    }

    /**
     * 元素是否显式显示
     * @param locator
     * @return
     */
    public boolean isElementDisplayed(Locator locator) {
        boolean flag = false;
        WebElement element = getElement(locator);
        flag = element.isDisplayed();
        return flag;
    }

    /**
     * 切换窗口
     * @param title
     */
    public void switchWindow(String title) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (handle.equals(driver.getWindowHandle())) {
                continue;
            } else {
                driver.switchTo().window(handle);
                if (title.contains(driver.getTitle())) {
                    break;
                } else {
                    continue;
                }
            }
        }
    }

    /**
     * 切换frame
     * @param locator
     */
    public void switchFrame(Locator locator) {
        driver.switchTo().frame(locator.getAddress());
    }

    /**
     * 智能等待，超出该时长抛出异常
     * @param locator
     */
    public void waitElement(Locator locator) {
        //TODO Auto-generated method stub

    }

}