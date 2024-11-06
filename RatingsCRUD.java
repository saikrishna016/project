package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RatingsCRUD {

    PreparedStatement pstatement;
    Scanner sc;

    // Insert
    public void insertRating(Connection con, Scanner scanner) {
        String insertSQL = "INSERT INTO Ratings(UserID, MovieID, Rating) VALUES(?, ?, ?)";
        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
            System.out.println("Enter UserID for the Rating:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            System.out.println("Enter MovieID for the Rating:");
            pstatement.setInt(2, sc.nextInt());
            System.out.print("Enter Rating (1-5): ");
            pstatement.setInt(3, sc.nextInt());

            // Execute the query
            int rowsInserted = pstatement.executeUpdate();
            System.out.println("No. of records inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("Error inserting rating: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update
    public void updateRating(Connection con, Scanner scanner) {
        try {
            System.out.println("Enter the RatingID to update:");
            sc = scanner;
            int ratingID = sc.nextInt();
            System.out.println("Enter your choice\n1.Update UserID\n2.Update MovieID\n3.Update Rating");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    pstatement = con.prepareStatement("UPDATE Ratings SET UserID=? WHERE RatingID=?");
                    System.out.print("Enter new UserID: ");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, ratingID);
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                case 2:
                    pstatement = con.prepareStatement("UPDATE Ratings SET MovieID=? WHERE RatingID=?");
                    System.out.print("Enter new MovieID: ");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, ratingID);
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                case 3:
                    pstatement = con.prepareStatement("UPDATE Ratings SET Rating=? WHERE RatingID=?");
                    System.out.print("Enter new Rating (1-5): ");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, ratingID);
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
    public void deleteRating(Connection con, Scanner scanner) {
        try {
            pstatement = con.prepareStatement("DELETE FROM Ratings WHERE RatingID=?");
            System.out.println("Enter RatingID for deleting the record:");
            sc = scanner;
            int ratingID = sc.nextInt();
            pstatement.setInt(1, ratingID);
            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select All
    public void getAllRatings(Connection con) {
        try {
            pstatement = con.prepareStatement("SELECT * FROM Ratings");
            ResultSet rSet = pstatement.executeQuery();
            System.out.println("--------------------------------------------------------------------");
            while (rSet.next()) {
                System.out.println("RatingID: " + rSet.getInt("RatingID") + ", UserID: " + rSet.getInt("User ID") +
                        ", MovieID: " + rSet.getInt("MovieID") + ", Rating: " + rSet.getInt("Rating") +
                        ", RatingDate: " + rSet.getTimestamp("RatingDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



