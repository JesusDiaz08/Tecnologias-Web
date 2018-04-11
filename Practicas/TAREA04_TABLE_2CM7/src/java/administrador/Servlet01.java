package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        String tabla = request.getParameter("clave_tabla");
        
        /*-- Obtiene filas y columnas en formato: nxm*/
        StringTokenizer f_c = new StringTokenizer(tabla, "x");
        String fila = f_c.nextToken();
        String columna = f_c.nextToken();
        /*Obtenemos valores filas y columnas en numero entero*/
        int fila_i = Integer.parseInt(fila);
        int columna_i = Integer.parseInt(columna);
        /*------------------------------------------*/
               
        session.setAttribute("atributo_filas", fila);
        session.setAttribute("atributo_columnas", columna);
                
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Table</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='Servlet02' method='GET' />");
        for (int i = 0; i < fila_i; i++) {
            for (int j = 0; j < columna_i; j++) {
                out.println("Valor ["+(i+1)+","+(j+1)+"]: <input type='text' name='clave"+i+j+"' />");
            }
            out.println("</br>");
        }
        out.println("<input type='submit' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
