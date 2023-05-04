package busreservation;

import java.sql.*;
import java.util.Scanner;

public class Input {
int n;
String us="";
String ps="";

int ss;
		  
 

void  Admin() throws SQLException {

	Scanner sc=new Scanner(System.in);
	CRUD c=new CRUD();
	System.out.println("operations \n     create the new bus data :1\n     retrive the bus data :2\n     update the bus dadas :3\n     delete  the bus dadas:4\n     delete the booking information:5 \n chose the opration  ");
	int s1=sc.nextInt();
 switch(s1) {
	case 1: 
	
		c.Create();
		int n=1;
		while(n<=1) {
		System.out.println("any insert the values click 1 otherwise click 2");
	   n=sc.nextInt();
	   if(n==1) {
		c.Create();
		}
	   else {
	   System.out.println("thanks for using");
	       }}
		break;
	
case 2: 
	c.Retrieve();
	int n1=1;
	while(n1<=1) {
  System.out.println("any Retrieve the values click 1 otherwise  click 2");
  n1=sc.nextInt();
  if(n1==1) {
	c.Retrieve();
	}
  else {
	   System.out.println("thanks for using");
	       }
  }
		break;
	
case 3: 
		c.Updation();
		int n11=1;
		while(n11<=1) {
		System.out.println("update the values click 1 otherwise click 2");
	  n11=sc.nextInt();
	  if(n11==1) {
		c.Updation();
		}
	  else {
		   System.out.println("thanks for using");
		       }
	      }
		break;
     
case 4: 
	c.deleting();
	int n111=1;
	while(n111<=1) {
	System.out.println("delete the values click 1 otherwise click 2");
  n111=sc.nextInt();
    if(n111==1) {
	c.deleting();
	}
    else {
 	   System.out.println("thanks for using");
 	       }
      }
		break;
case 5: 
	c.bookingdeleted();
	int n12=1;
	while(n12<=1) {
  System.out.println("any delete  the values click 1 otherwise  click 2");
  n12=sc.nextInt();
  if(n12==1) {
	  c.bookingdeleted();
  }
  else {
	   System.out.println("thanks for using");
	       }
  }
		break;
	}
	}
void get() throws SQLException
{
	 Scanner sc=new Scanner(System.in);

		System.out.println("Enter your username");
	    us=sc.nextLine();
		System.out.println("Enter your password");
		 ps=sc.nextLine();
		 login();
}
void login() throws SQLException {
	 Scanner sc=new Scanner(System.in);


	Connection con=connection.getConnection();
	
	String q="select username,pasword from userlogin ";//where username=? and pasword=?";
   PreparedStatement pst=con.prepareStatement(q);
 
   
  ResultSet rs=pst.executeQuery() ;
  
  while(rs.next())
  {
	
  
  
  if((us.equalsIgnoreCase(rs.getString("username")))&&(ps.equalsIgnoreCase(rs.getString("pasword"))))
  { 
	  ss=1;
  }}
 if(ss==1) {
	 Iterative();
  }
 else {
	int as=1;

	  while(as<=1) {
		  Scanner sc1=new Scanner(System.in);
		  
		  System.out.println("username and password is not matched ");
		  System.out.println("Are you try \n Enter 1 \n Enter 2");
		   as=sc1.nextInt();
		   if(as==1) {
			   get();
		

		  Connection con1=connection.getConnection();
			
			String q1="select username,pasword from userlogin ";//where username=? and pasword=?";
		   PreparedStatement pst1=con1.prepareStatement(q1);
		   
		 
		   
		  ResultSet rs1=pst1.executeQuery() ;
		  
		  while(rs1.next())
		  {
			
		  
		  
		  if((us.equalsIgnoreCase(rs1.getString("username")))&&(ps.equalsIgnoreCase(rs1.getString("pasword"))))
		  {
			 Iterative();
		  }
	      }}
		   else {
			   System.out.println("sorry mis match the input ");
			   break;
		   }
 }
	  
	  
 }
  }
void Iterative() throws SQLException {
	Scanner sc=new Scanner(System.in);
	 System.out.println("Are you ticketboking \n  Yes enter no  :1 \n  No enter no :2");
	  n=sc.nextInt();
	   
	   for(int i=1;i<=n;i++)
	   {
		  if(n==1) {  
		                TicketBokking tb=new TicketBokking();
		                tb.booking();
		             
		                break;
			        }
		     else if(n>=2){
			    System.out.println("thanks for visiting our site");
			    break;
	                       }
		           
    }
	
}
 void register() throws SQLException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your username");
	String us=sc.nextLine();
	System.out.println("Enter your password");
	String ps=sc.nextLine();
	Connection con=connection.getConnection();
	String q="insert into userlogin values(?,?) ";
	PreparedStatement pst=con.prepareStatement(q);
	pst.setString(1, us);
	pst.setString(2, ps);
	
	int n=pst.executeUpdate();

	  System.out.println("login success ");
	  System.out.println("Are you ticketboking \n if you yes enter no  :1 \n if you no using enter no :2");
		 n=sc.nextInt();
		if(n==1) {
		TicketBokking tb=new TicketBokking();
		tb.booking();  
		tb.BusInformation();
        tb.checking();
       int no=1;
while(no<=1) {   

    System.out.println("If you more ticket booking \n yes  :1 or no  :2");
     no=sc.nextInt();
	if(no==1)
	{
		tb.booking();  
		tb.BusInformation();
	    tb.checking();
	}
	else {
		System.out.println("happy journey");
	     }
	
             }

        
		}else {
			System.out.println("Thanks for register  our page");
		}
	
}
}
