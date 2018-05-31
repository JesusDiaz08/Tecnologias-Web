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
        
        String type_lista = request.getParameter("clave_lista").toUpperCase();
        String numero = request.getParameter("clave_num");
        
        session.setAttribute("atributo_tipoL", type_lista);
        session.setAttribute("atributo_num", numero);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' method='GET'>");
        for (int i = 0; i < Integer.parseInt(numero); i++) {
            out.println("Texto "+i+": <input type='text' name='texto"+i+"' size='10'/>");
            out.println("Refer "+i+": <input type='text' name='refer"+i+"' size='10'/>");
            out.println("<br/>");
        }
        
        out.println("<input type='submit' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
