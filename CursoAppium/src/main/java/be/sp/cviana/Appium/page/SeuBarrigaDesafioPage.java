package be.sp.cviana.Appium.page;

import static be.sp.cviana.Appium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;

import be.sp.cviana.Appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SeuBarrigaDesafioPage extends BasePage {
	
	
	public void setEmail(String email) {
		escrever(By.xpath("//*[@text='Nome']"), email);
	}
	
	public void setSenha(String senha) {
		escrever(By.xpath("//*[@text='Senha']"), senha);
	}
	
	public void entrar() {
		clicarPorTexto("ENTRAR");
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void excluir() {
		clicarPorTexto("EXCLUIR");
	}
	
	public void atualizar() {
		clicarPorTexto("ATUALIZAR");
	}
	
	public void deletarMovimentacao(String movimentacao) {
		swipePorElemento(0.9, 0.5, movimentacao);
		clicarPorTexto("Del");
	}
	
	public void setConta(String nome) {
		acessarContas();
		escrever(By.xpath("//*[@text='Conta']"),nome);
		salvar();
	}
	
	public void deleteConta(String conta) {
		acessarContas();
		new TouchAction(getDriver())
			.longPress(LongPressOptions.longPressOptions()
					.withElement(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='"+conta+"']"))))
						.withDuration(Duration.ofMillis(2000)) ).perform();
		excluir();
	}
	
	public void acessarHome() {
		clicarPorTexto("HOME");
	}
	
	public void acessarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacao() {
		clicarPorTexto("MOV...");
	}
	
	public void acessarResumo() {
		clicarPorTexto("RESUMO");
	}
	
	public void setDescricao(String descricao) {
		escrever(By.xpath("//*[@text='Descrição']"), descricao );
	}
	
	public void setInteressado(String nome) {
		escrever(By.xpath("//*[@text='Interessado']"), nome );
	}
	
	public void setValor(String valor) {
		escrever(By.xpath("//*[@text='Valor']"), valor );
	}
	
	public void setComboConta(String movimentacao) {
		selecionarCombo( By.xpath("//*[@text='Selecione uma conta...']"), movimentacao );
	}
	
	public boolean checkHome() {
		return existeElementoPorTexto("HOME");
	}
	
	public boolean checkSeContaAdicionada() {
		return existeElementoPorTexto("Conta adicionada com sucesso");
	}
	
	public boolean checkSeContaExcluida() {
		return existeElementoPorTexto("Conta excluída com sucesso");
	}
	
	public boolean confirmaContaAdicionada(String conta) {
		return existeElementoPorTexto(conta);
	}
	
	public boolean validaDescricao() {
		return existeElementoPorTexto("Descrição é um campo obrigatório");
	}
	
	public boolean validaInteressado() {
		return existeElementoPorTexto("Interessado é um campo obrigatório");
	}
	
	public boolean validaValor() {
		return existeElementoPorTexto("Valor é um campo obrigatório");
	}
	
	public boolean validaConta() {
		return existeElementoPorTexto("Conta é um campo obrigatório");
	}
	
	public boolean checkMovimentacaoSucesso() {
		return existeElementoPorTexto("Movimentação cadastrada com sucesso");
	}
	
	public boolean checkMovimentacaoRemovida() {
		return existeElementoPorTexto("Movimentação removida com sucesso!");
	}
	
	public String getSaldo() {
		return obterTexto(By.xpath("//*[@text='Conta para saldo']/following-sibling::android.widget.TextView"));
	}
	
	public void resetDataBase() {
		clicarPorTexto("HOME");
		clicarPorTexto("RESET");
	}
	
}
