/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class TestRunAutoITCommand {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec(new String[]{"D:\\20161\\hot site\\autoit_script\\test.exe"});
    }
}
