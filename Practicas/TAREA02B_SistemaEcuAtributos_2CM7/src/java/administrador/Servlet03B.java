package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet03B extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Cramer solve = new Cramer();
        
        /*Obtengo los datos de los atributos,*/
        String[] ecua01 = new String[3];
        String[] ecua02 = new String[3];
        
        ecua01[0] = request.getParameter("clave_A1");
        ecua01[1] = request.getParameter("clave_B1");
        ecua01[2] = request.getParameter("clave_S1");
        ecua02[1] = request.getParameter("clave_A2");
        ecua02[0] = request.getParameter("clave_B2");
        ecua02[2] = request.getParameter("clave_S2");
        
        solve.setA1(Float.parseFloat(ecua01[0]));
        solve.setB1(Float.parseFloat(ecua01[1]));
        solve.setS1(Float.parseFloat(ecua01[2]));
        
        solve.setA2(Float.parseFloat(ecua02[0]));
        solve.setB2(Float.parseFloat(ecua02[1]));
        solve.setS2(Float.parseFloat(ecua01[2]));
        
        String[] unknowns = solve.useCramer(solve.getA1(), solve.getB1(),
                                           solve.getS1(), solve.getA2(),
                                           solve.getB2(), solve.getS2());
        
        session.setAttribute("X_atributo", unknowns[0]);
        session.setAttribute("Y_atributo", unknowns[1]);
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet09</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> X: "+unknowns[0]+", Y: "+unknowns[1]+"</h1>");
        out.println("</body>");
        out.println("</html>");
    } 
}
