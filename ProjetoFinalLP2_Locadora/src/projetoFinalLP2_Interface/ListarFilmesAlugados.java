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

public class ListarFilmesAlugados extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ListarFilmesAlugados(Locadora locadora) {
		
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar os Filmes Alugados");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(247, 29, 370, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lista dos Filmes Alugados da Locadora:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(51, 85, 349, 22);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea fieldListaFilmesAlugados = new JTextArea();
		fieldListaFilmesAlugados.setFont(new Font("Monospaced", Font.PLAIN, 18));
		fieldListaFilmesAlugados.setLineWrap(true);
		fieldListaFilmesAlugados.setWrapStyleWord(true); // Para quebrar palavras apropriadamente
		
		JScrollPane scrollPane = new JScrollPane(fieldListaFilmesAlugados);
        scrollPane.setBounds(51, 116, 778, 419);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem vertical
        getContentPane().add(scrollPane);
		
		JButton btnListar = new JButton("Imprimir");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				
				rs = locadora.listarFilmesAlugados();
				
				try {
					while(rs.next()) {
						fieldListaFilmesAlugados.append("Nome do filme: " + rs.getString("nome_filme") + " | Cliente que alugou: " +  rs.getString("nome_cliente") + "\n\n");
					}
				} catch (SQLException i) {
					// TODO Auto-generated catch block
					i.printStackTrace();
				}
				
				if (rs != null) {
		            try {
		                rs.close();
		            } catch (SQLException i) {
		                System.out.println("Erro ao fechar ResultSet: " + i.getMessage());
		            }
				}
				
				fieldListaFilmesAlugados.setCaretPosition(0);
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListar.setBounds(410, 87, 109, 23);
		getContentPane().add(btnListar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldListaFilmesAlugados.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(537, 88, 89, 23);
		getContentPane().add(btnNewButton);

	}
	
	public void setPosicao() {
		setLocationRelativeTo(null); // Centraliza a janela na tela
    }

}
