package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.GenresCRUD;

public class Genres extends GenresCRUD{

    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject", "root", "sai100");
            GenresCRUD gc = new GenresCRUD();        
            
            while (true) {
                System.out.println("Select Your Choice.\n" +
                                   "1. Insert Genre\n" +
                                   "2. Update Genre\n" +
                                   "3. Delete Genre\n" +
                                   "4. Get all Genres\n" +
                                   "5. Exit\n" +
                                   "Enter your Option:");
    			int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        gc.insertGenre(connection, scanner);
                        break;
                    case 2:
                        gc.updateGenre(connection, scanner);
                        break;
                    case 3:
                        gc.deleteGenre(connection, scanner);
                        break;
                    case 4:
                        gc.getAllGenres(connection);
                        break;
                    case 5:
                        System.out.println("Thank you for using this App: Bye");
                        return; // Exit the loop and program
                    default:
                        System.out.println("Enter a valid option");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
    }
}