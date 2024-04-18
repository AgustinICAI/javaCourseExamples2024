	/*

API: https://jsoup.org/apidocs/index.html

javac -cp .;jsoup-1.13.1.jar App.java
java -cp .;jsoup-1.13.1.jar App

*/

package covid19;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.ArrayList;

public class Webscrapping
{
	public static ArrayList<Integer> readCasos() 
	{
		ArrayList<Integer> casos = new ArrayList<Integer>();
		try
		{
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/2020_coronavirus_pandemic_in_Spain").get();

			Elements elementos = doc.select("span[style*=width:3.5em; padding:0 0.3em 0 0; text-align:right; display:inline-block]");
			for(Element elemento:elementos)
			{
				String numeroDeCasosDia = elemento.text().toString().replace(",", "").trim();
				if(numeroDeCasosDia.length()>0)
				{
					try
					{
						casos.add(Integer.parseInt(numeroDeCasosDia));
					}
					catch(NumberFormatException e)
					{
						System.out.println("El dato " + numeroDeCasosDia + " no es numérico y no se pudo agregar");
					}
				}
			}
		}
		catch(java.io.IOException ioe)
		{
			System.out.println("Error de I/O");
			//ioe.printStackTrace();
		}
		return casos;
	}
}