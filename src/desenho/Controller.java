package desenho;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/*
 * @author Gustavo
 */
public class Controller {
    
    Ponto p = new Ponto();
    boolean end = false;
    Color color = Color.blue;
    
    public void addPonto(int x, int y) {
        p.addPonto(new Ponto(x, y));
    }
    
    public ArrayList<int[]> getPontos() {
        ArrayList<int[]> pontos = new ArrayList();
        
        ArrayList<Ponto> Pontos = p.getPontos();
        for (int i = 0; i < Pontos.size(); i++) {
            int pt[] = new int[2];
            pt[0] = Pontos.get(i).getX();
            pt[1] = Pontos.get(i).getY();
            pontos.add(pt);
        }
        return pontos;
    }
    
    public void cleanPoints() {
        p.cleanPoints();
    }
    
    public ArrayList<Point> findIntersections() {
        int pontosMax[] = p.getMaxAndMin(); //xmax, xmin, ymax, ymin 
        int xmax = pontosMax[0];
        int xmin = pontosMax[1];
        int ymax = pontosMax[2];
        int ymin = pontosMax[3];
        
        ArrayList<Ponto> Pontos = p.getPontos();
        
       ArrayList<Point> intersectionPoints = new ArrayList<>();
        
    for (int yTemp = ymin; yTemp <= ymax; yTemp++) {
            for (int p = 0; p < Pontos.size() - 1; p++) {
                int x1, x2, y1, y2;
                double deltax, deltay, x;
                x1 = Pontos.get(p).getX();
                y1 = Pontos.get(p).getY();
                x2 = Pontos.get(p + 1).getX();
                y2 = Pontos.get(p + 1).getY();

                deltax = x2 - x1;
                deltay = y2 - y1;

                int roundedX;
                x = x1 + deltax / deltay * (yTemp - y1);
                roundedX = (int) Math.round(x);
                if ((y1 <= yTemp && y2 > yTemp) || (y2 <= yTemp && y1 > yTemp)) {
                    intersectionPoints.add(new Point(roundedX, yTemp));
                }
            }
            //for the last interval
            int x1, x2, y1, y2;
            x1 = Pontos.get(Pontos.size() - 1).getX();
            y1 = Pontos.get(Pontos.size() - 1).getY();
            x2 = Pontos.get(0).getX();
            y2 = Pontos.get(0).getY();
            if ((y1 <= yTemp && y2 > yTemp) || (y2 <= yTemp && y1 > yTemp)) {
                intersectionPoints.add(new Point(x1 + ((x2 - x1) / (y2 - y1)) * (yTemp - y1), yTemp));
            }
            //you have to sort the intersection points of every scanline from the lowest x value to the highest
            
//            intersectionPoints.sort((t, t1) -> {;
//                return t.y > t1.y ? 1 : 0;
//            });
            //Collections.sort(intersectionPoints);
            intersectionPoints.sort((t, t1) -> {
                return t.x > t1.x ? 1 : 0;
            });           
        }
        //System.out.println(intersectionPoints);
         return intersectionPoints;
    }
  
}
