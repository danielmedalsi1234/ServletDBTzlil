package danielmedalsi1234.servletDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "onlineChatServlet",urlPatterns = "/onlineChatServlet",description = "online_Chat_Servlet")
public class onlineChatServlet extends HttpServlet {
    public static final String SET_MESSAGE = "set_message=";
    public static final String GET_MESSAGES = "get_messages=";
    private List<String> messages;

    @Override
    public void init() throws ServletException {
        messages = new ArrayList<>();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String queryString = request.getQueryString();
        if(queryString == null)
            return;

        if(queryString.startsWith(GET_MESSAGES)){
            int from = Integer.valueOf(queryString.substring(GET_MESSAGES.length()));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = from; i < messages.size()-1; i++) {
                stringBuilder.append(messages.get(i) + "&");
            }
            if(messages.size() > 0 && from <= messages.size()-1)
                stringBuilder.append(messages.get(messages.size()-1));
            response.getWriter().write(stringBuilder.toString());
        }else if(queryString.startsWith(SET_MESSAGE)){
            if(messages.size() > 300) {
                return;
            }
            this.messages.add(queryString.substring(SET_MESSAGE.length()));
            response.getWriter().write("successfully");
        }


    }
}
