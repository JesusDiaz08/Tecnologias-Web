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
        String act[] = new String[2];
        act[0] = (String)session.getAttribute("atributo_deporte");
        act[1] = (String)session.getAttribute("atributo_jugador");
        
        System.out.println("Deporte: "+act[0]);
        System.out.println("Jugador: "+act[1]);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet02</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<dl>Los deportes y sus respectivos jugadores son:");
        for (int i = 0; i < Integer.parseInt(act[0]); i++) {
            out.println("<dt> "+request.getParameter("dep"+i)+" </dt>");
            System.out.println("dep:"+i);
            for (int j = 0; j < Integer.parseInt(act[1]); j++){
                System.out.println("jug:"+j);
                out.println("<dd> "+request.getParameter("jug"+j)+" </dd>");
            }
            System.out.println("____");
        }
        out.println("</dl>");
        out.println("</body>");
        out.println("</html>");
    }
}
