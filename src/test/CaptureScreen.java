/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class CaptureScreen {

    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        BufferedImage buffer = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\co.png"));
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        Thread.sleep(3000);
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        BufferedImage result;
        for (int i = 0; i < 748; i++) {
            result = capture.getSubimage(264, i, 60, 20);
            if (bufferedImagesEqual(result, buffer)) {
                System.out.println(i);
                break;
            }
        }
        //ImageIO.write(result, "png", new File("C:\\Users\\Administrator\\Desktop\\co.png"));
    }

    static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
