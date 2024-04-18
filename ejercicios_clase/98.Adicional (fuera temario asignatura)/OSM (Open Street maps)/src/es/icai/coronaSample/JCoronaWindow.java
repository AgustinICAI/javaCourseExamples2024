package es.icai.coronaSample;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A simple sample application based in Sample4 and Sample6 at https://github.com/msteiger/jxmapviewer2
 * @author Agustín Gómez
 */
public class JCoronaWindow extends JFrame
{
    public static void main(String[] args) {
        new JCoronaWindow("jCoronaWindow",args[0]);
    }
    Set<MyWaypoint> wpCoronaCountries;
    final String pathcsv = "coronacases_20200330.csv";

    public JCoronaWindow(String title,String rutaFichero)
    {
        super(title);
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        //Centro en Espana con zoom level de 13
        jXMapKit.getMainMap().setCenterPosition(new GeoPosition(40.416775, -3.703790));
        jXMapKit.setZoom(13);

        Set<MyWaypoint> wpCoronaCountries = null;
        try {
            wpCoronaCountries = this.loadCoronaPaises(rutaFichero);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //From Sample4 of https://github.com/msteiger/jxmapviewer2
        if(wpCoronaCountries!=null) {
            // Create a waypoint painter that takes all the waypoints
            WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<>();
            waypointPainter.setWaypoints(wpCoronaCountries);
            waypointPainter.setRenderer(new FancyWaypointRenderer());
            jXMapKit.getMainMap().setOverlayPainter(waypointPainter);
        }

        this.add(jXMapKit);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Obtain the
     * @param path of CSV
     * @return Set de MyWaypoint a pintar
     * @throws IOException
     */
    Set<MyWaypoint> loadCoronaPaises(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
        Set<MyWaypoint> set = new HashSet<>();
        List<CSVRecord> csvrecords = csvParser.getRecords();
        int maxCases = Integer.MIN_VALUE;
        for (CSVRecord record : csvrecords) {
            int casos = Integer.parseInt(record.get("Cases"));
            maxCases = casos>maxCases?casos:maxCases;
        }
        //Para las expresiones lambda, si se trabaja con variables tienen que ser finales.
        final int finalMaxCases = maxCases;
        csvrecords.forEach(record -> {
            double latitude = Double.parseDouble(record.get("latitude"));
            double longitude = Double.parseDouble(record.get("longitude"));
            GeoPosition geoPosition = new GeoPosition(latitude, longitude);
            int cases = Integer.parseInt(record.get("Cases"));
            //Uso el espectro HSB de colores de 0 a 120º(0.3) para pintar del rojo al verde dependiendo de la criticidad. Le aplico a los valores x^0.1 para que sean logaritmicos los colores.
            Color color = Color.getHSBColor((float) (0.3f - 0.3f * Math.pow(cases, 0.1) / Math.pow(finalMaxCases, 0.1)), 1.0f, 0.8f);
            set.add(new MyWaypoint(record.get("Cases"), color, geoPosition));
        });
        return set;
    }
}
