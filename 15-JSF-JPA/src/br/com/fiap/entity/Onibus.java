package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="onibus", sequenceName="SQ_ONIBUS", allocationSize=1)
@Table(name="T_ONIBUS")
public class Onibus {
	
	@Id
	@GeneratedValue(generator="onibus",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_onibus")
	private int id;	
	
	@Column(name="nm_onibus")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fabricacao")
	private Calendar dataFabricacao;
	
	@Column(name="st_operando") //st de status
	private boolean operando;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public boolean isOperando() {
		return operando;
	}

	public void setOperando(boolean operando) {
		this.operando = operando;
	}

}
