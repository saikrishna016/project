package MRSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import MRSOperations.WatchHistoryCRUD;

public class WatchHistory extends WatchHistoryCRUD {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myproject", "root", "sai100");
            
            WatchHistoryCRUD whc = new WatchHistoryCRUD();        
            while (true) {
                System.out.println("Select Your Choice.\n 1.Insert Watch History \n2.Update Watch History \n3."
                        + "Delete Watch History\n 4.Get all Watch History \n5.exit:\nEnter your Option:");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: 
                        whc.insertWatchHistory(connection, scanner);
                        break;
                    case 2: 
                        whc.updateWatchHistory(connection, scanner);
                        break;
                    case 3:
                        whc.deleteWatchHistory(connection, scanner);
                        break;
                    case 4:
                        whc.getAllWatchHistory(connection);
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
