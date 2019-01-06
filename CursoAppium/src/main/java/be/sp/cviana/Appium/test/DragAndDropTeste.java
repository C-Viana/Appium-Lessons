package be.sp.cviana.Appium.test;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import be.sp.cviana.Appium.core.BaseTest;
import be.sp.cviana.Appium.page.DragAndDropPage;
import be.sp.cviana.Appium.page.MenuPage;

public class DragAndDropTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragAndDropPage page = new DragAndDropPage();
	
	private String[] estadoInicial = new String[] {"Esta","� uma lista","Drag em Drop!","Fa�a um clique longo,","e arraste para", "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,","� uma lista","Drag em Drop!","e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void deveEfetuarDragAndDrop() {
		
		WebDriverWait wait = new WebDriverWait(getDriver(),10);
		wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")) );
		
		menu.scrollDown();
		
		menu.acessarDragAndDrop();
		
		esperaFixa(2);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		page.arrastar("Esta", "e arraste para");
		page.arrastar("Fa�a um clique longo,", "� uma lista");
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
		
	}
	
	
}
