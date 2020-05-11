package br.ce.automacao.page;

import static br.ce.automacao.core.DriverFactory.getDriver;
import br.ce.automacao.core.BasePage;

public class LoginPage extends BasePage {
	public void acessarTelaInicial(){
		System.setProperty("webdriver.gecko.driver", "/Devtools/Drivers/geckodriver.exe");
		getDriver().get("https://seubarriga.wcaquino.me");
	}
	public void setEmail(String email){
		escrever("email", email);
	}
	public void setSenha(String senha){
		escrever("senha", senha);
	 }
	public void entrar(){
		clicarBotaoPorTexto("Entrar");
	}
	public void logar(String email, String senha){
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	public void resetar(){
		ClicarLink("reset");
	}
}
