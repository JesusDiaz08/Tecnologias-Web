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
        String h[] = new String[6];
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Encabezados</title>");
        out.println("</head>");
        out.println("<body>");
        for (int i = 0; i < 6; i++){
            h[i] = request.getParameter("clave_h"+(i+1));
            out.println("<h"+(i+1)+">");
            out.println(""+h[i]);
            out.println("</"+h[i]+">");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
