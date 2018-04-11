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
        PrintWriter out = response.getWriter();
        
        String num = (String)session.getAttribute("atributo_link");
        int num_i = Integer.parseInt(num);
        
        String parametros="?";
        
        for (int i = 0; i < num_i; i++) {
            parametros += "link"+i+"="+request.getParameter("link"+i)+"&"
                         + "texto"+i+"="+request.getParameter("texto"+i)+"&";
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<frameset cols='30%,*'>");
            out.println("<frame src='Servlet03"+parametros+"'/>");
            out.println("<frame src='Servlet04' name='contenidos' />");
        out.println("</frameset>");
        out.println("<body>");
        out.println("<h1>Hello World</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
