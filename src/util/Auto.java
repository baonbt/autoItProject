/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class Auto {

    Image image = new Image();

    public Auto() throws IOException {
        image.loadImage();
    }

    public AutoItX create() {
        File file = new File("lib", "jacob-1.18-x64.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
        return new AutoItX();
    }

    public int runBrowser(AutoItX x, int profileNum) {
        int processId = x.run(GlobalVars.COCCOC_FOLDER + " --start-maximized " + GlobalVars.FACEBOOK_HOMPAGE + " --profile-directory=\"Profile " + profileNum + '"');
        return processId;
    }

    public void maximizeBrowserWindow(AutoItX x) {

    }

    public void turnOffNotification(AutoItX x) {
        x.mouseClick("left", 360, 45, 1, 10);
        x.sleep(500);
    }

    public boolean checkImageLoaded(BufferedImage image, int w, int h) throws AWTException, IOException, InterruptedException {
        if (new Scanner().scanImageOnAllScreen(image, w, h) != null) {
            return true;
        }
        return false;
    }

    public boolean chromeWindowLoaded() throws AWTException, IOException, InterruptedException {
        if (checkImageLoaded(image.FB, 15, 15)) {
            return true;
        }
        return false;
    }

    public boolean waitChromeLoaded() throws AWTException, InterruptedException, IOException {
        int loops = 0;
        while (!chromeWindowLoaded()) {
            Thread.sleep(1000);
            loops++;
            if (loops > 20) {
                return false;
            }
        }
        return true;
    }

    public void closeBrowser(AutoItX x) {
        x.mouseMove(1338, 7, 20);
        x.sleep(1000);
        x.mouseClick("left", 1338, 7, 1, 10);
    }
}
