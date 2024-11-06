package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.ReviewsCRUD;

public class Reviews  extends ReviewsCRUD {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject", "root", "sai100");
            
            ReviewsCRUD rc = new ReviewsCRUD();        
            while (true) {
                System.out.println("Select Your Choice.\n 1.Insert Review \n2.Update Review \n3."
                        + "Delete Review\n 4.Get all Reviews \n5.exit:\nEnter your Option:");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: 
                        rc.insertReview(connection, scanner);
                        break;
                    case 2: 
                        rc.updateReview(connection, scanner);
                        break;
                    case 3:
                        rc.deleteReview(connection, scanner);
                        break;
                    case 4:
                        rc.getAllReviews(connection);
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
