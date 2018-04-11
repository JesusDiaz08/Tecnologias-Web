package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String txt1 = request.getParameter("clave_txt1");
        String txt2 = request.getParameter("clave_txt2");
        int num_br = Integer.parseInt(request.getParameter("clave_num"));
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Etiqueta BR</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>"+txt1+"</p>");
        for (int i = 0; i < num_br; i++) 
            out.println("</br>");
        out.println("<p>"+txt2+"</p>");
        out.println("</body>");
        out.println("</html>");
    }
}