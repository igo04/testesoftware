package br.com.teste.tdd.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;


public class TestWebBrowser {

    private WebDriver driver;
    private WebElement searchBox;

    private WebElement searchResults;
    private WebElement  element;

    private WebElement  product;







    @BeforeEach
    void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void closeBrowser() {
        //driver.quit(); // encerra(fecha) o Google Chrome
    }


    @Test
    void seach(){
        driver.get("https://www.kabum.com.br");


        searchBox = driver.findElement(By.id("input-busca"));
        searchBox.sendKeys("Playstation 5");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        element = driver.findElement(By.className("IconHeaderSearch"));
        element.click();
        element = driver.findElement(By.className("imageCard"));
        element.click();


        element = driver.findElement(By.cssSelector("button sc-gVf10g gvhTCY"));
        element.click();

    }
    }