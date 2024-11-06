package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class WatchHistoryCRUD {

    PreparedStatement pstatement;
    Scanner sc;

    // Insert
    public void insertWatchHistory(Connection con, Scanner scanner) {
        String insertSQL = "INSERT INTO WatchHistory(UserID, MovieID) VALUES(?, ?)";
        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
            System.out.println("Enter values for WatchHistory to insert the record\nEnter UserID:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            System.out.println("Enter MovieID:");
            pstatement.setInt(2, sc.nextInt());

            // Execute the query
            int rowsInserted = pstatement.executeUpdate();
            System.out.println("No. of records inserted: " + rowsInserted);

        } catch (SQLException e) {
            System.out.println("Error inserting WatchHistory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update
    public void updateWatchHistory(Connection con, Scanner scanner) {
        try {
            System.out.println("Enter WatchID to update:");
            sc = scanner;
            int watchID = sc.nextInt();

            System.out.println("Enter your choice\n1.Update UserID\n2.Update MovieID");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    pstatement = con.prepareStatement("UPDATE WatchHistory SET UserID=? WHERE WatchID=?");
                    System.out.println("Enter new UserID:");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, watchID);
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                case 2:
                    pstatement = con.prepareStatement("UPDATE WatchHistory SET MovieID=? WHERE WatchID=?");
                    System.out.println("Enter new MovieID:");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, watchID);
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                default:
                    System.out.println("You have entered a wrong option");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteWatchHistory(Connection con, Scanner scanner) {
        try {
            pstatement = con.prepareStatement("DELETE FROM WatchHistory WHERE WatchID=?");
            System.out.println("Enter WatchID for deleting the record:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all
    public void getAllWatchHistory(Connection con) {
        try {
            pstatement = con.prepareStatement("SELECT * FROM WatchHistory");

            ResultSet rSet = pstatement.executeQuery();
            System.out.println("--------------------------------------------------------------------");
            while (rSet.next()) {
                System.out.println("WatchID: " + rSet.getInt("WatchID") + ", UserID: " + rSet.getInt("User ID") +
                        ", MovieID: " + rSet.getInt("MovieID") + ", WatchDate: " + rSet.getTimestamp("WatchDate"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
