package br.com.fiap.bean;

import javax.faces.bean.ManagedBean; //SE IMPORTAR O OUTRO VOCE NÃO PASSA DE ANO

@ManagedBean
public class IndexBean {
		
	private String nome;
	
	public void ok() {
		System.out.println(nome);
	}
	
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
