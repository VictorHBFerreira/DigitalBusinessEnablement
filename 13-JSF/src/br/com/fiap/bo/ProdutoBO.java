package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.Produto;

public class ProdutoBO {

	private static List<Produto> lista = new ArrayList<Produto>();

	public void cadastrar(Produto produto) {
		lista.add(produto);
	}

	public List<Produto> listar() {
		return lista;

	}

}
