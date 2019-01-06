package be.sp.cviana.Appium.test;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.MenuPage;
import be.sp.cviana.Appium.page.SeuBarrigaDesafioPage;

public class SeuBarrigaDesafio extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SeuBarrigaDesafioPage page = new SeuBarrigaDesafioPage();
	
	
	@Before
	public void logIn() {
		menu.acessarSeuBarrigaNativo();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Seu Barriga']")));
		
		page.setEmail("sembarriga@teste.com");
		page.setSenha("123456");
		page.entrar();
		
		Assert.assertTrue( page.checkHome() );
	}
	
	
	@Test
	public void criarConta(){
		page.setConta("Tiburcio");
		Assert.assertTrue( page.checkSeContaAdicionada() );
		Assert.assertTrue( page.confirmaContaAdicionada("Tiburcio") );
		
	}
	
	@Test
	public void apagarConta() {
		page.setConta("Tiburcio");
		page.deleteConta("Tiburcio");
		Assert.assertTrue( page.checkSeContaExcluida() );
	}
	
	@Test
	public void criarMovimentacao() {
		page.acessarMovimentacao();
		page.salvar();
		
		Assert.assertTrue(page.validaDescricao());
		page.setDescricao( "Boleto teste" );
		page.salvar();
		Assert.assertTrue(page.validaInteressado());
		page.setInteressado( "Jamara" );
		page.salvar();
		Assert.assertTrue(page.validaValor());
		page.setValor( "550,00" );
		page.salvar();
		Assert.assertTrue(page.validaConta());
		
		page.setComboConta( "Conta para movimentacoes" );
		page.salvar();
		Assert.assertTrue(page.checkMovimentacaoSucesso());
	}
	
	@Test
	public void excluirMovimentacaoAtualizarSaldo() {
		page.acessarHome();
		page.scroll(0.3, 0.8);
		Assert.assertEquals( "534.00", page.getSaldo() );
	
		page.acessarResumo();
		page.atualizar();
		page.deletarMovimentacao("Movimentacao 3, calculo saldo");
		Assert.assertTrue( page.checkMovimentacaoRemovida() );
		page.atualizar();
		
		page.clicarPorTexto("HOME");
		esperaFixa(3);
		page.scroll(0.3, 0.8);
		Assert.assertEquals( "-1000.00", page.getSaldo() );
	}
	
	@After
	public void resetDataBase() {
		page.resetDataBase();
	}
	
	
}
