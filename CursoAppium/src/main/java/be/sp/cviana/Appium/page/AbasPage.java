package be.sp.cviana.Appium.page;

import org.openqa.selenium.By;

import be.sp.cviana.Appium.core.BasePage;

public class AbasPage extends BasePage {
	
	public boolean isAba1() {
		return existeElementoPorTexto("ABA 1");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("ABA 2");
	}
	
	public void selecionarAba1() {
		clicarPorTexto("ABA 1");
	}
	
	public void selecionarAba2() {
		clicarPorTexto("ABA 2");
	}
	
	public String obterTextoAba1() {
		return obterTexto( By.xpath("//*[@text='Este é o conteúdo da Aba 1']") );
	}
	
	public String obterTextoAba2() {
		return obterTexto( By.xpath("//*[@text='Este é o conteúdo da Aba 2']") );
	}
	
}
