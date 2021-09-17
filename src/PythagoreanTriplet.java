/**
 * This is a class
 * Created 2021-09-16
 *
 * @author Magnus Silverdal
 */
public class PythagoreanTriplet {
    public static void main(String[] args) {
        for (int a = 1 ; a < 950 ; a++) {
            for (int b = a ; b < 950 ; b++) {
                for (int c = b ; b < 950 ; c++) {
                    if (a+b+c > 950) {
                        break;
                    }
                    if (a*a+b*b==c*c && a+b+c==950) {
                        System.out.println(a*b*c);
                        return;
                    }
                }
            }
        }
    }
}
