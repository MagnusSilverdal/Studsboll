/**
 * This is a class
 * Created 2021-09-09
 *
 * @author Magnus Silverdal
 */
public class BasicSimulationPlain {

    //public static double deltaT = 0.1;
    public static void main(String[] args) {
        double deltaT = 0.1;
        double a = -9.82;
        double v = 0;
        double y = 10;
        double x = 10;
        double t = 0;
        double e = 0.9;

        for (int i = 0 ; i < 100 ; i++ ) {
            System.out.println(t + " ; " + y);
            t += deltaT;
            if (y<0) {
                v = -v;
            } else {
                v = updateVel(deltaT, a, v);
            }
            y = updatePos(deltaT, v, y);
        }
    }

    private static double updatePos(double deltaT, double v, double y) {
        y += v*deltaT;
        return y;
    }

    private static double updateVel(double deltaT, double a, double v) {
        v += a * deltaT;
        return v;
    }
}
