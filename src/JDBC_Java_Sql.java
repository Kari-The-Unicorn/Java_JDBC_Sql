import java.sql.*;

public class JDBC_Java_Sql {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/phpmyadmin?useUnicode=true&useJDBCCompliantTimezoneShift" +
        "=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";


    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC_Java_SQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql_drop = "DROP DATABASE IF EXISTS COSMETICS";
            stmt.executeUpdate(sql_drop);

            String sql_create = "CREATE DATABASE COSMETICS";
            stmt.executeUpdate(sql_create);

            String drop_procucts = "DROP TABLE IF EXISTS PRODUCTS";
            stmt.executeUpdate(drop_procucts);

            String drop_clients = "DROP TABLE IF EXISTS CLIENTS";
            stmt.executeUpdate(drop_clients);

            String drop_sellers = "DROP TABLE IF EXISTS SELLERS";
            stmt.executeUpdate(drop_sellers);

            String sql_use = "USE COSMETICS";
            stmt.executeUpdate(sql_use);

            //Create table Products
            String t_products = "CREATE TABLE PRODUCTS" +
                    "(Id_Product INT not NULL AUTO_INCREMENT," +
                            " Name VARCHAR(100) not NULL, " +
                            "Brand VARCHAR(25) not NULL, " +
                            "Category VARCHAR(15) not NULL, " +
                            "Price DECIMAL(13,2) not NULL, " +
                            "PRIMARY KEY (ID_Product))";

            stmt.executeUpdate(t_products);
            System.out.println("Created table Products in database COSMETICS");

            //Create table Clients
            String t_clients = "CREATE TABLE CLIENTS" +
                    "(Id_Client VARCHAR(5) not NULL," +
                    " Surname VARCHAR(30) not NULL, " +
                    "Name VARCHAR(30) not NULL, " +
                    "E_mail VARCHAR(50) not NULL, " +
                    "Address VARCHAR(50) not NULL, " +
                    "Postcode VARCHAR(10) not NULL, " +
                    "Place_of_residence VARCHAR(40) not NULL, " +
                    "Telephone_Number VARCHAR(30) not NULL, " +
                    "PRIMARY KEY (ID_Client))";

            stmt.executeUpdate(t_clients);
            System.out.println("Created table Clients in database COSMETICS");

            //Create table sellers
            String t_sellers = "CREATE TABLE SELLERS" +
                    "(Id_Seller VARCHAR(5) not NULL," +
                    " Surname VARCHAR(30) not NULL, " +
                    "Name VARCHAR(30) not NULL, " +
                    "Salary DECIMAL(13,2) not NULL, " +
                    "PRIMARY KEY (ID_Seller))";

            stmt.executeUpdate(t_sellers);
            System.out.println("Created table Sellers in database COSMETICS");
            

        }catch(SQLException se){
            //Handle errors for JDBC_Java_SQL
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }

}
