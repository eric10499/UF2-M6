package M6JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ejercicio2A {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://192.168.56.10:3306/ejemplo","eric","1234");
			Statement sentencia =conexion.createStatement();
			String sql = "select emple.apellido, emple.salario, depart.dnombre from emple join depart using(dept_no) order by salario desc limit 1";

			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()){
				System.out.printf("%s, %d, %s, %n",
						result.getString("emple.apellido"),
						result.getInt("emple.salario"),
						result.getString("depart.dnombre"));
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}
