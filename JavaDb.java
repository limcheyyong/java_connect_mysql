
/**
 * JavaDb
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaDb {

    public static void main(String[] args)throws Exception {
        insert();
        
    }
    public static void insert() throws Exception{
        try {
            Connection con = getConnection();
            PreparedStatement insert = con.prepareStatement("INSERT INTO `tablename`(`id`, `fisrt`, `last`) VALUES (3,'lim','yong')");
            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //select
    public static void select() throws Exception{
        try {
            Connection con = getConnection();
            PreparedStatement selected = con.prepareStatement("SELECT * FROM tablename");
            ResultSet result = selected.executeQuery();
            while(result.next()){
                System.out.println(result.getString("fisrt"));
                System.out.println(result.getString("last"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Function Complete");
        }
    }
    //insert
    public static void post() throws Exception{
        final String var1 = "John";
        final String var2 = "Heller";
        try {
            Connection con  = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO tablename(fisrt,last) value ('"+var1+"','"+var2+"')");
            posted.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Function Complete");
        }
    }
    //create a table
    public static void creatTable() throws Exception{
        try {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename(id int NOT NULL AUTO_INCREMENT,fisrt varchar(225),last varchar(225),PRIMARY KEY(id))");
            create.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Function Complete");
        }
    }
    //connect db
    public static Connection getConnection() throws Exception{
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/text?serverTimezone=GMT ";
            String user = "root";
            String password = "Limcheyyong6877";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}