import org.apache.commons.lang3.StringUtils;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadPhoto {

    public static String BRIGHTNESS_STRING = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
    public static double BRIGHTNESS_STRING_MULTIPLIER = 70/255.0;

    public static String inPlaceReverse(String input) {
        StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString();
    }

    public static double[][] getPixelBrightness(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        double[][] finalArray = new double[height][width];
//        Raster rs = image.getRaster();
        for(int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color myPixel = new Color(image.getRGB(col, row));
                finalArray[row][col] = (myPixel.getRed() + myPixel.getBlue() + myPixel.getGreen())/3;
//                int[] pixel = new int[3];
//                rs.getPixel(row, col, pixel);
//                finalArray[row][col] = (pixel[0]+pixel[1]+pixel[2])/3.0;
            }
        }
        return finalArray;
    }

    public static BufferedImage rescaleImage(BufferedImage inputPhoto, int requiredWidth) {
        return Scalr.resize(inputPhoto, requiredWidth);
    }

    public static void main(String[] args) throws IOException {
        BufferedImage trial = ImageIO.read(new File("C:\\Users\\dorot\\Documents\\AdvancedBeginners\\ASCIIArt\\src\\main\\resources\\Java2.jpg"));
        BufferedImage resized = rescaleImage(trial, 300);
        for(int row = 0; row < resized.getHeight(); row++) {
            System.out.println(" ");
            for (int col = 0; col < resized.getWidth(); col++) {
                System.out.print(StringUtils.repeat(inPlaceReverse(BRIGHTNESS_STRING)
                        .charAt((int) Math.round(getPixelBrightness(resized)[row][col]*BRIGHTNESS_STRING_MULTIPLIER)),2));
            }
        }


    }

}
