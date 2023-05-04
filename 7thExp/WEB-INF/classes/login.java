import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class login extends HttpServlet {   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname"); 

        Cookie ck = new Cookie("username", uname);
        response.addCookie(ck); 
            
        out.println("<header style = 'text-align: right'>" + uname + "&nbsp; &nbsp; &nbsp; &nbsp;");
        out.println("<a href='logout' target='_blank'>Logout</a> ");
        out.println("</header><hr style = 'border:'2px solid black>");


        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //out.println("<h1> into class</h1>");
            //create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel", "root", "root");
            if(conn==null)
            {
                out.println("<h1> Issues in Connection</h1>");
            }
            String sql;
            //display all the students' marks
            stmt = conn.createStatement();
            sql = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(sql);

            
            // Extract data from result set
            out.println("<form action='total' method='post'>");
            out.println("<table cellspacing='0' width='350px' border='1'>");
            out.println("<tr>");
            out.println("<td> Product Name </td>");
            out.println("<td> Product Price </td>");
            out.println("<td> Checked </td>");
           
            out.println("</tr>");

            String name = "";
            String price = "";
            while(rs.next())
            {
                name = rs.getString("name");
                price = rs.getString("price");


                out.println("<tr>");
                out.println("<td>"  +  name  +  "</td>");
                out.println("<td>"  +  price  +  "</td>");  
                out.println("<td><input type='checkbox' name='selected' value = '" + name + "'></td>");
            
                out.println("</tr>");
    
            }
            out.println("</table>");
            out.println("<input type='submit' value='Calculate Total'></form>");
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
