/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Administrator
 */
public class File {

    public static String getLineFromFile(String path, int num) throws IOException {
        String line = Files.readAllLines(Paths.get(path)).get(num - 1);
        return line;
    }

    public static int getFinalLineNumber(String path) throws IOException {
        return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8).size();
    }

    public void writeToFile(String input, String filePath) {
        try {
            java.io.File file = new java.io.File(filePath);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            //write to file allow append new line
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(input + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
