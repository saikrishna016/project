package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.MoviesCRUD;

public class Movies extends MoviesCRUD {


    public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
      
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject","root","sai100");
		
		MoviesCRUD mc=new MoviesCRUD();		
		while(true) {
			System.out.println("Select Your Choice.\n" +
                    "1. Insert Movie\n" +
                    "2. Update Movie\n" +
                    "3. Delete Movie\n" +
                    "4. Get all Movies\n" +
                    "5. Exit\n" +
                    "Enter your Option:");
			Scanner scanner=new Scanner(System.in);
			int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    mc.insertMovie(connection, scanner);
                    break;
                case 2:
                    mc.updateMovie(connection, scanner);
                    break;
                case 3:
                    mc.deleteMovie(connection, scanner);
                    break;
                case 4:
                    mc.getAllMovies(connection);
                    break;
                case 5:
                    System.out.println("Thank you for using this App: Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
	    
	}
}
}catch(Exception e) {
	System.out.println(e);
}
}
}



