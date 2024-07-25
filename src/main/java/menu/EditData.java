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

@WebServlet(urlPatterns = {"/EditData"})
public class EditData extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if(LoginAuth.isValid == true){
            String id = req.getParameter("id");
            String ageString = req.getParameter("age");
            int age = Integer.parseInt(ageString);
            String sex = req.getParameter("sex");
            String chestpaintype = req.getParameter("chestpaintype");
            String restingbpString = req.getParameter("restingbp");
            int restingbp = Integer.parseInt(restingbpString);
            String cholesterolString = req.getParameter("cholesterol");
            int cholesterol = Integer.parseInt(cholesterolString);
            String fastingBSString = req.getParameter("fastingBS");
            int fastingBS = Integer.parseInt(fastingBSString);
            String restingecg = req.getParameter("restingecg");
            String maxhrString = req.getParameter("maxhr");
            int maxhr = Integer.parseInt(maxhrString);
            String exerciseangina = req.getParameter("exerciseangina");
            String oldpeakString = req.getParameter("oldpeak");
//            float oldpeak = Float.parseFloat(oldpeakString);
            float oldpeak = 0;
            if (oldpeakString != null) {
                try {
                    oldpeak = Float.parseFloat(oldpeakString.trim());
                } catch (NumberFormatException e) {
                }
            }
            String st_slope = req.getParameter("st_slope");
            String heartdiseaseString = req.getParameter("heartdisease");
            int heartdisease = Integer.parseInt(heartdiseaseString);


            PrintWriter writer = resp.getWriter();
                writer.println("<html>");
                writer.println("<head>");
                writer.println("<style>");
                writer.println("body {");
                writer.println("    font-family: Arial, sans-serif;");
                writer.println("    background-image: url('img/test.jpg');");
                writer.println("    background-color: silver;"); // Ganti dengan warna latar belakang yang sesuai
                writer.println("}");
                writer.println(".form-container {");
                writer.println("    max-width: 500px;");
                writer.println("    margin: 50px auto;");
                writer.println("    background-color: white;");
                writer.println("    padding: 30px;");
                writer.println("    border-radius: 8px;");
                writer.println("    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);");
                writer.println("}");
                writer.println(".form-container h4 {");
                writer.println("    text-align: center;");
                writer.println("    margin-bottom: 20px;");
                writer.println("}");
                writer.println(".form-container form {");
                writer.println("    display: flex;");
                writer.println("    flex-direction: column;");
                writer.println("}");
                writer.println(".form-container label {");
                writer.println("    margin-bottom: 10px;");
                writer.println("    font-weight: bold;");
                writer.println("}");
                writer.println(".form-container input, .form-container select {");
                writer.println("    padding: 8px;");
                writer.println("    border: 1px solid #ccc;");
                writer.println("    border-radius: 4px;");
                writer.println("}");
                writer.println(".form-container input[type=\"submit\"] {");
                writer.println("    background-color: #4CAF50;");
                writer.println("    color: white;");
                writer.println("    border: none;");
                writer.println("    cursor: pointer;");
                writer.println("    padding: 10px 20px;");
                writer.println("    margin-top: 20px;");
                writer.println("}");
                writer.println(".form-container input[type=\"submit\"]:hover {");
                writer.println("    background-color: #45a049;");
                writer.println("}");
                writer.println("</style>");
                writer.println("</head>");
                writer.println("<body>");
                writer.println("<pre>");
                writer.println("<div class=\"form-container\">");
                writer.println("<h4>Edit Data Pasien</h4>");
                writer.println("<form action=\"EditData\" method=\"post\">");
                writer.println("id              :    <input type=\"text\" size=\"2\" name=\"id\"" +
                        " value="+id+" readonly><br/>");
                writer.println("Age             :    <input type=\"text\" size=\"2\" name=\"age\"" +
                        " value="+age+"><br/>");
                writer.println("Sex             :     <select name=\"sex\">"
                        + "<option value=\"F\">F</option>"
                        + "<option value=\"M\">M</option>"
                        + "</select><br/>");
                writer.println("Chestpaintype   :     <select name=\"chestpaintype\">"
                        + "<option value=\"ATA\">ATA</option>"
                        + "<option value=\"NAP\">NAP</option>"
                        + "<option value=\"ASY\">ASY</option>"
                        + "<option value=\"TA\">TA</option>"
                        + "</select><br/>");
                writer.println("Restingbp       :     <input type=\"text\" size=\"2\" name=\"restingbp\""+
                        " value="+restingbp+"><br/>");
                writer.println("Cholesterol     :     <input type=\"text\" size=\"2\" name=\"cholesterol\""+
                        " value="+cholesterol+"><br/>");
                writer.println("FastingBS       :     <select name=\"fastingBS\">"
                        + "<option value=\"0\">0</option>"
                        + "<option value=\"1\">1</option>"
                        + "</select><br/>");
                writer.println("Restingecg      :     <select name=\"restingecg\">"
                        + "<option value=\"Normal\">Normal</option>"
                        + "<option value=\"ST\">ST</option>"
                        + "</select><br/>");
                writer.println("Maxhr           :     <input type=\"text\" size=\"2\" name=\"maxhr\""+
                        " value="+maxhr+"><br/>");
                writer.println("Exerciseangina  :     <select name=\"exerciseangina\">"
                        + "<option value=\"Y\">Y</option>"
                        + "<option value=\"N\">N</option>"
                        + "</select><br/>");
                writer.println("Oldpeak         :     <input type=\"text\" size=\"2\" name=\"oldpeak\""+
                        " value="+oldpeak+"><br/>");
                writer.println("St_slope        :     <select name=\"st_slope\">"
                        + "<option value=\"Up\">Up</option>"
                        + "<option value=\"Flat\">Flat</option>"
                        + "<option value=\"Down\">Down</option>"
                        + "</select><br/>");
                writer.println("Heartdisease    :     <select name=\"heartdisease\">"
                        + "<option value=\"1\">1</option>"
                        + "<option value=\"0\">0</option>"
                        + "</select><br/>");
                writer.println("<input type=\"submit\" value=\"UPDATE\"/>");
                writer.println("</form>");
                writer.println("</div>");
                writer.println("</pre>");
                writer.println("</body>");
                writer.println("</html>");

            }else{
                LoginAuth.unauthorizedAcess(resp);
            }

        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ambil Parameter
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

        String exerciseangina = req.getParameter("exerciseangina");
        System.out.println("exerciseangina: "+ exerciseangina);

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
        if (DBUtil.update("jantung_sehat", id, age, sex, stringChestpaintype, restingbp, cholesterol, fastingBS, restingecg, maxhr, exerciseangina, oldpeak, st_slope, heartdisease)) {
            writer.println("<h2>Data berhasil diperbarui!</h2>");
        } else {
            writer.println("<h2>Gagal memperbarui data!</h2>");
        }
        writer.println("<h4><a href=\"Main\">Kembali ke Menu Utama</a></h4>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();


    }
}




