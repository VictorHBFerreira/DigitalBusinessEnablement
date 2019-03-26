package br.com.fiap.loja.singleton;

import java.io.IOException;
import java.util.Properties;

public class LojaSingleton {

	private static Properties p;
	
	private LojaSingleton() {}
	
	public static Properties getInstance() {
		if (p == null) {
			p = new Properties();
			try {
				p.load(LojaSingleton.class
						.getResourceAsStream("/fiap.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
