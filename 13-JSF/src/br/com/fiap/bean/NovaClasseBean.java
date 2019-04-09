package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NovaClasseBean {
	
	private String usuario;
	private String senha;
	
	public void logar() {
		if (usuario.equals("FIAP") && senha.equals("FIAP2019")) {
			System.out.println("Logado");
		}else {
			System.out.println("Deu ruim!");
		}
	}
	
	
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
