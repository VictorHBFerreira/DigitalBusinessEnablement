package br.com.fiap.revisao.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.bean.Genero;

public class FuncionarioTeste {

	public static void main(String[] args) {
		//Instanciar um funcionário
		Funcionario func = new Funcionario("Fernando");
		//Atribuir uma data de admissão
		Calendar data = Calendar.getInstance();//DATA ATUAL
		Calendar data2 = new GregorianCalendar(2018, Calendar.JANUARY, 20);
		func.setDataAdmissao(data);
		
		//objeto para formatar a data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//exibir a data			
		System.out.println(sdf.format(data2.getTime()));
		
		//exibir o genero
		System.out.println(func.getGenero());
		
		//atribuir um valor para o genero
		func.setGenero(Genero.MASCULINO);
		
	}

}






