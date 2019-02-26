package m6BBOO;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class ConsultasBBOO3 {
	public static void main(String[] args) {
		ODB odb = ODBFactory.open("EQUIPOS.DB");
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			jug.setEdad(jug.getEdad()+1);
			odb.store(jug);
			System.out.printf("%s, %s, %s, %d %n", jug.getNombre(), jug.getDeporte(),jug.getCiudad(), jug.getEdad()); 
		}
		odb.close(); 

	}
}
