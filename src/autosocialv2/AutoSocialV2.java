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
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Random;
import org.json.JSONObject;
import util.Auto;
import util.FbInteraction;
import util.File;
import static util.File.getFinalLineNumber;
import static util.File.getLineFromFile;
import static util.GlobalVars.CAPTION;
import static util.GlobalVars.COMMENT;
import static util.GlobalVars.SERVER_ADDRESS;
import static util.GlobalVars.SERVER_PARAM_PORT;
import static util.GlobalVars.SERVER_PORT;
import static util.GlobalVars.USERID;
import util.Image;

/**
 *
 * @author Administrator
 */
public class AutoSocialV2 {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException, UnsupportedFlavorException, Exception, ConnectException {
        //load image
        new Image().loadImage();
        //auto util
        Auto a = new Auto();
        //interact util
        FbInteraction fbi = new FbInteraction();
        AutoItX x = a.create();
        int count = 1;
        String target = "";
        String url = "";
        Boolean skip = false;
//        interactLoop=20
        int phpbd, paccFR, psgg, pshop, pliveVideo, pgame, pchangeCover, paddFriend, interactLoop, phandleInbox, pcheckNotification, pstatus, tlike, tshare, tcmt, nflike, nfshare, nfcmt, ppostlinkorimage, psellordiscussion;
        while (true) {
            String live = "";
            for (int i = 1; i < 11; i++) {
                //read url from server
                Socket s = new Socket(SERVER_ADDRESS, SERVER_PORT);
                BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String answer = input.readLine();
                System.out.println(answer);//answer: skip:boolen;update:boolean;link:string;url:string
                JSONObject jsonObj = new JSONObject(answer);
                skip = jsonObj.getBoolean("skip");
                url = jsonObj.getString("url");
                target = jsonObj.getString("target");
//                String cmtanswer = jsonObj.getString("cmt");//##################
//                String captionanswer = jsonObj.getString("cmt");//##################
                String cmt = getLineFromFile(COMMENT, random(1, 788));
                String caption = getLineFromFile(CAPTION, random(1, getFinalLineNumber(CAPTION)));
//                if (cmtanswer.length()> 5){//###############
//                    cmt = cmtanswer;//################
//                }//#######################
//                if (captionanswer.length() > 5) {//###############
//                    cmt = cmtanswer;//################
//                }//#######################
                //init default params
                phpbd = 5;
                paccFR = 3;
                psgg = 3;
                pshop = 4;
                pliveVideo = 5;
                pgame = 6;
                pchangeCover = 50;
                paddFriend = 7;
                interactLoop = 20;
                phandleInbox = 3;
                pcheckNotification = 3;
                pstatus = 50;
                tlike = 10;
                tshare = 20;
                tcmt = 1;
                nflike = 20;
                nfshare = 1000;
                nfcmt = 50;
                ppostlinkorimage = 2;
                psellordiscussion = 2;
                //read params from server
                Socket ps = new Socket(SERVER_ADDRESS, SERVER_PARAM_PORT);
                BufferedReader pinput = new BufferedReader(new InputStreamReader(ps.getInputStream()));
                String panswer = pinput.readLine();
                System.out.println(panswer);

                if (panswer.length() > 20) {
                    String[] result = panswer.split("-");
                    phpbd = Integer.valueOf(result[0]);
                    paccFR = Integer.valueOf(result[1]);
                    psgg = Integer.valueOf(result[2]);
                    pshop = Integer.valueOf(result[3]);
                    pliveVideo = Integer.valueOf(result[4]);
                    pgame = Integer.valueOf(result[5]);
                    pchangeCover = Integer.valueOf(result[6]);
                    paddFriend = Integer.valueOf(result[7]);
                    interactLoop = Integer.valueOf(result[8]);
                    phandleInbox = Integer.valueOf(result[9]);
                    pcheckNotification = Integer.valueOf(result[10]);
                    pstatus = Integer.valueOf(result[11]);
                    tlike = Integer.valueOf(result[12]);
                    tshare = Integer.valueOf(result[13]);
                    tcmt = Integer.valueOf(result[14]);
                    nflike = Integer.valueOf(result[15]);
                    nfshare = Integer.valueOf(result[16]);
                    nfcmt = Integer.valueOf(result[17]);
//                    psellordiscussion = Integer.valueOf(result[X]);//##############
//                    ppostlinkorimage = Integer.valueOf(result[X]);//##############
                }

                if (skip) {
                    live += "-";
                    System.out.println("skip on profile: " + i);
                    Thread.sleep(random(30000, 90000));
                } else {
                    a.runBrowser(x, i);
                    //wait browser to open, if not skip it
                    if (!a.waitChromeLoaded()) {
                        live += "c";
                        System.out.println("continue on profile: " + i);
                        Runtime.getRuntime().exec("taskkill /F /IM browser.exe");
                        continue;
                    }
                    //must doing
                    a.turnOffNotification(x);
                    if (fbi.handleSpamWarning(x)) {
                        live += "x";
                        System.out.println("break on profile: " + i);
                        break;
                    };
                    if (fbi.checkLive(x)) {
                        live += "1";
                        System.out.println("profile live: " + i);

                        int hpbd = random(1, phpbd);
                        if (hpbd == 1) {
                            fbi.happyBirthday(x);
                            fbi.closePin(x);
                        }
                        int accFR = random(1, paccFR);
                        if (accFR == 1) {
                            fbi.acceptFriend(x);
                            fbi.closePin(x);
                        }
                        int sgg = random(1, psgg);
                        if (sgg == 1) {
                            x.send("{CTRLDOWN}t{CTRLUP}!n", false);
                            x.sleep(random(1000, 2000));
                            fbi.searchGG(x);
                            x.sleep(random(1000, 2000));
                        }
                        int shop = random(1, pshop);
                        if (shop == 1) {
                            fbi.shopping(x);
                            fbi.closePin(x);
                        }
                        int liveVideo = random(1, pliveVideo);
                        if (liveVideo == 1) {
                            fbi.liveVideo(x);
                            fbi.closePin(x);
                        }
                        int game = random(1, pgame);
                        if (game == 4) {
                            fbi.game(x);
                            fbi.closePin(x);
                        }
                        int changeCover = random(1, pchangeCover);
                        if (changeCover == 1) {
                            fbi.changeCover(x);
                            fbi.closePin(x);
                        }
                        fbi.activity(x);
                        fbi.closePin(x);
                        //my algorithm
                        fbi.interactNewsfeed(x, interactLoop, nflike, nfshare, nfcmt);
                        fbi.closePin(x);
                        int addFriend = random(1, paddFriend);
                        if (addFriend == 5) {
                            fbi.addFriend(x);
                            fbi.closePin(x);
                        }
                        int checkNotification = random(1, pcheckNotification);
                        if (checkNotification == 2) {
                            fbi.checkNotification(x);
                            fbi.closePin(x);
                        }
                        int handleInbox = random(1, phandleInbox);
                        if (handleInbox == 2) {
                            fbi.handleInbox(x);
                            fbi.closePin(x);
                        }
//                    int interactTarget = random(1, 10);
                        if (target.length() > 10) {
                            fbi.interactTarget(x, target, cmt, tlike, tshare, tcmt);
                            fbi.closePin(x);
                        }
//                    int inboxTarget = random(2, 5);
//                    if (inboxTarget == 4) {
//                        fbi.inboxTarget(x);
//                        fbi.closePin(x);
//                    }

                        int status = random(1, pstatus);
                        if (status == 1) {
                            fbi.postOnHome(x);
                            fbi.closePin(x);
                        }
//                    int postOnGroup = random(1, 2);
                        if (url.length() > 10) {
                            String geturl = fbi.postOnGroupDesk(x, url, caption, ppostlinkorimage, psellordiscussion);
                            sendGetUrlToServer(i, geturl);
                            fbi.closePin(x);
                        }
                        a.closeBrowser(x);
                        fbi.closePin(x);
                        x.sleep(3000);
                        Thread.sleep(3000);
                    } else {
                        System.out.println("profile dead: " + i);
                        live += "0";
                        Thread.sleep(random(300000, 600000));
                        int sgg = random(1, psgg);
                        if (sgg == 1) {
                            x.send("{CTRLDOWN}t{CTRLUP}!n", false);
                            x.sleep(random(1000, 2000));
                            fbi.searchGG(x);
                            x.sleep(random(1000, 2000));
                        }
                        a.closeBrowser(x);
                        fbi.closePin(x);
                    }
                }//
            }
            sendLiveReportToServer(live);
            count++;
            System.out.println(count);
        }

    }

    public static void sendGetUrlToServer(int profileNum, String geturl) throws MalformedURLException, IOException {
        String url = "http://" + SERVER_ADDRESS + "/geturl?geturl=" + geturl + "&profileNum=" + profileNum;
//        String url = "http://localhost:8080/live?live=" + info;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Setting basic post request  
        con.setRequestMethod("POST");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
    }

    private static void sendLiveReportToServer(String info) throws Exception {

        String url = "http://" + SERVER_ADDRESS + "/live?live=" + info;
//        String url = "http://localhost:8080/live?live=" + info;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Setting basic post request  
        con.setRequestMethod("POST");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
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
