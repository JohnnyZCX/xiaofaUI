package com.aegismanager.object;

import com.aegismanager.utils.UIExecutorImp;
import com.aegismanager.utils.XMLUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

/**
 * 基础页面类
 *
 */
public class BasePage extends UIExecutorImp {
    protected WebDriver driver;
    protected String pageName;// 页面名称
    protected String xmlPath;// 页面元素配置文件路径
    protected HashMap<String, Locator> locatorMap;//存储页面元素信息
    public Logger log;


    public BasePage(WebDriver driver, String pageName) throws Exception{
        super(driver);
        this.driver = driver;
        this.pageName = pageName;
        // 获取page.xml文件路径，page.xml在同级目录
        xmlPath = this.getClass().getResource("").getPath() + "page.xml";
        locatorMap = XMLUtil.readXMLDocument(xmlPath, pageName);

    }
    public void click(String locatorName){
        super.click(getLocator(locatorName));
    }

    /**
     *
     * @param locatorName
     * page.xml文件中定义的元素名称
     * @param value
     * 操作某一个元素对其输入一些值，比如对文本输入框输入某些文本
     */
    public void sendKey(String locatorName, String value){
        super.sendKey(getLocator(locatorName), value);
    }
    public String getText(String locatorName){
        return super.getText(getLocator(locatorName));
    }
    public WebElement getElement(String locatorName){
        return super.getElement(getLocator(locatorName));
    }
    public boolean isElementDisplayed(String locatorName){
        return super.isElementDisplayed(getLocator(locatorName));
    }
    @Override
    public void switchWindow(String title){
        super.switchWindow(title);
    }
    public void switchFrame(String locatorName){
        super.switchFrame(getLocator(locatorName));
    }
    public Locator getLocator(String locatorName){
        Locator locator = null;
        if (locatorMap != null){
            locator = locatorMap.get(locatorName);
        }
        return locator;
    }
}
