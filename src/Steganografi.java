import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.*;

/**
 * This is a class
 * Created 2021-09-17
 *
 * @author Magnus Silverdal
 */
public class Steganografi {

    public String part1() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("turing_corrupt.png");
            outputStream = new FileOutputStream("turing_correct.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream dataInputStr = new DataInputStream(inputStream);
        //DataOutputStream dataOutpuStr = new DataOutputStream(outputStream);

        int count = 0;
        try {
            count = inputStream.available();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] b = new byte[count];
        int bytes = 0;
        try {
            bytes = dataInputStr.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0 ; i < bytes -4 ; i++) {
            if (b[i] == 0x1) {
                if (b[i+1] == 0x2 && b[i+2] == 0x3 && b[i+3] == 0x4) {
                    System.out.println(b[i] + "," + b[i + 1] + "," + b[i + 2] + "," + b[i + 3]);
                    i+=3;
                    continue;
                }
            }


                try {
                    outputStream.write(b[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        try {
            outputStream.write(b[b.length-4]);
            outputStream.write(b[b.length-3]);
            outputStream.write(b[b.length-2]);
            outputStream.write(b[b.length-1]);


            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String part2() {
        BufferedImage image = null;
        try {
            image = ImageIO.read((new File("turing_correct.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage imageCopy = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = imageCopy.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        int[] pixels = ((DataBufferInt) imageCopy.getRaster().getDataBuffer()).getData();

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("solution.wav");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //DataOutputStream dataOutputStr = new DataOutputStream(outputStream);

        for (int i = 0 ; i < pixels.length ; i+=2) {
        //for (int i = 0 ; i < 8 ; i+=2) {

            //int i = 0;
            byte b = 0;
            int msb = pixels[i];
            int lsb = pixels[i+1];
            //System.out.println(Integer.toBinaryString(msb));
            //System.out.println(Integer.toBinaryString(lsb));
            b += (msb&16777216)>>>20;
            b += (msb&65536)>>>11;
            b += (msb&256)>>>2;
            b += (msb&1)<<7;
            //System.out.print(Integer.toBinaryString(Byte.toUnsignedInt(b)) + " : ");

            b += (lsb&16777216)>>>21;
            b += (lsb&65536)>>>16;
            b += (lsb&256)>>>6;
            b += (lsb&1)<<1;
            /*b += (msb&16777216)>>>17;
            b += (msb&65536)>>>10;
            b += (msb&256)>>>3;
            b += (msb&1)<<4;
            b += (lsb&16777216)>>>21;
            b += (lsb&65536)>>>14;
            b += (lsb&256)>>>7;
            b += (lsb&1);*/
            //System.out.println(Integer.toBinaryString(Byte.toUnsignedInt(b)));
            try {
                outputStream.write(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(Integer.toBinaryString(Byte.toUnsignedInt(b)));
        }
        try {
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        Steganografi s = new Steganografi();
        //System.out.println(Integer.toBinaryString(-11909820));
        //System.out.println(Integer.toBinaryString(-28160947));
        //System.out.println(Integer.toBinaryString(-95));
        //s.part1();
        s.part2();
    }



}
