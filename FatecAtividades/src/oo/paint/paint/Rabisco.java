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
	private int tamanho = 8;
	private int metade = tamanho / 2;
	private Color cor;
	private boolean usaBorracha;
	private boolean trava;

	public Rabisco(Color cor){
		this.cor = cor;
		this.usaBorracha = false;
		trava = false;
		pontosAtualizados = new ArrayList<Point>();
		pontos = new ArrayList<Point>(1024);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(cor);
		for(Point ponto : pontos){	
			g2d.fillOval(ponto.x - metade, ponto.y - metade, tamanho, tamanho);
		}	
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Point ponto = e.getPoint();
		pontos.add(ponto);
		pontosAtualizados.add(ponto);
		trava = true;
		if(usaBorracha) {
			removeItem(e.getPoint());
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
			pontosAtualizados.add(ponto);
			if(usaBorracha && !trava) {
				System.out.println("apaga 1");
				removeItem(e.getPoint());
			}
			repaint(); 
			break;
		case MouseEvent.BUTTON3:
			if(!usaBorracha) {
				usaBorracha = true;
			}else {
				usaBorracha = false;
				trava = false;
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