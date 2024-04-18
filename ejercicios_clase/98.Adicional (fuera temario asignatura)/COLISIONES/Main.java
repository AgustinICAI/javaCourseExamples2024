import java.awt.*;
import java.awt.geom.Area;

public class Main {

    public static void main(String[] args) {

        Area area = new Area();
        area.add(new Area(new Rectangle(0,0,20,20)));
        area.add(new Area(new Rectangle(80,80,20,20)));
        


        Rectangle rectangulo = new Rectangle(60,60,10,10);
        System.out.println("Hay Colision:" + area.intersects(rectangulo));

    }
}
