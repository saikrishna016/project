package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MoviesCRUD {
	

	    PreparedStatement pstatement;
	    Scanner sc;

	    // Insert
	     public void insertMovie(Connection con, Scanner scanner) {
	        String insertSQL = "INSERT INTO Movies (Title, ReleaseYear, DurationMinutes, Summary) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
	            sc = scanner;
	            System.out.print("Enter Movie Title: ");
	            pstatement.setString(1, sc.next());
	            System.out.print("Enter Release Year: ");
	            pstatement.setInt(2, sc.nextInt());
	            System.out.print("Enter Duration in Minutes: ");
	            pstatement.setInt(3, sc.nextInt());
	            System.out.print("Enter Summary: ");
	            pstatement.setString(4, sc.next());

	            // Execute the query
	            int rowsInserted = pstatement.executeUpdate();
	            System.out.println("No. of records inserted: " + rowsInserted);
	        } catch (SQLException e) {
	            System.out.println("Error inserting movie: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    // Update
	     public void updateMovie(Connection con, Scanner scanner) {
	        try {
	            System.out.println("Enter your choice\n1. Update Title\n2. Update Release Year\n3. Update Duration\n4. Update Summary\n5. Update Movieid");
	            sc = scanner;
	            int option = sc.nextInt();
	            switch (option) {
	                case 1:
	                    pstatement = con.prepareStatement("UPDATE Movies SET Title = ? WHERE MovieID = ?");
	                    System.out.print("Enter new Title: ");
	                    pstatement.setString(1, sc.next());
	                    System.out.print("Enter MovieID: ");
	                    pstatement.setInt(2, sc.nextInt());
	                    break;
	                case 2:
	                    pstatement = con.prepareStatement("UPDATE Movies SET ReleaseYear = ? WHERE MovieID = ?");
	                    System.out.print("Enter new Release Year: ");
	                    pstatement.setInt(1, sc.nextInt());
	                    System.out.print("Enter MovieID: ");
	                    pstatement.setInt(2, sc.nextInt());
	                    break;
	                case 3:
	                    pstatement = con.prepareStatement("UPDATE Movies SET DurationMinutes = ? WHERE MovieID = ?");
	                    System.out.print("Enter new Duration in Minutes: ");
	                    pstatement.setInt(1, sc.nextInt());
	                    System.out.print("Enter MovieID: ");
	                    pstatement.setInt(2, sc.nextInt());
	                    break;
	                case 4:
	                    pstatement = con.prepareStatement("UPDATE Movies SET Summary = ? WHERE MovieID = ?");
	                    System.out.print("Enter new Summary: ");
	                    pstatement.setString(1, sc.next());
	                    System.out.print("Enter MovieID: ");
	                    pstatement.setInt(2, sc.nextInt());
	                    break;
	                case 5:
	                    pstatement = con.prepareStatement("UPDATE Movies SET MovieID = ? WHERE MovieID = ?");
	                    System.out.print("Enter new MovieID: ");
	                    pstatement.setString(1, sc.next());
	                    System.out.print("Enter MovieID: ");
	                    pstatement.setInt(2, sc.nextInt());
	                    break;
	                default:
	                    System.out.println("You have entered a wrong option");
	                    return;
	            }
	            System.out.println("Update records: " + pstatement.executeUpdate());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Delete
	    public void deleteMovie(Connection con, Scanner scanner) {
	        try {
	            pstatement = con.prepareStatement("DELETE FROM Movies WHERE MovieID = ?");
	            System.out.print("Enter MovieID for deleting the record: ");
	            sc = scanner;
	            int movieId = sc.nextInt();
	            pstatement.setInt(1, movieId);
	            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Select all
	     public void getAllMovies(Connection con) {
	        try {
	            pstatement = con.prepareStatement("SELECT * FROM Movies");
	            ResultSet rSet = pstatement.executeQuery();
	            System.out.println("--------------------------------------------------------------------");
	            while (rSet.next()) {
	                System.out.println(rSet.getInt("MovieID") + " " +
	                                   rSet.getString("Title") + " " +
	                                   rSet.getInt("ReleaseYear") + " " +
	                                   rSet.getInt("DurationMinutes") + " " +
	                                   rSet.getString("Summary") + " " +
	                                   rSet.getTimestamp("CreatedAt"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



		

}
