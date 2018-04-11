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
        HttpSession session = request.getSession();
        String lineas = request.getParameter("numero_lineas");
        int numero_lineas = Integer.parseInt(lineas);
        
        session.setAttribute("atributo_numero", lineas);
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' method='GET'>");
        for (int i = 0; i < numero_lineas; i++) {
            out.println("Punto inicial X"+(i+1)+": <input type='text' name='xi"+i+"' /> ");
            out.println("Punto inicial Y"+(i+1)+": <input type='text' name='yi"+i+"' /> ");
            out.println("Punto final X"+(i+1)+": <input type='text' name='xf"+i+"' /> ");
            out.println("Punto final Y"+(i+1)+": <input type='text' name='yf"+i+"' /> ");
            out.println("</br>");
        }
        out.println("<input type='submit' />");
        out.println("<form>");
        out.println("</body>");
        out.println("</html>");
    }
}
