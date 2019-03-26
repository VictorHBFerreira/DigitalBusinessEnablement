package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_FILME")
@SequenceGenerator(name="filme",sequenceName="SQ_T_FILME",allocationSize=1)
public class Filme {

	@Id
	@Column(name="cd_filme")
	@GeneratedValue(generator="filme",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_filme", nullable=false)
	private String nome;
	
	@Column(name="vl_duracao")
	private float duracao;
	
	@Column(name="st_cartaz")
	private boolean cartaz;
	
	public Filme() {
		super();
	}

	public Filme(int codigo, String nome, float duracao, boolean cartaz) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.duracao = duracao;
		this.cartaz = cartaz;
	}

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

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public boolean isCartaz() {
		return cartaz;
	}

	public void setCartaz(boolean cartaz) {
		this.cartaz = cartaz;
	}
	
}