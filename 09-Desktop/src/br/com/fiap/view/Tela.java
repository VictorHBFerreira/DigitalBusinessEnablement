package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNumero1;
	private Text txtNumero2;
	private Text txtCepOrigem;
	private Text txtCepDestino;
	private Text txtPrazo;
	private Text txtDataMaxima;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNmero = new Label(shell, SWT.NONE);
		lblNmero.setBounds(32, 36, 55, 15);
		lblNmero.setText("N\u00FAmero 1");
		
		txtNumero1 = new Text(shell, SWT.BORDER);
		txtNumero1.setBounds(93, 33, 76, 21);
		
		Label lblNmero_1 = new Label(shell, SWT.NONE);
		lblNmero_1.setBounds(32, 75, 55, 15);
		lblNmero_1.setText("N\u00FAmero 2");
		
		txtNumero2 = new Text(shell, SWT.BORDER);
		txtNumero2.setBounds(93, 72, 76, 21);
		
		Label lblResposta = new Label(shell, SWT.NONE);
		lblResposta.setBounds(32, 152, 55, 15);

		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//clique do botão
				int numero1 = Integer.parseInt(txtNumero1.getText());
				int numero2 = Integer.parseInt(txtNumero2.getText());
				lblResposta.setText(Integer.toString(numero1+numero2));
			}
		});
		
		btnCalcular.setBounds(93, 110, 75, 25);
		btnCalcular.setText("Calcular");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(205, 10, 2, 241);
		
		Label lblCepOrigem = new Label(shell, SWT.NONE);
		lblCepOrigem.setBounds(224, 36, 66, 15);
		lblCepOrigem.setText("CEP Origem");
		
		txtCepOrigem = new Text(shell, SWT.BORDER);
		txtCepOrigem.setBounds(307, 33, 76, 21);
		
		Label lblCepDestino = new Label(shell, SWT.NONE);
		lblCepDestino.setBounds(224, 75, 66, 15);
		lblCepDestino.setText("CEP Destino");
		
		txtCepDestino = new Text(shell, SWT.BORDER);
		txtCepDestino.setBounds(307, 72, 76, 21);
		
		Label lblPrazo = new Label(shell, SWT.NONE);
		lblPrazo.setBounds(224, 171, 55, 15);
		lblPrazo.setText("Prazo");
		
		Label lblDataMxima = new Label(shell, SWT.NONE);
		lblDataMxima.setBounds(224, 206, 76, 15);
		lblDataMxima.setText("Data M\u00E1xima");
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setEnabled(false);
		txtPrazo.setBounds(307, 165, 76, 21);
		
		txtDataMaxima = new Text(shell, SWT.BORDER);
		txtDataMaxima.setEnabled(false);
		txtDataMaxima.setBounds(307, 203, 76, 21);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					
					CalcPrazo parametros = new CalcPrazo();
					//parametros.setNCdServico("40010");
					parametros.setSCepDestino(txtCepDestino.getText());
					parametros.setSCepOrigem(txtCepOrigem.getText());
					
					CalcPrazoResponse resp = stub.calcPrazo(parametros);
					
					txtPrazo.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega() + " dias");
					txtDataMaxima.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
					
				} catch (Exception e1) {
					e1.printStackTrace();
					MessageBox dialog = new MessageBox(shell);
					dialog.setMessage("Erro.. tente mais tarde");
					dialog.open();
				}
			}
		});
		btnPesquisar.setBounds(308, 110, 75, 25);
		btnPesquisar.setText("Pesquisar");
	}
}
