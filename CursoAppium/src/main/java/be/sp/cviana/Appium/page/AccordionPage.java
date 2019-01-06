package be.sp.cviana.Appium.page;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import be.sp.cviana.Appium.core.BasePage;
import io.appium.java_client.MobileElement;

public class AccordionPage extends BasePage {
	
	public void acessarOpcao(int opt) {
		clicarPorTexto( "Op��o " + opt );
	}
	
	public String obterOpcaoSelecionada(int opt) {
		return obterTexto( By.xpath("//*[@text='Op��o " + opt + "']/../../following-sibling::android.view.ViewGroup//android.widget.TextView") );
	}
	
	
	public int getTotalOpcoes() {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[starts-with(@text, 'Op��o ')]") );
		System.out.println(elementos.size());
		return elementos.size();
		
	}
	
	public void validaOpcoes(int opt) {
				
		switch(opt) {
		case 1:
			Assert.assertEquals( "Esta � a descri��o da op��o 1" , obterOpcaoSelecionada(opt) );
			break;
		case 2:
			Assert.assertEquals( "Esta � a descri��o da op��o 2" , obterOpcaoSelecionada(opt) );
			break;
		case 3:
			Assert.assertEquals( "Esta � a descri��o da op��o 3. Que pode, inclusive ter mais que uma linha" , obterOpcaoSelecionada(opt) );
			break;
		case 4:
			Assert.assertEquals( "Esta � a descri��o da op��o 4" , obterOpcaoSelecionada(opt) );
			break;
		case 5:
			Assert.assertEquals( "Esta � a descri��o da op��o 5" , obterOpcaoSelecionada(opt) );
			break;
		case 6:
			Assert.assertEquals( "Esta � a descri��o da op��o 6" , obterOpcaoSelecionada(opt) );
			break;
		}
		
		
	}
	
	
}
