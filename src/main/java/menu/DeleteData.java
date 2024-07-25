package menu;

import auth.LoginAuth;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/DeleteData"})
public class DeleteData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(LoginAuth.isValid == true){
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        //String age = req.getParameter("age");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<style>");
            writer.println("body {");
            writer.println("    font-family: Arial, sans-serif;");
            writer.println("    background-color: silver;");
            writer.println("}");

            writer.println(".container {");
            writer.println("    display: flex;");
            writer.println("    flex-direction: column;");
            writer.println("    align-items: center;");
            writer.println("    margin-top: 50px;");
            writer.println("}");

            writer.println(".form-container {");
            writer.println("    background-color: #F5F5F5;");
            writer.println("    border-radius: 8px;");
            writer.println("    padding: 20px;");
            writer.println("    width: 400px;");
            writer.println("    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);");
            writer.println("    text-align: center;");
            writer.println("}");

            writer.println(".form-container h2 {");
            writer.println("    margin-top: 0;");
            writer.println("}");

            writer.println(".form-container input[type='text'] {");
            writer.println("    width: 100%;");
            writer.println("    padding: 8px;");
            writer.println("    margin-bottom: 10px;");
            writer.println("    box-sizing: border-box;");
            writer.println("}");

            writer.println(".form-container input[type='submit'] {");
            writer.println("    background-color: #4CAF50;");
            writer.println("    color: white;");
            writer.println("    padding: 10px 20px;");
            writer.println("    border: none;");
            writer.println("    border-radius: 4px;");
            writer.println("    cursor: pointer;");
            writer.println("}");

            writer.println(".form-container input[type='submit']:hover {");
            writer.println("    background-color: #45a049;");
            writer.println("}");

            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div class=\"container\">");
            writer.println("<div class=\"form-container\">");
            writer.println("<h2>Delete Data</h2>");
            writer.println("<form action=\"DeleteData\" method=\"post\">");
            writer.println("Apakah anda yakin ingin menghapus data ini?<br/>");
            writer.println("ID:     <input type=\"text\" size=\"2\" name=\"id\" value="+id+" readonly><br/>");
            writer.println("<input type=\"submit\" value=\"Delete\"/>");
            writer.println("</form>");
            writer.println("</div>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");

            writer.flush();

        }else{
            LoginAuth.unauthorizedAcess(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ambil parameter yang diinput
        String stringID = req.getParameter("id");
        int id = Integer.parseInt(stringID);

//        String stringAge = req.getParameter("age");
//        int age = Integer.parseInt(stringAge);

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
        if (DBUtil.delete("jantung_sehat", id)) {
            writer.println("<h2>Data dengan ID " + stringID + " berhasil dihapus!</h2>");
        } else {
            writer.println("<h2>Gagal menghapus data dengan ID " + stringID + "!</h2>");
        }
        writer.println("<h4><a href=\"Main\">Kembali ke Menu Utama</a></h4>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();

    }
}
