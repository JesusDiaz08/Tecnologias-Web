package admin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class ServletDomPath extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getRealPath("/");
        try {
            Element root = new Element("root");
            Element hoja = new Element("hoja");
            
            hoja.setAttribute("numerodehojas","4");
            hoja.setText("VALORNODO");
            root.addContent(hoja);
            
            Document newDoc = new Document(root);
            XMLOutputter fmt = new XMLOutputter();
            FileWriter writer = new FileWriter(path);
            
            fmt.output(newDoc, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("There was an error");
            System.err.println(e.getMessage());
        }
    }
}
