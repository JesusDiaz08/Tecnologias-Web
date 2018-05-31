package paquete;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import java.io.IOException;
import java.io.PrintWriter;

public class JDOMVALIDADOR {
    
    PrintWriter out;
    // Método que comprueba la conformidad con XML
    public void checkConforme(String sURL)
            throws JDOMException, IOException {
        //Simple API XML
        SAXBuilder builder = new SAXBuilder();
        builder.build(sURL);
    }
    
    // Método que comprueba la validez con el DTD
    public void checkValido(String sURL)
            throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        builder.setValidation(true);
        builder.build(sURL);
    }

    public void realmain(String args[], PrintWriter out) {
        String str = "";
        this.out = out;
        out.println("<!DOCTYPE>");
        out.println("<html>");
        out.println("<head></head><body>");
        
        
        if (args.length == 0) {
            System.out.println("Utilizacion: java JDOMValidador URL");
            
        } else {
            JDOMVALIDADOR validador = new JDOMVALIDADOR(); // El propio validador
            try {
                try {
                // Documento conformado??
                    validador.checkConforme(args[0]);
                } // Indicacion de un fichero mal formado
                catch (JDOMException e) {
                    str = args[0] + " No es bien formado";
                    out.println(str);
                    System.out.println(args[0] + " No es bien formado");
                    System.out.println(e.getMessage());
                    out.println(e.getMessage());
                    System.exit(0);
                }
                // Si el fichero esta bien formado no saltará ninguna excepcion
                System.out.println(args[0] + " Bien formado");
                str = args[0] + " Bien formado";
                out.println(str);
                try {
                // Documento Válido??
                    validador.checkValido(args[0]);
                } // Indicacion de un fichero no válido
                catch (JDOMException e) {
                    System.out.println(args[0] + " NO valido");
                    str = args[0] + " NO valido";
                    out.println(str);
                    System.out.println(e.getMessage());
                    out.println(e.getMessage());
                    System.exit(0);
                }
                // Si el fichero es válido no saltará ninguna excepcion
                System.out.println(args[0] + " Es valido");
                str = args[0] + " Es valido";
                out.println(str);
            } // Indicación de que el fichero no es accesible
            catch (IOException e) {
                System.out.println("No se puede chequear " + args[0]);
                str = "No se puede chequear " + args[0];
                out.println(str);
                System.out.println("Excepcion: " + e.getMessage());
                str = "Excepcion: " + e.getMessage();
                out.println(str);
            }
        }
        out.println("</body>");
        out.println("</html>");
    }
}
