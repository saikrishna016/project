package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.MovieGenresCRUD;

public class MovieGenres extends MovieGenresCRUD {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject", "root", "sai100");
            
            MovieGenresCRUD mgc = new MovieGenresCRUD();		
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("Select Your Choice.\n 1.Insert Movie Genre \n2.Update Movie Genre \n3."
                        + "Delete Movie Genre\n 4.Get all Movie Genres \n5.exit:\nEnter your Option:");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1: 
                        mgc.insertMovieGenre(connection, scanner);
                        break;
                    case 2: 
                        mgc.updateMovieGenre(connection, scanner);
                        break;
                    case 3: 
                        mgc.deleteMovieGenre(connection, scanner);
                        break;
                    case 4: 
                        mgc.getAllMovieGenres(connection);
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


