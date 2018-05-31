package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String se = request.getParameter("clave_se");
        String ce = request.getParameter("clave_ce");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Enfasis</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>"+se+"</p>");
        out.println("<hr>");
        out.println("<p><em>"+ce+"</em></p>");
        out.println("</body>");
        out.println("</html>");
    }
}
