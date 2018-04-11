package administrador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
           response.setContentType("text/html;charset=UTF-8");
           String cadena = request.getRealPath("\\WEB-INF\\classes\\administrador");//Da la ruta donde se encuentra el recurso virtual
           //recibe una trayectoria de una carpeta virtual
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Get Real Path</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>HELLO WORLD: "+cadena+"</h1>");
            File archivo = new File(cadena+"\\archivo.txt");
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));//Permite escribir un texrto en OutputStream, utilizando un buffer para proporcionar una escritura eficiente en caracteres, arrays y strings.
            bw.write("Recurso creado correctamente.");
            bw.close();
            out.println("</body>");
            out.println("</html>");  
        
    }
}