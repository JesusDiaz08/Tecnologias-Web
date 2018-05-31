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
        String lineas = (String)session.getAttribute("atributo_numero");
        int num_lineas = Integer.parseInt(lineas);
        
        PrintWriter out = response.getWriter();        
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
            out.println("<canvas id='myCanvas' width='600' height='800'> </canvas>");
            out.println("<script>");
                out.println("var canvas = document.getElementById('myCanvas');");
                out.println("var context = canvas.getContext('2d');");
                for (int i = 0; i < num_lineas; i++) {
                    out.println("context.beginPath();");
                    out.println("context.moveTo("+request.getParameter("xi"+i)+","
                                                 +request.getParameter("yi"+i)+")");
                    out.println("context.lineTo("+request.getParameter("xf"+i)+","
                                                 +request.getParameter("yf"+i)+")");
                    out.println("context.stroke();");
                }
                
            out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
}
