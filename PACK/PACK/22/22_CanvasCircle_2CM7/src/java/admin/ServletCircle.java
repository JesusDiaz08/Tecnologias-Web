package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCircle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String radio = request.getParameter("radio");
        int radio_n = Integer.parseInt(radio);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Circle</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<canvas id='lienzo' width='250' height='200'> </canvas>");
        out.println("<script>");
        out.println("	var lienzo = document.getElementById('lienzo');\n" +
"		if (lienzo && lienzo.getContext) {\n" +
"		var contexto = lienzo.getContext('2d');\n" +
"			if (contexto) {\n" +
"					var X = lienzo.width/2;\n" +
"					var Y = lienzo.height/2;\n" +
"					var r = "+radio_n+";\n" +
"					contexto.strokeStyle = '#006400';\n" +
"					contexto.fillStyle = '#6ab150';\n" +
"					contexto.lineWidth = 5;\n" +
"					contexto.arc(X,Y,r,0,2*Math.PI);\n" +
"					contexto.fill();\n" +
"					contexto.stroke();\n" +
"			}\n" +
"		}");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
}
