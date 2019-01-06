package be.sp.cviana.Appium.test;

import org.junit.Test;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.AccordionPage;
import be.sp.cviana.Appium.page.MenuPage;

public class AccordionTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	
	@Test
	public void deveInteragirComAccordion() {
		menu.acessarAccordion();
		
		int total = page.getTotalOpcoes();
		
		for(int i=1; i<total+1; i++) {
			page.acessarOpcao(i);
			//esperaFixa(3);
			page.validaOpcoes(i);
		}
		
	}
	
	
}
