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
        String datos[] = new String[4];
        datos[0] = request.getParameter("clave_name");
        datos[1] = request.getParameter("clave_age");
        datos[2] = request.getParameter("clave_sex");
        datos[3] = request.getParameter("clave_school");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Lista Descriptiva</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2> Datos </h2>");
        out.println("<dl>");
            out.println("<dt>Nombre </dt>");
                out.println("<dd>"+datos[0]+" </dd>");
            out.println("<dt>Edad </dt>");
                out.println("<dd>"+datos[1]+" </dd>");
            out.println("<dt>Sexo </dt>");
                out.println("<dd>"+datos[2]+" </dd>");
            out.println("<dt>Escuela </dt>");
                out.println("<dd>"+datos[3]+" </dd>");
        out.println("</dl>");
        out.println("</body>");
        out.println("</html>");
    }
}
