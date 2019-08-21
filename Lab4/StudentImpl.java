import java.rmi.StubNotFoundException;
import java.sql.*;
import java.util.*;

public class StudentImpl implements Hello{
     public List<Student> getStudents()  throws Exception{
          List<Student> list = new ArrayList<Student>();

          String JDBC_DRIVER =  "com.mysql.jdbc.Driver";   
          String DB_URL = "jdbc:mysql://localhost:3306/details";  
      
          String USER = "username";
          String PASS = "password";

          Connection conn = null;
          Statement stmt = null;

          Class.forName("com.mysql.jdbc.Driver");


          System.out.println("Connecting to Database..");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          System.out.println("Connection Successful");

          System.out.println("Creating Statement");

          stmt = conn.createStatement();
          String sql = "SELECT *FROM  student_data";
          ResultSet rs = stmt.executeQuery(sql);

          while(rs.next()){

            int id = rs.getInt("id");


            String name = rs.getString("name");
            String branch = rs.getString("branch");

            float cpi = rs.getFloat("cpi");

            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setBranch(branch);
            student.setCpi(cpi);
            list.add(student);
 
          }

          rs.close();
          return list;

     }
}