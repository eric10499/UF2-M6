package M6JDBC;

import java.sql.*;
public class ejercicioJDBC2A {
	public static void main (String [] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://192.168.56.10:3306/ejemplo","eric","1234");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.printf("Nombre: %s %n", nombre);
			System.out.printf("Nombre: %s %n", driver);
			System.out.printf("Nombre: %s %n", url);
			System.out.printf("Nombre: %s %n", usuario);
			resul = dbmd.getColumns(null,null,"depart",null);
			while (resul.next()){
				String nombreColumna = resul.getString("COLUMN_NAME");
				String tipo = resul.getString("TYPE_NAME");
				int tamaño = resul.getInt("COLUMN_SIZE");
				String esnull = resul.getString("IS_NULLABLE");
				System.out.printf("Nombre Columna: %s - Tipo: %s Tamaño: %s Es null: %s %n", nombreColumna, tipo, tamaño, esnull);
			}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
