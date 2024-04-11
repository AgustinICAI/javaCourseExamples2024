package es.icai.gitt.juegos.shootingMario.dominio;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Juego {

	public static final int FPS = 30;
	private static final int PUNTOS_FIN_PARTIDA = 5;
	private Mario mario;
	private Luigi luigi;

	private int puntosMario, puntosLuigi;
	static int Y_MIN = 390;
	static Rectangle AREA = new Rectangle(1000,563);
	private String message;
	private String finPartida;
	private long tsLastMessage;

	public Juego() throws IOException {
		mario = new Mario(100,Y_MIN);
		luigi = new Luigi(800,Y_MIN);
	}
	public String getMessage() {
		return message;
	}
	public String getFinPartida() {
		return finPartida;
	}
	public long getTsLastMessage() {
		return tsLastMessage;
	}



	public Collection<Personaje> getPersonajes() {
		return List.of(mario,luigi);
	}

	public Personaje getMario() {
		return mario;
	}
	public Personaje getLuigi() {
		return luigi;
	}

	public void moverPersonajes(Collection<Integer> teclasPulsadas) {
		if(teclasPulsadas.contains(KeyEvent.VK_W))
			mario.saltar();
		if(teclasPulsadas.contains(KeyEvent.VK_A))
			mario.moverIzquierda();
		if(teclasPulsadas.contains(KeyEvent.VK_D))
			mario.moverDerecha();
		if(teclasPulsadas.contains(KeyEvent.VK_SPACE))
			mario.disparar();

		if(teclasPulsadas.contains(KeyEvent.VK_UP))
			luigi.saltar();
		if(teclasPulsadas.contains(KeyEvent.VK_LEFT))
			luigi.moverIzquierda();
		if(teclasPulsadas.contains(KeyEvent.VK_RIGHT))
			luigi.moverDerecha();
		if(teclasPulsadas.contains(KeyEvent.VK_ENTER)) {
			luigi.disparar();
			teclasPulsadas.remove(KeyEvent.VK_ENTER);
		}

		this.getPersonajes().forEach(Personaje::actualizar);
	}

	public void comprobarLogica() {
		//Se comprueba intersect y contains a la vez, ya que si disparan a quemarropa la bala está ya contenida directamente
		List<Bala> balasImpactoLuigi = mario.getBalas().stream().filter(bala -> luigi.getShape().contains(bala.getShape()) || luigi.getShape().intersects(bala.getShape())).collect(Collectors.toList());
		List<Bala> balasImpactoMario = luigi.getBalas().stream().filter(bala -> mario.getShape().contains(bala.getShape()) || mario.getShape().intersects(bala.getShape())).collect(Collectors.toList());
		if (balasImpactoMario.size()>0 || balasImpactoLuigi.size()>0) {
			if (balasImpactoMario.size()>0 && balasImpactoLuigi.size()>0)
				this.message = "IMPACTOS SIMULTANEOS!!";
			else if (balasImpactoLuigi.size()>0) {
				this.message = "PUNTO PARA MARIO ...";
				mario.addPuntos(balasImpactoLuigi.size());
			} else if (balasImpactoMario.size()>0) {
				this.message = "PUNTO PARA LUIGI ...";
				luigi.addPuntos(balasImpactoMario.size());
			}
			this.tsLastMessage = System.nanoTime();
		}
		//Se borran las balas
		mario.removeBalas(balasImpactoLuigi);
		luigi.removeBalas(balasImpactoMario);

		if(mario.getPuntos() >= PUNTOS_FIN_PARTIDA)
			this.finPartida = "GANA MARIO !";
		else if(luigi.getPuntos() >= PUNTOS_FIN_PARTIDA)
			this.finPartida = "GANA LUIGI !";

	}

	public void volverAEmpezar() {
		this.mario.reset();
		this.luigi.reset();
		this.message = null;
		this.tsLastMessage = 0;
		this.finPartida = null;
	}
}