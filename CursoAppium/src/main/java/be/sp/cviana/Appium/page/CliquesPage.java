package be.sp.cviana.Appium.page;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;

import be.sp.cviana.Appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class CliquesPage extends BasePage {
	
	
	public void cliqueLongo() {
		MobileElement clique = getDriver().findElement( By.xpath("//*[@text='Clique Longo']") );
		
		new TouchAction( getDriver() )
		.longPress( LongPressOptions.longPressOptions().withElement(ElementOption.element(clique)).withDuration(Duration.ofMillis(2000)) )
		.perform();
		
		
	}
	
	
	public String obterTextoCampo() {
		return getDriver().findElement( By.xpath( "(//android.widget.TextView[2])" ) ).getText();
	}
	
	public void cliqueDuplo() {
		clicarPorTexto("Clique duplo");
		clicarPorTexto("Clique duplo");
		
	}
	
	
}
