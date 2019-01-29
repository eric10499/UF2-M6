package M6JDBC;

import java.sql.*;
public class EjemploInsert {
	public static void main (String[] args){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.56.10:3306/ejemplo","eric","1234");
			String dep = "20";
			String inc = "10";
			String sql = String.format("update emple set salario = salario + %s where dept_no = '%s'" , Integer.parseInt(inc), Integer.parseInt(dep));
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			sentencia.close();
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
