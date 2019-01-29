import primer.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primer.HibernateUtil;
public class hibernate2 {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton. 
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en emple");		
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		Emple emp = new Emple();
		emp.setEmpNo(19);
		emp.setApellido("RODRIGUEZ");
		emp.setOficio("FRUTERO");
		emp.setDir(1234);
		Date now = new Date();
		emp.setFechaAlt(now);
		emp.setSalario(1000);
		Depart dept = new Depart();
		dept.setDeptNo((byte) 10);
		dept.setDnombre("MARKETING");
		dept.setLoc("GUADALAJARA");
		emp.setDepart(dept);	
		//Guardamos en la base de datos y comprometemos la información
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}
