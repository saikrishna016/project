package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GenresCRUD {
    
    // Insert
    public void insertGenre(Connection con, Scanner scanner) {
        String insertSQL = "INSERT INTO Genres (GenreID, GenreName) VALUES (?, ?)";
        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
            System.out.print("Enter GenreID: ");
            pstatement.setInt(1, scanner.nextInt());
            System.out.print("Enter GenreName: ");
            pstatement.setString(2, scanner.next());
            
            // Execute the query
            int rowsInserted = pstatement.executeUpdate();
            System.out.println("No. of records inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("Error inserting genre: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update
    public void updateGenre(Connection con, Scanner scanner) {
        try {
            System.out.println("Enter your choice\n1. Update GenreID\n2. Update GenreName");
            int option = scanner.nextInt();
            String updateSQL = "";
            switch (option) {
                case 1:
                    updateSQL = "UPDATE Genres SET GenreID = ? WHERE GenreID = ?";
                    break;
                case 2:
                    updateSQL = "UPDATE Genres SET GenreName = ? WHERE GenreID = ?";
                    break;
                default:
                    System.out.println("You have entered a wrong option");
                    return;
            }
            try (PreparedStatement pstatement = con.prepareStatement(updateSQL)) {
                if (option == 1) {
                    System.out.print("Enter new GenreID: ");
                    pstatement.setInt(1, scanner.nextInt());
                } else {
                    System.out.print("Enter new GenreName: ");
                    pstatement.setString(1, scanner.next());
                }
                System.out.print("Enter GenreID: ");
                pstatement.setInt(2, scanner.nextInt());
                System.out.println("Update records: " + pstatement.executeUpdate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  

    // Delete
    public void deleteGenre(Connection con, Scanner scanner) {
        try (PreparedStatement pstatement = con.prepareStatement("DELETE FROM Genres WHERE GenreID = ?")) {
            System.out.print("Enter GenreID for deleting the record: ");
            int genreId = scanner.nextInt();
            pstatement.setInt(1, genreId);
            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all
    public void getAllGenres(Connection con) {
        try (PreparedStatement pstatement = con.prepareStatement("SELECT * FROM Genres");
             ResultSet rSet = pstatement.executeQuery()) {
            System.out.println("--------------------------------------------------------------------");
            while (rSet.next()) {
                System.out.println(rSet.getInt("GenreID") + " " +
                                   rSet.getString("GenreName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}