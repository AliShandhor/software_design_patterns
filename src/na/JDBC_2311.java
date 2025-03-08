package na;

import java.sql.*;

public class JDBC_2311 {
    public static void main(String[] args) {
        String dbName = "2311Labtest3";
        String dbUser = "postgres";
        String userPassword = "Ali0558585245$"; // Replace with your actual password
        String url = "jdbc:postgresql://localhost:5432/" + dbName;

        try {
            // Establish the connection to the PostgreSQL database
            Connection connection = DriverManager.getConnection(url, dbUser, userPassword);
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Create a statement and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Loan");

            // Print result set in table format
            System.out.println("Loan Table Info:");
            System.out.println("loanId | isbn | memberId");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("loanId") + " | " +
                        resultSet.getString("isbn") + " | " +
                        resultSet.getInt("memberId"));
            }

            // Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
