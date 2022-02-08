package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;


    public class DBlogic {

        // defaults for connection MySQL Workbench
        String URL = "jdbc:mysql://localhost:3306/java_CRUD";
        String USER = "root";
        String PASSWORD = "SamoleT134$";


        // CREATE/insert
        public void insert() {

            try (
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            ) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO new_data VALUE (?,?,?,?,?,?)");

                statement.setInt(1, 1);
                statement.setString(2, "SIA GEMOSS");
                statement.setString(3, "Vīna glāze PURE 300 ml");
                statement.setDouble(4, 6.28);
                statement.setInt(5, 10);
                statement.setDouble(6, 62.80);

                int insert = statement.executeUpdate();
                System.out.println(insert + " " + "Data inserted");

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // READ/select
        public void select() {

            try (
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            ) {
                PreparedStatement statement = connection.prepareStatement("SELECT Customer, Product, Price FROM new_data WHERE id = ?");

                statement.setInt(1, 1);

                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    System.out.println("Customer:" + " " + result.getString("Customer"));
                    System.out.println("Product:" + " " + result.getString("Product"));
                    System.out.println("Price:" + " " + result.getDouble("Price"));
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // UPDATE
        public void update() {

            try (
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)
            ) {
                PreparedStatement statement = connection.prepareStatement("UPDATE new_data SET id = ?, Customer = ?, Price = ?, Value = ? WHERE Product = ?");

                statement.setInt(1, 2);
                statement.setString(2, "SIA ARKOLAT");
                statement.setDouble(3, 5.88);
                statement.setDouble(4, 58.80);
                statement.setString(5, "Vīna glāze PURE 300 ml");

                int update = statement.executeUpdate();
                System.out.println(update + " " + "Data updated");

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // DELETE
        public void delete() {
            
            try (
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)

            ) {
                PreparedStatement statement = connection.prepareStatement("DELETE FROM new_data WHERE Customer = ?");

                statement.setString(1, "SIA ARKOLAT");

                int delete = statement.executeUpdate();
                System.out.println(delete + " " + "Data deleted");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

