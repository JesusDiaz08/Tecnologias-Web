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
        String sex[] = request.getParameterValues("clave_sex");
        String name = request.getParameter("clave_name");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Nombre: "+name);
        out.println("</br>Los valores seleccionados son: <br/>");
        for (int i = 0; i < sex.length; i++) 
            out.println("<h2>"+sex[i]+"</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
