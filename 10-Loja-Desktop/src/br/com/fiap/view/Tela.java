package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtCodigo;
	private Table table;

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
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(20, 26, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(81, 23, 76, 21);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Recuperar o valor digitado pelo usuário
				int codigo = Integer.parseInt(txtCodigo.getText());
				try {
					//Chamar o web service
					EstoqueBOStub stub = new EstoqueBOStub();
					
					ConsultarProduto valores = new ConsultarProduto();
					valores.setCodProduto(codigo);
					
					ConsultarProdutoResponse resp =
									stub.consultarProduto(valores);
					
					ProdutoTO produto = resp.get_return();
					
					table.removeAll();
					
					//Exibe o resultado em um tabela
					TableItem item = new TableItem(table, 0);
					
					item.setText(new String[] 
							{ produto.getDescricao(),
							  Integer.toString(produto.getQuantidade()),
							  String.valueOf(produto.getPreco())
							});
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(164, 21, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(20, 69, 312, 91);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnDescrio = new TableColumn(table, SWT.NONE);
		tblclmnDescrio.setWidth(100);
		tblclmnDescrio.setText("Descri\u00E7\u00E3o");
		
		TableColumn tblclmnQuantidade = new TableColumn(table, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");
		
		TableColumn tblclmnPreo = new TableColumn(table, SWT.NONE);
		tblclmnPreo.setWidth(100);
		tblclmnPreo.setText("Pre\u00E7o");

	}
}
