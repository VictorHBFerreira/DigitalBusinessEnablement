package br.com.fiap.revisao.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.bean.Pessoa;

public class ColecaoTeste {

	public static void main(String args[]) {
		//criar uma lista
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		//adicionar elementos na lista
		lista.add(new Funcionario("Thiago"));
		lista.add(new Pessoa("Rodrigo"));
		
		//percorrer a lista
		System.out.println("LIST");
		for (Pessoa p : lista) {
			System.out.println(p.getNome());			
		}
		
		//criar um set e adicionar valores
		Set<String> set = new HashSet<>();
		set.add("Alice");
		set.add("Rafael");
		set.add("Rafael");
		
		System.out.println("SET");
		for (String s : set) {
			System.out.println(s);
		}
		
		//criar um map
		Map<String, Pessoa> map = new HashMap<>();
		//adicionar valores para o mapa
		map.put("gerente", new Funcionario("Rita"));
		map.put("cliente", new Pessoa("Ronaldo"));
		
		System.out.println("MAP");
		Pessoa p = map.get("gerente");
		System.out.println(p.getNome());
		
	}

}


