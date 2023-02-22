import java.sql.*;

public class InsertData {

    Connection con;

    Statement stmt;

    public InsertData() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/database1?";

            con = DriverManager.getConnection(url + "user=student1&password=pass");

            stmt = con.createStatement();
        } catch (Exception e) {

            System.out.println("Error connection to database.");
            System.exit(0);
        }

        try {

            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(23,'Juan','Son','1234 Nowing','Alabama','TE','12345')")
                            + "row updated");

            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(12,'Bad','Barb','1235 Jackson Street','California','ND','12345')")
                            + "row updated");
            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(62,'Stern','Howard','1000 Galavan Road','New York','CA','23456')")
                            + "row updated");
            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(63,'Howard','Smith','7654 Marksman Circle','Madrid','AZ','23456')")
                            + "row updated");

            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(54,'Barry','Larry','9897 Madrid Lane','Roma','CA','23456')")
                            + "row updated");
            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(95,'Sonny','Bill','0098 Roma Road','Paris','NY','34567')")
                            + "row updated");
            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(96,'Scarn','Mike','9999 Maurice Lane','San Juan','FL','34567')")
                            + "row updated");

            System.out.println(
                    stmt.executeUpdate(
                            "INSERT INTO address1 VALUES(84,'Tom','Jerry','1991 Filmore Street','Los Palos Verdes','CA','77777')")
                            + "row updated");

            stmt.executeUpdate("COMMIT");

            System.out.println("Data Inserted");
        } catch (SQLException e) {

            System.out.println(e);
            System.out.println("Insert Data Failed");
        }

        try {

            stmt.close();

            con.close();
            System.out.println("Database connections closed");
        } catch (SQLException e) {

            System.out.println("Connection close failed");
        }
    }

    public static void main(String args[]) {

        new InsertData();
    }
}