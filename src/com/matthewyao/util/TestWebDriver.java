package com.matthewyao.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;

import java.util.List;


/**
 * Created by matthewyao on 2016/5/10.
 */
public class TestWebDriver {

//    private static final String URL_NAVIGATE = "http://www.baidu.com";
    private static final String URL_NAVIGATE = "http://moni.51hupai.org/?new=13";
    private static final String URL_CHROME_DRIVER = "D:\\programmData\\JavaLearning\\ChromeDriver\\chromedriver.exe";

    public static void execute(){
        String[] words = new String[]{"webDriver","matthewyao","suliangbo","hupai","test","java"};

        System.setProperty("webdriver.chrome.driver",URL_CHROME_DRIVER);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_NAVIGATE);
        WebElement input;
        List<WebElement> elements;
        elements = driver.findElements(By.id("Mainbox"));
        for (WebElement element : elements) {
            element.sendKeys("88888");
        }
//        for (String word : words) {
//            input = driver.findElement(By.name("wd"));
//            input.sendKeys(word);
//            input.submit();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            driver.navigate().to(URL_NAVIGATE);
//        }
//        driver.quit();
    }
}
