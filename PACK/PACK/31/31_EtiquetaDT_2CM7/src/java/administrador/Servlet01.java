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
        String num = request.getParameter("clave_num");
        int num_i = Integer.parseInt(num);
        PrintWriter out = response.getWriter();
        session.setAttribute("atributo_num", num);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet02</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' metho='get'>");
        for (int i = 0; i < num_i; i++) {
            out.println("Pais:   <input type='text' name='clave_p"+i+"' />");
            out.println("Ciudad: <input type='text' name='clave_e"+i+"' />");
            out.println("</br>");
        }
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
