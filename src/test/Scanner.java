/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import util.*;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static util.GlobalVars.KEY_IMAGE_FOLDER;

/**
 *
 * @author Administrator
 */
public class Scanner {
    
    static BufferedImage img;
    
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        img = ImageIO.read(new File(KEY_IMAGE_FOLDER + "\\right_now_desk.png"));
        new Scanner().scanImageOnAllScreen(40, 15, img);
//        System.out.println(new Scanner().scanImageOnScreen(267, 58, 13, img));
//        new Scanner().scanImageOnScreen(970, 15, 15, img);
    }

    public int scanImageOnScreen(int x, int w, int h, BufferedImage key) throws AWTException, IOException, InterruptedException {
        Thread.sleep(3000);
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        BufferedImage result = null;
        for (int i = 0; i < 768 - h; i++) {
            result = capture.getSubimage(x, i, w, h);
            if (new Image().bufferedImagesEqual(result, key)) {
                return i;
            }
        }
        return -1;
    }

    public void scanImageOnAllScreen(int w, int h, BufferedImage key) throws AWTException, InterruptedException, IOException {
        Thread.sleep(3000);
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        BufferedImage result = null;
        for (int i = 0; i < 1366 - w; i++) {
            for (int j = 0; j < 768 - h; j++) {
                result = capture.getSubimage(i, j, w, h);
                if (new Image().bufferedImagesEqual(result, key)) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}
