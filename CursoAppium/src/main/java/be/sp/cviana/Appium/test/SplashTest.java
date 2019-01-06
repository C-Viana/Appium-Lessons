package be.sp.cviana.Appium.test;

import org.junit.Assert;
import org.junit.Test;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.MenuPage;
import be.sp.cviana.Appium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		
		//Acessar splash
		menu.acessarSplash();
		
		//verificar que splash está sobre a tela
		page.isTelaSplashVisivel();
		
		//aguardar splash sumir
		page.aguardarSplashSumir();
		
		//visualizar formulário
		Assert.assertTrue( page.existeElementoPorTexto("Formulário") );
		
	}
	
	
}
