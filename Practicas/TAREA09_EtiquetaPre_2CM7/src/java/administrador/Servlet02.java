package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String tool = (String)session.getAttribute("atributo_numT");
        int num_tools = Integer.parseInt(tool);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet02 Orden</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<pre> Las herramienats necesarias son: ");
        for (int i = 0; i < num_tools; i++) 
            out.println(""+(i+1)+".- " +request.getParameter("tool_"+i));
        out.println("</pre>");
        out.println("</body>");
        out.println("</html>");
    }
}
