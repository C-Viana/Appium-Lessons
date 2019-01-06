package be.sp.cviana.Appium.test;

import org.junit.Assert;
import org.junit.Test;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.AbasPage;
import be.sp.cviana.Appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	
	
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		//Acessar menu abas
		menu.acessarAbas();
		//Certificar-se da aba 1
		if( page.isAba1() ) {
			page.selecionarAba1();
			//Verificar que esta na aba 1
			Assert.assertEquals("Este é o conteúdo da Aba 1", page.obterTextoAba1() );
			//Acessar aba 2
			page.clicarPorTexto("ABA 2");
			if( page.isAba1() ) {
				//Verificar que está na aba 2
				Assert.assertEquals("Este é o conteúdo da Aba 2", page.obterTextoAba2() );
			}
		}
		
		
		
	}
	
	
	
	
}
