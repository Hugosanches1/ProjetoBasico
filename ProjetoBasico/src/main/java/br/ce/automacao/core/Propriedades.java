package br.ce.automacao.core;

public class Propriedades {
	public static boolean FECHAR_BROWSER = true;
	
	public static Browser BROWSER = Browser.FIREFOX;
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;
	public enum Browser{
		CHROME,
		FIREFOX
	}
	public enum TipoExecucao{
		LOCAL,
		GRID,
		NUVEM
	}
}
