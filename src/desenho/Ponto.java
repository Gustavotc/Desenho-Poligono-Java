package desenho;

import java.util.ArrayList;

/**
 * @author Gustavo
 */

public class Ponto {
    
    private int x, y;
    
    private static ArrayList<Ponto> pontos = new ArrayList<>();
    
    public Ponto(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Ponto() {
    }
    
    public void addPonto(Ponto p) {
        pontos.add(p);
    }
    
    public ArrayList<Ponto> getPontos() {
        return pontos;
    }
    
    public void cleanPoints() {
        pontos.clear();
    }
    
    public int[] getMaxAndMin() {
        int ymax = pontos.get(0).y;
        int ymin = pontos.get(0).y;
        int xmax = pontos.get(0).x;
        int xmin = pontos.get(0).x; 
        
        for (Ponto ponto : pontos) {
            if(ponto.x > xmax) {
                xmax = ponto.x;
            } 
            
            if (ponto.x < xmin) {
                xmin = ponto.x;
            }
            
            if(ponto.y > ymax) {
                ymax = ponto.y;
            } 
            
            if (ponto.y < ymin) {
                ymin = ponto.y;
            }  
        } 
        int pontos[] = {xmax, xmin, ymax, ymin};
        return pontos;
    }
    
}
