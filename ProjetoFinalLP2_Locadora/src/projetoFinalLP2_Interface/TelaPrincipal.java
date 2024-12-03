package projetoFinalLP2_Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projetoFinalLP2_BackEnd.Locadora;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Locadora locadora = Locadora.getInstance();
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 613, 486);

	    // Caminho da imagem (ajuste conforme necessário)
	    String caminhoImagem = "src/Imagens/fundo.jpg";
	    
	    System.out.println(new File(caminhoImagem).getAbsolutePath());

	    // Substituir o contentPane pelo painel com imagem
	    PainelComImagem painelComImagem = new PainelComImagem(caminhoImagem);
	    setContentPane(painelComImagem);
	    painelComImagem.setLayout(null);
	    
	    //contentPane = new JPanel();
	    //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    //setContentPane(contentPane);
	    //contentPane.setLayout(null);

	    // Adicionar barra de menu
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);

	    JMenu menuLivro = new JMenu("Filmes");
	    menuLivro.setFont(new Font("Segoe UI", Font.PLAIN, 30));
	    menuBar.add(menuLivro);

	    JMenuItem menuLivroItemALugar = new JMenuItem("Alugar");
	    menuLivroItemALugar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    menuLivroItemALugar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Alugar telaAlugar = new Alugar(locadora);
	            telaAlugar.setVisible(true);
	            telaAlugar.setPosicao();
	        }
	    });
	    menuLivro.add(menuLivroItemALugar);

	    JMenuItem menuLivroItemDevolver = new JMenuItem("Devolver");
	    menuLivroItemDevolver.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    menuLivroItemDevolver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Devolver telaDevolver = new Devolver(locadora);
	    		telaDevolver.setVisible(true);
	    		telaDevolver.setPosicao();
	    	}
	    });
	    menuLivro.add(menuLivroItemDevolver);

	    JMenuItem menuLivroItemBuscar = new JMenuItem("Buscar");
	    menuLivroItemBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    menuLivroItemBuscar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		BuscarFilme telaBuscarFilme = new BuscarFilme(locadora);
	    		telaBuscarFilme.setVisible(true);
	    		telaBuscarFilme.setPosicao();
	    	}
	    });
	    menuLivro.add(menuLivroItemBuscar);

	    JMenu menuListar = new JMenu("Listar");
	    menuListar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
	    menuBar.add(menuListar);

	    JMenuItem menuListarItemFilmes = new JMenuItem("Filmes");
	    menuListarItemFilmes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    menuListarItemFilmes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ListarFilmes telaListarFilmes = new ListarFilmes(locadora);
	    		telaListarFilmes.setVisible(true);
	    		telaListarFilmes.setPosicao();
	    	}
	    });
	    menuListar.add(menuListarItemFilmes);

	    JMenuItem menuListarItemClientes = new JMenuItem("Clientes");
	    menuListarItemClientes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    menuListarItemClientes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ListarClientes telaListarClientes = new ListarClientes(locadora);
	    		telaListarClientes.setVisible(true);
	    		telaListarClientes.setPosicao();
	    	}
	    });
	    menuListar.add(menuListarItemClientes);

	    JMenuItem menuListarItemFilmesAlugados = new JMenuItem("Filmes Alugados");
	    menuListarItemFilmesAlugados.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    menuListarItemFilmesAlugados.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ListarFilmesAlugados telaListarFilmesAlugados = new ListarFilmesAlugados(locadora);
	    		telaListarFilmesAlugados.setVisible(true);
	    		telaListarFilmesAlugados.setPosicao();
	    		
	    	}
	    });
	    menuListar.add(menuListarItemFilmesAlugados);

	    JMenu menuCadastrar = new JMenu("Cadastrar");
	    menuCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
	    menuBar.add(menuCadastrar);

	    JMenuItem menuCadastrarItemCliente = new JMenuItem("Cliente");
	    menuCadastrarItemCliente.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    menuCadastrarItemCliente.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		CadastrarCliente telaCadastrarCliente = new CadastrarCliente(locadora);
	    		telaCadastrarCliente.setVisible(rootPaneCheckingEnabled);
	    		telaCadastrarCliente.setPosicao();
	    	}
	    });
	    menuCadastrar.add(menuCadastrarItemCliente);
	    
	}
	
	
}
