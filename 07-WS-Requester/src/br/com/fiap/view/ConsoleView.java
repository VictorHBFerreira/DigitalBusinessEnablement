package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.ImpostoBOStub;
import br.com.fiap.bo.ImpostoBOStub.CalcularIRPF;
import br.com.fiap.bo.ImpostoBOStub.CalcularIRPFResponse;

public class ConsoleView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			//Criar o objeto que acessa o web service
			ImpostoBOStub stub = new ImpostoBOStub();
			
			//Objeto que armazena os valores enviados para o servidor
			CalcularIRPF valores = new CalcularIRPF();
			System.out.print("Digite a renda: ");
			valores.setRenda(sc.nextDouble());
			
			//chama o web service
			CalcularIRPFResponse resp = stub.calcularIRPF(valores);
			
			System.out.println("Imposto é " + resp.get_return());
			  
		} catch (Exception e) {
			System.err.println("Por favor, tente mais tarde.");
			e.printStackTrace();
		}
		sc.close();
	}
	
}





