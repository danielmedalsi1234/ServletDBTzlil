import javax.servlet.ServletException;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ChatServlet extends javax.servlet.http.HttpServlet {

    public static final String SET_MESSAGE = "first_name=";
    public static final String GET_MESSAGES = "get_message=";
    private List<String> messages;
    public static final String pathToDesktop = "/home/danielmedalsi1234/Desktop/";



    @Override
    public void init() throws ServletException {
        messages = new ArrayList<>();

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    protected void doGet (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
            response) throws javax.servlet.ServletException, IOException
    {

        String queryString = request.getQueryString();
        if (queryString == null)
            return;

        if (queryString.startsWith(GET_MESSAGES)) {
            int from = Integer.valueOf(queryString.substring(GET_MESSAGES.length()));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = from; i < messages.size() - 1; i++) {
                stringBuilder.append(messages.get(i) + "&");
            }
            if (messages.size() > 0 && from <= messages.size() - 1)
                stringBuilder.append(messages.get(messages.size() - 1));
            response.getWriter().write(stringBuilder.toString());
        } else if (queryString.startsWith(SET_MESSAGE)) {
            if (messages.size() > 300) {
                return;
            }
            this.messages.add(queryString.substring(SET_MESSAGE.length()));
            for (int i=0;i<messages.size();i++){
                response.getWriter().write("\n" + i + ":"+ messages.get(i));
                System.out.println(messages.get(i));
            }
            try {
                InsertDataToTableDB();
            } catch (Exception e) {
                e.printStackTrace();
            }
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

        String query = " insert into user (user_name,password,id)"
                + " values ('roei',11234112,279879993)";
        try {
            Connection connection = getConnection();
            PreparedStatement insert = connection.prepareStatement(query);
            insert.executeUpdate();
            System.out.println("try-insert done");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erorr insert");
        } finally {
            System.out.println("finaly - insert");

        }
    }



}
