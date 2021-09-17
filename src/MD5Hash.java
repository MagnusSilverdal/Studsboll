import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This is a class
 * Created 2021-09-16
 *
 * @author Magnus Silverdal
 */
public class MD5Hash {
    public static void main(String[] args) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.print(e);
        }
        String salt = "AdaLovelace-";
        String key = "0CF2FCF4598769F395B7CC0528C09C0E";
        key = key.toLowerCase();
        for (char x0 = 'a' ; x0 <= 'z' ; x0++ ) {
            for (char x1 = 'a' ; x1 <= 'z' ; x1++ ) {
                for (char x2 = 'a' ; x2 <= 'z' ; x2++ ) {
                    for (char x3 = 'a' ; x3 <= 'z' ; x3++ ) {
                        for (char x4 = 'a' ; x4 <= 'z' ; x4++ ) {
                            String message = salt + x0+x1+x2+x3+x4;
                            //System.out.println(message);
                            byte[] byteData = MD5hash(message, md);
                            String keyString = convertHex(byteData);
                            if (keyString.equals(key)) {
                                System.out.println(x0+""+x1+""+x2+""+x3+""+x4);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static byte[] MD5hash(String input, MessageDigest md) {
        md.update(input.getBytes());
        return md.digest();
    }

    private static String convertHex(byte[] byteData) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
