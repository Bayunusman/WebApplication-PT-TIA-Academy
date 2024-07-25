package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        DBUtil.connect();
        writer.println("<html>\n" +
                "    <head>\n" +
                "        <title>Login</title>\n" +
                "         <link href=\"css/styleReg.css\" rel=\"stylesheet\" type=\"text/css\" >\n" +
                "         <style>\n" +
                "             body {\n" +
                "                 background-image: url('img/test.jpg');\n" +
                "                 background-size: cover;\n" +
                "             }\n" +
                "         </style>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Register</h1>\n" +
                "        <form action=\"Register\" method=\"post\">\n" +
                "        Email:       <input type=\"text\" size=\"25\" name=\"Email\"/><br/>\n" +
                "        Password:    <input type=\"password\" size=\"25\" name=\"Password\"/><br/>\n" +
                "        Konfirmasi:  <input type=\"password\" size=\"25\" name=\"Konfirmasi\"/><br/>\n" +
                "        <input type=\"submit\" value=\"Regsitrasi\"/>\n" +
                "        </form>\n" +
                "    </body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stringEmail = req.getParameter("Email");
        System.out.println("Email = " + stringEmail);
        String stringPassword = req.getParameter("Password");
        System.out.println("Password = " + stringPassword);
        String stringKonfirmasi = req.getParameter("Konfirmasi");
        System.out.println("Konfirmasi = " + stringKonfirmasi);
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        boolean isValid1 = false;
        if (stringEmail.isEmpty() || stringPassword.isEmpty() || stringKonfirmasi.isEmpty()) {
            isValid1 = false;
            writer.println("<html><head><style>");
            writer.println("body { font-family: 'Arial', sans-serif; text-align: center; padding: 50px; background-color: #f2f2f2; }");
            writer.println("h2 { color: #e74c3c; margin-bottom: 20px; }");
            writer.println("p { color: #e74c3c; }");
            writer.println("</style></head><body>");
            writer.println("<h2>Oops! Terjadi Kesalahan.</h2>");
            writer.println("<p>Email, Password, dan Konfirmasi Password harus diisi.</p>");
        } else {
            isValid1 = true;
        }

        boolean isValid2 = false;
        if (!stringPassword.equals(stringKonfirmasi)) {
            isValid2 = false;
            writer.println("<h2>Oops! Terjadi Kesalahan.</h2>");
            writer.println("<p>Password dan Konfirmasi Password tidak sesuai.</p>");
        } else {
            isValid2 = true;
        }
        if (isValid1 && isValid2) {
            String passwordMD5 = MD5.getMd5(stringPassword);
            if (DBUtil.insertRegist("users", stringEmail, passwordMD5)) {
                writer.println("<html><body style=\"font-family: Arial, sans-serif; text-align: center; padding: 50px;\">");
                writer.println("<h2 style=\"color: #4CAF50;\">Daftar akun " + stringEmail + " Berhasil!</h2>");
            } else {
                writer.println("<html><body style=\"font-family: Arial, sans-serif; text-align: center; padding: 50px;\">");
                writer.println("<h2 style=\"color: #f44336;\">Daftar akun " + stringEmail + " Gagal!</h2>");
            }
        }

        writer.println("<h4 style=\"margin-top: 20px;\"><a href=\"index.jsp\" style=\"text-decoration: none; color: #2196F3;\">Silakan Masuk ke Menu Login</a></h4>");
        writer.println("</body></html>");
        writer.flush();
    }
}