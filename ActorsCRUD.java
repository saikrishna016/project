package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ActorsCRUD {

			PreparedStatement pstatement;
			Scanner sc;
			//insert
			 public void insertActors(Connection con,Scanner scanner) {
				String insertSQL = "INSERT INTO Actor(Actorname) VALUES(?,)";
				try(PreparedStatement pstatement = con.prepareStatement(insertSQL)){
					System.out.println("Enter values for the Actor to insert the record\nEnter Actorname of the Actor:");
					
					sc=scanner;
					pstatement.setString(1, sc.next());
					
					//execute the query
					int rowsInserted = pstatement.executeUpdate();
					System.out.println("No. of records inserted:"+ rowsInserted);
					
				 } catch (SQLException e) {
				        System.out.println("Error inserting user: " + e.getMessage());
				        e.printStackTrace();
				    }
				}
			//update
		     public void updateActors(Connection con,Scanner scanner) {
		    	try {
		    		System.out.println("Enter your choice\n1.Update ActorName");
		    		sc=scanner;
		    		int option=sc.nextInt();
		    		switch(option) {
		    		case 1:pstatement=con.prepareStatement("UPDATE Actors SET ActorName = ? WHERE ActorID = ?");
		    		      System.out.println("enter   new Actorname");       
		    		      pstatement.setString(1, sc.next());
		    		      System.out.print("Enter ActorID: ");
		    		      pstatement.setInt(2, sc.nextInt());
					      System.out.println("Update records: "+pstatement.executeUpdate());
					      break;
					

				    default:
				    	  System.out.println("you have entered wrong option");
					      break;
					
		  		}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  	
		  }
		    //delete
		     public void deleteActors(Connection con,Scanner scanner) {
		    	try {
					pstatement=con.prepareStatement("delete from Actors where Actorid=?");
					System.out.println("Enter Actorid for deleting the record:");
					sc=scanner;
					int Actorid=sc.nextInt();
					pstatement.setInt(1, Actorid);
					System.out.println("No.of Records deleted:"+pstatement.executeUpdate());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
		    //select all 
		     public void getAllActors(Connection con) {
		    	try {
					pstatement=con.prepareStatement("select * from Actor");
					
					ResultSet rSet = pstatement.executeQuery();
					System.out.println("--------------------------------------------------------------------");
					while(rSet.next())
						System.out.println(rSet.getInt("Actorid") + " " +
		                        rSet.getString("Actorname"));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }


	  }


