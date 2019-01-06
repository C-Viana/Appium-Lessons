package be.sp.cviana.Appium.test;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.MenuPage;

public class OpcaoEscondidaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		
		menu.scrollDown();
		menu.acessarOpcaoEscondida();
		Assert.assertEquals("Sucesso",menu.obterTituloAlerta());
		Assert.assertEquals("Você achou essa opção",menu.obterMensagemAlerta());
		menu.clicarPorTexto("OK");
		
	}
	
	
	
}
