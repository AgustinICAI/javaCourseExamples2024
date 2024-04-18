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

public class WebScrappingAs extends Thread
{
	private JVentanaScrapping ventana;

	public WebScrappingAs(JVentanaScrapping ventana)
	{
		this.ventana = ventana;
	}

	public void run()
	{
		ArrayList<String> listaNoticias = new ArrayList<String>();
		Document doc = null;
		try
		{
			doc = Jsoup.connect("https://www.as.com/").get();
			Elements noticias = doc.select("h2[class=title]");
			for(Element noticia:noticias)
				ventana.actualizarNoticia("As: " + noticia.text());
		}
		catch(IOException e)
		{
			ventana.mostrarError("No me pude conectar a las noticias de As");
		}
	}
}