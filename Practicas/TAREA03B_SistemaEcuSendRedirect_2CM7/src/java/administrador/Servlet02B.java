package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02B extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String valor_X = request.getParameter("parametro_X");
        String valor_Y = request.getParameter("parametro_Y");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet02</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Los valores de X y Y son:</h1>");
        out.println("<h2>X ="+valor_X+"</h2>");
        out.println("<h2>Y ="+valor_Y+"</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
