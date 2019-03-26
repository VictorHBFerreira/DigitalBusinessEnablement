package br.com.fiap.loja.bo;

import org.apache.axis2.AxisFault;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public ProdutoTO consultarProduto(int codProduto) throws AxisFault {
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
		default:
			throw new AxisFault("Produto não encontrado");
		}
		return produto;
	}

}
