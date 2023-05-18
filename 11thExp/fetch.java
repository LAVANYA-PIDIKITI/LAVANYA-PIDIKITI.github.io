package Lavanya;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fetch extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GetCustomerDetails customerDetails = new GetCustomerDetails();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String customerId = request.getParameter("customer_id");
        String xmlResult = customerDetails.hello(customerId);

        // Parse XML response and display results in table rows
        out.println("<html>");
        out.println("<head><title>Customer Details</title></head>");
        out.println("<body>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Customer ID</th><th>Customer Name</th></tr>");
        
        String id = "", name = "";
        int startIndex, endIndex;
        while (xmlResult.contains("<Customer>")) {
            startIndex = xmlResult.indexOf("<ID>") + 4;
            endIndex = xmlResult.indexOf("</ID>");
            id = xmlResult.substring(startIndex, endIndex);
            xmlResult = xmlResult.substring(endIndex + 5);
            
            startIndex = xmlResult.indexOf("<Name>") + 6;
            endIndex = xmlResult.indexOf("</Name>");
            name = xmlResult.substring(startIndex, endIndex);
            xmlResult = xmlResult.substring(endIndex + 7);
            
            out.println("<tr><td>" + id + "</td><td>" + name + "</td></tr>");
        }
        
        out.println("</table>");
        out.println("</body></html>");
    }
}
