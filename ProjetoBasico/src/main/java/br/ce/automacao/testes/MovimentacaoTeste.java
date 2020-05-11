package br.ce.automacao.testes;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.automacao.Utils.DataUtils;
import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.MenuPage;
import br.ce.automacao.page.MovimentacaoPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTeste{
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_inserirMovimentacao(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Teste de Movimento");
		movPage.setInteressado("Interessado do Teste");
		movPage.setValor("3400");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	
	}
	@Test
	public void test2_CamposObrigatorios(){
	menuPage.acessarTelaInserirMovimentacao();
	
	movPage.salvar();
	
	List<String> erros = movPage.obterErros();
	Assert.assertTrue(erros.containsAll(Arrays.asList(
			"Data da Movimentação é obrigatório",
			"Data do pagamento é obrigatório",
			"Descrição é obrigatório",
			"Interessado é obrigatório",
			"Valor é obrigatório",
			"Valor deve ser um número"
			)));
	Assert.assertEquals(6, erros.size());
		
	}
	@Test
	public void test3_inserirMovimentacaoFutura(){
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Teste de Movimento");
		movPage.setInteressado("Interessado do Teste");
		movPage.setValor("3400");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();	
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains(
				"Data da Movimentação deve ser menor ou igual à data atual"
				));
		Assert.assertEquals(1, erros.size());
		
		
		
	}
}
