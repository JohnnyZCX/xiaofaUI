package com.aegismanager.utils;

import com.aegismanager.object.Locator;
import org.openqa.selenium.WebElement;

/**
 * webDriver常见的API
 *
 * @author Johnny
 */
public interface UIExecutor {
    //点击
    public void click(Locator locator);
    //输入文本
    public void sendKey(Locator locator,String value);
    //获取元素文本
    public String getText(Locator locator);
    //获取元素
    public WebElement getElement(Locator locator) throws Exception;
    //判断元素是否显示
    public boolean isElementDisplayed(Locator locator);
    //切换页面
    public void switchWindow(String title);
    //切换frame
    public void switchFrame(Locator locator);
    //智能等待
    public void waitElement(Locator locator);


}
