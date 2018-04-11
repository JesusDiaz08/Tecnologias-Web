package administrador;

public class Cramer {

    private float A1, B1, S1;
    private float A2, B2, S2;

    public Cramer() {
    }

    public String[] useCramer(float A1, float B1, float S1,
                              float A2, float B2, float S2) {

        String[] unknowns = new String[2];
        float X = 0, Y = 0, det_S, det_X, det_Y;
        /*Unkowns*/

        det_S = ((A1 * B2) - (A2 * B1));

        if (det_S != 0) {
            det_X = ((B1 * S2) - (B2 * S1));
            det_Y = ((A1 * S2) - (A2 * S1));

            X = (det_X / det_S);
            Y = (det_Y / det_S);

            unknowns[0] = Float.toString(X);
            unknowns[1] = Float.toString(Y);
        } else {
            unknowns[0] = "Hay una";
            unknowns[1] = "incongruencia";
        }
        return unknowns;
    }

    public float getA1() {
        return A1;
    }

    public void setA1(float A1) {
        this.A1 = A1;
    }

    public float getB1() {
        return B1;
    }

    public void setB1(float B1) {
        this.B1 = B1;
    }

    public float getS1() {
        return S1;
    }

    public void setS1(float S1) {
        this.S1 = S1;
    }

    public float getA2() {
        return A2;
    }

    public void setA2(float A2) {
        this.A2 = A2;
    }

    public float getB2() {
        return B2;
    }

    public void setB2(float B2) {
        this.B2 = B2;
    }

    public float getS2() {
        return S2;
    }

    public void setS2(float S2) {
        this.S2 = S2;
    }
}