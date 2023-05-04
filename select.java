package Continer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.DriverManager;

public class select {

	public static void main(String[] args) {
		String Url="jdbc:mysql://localhost:3306/aim";
		String user="root";
		String pass="";
		
		try {
			Connection con=DriverManager.getConnection(Url,user,pass);
			
			String r="select eid,ename,edepartment,esalary from employee";
			PreparedStatement pst=con.prepareStatement(r);
	
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				System.out.print(rs.getInt("eid")+" ");
				System.out.print(rs.getString("ename")+" ");
				System.out.print((rs.getString("edepartment"))+" ");
				System.out.print((rs.getInt("esalary"))+" ");
				System.out.println();
			}
			
			
			con.close();
			
			
		}catch(Exception e)
		{
			System.out.println("Reason :"+e );
		}

	}

}
