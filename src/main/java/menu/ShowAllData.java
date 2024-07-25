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
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/ShowAllData"})
public class ShowAllData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showAllRecord(resp);
    }

    public void showAllRecord(HttpServletResponse resp) throws IOException {
        ResultSet resultSet = null;
        DBUtil.connect();
        PrintWriter writer = resp.getWriter();
            if(LoginAuth.isValid) {
            try {
                resultSet = DBUtil.selectAll("jantung_sehat");
                writer.println("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "    <style>\n" +
                        "        .data-table {\n" +
                        "    width: 100%;\n" +
                        "    border-collapse: collapse;\n" +
                        "  }\n" +
                        "  \n" +
                        "  .data-table th,\n" +
                        "  .data-table td {\n" +
                        "    padding: 8px;\n" +
                        "    text-align: left;\n" +
                        "    border-bottom: 1px solid #ccc;\n" +
                        "  }\n" +
                        "  \n" +
                        "  .data-table th {\n" +
                        "    background-color: #f2f2f2;\n" +
                        "  }\n" +
                        "  \n" +
                        "  .edit-button,\n" +
                        "  .delete-button {\n" +
                        "    padding: 5px 10px;\n" +
                        "    font-size: 14px;\n" +
                        "    border: none;\n" +
                        "    background-color: #4caf50;\n" +
                        "    color: #fff;\n" +
                        "    cursor: pointer;\n" +
                        "    margin-right: 5px;\n" +
                        "  }\n" +
                        "  \n" +
                        "  .delete-button {\n" +
                        "    background-color: #f44336;\n" +
                        "  }\n" +
                        "    </style>\n" +
                        "\n" +
                        "</head>\n" +
                        "<table class=\"data-table\">\n" +
                        "  <thead>\n" +
                        "    <tr>\n" +
                        "      <th>ID</th>\n" +
                        "      <th>Age</th>\n" +
                        "      <th>Sex</th>\n" +
                        "      <th>Chest Pain Type</th>\n" +
                        "      <th>Resting BP</th>\n" +
                        "      <th>Cholesterol</th>\n" +
                        "      <th>Fasting BS</th>\n" +
                        "      <th>Resting ECG</th>\n" +
                        "      <th>Max HR</th>\n" +
                        "      <th>Exercise Angina</th>\n" +
                        "      <th>Old Peak</th>\n" +
                        "      <th>ST Slope</th>\n" +
                        "      <th>Heart Disease</th>\n" +
                        "      <th>Actions</th>\n" +
                        "    </tr>\n" +
                        "  </thead>");
//                writer.println("<h2>Database Heart </h2>");
//                writer.println("<table border=1>");
//                writer.println("<tr>");
//                writer.println("<th>id</th>");
//                writer.println("<th>age</th>");
//                writer.println("<th>sex</th>");
//                writer.println("<th>chestpaintype</th>");
//                writer.println("<th>restingbp</th>");
//                writer.println("<th>cholesterol</th>");
//                writer.println("<th>fastingBS</th>");
//                writer.println("<th>restingecg</th>");
//                writer.println("<th>maxhr</th>");
//                writer.println("<th>exerciseangina</th>");
//                writer.println("<th>oldpeak</th>");
//                writer.println("<th>st_slope</th>");
//                writer.println("<th>heartdisease</th>");
//                writer.println("<th colspan=2>aksi</th>");
//                writer.println("</tr>");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int age = resultSet.getInt("age");
                    String sex = resultSet.getString("sex");
                    String chestpaintype = resultSet.getString("chestpaintype");
                    int restingbp = resultSet.getInt("restingbp");
                    int cholesterol = resultSet.getInt("cholesterol");
                    int fastingBS = resultSet.getInt("fastingBS");
                    String restingecg = resultSet.getString("restingecg");
                    int maxhr = resultSet.getInt("maxhr");
                    String exerciseangina = resultSet.getString("exerciseangina");
                    Float oldpeak = resultSet.getFloat("oldpeak");
                    String st_slope = resultSet.getString("st_slope");
                    int heartdisease = resultSet.getInt("heartdisease");

                    writer.println("<tr>");
                    writer.println("<td>" + id + "</td>");
                    writer.println("<td>" + age + "</td>");
                    writer.println("<td>" + sex + "</td>");
                    writer.println("<td>" + chestpaintype + "</td>");
                    writer.println("<td>" + restingbp + "</td>");
                    writer.println("<td>" + cholesterol + "</td>");
                    writer.println("<td>" + fastingBS + "</td>");
                    writer.println("<td>" + restingecg + "</td>");
                    writer.println("<td>" + maxhr + "</td>");
                    writer.println("<td>" + exerciseangina + "</td>");
                    writer.println("<td>" + oldpeak+ "</td>");
                    writer.println("<td>" + st_slope + "</td>");
                    writer.println("<td>" + heartdisease + "</td>");
//                    writer.println("<td><button><a href=\"EditData?id=" + id + "&age=" + age + "&sex=" + sex + "&chestpaintype=" + chestpaintype + "&restingbp=" + restingbp + "&cholesterol=" + cholesterol + "&fastingBS=" + fastingBS +
//                           "&restingecg=" + restingecg + "&maxhr=" + maxhr + "&exerciseangina=" + exerciseangina + "&oldpeaka=" + oldpeak + "&st_slope=" + st_slope + "&heartdisease=" + heartdisease + "\">Edit</a></button>" +
//                            "<button><a href=\"javascript:void(0)\" onclick=\"if (confirm('Apakah Anda yakin ingin menghapus identitas ini?')) { window.location.href = 'DeleteData?id=\" + id + \"'; } else { return false; }\">Delete</a></button></td>");
                    writer.println("<td>");
                    writer.println("<button><a href=\"EditData?id=" + id + "&age=" + age + "&sex=" + sex + "&chestpaintype=" + chestpaintype + "&restingbp=" + restingbp + "&cholesterol=" + cholesterol + "&fastingBS=" + fastingBS +
                            "&restingecg=" + restingecg + "&maxhr=" + maxhr + "&exerciseangina=" + exerciseangina + "&oldpeaka=" + oldpeak + "&st_slope=" + st_slope + "&heartdisease=" + heartdisease + "\">Edit</a></button>");
                    writer.println("<button><a href=\"javascript:void(0)\" onclick=\"if (confirm('Apakah Anda yakin ingin menghapus identitas ini?')) { window.location.href = 'DeleteData?id=" + id + "'; } else { return false; }\">Delete</a></button>");
                    writer.println("</td>");

                    writer.println("</tr>");
                }
                writer.println("</table>");
                writer.println("<a href=\"Main\">Kembali ke Menu Utama</a>");
                writer.println("</html>");
                writer.flush();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            LoginAuth.unauthorizedAcess(resp);
        }
    }
}