package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.StringTokenizer;

public class Servlet01 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String dim = request.getParameter("clave_dimension");
        StringTokenizer tokens=new StringTokenizer(dim, "x");
        String fila = tokens.nextToken();
        String columna = tokens.nextToken();
        session.setAttribute("atributo_filas",fila);
        session.setAttribute("atributo_columnas",columna);
        int fila_i = Integer.parseInt(fila);
        int columna_i = Integer.parseInt(columna);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Imagen-Link</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' method ='GET'>");
        for (int i = 0; i<fila_i; i++) {
          for (int j = 0; j<columna_i;j++ ) {
            out.println("Imgn"+i+","+j+":<input type ='text' name='imagen"+i+""+j+"' size='5'/>");
            out.println("Link"+i+","+j+":<input type ='text' name='link"+i+""+j+"' size='5'/>");
          }
          out.println("</br>");
        }
        out.println("<input type ='submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
