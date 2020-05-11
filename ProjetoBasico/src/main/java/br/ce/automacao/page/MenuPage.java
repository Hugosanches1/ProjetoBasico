package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta(){
		ClicarLink("Contas");
		ClicarLink("Adicionar");
	}
	public void acessarTelaListarConta(){
		ClicarLink("Contas");
		ClicarLink("Listar");
	}
	public void acessarTelaInserirMovimentacao(){
		ClicarLink("Criar Movimentação");
	}
	public void acessarTelaResumo(){
		ClicarLink("Resumo Mensal");
	}
	public void acessarTelaPrincipal(){
		ClicarLink("Home");
	}

}
