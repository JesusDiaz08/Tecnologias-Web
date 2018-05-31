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
        PrintWriter out = response.getWriter();
        String type = ((String)session.getAttribute("atributo_tipoL")).toUpperCase();
        int numero = Integer.parseInt((String)session.getAttribute("atributo_num"));
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet01</title>");
        out.println("</head>");
        if(type.equals("ORDENADA")){
            out.println("<h1> Lista Ordenada </h1>");
            out.println("<ol>");
                for (int i = 0; i < numero; i++) {
                    out.println("<li>");
                    out.println("<a href='"+request.getParameter("refer"+i)+"' >"+
                            request.getParameter("texto"+i)+"</a>");
                    out.println("</li>");
                }
            out.println("</ol>");
        }else if(type.equals("DESORDENADA")){
            out.println("<h1> Lista Desordenada </h1>");
            out.println("<ul>");
                for (int i = 0; i < numero; i++) {
                    out.println("<li>");
                    out.println("<a href='"+request.getParameter("refer"+i)+"' >"+
                            request.getParameter("texto"+i)+"</a>");
                    out.println("</li>");
                }
            out.println("</ul>");
        }
        out.println("</html>");
        
        
        out.println("<body>");
        out.println("<h1>Hello World</h1>");
        out.println("</body>");
    }
}
