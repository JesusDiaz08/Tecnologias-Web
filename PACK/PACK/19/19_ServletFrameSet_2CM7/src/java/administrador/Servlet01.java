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
        PrintWriter out = response.getWriter();
        
        String links = request.getParameter("clave_link");
        int num_link = Integer.parseInt(links);
        
        session.setAttribute("atributo_link", links);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Marcos-Links</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' method='GET'>");
        for (int i = 0; i < num_link; i++) {
             out.println("Link"+i+": <input type ='text' name='link"+i+"' size='7'/>");
             out.println("</br>");
             out.println("Texto"+i+": <input type ='text' name='texto"+i+"' size='5'/>");
             out.println("</br>");
        }
        out.println("<input type='submit' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
