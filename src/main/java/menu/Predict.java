package menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Predict"})
public class Predict extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // test tampilan
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("    font-family: Arial, sans-serif;");
        writer.println("    background-image: url('img/test.jpg');");
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

        writer.println(".form-container h4 {");
        writer.println("    margin-top: 0;");
        writer.println("}");

        writer.println(".form-container input[type='text'], .form-container select {");
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
        writer.println("<h4>Prediksi Data Pasien</h4>");
        writer.println("<form action=\"Predict\" method=\"post\">");
        writer.println("Age (Umur):             <input type=\"text\" size=\"2\" name=\"age\"/><br/>");
        writer.println("Jenis Kelamin (Sex):             <select name=\"sex\">"
                + "<option value=\"0\">Perempuan</option>"
                + "<option value=\"1\">Laki Laki</option>"
                + "</select><br/>");
        writer.println("Chestpain Type (Jenis Nyeri Dada):  <select name=\"chestpaintype\">"
                + "<option value=\"1\">ATA (Tidak Nyaman)</option>"
                + "<option value=\"2\">NAP (Nyeri Tanpa Keterkaitan)</option>"
                + "<option value=\"0\">ASY (Tanpa Gejala)</option>"
                + "<option value=\"3\">TA (Nyeri Dada Tidak Biasa)</option>"
                + "</select><br/>");
        writer.println("Resting BP (Tekanan Darah Istirahat):      <input type=\"text\" size=\"2\" name=\"restingbp\"/><br/>");
        writer.println("Cholesterol (Kolesterol):     <input type=\"text\" size=\"2\" name=\"cholesterol\"/><br/>");
        writer.println("Fasting BS (Kadar Gula Puasa):      <select name=\"fastingBS\">"
                + "<option value=\"0\">Normal</option>"
                + "<option value=\"1\">Tinggi</option>"
                + "</select><br/>");
        writer.println("Resting ECG (Hasil Elektrokardiogram):     <select name=\"restingecg\">"
                + "<option value=\"0\">LVH (Pembesaran Ventrikel)</option>"
                + "<option value=\"1\">Normal (Kondisi Normal)</option>"
                + "<option value=\"2\">ST (Perubahan Iskemik)</option>"
                + "</select><br/>");
        writer.println("Max HR (Denyut Jantung):          <input type=\"text\" size=\"2\" name=\"maxhr\"/><br/>");
        writer.println("Exercise Angina (Nyeri Dada): <select name=\"exerciseangina\">"
                + "<option value=\"1\">Ya</option>"
                + "<option value=\"0\">Tidak</option>"
                + "</select><br/>");
        writer.println("Old Peak (Depresi Segmen):        <input type=\"text\" size=\"2\" name=\"oldpeak\"/><br/>");
        writer.println("ST Slope (Kemiringan Segemen):        <select name=\"st_slope\">"
                + "<option value=\"0\">Down (Turun)</option>"
                + "<option value=\"1\">Flat (Datar)</option>"
                + "<option value=\"2\">Up (Naik)</option>"
                + "</select><br/>");
        writer.println("<input type=\"submit\" value=\"Prediksi Jantung Anda\"/>");
        writer.println("</form>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");


        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<style>");
        writer.println("body { background-color: #EAEFF5; font-family: 'Arial', sans-serif; }");
        writer.println("h2 { color: #333; font-size: 24px; padding-left: 20px; }");
        writer.println("ul { list-style-type: disc; color: #333; font-size: 18px; padding-left: 40px; }");
        writer.println("li { margin-bottom: 10px; }");
        writer.println(".header { background-color: #108BE3; color: #FFF; padding: 10px; }");
        writer.println(".list-container { background-color: #F5F8FD; padding: 20px; }");
        writer.println(".list-title { color: #108BE3; font-size: 20px; margin-bottom: 10px; }");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class='header'>");
        writer.println("<h2>Hasil prediksi kesehatan Jantung</h2>");
        writer.println("</div>");


        String stringAge = req.getParameter("age");
        int age = Integer.parseInt(stringAge); // parse to int

        String stringSex = req.getParameter("sex");
        int sex = Integer.parseInt(stringSex);

        String stringChestpaintype = req.getParameter("chestpaintype");
        int chestpaintype = Integer.parseInt(stringChestpaintype);

        String stringRestingbp = req.getParameter("restingbp");
        int restingbp = Integer.parseInt(stringRestingbp);

        String stringCholesterol = req.getParameter("cholesterol");
        int cholesterol = Integer.parseInt(stringCholesterol);

        String stringFastingBS = req.getParameter("fastingBS");
        int fastingBS = Integer.parseInt(stringFastingBS);

        String stringRestingecg = req.getParameter("restingecg");
        int restingecg = Integer.parseInt(stringRestingecg);

        String stringMaxhr = req.getParameter("maxhr");
        int maxhr = Integer.parseInt(stringMaxhr);

        String stringExerciseangina = req.getParameter("exerciseangina");
        int exerciseangina = Integer.parseInt(stringExerciseangina);

        String stringOldpeak = req.getParameter("oldpeak");
        float oldpeak = Float.parseFloat(stringOldpeak);

        String stringSt_slope = req.getParameter("st_slope");
        int st_slope = Integer.parseInt(stringSt_slope);

        writer.println("<div class='list-container'>");
        writer.println("<h3 class='list-title'>Data Pasien:</h3>");
        writer.println("<ul>");
        writer.println("<li><b>Age:</b> " + age + "</li>");
        writer.println("<li><b>Sex:</b> " + sex + "</li>");
        writer.println("<li><b>Chestpain Type:</b> " + chestpaintype + "</li>");
        writer.println("<li><b>Resting BP:</b> " + restingbp + "</li>");
        writer.println("<li><b>Cholesterol:</b> " + cholesterol + "</li>");
        writer.println("<li><b>Fasting Blood Sugar:</b> " + fastingBS + "</li>");
        writer.println("<li><b>Resting ECG:</b> " + restingecg + "</li>");
        writer.println("<li><b>Max HR:</b> " + maxhr + "</li>");
        writer.println("<li><b>Exercise-Induced Angina:</b> " + exerciseangina + "</li>");
        writer.println("<li><b>Oldpeak:</b> " + oldpeak + "</li>");
        writer.println("<li><b>ST Slope:</b> " + st_slope + "</li>");
        writer.println("</ul>");
        writer.println("</div>");


        // eksekusi file python
        ProcessBuilder processBuilder = new ProcessBuilder(
                "python",
                "C:\\TIA\\Tugas\\Week 7\\apache-tomcat-10.1.7\\ProjekAkhir\\target\\Jantung_Sehat.py",
                "C:\\TIA\\Tugas\\Week 7\\apache-tomcat-10.1.7\\ProjekAkhir\\target\\heart.csv",
                stringAge, stringSex, stringChestpaintype, stringRestingbp, stringCholesterol, stringFastingBS, stringRestingecg, stringMaxhr, stringExerciseangina, stringOldpeak, stringSt_slope );

                        Process process = processBuilder.start();

        // menampilkan hasil eksekusi
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            // menampilkan hasil ke web page
//            writer.println("<h4> Res = "  + salary + "</h4>");
            writer.println("<h4> PREDICT ANDA MEMILIKI PENYAKIT JANTUNG ADALAH = "  + line + "</h4>");
            writer.println("<h4> Angka 0 Berarti Tidak, Angka Satu Berarti Anda Mempunyai Penyakit Jantung </h4>");
            System.out.println(line);
        }

        writer.println("<a href=\"index.jsp\">Kembali ke Menu Utama</a>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }
}
