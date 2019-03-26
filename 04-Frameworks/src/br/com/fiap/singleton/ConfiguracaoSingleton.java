package br.com.fiap.singleton;

import java.util.Properties;

public class ConfiguracaoSingleton {

	//1- atributo estático que será único na aplicação
	private static Properties prop;
	
	//2- Construtor privado
	private ConfiguracaoSingleton() {}
	
	//3- Método estático getInstance
	public static Properties getInstance() {
		if (prop == null) {
			prop = new Properties();
			try {
				//carregar o objeto com os dados do arquivo
				prop.load(ConfiguracaoSingleton
					.class.getResourceAsStream("/configuracao.properties"));
			}catch(Exception e) {
				e.printStackTrace();				
			}
		}
		return prop;
	}
	
}





