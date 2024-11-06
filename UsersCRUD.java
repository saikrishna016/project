package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersCRUD {
	PreparedStatement pstatement;
	Scanner sc;
	//insert
	 public void insertUsers(Connection con,Scanner scanner) {
		String insertSQL = "INSERT INTO Users(UserID, Username,email,password) VALUES(?,?,?,?)";
		try(PreparedStatement pstatement = con.prepareStatement(insertSQL)){
			System.out.println("Enter values for the Users to insert the record\nEnter Userid of the Users:");
			sc=scanner;
			pstatement.setString(1, sc.next());
			System.out.println("Enter name of the User:");
			pstatement.setString(2, sc.next());
			System.out.print("Enter email for User:");
			pstatement.setString(3, sc.next());
			System.out.print("Enter password for User:");
			pstatement.setString(4, sc.next());
			
			//execute the query
			int rowsInserted = pstatement.executeUpdate();
			System.out.println("No. of records inserted:"+ rowsInserted);
			
		 } catch (SQLException e) {
		        System.out.println("Error inserting user: " + e.getMessage());
		        e.printStackTrace();
		    }
		}
	//update
     public void updateUsers(Connection con,Scanner scanner) {
    	try {
    		System.out.println("Enter your choice\n1.Update Username\n2.Update Password\n3.Update Email");
    		sc=scanner;
    		int option=sc.nextInt();
    		switch(option) {
    		case 1:pstatement=con.prepareStatement("update Users set Username=?  where Userid=?");
    		      System.out.println("enter   new Username for Userid");       
    		      pstatement.setString(1, sc.next());
    		      System.out.print("Enter UserID: ");
    		      pstatement.setInt(2, sc.nextInt());
			      System.out.println("Update records: "+pstatement.executeUpdate());
			      break;
			case 2:
			  pstatement=con.prepareStatement("update Users set Password=?  where Userid=?");
		      System.out.println("enter Password for Userid");       
		      pstatement.setString(1, sc.next());
		      System.out.print("Enter UserID: ");
		      pstatement.setInt(2, sc.nextInt());
		      System.out.println("Update records: "+pstatement.executeUpdate());
		          break; 
    		case 3:
    		pstatement=con.prepareStatement("update Users set Email=?  where Userid=?");
    		  System.out.println("enter Email for Userid");       
		      pstatement.setString(1, sc.next());
		      System.out.print("Enter UserID: ");
		      pstatement.setInt(2, sc.nextInt());
		      System.out.println("Update records: "+pstatement.executeUpdate());
		      break;
  		

		    default:
		    	  System.out.println("u have entered wrong option");
			      break;
			
  		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
  }
    //delete
     public void deleteUsers(Connection con,Scanner scanner) {
    	try {
			pstatement=con.prepareStatement("delete from Users where Userid=?");
			System.out.println("Enter Userid for deleting the record:");
			sc=scanner;
			int Userid=sc.nextInt();
			pstatement.setInt(1, Userid);
			System.out.println("No.of Records deleted:"+pstatement.executeUpdate());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    //select all 
     public void getAllUsers(Connection con) {
    	try {
			pstatement=con.prepareStatement("select * from Users");
			
			ResultSet rSet = pstatement.executeQuery();
			System.out.println("--------------------------------------------------------------------");
			while(rSet.next())
				System.out.println(rSet.getInt("userid") + " " +
                        rSet.getString("Username") + " " +
                        rSet.getString("email") + " " +
                        rSet.getString("password") + " " +
                        rSet.getTimestamp("CreatedAT"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}








