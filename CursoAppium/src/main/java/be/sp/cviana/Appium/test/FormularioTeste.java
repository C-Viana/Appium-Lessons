package be.sp.cviana.Appium.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.core.DriverFactory;
import be.sp.cviana.Appium.page.FormularioPage;
import be.sp.cviana.Appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();
	
	String nome = "Buchado";
	
	@Before
	public void inicializarAppium() {
		menu.acessarFormulario();
	}
	
	@Test
	public void devePreencherNome() {
		page.escreverNome(nome);
	    Assert.assertEquals("Buchado", page.obterNome() );
	} //FIM DO METODO
	
	@Test
	public void deveInteragirCombo(){
	    page.selecionarCombo("PS4");
	    Assert.assertEquals( "PS4", page.obterValorDoCombo() );
	    
	} //FIM DO METODO
	
	
	@Test
	public void deveInteragirSwitchCheckbox() {
		Assert.assertFalse( page.isCheckMarcado() );
	    Assert.assertTrue( page.isSwitchMarcado() );
		
		page.clicarCheck();
	    page.clicarSwitch();
	    
		Assert.assertTrue( page.isCheckMarcado() );
	    Assert.assertFalse( page.isSwitchMarcado() );
	    
	} //FIM DO METODO
	
	
	@Test
	public void deveRealizarCadastro() {
	    page.escreverNome("Goon");
	    page.selecionarCombo("Nintendo Switch");
	    page.clicarCheck();
	    page.clicarSwitch();
	    page.salvar();
	    Assert.assertEquals("Nome: Goon", page.obterNomeCadastrado() );
	    Assert.assertEquals("Console: switch", page.obterConsoleCadastrado() );
	    Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off") );
	    Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado") );
	    
	}
	
	
	@Test
	public void deveRealizarCadastroDemorado() {
	    page.escreverNome("Goon");
	    DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    page.salvarDemorado();
	    
//	    esperaFixa(4000);
	    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
	    wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Goon']")) );
	    
	    Assert.assertEquals("Nome: Goon", page.obterNomeCadastrado() );
	    
	}

	@Test
	public void deveInteragirComSeekBar() {
		page.clicarSeekBar(0.09);
		esperaFixa(2);
	}
	
	@Test
	public void DeveAlterarData(){
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue( page.existeElementoPorTexto("20/01/2000") );
	}
	
	
	@Test
	public void deveAlterarHora() {
		esperaFixa(3);
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("20"));
		page.clicar(MobileBy.AccessibilityId("35"));
		
		page.clicarPorTexto("OK");
		Assert.assertTrue( page.existeElementoPorTexto("20:35") );
	}
	
	
} //FIM DA CLASSE
