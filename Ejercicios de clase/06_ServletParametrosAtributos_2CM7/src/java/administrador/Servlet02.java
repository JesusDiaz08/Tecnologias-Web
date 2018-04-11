package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String Object01 = (String)session.getAttribute("clave_atributo1");
        int Object01_i = Integer.parseInt(Object01);
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet02</title>");
        out.println("</head>");
        out.println("<body>");
        
        for (int i = 0; i < Object01_i; i++) {
            out.println("<a href='"+request.getParameter("clave_url"+i)+"'>"+
                         request.getParameter("clave_valor"+i)+"</a>");
            out.println("<br/>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
