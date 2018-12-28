/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import autoitx4java.AutoItX;
import java.awt.AWTException;
import java.io.IOException;
import util.Auto;
import util.FbInteraction;

/**
 *
 * @author Administrator
 */
public class TestAuto {
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
//        Auto a = new Auto();
//        AutoItX x = a.create();
//        x.mouseMove(800, 400); 
//        x.mouseWheel("down", 4);         
//        System.out.println("dkm");
        Thread.sleep(3000);
        FbInteraction f = new FbInteraction();
        Auto a = new Auto();
        AutoItX x = a.create();
        f.clickLikeHuman(x, 100, 700);
    }
}
