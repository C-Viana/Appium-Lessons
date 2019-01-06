package be.sp.cviana.Appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.CliquesPage;
import be.sp.cviana.Appium.page.MenuPage;


public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	
	@Before
	public void acessarCliques() {
		menu.acessarCliques();
	}
	
	
	@Test
	public void deveRealizarCliqueLongo() {
		
		page.cliqueLongo();
		Assert.assertEquals( "Clique Longo", page.obterTextoCampo() );
		
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		esperaFixa(0.005f);
		page.clicarPorTexto("Clique duplo");
		Assert.assertEquals( "Duplo Clique", page.obterTextoCampo() );
	}
	
	
	
}
