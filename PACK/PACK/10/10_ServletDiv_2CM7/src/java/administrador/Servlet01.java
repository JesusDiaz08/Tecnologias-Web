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
        PrintWriter out = response.getWriter();
        String alineacion = request.getParameter("clave_alineacion");
        String contenido = request.getParameter("clave_contenido");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div align='"+alineacion+"'>"+contenido+"</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
