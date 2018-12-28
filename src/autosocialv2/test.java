/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autosocialv2;

import autoitx4java.AutoItX;
import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import util.Auto;
import util.FbInteraction;
import util.File;
import static util.GlobalVars.SERVER_ADDRESS;
import static util.GlobalVars.SERVER_PORT;
import static util.GlobalVars.USERID;
import util.Image;

/**
 *
 * @author Administrator
 */
public class test {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException, UnsupportedFlavorException, JSONException {
        //load image
//        new Image().loadImage();
        //auto util
        Auto a = new Auto();
        //interact util
        FbInteraction fbi = new FbInteraction();
        AutoItX x = a.create();
        Thread.sleep(1000);
//        fbi.testing(x);
//        System.out.println(fbi.postOnGroupDesk(x, "day-la-url", "day-la-caption", 2, 2));//ok con de
//        fbi.testing(x);

        /////////////////////////////
//        String yUrl = "https://www.youtube.com/watch?v=kffacxfA7G4";
//        fbi.shareYoutube(x, yUrl);
//Runtime.getRuntime().exec("taskkill /F /IM browser.exe");
////        ////////////////////////////////
//        Socket s = new Socket(SERVER_ADDRESS, SERVER_PORT);
//        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        String answer = input.readLine();
//        System.out.println(answer);//answer: skip:boolen;update:boolean;link:string;url:string
//        JSONObject jsonObj = new JSONObject(answer);
//        String cmtanswer = jsonObj.getString("cmt");
////                String cmt = getLineFromFile(COMMENT, random(1, 788));
//                if (cmtanswer.length()>5){
//                    System.out.println("1");
//                }
//        fbi.shareAPagePostToAGroup(x, "https://www.facebook.com/bbcnews/posts/10154057543387217");
//        String geturl = fbi.postOnGroupDesk(x, "abcxyzhaha");
//        fbi.sendGetUrlToServer(1, geturl);
//                JSONObject jsonObj = new JSONObject(answer);
////                Boolean skip = jsonObj.getBoolean("skip");
//                String target = jsonObj.getString("link");
////                String url = jsonObj.getString("url");
//                System.out.println(target);
        /////////////////////////////////
//        if (!fbi.checkLive(x)){
//            System.out.println("1");
//        }
//        fbi.testimg(x);
//        fbi.interactNewsfeed(x);//OK             1
//        fbi.postOnGroupDesk(x);//ok               1
//        fbi.interactTarget(x);//ok                1 
//        fbi.handleSpamWarning(x);//uncheck        1
//        fbi.inboxTarget(x);//ok                   1         
//        fbi.addFriend(x);//ok                   1
//        fbi.checkNotification(x);//ok             1
//        fbi.handleInbox(x);//ok                   1
//        fbi.happyBirthday(x);//ok                 1
//        fbi.acceptFriend(x);//ok                  1
//        fbi.shopping(x);//ok                      1
//        fbi.liveVideo(x);//ok                     1
//        fbi.game(x);//ok                          1
//        fbi.activity(x);//ok                      1
//        fbi.changeCover(x);//ok                   1
//        fbi.postOnHome(x);//ok                    1
//        fbi.searchGG(x);//ok                      1
//        fbi.closePin(x);    //                      1
////////////////////////////////////////
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
