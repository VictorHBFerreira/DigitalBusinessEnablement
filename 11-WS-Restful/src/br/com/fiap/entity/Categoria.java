package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CATEGORIA")
@SequenceGenerator(name="categoria",sequenceName="SQ_T_CATEGORIA",allocationSize=1)
public class Categoria {

	@Id
	@Column(name="cd_categoria")
	@GeneratedValue(generator="categoria",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_categoria")
	private String nome;
	
	@Column(name="ds_classificacao")
	private int classificacao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
}
