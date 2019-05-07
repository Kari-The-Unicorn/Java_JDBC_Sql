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

            String drop_orders = "DROP TABLE IF EXISTS ORDERS";
            stmt.executeUpdate(drop_orders);

            String drop_ordered = "DROP TABLE IF EXISTS ORDERED_PRODUCTS";
            stmt.executeUpdate(drop_ordered);

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

            //Create table orders
            String t_orders = "CREATE TABLE ORDERS" +
                    "(Id_Order VARCHAR(6) not NULL, " +
                    "Id_Client VARCHAR(5), " +
                    "Id_Seller VARCHAR(5) not NULL, " +
                    "Order_date DATE not NULL, " +
                    "Order_value DECIMAL(13,2) not NULL, " +
                    "PRIMARY KEY (Id_Order), " +
                    "FOREIGN KEY (Id_Client) " +
                    "REFERENCES Clients (Id_Client), " +
                    "FOREIGN KEY (Id_Seller) " +
                    "REFERENCES Sellers(ID_Seller))";

            stmt.executeUpdate(t_orders);
            System.out.println("Created table orders in database COSMETICS");

            //Create table ordered_products
            String t_ordered_products = "CREATE TABLE ORDERED_PRODUCTS" +
                    "(Id_Ordered_Product VARCHAR(15) not NULL, " +
                    "Id_Order VARCHAR(6), " +
                    "Id_Product INT AUTO_INCREMENT, " +
                    "Order_amount INT not NULL, " +
                    "Price DECIMAL(13,2) not NULL, " +
                    "PRIMARY KEY (Id_Ordered_Product), " +
                    "FOREIGN KEY (Id_Order) " +
                    "REFERENCES Orders (Id_Order), " +
                    "FOREIGN KEY (Id_Product) " +
                    "REFERENCES Products(Id_Product))";

            stmt.executeUpdate(t_ordered_products);
            System.out.println("Created table ordered_products in database COSMETICS");

            //insert into table products
            String insert_pr_1 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Shampoo Pro Volume'," +
                    "'Alverde','Hair','4');";
            stmt.executeUpdate(insert_pr_1);

            String insert_pr_2 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Black Soap'," +
                    "'Speick','Body','7');";
            stmt.executeUpdate(insert_pr_2);

            String insert_pr_3 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Nourishing Cream'," +
                    "'Purite','Face','9');";
            stmt.executeUpdate(insert_pr_3);

            String insert_pr_4 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Body Lotion'," +
                    "'Sylveco','Body','6');";
            stmt.executeUpdate(insert_pr_4);

            String insert_pr_5 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Toothpaste'," +
                    "'Lavera','Tooth','6');";
            stmt.executeUpdate(insert_pr_5);

            String insert_pr_6 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('After Sun Lotion'," +
                    "'Eco Cosmetics','Body','10');";
            stmt.executeUpdate(insert_pr_6);

            String insert_pr_7 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Shaving Cream'," +
                    "'Weleda','Body','8');";
            stmt.executeUpdate(insert_pr_7);

            String insert_pr_8 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Baby Balm'," +
                    "'Badger','Body','5');";
            stmt.executeUpdate(insert_pr_8);

            String insert_pr_9 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Bath Salt'," +
                    "'Kneipp','Body','9');";
            stmt.executeUpdate(insert_pr_9);

            String insert_pr_10 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Orange Body Wash'," +
                    "'Faith in Nature','Body','7');";
            stmt.executeUpdate(insert_pr_10);

            String insert_pr_11 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Conditioning & Styling Elixir','Giovanni','Hair','9');";
            stmt.executeUpdate(insert_pr_11);

            String insert_pr_12 = "INSERT INTO PRODUCTS (Name, Brand, Category, Price) VALUES ('Age Resist Face " +
                    "Cream','Bentley Organic','Face','11');";
            stmt.executeUpdate(insert_pr_12);

            System.out.println("Inserted values into table products in database COSMETICS");

            //insert into table clients
            String insert_cl_1 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('001','Wilson','Kate'," +
                    "'kwilson@gmail.com',' Leeman Road 15','YO1 0AF','York','074-553-402');";
            stmt.executeUpdate(insert_cl_1);

            String insert_cl_2 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('002','Smith','John'," +
                    "'kwilson@gmail.com','Bangors Road South 18','SL0 0AA','Slough','424-544-335');";
            stmt.executeUpdate(insert_cl_2);

            String insert_cl_3 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('003','Montana','Hannah'," +
                    "'hmontana@gmail.com','Knab Road 4','ZE1 0BF','Lerwick','075-546-986');";
            stmt.executeUpdate(insert_cl_3);

            String insert_cl_4 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('004','Luke','Lucky'," +
                    "'lluke@yahoo.com','Victory Street 7','L5 0AA','Liverpool','646-353-232');";
            stmt.executeUpdate(insert_cl_4);

            String insert_cl_5 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('005','Arden','Elizabeth'," +
                    "'aarden@yahoo.com','Queens Place 1','YO1 0AF','York','545-324-321');";
            stmt.executeUpdate(insert_cl_5);

            String insert_cl_6 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('006','Jude','Gary'," +
                    "'jude@gmail.com','Milton Lodge 1','SL5 0AA','Slough','098-643-535');";
            stmt.executeUpdate(insert_cl_6);

            String insert_cl_7 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('007','Churchill','Emily'," +
                    "'emi123@gmail.com','Blacsea Street Flat 15','L1 0AA','Liverpool','664-425-452');";
            stmt.executeUpdate(insert_cl_7);

            String insert_cl_8 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('008','Aighan','Bruce'," +
                    "'brucecute@gmail.com','Thames Valley 3','RG1 1AA','Reading','768-675-235');";
            stmt.executeUpdate(insert_cl_8);

            String insert_cl_9 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('009','Jackan','Ben'," +
                    "'ben111@gmail.com','Grove Road 1','LU1 1AA','London','065-215-402');";
            stmt.executeUpdate(insert_cl_9);

            String insert_cl_10 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('010','Bite','Barnaby'," +
                    "'bbi@gmail.com','Blundell Street 1','L1 0AA','Liverpool','025-575-313');";
            stmt.executeUpdate(insert_cl_10);

            String insert_cl_11 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('011','Ulma','Michelle'," +
                    "'michel@yahoo.com','Liverpool Road 45','LU1 1AA ','London','025-532-745');";
            stmt.executeUpdate(insert_cl_11);

            String insert_cl_12 = "INSERT INTO CLIENTS (Id_Client, Surname, Name, E_mail, Address, " +
                    "Postcode, Place_of_residence, Telephone_Number) VALUES ('012','Orma','Grace'," +
                    "'orma123@gmail.com','Nelson Street 167','L1 0AA','Liverpool','073-334-896');";
            stmt.executeUpdate(insert_cl_12);

            System.out.println("Inserted values into table clients in database COSMETICS");

            //insert into table sellers
            String insert_s_1 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.11 ','Brahman'," +
                    "'Joseph','1300');";
            stmt.executeUpdate(insert_s_1);

            String insert_s_2 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.12 ','Blake'," +
                    "'Julie','1400');";
            stmt.executeUpdate(insert_s_2);

            String insert_s_3 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.13 ','White'," +
                    "'Will','1200');";
            stmt.executeUpdate(insert_s_3);

            String insert_s_4 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.14 ','Somer'," +
                    "'Ben','1540');";
            stmt.executeUpdate(insert_s_4);

            String insert_s_5 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.15 ','Yugoth'," +
                    "'Beatrice','1560');";
            stmt.executeUpdate(insert_s_5);

            String insert_s_6 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.16 ','Place'," +
                    "'Violet','1230');";
            stmt.executeUpdate(insert_s_6);

            String insert_s_7 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.17 ','Walter'," +
                    "'David','1450');";
            stmt.executeUpdate(insert_s_7);

            String insert_s_8 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.18 ','Monta'," +
                    "'Josephine','1230');";
            stmt.executeUpdate(insert_s_8);

            String insert_s_9 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.19 ','Brooks'," +
                    "'Margaret','1100');";
            stmt.executeUpdate(insert_s_9);

            String insert_s_10 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.20 ','Lake'," +
                    "'Melanie','1150');";
            stmt.executeUpdate(insert_s_10);

            String insert_s_11 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.21 ','Winfrey'," +
                    "'Oprah','1240');";
            stmt.executeUpdate(insert_s_11);

            String insert_s_12 = "INSERT INTO SELLERS (Id_Seller, Surname, Name, Salary) VALUES ('01.22 ','Smith'," +
                    "'Maria','1210');";
            stmt.executeUpdate(insert_s_12);

            System.out.println("Inserted values into table sellers in database COSMETICS");

            //insert into table orders
            String insert_o_1 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES" +
                    " ('01.100','004','01.11 ','2018-1-30','12');";
            stmt.executeUpdate(insert_o_1);

            String insert_o_2 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.101','012','01.12','2018-2-13','108');";
            stmt.executeUpdate(insert_o_2);

            String insert_o_3 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.102','012','01.20 ','2018-2-20','201');";
            stmt.executeUpdate(insert_o_3);

            String insert_o_4 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.103','003','01.14 ','2018-4-9','30');";
            stmt.executeUpdate(insert_o_4);

            String insert_o_5 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.104','008','01.22 ','2018-4-30','75');";
            stmt.executeUpdate(insert_o_5);

            String insert_o_6 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.105','005','01.17 ','2018-5-1','14');";
            stmt.executeUpdate(insert_o_6);

            String insert_o_7 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.106','008','01.15 ','2018-5-26','18');";
            stmt.executeUpdate(insert_o_7);

            String insert_o_8 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.107','002','01.16 ','2019-3-1','56');";
            stmt.executeUpdate(insert_o_8);

            String insert_o_9 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES " +
                    "('01.108','001','01.19 ','2019-2-27','120');";
            stmt.executeUpdate(insert_o_9);

            String insert_o_10 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES" +
                    " ('01.109','010','01.19 ','2019-3-13','105');";
            stmt.executeUpdate(insert_o_10);

            String insert_o_11 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES" +
                    " ('01.110','010','01.14 ','2019-4-14','126');";
            stmt.executeUpdate(insert_o_11);

            String insert_o_12 = "INSERT INTO ORDERS (Id_Order, Id_Client, Id_Seller, Order_date, Order_value) VALUES" +
                    " ('01.111','002','01.13 ','2018-12-17','13');";
            stmt.executeUpdate(insert_o_12);

            System.out.println("Inserted values into table orders in database COSMETICS");

            //insert into table ordered_products
            String insert_op_1 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.11.Z','01.100','1','1','12');";
            stmt.executeUpdate(insert_op_1);

            String insert_op_2 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.12.Z','01.109','11','9','288');";
            stmt.executeUpdate(insert_op_2);

            String insert_op_3 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.13.Z','01.101','3','3','81');";
            stmt.executeUpdate(insert_op_3);

            String insert_op_4 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.14.Z','01.102','2','7','105');";
            stmt.executeUpdate(insert_op_4);

            String insert_op_5 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.15.Z','01.106','5','3','66');";
            stmt.executeUpdate(insert_op_5);

            String insert_op_6 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.16.Z','01.107','7','6','156');";
            stmt.executeUpdate(insert_op_6);

            String insert_op_7 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.17.Z','01.108','8','7','133');";
            stmt.executeUpdate(insert_op_7);

            String insert_op_8 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.18.Z','01.103','11','3','66');";
            stmt.executeUpdate(insert_op_8);

            String insert_op_9 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.19.Z','01.104','12','6','156');";
            stmt.executeUpdate(insert_op_9);

            String insert_op_10 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.20.Z','01.105','2','7','133');";
            stmt.executeUpdate(insert_op_10);

            String insert_op_11 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.21.Z','01.111','5','2','30');";
            stmt.executeUpdate(insert_op_11);

            String insert_op_12 = "INSERT INTO ORDERED_PRODUCTS (Id_Ordered_Product, Id_Order, Id_Product, Order_amount, Price) VALUES" +
                    " ('PKD01.22.Z','01.110','4','5','95');";
            stmt.executeUpdate(insert_op_12);

            System.out.println("Inserted values into table ordered_products in database COSMETICS");

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
