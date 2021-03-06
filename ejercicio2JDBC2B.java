package M6JDBC;

import java.sql.*;
public class ejercicio2JDBC2B {
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
			ResultSet primaryKey = dbmd.getPrimaryKeys("ejemplo", null, "depart");
			ResultSet  exportedKey = dbmd.getExportedKeys("ejemplo", null, "depart");
			while (primaryKey.next()){

				String pk =primaryKey.getString("COLUMN_NAME");
				System.out.printf("primaryKey: %s %n", pk);
			}

			while (exportedKey.next()){

				String ek =exportedKey.getString("FKCOLUMN_NAME");
				System.out.printf("exportedKey: %s %n", ek);
			}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
