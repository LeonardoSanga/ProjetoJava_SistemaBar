package projetoFinalLP2_Interface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import projetoFinalLP2_BackEnd.Locadora;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Devolver extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField fieldNomeFilme;
	private JTextField fieldNomeCliente;
	private JTextField fieldProdutora;
	private JTextField fieldDataDevolve;

	/**
	 * Create the panel.
	 */
	public Devolver(Locadora locadora) {
		
		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Devolver Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(348, 29, 269, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Filme: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(133, 88, 131, 16);
		getContentPane().add(lblNewLabel_1);
		
		fieldNomeFilme = new JTextField();
		fieldNomeFilme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldNomeFilme.setColumns(10);
		fieldNomeFilme.setBounds(265, 88, 488, 21);
		getContentPane().add(fieldNomeFilme);
		
		JLabel lblNewLabel_2 = new JLabel("Nome do Cliente:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(133, 146, 144, 20);
		getContentPane().add(lblNewLabel_2);
		
		fieldNomeCliente = new JTextField();
		fieldNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldNomeCliente.setColumns(10);
		fieldNomeCliente.setBounds(278, 146, 475, 23);
		getContentPane().add(fieldNomeCliente);
		
		JLabel lblNewLabel_3 = new JLabel("Produtora do Filme:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(133, 201, 163, 14);
		getContentPane().add(lblNewLabel_3);
		
		fieldProdutora = new JTextField();
		fieldProdutora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldProdutora.setColumns(10);
		fieldProdutora.setBounds(298, 200, 455, 21);
		getContentPane().add(fieldProdutora);
		
		JLabel lblNewLabel_4 = new JLabel("Data da Devolução:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(133, 258, 163, 20);
		getContentPane().add(lblNewLabel_4);
		
		fieldDataDevolve = new JTextField();
		fieldDataDevolve.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldDataDevolve.setColumns(10);
		fieldDataDevolve.setBounds(298, 261, 131, 20);
		getContentPane().add(fieldDataDevolve);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(locadora.devolver(fieldNomeFilme.getText(), fieldNomeCliente.getText(), fieldDataDevolve.getText(), fieldProdutora.getText())) {
                	System.out.println("Devolvido com Sucesso!!!\n");
                	JOptionPane.showMessageDialog(null, "Devolvido com Sucesso!!!");
                } else {
                	System.out.println("Filme já está Disponível ou Nomes do Filme ou do Cliente escritos Errados!!!\n");
                	JOptionPane.showMessageDialog(null, "Filme já está Disponível ou Nomes do Filme ou do Cliente escritos Errados!!!");
                }
				
				limparCampos();
			}
		});
		btnDevolver.setBounds(331, 335, 109, 32);
		getContentPane().add(btnDevolver);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(489, 336, 120, 31);
		getContentPane().add(btnCancelar);

	}
	
	public void setPosicao() {
		setLocationRelativeTo(null); // Centraliza a janela na tela
    }
	
	public void limparCampos() {
		fieldNomeFilme.setText("");
		fieldNomeCliente.setText("");
		fieldProdutora.setText("");
		fieldDataDevolve.setText("");
	}

}
