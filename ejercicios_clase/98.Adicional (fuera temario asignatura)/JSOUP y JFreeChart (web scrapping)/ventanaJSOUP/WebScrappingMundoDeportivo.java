/*

API: https://jsoup.org/apidocs/index.html
DOC: https://jsoup.org/cookbook/extracting-data/selector-syntax

javac -cp .;jsoup-1.13.1.jar AppNoticiasMarca.java
java -cp .;jsoup-1.13.1.jar AppNoticiasMarca

Examples: https://jsoup.org/cookbook/

*/
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

public class WebScrappingMundoDeportivo extends Thread
{
	private JVentanaScrapping ventana;

	public WebScrappingMundoDeportivo(JVentanaScrapping ventana)
	{
		this.ventana = ventana;
	}

	public void run()
	{
		ArrayList<String> listaNoticias = new ArrayList<String>();
		Document doc = null;
		try
		{
			doc = Jsoup.connect("https://www.mundodeportivo.com/").get();
			//Elements noticias = doc.select("h2.mod-title > a:contains(MADRID)");
			Elements noticias = doc.select("h3[class=story-header-title]");
			for(Element noticia:noticias)
				//listaNoticias.add(noticia.text());
				ventana.actualizarNoticia("Mundo deportivo: " + noticia.text());
		}
		catch(IOException e)
		{
			ventana.mostrarError("No me pude conectar a las noticias de Marca");
		}
	}
}