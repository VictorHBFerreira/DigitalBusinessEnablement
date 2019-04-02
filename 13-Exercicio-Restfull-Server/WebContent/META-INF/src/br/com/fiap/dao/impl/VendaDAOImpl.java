package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VendaDAO;
import br.com.fiap.entity.Venda;

public class VendaDAOImpl extends GenericDAOImpl<Venda, Integer> implements VendaDAO{

	public VendaDAOImpl(EntityManager em) {
		super(em);
	}

}
