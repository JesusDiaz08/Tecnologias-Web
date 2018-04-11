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
        String pais = request.getParameter("clave_txt");
        String bandera = request.getParameter("clave_img");
        String ali_pais = request.getParameter("clave_align");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='2'>");
        
        out.println("<tr>");
            out.println("<td><strong> Pais </td>");
            out.println("<td><strong> Bandera </td>");
        out.println("</tr>");
        
        out.println("<tr>");
            out.println("<td>"+pais+"</td>");
            out.println("<td><img src='"+bandera+"' align='"+ali_pais+"'></td>");
        out.println("</tr>");
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
