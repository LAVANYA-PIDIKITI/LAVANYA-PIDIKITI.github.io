import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet")
public class basic extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionId = request.getParameter("sessionid");
        if (sessionId == null) {
            sessionId = UUID.randomUUID().toString();
        }
        session.setAttribute("sessionid", sessionId);
        String name = request.getParameter("name");
        response.setContentType("text/html");
        response.getWriter().println("<html><body><h1>Hello, " + name + "!</h1></body></html>");
    }
}
