package m6BBOO;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;


public class IntroducirJugadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paises pais1 = new Paises(1, "España");
		Paises pais2 = new Paises(2, "USA");
		Paises pais3 = new Paises(3, "Italia");
		Paises pais4 = new Paises(4, "Francia");
		Jugadores jugador1 = new Jugadores(pais1, "Eric", "Futbol", "Barcelona", 19);
		Jugadores jugador2 = new Jugadores(pais2, "Lebron", "Balocensto", "Cleveland", 34);
		Jugadores jugador3 = new Jugadores(pais3, "Francesco", "Motociclismo", "Roma", 26);
		Jugadores jugador4 = new Jugadores(pais4, "Killian", "Tenis", "Paris", 22);

		ODB odb = ODBFactory.open("EQUIPOS.DB");  	
		odb.store(jugador1);
		odb.store(jugador2);
		odb.store(jugador3);
		odb.store(jugador4);
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class); 
		System.out.printf("%d Jugadores: %n", objects.size());
		

		int i = 1;
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.printf("%d: %s, %s, %s, %d %n",i++, jug.getNombre(), jug.getDeporte(),jug.getCiudad(), jug.getEdad());   
		
	}
	odb.close(); 

}
}
