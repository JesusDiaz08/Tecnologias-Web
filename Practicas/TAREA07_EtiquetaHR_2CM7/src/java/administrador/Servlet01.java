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
        String prf1 = request.getParameter("clave_pf1");
        String prf2 = request.getParameter("clave_pf2");
        int num_hr = Integer.parseInt(request.getParameter("clave_num"));
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet01 Etiqueta HR </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>"+prf1+"</p>");
        for (int i = 0; i < num_hr; i++) 
            out.println("<hr>");
        out.println("<p>"+prf2+"</p>");
        out.println("</body>");
        out.println("</html>");
    }
}