package br.com.fiap.loja.view;

import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o código:");
		int codigo = sc.nextInt();
		
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			
			//Valores para o web service
			ConsultarProduto parametros = new ConsultarProduto();
			parametros.setCodProduto(codigo);
			
			//Chama o web service
			ConsultarProdutoResponse resposta =
						stub.consultarProduto(parametros);
			
			//Exibe o resultado
			ProdutoTO produto = resposta.get_return();
			System.out.println(produto.getDescricao());
			System.out.println("Preço:" + produto.getPreco());
			System.out.println("QTD:" + produto.getQuantidade());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}




