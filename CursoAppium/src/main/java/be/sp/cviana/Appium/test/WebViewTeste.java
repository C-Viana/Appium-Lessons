package be.sp.cviana.Appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.MenuPage;
import be.sp.cviana.Appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
//	login.setEmail("sem.barriga_teste@teste.com"); 
//	login.setSenha("123456");
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		menu.acessarSeuBarrigaHibrido();
		esperaFixa(5);
		page.entrarContextoWeb();
		page.setEmail("sem.barriga_teste@teste.com");
		page.setSenha("123456");
		page.entrar();
		Assert.assertEquals("Bem vindo, Sem Barriga!", page.getMensagem());
	}
	
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
	
}
