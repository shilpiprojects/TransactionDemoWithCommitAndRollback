package org.demo.bdd;

import java.sql.*;
import java.util.*;

class TransactionDemoWithCommitAndRollback {
    public static void main(String[] args) throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Connection details
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname = "root";
        String password = "password";


        Connection con = DriverManager.getConnection(url, uname, password);


        Statement st = con.createStatement();


        System.out.println("Data before Transaction:");
        System.out.println("--------------------------");
        Sysytem.out.println("this demo is for git rebase in intellij");
        ResultSet rs = st.executeQuery("SELECT * FROM accounts");

        while (rs.next()) {
            System.out.println(rs.getString(1) + " --- " + rs.getInt(2));
        }


        System.out.println("Transaction begins...");
        con.setAutoCommit(false); 


        st.executeUpdate("UPDATE accounts SET balance = balance - 20000 WHERE user = 'Milan'");
        st.executeUpdate("UPDATE accounts SET balance = balance + 20000 WHERE user = 'Anushka'");


        System.out.println("Can you please confirm this transaction of 20000? [Yes|No]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();


        if (option.equalsIgnoreCase("yes")) {
            con.commit();
            System.out.println("Transaction Committed");
        } else {
            con.rollback();
            System.out.println("Transaction Rolled Back");
        }


        System.out.println("Data After Transaction:");
        System.out.println("--------------------------");
        ResultSet rs1 = st.executeQuery("SELECT * FROM accounts");
        while (rs1.next()) {
            System.out.println(rs1.getString(1) + " --- " + rs1.getInt(2));
        }


        con.close();
        sc.close();
    }
}
