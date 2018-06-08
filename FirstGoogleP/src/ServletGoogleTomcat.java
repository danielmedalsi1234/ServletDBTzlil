import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ServletGoogleTomcat extends HttpServlet {
    public static final String SET_MESSAGE = "set_message=";
    public static final String GET_MESSAGES = "get_messages=";
    private List<String> messages;

    @Override
    public void init() throws ServletException {
        messages = new ArrayList<>();
        messages.add("test1");
        messages.add("test2");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            response.getWriter().write("ok");
        }
    }
}
