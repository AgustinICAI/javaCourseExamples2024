/**
 @author David Contreras
*/

public class App
{
	public static void main	(String args[])
	{
		Parque parques[] = new Parque[4];
		parques[0] = new ReservaCaza("Masai Mara", 2000.0, 546, 300.0, "Escopeta"); 
		parques[1] = new AreaProtegidaAcuatica("Lago Nakuru ", 1800.0, 546, 300.0, "Salvemos al Flamenco", 3);
		parques[2] = new AreaProtegidaTerrestre("Serengeti",5000.0, 67542,1234,"ONG Chetaw", "Arcillosa");
		parques[3] = new AreaProtegida("NGorongoro", 1400.0, 876, 2345, "GreenPeace");

		System.out.println("Listado de Parques");
		
		for(Parque parque:parques)
			System.out.println(parque.getNombre());
				
		System.out.println("Nombre de Parques");
		for(Parque parque:parques)
		    System.out.println(parque.getInfo());
	
		Visitable visitables[] = new Visitable [4];
		visitables[0] = (Visitable) parques[1];
		visitables[1] = (Visitable) parques[2];
		visitables[2] = (Visitable) parques[3];
		visitables[3] = new Museo("Museo del Prado", "Paseo del Prado S/N", 10.0);

		String guias[] = {"Luis", "María"};
		int indice = 0;

		System.out.println("\nListado de Parques Visitables");
		for(Visitable visitable : visitables)
		{
		    System.out.println(visitable.visitar(guias[indice++]));
			if(indice == guias.length)
				indice = 0;
		}
	}
} 
