package utils;

import java.sql.*;

public class DBUtil {
    static Connection connection = null;
    static Statement statement = null;

    // konek ke DB
    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/projek_akhir", "root", "Bayu250801.");
            statement = connection.createStatement();
            System.out.println("Koneksi ke DB berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi ke DB gagal!");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet selectUser(String email, String password) throws SQLException {
//        return statement.executeQuery ("select * from users where email ='"+email+"'and"+"password='"+password+"'");
        String sql = ("select * from users where email ='" + email + "' and " + "password='" + password + "'");
        System.out.println("sql = " + sql);
        return statement.executeQuery(sql);

    }

    public static boolean insertRegist(String tableName, String Email, String Password) {
        //create query
        String query = "insert into " + tableName + " (email , password) values ('" + Email + "', '" + Password + "')";
        System.out.println("Query = " + query);
        try {
            if (statement.executeUpdate(query) > 0) {
                System.out.println("Query TRUE");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet selectAll(String tableName) throws SQLException {
        return statement.executeQuery("select * from " + tableName);

    }
    public static boolean insert(String tableName, int id, int age, String sex, String chestpaintype, int restingbp, int cholesterol, String fastingBS, String restingecg, int maxhr, String exerciseangina, float oldpeak, String st_slope, String heartdisease) {
        String query = "INSERT INTO " + tableName + " VALUES (" + id + ", " + age + ", '" + sex + "', '" + chestpaintype + "', " + restingbp + ", " + cholesterol + ", '" + fastingBS + "', '" + restingecg + "', " + maxhr + ", '" + exerciseangina + "', " + oldpeak + ", '" + st_slope + "', '" + heartdisease + "')";
        System.out.println(query);
        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(String tableName, int id, int age, String sex, String chestpaintype, int restingbp, int cholesterol, String fastingBS, String restingecg, int maxhr, String exerciseangina, float oldpeak, String st_slope, String heartdisease) {
        // Membuat query
        String query = "UPDATE " + tableName + " SET age = " + age + ", sex = '" + sex + "', chestpaintype = '" + chestpaintype + "', restingbp = " + restingbp +
                ", cholesterol = " + cholesterol + ", fastingBS = '" + fastingBS + "', restingecg = '" + restingecg + "', maxhr = " + maxhr +
                ", exerciseangina = '" + exerciseangina + "', oldpeak = " + oldpeak + ", st_slope = '" + st_slope +
                "', heartdisease = '" + heartdisease + "' WHERE id = " + id;

        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //fungsi menghapus record
    public static boolean delete(String tableName, int id) {
        //membuat query
        String query = "delete from " + tableName + " where id = " + id;
        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static ResultSet hearth(String tableName) throws SQLException {
//        return statement.executeQuery("select * from " + tableName);
//
//    }
}