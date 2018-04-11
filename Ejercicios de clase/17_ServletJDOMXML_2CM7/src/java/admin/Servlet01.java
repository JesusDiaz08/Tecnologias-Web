package admin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.output.XMLOutputter;
import org.jdom.*;
/*@author kaimorts*/

public class Servlet01 extends HttpServlet {
    
    public final String ROOT = "ROOT";
    public final String HOJA = "HOJA";
    public final String PATH_XML = "C:\\pregunta.xml";
    
    @Override
        protected void doGet(HttpServletRequest request,HttpServletResponse response) 
            throws ServletException, IOException{
        /*Podemos poner o no el MIME.
        response.setContentType("text/html;charset=UTF-8");*/
        
        try{
            Element raiz = new Element(ROOT);
            Element hoja = new Element(HOJA);
            
            hoja.setAttribute("NumeroDeHojas", "4");
            hoja.setText("ValorDelNodo");
            
            raiz.addContent(hoja);
            
            Document new_doc = new Document(raiz);
            XMLOutputter fmt = new XMLOutputter();      
            FileWriter writer = new FileWriter(PATH_XML); /*Genera la carpeta C:\\XML\\pregunta.xml*/
            fmt.output(new_doc, writer);    /*Hace persistente al archivo y lo crea fisicamente*/
            writer.flush();                 /*Limpia caché*/
            writer.close();
            
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        
        
    }
}
