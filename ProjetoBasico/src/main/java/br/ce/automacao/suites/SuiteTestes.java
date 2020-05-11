package br.ce.automacao.suites;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.automacao.core.DriverFactory;
import br.ce.automacao.page.LoginPage;
//import br.ce.automacao.core.DriverFactory;
//import br.ce.automacao.page.LoginPage;
import br.ce.automacao.testes.ContaTeste;
import br.ce.automacao.testes.MovimentacaoTeste;
import br.ce.automacao.testes.RemoverMovimentacaoContaTeste;
import br.ce.automacao.testes.ResumoTeste;
import br.ce.automacao.testes.SaldoTeste;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTeste.class,
	MovimentacaoTeste.class,
	RemoverMovimentacaoContaTeste.class,
	SaldoTeste.class,
	ResumoTeste.class
})
public class SuiteTestes {
	public static LoginPage page = new LoginPage();
	@BeforeClass
	public static void reset(){
		page.acessarTelaInicial();
		page.logar("hugo@hotmail.com", "hugo");
		
		page.resetar();
		
		DriverFactory.killDriver();
		
		
	}
	
}
