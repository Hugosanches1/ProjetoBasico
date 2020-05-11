package br.ce.automacao.testes;

import org.junit.Test;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.core.Propriedades;
import br.ce.automacao.page.ContasPage;
import br.ce.automacao.page.MenuPage;
import junit.framework.Assert;

public class RemoverMovimentacaoContaTeste extends BaseTeste {
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	@Test
	public void testeExcluirContaMovimentacao(){
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");

		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
