package projetoFinalLP2_Interface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import projetoFinalLP2_BackEnd.Locadora;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ListarFilmes extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ListarFilmes(Locadora locadora) {
		
		setBounds(100, 100, 1200, 635);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar os Filmes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(338, 26, 226, 41);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de Filmes da Locadora:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(46, 114, 292, 28);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea fieldListaFilmes = new JTextArea();
		fieldListaFilmes.setFont(new Font("Monospaced", Font.PLAIN, 14));
		fieldListaFilmes.setLineWrap(true);
		fieldListaFilmes.setWrapStyleWord(true); // Para quebrar palavras apropriadamente
		
		JScrollPane scrollPane = new JScrollPane(fieldListaFilmes);
        scrollPane.setBounds(46, 153, 1098, 421);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem vertical
        getContentPane().add(scrollPane);
		
		
		JButton btnListar = new JButton("Imprimir");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				
				rs = locadora.listarFilmes();
				
				try {
					while(rs.next()) {
						fieldListaFilmes.append(rs.getString("nome") + " | Gênero: " + rs.getString("genero") + " | Produtora: " + rs.getString("produtora") + " | Diretor: " + rs.getString("Diretor") + " | Classificação Indicativa: " + rs.getInt("classficacao_indicativa") + "\n\n");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (rs != null) {
		            try {
		                rs.close();
		            } catch (SQLException i) {
		                System.out.println("Erro ao fechar ResultSet: " + i.getMessage());
		            }
		        }
				
		        fieldListaFilmes.setCaretPosition(0);
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListar.setBounds(309, 119, 112, 23);
		getContentPane().add(btnListar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldListaFilmes.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(435, 120, 89, 23);
		getContentPane().add(btnNewButton);
		
		

	}
	
	public void setPosicao() {
		setLocationRelativeTo(null); // Centraliza a janela na tela
    }

}
