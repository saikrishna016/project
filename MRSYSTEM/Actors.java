package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.ActorsCRUD;

public class Actors extends ActorsCRUD {
    
	 public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject", "root", "sai100");
	                 Scanner scanner = new Scanner(System.in)) {
	                
	                ActorsCRUD ac = new ActorsCRUD();
	                while (true) {
	                    
	                    int choice = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline left-over
	                    switch (choice) {
	                        case 1:
	                            ac.insertActors(connection, scanner);
	                            break;
	                        case 2:
	                            ac.updateActors(connection, scanner);
	                            break;
	                        case 3:
	                            ac.deleteActors(connection, scanner);
	                            break;
	                        case 4:
	                            ac.getAllActors(connection);
	                            break;
	                        case 5:
	                            System.out.println("Thank you for using this App: Bye");
	                            return; // Use return to exit the method and end the program
	                        default:
	                            System.out.println("Enter a valid option");
	                            break;
	                    }
	                }
	            }
	        
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}

