package com.rafaelwassoaski.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestPage {
    private WebDriver webDriver;

    public LoginTestPage(){
        System.setProperty("webdriver.chrome.driver", "src/webDrivers/chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://localhost:8080/login");
    }

    public void finalizar(){
        webDriver.quit();
    }

    public boolean estaNaPaginaHome(){
        return webDriver.getCurrentUrl().equals("http://localhost:8080/");
    }

    public void fazerLogin(String usuario, String senha){
        webDriver.findElement(By.id("username")).sendKeys(usuario);
        webDriver.findElement(By.id("password")).sendKeys(senha);
        webDriver.findElement(By.tagName("button")).click();
    }
}
