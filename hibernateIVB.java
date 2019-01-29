import java.util.Iterator;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primer.Depart;
import primer.Emple;
import primer.HibernateUtil;

public class hibernateIVB {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton. 
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();		
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		Depart dep = new Depart();
		try {
			dep = (Depart) session.load(Depart.class, 10);
					System.out.println(dep.getDeptNo());
					System.out.println(dep.getDnombre());
					System.out.println(dep.getLoc());
					Set<Emple> listaemp = dep.getEmples();
					Iterator<Emple> it = listaemp.iterator();
					while(it.hasNext()) {
						Emple emp = it.next();
						System.out.println(emp.getApellido());
						System.out.println(emp.getSalario());
					}
		} catch (ObjectNotFoundException o) {
			System.out.println ("No existe el departamento");
			}
		//Guardamos en la base de datos y comprometemos la información
		
		tx.commit();
		session.close();
		System.exit(0);
		
		
	
	}
}
