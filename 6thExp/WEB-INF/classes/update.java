import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class update extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
            //Get the customer name as input from the user
            String name = request.getParameter("customer_name");
            String contact = request.getParameter("customer_contact");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel","root", "");
            if(conn!=null)
            {
                out.println("<h1> Connection established successfully </h1>");
            }
            stmt = conn.createStatement();
            

            
            //Update the contact information of the customer with the given name
            String sql = "UPDATE customers SET customer_contact='" + contact + "' WHERE customer_name='" + name + "'";
            int rowsAffected = stmt.executeUpdate(sql);
            if(rowsAffected > 0)
            {
                out.println("<h2> Customer contact updated successfully </h2>");
            }
            else
            {
                out.println("<h2> Error updating customer contact </h2>");
            }
    
            // Clean-up environment
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Error connecting to DB - Error:"+e);
        }
    }
}
