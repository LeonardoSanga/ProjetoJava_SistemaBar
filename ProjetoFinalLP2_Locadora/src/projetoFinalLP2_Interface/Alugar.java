package projetoFinalLP2_Interface;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import	projetoFinalLP2_BackEnd.Cliente;
import	projetoFinalLP2_BackEnd.Filme;
import	projetoFinalLP2_BackEnd.Locadora;
import	projetoFinalLP2_BackEnd.Paramount;
import	projetoFinalLP2_BackEnd.Produtora;
import	projetoFinalLP2_BackEnd.Universal;
import	projetoFinalLP2_BackEnd.WarnerBros;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alugar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField fieldNomeFilme;
	private JTextField fieldNomeCliente;
	private JTextField fieldProdutora;
	private JTextField fieldDataDevolve;
	private JTextField fieldDataAluga;

	/**
	 * Create the panel.
	 */
	public Alugar(Locadora locadora) {
		
		setBounds(100, 100, 900, 500);
        getContentPane().setLayout(null);
		
		
		JLabel lblAlugarFilme = new JLabel("Alugar Filme");
		lblAlugarFilme.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAlugarFilme.setBounds(395, 30, 182, 32);
		getContentPane().add(lblAlugarFilme);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome do Filme: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(96, 110, 146, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		fieldNomeFilme = new JTextField();
		fieldNomeFilme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldNomeFilme.setColumns(10);
		fieldNomeFilme.setBounds(242, 110, 490, 20);
		getContentPane().add(fieldNomeFilme);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome do Cliente:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(90, 159, 162, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		fieldNomeCliente = new JTextField();
		fieldNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldNomeCliente.setColumns(10);
		fieldNomeCliente.setBounds(242, 159, 490, 20);
		getContentPane().add(fieldNomeCliente);
		
		JLabel lblNewLabel_3_1 = new JLabel("Produtora do Filme:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(64, 218, 176, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		fieldProdutora = new JTextField();
		fieldProdutora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldProdutora.setColumns(10);
		fieldProdutora.setBounds(230, 212, 496, 20);
		getContentPane().add(fieldProdutora);
		
		JLabel lblNewLabel_4_1 = new JLabel("Data da Devolução:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(439, 264, 191, 31);
		getContentPane().add(lblNewLabel_4_1);
		
		fieldDataDevolve = new JTextField();
		fieldDataDevolve.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldDataDevolve.setColumns(10);
		fieldDataDevolve.setBounds(597, 268, 129, 20);
		getContentPane().add(fieldDataDevolve);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Data do Alugamento:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1_1.setBounds(124, 268, 176, 23);
		getContentPane().add(lblNewLabel_4_1_1);
		
		fieldDataAluga = new JTextField();
		fieldDataAluga.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldDataAluga.setColumns(10);
		fieldDataAluga.setBounds(299, 268, 101, 20);
		getContentPane().add(fieldDataAluga);
		
		JButton btnAlugar = new JButton("Alugar");
		btnAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fieldNomeCliente.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Nome do Cliente!");
					return;
				}
				
				Filme filmeAlugar = null;
                if(fieldProdutora.getText().equalsIgnoreCase("Warner Bros")) {
                	Produtora warner = new WarnerBros();
                	
                	filmeAlugar = warner.geraFilme(fieldNomeFilme.getText());
                	
                } else if(fieldProdutora.getText().equalsIgnoreCase("Universal")) {
                	Produtora universal = new Universal();
                	
                	filmeAlugar = universal.geraFilme(fieldNomeFilme.getText());
                } else if(fieldProdutora.getText().equalsIgnoreCase("Paramount")) {
                	
                	System.out.print("OI");
                	Produtora paramount = new Paramount();
                	
                	filmeAlugar = paramount.geraFilme(fieldNomeFilme.getText());
                }
                System.out.print(fieldProdutora.getText());
                System.out.print(fieldNomeFilme.getText());
                
                filmeAlugar = locadora.buscarFilme(fieldNomeFilme.getText());
                
                if(filmeAlugar == null) {
                	System.out.println("Não há esse filme na locadora\n");
                	JOptionPane.showMessageDialog(null, "Não há esse filme na locadora");
                	return; 
                }
                
                Cliente clienteAlugar = new Cliente();
                clienteAlugar = locadora.buscarCliente(fieldNomeCliente.getText());
                
                if(clienteAlugar == null) {
                	System.out.println("Cliente não está cadastrado na lista de clientes da locadora\n");
                	JOptionPane.showMessageDialog(null, "Cliente não está cadastrado na lista de clientes da locadora");
                	return; 
                }
                
                if(locadora.alugar(filmeAlugar, clienteAlugar, fieldDataAluga.getText(), fieldDataDevolve.getText())) {
                	System.out.println("Alugado com Sucesso!!!\n");
                	JOptionPane.showMessageDialog(null, "Alugado com Sucesso!!!");
                } else {
                	System.out.println("O Filme NÃO foi Alugado!!!\n");
                	JOptionPane.showMessageDialog(null, "O Filme NÃO foi Alugado!!!");
                }
                
                limparCampos();
			}
		});
		btnAlugar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlugar.setBounds(330, 329, 101, 32);
		getContentPane().add(btnAlugar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(461, 329, 116, 32);
		getContentPane().add(btnCancelar);
		
		

	}
	
	public void setPosicao() {
		setLocationRelativeTo(null); // Centraliza a janela na tela
    }
	
	public void limparCampos() {
		fieldNomeFilme.setText("");
		fieldNomeCliente.setText("");
		fieldProdutora.setText("");
		fieldDataAluga.setText("");
		fieldDataDevolve.setText("");
	}
}
