package m6BBOO;

import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;

import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class ConsultasBBOO {
	public static void main(String[] args) {
		System.out.println("Enter a username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();

		ODB odb = ODBFactory.open("EQUIPOS.DB");   
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("nombre",username));
		Objects<Jugadores> objects=odb.getObjects(query);
		if (objects.isEmpty()) {
			System.out.println("no hay ningún jugador que tenga ese nombre en la base de datos");
		} else {

			while(objects.hasNext()) {
				Jugadores jug = objects.next();
				System.out.printf("%s, %s, %s, %d %n", jug.getNombre(), jug.getDeporte(),jug.getCiudad(), jug.getEdad());   

			}
			odb.close(); 
		}
	}


}
