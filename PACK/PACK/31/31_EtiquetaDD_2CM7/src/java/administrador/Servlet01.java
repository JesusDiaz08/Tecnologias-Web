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
        
        String act[] = new String[2];
        act[0] = request.getParameter("clave_d");
        act[1] = request.getParameter("clave_j");
        
        int num[] = new int[2];
        num[0] = Integer.parseInt(act[0]);
        num[1] = Integer.parseInt(act[1]);
        
        System.out.println("S1: D: "+act[0]);
        System.out.println("S1: J: "+act[1]);
        
        session.setAttribute("atributo_deporte", act[0]);
        session.setAttribute("atributo_jugador", act[1]);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' method='get'>");
        
        for (int i = 0; i < num[0]; i++) {
            out.println("Deporte "+(i+1)+": <input type='text' name='dep"+i+"'/>");
            out.println("</br>");
            for (int j = 0; j < num[1]; j++) 
                out.println("Jugador: <input type='text' name='jug"+j+"'/>");
            out.println("</br>");
            out.println("<hr>");
        }
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}

