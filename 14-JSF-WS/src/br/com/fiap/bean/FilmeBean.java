package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.repository.FilmeRepository;
import br.com.fiap.to.Filme;

@ManagedBean
public class FilmeBean {
	
	private Filme filme;
	private FilmeRepository repository;
	
	@PostConstruct
	public void init() {
		filme = new Filme();
		repository = new FilmeRepository();
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			repository.cadastrar(filme);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Filme> list() {
		List<Filme> busca = null;
		FacesMessage msg;
		try {
			busca = repository.listar();
		} catch (Exception e) {
			msg = new FacesMessage("Deu ruim");
			e.printStackTrace();
		}
		return busca;
	}
	
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public FilmeRepository getRepository() {
		return repository;
	}
	public void setRepository(FilmeRepository repository) {
		this.repository = repository;
	}
	
	

}
