package busreservation;
import java.sql.*;
import java.util.Scanner;
public class TicketBokking {
	 String name;
     String destination;
	 int nn;
	 
       int n;
	 int id;
	  int scc;

	 int seateNo=1 ;
	
	public  void booking() throws SQLException {
		Scanner sc=new Scanner(System.in);
			System.out.println("Enter passenger name :");
			 name=sc.nextLine();
			System.out.println("destination :");
			 destination=sc.nextLine();
			System.out.println(" Ac  enter 1 \n not Ac enter 0");
		     nn=sc.nextInt();
		   
		    System.out.println(" pleace wait for checking ");
		    BusInformation();
		   	
		}
	


	public  void  BusInformation() throws SQLException {
	
		Scanner sc=new Scanner(System.in);
		Connection con=connection.getConnection();
		 String qq="select*from bookings where destination=?  order by seateNo desc limit 1 ";
		PreparedStatement ps1=con.prepareStatement(qq);
	
		ps1.setString(1, destination);

		ResultSet rs=ps1.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("destination"));
			int no=rs.getInt("seateNo");
			System.out.println(rs.getInt("seateNo"));
	  
this.seateNo=++no;

		}
		{
		
		String q="select * from businfo where busRoutes =? and Ac=? ";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, destination);
		pst.setInt(2,nn);
		ResultSet rs1=pst.executeQuery();

		while(rs1.next()) {
			  id=rs1.getInt("id");
			 
			 
			if(destination.equalsIgnoreCase(rs1.getString("busRoutes"))&&nn==(rs1.getInt("Ac"))&&seateNo<=(rs1.getInt("capacity"))) {
		
				scc=1;
		
			}
			}
		    if(scc==1) {
				conform();
				
		
			}
			else
			{
				System.out.println("not available the bus");
				
			}
			}}
		void conform() throws SQLException {
			Scanner sc=new Scanner(System.in);
		
			
					checking();
					int no=1;
	                while(no<=1) {   

	                    System.out.println("If you more ticket booking \n yes  :1 or no  :2");
	                     no=sc.nextInt();
	                	if(no==1)
	                	{
	                		booking();  
	                		
	                	}
	                	else {
	                		System.out.println("happy journey");
	                	     }
	                	         }
				
	
				}
	
		
			
		

	     
	     
		
   public  void checking() throws SQLException {
	  
	 
	   Connection con=connection.getConnection();
		
				
	       
	        	  
	        	  String qq1="insert into bookings values(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(qq1);
					 ps.setString(1, name);
					 ps.setString(2, destination);
					 
					 ps.setInt(3,seateNo);
					 ps.setInt(4,id);
	        	 int n=ps.executeUpdate();
	        	
	        	 
	        	 System.out.println((n>=1)?"booking success":"does't booking the ticket");
	        
			
				
			
		}
		}
		
		 
	


