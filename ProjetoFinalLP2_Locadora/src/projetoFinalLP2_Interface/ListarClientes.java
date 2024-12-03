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

public class ListarClientes extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public ListarClientes(Locadora locadora) {
        
        setBounds(100, 100, 900, 600);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Listar os Clientes");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel.setBounds(229, 36, 249, 35);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Lista de Clientes da Locadora:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(35, 82, 305, 25);
        getContentPane().add(lblNewLabel_1);
        
        JTextArea fieldListaClientes = new JTextArea();
        fieldListaClientes.setFont(new Font("Monospaced", Font.PLAIN, 18));
        fieldListaClientes.setLineWrap(true);
        fieldListaClientes.setWrapStyleWord(true); // Para quebrar palavras apropriadamente
        
        // Envolvendo o JTextArea em um JScrollPane
        JScrollPane scrollPane = new JScrollPane(fieldListaClientes);
        scrollPane.setBounds(28, 128, 800, 398);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem vertical
        getContentPane().add(scrollPane);
        
        JButton btnListar = new JButton("Imprimir");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = null;
                
                rs = locadora.listarClientes();
                
                try {
                    while(rs.next()) {
                        fieldListaClientes.append("Nome: " + rs.getString("nome") + " | Idade: " +  rs.getInt("idade") + "\n\n");
                    }
                } catch (SQLException i) {
                    i.printStackTrace();
                }
                
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException i) {
                        System.out.println("Erro ao fechar ResultSet: " + i.getMessage());
                    }
                }
                
                fieldListaClientes.setCaretPosition(0);
            }
        });
        btnListar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnListar.setBounds(314, 83, 104, 22);
        getContentPane().add(btnListar);
        
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldListaClientes.setText("");
            }
        });
        btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnLimpar.setBounds(428, 82, 89, 23);
        getContentPane().add(btnLimpar);

    }
    
    public void setPosicao() {
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }
}