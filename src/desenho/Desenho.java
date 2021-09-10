package desenho;

import java.awt.Color;
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
    
    boolean pressionado = false;
    
    public Desenho() {
        
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
            }

            public void mousePressed(MouseEvent me) {
                pressionado = true;
                 posicoes.clear();
            }

            public void mouseReleased(MouseEvent me) {
                  pressionado = false;
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });
        
        new Time().start();
        
        //Configuração da Janela
        setSize(1200,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    ArrayList<Posicao> posicoes = new ArrayList<>();
    
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
            
            g.drawLine(x2, y2, x, y);
        }
       
    }
    
    public static void main(String[] args) {
      
        new Desenho();
        
    }
    
    //Monitora o movimento do mouse e salva as coordenadas a todo momento
    public class Time extends Thread {
        public void run() {     
            while(true) {
                if(pressionado){
                    try{
                        Point ponto = getMousePosition();
                        posicoes.add(new Posicao(ponto.x, ponto.y));
                } catch (Exception erro){}
                }
                repaint(); //Redesenha a tela a todo momento
            }
        }
    }
    
}
