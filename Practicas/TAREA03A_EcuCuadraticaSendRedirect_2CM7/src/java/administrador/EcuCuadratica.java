package administrador;
/** @author Kaimorts */

public class EcuCuadratica {
    private float a; /*Coeficiente numerico de x^2*/
    private float b; /*Coeficiente numerico de x*/
    private float c; /*Termino independiente*/
    
    public EcuCuadratica(float A, float B, float C){
        a = A;
        b = B;
        c = C;
    }
    
    public EcuCuadratica(){}
    
    public String[] solve(float a,float b,float c){
        
        String[] raices = new String[2];
        float X1=0,X2=0,insideSqrt;
        insideSqrt = (float) (Math.pow(b,2) - (4*a*c));
        
        if (insideSqrt>=0){  /*Raices dentro de los Reales*/
            X1 = (float) ( ( ((-1)*b) + Math.sqrt(insideSqrt) ) / (2*a) );
            X2 = (float) ( ( ((-1)*b) - Math.sqrt(insideSqrt) ) / (2*a) );
            raices[0] = Float.toString(X1);
            raices[1] = Float.toString(X2);
        }else{
            System.out.println("Raices dentro de los Complejos");
            float neg_b = ((-1)*b);
            raices[0] = "("+(float)neg_b + " + "+ (float)Math.sqrt(insideSqrt*(-1))+"i )"+"/"+(float)(2*a);
            raices[1] = "("+(float)neg_b + " - "+ (float)Math.sqrt(insideSqrt*(-1))+"i )"+"/"+(float)(2*a);
        }
        return raices;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
}