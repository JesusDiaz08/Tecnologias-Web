package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet01A extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession();  /*Servirá para guardar: COFRE*/
       EcuCuadratica ecu = new EcuCuadratica();
       
       String a = request.getParameter("clave_a");
       String b = request.getParameter("clave_b");
       String c = request.getParameter("clave_c");
       
       ecu.setA(Float.parseFloat(a));
       ecu.setB(Float.parseFloat(b));
       ecu.setC(Float.parseFloat(c));
       
       String[] raiz = ecu.solve(ecu.getA(), ecu.getB(), ecu.getC());
       
       session.setAttribute("x1_atributo",raiz[0]);
       session.setAttribute("x2_atributo",raiz[1]);
       
       PrintWriter out = response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>SERVLET_01A</title>");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1> Las raices de la ecuacion son:</h1>");
       out.println("<h2> X1 = " + raiz[0]+"</h2>");
       out.println("<h2> X2 = " + raiz[1]+"</h2>");
       out.println("</body>");
       out.println("</html>");
    }
}
