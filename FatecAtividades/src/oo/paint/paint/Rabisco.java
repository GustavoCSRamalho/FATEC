package oo.paint.paint;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Rabisco extends JComponent implements 
		MouseListener, MouseMotionListener{
	private ArrayList<Point> pontos;
	private ArrayList<Point> pontosAtualizados;
	private ArrayList<Integer> pontosTipos;
	private int tamanho = 8;
	private int metade = tamanho / 2;
	private Color cor;
	private boolean usaBorracha;
	private static Graphics2D g2d;

	public Rabisco(Color cor){
		
		this.cor = cor;
		this.usaBorracha = false;
		pontosAtualizados = new ArrayList<Point>();
		pontos = new ArrayList<Point>(1024);
		pontosTipos = new ArrayList<Integer>();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	protected void paintComponent(Graphics g){
		g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		for(int  i = 0; i < pontos.size(); i++) {
			if(pontos.get(i) != null ) {
				if(pontosTipos.get(i).intValue() == 1) {
					g2d.setColor(cor);
					g2d.fillOval(pontos.get(i).x - metade, pontos.get(i).y - metade, tamanho, tamanho);
				}else {
					g2d.setColor(Color.WHITE);
					g2d.fillOval(pontos.get(i).x - metade, pontos.get(i).y - metade, tamanho*2, tamanho*2);
				}
			}
		}
			
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Point ponto = e.getPoint();
		pontos.add(ponto);
		if(usaBorracha) {
			pontosTipos.add(2);
		}else {
			pontosTipos.add(1);
		}
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		switch(e.getButton()){
		case MouseEvent.BUTTON1: 
			Point ponto = e.getPoint();
			pontos.add(ponto);
			if(usaBorracha ) {
				pontosTipos.add(2);
			}else {
				pontosTipos.add(1);
			}
			repaint(); 
			break;
		case MouseEvent.BUTTON3:
			if(!usaBorracha) {
				usaBorracha = true;
			}else {
				usaBorracha = false;
			}
		}
		repaint();
	}
	
	public void removeItem(Point e) {
		Point ponto = e;
		while(pontosAtualizados.remove(ponto)) {}
		pontos = new ArrayList<Point>(1024);
		pontos.addAll(pontosAtualizados);
		repaint();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}