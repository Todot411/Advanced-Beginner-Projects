import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadPhoto {

    public static String BRIGHTNESS_STRING = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";


    public static int[][][] to2DArrayUsingGetRGB(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        int[][][] finalArray = new int[height][width][3];
        for(int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color myPixel = new Color(image.getRGB(col, row));
                finalArray[row][col][0] = myPixel.getRed();
                finalArray[row][col][1] = myPixel.getGreen();
                finalArray[row][col][2] = myPixel.getBlue();
            }
        }
        return finalArray;
    }

    public static String inPlaceReverse(String input) {
        StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString();
    }

    public static int[][] getPixelBrightness(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        int[][] finalArray = new int[height][width];
        for(int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color myPixel = new Color(image.getRGB(col, row));
                finalArray[row][col] = (myPixel.getRed() + myPixel.getBlue() + myPixel.getGreen())/3;
            }
        }
        return finalArray;
    }

    public static void main(String[] args) throws IOException {
        //ImageInfo trial = new ImageInfo("C:\\Users\\dorot\\Documents\\AdvancedBeginners\\ASCIIArt\\src\\main\\resources\\JavaImage.jpg");
//        System.out.println("Successfully loaded image!");
//        System.out.println("Image size: " + trial.getSize());
        //System.out.println(src.g);

        BufferedImage trial = ImageIO.read(new File("C:\\Users\\dorot\\Documents\\AdvancedBeginners\\ASCIIArt\\src\\main\\resources\\Java2.jpg"));
        System.out.println("Successfully loaded image!");
        System.out.println("Image size: " + trial.getWidth() + " x " + trial.getHeight());
        System.out.println("Successfully created brightness array!");
        System.out.println("Iterating through array: ");

        for(int row = 0; row < trial.getHeight(); row++) {
            System.out.println(" ");
            for (int col = 0; col < trial.getWidth(); col++) {
//                System.out.println(to2DArrayUsingGetRGB(trial)[row][col][0]);
                System.out.print(StringUtils.repeat(inPlaceReverse(BRIGHTNESS_STRING).charAt((int) Math.round(getPixelBrightness(trial)[row][col]*70/255.0)),2));
            }
        }


    }

}
