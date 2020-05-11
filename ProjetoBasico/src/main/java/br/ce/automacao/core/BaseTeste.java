package br.ce.automacao.core;

import static br.ce.automacao.core.DriverFactory.getDriver;
import static br.ce.automacao.core.DriverFactory.killDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.automacao.page.LoginPage;


public class BaseTeste {
	
	@Rule
	public TestName testName = new TestName();
	
	private LoginPage loginPage = new LoginPage();
	
	@Before
	public  void inicializa(){
		loginPage.acessarTelaInicial();
		
		loginPage.setEmail("hugo@hotmail.com");
		loginPage.setSenha("hugo");
		loginPage.entrar();
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo,new File(
				"target" + File.separator + "screenshots" + 
				File.separator + testName.getMethodName() + ".jpg"));
		if (Propriedades.FECHAR_BROWSER){
			killDriver();
		}
	}

}
