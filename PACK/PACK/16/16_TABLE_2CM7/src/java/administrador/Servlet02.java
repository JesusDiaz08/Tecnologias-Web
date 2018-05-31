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
        
        String filas_columnas = request.getParameter("clave_tabla");
        
        /*Obtenemos los valores de las filas y columnas ingresados*/
        String filas = (String) session.getAttribute("atributo_filas");
        String columnas = (String) session.getAttribute("atributo_columnas");
        /*--------------------------------------------------------*/
        
        /*Declaramos sus correspondientes valores enteros de filas y columnas*/
        int filas_i = Integer.parseInt(filas);
        int columnas_i = Integer.parseInt(columnas);
        /*-------------------------------------------------------------------*/
        
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Table created</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1'>");
        for (int i = 0; i < filas_i; i++) {
            out.println("<tr>");
            for (int j = 0; j < columnas_i; j++) {
                out.println("<td>"+request.getParameter("clave"+i+""+j)+"</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
