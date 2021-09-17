/**
 * This is a class
 * Created 2021-09-16
 *
 * @author Magnus Silverdal
 */
public class fibonacci {
    public static void main(String[] args) {
        int x0 = 1;
        int x1 = 2;
        int limit =2000000;
        int sum = 2;
        while (x1 < limit) {
            int newX = x0+x1;
            x0 = x1;
            x1 = newX;
            if (newX%2 == 0) {
                sum += newX;
            }
        }
        System.out.println(sum);
    }

}
