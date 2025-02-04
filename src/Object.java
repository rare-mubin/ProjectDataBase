package src;
import java.sql.*;
 
public class Object {
 
    public static void main(String[] args) {
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // register jdbc driver of mysql,Driver Registration
            //This line ensures that the MySQL JDBC driver is loaded and registered with the JDBC API. It allows your application to connect to the MySQL database.
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mubin", "root", ""); //Establishing a Connection
            //This line establishes a connection to the database named newdb running on localhost at the default MySQL port 3306.
            //DriverManager.getConnection() returns a Connection object which represents the session with the database.
            System.out.println("connected");//printing that database is connected
            Statement st = conn.createStatement();//Creating a Statement which allows you to send SQL queries to the database.
            ResultSet rs = st.executeQuery("select * from student");//Executing the SQL Query
            while (rs.next()) {//moves the cursor to the next row of the result set. If there are no more rows, it returns false, terminating the loop.
                System.out.println("ID=" + rs.getInt(1) );
                System.out.println("Name=" + rs.getString(2) );
                System.out.println("section=" + rs.getString(3) );
 
            }
           // Connection.close(); //This line is commented out, which means the connection is not being closed after use. This could lead to resource leaks (open database connections that aren't cleaned up).
           //Ideally, you should close the connection after completing your operations. You can do this either by explicitly calling conn.close() or by using try-with-resources for automatic resource management.
        } catch (Exception s) {
            System.out.println(s);
        }
    }
}
 
 
//javac -cp Driver.jar;. Object.java
//java -cp Driver.jar;. Object
 
 
/*  System.out.println("SID=" + rs.getInt(1) + " First Name=" + rs.getString(2) + " Last Name=" + rs.getString(3) + " Department=" + rs.getString(4));// Processing the ResultSet*/