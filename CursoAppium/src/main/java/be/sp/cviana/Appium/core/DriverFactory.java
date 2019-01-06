package be.sp.cviana.Appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	
	private static void createDriver() {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
//	    desiredCapabilities.setCapability("deviceName", "G5AZB60061605Z7");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    //desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:/Códigos Fonte/Eclipse Workstation/CursoAppium/resources/CTAppium-1-1.apk");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:/SALVO/Códigos Fonte/Eclipse Workstation/CursoAppium/resources/CTAppium-1-1.apk");
	    
	    try {
			driver = new AndroidDriver<MobileElement>( new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities );
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	private static void createTestObjectDriver() {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("testobject_api_key", "");
	    desiredCapabilities.setCapability("appiumVersion", "1.10.0");
	    
	    try {
			driver = new AndroidDriver<MobileElement>( new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities );
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
//			createTestObjectDriver();
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	
}
