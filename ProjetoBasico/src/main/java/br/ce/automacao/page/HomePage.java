package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String nome){
			return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
}



