package projetoFinalLP2_Interface;

import projetoFinalLP2_BackEnd.Cliente;
import projetoFinalLP2_BackEnd.Locadora;
import projetoFinalLP2_DataBase.ClienteDB;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField fieldNomeCliente;
	private JTextField fieldIdadeCliente;

	/**
	 * Create the panel.
	 */
	public CadastrarCliente(Locadora locadora) {
		
		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(342, 46, 275, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(70, 129, 137, 14);
		getContentPane().add(lblNewLabel_1);
		
		fieldNomeCliente = new JTextField();
		fieldNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldNomeCliente.setColumns(10);
		fieldNomeCliente.setBounds(217, 122, 553, 28);
		getContentPane().add(fieldNomeCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Idade do Cliente: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(70, 182, 154, 28);
		getContentPane().add(lblNewLabel_2);
		
		fieldIdadeCliente = new JTextField();
		fieldIdadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldIdadeCliente.setColumns(10);
		fieldIdadeCliente.setBounds(217, 182, 117, 27);
		getContentPane().add(fieldIdadeCliente);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente clienteCadastrar = new Cliente();
				
				if(fieldNomeCliente.getText().equals("") || fieldIdadeCliente.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!!");
					return;
				}
            	
            	clienteCadastrar.setNome(fieldNomeCliente.getText());
            	clienteCadastrar.setIdade(Integer.parseInt(fieldIdadeCliente.getText()));
            	
            	ClienteDB clienteDB = new ClienteDB();
            	clienteDB.inserirCliente(clienteCadastrar);
            	
            	limparCampos();
            	
            	JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!!!");
			}
		});
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarCliente.setBounds(304, 306, 124, 31);
		getContentPane().add(btnCadastrarCliente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(485, 306, 107, 31);
		getContentPane().add(btnCancelar);

	}
	
	public void setPosicao() {
		setLocationRelativeTo(null); // Centraliza a janela na tela
    }
	
	public void limparCampos() {
		fieldNomeCliente.setText("");
		fieldIdadeCliente.setText("");
	}
}
