package busreservation;

import java.sql.*;
import java.util.Scanner;

public class CRUD {
	
public void Create() throws SQLException
	{   Scanner sc=new Scanner(System.in);
	    Connection con=connection.getConnection();
		System.out.println(" Enter the update set id\n busrout \n Ac bus Enter no 1 or  0 \n capacity");
     	int id=sc.nextInt();
     	sc.nextLine();
     	String busRoutes=sc.nextLine();
     	int Ac=sc.nextInt();
     	int capacity=sc.nextInt();
     	String q="insert into businfo (id , busRoutes ,Ac, capacity)values(?,?,?,?)";
     	PreparedStatement pst=con.prepareStatement(q);
    	pst.setInt(1, id);
     	pst.setString(2,busRoutes );
     	pst.setInt(3, Ac);

     	pst.setInt(4, capacity);

     	int n=pst.executeUpdate();
     	System.out.println((n>=1)?"updated":"not updated");
    
		
	}
public void Retrieve() throws SQLException {
	  Scanner sc=new Scanner(System.in);
	   Connection con=connection.getConnection();
	   System.out.println("give the All details click no  :1  or selection no  2");
	   int n=sc.nextInt();
	   for(int i=1;i<=n;i++) {
		   if(n==1) {
			   String q="select*from businfo ";
			   PreparedStatement pst=con.prepareStatement(q);
			  ResultSet rs=pst.executeQuery();
			  while(rs.next()) {
				  System.out.println(rs.getInt("id"));
				  System.out.println(rs.getString("busRoutes"));
				  System.out.println((rs.getInt("Ac")));
				  System.out.println(rs.getInt("capacity"));
				  System.out.println(rs.getInt("bookingSeats"));
				  System.out.println();
				  System.out.println();
			  }
			  break;
			  }
			  else {System.out.println("Enter the bus id");
			  int n1=sc.nextInt();
				  String q="select*from businfo where id=?  ";
				   PreparedStatement pst=con.prepareStatement(q);
				   pst.setInt(1, n1);
				  ResultSet rs=pst.executeQuery();
				  while(rs.next()) {
					  System.out.println(rs.getInt("id"));
					  System.out.println(rs.getString("busRoutes"));
					  System.out.println((rs.getInt("Ac")));
					  System.out.println(rs.getInt("capacity"));
					  System.out.println(rs.getInt("bookingSeats"));
					  System.out.println();
					  System.out.println();
			  }break;
		   }
	   }
	  
	}
 public void Updation() throws SQLException {
	 Scanner sc=new Scanner(System.in);
	 Connection con=connection.getConnection();
	 System.out.println("  Bus routes change click no :1\nBus capacity change click no 2 ");
     int no=sc.nextInt();
     for(int i=1;i<=no;i++) {
          
    if(no==1)
     {  System.out.println(("Enter the Bus id number"));
	    int id=sc.nextInt();
     	sc.nextLine();
     	System.out.println("Enter the update bus Route");
     	String busroute=sc.nextLine();

     	
     	String q="update businfo set busRoutes =? where id=? ";
     	PreparedStatement pst=con.prepareStatement(q);
     
     	pst.setString(1, busroute);
     	pst.setInt(2,id);
     	int n=pst.executeUpdate();
     	System.out.println((n>=1)?"updated":"not updated");
     	break;
     }
   else if(no==2)  {
     	System.out.println("Enter the update capacity\nbus id");
     	int capacity=sc.nextInt();
     
     	int id=sc.nextInt();
     	String q="update businfo set capacity=? where id=?";
     	PreparedStatement pst=con.prepareStatement(q);
     	pst.setInt(1, capacity);
     	pst.setInt(2, id);
     	int n=pst.executeUpdate();
     	System.out.println((n>=1)?"updated":"not updated");
     	break;
     	
     }
  
       
     	
     }
 }
 public void deleting() throws SQLException {
	 Scanner sc=new Scanner(System.in);
	  Connection con=connection.getConnection();
	  System.out.println("Enter the bus id no.  all information wll be delete in Bus");   
		int id=sc.nextInt();
		String q="delete from businfo where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, id);
		int n1=pst.executeUpdate();
		System.out.println((n1>=1)?"deleted":"not deleted");
		
	}

public void bookingdeleted() throws SQLException {
	 Scanner sc=new Scanner(System.in);
	  Connection con=connection.getConnection();
	  System.out.println("Enter the bus id no.  all information wll be delete in Bus");   
		int id=sc.nextInt();
		String q="delete from bookings where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, id);
		int n1=pst.executeUpdate();
		System.out.println((n1>=1)?"deleted":"not deleted");
}

}
