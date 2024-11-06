package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.UsersCRUD;

public class Users extends UsersCRUD {
    
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
      
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject","root","sai100");
		
		UsersCRUD uc=new UsersCRUD();		
		while(true) {
			System.out.println("Select Your Choice.\n 1.Insert Users \n2.Update Users \n3."
					+ "Delete User\n 4.Get all Users \n5.exit:\nEnter your Option:");
			Scanner scanner=new Scanner(System.in);
			int choice=scanner.nextInt();
			switch(choice) {
			case 1: uc.insertUsers(connection,scanner);
	        break;
	        case 2: uc.updateUsers(connection,scanner);
            break;
	        case 3:uc.deleteUsers(connection,scanner);
            break;
	        case 4:uc.getAllUsers(connection);
             break;
	        case 5:System.out.println("Thank you for using this App:Bye");
		   System.exit(0);
            break;
	       default:System.out.println("Enter valid option");
           break;
	    
	        }
       }
   }
		catch(Exception e) {
	System.out.println(e);
    }
  }

}


