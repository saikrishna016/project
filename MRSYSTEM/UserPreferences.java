package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.UserPreferencesCRUD;

public class UserPreferences   {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject", "root", "sai100");
            
            UserPreferencesCRUD upc = new UserPreferencesCRUD();		
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("Select Your Choice.\n 1.Insert User Preference \n2.Update User Preference \n3."
                        + "Delete User Preference\n 4.Get all User Preferences \n5.exit:\nEnter your Option:");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1: 
                        upc.insertUserPreference(connection, scanner);
                        break;
                    case 2: 
                        upc.updateUserPreference(connection, scanner);
                        break;
                    case 3: 
                        upc.deleteUserPreference(connection, scanner);
                        break;
                    case 4: 
                        upc.getAllUserPreferences(connection);
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


