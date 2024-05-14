package examen2023.domain;

import examen2023.ui.Fondo;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Planeta implements Comparable {
    protected int x,y;
    protected boolean relleno;
    protected Color color;
    protected double ancho;
    private boolean visible = true;
    public final static int ANCHO_PLANETA = 100;
    public Planeta(int x, int y, boolean relleno, Color color) {
        this.ancho = ANCHO_PLANETA;
        setX(x);
        setY(y);
        this.relleno = relleno;
        this.color = color;
    }


    protected void setX(int x) {
        if(x==-1)
            this.x = (int) (Math.random()* Fondo.ANCHO_FONDO);
        else
            this.x = x;
        if(x>Fondo.ANCHO_FONDO - ancho)
            this.x = (int) (Fondo.ANCHO_FONDO - ancho);
    }

    protected void setY(int y) {
        if(y==-1)
            this.y = (int) (Math.random()* Fondo.ALTO_FONDO);
        else
            this.y = y;
        if(y>Fondo.ALTO_FONDO - ancho)
            this.y = (int) (Fondo.ALTO_FONDO - ancho);
    }

    public Color getColor() {
        return color;
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    @Override
    public String toString() {
        return  "tipo=" + this.getClass().getName() +
                ": x=" + x +
                ",y=" + y +
                ",relleno=" + relleno +
                ",color=" + color;
    }

    public void paint(Graphics g) {
        if(visible) {
            g.setColor(color);
            if (relleno)
                g.fillOval(x, y, (int) ancho, (int) ancho);
            else
                g.drawOval(x, y, (int) ancho, (int) ancho);
        }
    }
    public static Collection<Planeta> readPlanetas() throws IOException {
        ArrayList<Planeta> planetas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("juego.txt")));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            Pattern pattern = Pattern.compile("(-?\\d+)(true|false)(-?\\d+)(rojo|verde|azul)(\\d)");
            Matcher matcher = pattern.matcher(linea);
            if(matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(3));
                boolean relleno = matcher.group(2).equals("true")?true:false;
                Color color = ColorPlaneta.valueOf(matcher.group(4)).getColorPlaneta();
                switch (matcher.group(5)){
                    case "1" -> planetas.add(new Planeta(x,y,relleno,color));
                    case "2" -> planetas.add(new PlanetaMovimiento(x,y,relleno,color));
                    case "3" -> planetas.add(new PlanetaZoom(x,y,relleno,color));
                }
            }
        }

        br.close();

        return planetas;

    }


    /*EL EJEMPLO ANTERIOR ES COMO DEBERÍA REALIZARSE MEDIANTE EXPRESIONES REGULARES, AUNQUE NO SE HAYAN VISTO EN CLASE*/
    public static ArrayList<Planeta> readPlanetasBasico() throws IOException {
        ArrayList<Planeta> planetas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("juego.txt")));
        String linea = null;
        while ((linea = br.readLine()) != null){
            int x = -1;
            int y = -1;
            boolean relleno = false;
            Color color = null;
            String tipo = linea.substring(linea.length()-1);

            if(linea.indexOf("true") != -1) {
                x = Integer.parseInt(linea.substring(0, linea.indexOf("true")));
                relleno = true;
            }
            else if(linea.indexOf("false") != -1) {
                x = Integer.parseInt(linea.substring(0, linea.indexOf("false")));
            }

            int posY = relleno?linea.indexOf("true")+"true".length():linea.indexOf("false")+"false".length();

            if(linea.indexOf("rojo") != -1) {
                y = Integer.parseInt(linea.substring(posY, linea.indexOf("rojo")));
                color = Color.RED;
            }
            else if(linea.indexOf("azul") != -1) {
                y = Integer.parseInt(linea.substring(posY, linea.indexOf("azul")));
                color = Color.BLUE;
            }
            else if(linea.indexOf("verde") != -1) {
                y = Integer.parseInt(linea.substring(posY, linea.indexOf("verde")));
                color = Color.GREEN;
            }

            switch (tipo){
                case "1" -> planetas.add(new Planeta(x,y,relleno,color));
                case "2" -> planetas.add(new PlanetaMovimiento(x,y,relleno,color));
                case "3" -> planetas.add(new PlanetaZoom(x,y,relleno,color));
            }

        }
        br.close();

        return planetas;
    }



    public static void GuardarPlanetas(Collection<Planeta> planetasVisibles) {
        try {
            String fileName = "juego-"+new Date().getTime()+".txt";
            System.out.println("Saving visible planets to " + fileName);
            PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName)));
            TreeSet<Planeta> planetasOrdenados = new TreeSet<>(planetasVisibles);
            for(Planeta p : planetasOrdenados){
                pw.println(p.getInfoBy(","));
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInfoBy(String delimiter) {
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(delimiter);
        sb.append(relleno).append(delimiter);
        sb.append(y).append(delimiter);
        sb.append(color.getRGB()).append(delimiter);
        if(this instanceof PlanetaZoom)
            sb.append(3);
        else if (this instanceof PlanetaMovimiento)
            sb.append(2);
        else if (this instanceof Planeta)
            sb.append(1);
        return sb.toString();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Planeta p)
            if(x != p.getX())
                return Integer.compare(x,p.getX());
            else
                return Integer.compare(y,p.getY());
        else return -1;
    }
}
