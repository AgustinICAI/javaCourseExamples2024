package examenMayo.ui;

import examenMayo.dominio.Casilla;
import examenMayo.dominio.Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Tablero extends JPanel
{
	final static int ANCHO = 300;
	final static int ALTO = 200;
	private Juego juego;

	private Image fondo;


	public Tablero(Juego juego) {
		try {
			fondo = ImageIO.read(new File("./resources/fondo.png")).getScaledInstance(ANCHO,ALTO,Image.SCALE_DEFAULT);
		} catch (IOException exception){
			exception.printStackTrace();
			System.exit(-1);
		}

		this.juego = juego;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("x: " + e.getX() + ", y: " + e.getY());
				juego.actualizaTurno(e.getPoint());
				Tablero.this.repaint();
			}
		});

		this.setPreferredSize(new Dimension(ANCHO,ALTO));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(fondo,0,0,null);
		for(Casilla c  : juego.getCasillas())
			if(c.getLetra()!=null && c.isVisible())
				c.getLetra().pintar(g);
		if(juego.getFinPartida() !=null && juego.isFinPartidaVisible()) {
			g.setColor(Color.BLUE);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD,45));
			g.drawString(juego.getFinPartida(), 20, 80);
		}
	}


}
