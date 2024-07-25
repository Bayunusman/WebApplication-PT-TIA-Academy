package menu;

import auth.LoginAuth;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/InsertData"})
public class InsertData extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginAuth.isValid==true) {
        DBUtil.connect();
        PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<style>");
            writer.println("body {");
            writer.println("    font-family: Arial, sans-serif;");
            writer.println("    background-image: url('img/test.jpg');");
            writer.println("    background-color: #ECECEC;");
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
            writer.println("    color: #4CAF50;");
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
            writer.println("<h4>Input Data Pasien</h4>");
            writer.println("<form action=\"InsertData\" method=\"post\">");
            writer.println("ID:              <input type=\"text\" size=\"2\" name=\"id\"/><br/>");
            writer.println("Age:             <input type=\"text\" size=\"2\" name=\"age\"/><br/>");
            writer.println("Sex:             <select name=\"sex\">"
                    + "<option value=\"F\">F</option>"
                    + "<option value=\"M\">M</option>"
                    + "</select><br/>");
            writer.println("Chestpain Type:  <select name=\"chestpaintype\">"
                    + "<option value=\"ATA\">ATA</option>"
                    + "<option value=\"NAP\">NAP</option>"
                    + "<option value=\"ASY\">ASY</option>"
                    + "<option value=\"TA\">TA</option>"
                    + "</select><br/>");
            writer.println("Resting BP:      <input type=\"text\" size=\"2\" name=\"restingbp\"/><br/>");
            writer.println("Cholesterol:     <input type=\"text\" size=\"2\" name=\"cholesterol\"/><br/>");
            writer.println("Fasting BS:      <select name=\"fastingBS\">"
                    + "<option value=\"0\">0</option>"
                    + "<option value=\"1\">1</option>"
                    + "</select><br/>");
            writer.println("Resting ECG:     <select name=\"restingecg\">"
                    + "<option value=\"Normal\">Normal</option>"
                    + "<option value=\"ST\">ST</option>"
                    + "</select><br/>");
            writer.println("Max HR:          <input type=\"text\" size=\"2\" name=\"maxhr\"/><br/>");
            writer.println("Exercise Angina: <select name=\"exerciseangina\">"
                    + "<option value=\"Y\">Y</option>"
                    + "<option value=\"N\">N</option>"
                    + "</select><br/>");
            writer.println("Old Peak:        <input type=\"text\" size=\"2\" name=\"oldpeak\"/><br/>");
            writer.println("ST Slope:        <select name=\"st_slope\">"
                    + "<option value=\"Up\">Up</option>"
                    + "<option value=\"Flat\">Flat</option>"
                    + "<option value=\"Down\">Down</option>"
                    + "</select><br/>");
            writer.println("Heart Disease:   <select name=\"heartdisease\">"
                    + "<option value=\"1\">1</option>"
                    + "<option value=\"0\">0</option>"
                    + "</select><br/>");
            writer.println("<input type=\"submit\" value=\"Simpan\"/>");
            writer.println("</form>");
            writer.println("</div>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");

            writer.flush();

        }else {
            LoginAuth.unauthorizedAcess(resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



            String stringId = req.getParameter("id");
            int id = Integer.parseInt(stringId); // parse to int
            System.out.println("id: "+id);

            String stringAge = req.getParameter("age");
            int age = Integer.parseInt(stringAge); // parse to int
            System.out.println("age: "+age);

            String sex = req.getParameter("sex");
            System.out.println("sex: "+sex);

            String stringChestpaintype = req.getParameter("chestpaintype");
            System.out.println("chestpaintype: "+ stringChestpaintype);

            String stringRestingbp = req.getParameter("restingbp");
            int restingbp = Integer.parseInt(stringRestingbp);
            System.out.println("restingbp: "+ stringRestingbp);


            String stringCholesterol = req.getParameter("cholesterol");
            int cholesterol = Integer.parseInt(stringCholesterol);
            System.out.println("cholesterol: "+ stringCholesterol);


            String fastingBS = req.getParameter("fastingBS");
            System.out.println("fastingBS: "+ fastingBS);

            String restingecg = req.getParameter("restingecg");
            System.out.println("restingecg: "+ restingecg);

            String stringMaxhr = req.getParameter("maxhr");
            int maxhr = Integer.parseInt(stringMaxhr);
            System.out.println("maxhr: "+ stringMaxhr);

            String Exerciseangina = req.getParameter("exerciseangina");
            System.out.println("exerciseangina: "+ Exerciseangina);

            String stringOldpeak = req.getParameter("oldpeak");
            float oldpeak = Float.parseFloat(stringOldpeak);
//            float oldpeak = Float.parseFloat(stringOldpeak);
            //System.out.println("oldpeak: "+oldpeak);

            String st_slope = req.getParameter("st_slope");
            System.out.println("st_slope: "+st_slope);

            String heartdisease = req.getParameter("heartdisease");
            System.out.println("heartdisease: "+heartdisease);


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
            if (DBUtil.insert("jantung_sehat", id, age, sex, stringChestpaintype, restingbp, cholesterol, fastingBS, restingecg, maxhr, Exerciseangina, oldpeak, st_slope, heartdisease)) {
                writer.println("<h2>Data dengan ID " + id + " berhasil ditambahkan!</h2>");
            } else {
                writer.println("<h2>Gagal menambahkan data dengan ID " + id + "!</h2>");
            }
            writer.println("<h4><a href=\"Main\">Kembali ke Menu Utama</a></h4>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");

            writer.flush();



    }
}


