
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;


public class mysqlToNeodatis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection
					("jdbc:mysql://192.168.56.10:3306/ejemplo","eric","1234");
			Statement sentencia =conexion.createStatement();

			Scanner sc = new Scanner(System.in);
			String apellido = sc.nextLine();
			String sql = "select * from emple where emple.apellido = " + apellido;

			//			Scanner sc = new Scanner(System.in);
			//			int num_emp = sc.nextInt();
			//String sql = "select * from emple where emple.emp_no = " + num_emp;


			ResultSet result = sentencia.executeQuery(sql);

			ODB odb = ODBFactory.open("EMPRESA.DB");
			Objects<Emple> objects = odb.getObjects(Emple.class);

			while (result.next()){

				for(Emple empleado : objects) {
					if(empleado.getEmpNo() == result.getInt("emple.emp_no") || empleado.getApellido().equals(result.getString("emple.apellido"))) {
						System.out.println("ERROR - Numero o apellido de empleado ya insertado.");
					} else {
						java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

						Emple emple = new Emple(result.getInt("emple.emp_no"), result.getString("emple.apellido"), result.getString("emple.oficio"), new Emple(result.getInt("emple.dir"), "Fernandez", "Director", null, date, 0, 0, null),
								result.getDate("emple.fecha_alt"), result.getFloat("result.salario"), result.getFloat("emple.comision"), new Depart(result.getInt("emple.dept_no"), "Mysql", "LA"));
						odb.store(emple);
					}
				}
			}
			odb.close();
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}

	}
}

