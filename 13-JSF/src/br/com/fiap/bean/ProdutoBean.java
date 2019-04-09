package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.Produto;

public class ProdutoBean {

	ProdutoBO bo;
	Produto produto;

	@PostConstruct
	public void iniciar() {
		bo = new ProdutoBO();
		produto = new Produto();
	}

	public void cadastrar() {
		bo.cadastrar(produto);
		FacesMessage msg = new FacesMessage("Produto cadastrado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Produto> listar() {
		return bo.listar();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}