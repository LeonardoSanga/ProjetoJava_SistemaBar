package projetoFinalLP2_Interface;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PainelComImagem extends JPanel {

    private static final long serialVersionUID = 1L;
    private Image imagemDeFundo;

    public PainelComImagem(String caminhoImagem) {
        try {
            imagemDeFundo = ImageIO.read(new File(caminhoImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemDeFundo != null) {
        	g.drawImage(imagemDeFundo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
