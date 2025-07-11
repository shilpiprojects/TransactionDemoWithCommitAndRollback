package org.demo.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCMLDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        Connection con = null;
        ResultSet resultSet = null;


        String insertQuery = "INSERT INTO employee VALUES ('5', 'Barkha', 'Wembley')";
        String updateQuery = "UPDATE employee SET city='Chennai' WHERE id=1";
        String deleteQuery = "DELETE FROM employee WHERE id=1";

        try {

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!");


            Statement st = con.createStatement();


            int insertCount = st.executeUpdate(insertQuery);
            System.out.println("Insert Query - Rows affected: " + insertCount);


            int updateCount = st.executeUpdate(updateQuery);
            System.out.println("Update Query - Rows affected: " + updateCount);


            int deleteCount = st.executeUpdate(deleteQuery);
            System.out.println("Delete Query - Rows affected: " + deleteCount);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
