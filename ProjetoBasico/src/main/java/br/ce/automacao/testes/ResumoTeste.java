package br.ce.automacao.testes;

import static br.ce.automacao.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.MenuPage;
import br.ce.automacao.page.ResumoPage;


//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTeste extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	ResumoPage resumoPage = new ResumoPage();	
	
	@Test
	public void test1_ExcluirMovimentacao(){
		
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}
	//@Test(expected=NoSuchElementException.class) -- Faz com que a classe espre um erro de elemento não encontrado
	@Test
	public void test2_ResumoMensal(){
		
		menuPage.acessarTelaResumo();
	
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resumoPage.selecionarAno("2018");
		resumoPage.buscar();
		
		Assert.assertTrue(resumoPage.movimentoInexistente());
		Assert.assertEquals(0, resumoPage.retornaNumMovimentos().size());
		
		List<WebElement> elementosEncontrados = resumoPage.retornaNumMovimentos();
		Assert.assertEquals(0, elementosEncontrados.size());
	}

}
