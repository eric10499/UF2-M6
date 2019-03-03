import java.util.Calendar;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


public class LlamadaBBOO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ODB odb = ODBFactory.open("EMPRESA.DB");
        Objects<Emple> objects = odb.getObjects(Emple.class);
        Objects<Depart> objects_depart = odb.getObjects(Depart.class);
        

        //Consulta 1:
//        IQuery query = new CriteriaQuery(Emple.class, Where.equal("dept.deptNo", 10));
//        Objects<Emple> objects=odb.getObjects(query);
//        for(Emple emple : objects) {
//            System.out.println(emple.getEmpNo() + " - " + emple.getApellido() + " - " + emple.getDept());
//            
//        }
        
        
        //Consulta 2:
//        IQuery query = new CriteriaQuery(Emple.class, Where.equal("dept.dnombre", "Ventas"));
//        Objects<Emple> objects=odb.getObjects(query);
//        System.out.println(objects.size());

        
       //Consulta 3:
//        IQuery query = new CriteriaQuery(Emple.class, Where.equal("dir.apellido", "Fernandez"));
//        Objects<Emple> objects=odb.getObjects(query);
//        for(Emple emple : objects) {
//      	  System.out.println(emple.getApellido());        
//        }
        
        //Consulta 4:
//        Objects<Depart> departs = odb.getObjects(Depart.class);
//        for(Depart dep : departs) {
//        	IQuery query = new CriteriaQuery(Emple.class, Where.equal("dept.dnombre", dep.getDnombre()));
//
//        	Objects<Emple> empleados = odb.getObjects(query);
//        	System.out.println(dep.getDnombre() + " - " + empleados.size());
//        }
            
//		for(Emple emple : objects) {
//				odb.delete(emple);
//		}		
//		
//		for(Depart dep : objects_depart) {
//			odb.delete(dep);
//	}		
        
 
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        // Emple definido como director.
//      Emple director = new Emple(1, "Fernandez", "Director", null, date, 0, 0, depart);

        // Ejemplos métodos inserción
      /* Depart depart = new Depart(10, "VENTAS", "BCN");
      	insertarDatosEmple(odb, objects, 8, "Llamas", "Distribuidor", director, 0, 0, depart);
        insertarDatosEmple(odb, objects, 2, "Martinez", "Bombero", null, 0, 0, depart);
        insertarDatosDepart(odb, 11, "INFORMÁTICA", "Madrid");      
        */
        
        //Prueba método modifcarSalarioPorApellido
//        modificarSalarioPorApellido(odb, objects, "Martinez", 1000);
        
        //Prueba método eliminarEmpleadoPorApellido
//        eliminarEmpleadoPorApellido(odb, objects, "Martinez");
        
        //Ejemplos métodos mostrar datos.
//        mostrarEmpleados(odb, objects);
//        System.out.println("----------------------------------------------------------");
//        mostrarDepartamentos(odb, objects_depart);
        
        odb.close();

	}
	
	
	// Método para insertar empleados
	public static void insertarDatosEmple(ODB odb, Objects<Emple> objects, int empNo, String apellido, String oficio, Emple dir, float salario, float comision, Depart dept) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Emple empleado = new Emple(empNo, apellido, oficio, dir, date, salario, comision, dept);
		boolean exists = existeEmple(empNo, apellido, objects);
		if(exists) {
			System.out.println("ERROR - Numero o apellido de empleado ya insertado.");
		} else {
			odb.store(empleado);
		}

	}

	
	// Método para insertar departamentos
	public static void insertarDatosDepart(ODB odb, int deptNo, String dnombre, String loc) {
		Objects<Depart> objects = odb.getObjects(Depart.class);
		for (Depart depart : objects) {
			if(depart.getDeptNo() == deptNo || (depart.getDnombre()).equals(dnombre)) {
				System.out.println("ERROR - Departamento ya insertado");
			} else {
				Depart dep = new Depart(deptNo, dnombre, loc);
				odb.store(dep);
			}

		}
	}


	// Método para comprobar que un empleado existe, ya sea por su número o su apellido
	public static boolean existeEmple(int empNo, String apellido, Objects<Emple> objects) {
		for (Emple empleado : objects) {
			if(empleado.getEmpNo() == empNo || (empleado.getApellido()).equals(apellido)) {
				return true;
			}
		}
		return false;
	}

	// Método para mostrar empleados
	public static void mostrarEmpleados(ODB odb, Objects<Emple> objects ) {
		objects = odb.getObjects(Emple.class);
		for(Emple emple : objects) {
			System.out.println(emple.toString());

		}
	}

	// Método para mostrar departamentos
	public static void mostrarDepartamentos(ODB odb, Objects<Depart> objects ) {
		objects = odb.getObjects(Depart.class);
		for(Depart depart : objects) {
			System.out.println(depart.toString());

		}
	}
	
	
	// Método para modificar el salario de un empleado indicando su apellido
	public static void modificarSalarioPorApellido(ODB odb, Objects<Emple> objects, String apellido, float salario) {
		objects = odb.getObjects(Emple.class);
		for(Emple emple : objects) {
			if(emple.getApellido().equals(apellido)) {
				emple.setSalario(salario);
				odb.store(emple);
			}
		}	
	}
	
	
	// Método para eliminar un empleado indicando su apellido
	public static void eliminarEmpleadoPorApellido(ODB odb, Objects<Emple> objects, String apellido) {
		objects = odb.getObjects(Emple.class);
		for(Emple emple : objects) {
			if(emple.getApellido().equals(apellido)) {
				odb.delete(emple);
			}
		}		
	}


}
