import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet{

    String details[][] = { 
        { "1", "Ramesh", "89", "2" }, 
        { "2", "Suresh", "32", "F" }, 
        { "3", "Rakesh", "78", "4" },
        { "4", "Danish", "65", "5" },
        { "5", "Gil", "33", "F" },  
        { "6", "Til", "63", "6" },
        { "7", "Bil", "20", "F" },
        { "8", "Mil", "87", "3" },
        { "9", "Jil", "62", "7" },
        { "10", "Sil", "95", "1" } 
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String x = request.getParameter("reg");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        for (int i = 0; i < 10; i++) {
            if (x.equals(details[i][0])) {
                out.println("<html><body>");
                out.println("<h1>Details of " + x + ":</h1><br/>");
                out.println("<h1>Name: " + details[i][1] + "</h1>");
                out.println("<h1>Marks: " + details[i][2] + "</h1>");
                out.println("<h1>Rank: " + details[i][3] + "</h1>");
                out.println("<button onclick=\"window.location.href='rank-array.html'\">Back to home</button>");
                out.println("</body></html>");
                return;
            }
        }
        out.println("<html><head></head><body><h1>Register number not found</h1></body></html>");
    }
    
}
