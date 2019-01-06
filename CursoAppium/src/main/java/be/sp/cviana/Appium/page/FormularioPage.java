package be.sp.cviana.Appium.page;

import org.openqa.selenium.By;

import be.sp.cviana.Appium.core.BasePage;
import static be.sp.cviana.Appium.core.DriverFactory.getDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {
	
	
	
	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome") );
	}
	
	public void selecionarCombo(String value) {
		selecionarCombo(MobileBy.AccessibilityId("console"), value);
	}
	
	public String obterValorDoCombo() {
		return obterTexto( By.xpath("//android.widget.Spinner/android.widget.TextView") );
	}
	
	public void clicarCheck() {
		clicar( By.className("android.widget.CheckBox") );
	}
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clicar( MobileBy.AccessibilityId("switch") );
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR"); 
	}
	
	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO"); 
	}
	
	public String obterNomeCadastrado() {
		return obterTexto( By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]") );
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto( By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]") );
	}
	
	public String obterCheckCadastrado() {
		return obterTexto( By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]") );
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto( By.xpath("//android.widget.TextView[starts-with(@text,'Switch')]") );
	}
	
	public void clicarSeekBar(double pos) {
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int delta = 38;
		int xinicial = seek.getLocation().x + delta;
		int x = (int)( xinicial + ( (seek.getSize().width - 2*delta) * pos)  );
		int y = (int)( seek.getLocation().y + (seek.getSize().height / 2) );
		
		tap(x,y);
		
		salvar();
		
	}
	
	
}
