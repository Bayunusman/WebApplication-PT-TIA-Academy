package menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/DownloadData"})
public class DownloadData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/csv");
            resp.setHeader("Content-Disposition", "attachment; filename=\"hearth.csv\"");

            ResultSet rs = DBUtil.selectAll("jantung_sehat");
            ServletOutputStream outputStream = resp.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            writer.println("Age,Sex,ChestPainType,RestingBP,Cholesterol,FastingBS,RestingECG,MaxHR,ExerciseAngina,Oldpeak,ST_Slope,HeartDisease");

            while (rs.next()) {
                int Age = rs.getInt("Age");
                String Sex = rs.getString("Sex");
                String ChestPainType = rs.getString("ChestPainType");
                String RestingBP = rs.getString("RestingBP");
                String Cholesterol = rs.getString("Cholesterol");
                String FastingBS = rs.getString("FastingBS");
                String RestingECG = rs.getString("RestingECG");
                String MaxHR = rs.getString("MaxHR");
                String ExerciseAngina = rs.getString("ExerciseAngina");
                String Oldpeak = rs.getString("Oldpeak");
                String ST_Slope = rs.getString("ST_Slope");
                String HeartDisease = rs.getString("HeartDisease");

                writer.println(Age + "," + Sex + "," + ChestPainType + "," + RestingBP + "," + Cholesterol + "," + FastingBS + "," + RestingECG + "," + MaxHR + "," + ExerciseAngina + "," + Oldpeak + "," + ST_Slope + "," + HeartDisease);
                writer.flush(); // Memanggil flush setelah menulis setiap baris
            }

            writer.close();
            outputStream.flush();
            outputStream.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
