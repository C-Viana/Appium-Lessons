package be.sp.cviana.Appium.test;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.MenuPage;

public class SwipeTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		
		menu.acessarSwipe();
		
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		menu.swipeRight();
		
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		menu.clicarPorTexto("�");
		
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar at� o fim!"));
		
		menu.swipeLeft();
		
		menu.clicarPorTexto("�");
		
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
	}
	
	
	@Test
	public void desafioSwipe() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		menu.scroll(0.6, 0.2);
		//Clicar no Swipe List
		menu.acessarSwipeList(); 
		//Fazer swipe � esquerda na op��o 1
		menu.swipePorElemento(0.9, 0.3, "Op��o 1");
		//clicar no bot�o +
		//menu.clicarPorTexto("(+)");
		menu.clicarPorElementoELocal(0.1, "//*[@text='(+)']");
		//Verificar opt+
		Assert.assertTrue( menu.existeElementoPorTexto("Op��o 1 (+)"));
		//opt4 � esquerda
		menu.swipePorElemento(0.9, 0.3, "Op��o 4");
		//Clicar em - e validar
		menu.clicarPorElementoELocal(0.1, "//*[@text='(-)']");
		Assert.assertTrue( menu.existeElementoPorTexto("Op��o 4 (-)"));
		//opt5 � direita e  verificar
		menu.swipePorElemento(0.3, 0.9, "Op��o 5");
		Assert.assertTrue( menu.existeElementoPorTexto("Op��o 5"));
		
	}
	
}
