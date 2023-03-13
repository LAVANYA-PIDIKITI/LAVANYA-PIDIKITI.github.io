import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class trad extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Display Array</title></head>");
        out.println("<body>");
        out.println("<h1>Array Contents:</h1>");
        out.println("<table>");
        out.println("<tr><th>Name</th><th>Age</th><th>Student</th></tr>");
        
        Object[][] details = {
            {"Lavanya", 25, true},
            {"Monica", 32, true},
            {"Samyuktha", 4, false},
            {"Riyansh", 89, false}
        };
        
        for (int i = 0; i < details.length; i++) {
            out.println("<tr>");
            out.println("<td>" + details[i][0] + "</td>");
            out.println("<td>" + details[i][1] + "</td>");
            out.println("<td>" + details[i][2] + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        out.println("</body>");
        out.println("<button onclick=\"window.location.href='serv-array.html'\">Back to home</button>");
        out.println("</html>");

    }
}
