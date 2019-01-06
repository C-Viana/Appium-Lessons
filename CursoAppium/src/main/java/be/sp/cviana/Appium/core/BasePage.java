package be.sp.cviana.Appium.core;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class BasePage {
	
	
	public void escrever(By by, String text) {
		getDriver().findElement(by).sendKeys(text);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void selecionarCombo(By by, String value) {
		//CLICAR NO COMBO
		getDriver().findElement(by).click();
		clicarPorTexto(value);
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorElementoELocal(double inicio, String elemento) {
		MobileElement e = getDriver().findElement( By.xpath(elemento) );
		int x = (int) (e.getLocation().x + (e.getSize().getWidth() * inicio));
		int y = e.getLocation().y + (e.getSize().getHeight()/2 );
		tap(x,y);
	}
	
	public void clicarPorTexto(String text) {
		clicar(By.xpath("//*[@text='"+text+"']"));
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']") );
		return elementos.size() > 0;
	}

	public String obterTituloAlerta() {
		return obterTexto( By.id("android:id/alertTitle") );
	}
	
	public String obterMensagemAlerta() {
		return obterTexto( By.id("android:id/message") );
	}
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
	}
	
	public void scroll(double inicio, double fim) {
		Dimension tela = getDriver().manage().window().getSize();
		int x = tela.width / 2;
		int y1 = (int)(tela.height * inicio);
		int y2 = (int)(tela.height * fim);
		
		new TouchAction(getDriver()).press( PointOption.point(x,y1) )
			.waitAction( WaitOptions.waitOptions(Duration.ofMillis(500)) )
			.moveTo( PointOption.point(x,y2) )
			.release()
			.perform();
		
	}
	
	public void scrollDown() {
		scroll(0.90, 0.10);
	}
	
	public void scrollUp() {
		scroll(0.10, 0.90);
	}
	
	public void swipe(double inicio, double fim) {
		Dimension tela = getDriver().manage().window().getSize();
		int y = tela.height / 2;
		int x1 = (int)(tela.width * inicio);
		int x2 = (int)(tela.width * fim);
		
		new TouchAction(getDriver()).press( PointOption.point(x1,y) )
			.waitAction( WaitOptions.waitOptions(Duration.ofMillis(500)) )
			.moveTo( PointOption.point(x2,y) )
			.release()
			.perform();
	}
	
	public void swipePorElemento(double inicio, double fim, String nome) {
		MobileElement size = getDriver().findElement( By.xpath( "//*[contains(@text, '"+nome+"')]/.." ) );
		
		int y = (size.getLocation().y + size.getSize().height / 2);
		int x1 = (int)(size.getLocation().x + size.getSize().width * inicio);
		int x2 = (int)(size.getLocation().x + size.getSize().width * fim);
		
		new TouchAction(getDriver()).press( PointOption.point(x1,y) )
			.waitAction( WaitOptions.waitOptions(Duration.ofMillis(500)) )
			.moveTo( PointOption.point(x2,y) )
			.release()
			.perform();
	}
	
	public void swipeLeft() {
		swipe(0.10, 0.90);
	}
	
	public void swipeRight() {
		swipe(0.90, 0.10);
	}
	
}
