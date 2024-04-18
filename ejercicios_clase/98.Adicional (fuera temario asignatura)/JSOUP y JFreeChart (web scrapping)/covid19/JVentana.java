package covid19;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import java.util.Collection;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JVentana extends JFrame
{
    public static void main(String[] args)
    {
        new JVentana();
    }

	public JVentana()
	{
        super("Covid19");
        this.setLayout(new FlowLayout());

        XYSeries series = new XYSeries("España");
        Collection<Integer> datos = Webscrapping.readCasos();

        int ejeX = 1;
        for(int dato:datos)
        	series.add(ejeX++, dato);

        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Fallecimientos por coronavirus", "días", "fallecimientos", data, 
        	PlotOrientation.VERTICAL, true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);

        this.add(chartPanel);

        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
}
