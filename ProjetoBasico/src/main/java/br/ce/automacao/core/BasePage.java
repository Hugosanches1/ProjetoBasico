package br.ce.automacao.core;

import static br.ce.automacao.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	public List<WebElement> obterValorcombolista;

	public void escrever(String id, String texto) {
		getDriver().findElement(By.id(id)).clear();
		getDriver().findElement(By.id(id)).sendKeys(texto);
	}

	public String obtemValor(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}


	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> obterValorcombolista(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> elementos = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : elementos) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	public void clicarBotao(String id) {
		clicarBotao(id);
	}
	public void clicarBotao(By by){
		getDriver().findElement(by).click();
	}
	public void clicarBotaoPorTexto(String texto){
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}

	public void ClicarLink(String id) {
		getDriver().findElement(By.linkText(id)).click();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	public List<WebElement> ListaMovimentos(By by) {
		return getDriver().findElements(by);
	}

	public boolean comparaValores(String esperado, String id) {
		String real = obtemValor(id);
		if (esperado == real) {
			return true;
		} else {
			return false;
		}
	}

	public String obterVelueElemento(String id) {
		return getDriver().findElement(By.id("id")).getAttribute("value");
	}

	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		return texto;
	}

	public String alertaObterTextoENega() {
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		alert.dismiss();
		return texto;
	}

	public Object executasJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);

	}

	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}

	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}

	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}

	/*********** Tabelas ***********/

	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// Procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='" + idTabela + "']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// Procurar linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// procurar coluna botão
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botao da linha encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
			WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
			celula.findElement(By.xpath(".//input")).click();
	}
	
	

	private int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}

	private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}
	/************* Prime Faces ********/
	public void selecionarComboPrime(String radical, String valor){
		clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
	}
}
