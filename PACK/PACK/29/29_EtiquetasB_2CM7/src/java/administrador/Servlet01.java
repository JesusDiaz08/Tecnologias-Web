package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cadena = request.getParameter("clave_bold");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Etiqueta Black</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<b>"+cadena+" </b>");
        out.println("</body>");
        out.println("</html>");
        
    }
}
