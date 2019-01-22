package M6JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ejercicio3A {
	public static void main(String[] args) {
		try{
			System.out.println("Escribe una localidad: ");
			Scanner scanner = new Scanner(System.in);
			String localidad = scanner.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://192.168.56.10:3306/ejemplo","eric","1234");
			Statement sentencia =conexion.createStatement();
			String sql = "select depart.dnombre, emple.apellido from emple join depart using(dept_no) where depart.loc = \'"+localidad+"\';";

			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()){
				System.out.printf("%s, %s, %n",
						result.getString("depart.dnombre"),
						result.getString("emple.apellido"));
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}
