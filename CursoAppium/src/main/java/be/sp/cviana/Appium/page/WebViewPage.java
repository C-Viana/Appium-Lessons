package be.sp.cviana.Appium.page;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import be.sp.cviana.Appium.core.BasePage;

public class WebViewPage extends BasePage {
	
	
	public void entrarContextoWeb() {
		Set<String> contexts = getDriver().getContextHandles();
		for(String context : contexts) {
			System.out.println(context);
		}
		getDriver().context( (String) contexts.toArray()[1] );
	}
	
	public void setEmail(String email) {
		getDriver().findElement(By.id("email")).sendKeys(email);;
	}
	
	public void setSenha(String senha) {
		getDriver().findElement(By.id("senha")).sendKeys(senha);;
	}
	
	public void entrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void sairContextoWeb() {
		getDriver().context( (String) getDriver().getContextHandles().toArray()[0] );
	}
	
}
