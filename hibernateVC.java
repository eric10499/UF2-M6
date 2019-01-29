import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primer.*;

public class hibernateVC {

	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as e join Depart as a ON e.depart.deptNo = a.deptNo");
		List <?> lista =q.list();
		Iterator <?> iter = lista.iterator();
		Object[] listaObj;
		Depart depart;
		while (iter.hasNext()){
			listaObj = (Object[]) iter.next(); 
			Emple emp = (Emple) listaObj[0];
			depart = (Depart) listaObj[1];
			System.out.println(emp.getApellido() +" - "+ depart.getDnombre());
		}
		session.close();
		System.exit(0);
	}

}
