package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {

	public static WebDriver driver=null;
	public static Properties config = new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoylogger");
	
	public static void main(String[] args) throws IOException {
		
		if(driver==null)
		{
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			
			if(config.getProperty("browser").equals("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.debug("Chrome started");
			}
			else if (config.getProperty("browser").equals("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
			}else if (config.getProperty("browser").equals("ie"))
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			
			driver.get(config.getProperty("url"));
			log.debug("url launched");
			driver.manage().window().maximize();
			log.debug("window maximised");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait"))));
			
		
	}
	}

}
