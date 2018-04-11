package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cramer solve = new Cramer();
        response.setContentType("text/html;charset=UTF-8");
        
        /*ES LA CLAVE-VALOR*/
        
        /*ECUACION 01*/
        String A1 = request.getParameter("clave_A1");
        String B1 = request.getParameter("clave_B1");
        String S1 = request.getParameter("clave_S1");
        
        /*ECUACION 02*/
        String A2 = request.getParameter("clave_A2");
        String B2 = request.getParameter("clave_B2");
        String S2 = request.getParameter("clave_S2");
        
        solve.setA1(Float.parseFloat(A1));
        solve.setB1(Float.parseFloat(B1));
        solve.setS1(Float.parseFloat(S1));
        
        solve.setA2(Float.parseFloat(A2));
        solve.setB2(Float.parseFloat(B2));
        solve.setS2(Float.parseFloat(S2));
        
        String[] unkowns = solve.useCramer(solve.getA1(), solve.getB1(),
                                           solve.getS1(), solve.getA2(),
                                           solve.getB2(), solve.getS2());
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet04</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> VALORES DE LAS INCOGNITAS. </h1>");
        out.println("<br/>");
        out.println("<h2> X: "+unkowns[0]+"</h2>");
        out.println("<h2> Y: "+unkowns[1]+"</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
