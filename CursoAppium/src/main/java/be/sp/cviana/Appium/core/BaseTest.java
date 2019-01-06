package be.sp.cviana.Appium.core;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;
import static be.sp.cviana.Appium.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	
	@Rule
	public TestName testName = new TestName();
	

	@After
	public void tearDown() {
		gerarScreenshot();
		getDriver().resetApp();
		getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void finalizaClasse() {
		killDriver();
	}
	
	
	public void gerarScreenshot() {
		File image = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(image, new File("screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperaFixa(float segundos) {
		try {
			Thread.sleep((int)segundos*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
