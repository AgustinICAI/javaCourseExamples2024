package es.icai.gitt.juegos.shootingMario.dominio;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Personaje extends Sprite{
    private int xOriginal, yOriginal;
    boolean orientacionDerechaOriginal;
    private String name;
    private int puntos;
    protected Image image,originalImage,flippedImage;
    static double VELOCIDAD_SALTO = 250; //Pixeles/s
    static double VELOCIDAD_DESPLAZAMIENTO = 150; //Pixeles/s

    static double TIEMPO_SALTO = 0.3;
    static int BALAS_INICIALES = 5;

    static double TIEMPO_ENTRE_BALAS = 0.5;

    long tsInicioSalto;

    Collection<Bala> balas = new ArrayList<>();

    long tsUltimaBala = 0;
    private int ancho,alto;
    private Polygon silueta;

    public Personaje(String name, int x, int y, boolean orientacionDerecha) {
        super(x, y, orientacionDerecha);
        this.xOriginal = x;
        this.yOriginal = y;
        this.orientacionDerechaOriginal = orientacionDerecha;
        this.name = name;
    }

    public void addPunto(){
        this.puntos +=1;
    }
    public void addPuntos(int puntos){
        this.puntos += puntos;
    }

    protected void setImage(String path) throws IOException{
        originalImage = ImageIO.read(new File(path));
        image = originalImage;
        // Flip the image horizontally
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        flippedImage = op.filter((BufferedImage) image, null);
        this.ancho = ((BufferedImage) image).getWidth();
        this.alto = ((BufferedImage) image).getHeight();
    }

    public void saltar() {
        if (tsInicioSalto == 0)
            tsInicioSalto = System.nanoTime();
    }

    public void disparar(){
        if(balas.size() < BALAS_INICIALES && System.nanoTime() - tsUltimaBala > TIEMPO_ENTRE_BALAS*1e9){
            //Hacemos el if condicional para que dependiendo de la orientación salga pegada la bala al cuerpo
              balas.add(new Bala(((int) (orientacionDerecha ? x + ancho + 5 : x)),Juego.Y_MIN + 60, orientacionDerecha));
            tsUltimaBala = System.nanoTime();
        }
    }

    public void actualizar(){
        //Personaje saltando
        if (tsInicioSalto + TIEMPO_SALTO*1e9 > System.nanoTime())
            this.y -= VELOCIDAD_SALTO/Juego.FPS;
        //Personaje empieza a bajar
        else{
            this.y += VELOCIDAD_SALTO/Juego.FPS;
            if(y > Juego.Y_MIN) {
                this.y = Juego.Y_MIN;
                tsInicioSalto = 0;
            }
        }
        //Actualizando posición Balas
        balas.forEach(Bala::actualizar);
        //Revisando balas fuera del mapa para borrarlas
        List<Bala> balasFueraFondo = balas.stream().filter(b -> !b.getShape().intersects(Juego.AREA)).collect(Collectors.toList());
        this.balas.removeAll(balasFueraFondo);
    }

    public void moverIzquierda() {
        this.x -= VELOCIDAD_DESPLAZAMIENTO/Juego.FPS;
        if(x < 0)
            x = 0;
        setOrientacionDerecha(false);
    }

    public void moverDerecha() {
        this.x += VELOCIDAD_DESPLAZAMIENTO/Juego.FPS;
        //Es necesario restarle el ancho para que el personaje no se salga del fondo
        if(x > Juego.AREA.width - this.ancho)
            x = Juego.AREA.width - this.ancho;
        setOrientacionDerecha(true);
    }

    public void paint(Graphics g) {
        if(orientacionDerecha)
            g.drawImage(image, x, y, null);
        else
            g.drawImage(flippedImage, x, y, null);

        g.setColor(Color.RED);
        g.drawPolygon(getShape());

        balas.forEach(b -> b.paint(g));
    }

    public Polygon getShape() {
        if(orientacionDerecha){
            int [] xs = Arrays.stream(silueta.xpoints).map(x1 -> x1 + x).toArray();
            int [] ys = Arrays.stream(silueta.ypoints).map(y1 -> y1 + y).toArray();
            return new Polygon(xs, ys,xs.length);
        }
        else {
            int [] xs = Arrays.stream(silueta.xpoints).map(x1 -> (ancho - x1) + x).toArray();
            int [] ys = Arrays.stream(silueta.ypoints).map(y1 -> y1 + y).toArray();
            return new Polygon(xs, ys,xs.length);
        }
    }

    protected void cargarShape(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String linea;
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();

        while ((linea = br.readLine())!=null ){
            String[] split = linea.split(",");
            xs.add(Integer.parseInt(split[0]));
            ys.add(Integer.parseInt(split[1]));
        }
        this.silueta = new Polygon(xs.stream().mapToInt(i -> i).toArray(), ys.stream().mapToInt(i -> i).toArray(), xs.size());
        br.close();
    }

    public Collection<Bala> getBalas() {
        return balas;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void reset() {
        this.puntos = 0;
        this.balas = new ArrayList<>();
        this.x = xOriginal;
        this.y = yOriginal;
        tsInicioSalto = 0;
        tsUltimaBala = 0;
        this.orientacionDerecha = orientacionDerechaOriginal;
    }

    public String getName() {
        return this.name;
    }

    public void removeBalas(List<Bala> balasImpacto) {
        this.balas.removeAll(balasImpacto);
    }
}
