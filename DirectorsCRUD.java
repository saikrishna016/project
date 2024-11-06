package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DirectorsCRUD {

		PreparedStatement pstatement;
		Scanner sc;
		//insert
		 public void insertDirectors(Connection con,Scanner scanner) {
			String insertSQL = "INSERT INTO Directors(DirectorID,Directorname) VALUES(?,?)";
			try(PreparedStatement pstatement = con.prepareStatement(insertSQL)){
				System.out.println("Enter values for the Directors to insert the record\nEnter Directorid of the Director:");
				sc=scanner;
				pstatement.setString(1, sc.next());
				System.out.println("Enter name of the Director:");
				pstatement.setString(2, sc.next());
				
				
				//execute the query
				int rowsInserted = pstatement.executeUpdate();
				System.out.println("No. of records inserted:"+ rowsInserted);
				
			 } catch (SQLException e) {
			        System.out.println("Error inserting user: " + e.getMessage());
			        e.printStackTrace();
			    }
			}
		//update
	     public void updateDirectors(Connection con,Scanner scanner) {
	    	try {
	    		System.out.println("Enter your choice\n1.Update Directorid\n2.Update Directorname");
	    		sc=scanner;
	    		int option=sc.nextInt();
	    		switch(option) {
	    		case 1:pstatement=con.prepareStatement("update Users set Directorname=?  where Directorid=?");
	    		      System.out.println("enter   new Username for Directorid");       
	    		      pstatement.setString(1, sc.next());
	    		      System.out.print("Enter Directorid: ");
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
	     public void deleteDirectors(Connection con,Scanner scanner) {
	    	try {
				pstatement=con.prepareStatement("delete from Directors where Directorid=?");
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
	     public void getAllDirectors(Connection con) {
	    	try {
				pstatement=con.prepareStatement("select * from Directors");
				
				ResultSet rSet = pstatement.executeQuery();
				System.out.println("--------------------------------------------------------------------");
				while(rSet.next())
					System.out.println(rSet.getInt("Directorid") + " " +
	                        rSet.getString("Directorname"));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }


}










