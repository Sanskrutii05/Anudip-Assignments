package com.project;

import java.sql.*;
import java.util.Scanner;

class aasignment1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/sys";
        String username = "root";
        String password = "1234";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            // Create table
            String createTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "USER_ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NAME VARCHAR(50), " +
                    "CITY VARCHAR(50))";
            st.executeUpdate(createTable);

            // Input
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            // Insert
            String insertQuery = "INSERT INTO users (NAME, CITY) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, name);
            ps.setString(2, city);
            ps.executeUpdate();

            System.out.println("\nData Inserted Successfully!\n");

            // Display
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("USER_ID") + " | " +
                        rs.getString("NAME") + " | " +
                        rs.getString("CITY")
                );
            }
            sc.close();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
