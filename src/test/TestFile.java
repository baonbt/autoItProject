/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.Random;
import util.FbInteraction;

/**
 *
 * @author Administrator
 */
public class TestFile {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            System.out.println(random(1, 5));
        }
    }

    public static int random(int from, int to) {
        if (from == to) {
            return from;
        } else {
            from = from - 1;
            Random rand = new Random();
            int n = rand.nextInt(to - from) + 1;
            return from + n;
        }
    }
}
