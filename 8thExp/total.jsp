<%@page import="java.io.*,  java.util.*,javax.servlet.*,javax.servlet.http.*,java.sql.*"%>
<%

    Cookie[] cookies = request.getCookies();
    String uname = null;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                uname = cookie.getValue();
                break;
            }
        }
    }

    out.println("<a href='logout.jsp' target='_blank'>Logout</a> ");

    String[] selectedProducts = request.getParameterValues("selected");

    response.setContentType("text/html");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Selected Products</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Selected Products</h1>");

    if (selectedProducts != null) {
        double totalPrice = 0.0;
        out.println("<table cellspacing='0' width='350px' border='1'>");
        out.println("<tr><th>Product</th><th>Price</th></tr>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=null;
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/travel","root", "");
            PreparedStatement stmt = conn.prepareStatement("SELECT price FROM products WHERE name = ?");
            for (int i = 0; i < selectedProducts.length; i++) {
                stmt.setString(1, selectedProducts[i]);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    double price = rs.getDouble("price");
                    out.println("<tr><td>" + selectedProducts[i] + "</td><td>" + price + "</td></tr>");
                    totalPrice += price;
                } else {
                    out.println("<tr><td>" + selectedProducts[i] + "</td><td>price not found</td></tr>");
                }
                rs.close();
            }
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            out.println("<p>Database error occurred.</p>");
        }

        out.println("</table>");
        out.println("<h1>Total Price: " + totalPrice + "</h1>");
    } else {
        out.println("<p>No products selected.</p>");
    }

    out.println("</body>");
    out.println("</html>");
%>