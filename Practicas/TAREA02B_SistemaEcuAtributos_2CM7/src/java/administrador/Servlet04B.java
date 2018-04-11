package administrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet04B extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession();
       
       String X = (String)session.getAttribute("X_atributo");
       String Y = (String)session.getAttribute("Y_atributo");
       
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet08</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> "+X+"</h1>");
        out.println("<br/>");
        out.println("<h1> "+Y+"</h1>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("</body>");
        out.println("</html>");
    }
}