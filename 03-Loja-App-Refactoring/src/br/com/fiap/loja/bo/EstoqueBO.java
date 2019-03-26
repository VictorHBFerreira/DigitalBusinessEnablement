package br.com.fiap.loja.bo;

import org.apache.log4j.Logger;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	private static Logger log = Logger.getLogger(EstoqueBO.class);
	
	public ProdutoTO consultarProduto(int codProduto) {
		log.debug("Pesquisando por produto de código " + codProduto);
		ProdutoTO produto = null;
		switch (codProduto) {
		case 401:
			produto = new ProdutoTO(401, 10, 5, "Camiseta Branca");
			break;
		case 402:
			produto = new ProdutoTO(402, 20, 10, "Camiseta Azul");
			break;
		case 403:
			produto = new ProdutoTO(403, 21, 12, "Camiseta Rosa");
			break;
		}
		return produto;
	}
	
}
