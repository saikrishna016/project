package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReviewsCRUD {

    PreparedStatement pstatement;
    Scanner sc;

    // Insert
    public void insertReview(Connection con, Scanner scanner) {
        String insertSQL = "INSERT INTO Reviews(UserID, MovieID, ReviewText) VALUES(?, ?, ?)";
        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
            System.out.println("Enter values for the Review to insert the record\nEnter UserID:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            System.out.println("Enter MovieID:");
            pstatement.setInt(2, sc.nextInt());
            System.out.println("Enter Review Text:");
            pstatement.setString(3, sc.next());

            // Execute the query
            int rowsInserted = pstatement.executeUpdate();
            System.out.println("No. of records inserted: " + rowsInserted);

        } catch (SQLException e) {
            System.out.println("Error inserting review: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update
    public void updateReview(Connection con, Scanner scanner) {
        try {
            System.out.println("Enter ReviewID to update:");
            sc = scanner;
            int reviewID = sc.nextInt();

            System.out.println("Enter your choice\n1.Update Review Text");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    pstatement = con.prepareStatement("UPDATE Reviews SET ReviewText=? WHERE ReviewID=?");
                    System.out.println("Enter new Review Text:");
                    pstatement.setString(1, sc.next());
                    pstatement.setInt(2, reviewID);
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
    public void deleteReview(Connection con, Scanner scanner) {
        try {
            pstatement = con.prepareStatement("DELETE FROM Reviews WHERE ReviewID=?");
            System.out.println("Enter ReviewID for deleting the record:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all
    public void getAllReviews(Connection con) {
        try {
            pstatement = con.prepareStatement("SELECT * FROM Reviews");

            ResultSet rSet = pstatement.executeQuery();
            System.out.println("--------------------------------------------------------------------");
            while (rSet.next()) {
                System.out.println("ReviewID: " + rSet.getInt("ReviewID") + 
                                   ", UserID: " + rSet.getInt("User ID") + 
                                   ", MovieID: " + rSet.getInt("MovieID") + 
                                   ", ReviewText: " + rSet.getString("ReviewText") + 
                                   ", ReviewDate: " + rSet.getTimestamp("ReviewDate"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
