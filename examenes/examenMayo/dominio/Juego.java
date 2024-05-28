package examenMayo.dominio;

import examenMayo.ui.JVentana;
import examenMayo.ui.Tablero;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


public class Juego {
    private JVentana jVentana;
    private boolean turnoX = true;
    private int[][] combinacionesGanadora;

    private String finPartida;

    ArrayList<Casilla> casillas;

    static int POS_X_INICIAL = 63;
    static int POS_Y_INICIAL = 20;
    static int TAM_CASILLA = 58;

    boolean finPartidaVisible=false;

    public Juego(JVentana jVentana) {
        this.jVentana = jVentana;
		
        try {
            this.combinacionesGanadora = IOFichero.leerCombinaciones("./resources/WinningCombination.txt");
        } catch (IOException e) {
            System.err.println("Error al cargar las combinaciones ganadoras: " + e.getMessage());
           
        }
		casillas = new ArrayList<>();
        for (int c = 0; c < 3; c++) {
            for (int f = 0; f < 3; f++) {
                casillas.add(new Casilla(new Rectangle(POS_X_INICIAL + (f * TAM_CASILLA), POS_Y_INICIAL + (c * TAM_CASILLA), TAM_CASILLA, TAM_CASILLA)));
            }
        }
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void actualizaTurno(Point point) {
        //Partida acabada, se empieza de nuevo
        if (finPartida != null) {
            finPartida = null;
            finPartidaVisible = false;
            casillas.forEach(Casilla::resetLetra);
        }
        Casilla c = this.getCasillaPulsada(point);
        if(c==null) {
            System.out.println("No se ha pulsado casilla");
            return;
        }
        if (c.getLetra() == null) {
            if (turnoX)
                c.setLetraX();
            else
                c.setLetraY();
            int[] combinacionGanadora = hayGanador();
            if (combinacionGanadora!=null) {
                finPartida = "WINNER " + (turnoX ? "X" : "O");
                for(int i : combinacionGanadora)
                    casillas.get(i).getLetra().setColor(Color.BLUE);
                jVentana.arrancarAnimacion(combinacionGanadora);
                System.out.println(finPartida);
            }
            //Se comprueba si todas las casillas tienen una letra
            else if (casillas.stream().allMatch(c1 -> c1.getLetra() != null)) {
                finPartida = "  OTRA ?";
                finPartidaVisible = true;
            }
            turnoX = !turnoX;
        }
		else
			System.out.println("CASILLA YA RELLENA");
    }



    private Casilla getCasillaPulsada(Point point) {
		try{
        	return casillas.stream().filter(c -> c.getArea().contains(point)).findFirst().get();
        }catch (Exception e) {
			return null;
		}
    }

    public boolean isFinPartidaVisible() {
        return finPartidaVisible;
    }

    public void setFinPartidaVisible(boolean finPartidaVisible) {
        this.finPartidaVisible = finPartidaVisible;
    }

    int[] hayGanador() {
		for (int[] combinacion : combinacionesGanadora) {
            boolean ganador = true;
            for (int posicion : combinacion) {
                if (casillas.get(posicion).getLetra() == null ||
                        casillas.get(posicion).getLetra() instanceof LetraX && !turnoX ||
						casillas.get(posicion).getLetra() instanceof LetraO && turnoX) {
                    ganador = false;
                }
            }
            if (ganador)
                return combinacion;
        }
        return null;

    }

    public String getFinPartida() {
        return finPartida;
    }

}