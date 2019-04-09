package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.Cliente;

public class ClienteBO {
	private static List<Cliente> lista = new ArrayList<Cliente>();
	
	public void cadastrar(Cliente cliente) {
		lista.add(cliente);
	}
	public List<Cliente> listar(){
		return lista;
		
	}

	
}
