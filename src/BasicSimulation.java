/**
 * This is a class
 * Created 2021-09-02
 *
 * @author Magnus Silverdal
 */
public class BasicSimulation {
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
            v = updateSpeed(deltaT, a, v, y, e);
            y = updatePosition(deltaT, v, y);
        }
    }

    private static double updatePosition(double deltaT, double v, double s) {
        s += v*deltaT;
        return s;
    }

    private static double updateSpeed(double deltaT, double a, double v, double y, double e) {
        if (isBouncing(y)) {
            v = bounce(v,e);
        } else {
            v += a * deltaT;
        }
        return v;
    }

    private static double bounce(double v, double e) {
        return -v;
    }

    private static boolean isBouncing(double y) {
        if (y < 0) {
            return true;
        }
        return false;
    }
}
