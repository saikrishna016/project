package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.MovieActorsCRUD;

public class MovieActors  extends MovieActorsCRUD {
    
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
      
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject","root","sai100");
		
		MovieActorsCRUD ma=new MovieActorsCRUD();		
		while(true) {
			System.out.println("Select Your Choice.\n 1.Insert Users \n2.Update Users \n3."
					+ "Delete User\n 4.Get all Users \n5.exit:\nEnter your Option:");
			Scanner scanner=new Scanner(System.in);
			int choice=scanner.nextInt();
			switch(choice) {
			case 1: ma.insertMovieActor(connection,scanner);
	        break;
	        case 2: ma.updateMovieActor(connection,scanner);
            break;
	        case 3:ma.deleteMovieActor(connection,scanner);
            break;
	        case 4:ma.getAllMovieActors(connection);
             break;
	        case 5:System.out.println("Thank you for using this App:Bye");
		   System.exit(0);
            break;
	       default:System.out.println("Enter valid option");
           break;
	    
	}
}
}catch(Exception e) {
	System.out.println(e);
}
}

}
