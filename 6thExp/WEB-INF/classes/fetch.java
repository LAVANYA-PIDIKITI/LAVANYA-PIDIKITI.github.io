import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class fetch extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //out.println("<h1> into class</h1>");
            //create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/travel","root", "");
            if(conn!=null)
            {
                out.println("<h1> No issues in Connection</h1>");
            }
            stmt = conn.createStatement();
            String sql;
            //display all the students' marks
            sql = "SELECT * FROM customers";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next())
            {
                //out.println("<h1> into while loop</h1>");
                //Retrieve by column name
                String id = rs.getString("customer_id");
                String name = rs.getString("customer_name");
                String email = rs.getString("customer_email");
                String country = rs.getString("customer_country");
                String city = rs.getString("customer_city");
                String contact = rs.getString("customer_contact");
                
                //Display values
                out.println("<p> Customer id: " + id + "<br>");
                out.println("Customer name: " + name + "<br>");
                out.println("Customer email: " + email + "<br>");
                out.println("Customer country: " + country + "<br>");
                out.println("Customer city: " + city + "<br>");
                out.println("Customer Contact: " + contact + "<br>");
    
            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}
