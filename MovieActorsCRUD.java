package MRSOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MovieActorsCRUD {

    PreparedStatement pstatement;
    Scanner sc;

    // Insert
    public void insertMovieActor(Connection con, Scanner scanner) {
        String insertSQL = "INSERT INTO MovieActors(MovieID, ActorID) VALUES(?, ?)";
        try (PreparedStatement pstatement = con.prepareStatement(insertSQL)) {
            System.out.println("Enter values for MovieActors to insert the record\nEnter MovieID:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            System.out.println("Enter ActorID:");
            pstatement.setInt(2, sc.nextInt());

            // Execute the query
            int rowsInserted = pstatement.executeUpdate();
            System.out.println("No. of records inserted: " + rowsInserted);

        } catch (SQLException e) {
            System.out.println("Error inserting MovieActor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update
    public void updateMovieActor(Connection con, Scanner scanner) {
        try {
            System.out.println("Enter MovieID and ActorID to update:");
            sc = scanner;
            int movieID = sc.nextInt();
            int actorID = sc.nextInt();

            System.out.println("Enter your choice\n1.Update MovieID\n2.Update ActorID");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    pstatement = con.prepareStatement("UPDATE MovieActors SET MovieID=? WHERE ActorID=?");
                    System.out.println("Enter new MovieID:");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, actorID);
                    System.out.println("Update records: " + pstatement.executeUpdate());
                    break;
                case 2:
                    pstatement = con.prepareStatement("UPDATE MovieActors SET ActorID=? WHERE MovieID=?");
                    System.out.println("Enter new ActorID:");
                    pstatement.setInt(1, sc.nextInt());
                    pstatement.setInt(2, movieID);
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
    public void deleteMovieActor(Connection con, Scanner scanner) {
        try {
            pstatement = con.prepareStatement("DELETE FROM MovieActors WHERE MovieID=? AND ActorID=?");
            System.out.println("Enter MovieID and ActorID for deleting the record:");
            sc = scanner;
            pstatement.setInt(1, sc.nextInt());
            pstatement.setInt(2, sc.nextInt());
            System.out.println("No. of Records deleted: " + pstatement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all
    public void getAllMovieActors(Connection con) {
        try {
            pstatement = con.prepareStatement("SELECT * FROM MovieActors");

            ResultSet rSet = pstatement.executeQuery();
            System.out.println("---------------------------------------------------");
            while (rSet.next()) {
                System.out.println("MovieID: " + rSet.getInt("MovieID") + ", ActorID: " + rSet.getInt("ActorID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
