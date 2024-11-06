package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserPreferencesCRUD {

    PreparedStatement pstatement;
    Scanner sc;

    // Insert
    public void insertUserPreference(Connection con, Scanner scanner) {
        String insertSQL = "INSERT INTO UserPreferences(UserID, GenreID, PreferenceLevel) VALUES(?, ?, ?)";
        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
            System.out.println("Enter UserID for the User Preference:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            System.out.println("Enter GenreID for the User Preference:");
            pstatement.setInt(2, sc.nextInt());
            System.out.print("Enter Preference Level (1-5): ");
            pstatement.setInt(3, sc.nextInt());

            // Execute the query
            int rowsInserted = pstatement.executeUpdate();
            System.out.println("No. of records inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("Error inserting user preference: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update
    public void updateUserPreference(Connection con, Scanner scanner) {
        try {
            System.out.println("Enter the PreferenceID to update:");
            sc = scanner;
            int preferenceID = sc.nextInt();
            System.out.println("Enter your choice\n1.Update UserID\n2.Update GenreID\n3.Update PreferenceLevel");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    pstatement = con.prepareStatement("UPDATE UserPreferences SET UserID=? WHERE PreferenceID=?");
                    System.out.print("Enter new UserID: ");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, preferenceID);
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                case 2:
                    pstatement = con.prepareStatement("UPDATE UserPreferences SET GenreID=? WHERE PreferenceID=?");
                    System.out.print("Enter new GenreID: ");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, preferenceID);
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                case 3:
                    pstatement = con.prepareStatement("UPDATE UserPreferences SET PreferenceLevel=? WHERE PreferenceID=?");
                    System.out.print("Enter new Preference Level (1-5): ");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, preferenceID);
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
    public void deleteUserPreference(Connection con, Scanner scanner) {
        try {
            pstatement = con.prepareStatement("DELETE FROM UserPreferences WHERE PreferenceID=?");
            System.out.println("Enter PreferenceID for deleting the record:");
            sc = scanner;
            int preferenceID = sc.nextInt();
            pstatement.setInt(1, preferenceID);
            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select All
    public void getAllUserPreferences(Connection con) {
        try {
            pstatement = con.prepareStatement("SELECT * FROM UserPreferences");
            ResultSet rSet = pstatement.executeQuery();
            System.out.println("--------------------------------------------------------------------");
            while (rSet.next())
                System.out.println("PreferenceID: " + rSet.getInt("PreferenceID") +
                        ", UserID: " + rSet.getInt("User ID") +
                        ", GenreID: " + rSet.getInt("GenreID") +
                        ", PreferenceLevel: " + rSet.getInt("PreferenceLevel"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
