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
        
        String dimension = request.getParameter("clave_dimension");
        
        /*Recuperamos los valores a mostrar.*/
        String filas = (String)session.getAttribute("atributo_filas");
        String columnas = (String) session.getAttribute("atributo_columnas");
        
        /*Obtenemos sus valores enteros de filas y columnas*/
        int filas_i = Integer.parseInt(filas);
        int columnas_i = Integer.parseInt(columnas);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1'>");
        for (int i = 0; i < filas_i; i++) {
            out.println("<tr>");
            for (int j = 0; j < columnas_i; j++) {
                out.println("<td>");
                out.println("<a href='"+request.getParameter("link"+i+""+j)+"'>");
                out.println("<image src='"+request.getParameter("imagen"+i+""+j)+"'>");
                out.println("</a>"); 
                out.println("</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
