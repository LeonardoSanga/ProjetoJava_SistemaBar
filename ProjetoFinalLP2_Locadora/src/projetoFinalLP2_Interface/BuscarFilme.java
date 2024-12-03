package projetoFinalLP2_Interface;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projetoFinalLP2_BackEnd.Filme;
import projetoFinalLP2_BackEnd.Locadora;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BuscarFilme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField fieldFilmeBuscar;

	/**
	 * Create the panel.
	 */
	public BuscarFilme(Locadora locadora) {
		
		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(372, 21, 208, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Filme:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(114, 106, 136, 27);
		getContentPane().add(lblNewLabel_1);
		
		fieldFilmeBuscar = new JTextField();
		fieldFilmeBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldFilmeBuscar.setColumns(10);
		fieldFilmeBuscar.setBounds(247, 105, 417, 27);
		getContentPane().add(fieldFilmeBuscar);
		
		JLabel labelFilmeBuscado = new JLabel("");
		labelFilmeBuscado.setFont(new Font("Tahoma", Font.BOLD, 40));
		labelFilmeBuscado.setBounds(54, 221, 747, 71);
		getContentPane().add(labelFilmeBuscado);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme filmeBuscar = null;                  
            	filmeBuscar = locadora.buscarFilme(fieldFilmeBuscar.getText());  

            	if(filmeBuscar == null) {
            		System.out.println("O Filme NÃO está presente na locadora!!!\n");
            		JOptionPane.showMessageDialog(null, "O Filme NÃO está presente na locadora!!!");
            		limparCampos();
            		return;
            	}
            	
            	
            	if(filmeBuscar.isDisponivel()) {
					System.out.printf("DISPONÍVEL\n");
					labelFilmeBuscado.setText(filmeBuscar.getNome() + " | " + "DISPONÍVEL");
				} else {
					System.out.printf("INDISPONÍVEL\n");
					labelFilmeBuscado.setText(filmeBuscar.getNome() + " | " + "INDISPONÍVEL");
				}
            	
            	labelFilmeBuscado.setHorizontalAlignment(SwingConstants.CENTER);
            	
            	limparCampos();
          
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(674, 106, 127, 27);
		getContentPane().add(btnNewButton);

	}
	
	public void setPosicao() {
		setLocationRelativeTo(null); // Centraliza a janela na tela
    }
	
	public void limparCampos() {
		fieldFilmeBuscar.setText("");
	}
}
