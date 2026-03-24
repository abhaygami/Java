package jdbcwithstatement;

import java.sql.*;      // 🔌 JDBC classes
import java.util.*;     // 🧾 Scanner

// Table: student(rollno, name, course, sem)
// Insert, DisplayAll, Delete(using rollno), Update, Search(Using rollno)

public class JDBCWithStatement {

    static Scanner scanner = new Scanner(System.in); // ⌨️ user input
    static Connection conn; // 🔗 database connection

    public static void main(String[] args) {
        try {
            // 🔌 Establish connection with MySQL(phpMyAdmin)
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB",
                    "root",
                    ""
            );

            int choice = -1;

            // 🔁 Menu loop
            while (choice != 0) {
                System.out.println("\n1. Insert into student");
                System.out.println("2. View students");
                System.out.println("3. Update student");
                System.out.println("4. Delete student");
                System.out.println("5. Search student");
                System.out.println("0. Exit");

                System.out.print("\nEnter your choice = ");
                choice = scanner.nextInt();
                scanner.nextLine(); // ⚠️ clear buffer

                // 🎯 Perform operation based on choice
                switch (choice) {
                    case 1:
                        insert(); // ➕ insert record
                        break;
                    case 2:
                        displayAll(); // 👀 view all
                        break;
                    case 3:
                        update(); // ✏️ update record
                        break;
                    case 4:
                        delete(); // ❌ delete record
                        break;
                    case 5:
                        search(); // 🔍 search record
                        break;
                    case 0:
                        System.out.println("Exiting..........."); // 🚪 exit
                        break;
                    default:
                        System.out.println("Enter valid choice!"); // ⚠️ invalid input
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println(e); // ❗ connection error
        }
    }

    // ➕ INSERT DATA
    public static void insert() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter course name: ");
            String course = scanner.nextLine();

            System.out.print("Enter sem: ");
            int sem = scanner.nextInt();
            scanner.nextLine();

            // 🧠 SQL query (String concatenation)
            String query = "INSERT INTO student(name, course, sem) VALUES ('" + name + "', '" + course + "', " + sem + ")";

            Statement stmt = conn.createStatement(); // 📌 create statement
            int rows = stmt.executeUpdate(query);    // ▶️ execute insert

            if (rows > 0) {
                System.out.println("Insertion done! ✅");
            } else {
                System.out.println("Insertion failed! ❌");
            }
        } catch (Exception ex) {
            System.out.println("Exception in Insertion!"); // ❗ error
        }
    }

    // ❌ DELETE DATA
    public static void delete() {
        try {
            System.out.print("Enter rollno you want to delete: ");
            int rollno = scanner.nextInt();
            scanner.nextLine();

            String query = "DELETE FROM student WHERE rollno = " + rollno;

            Statement stmt = conn.createStatement();
            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Deletion done of " + rows + " rows! ✅");
            } else {
                System.out.println("No rows deleted! ❌");
            }
        } catch (Exception ex) {
            System.out.println("Exception in Deletion!: " + ex.getMessage());
        }
    }

    // ✏️ UPDATE DATA
    public static void update() {
        try {
            System.out.print("Enter rollno whom you want to update: ");
            int rollno = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new course name: ");
            String course = scanner.nextLine();

            System.out.print("Enter new sem: ");
            int sem = scanner.nextInt();
            scanner.nextLine();

            String query = "UPDATE student SET course = '" + course + "', sem = " + sem + " WHERE rollno = " + rollno;

            Statement stmt = conn.createStatement();
            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Updation done of " + rows + " rows! ✅");
            } else {
                System.out.println("No rows Updated! ❌");
            }
        } catch (Exception ex) {
            System.out.println("Exception in Updation!" + ex.getMessage());
        }
    }

    // 👀 DISPLAY ALL DATA
    public static void displayAll() {
        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM student"); // 📊 fetch data

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                // 🔁 iterate each row
                System.out.println(
                        rs.getInt("rollno") + " | "
                        + rs.getString("name") + " | "
                        + rs.getString("course") + " | "
                        + rs.getInt("sem")
                );
            }
        } catch (Exception ex) {
            System.out.println("Exception in Display ALL!");
        }
    }

    // 🔍 SEARCH DATA
    public static void search() {
        try {
            System.out.print("Enter rollno. : ");
            int rollno = scanner.nextInt();
            scanner.nextLine();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE rollno = " + rollno);

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("rollno") + " | "
                        + rs.getString("name") + " | "
                        + rs.getString("course") + " | "
                        + rs.getInt("sem")
                );
            }
        } catch (Exception ex) {
            System.out.println("Exception in Searching: " + ex.getMessage());
        }
    }
}
