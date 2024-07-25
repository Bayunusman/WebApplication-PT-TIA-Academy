package menu;

import auth.LoginAuth;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Main"})
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        if (LoginAuth.isValid) {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<style>");
            writer.println("body {");
            writer.println("    font-family: Arial, sans-serif;");
//            writer.println("    background-image: url('https://media.istockphoto.com/id/1263084035/id/vektor/perawatan-kesehatan-dan-latar-belakang-medis-dalam-warna-biru.jpg?s=1024x1024&w=is&k=20&c=dlQYIABT_4DQXPH7LWnYUjQSCDIeFz35j3pltXgJ29I=');");
            writer.println("    background-image: url('img//test.jpg');");
            writer.println("    background-size: cover;");
            writer.println("}");
            writer.println(".menu-container {");
            writer.println("    display: flex;");
            writer.println("    flex-direction: column;");
            writer.println("    align-items: center;");
            writer.println("    margin-top: 50px;");
            writer.println("}");
            writer.println(".menu-item {");
            writer.println("    background-color: white;"); // Ubah warna latar belakang sesuai keinginan Anda
            writer.println("    border-radius: 8px;");
            writer.println("    padding: 20px;");
            writer.println("    width: 400px;");
            writer.println("    margin-bottom: 20px;");
            writer.println("    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);");
            writer.println("    transition: box-shadow 0.3s ease-in-out;");
            writer.println("    text-align: center;");
            writer.println("}");
            writer.println(".menu-item:hover {");
            writer.println("    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);");
            writer.println("}");
            writer.println(".menu-item a {");
            writer.println("    text-decoration: none;");
            writer.println("    color: #333333;");
            writer.println("    font-size: 18px;");
            writer.println("}");
            writer.println(".menu-item a:hover {");
            writer.println("    color: #000000;");
            writer.println("}");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1 style=\"text-align: center; margin-top: 50px;\">Menu Utama</h1>");
            writer.println("<div class=\"menu-container\">");
            writer.println("<div class=\"menu-item\" style=\"margin-top: 20px;\">");
            writer.println("<a href=\"ShowAllData\">1. Show All Data</a>");
            writer.println("</div>");
            writer.println("<div class=\"menu-item\">");
            writer.println("<a href=\"InsertData\">2. Insert Data</a>");
            writer.println("</div>");
            writer.println("<div class=\"menu-item\">");
            writer.println("<a href=\"Predict\">3. Predict</a>");
            writer.println("</div>");
            writer.println("<div class=\"menu-item\">");
            writer.println("<a href=\"DownloadData\">4. Download Data</a>");
            writer.println("</div>");
            writer.println("<div class=\"menu-item\">");
            writer.println("<a href=\"Logout\">5. Logout</a>");
            writer.println("</div>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
            writer.flush();


        } else {
            LoginAuth.unauthorizedAcess(resp);
        }
    }
}
