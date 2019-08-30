/**
 *  Brien Hewan-Lowe
 *  CISC 3180 SQL Project
 * 
 */

package briendatabase;

import java.sql.*;

public class PostgreSQLJDBC {
 public static void main(String args[]) {
      //Here we establish a connection and open to the Database 
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost/registrar",
            "postgres", "brienh");
         System.out.println("Opened database successfully");
         c.setAutoCommit(false);

         
         //Here we create 3 different tables in the Registrar database
         //inside of the BrooklynCollege schema.
         stmt = c.createStatement();
         
        //This is the Student table which will hold information
        //for the student id, first name, last name, date of birth,
        //and email address.
        String sql = "CREATE TABLE BrooklynCollege.Student "
                 + "(studentID  numeric(8)  PRIMARY KEY NOT NULL, "
                 + "firstName  varchar(25), "
                 + "lastName   varchar(25), "
                 + "dateOfBirth  date, "
                 + "email  varchar(30)); ";
        stmt.executeUpdate(sql);
        
        //This is the Grades table which will hold information about
        //the student's id, graduation year, GPA and degree.
        sql = "CREATE TABLE BrooklynCollege.Grades "
            + "(studentID  numeric(8)  PRIMARY KEY NOT NULL, "
            + "graduationYear  numeric(4), "
            + "gpa   varchar(4), "
            + "degree  varchar(25)); ";
        stmt.executeUpdate(sql);
        
        //The Location table is the final table and will hold 
        //information about the student's id, state, zip code, 
        //city and address.
        sql = "CREATE TABLE BrooklynCollege.Location "
            + "(studentID  numeric(8)  PRIMARY KEY NOT NULL, "
            + "state  varchar(2), "
            + "zipcode   numeric(5), "
            + "city  varchar(25), "
            + "address varchar(50));";
        stmt.executeUpdate(sql);
           
        //Here we  create a record of 4 students to insert into the
        //Student table
        sql = "INSERT INTO BrooklynCollege.STUDENT"
            + " VALUES(14105029, 'William', 'James', "
            + "'1994-10-10', 'WJames94@gmail.com');";
            stmt.executeUpdate(sql);
            
        sql = "INSERT INTO BrooklynCollege.STUDENT"
            + " VALUES(18303940, 'Michael', 'Smith', "
            + "'1991-05-08', 'mikesmith94@gmail.com');";
            stmt.executeUpdate(sql);
            
        sql = "INSERT INTO BrooklynCollege.STUDENT"
            + " VALUES(12901029, 'John', 'Jackson', "
            + "'1984-03-11', 'JJackson1984@gmail.com');";
            stmt.executeUpdate(sql);
        
        sql = "INSERT INTO BrooklynCollege.STUDENT"
            + " VALUES(12030409, 'Matthew', 'Johnson', "
            + "'1997-01-08', 'MJohnson1997@gmail.com');";
            stmt.executeUpdate(sql);
            
            
        //This will insert these records into the Location table    
        sql = "INSERT INTO BrooklynCollege.Location"
            + " VALUES(14105029, 'NY', 11203, "
            + " 'Brooklyn', '430 Pen Road');";
            stmt.executeUpdate(sql);
            
        sql = "INSERT INTO BrooklynCollege.Location"
            + " VALUES(18303940, 'NY', 11220, "
            + "'Brooklyn', '4828 Eagle Nest Drive');";
            stmt.executeUpdate(sql);
            
        sql = "INSERT INTO BrooklynCollege.Location"
            + " VALUES(12901029, 'NY', '11232', "
            + "'Queens', '1777 Cambridge Drive');";
            stmt.executeUpdate(sql);
        
        sql = "INSERT INTO BrooklynCollege.Location"
            + " VALUES(12030409, 'NJ', '11420', "
            + "'Newark', '3060 Parrish Avenue');";
            stmt.executeUpdate(sql);
           
        //This will insert the records of these 4 students
        ///into the Grades table
        sql = "INSERT INTO BrooklynCollege.Grades"
            + " VALUES(14105029, 2019, '3.90', "
            + "'Computer Science');";
            stmt.executeUpdate(sql);
            
        sql = "INSERT INTO BrooklynCollege.Grades"
            + " VALUES(18303940, 2020, 3.53, "
            + "'Psychology');";
            stmt.executeUpdate(sql);
            
        sql = "INSERT INTO BrooklynCollege.Grades"
            + " VALUES(12901029, '2019', '4.00', "
            + "'Computer Science');";
            stmt.executeUpdate(sql);
        
        sql = "INSERT INTO BrooklynCollege.Grades"
            + " VALUES(12030409, '2022', '3.21', "
            + "'Accounting');";
            stmt.executeUpdate(sql);
        System.out.println("Inserted records into database");

        
        //This will print out the information from the Student table
        System.out.println("\nStudent: ");
        sql = "SELECT studentID, firstName, lastName, dateOfBirth, email "
                + "FROM BrooklynCollege.Student";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
                int studentID = rs.getInt("studentID");
                java.sql.Date dateOfBirth = rs.getDate("dateOfBirth");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");        
        System.out.print("studentID: " + studentID);
        System.out.print(" firstName: " + firstName);
        System.out.print("  lastName: " + lastName);
        System.out.print("  dateOfBirth: " + dateOfBirth);
        System.out.print("  email: " + email);
        System.out.print("\n");
        }

        
        //This will  print out the information from the Grades table
        System.out.println("\nGrades: ");
        sql = "SELECT studentID, graduationYear, GPA, degree  "
                + "FROM BrooklynCollege.Grades";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
                int studentID = rs.getInt("studentID");
                int graduationYear = rs.getInt("graduationYear");
                String GPA = rs.getString("GPA");
                String degree = rs.getString("degree");               
        System.out.print("studentID: " + studentID);
        System.out.print("  graduationYear: " + graduationYear);
        System.out.print("  GPA: " + GPA);
        System.out.print("  degree: " + degree);
        System.out.print("\n");
        } 
        
        //This will  print out the information from the Location table
        System.out.println("\nLocation: ");
        sql = "SELECT studentID, state, zipCode, city, address "
                + "FROM BrooklynCollege.Location";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
                int studentID = rs.getInt("studentID");
                int zipCode = rs.getInt("zipCode");
                String state = rs.getString("state");
                String city = rs.getString("city");
                String address = rs.getString("address");              
        System.out.print("studentID: " + studentID);
        System.out.print("  state: " + state);
        System.out.print("  zipCode: " + zipCode);
        System.out.print("  city: " + city);
        System.out.print("  address: " + address);
        System.out.print("\n");
        }
        
        rs.close();
        stmt.close();
        c.commit();
        c.close();
      } catch (Exception e) {
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
    
}
