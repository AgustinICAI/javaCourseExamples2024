/*

API: https://jsoup.org/apidocs/index.html
DOC: https://jsoup.org/cookbook/extracting-data/selector-syntax

javac -cp .;jsoup-1.13.1.jar App.java
java -cp .;jsoup-1.13.1.jar App

*/
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.ArrayList;

public class AppNoticiasMarca
{
	public static void main(String args[]) throws Exception
	{
		Document doc = Jsoup.connect("https://www.marca.com/").get();
		System.out.println(doc.title());

		Elements noticias = doc.select("h2.mod-title > a:contains(MADRID)");
		for(Element noticia:noticias)
			System.out.println(noticia.text());
	}
}