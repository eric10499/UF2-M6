
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import primer.Depart;
import primer.Emple;
import primer.HibernateUtil;
public class hibernateIVC {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Emple emp = (Emple) session.load(Emple.class, 7369);
		Depart dep = new Depart();
		try {
			emp.setSalario(emp.getSalario()+1000);
			dep.setDeptNo(30);
			emp.setDepart(dep);
			session.update(emp);
			tx.commit();
			System.out.println ("Update realizado");
		} catch (
				ObjectNotFoundException c) 
		{ System.out.println ("No existe");}

		catch (Exception e) { e.printStackTrace();}
		session.close(); System.exit(0); } }
