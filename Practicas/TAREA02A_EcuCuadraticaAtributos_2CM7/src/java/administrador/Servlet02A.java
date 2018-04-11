package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet02A extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession();
       
       String X1 = (String)session.getAttribute("x1_atributo");
       String X2 = (String)session.getAttribute("x2_atributo");
       
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SERVLET_02A</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> "+X1+"</h1>");
        out.println("<br/>");
        out.println("<h1> "+X2+"</h1>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("</body>");
        out.println("</html>");
    }
}
