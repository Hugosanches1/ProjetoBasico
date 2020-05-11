package br.ce.automacao.testes;

import org.junit.Test;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.HomePage;
import br.ce.automacao.page.MenuPage;
import junit.framework.Assert;

public class SaldoTeste extends BaseTeste{
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void testeSaldoConta(){
		menuPage.acessarTelaPrincipal();
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
		
	}

}
