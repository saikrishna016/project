package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MovieGenresCRUD {


    PreparedStatement pstatement;
    Scanner sc;

    // Insert
    public void insertMovieGenre(Connection con, Scanner scanner) {
        String insertSQL = "INSERT INTO MovieGenres(MovieID, GenreID,) VALUES(?, ?)";
        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
            sc = scanner;
            System.out.print("Enter MovieID: ");
            pstatement.setInt(1, sc.nextInt());
            System.out.print("Enter GenreID: ");
            pstatement.setInt(2, sc.nextInt());

            // Execute the query
            int rowsInserted = pstatement.executeUpdate();
            System.out.println("No. of records inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("Error inserting movie genre: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update
    public void updateMovieGenre(Connection con, Scanner scanner) {
        try {
            System.out.println("Enter your choice\n1.Update MovieID\n2.Update GenreID");
            sc = scanner;
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    pstatement = con.prepareStatement("UPDATE MovieGenres SET MovieID=? WHERE GenreID=?");
                    System.out.print("Enter new MovieID: ");
                    pstatement.setInt(1, sc.nextInt());
                    System.out.print("Enter GenreID: ");
                    pstatement.setInt(2, sc.nextInt());
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                case 2:
                    pstatement = con.prepareStatement("UPDATE MovieGenres SET GenreID=? WHERE MovieID=?");
                    System.out.print("Enter new GenreID: ");
                    pstatement.setInt(1, sc.nextInt());
                    System.out.print("Enter MovieID: ");
                    pstatement.setInt(2, sc.nextInt());
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
    public void deleteMovieGenre(Connection con, Scanner scanner) {
        try {
            pstatement = con.prepareStatement("DELETE FROM MovieGenres WHERE MovieID=? AND GenreID=?");
            sc = scanner;
            System.out.print("Enter MovieID: ");
            pstatement.setInt(1, sc.nextInt());
            System.out.print("Enter GenreID: ");
            pstatement.setInt(2, sc.nextInt());
            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select All
    public void getAllMovieGenres(Connection con) {
        try {
            pstatement = con.prepareStatement("SELECT * FROM MovieGenres");
            ResultSet rSet = pstatement.executeQuery();
            System.out.println("----------------------------------------------------");
            while (rSet.next()) {
                System.out.println("MovieID: " + rSet.getInt("MovieID") + ", GenreID: " + rSet.getInt("GenreID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



