package busreservation;

import java.sql.*;
import java.util.Scanner;

public class Mainclass {
	 
	public static void main(String[] args) {
		
		 int n;
	try {
		Connection con=connection.getConnection();
		Scanner sc=new Scanner(System.in);
		Input val=new Input();
	    System.out.println(" Are you new user click  :1\n Alredy register click: 2\n Are you admin click :3");
			   n=sc.nextInt();
			   switch(n) 
			   {
			   
			   case 1:   
			             val.register();
			             break;
			   case 2:     
val.get();
				      
				        break;
			         
			   case 3:
			       Scanner ss=new Scanner(System.in);  
				   System.out.println(" Enter your username \n Enter your Password ");
			       String us=ss.nextLine();
			  
		            String ps=ss.nextLine();
		           	
				  String q="select username ,password from Admin";
			      PreparedStatement pst=con.prepareStatement(q);
			      
			      ResultSet rs=   pst.executeQuery();
			      
			      while (rs.next())
			      {
			    	  if(us.equals(rs.getString("username"))&&ps.equals(rs.getString("password")))
			    	  {
						  val.Admin();
						  break;
			          }  
			    	  else {  
			    		  System.out.println("not match");
			    		  System.out.println("try to one time  \n  Enter your username : \n  Enter your Password :  ");
			    		  String uss=ss.nextLine();
						  
				            String pss=ss.nextLine();
				           	
						  String qq="select username ,password from Admin";
					      PreparedStatement psst=con.prepareStatement(qq);
					      
					      ResultSet rss=   psst.executeQuery();
					      
					      while (rss.next())
					      {
					    	  if(uss.equals(rs.getString("username"))&&pss.equals(rs.getString("password")))
					    	  {
								  val.Admin();
								  break;
					          }  
					    	  else {  
					    		  System.out.println(" sory not match the username and  password");
					    	  }
					      }
			    	  }
			     }
			  
  
			 
			 
 }	   }
 
		catch (SQLException e) {
			
			e.printStackTrace();
		                }

	}
}