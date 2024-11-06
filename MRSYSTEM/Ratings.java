package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.RatingsCRUD;

public class Ratings extends RatingsCRUD {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject", "root", "sai100");
            
            RatingsCRUD rc = new RatingsCRUD();		
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("Select Your Choice.\n 1.Insert Rating \n2.Update Rating \n3."
                        + "Delete Rating\n 4.Get all Ratings \n5.exit:\nEnter your Option:");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1: 
                        rc.insertRating(connection, scanner);
                        break;
                    case 2: 
                        rc.updateRating(connection, scanner);
                        break;
                    case 3: 
                        rc.deleteRating(connection, scanner);
                        break;
                    case 4: 
                        rc.getAllRatings(connection);
                        break;
                    case 5: 
                        System.out.println("Thank you for using this App: Bye");
                        System.exit(0);
                        break;
                    default: 
                        System.out.println("Enter valid option");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
