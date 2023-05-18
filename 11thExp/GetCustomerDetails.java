package Lavanya;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lavanya
 */
@WebService(serviceName = "GetCustomerDetails")
public class GetCustomerDetails {

    /**
     * This is a sample web service operation
     */
    String Result = "No records found :((";
    @WebMethod(operationName = "customer_id")
public String hello(@WebParam(name = "customer_id") String customer_id) {
        

   try
   {
       Class.forName("com.mysql.jdbc.Driver");
       try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/travel","root", "")) {
           if(conn!=null)
           {
               System.err.println("<h1> No issues in Connection</h1>");
           }
           try (Statement stmt = conn.createStatement()) {
               String sql;
               sql = "SELECT customer_id,customer_name FROM customers WHERE customer_id='" + customer_id + "'" ;
               System.out.println("Customer ID: ");
               // Extract data from result set
               try (ResultSet rs = stmt.executeQuery(sql)) {
                   // Extract data from result set
                   while(rs.next())
                   {
                       //Retrieve by column name
                       String id = rs.getString("customer_id");
                       String name = rs.getString("customer_name");
                       System.out.println("Customer ID: " + id);
                       
                       Result = "<Customer><ID>" + id + "</ID><Name>" + name + "</Name></Customer>";

                       System.err.format("%s,%s\n",id,name);
                   }
                   if (Result.equals("No records found :((")) {
                       System.out.println("No records found for customer ID: " + customer_id);
                   }
               }
           }
       }
   }
   catch(ClassNotFoundException | SQLException e)
   {
       System.err.print("Do not connect to DB - Error:"+e);
   }
        
   return Result;
}


}
