package br.com.fiap.teste;

import org.apache.log4j.Logger;

import br.com.fiap.singleton.ConfiguracaoSingleton;

public class Teste {

	private static Logger log = Logger.getLogger(Teste.class);
	
	public static void main(String[] args) {
		
		log.info("Iniciando a aplicação");
		
		//recuperar a configuração de idioma
		String idioma = ConfiguracaoSingleton.getInstance().getProperty("ambiente");
		
		log.warn("Recuperando a configuração do sistema");
		
		System.out.println(idioma);
	}
	
}

