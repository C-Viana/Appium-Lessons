package be.sp.cviana.Appium.page;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import be.sp.cviana.Appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDropPage extends BasePage {
	
	
	public void arrastar(String origem, String destino) {
		MobileElement el1 = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement el2 = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		new TouchAction(getDriver()).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(el1)))
			.moveTo(ElementOption.element(el2) ).release().perform();
		
	}
	
	
	public String[] obterLista() {
		List<MobileElement> lista = getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[lista.size()];
		for(int i=0; i<lista.size(); i++) {
			retorno[i] = lista.get(i).getText();
//			System.out.print(retorno[i] + " | ");
		}
		return retorno;
	}
	
	
}
