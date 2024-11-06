package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.DirectorsCRUD;

public class Directors {

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
      
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject","root","sai100");
		
		DirectorsCRUD dc=new DirectorsCRUD();		
		while(true) {
			System.out.println("Select Your Choice.\n 1.Insert Directors \n2.Update Directors \n3."
					+ "Delete Directors\n 4.Get all Directors \n5.exit:\nEnter your Option:");
			Scanner scanner=new Scanner(System.in);
			int choice=scanner.nextInt();
			switch(choice) {
			case 1: dc.insertDirectors(connection,scanner);
	        break;
	        case 2: dc.updateDirectors(connection,scanner);
            break;
	        case 3:dc.deleteDirectors(connection,scanner);
            break;
	        case 4:dc.getAllDirectors(connection);
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
