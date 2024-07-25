package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginAuth.isValid = false;
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("    font-family: Arial, sans-serif;");
        writer.println("    background-color: silver;");
        writer.println("    display: flex;");
        writer.println("    justify-content: center;");
        writer.println("    align-items: center;");
        writer.println("    height: 100vh;");
        writer.println("}");

        writer.println(".container {");
        writer.println("    background-color: #F5F5F5;");
        writer.println("    border-radius: 8px;");
        writer.println("    padding: 20px;");
        writer.println("    width: 400px;");
        writer.println("    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);");
        writer.println("    text-align: center;");
        writer.println("}");

        writer.println(".container h2 {");
        writer.println("    margin-top: 0;");
        writer.println("}");

        writer.println(".container a {");
        writer.println("    text-decoration: none;");
        writer.println("    color: #4CAF50;");
        writer.println("}");

        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"container\">");
        writer.println("<h2>Logout Success</h2>");
        writer.println("<p>Terimakasih telah menggunakan program ini.</p>");
        writer.println("<h4><a href=\"index.jsp\">Kembali ke Login</a></h4>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();

    }
}