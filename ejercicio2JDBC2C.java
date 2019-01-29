package M6JDBC;

import java.sql.*;

public class ejercicio24 {


	public static void main (String [] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://192.168.56.10:3306/ejemplo","eric","1234");
			PreparedStatement ps=conexion.prepareStatement("select * from emp");  
			ResultSet resul = ps.executeQuery("SELECT * FROM depart");
			ResultSetMetaData rsmd = resul.getMetaData();
			int contador = rsmd.getColumnCount();
			for(int i = 1; i<= contador; i++) {

				String tipo = rsmd.getColumnTypeName(i);
				System.out.println("Nº" + i + " Tipo: " + tipo);
			}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}

