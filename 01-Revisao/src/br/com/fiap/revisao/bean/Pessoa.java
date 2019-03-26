package br.com.fiap.revisao.bean;

public class Pessoa {

	/* Modificadores de acesso 
	 * public, private	
	 * protected - filhas e pacote  
	 * default/package - pacote
	 */
	private String nome;
	
	private Genero genero;
	
	protected long rm;
	
	// 1- Mesmo nome da classe, 
	// 2- Não tem retorno (nem void)
	// 3- Chamar um construtor do pai (1 linha)
	public Pessoa() {
		super(); //chama o construtor vazio do pai
	}
	
	public boolean validarRm() {
		String rmStr = String.valueOf(rm);
		if (rmStr.length() == 5) {
			return true;
		}else {
			return false;
		}
	}
	
	public Pessoa(String nome) {
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getRm() {
		return rm;
	}

	public void setRm(long rm) {
		this.rm = rm;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}