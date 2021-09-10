package desenho;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * @author Gustavo
 */
public class Desenho extends JFrame {
    
    //Lista para armazenar os pontos selecionados
     ArrayList<Posicao> posicoes = new ArrayList<>();
    
    public Desenho() {
        
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                 Point ponto = getMousePosition();
                 posicoes.add(new Posicao(ponto.x, ponto.y));
                 repaint();
            }

            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });
        
        //Configuração da Janela
        setSize(1200,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public class Posicao {
        int x, y;
        public Posicao(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
    
    public void paint(Graphics g) {
    
        //Percorre o array de posições
        for (int i = 1; i < posicoes.size(); i++) {
            //Pega cada ponto do array e desenha na tela
            int x = posicoes.get(i).x; 
            int y = posicoes.get(i).y;
            int x2 = posicoes.get(i-1).x;
            int y2 = posicoes.get(i-1).y;
            
            //Desenha o ponto ou reta na tela
            g.drawLine(x2, y2, x, y);
        }
       
    }
    
    public static void main(String[] args) {
      
        new Desenho();
        
    }
 
}
