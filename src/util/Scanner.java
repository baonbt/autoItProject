/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Position;
import static util.GlobalVars.KEY_IMAGE_FOLDER;

/**
 *
 * @author Administrator
 */
public class Scanner {

    //scan image base on y axe
    public int scanImageOnScreen(int x, int w, int h, BufferedImage key) throws AWTException, IOException {
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

    //scan image in all screen
    public Position scanImageOnAllScreen(BufferedImage key, int w, int h) throws AWTException, InterruptedException, IOException {
        Thread.sleep(1000);
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
//        ImageIO.write(capture, "png", new java.io.File(KEY_IMAGE_FOLDER + "screen.png"));
        BufferedImage result = null;
        for (int i = 0; i < 1364 - w; i++) {
            for (int j = 0; j < 768 - h; j++) {
                result = capture.getSubimage(i, j, w, h);
                if (new Image().bufferedImagesEqual(result, key)) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }
}
