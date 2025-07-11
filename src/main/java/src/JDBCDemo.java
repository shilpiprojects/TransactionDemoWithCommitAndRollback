
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");


        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from employee");

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Address: " + rs.getString(3));
            System.out.println("-----------");
        }

        con.close();
    }
}

