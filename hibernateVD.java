import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primer.HibernateUtil;

public class hibernateVD {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("select avg(e.salario) from Emple e");
		List <Double> lista =q.list();
		Iterator <Double> iter = lista.iterator();
		while (iter.hasNext()){
			System.out.println("Salario medio: " + iter.next());
		}
		session.close();
		System.exit(0);
	}
}
