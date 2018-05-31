package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String tools = request.getParameter("clave_tools");
        int num_tools = Integer.parseInt(tools);
        session.setAttribute("atributo_numT", tools);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet02 </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' method='get'>");
        for (int i = 0; i < num_tools; i++) {
            out.println("Herramienta "+(i+1)+": ");
            out.println("<input type='text' name='tool_"+i+"' />");
            out.println("<br/>");
        }
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
