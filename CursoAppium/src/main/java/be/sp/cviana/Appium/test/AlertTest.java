package be.sp.cviana.Appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.AlertaPage;
import be.sp.cviana.Appium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	
	@Before
	public void acessarAlertas() {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		
		//clicar em alerta confirm
		page.clicarAlertaConfirm();
		//verificar os textos
		Assert.assertEquals( "Info", page.obterTituloAlerta() );
		Assert.assertEquals( "Confirma a operação?", page.obterMensagemAlerta() );
		//confirmar o alerta
		page.confirmar();
		//verificar nova mensagem
		Assert.assertEquals( "Confirmado", page.obterMensagemAlerta() );
		//sair
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		page.clicarAlertaSimples();
		esperaFixa(2);
		page.clicarForaCaixa();
		Assert.assertFalse( page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair") );
	}
	
	
}
