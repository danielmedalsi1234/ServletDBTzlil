package danielmedalsi1234.servletDB;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@javax.servlet.annotation.WebServlet(name = "ServletDB",urlPatterns = "/ServletDB",description = "servlet_db")
public class ServletDB extends javax.servlet.http.HttpServlet {
    ResultSet rs;
    PreparedStatement ps;

        protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        }
        protected void doGet (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
                response) throws javax.servlet.ServletException, IOException
        {

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();

            String fullName = request.getParameter("txtFullName");
            int phone = Integer.parseInt(request.getParameter("txtPhone"));
            //int id = Integer.parseInt(request.getParameter("txtID"));

                printWriter.print("<html>");
                printWriter.print("<body bgcolor=pink");

                printWriter.print("<br><font color=blue size=20>Full Name: "+ fullName +"</font>");
                printWriter.print("<br><font color=blue size=20>Phone: "+ phone +"</font>");
                //printWriter.print("<br><font color=blue size=20>your ID: "+ id +"</font>");
                printWriter.print("</body>");
                printWriter.print("</html>");

            try {
                InsertDataToTableDB(fullName,phone);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                this.getConnection();
                System.out.println("in connection");
                ps = getConnection().
                        prepareStatement("select * from newOferrs");
                rs = ps.executeQuery();
                //make table
                System.out.println("<table>");

                while (rs.next()) {
                    System.out.println("full name: "
                            + rs.getString(1) + " | phone: " + rs.getString(2));
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("error!!!");
            }

        }

    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            //here enter url with/database
            String url = "jdbc:mysql://localhost:3306/tzlilMakeUp";
            //here enter username for mysql
            String user_name = "root";
            //here enter password for mysql
            String password = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user_name, password);
            System.out.println("connected");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*public static void CreateTableDB() throws Exception {
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
    }*/
    public void InsertDataToTableDB(String full_name,int phone) throws Exception {

        String query = " insert into newOferrs (full_name,phone)"
                + " values ('"+full_name+"',"+phone+")";
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

    public void pullDataFromTable(){

    }
}
