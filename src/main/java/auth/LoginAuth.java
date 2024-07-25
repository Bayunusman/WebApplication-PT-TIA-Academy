package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/LoginAuth"})
public class LoginAuth extends HttpServlet {
    public static  boolean isValid = false;

    public static void unauthorizedAcess(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<style>");
        writer.println("body { background-color: #EAEFF5; font-family: 'Arial', sans-serif; }");
        writer.println(".container { background-color: #F5F8FD; padding: 20px; text-align: center; }");
        writer.println("h2 { color: #333; font-size: 24px; }");
        writer.println("p { color: #666; font-size: 18px; margin-bottom: 20px; }");
        writer.println("a { color: #108BE3; text-decoration: none; }");
        writer.println("a:hover { text-decoration: underline; }");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class='container'>");
        writer.println("<h2>Access Tidak Valid</h2>");
        writer.println("<p>Silahkan Registrasi Terlebih Dahulu</p>");
        writer.println("<h4><a href='index.jsp'>Kembali ke login</a></h4>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Koneksi Ke DB
        DBUtil.connect();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordMD5 = MD5.getMd5(password);


        ResultSet resultSet = null;
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<style>");
        writer.println("body { background-color: #EAEFF5; font-family: 'Arial', sans-serif; }");
        writer.println(".container { background-color: #F5F8FD; padding: 20px; text-align: center; }");
        writer.println("h2 { color: #333; font-size: 24px; }");
        writer.println("p { color: #666; font-size: 18px; margin-bottom: 20px; }");
        writer.println("a { color: #108BE3; text-decoration: none; }");
        writer.println("a:hover { text-decoration: underline; }");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class='container'>");
        try {
            resultSet = DBUtil.selectUser(email, passwordMD5);
            if (resultSet.next()){
                isValid = true;
                resp.sendRedirect("Main");
            } else {
                isValid = false;
                writer.println("<h2>Email/Password Invalid</h2>");
                writer.println("<p><a href='index.jsp'>Kembali Ke Login</a></p>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }
}
