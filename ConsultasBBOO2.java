package m6BBOO;

import java.util.ArrayList;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ConsultasBBOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ODB odb = ODBFactory.open("EQUIPOS.DB"); 
		

		ICriterion criterio = new And()
				.add(Where.ge("edad", 14))
				.add(Where.le("edad", 20));

		CriteriaQuery query = new CriteriaQuery (Jugadores.class, criterio);

		Objects<Jugadores> objects = odb.getObjects(query);
		if (objects.isEmpty()) {
			System.out.println("no hay resultados");
		} else {

			while(objects.hasNext()) {
				Jugadores jug = objects.next();
				System.out.printf("%s, %s, %s, %d %n", jug.getNombre(), jug.getDeporte(),jug.getCiudad(), jug.getEdad());   

			}
			odb.close(); 
		}

	}

}
