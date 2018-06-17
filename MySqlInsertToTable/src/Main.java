import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) throws Exception {

            //getConnection();


            /*CreateTableDB();
            System.out.println("insert completed");*/

            try {
                InsertDataToTableDB();
            }catch (Exception e){
                e.printStackTrace();
            }



    }


    public static Connection getConnection() throws Exception {

        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/users";
            String user_name = "root";
            String password = "de12de9578641";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user_name, password);
            System.out.println("connected");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void CreateTableDB() throws Exception {
        final String UserName = "dani1";
        final int password = 1234;
        final int id = 1;
        try {
            Connection connection = getConnection();
            PreparedStatement insert = connection.prepareStatement("create table test (\n" +
                    "  id int unsigned auto_increment not null,\n" +
                    "  first_name varchar(32) not null,\n" +
                    "  last_name varchar(32) not null,\n" +
                    "  date_created timestamp default now(),\n" +
                    "  is_admin boolean,\n" +
                    "  num_points int,\n" +
                    "  primary key (id)\n" +
                    ");");
            insert.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("insert complete!");
        }
    }
    public static void InsertDataToTableDB() throws Exception {
        final String UserName = "dani1";
        final int password = 1234;
        final int id = 1;
        String query = " insert into user (user_name,password,id)"
                + " values ('roei12',11234112,279879993)";
        try {
            Connection connection = getConnection();
            PreparedStatement insert = connection.prepareStatement(query);
            insert.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("insert complete!");
        }
    }
}