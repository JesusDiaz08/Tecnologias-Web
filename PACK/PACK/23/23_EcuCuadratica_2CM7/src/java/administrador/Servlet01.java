package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EcuacionGral ecu = new EcuacionGral();
        response.setContentType("text/html;charset=UTF-8");
        
        /*ES LA CLAVE-VALOR*/
        String a = request.getParameter("clave_a");
        String b = request.getParameter("clave_b");
        String c = request.getParameter("clave_c");

        ecu.setA(Float.parseFloat(a));
        ecu.setB(Float.parseFloat(b));
        ecu.setC(Float.parseFloat(c));
        
        String[] raiz = ecu.solve(ecu.getA(), ecu.getB(), ecu.getC());
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SERVLET TAREA_01: ECUACION GENERAL </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Las raices de la ecuacion son: </h1>");
        out.println("</br>");
        out.println("<h1> X1 = "+raiz[0]+" </h1>");
        out.println("</br>");
        out.println("<h1> X2 = "+raiz[1]+" </h1>");
        out.println("</body>");
        out.println("</html>");
    }    
}
