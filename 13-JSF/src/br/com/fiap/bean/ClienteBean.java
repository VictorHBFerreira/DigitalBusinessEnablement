package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.Cliente;

@ManagedBean
public class ClienteBean {

	private Cliente cliente;
	
	private ClienteBO bo;
	
	@PostConstruct//petodo que é executado antes de tudo
	public void iniciar() {
		bo = new ClienteBO();
		cliente = new Cliente();
		
	}
	
	public void cadastrar() {
		bo.cadastrar(cliente);
		FacesMessage msg = new FacesMessage("Usuario cadastrado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	
	
	
	public List<Cliente> listar(){
		return bo.listar();
	}

	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
