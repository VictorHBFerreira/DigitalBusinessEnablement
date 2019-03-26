package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreiosView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Ler dois CEPs
		System.out.print("CEP Origem:");
		String cepOrigem = sc.next();
		System.out.print("CEP Destino:");
		String cepDestino = sc.next();
		String servico = "40010"; //SEDEX VAREJO
		
		try {
			//Calcular o prazo de entrega
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			//Parametros para enviar ao web service
			CalcPrazo parametros = new CalcPrazo();
			parametros.setNCdServico(servico);
			parametros.setSCepDestino(cepDestino);
			parametros.setSCepOrigem(cepOrigem);
			
			//Chama o web service e armazena a resposta
			CalcPrazoResponse resposta = stub.calcPrazo(parametros);
			
			String prazo = resposta.getCalcPrazoResult()
				.getServicos().getCServico()[0].getPrazoEntrega();
			
			String dataMaxima = resposta.getCalcPrazoResult()
				.getServicos().getCServico()[0].getDataMaxEntrega();
					
			System.out.println("Prazo: " + prazo);
			System.out.println("Data máxima: " + dataMaxima);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}

