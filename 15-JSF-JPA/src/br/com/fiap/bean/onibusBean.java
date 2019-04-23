package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.OnibusDAO;
import br.com.fiap.dao.impl.OnibusDAOImpl;
import br.com.fiap.entity.Onibus;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@ViewScoped
public class onibusBean implements Serializable{
	
	private Onibus onibus;
	private OnibusDAO onibusDAO;
	
	@PostConstruct
	public void init() {
		onibus = new Onibus();
		onibusDAO = new OnibusDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
		onibus.setDataFabricacao(Calendar.getInstance());
	}
	
	
	
	

	public List<Onibus> listar(){	
		try {			
			return onibusDAO.listar();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			onibusDAO.cadastrar(onibus);
			msg = new FacesMessage("Atualizado");
			onibusDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Deu ruim!");			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void atualizar() {
		FacesMessage msg;
		try {
			onibusDAO.atualizar(onibus);
			msg = new FacesMessage("Atualizado");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Deu ruim!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}		

	public void remover(int codigo) {
		FacesMessage msg;
		try {
			onibusDAO.remover(codigo);
			msg = new FacesMessage("Atualizado");
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			msg = new FacesMessage("Deu ruim!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}	
	
	public onibusBean(Onibus onibus, OnibusDAO onibusDAO) {
		super();
		this.onibus = onibus;
		this.onibusDAO = onibusDAO;
	}
	
	public onibusBean() {
		super();
	}
	public onibusBean(Onibus onibus) {
		super();
		this.onibus = onibus;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
