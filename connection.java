package busreservation;

import java.sql.*;


public class connection {
public	static String url="jdbc:mysql://localhost:3306/BusReservation";
public	static String user="root";
public	static String pass="";
public static Connection getConnection() throws SQLException
{
	return 	(Connection) DriverManager.getConnection(url,user,pass);
}
}
