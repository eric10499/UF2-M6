import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primer.Emple;
import primer.HibernateUtil;

public class hibernateVB {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as e where e.apellido = 'ARROYO'");
		List <Emple> lista =q.list();
		Iterator <Emple> iter = lista.iterator();
		while (iter.hasNext()){
			Emple emp = (Emple) iter.next();
			System.out.println(emp.getApellido() +"-"+ emp.getSalario()+"-"+emp.getEmpNo());
		}
		session.close();
		System.exit(0);
	}
}
