package desenho;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JColorChooser;

/*
 * @author Gustavo
 */
public class TelaDesenho extends javax.swing.JFrame {
    
    Controller controller = new Controller();

    /*
     * Creates new form TelaDesenho
     */
    public TelaDesenho() {
        initComponents();
         
        //Configuração da Janela
        setSize(1200,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        painelCor.setBackground(Color.blue);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFecharForma = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        painelCor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        btnFecharForma.setText("Fechar Forma");
        btnFecharForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharFormaActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        painelCor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelCorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelCorLayout = new javax.swing.GroupLayout(painelCor);
        painelCor.setLayout(painelCorLayout);
        painelCorLayout.setHorizontalGroup(
            painelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        painelCorLayout.setVerticalGroup(
            painelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(painelCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 744, Short.MAX_VALUE)
                .addComponent(btnFecharForma)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFechar)
                            .addComponent(btnLimpar)
                            .addComponent(btnFecharForma))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(painelCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //Pega posição da tela que o usuário clicou
        Point ponto = getMousePosition();
        controller.addPonto(ponto.x, ponto.y);
        repaint();
    }//GEN-LAST:event_formMouseClicked

    private void btnFecharFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFormaActionPerformed
        //Fecha a forma desenhada
        controller.end = true;
        repaint();
    }//GEN-LAST:event_btnFecharFormaActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        //Fecha o programa
        System.exit(0);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //Limpa a tela 
        controller.cleanPoints();
        controller.end = false;
        repaint();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void painelCorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCorMouseClicked
        //Opção para usuário selecionar cor
        JColorChooser colorChooser = new JColorChooser();
        Color color = JColorChooser.showDialog(null, "Escolha uma cor", Color.blue);
        painelCor.setBackground(color);
        controller.color = color;
    }//GEN-LAST:event_painelCorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDesenho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDesenho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDesenho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDesenho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDesenho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFecharForma;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JPanel painelCor;
    // End of variables declaration//GEN-END:variables

        public void paint(Graphics g) {
            super.paint(g);
            
            //Define cor dar linhas
            g.setColor(Color.blue);
            
            ArrayList<int[]> pontos = controller.getPontos();

            //Percorre o array de posições
            for (int i = 1; i < pontos.size(); i++) {
                //Pega cada ponto do array e desenha na tela
                int x = pontos.get(i)[0]; 
                int y = pontos.get(i)[1];
                int x2 = pontos.get(i-1)[0];
                int y2 = pontos.get(i-1)[1];

                //Desenha o ponto ou reta na tela
                g.drawLine(x2, y2, x, y);
           }
            
            //Quando a forma for fechada, é preenchida
            if (controller.end) {
                
                //Cor escolhida pelo usuário
                g.setColor(controller.color);
                
                //Liga o primeiro pronto com o último, fechando o polígono
                int x = pontos.get(0)[0];
                int y = pontos.get(0)[1];
                int x2 = pontos.get(pontos.size() -1)[0];
                int y2 = pontos.get(pontos.size() -1)[1];
                g.drawLine(x2, y2, x, y);
                
                //Pega interseção dos pontos
                ArrayList<Point> intersectionPoints = controller.findIntersections();
  
                //Utiliza a interseção para preencher o polígono
                for (int i = 1; i < intersectionPoints.size(); i++) {
                    //Pega cada ponto do array e desenha na tela
                    int xi = intersectionPoints.get(i).x; 
                    int yi = intersectionPoints.get(i).y;
                    int xi2 = intersectionPoints.get(i-1).x;
                    int yi2 = intersectionPoints.get(i-1).y;

                    //Desenha o ponto ou reta na tela
                    g.drawLine(xi, yi, xi2, yi2);
                }
                
            }
            
       }
        
}
