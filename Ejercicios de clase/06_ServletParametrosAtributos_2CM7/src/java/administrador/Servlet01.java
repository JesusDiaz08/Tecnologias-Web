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
        String valor01 = request.getParameter("clave_parametro01");
        HttpSession session = request.getSession(); /*Guardaremos las URLs*/
        int valor01_i = Integer.parseInt(valor01);
        session.setAttribute("clave_atributo1", valor01);
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Servlet01 </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action = 'Servlet02' method='GET'>");
        for (int i = 0; i < valor01_i ; i++) {
            out.println("URL: <input type='text' name='clave_url"+i+"' />");
            out.println("<br/>");
            out.println("Valor del nodo "+i+": <input type='text' name='clave_valor"+i+"' />");        
            out.println("<br/>");
        }
        out.println("<input type='submit' />");
        
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
