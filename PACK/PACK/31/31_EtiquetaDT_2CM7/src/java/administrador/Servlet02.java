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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String pais = (String)session.getAttribute("atributo_num");
        int num_pais = Integer.parseInt(pais);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2> PAISES-ESTADOS </h2>");
        out.println("<dl>");
        for (int i = 0; i < num_pais; i++) {
            out.println("<dt>"+request.getParameter("clave_p"+i)+" </dt>");
            out.println("<dd>"+request.getParameter("clave_e"+i)+" </dd>");
        }
        out.println("</dl>");
        out.println("</body>");
        out.println("</html>");
    }
}
