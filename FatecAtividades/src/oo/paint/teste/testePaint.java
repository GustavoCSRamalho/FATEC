package oo.paint.teste;

import java.awt.Color;
import java.awt.Graphics;
/*from ww w  .  java 2  s  .  c  om*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class testePaint extends JPanel {

  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.clearRect(0, 0, 100, 100);
   

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(new testePaint());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(20,20, 500,500);
    frame.setVisible(true);
  }
}
