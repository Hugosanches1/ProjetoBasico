package br.ce.automacao.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.ce.automacao.core.BasePage;
import br.ce.automacao.core.DriverFactory;

public class ResumoPage extends BasePage {
	public void excluirMovimentacao(){
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	public Boolean movimentoInexistente(){
		try {
			DriverFactory.getDriver().findElement(By.xpath("//*[@id ='tabelaExtrato']/tbody/tr"));
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}	
	}
	public List<WebElement> retornaNumMovimentos(){
			return ListaMovimentos(By.xpath("//*[@id ='tabelaExtrato']/tbody/tr"));	
	}
	public void selecionarAno(String ano){
		selecionarCombo("ano", ano);
	}
	public void buscar(){
		clicarBotao(By.xpath("//input[@value='Buscar']"));
	}
	
}
