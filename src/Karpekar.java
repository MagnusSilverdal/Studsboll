import java.util.Arrays;

/**
 * This is a class
 * Created 2021-09-16
 *
 * @author Magnus Silverdal
 */
public class Karpekar {
    public static void main(String[] args) {
        System.out.println(karpekar(1917) + "" + karpekar(7430) + "" + karpekar(8833) + "" + karpekar(9998));
    }

    private static int karpekar(int number) {
        int n = 2;
        while (number != 6174) {
            int[] digits = new int[4];
            digits[0] = number / 1000;
            number %=1000;
            digits[1] = number / 100;
            number %=100;
            digits[2] = number / 10;
            number %=10;
            digits[3] = number;
            Arrays.sort(digits);
            int max = digits[3]*1000+digits[2]*100+digits[1]*10+digits[0];
            int min = digits[0]*1000+digits[1]*100+digits[2]*10+digits[3];
            number = max-min;
            n++;
        }
        return n;
    }
}
