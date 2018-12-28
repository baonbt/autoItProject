/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import autoitx4java.AutoItX;
//import com.jacob.com.LibraryLoader;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import model.Position;
import org.apache.commons.io.FileUtils;
import static util.File.getFinalLineNumber;
import static util.File.getLineFromFile;
import static util.GlobalVars.CAPTION;
import static util.GlobalVars.COMMENT;
import static util.GlobalVars.COVER_IMAGE_FOLDER;
import static util.GlobalVars.EMOTICON;
import static util.GlobalVars.FACEBOOK_HOMPAGE;
import static util.GlobalVars.FRIEND_TOBE_ADDED;
import static util.GlobalVars.GROUP_ID;
import static util.GlobalVars.HAPPY_BIRTHDAY_IMAGE_FOLDER;
import static util.GlobalVars.IMG_SELL;
import static util.GlobalVars.INBOX_TARGET;
import static util.GlobalVars.MESS;
import static util.GlobalVars.PHOTO_IMAGE_FOLDER;
import static util.GlobalVars.PRAISE;
//import static util.GlobalVars.POSTED_URL;
import static util.GlobalVars.QUOTES;
import static util.GlobalVars.SEARCH;
import static util.GlobalVars.SELL_POSITION;
import static util.GlobalVars.STATUS;
import static util.GlobalVars.TARGET;
import static util.GlobalVars.URL_TO_POST;
import static util.GlobalVars.WISH;

/**
 *
 * @author Administrator
 */
public class FbInteraction {

    Image image = new Image();

    public FbInteraction() throws IOException {
        image.loadImage();
    }

    public void shareAPagePostToAGroup(AutoItX x, String pageUrl) throws AWTException, InterruptedException, IOException, UnsupportedFlavorException {
//        waitChromeLoaded();
        String groupId = getLineFromFile(GROUP_ID, random(1, getFinalLineNumber(GROUP_ID)));
        while (groupId.length() < 5) {
            groupId = getLineFromFile(GROUP_ID, random(1, getFinalLineNumber(GROUP_ID)));
        }
        String caption = getLineFromFile(CAPTION, random(1, getFinalLineNumber(CAPTION)));
        String praise = getLineFromFile(PRAISE, random(1, getFinalLineNumber(PRAISE)));
        String emoticon = getLineFromFile(EMOTICON, random(1, getFinalLineNumber(EMOTICON)));
//        groupId = "YNCHDNEG";
        String link = "https://facebook.com/groups/" + groupId;
        gotoUrl(x, link);
        waitChromeLoaded();
        boolean joingroup = true;
        if (joingroup) {
            waitChromeLoaded();
            Position p = new Scanner().scanImageOnAllScreen(image.JOIN_GROUP, 40, 15);
            if (p != null) {
                click(x, p.getX() + random(20, 100), p.getY() + random(5, 15));
                x.sleep(random(1000, 2000));
            } else if (p == null) {
                joingroup = false;
            }
        }
        if (!joingroup) {
            Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
            if (fb_symbol != null) {
                click(x, fb_symbol.getX() + random(50, 100), fb_symbol.getY() + random(5, 15));
                x.sleep(random(1000, 2000));
                x.send("{CTRLDOWN}c{CTRLUP}!n", false);
                x.sleep(random(1000, 2000));
                String groupName = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                x.sleep(random(1000, 2000));
                gotoUrl(x, pageUrl);
                x.sleep(random(3000, 5000));
                for (int i = 1; i < 10; i++) {
                    Position share_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NF, 15, 15);
                    if (share_nf != null) {
                        break;
                    } else {
                        x.mouseWheel("down", random(1, 2));
                        x.sleep(random(1000, 2000));
                    }
                }
                Position share_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NF, 15, 15);
                if (share_nf != null) {
                    click(x, share_nf.getX() + random(1, 30), share_nf.getY() + random(1, 10));
                    x.sleep(random(1000, 3000));
                    Position share_with_nf = new Scanner().scanImageOnAllScreen(image.SHARE_WITH, 40, 15);
                    if (share_with_nf != null) {
                        click(x, share_with_nf.getX() + random(1, 30), share_with_nf.getY() + random(1, 10));
                        for (int sh = 1; sh < 5; sh++) {
                            x.mouseMove(random(399, 820), random(217, 380), random(10, 30));
                            Position share_CL = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                            if (share_CL == null) {
                                x.sleep(random(2000, 3000));
                            } else {
                                break;
                            }
                        }
                        Position write_sth = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                        if (write_sth != null) {
                            click(x, write_sth.getX() - 150 + random(1, 30), write_sth.getY() + 50 + random(1, 10));
                            x.sleep(random(1000, 2000));
                            String cmt = getLineFromFile(COMMENT, random(1, getFinalLineNumber(COMMENT)));
                            typeMessage(x, caption);
                            typeMessage(x, praise);
                            typeMessage(x, emoticon);
                            x.sleep(random(2000, 4000));
                            click(x, write_sth.getX() - 400 + random(1, 30), write_sth.getY() + random(2, 10));
                            Position share_yt_fb_group = new Scanner().scanImageOnAllScreen(image.SHARE_YT_GROUP, 15, 15);
                            if (share_yt_fb_group != null) {
                                click(x, share_yt_fb_group.getX() + 10 + random(1, 30), share_yt_fb_group.getY() + random(2, 10));
                                x.sleep(random(1000, 2000));
                                Position group_name = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                                if (group_name != null) {
                                    click(x, group_name.getX() - 346 + random(1, 30), group_name.getY() + 40 + random(1, 7));
                                    x.sleep(random(700, 1500));
                                    typeMessage(x, groupName);
                                    x.sleep(random(1000, 2000));
                                    click(x, group_name.getX() - 346 + random(1, 30), group_name.getY() + 85 + random(1, 7));
                                    x.sleep(random(700, 1500));
                                    if (checkImageLoaded(image.POST_HPBD, 20, 15)) {
                                        Position share_with_post_nf = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                                        if (share_with_post_nf != null) {
                                            click(x, share_with_post_nf.getX() + random(1, 30), share_with_post_nf.getY() + random(1, 10));
                                            x.sleep(random(1000, 3000));
                                            for (int sh = 1; sh < 5; sh++) {
                                                Position share_fb = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
                                                if (share_fb == null) {
                                                    x.sleep(random(2000, 3000));
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                    }//if post
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void interactNewsfeed(AutoItX x, int wl, int plike, int pshare, int pcmt) throws AWTException, InterruptedException, IOException {
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        } else {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
        x.sleep(random(1000, 2000));
        waitChromeLoaded();
        int loops = 0;
        int www = 0;
        for (int az = 1; az < wl; az++) {
            while (!checkImageLoaded(image.LIKE_NF, 15, 15)) {
                if (loops < 5) {
                    int up = random(1, 10);
                    if (up <= 2) {
                        x.mouseWheel("up", random(2, 5));
                    } else {
                        x.mouseWheel("down", random(6, 12));
                    }
                    x.sleep(random(2000, 4000));
                    loops++;
                    www++;
                } else {
                    x.send("{f5}!n", false);
                    x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
                    x.sleep(random(1000, 2000));
                    loops = 0;
                }
                if (www > 30) {
                    break;
                }
            }
            int likeornot = random(1, plike);
            int cmtornot = random(1, pcmt);
            int shareornot = random(1, pshare);
            int d = random(1, 6);
            Position like_nf = new Scanner().scanImageOnAllScreen(image.LIKE_NF, 15, 15);
            if (like_nf != null) {
                if (likeornot < 4) {
                    click(x, like_nf.getX() + random(1, 20), like_nf.getY() + random(1, 10));
                    x.sleep(random(1000, 2000));
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(1000, 2000));
                } else if (likeornot == 4) {
                    x.mouseMove(like_nf.getX() + random(1, 30), like_nf.getY() + random(1, 10), random(20, 50));
                    x.sleep(random(2000, 4000));
                    Position love_nf = new Scanner().scanImageOnAllScreen(image.LOVE_NF, 15, 15);
                    if (love_nf != null) {
                        switch (d) {
                            case 1:
                                click(x, love_nf.getX() + 0 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 2:
                                click(x, love_nf.getX() + 50 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 3:
                                click(x, love_nf.getX() + 100 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 4:
                                click(x, love_nf.getX() + 150 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 5:
                                click(x, love_nf.getX() + 200 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 6:
                                click(x, love_nf.getX() + 250 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                        }
                    }
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(1000, 3000));
                } else if (likeornot > 5) {
                    x.mouseWheel("down", random(4, 8));
                    x.sleep(random(2000, 4000));
                }
            }
            if (cmtornot == 20) {
                Position cmt_nf = new Scanner().scanImageOnAllScreen(image.CMT_NF, 15, 15);
                if (cmt_nf != null) {
                    click(x, cmt_nf.getX() + random(1, 30), cmt_nf.getY() + random(1, 10));
                    x.sleep(random(2000, 4000));
                    String cmt = getLineFromFile(COMMENT, random(1, getFinalLineNumber(COMMENT)));
                    typeMessage(x, cmt);
                    x.sleep(random(1000, 3000));
                    x.send("{enter}!n", false);
                    x.sleep(random(1000, 3000));
                    x.send("{enter}!n", false);
                    x.sleep(random(1000, 3000));
//                    int tagfr = random(1, 20);
//                    if (tagfr == 5) {
//                        x.send(" @");
//                        String tag = randomSimpleString(1);
//                        x.send(tag);//send char
//                        x.sleep(3000);
//                        x.send("{enter}!n", false);
//                        x.sleep(2000);
//                        x.send("{enter}!n", false);
//                        x.sleep(random(2000, 4000));
//                        click(x, random(1, 20), random(650, 700));//click cancel photo
//                        x.sleep(random(1000, 3000));
//                    }// TAG FRIEND
                    int cmtsticker = random(1, 10);
                    if (cmtsticker == 5) {
//                        x.send("{enter}!n", false);
//                        x.sleep(random(1000, 2000));
                        Position sticker_nf = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
                        if (sticker_nf != null) {
                            if (sticker_nf.getY() < 550) {
//                                x.mouseClick("left", 1354 + random(1, 6), 68 + random(1, 3), 1, random(10, 30));
//                                sticker_nf = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
//                            }
                                click(x, sticker_nf.getX() + random(1, 10), sticker_nf.getY() + random(1, 10));
                                x.sleep(random(1000, 3000));
                                click(x, sticker_nf.getX() - 195 + random(1, 60), sticker_nf.getY() - 361 + random(1, 10));
                                x.sleep(random(1000, 3000));
                                click(x, sticker_nf.getX() - 227 + (random(0, 3)) * 68 + random(1, 20), sticker_nf.getY() - 309 + (random(0, 3)) * 72 + random(1, 20));
                                x.sleep(random(1000, 3000));
                                click(x, random(1, 20), random(650, 700));//click cancel photo
                                x.sleep(random(1000, 3000));
                            }
                        }
                    }
//                    else {
//                        x.send("{enter}!n", false);
//                        x.sleep(random(1000, 2000));
//                        click(x, random(1, 20), random(650, 700));//click cancel photo
//                        x.sleep(random(1000, 3000));
//                    }
                }
            }
            if (shareornot == 20) {
                Position share_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NF, 15, 15);
                if (share_nf != null) {
                    click(x, share_nf.getX() + random(1, 30), share_nf.getY() + random(1, 10));
                    x.sleep(random(1000, 3000));
                    int sharenow = random(1, 3);
                    if (sharenow == 2) {
                        Position share_now_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NOW, 40, 15);
                        if (share_now_nf != null) {
                            click(x, share_now_nf.getX() + random(1, 30), share_now_nf.getY() + random(1, 10));
                            x.sleep(random(1000, 3000));
                        }
                        for (int sh = 1; sh < 5; sh++) {
                            Position share_fb = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 30, 30);
                            if (share_fb == null) {
                                x.sleep(random(2000, 3000));
                            } else {
                                break;
                            }
                        }
                    } else {
                        Position share_with_nf = new Scanner().scanImageOnAllScreen(image.SHARE_WITH, 40, 15);
                        if (share_with_nf != null) {
                            click(x, share_with_nf.getX() + random(1, 30), share_with_nf.getY() + random(1, 10));
                            for (int sh = 1; sh < 5; sh++) {
                                Position share_CL = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                                if (share_CL == null) {
                                    x.sleep(random(2000, 3000));
                                } else {
                                    break;
                                }
                            }
                            Position write_sth = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                            if (write_sth != null) {
                                click(x, write_sth.getX() - 150 + random(1, 30), write_sth.getY() + 50 + random(1, 10));
                                x.sleep(random(1000, 2000));
                                String cmt = getLineFromFile(COMMENT, random(1, getFinalLineNumber(COMMENT)));
                                typeMessage(x, cmt);
                                x.sleep(random(2000, 4000));
                                if (checkImageLoaded(image.POST_HPBD, 20, 15)) {
                                    Position share_with_post_nf = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                                    if (share_with_post_nf != null) {
                                        click(x, share_with_post_nf.getX() + random(1, 30), share_with_post_nf.getY() + random(1, 10));
                                        x.sleep(random(1000, 3000));
                                        for (int sh = 1; sh < 5; sh++) {
                                            Position share_fb = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 30, 30);
                                            if (share_fb == null) {
                                                x.sleep(random(2000, 3000));
                                            } else {
                                                break;
                                            }
                                        }
                                        click(x, random(1, 20), random(650, 700));//click cancel photo
                                        x.sleep(random(1000, 3000));
                                    }
                                }
                            }
                        }
                    }

                }
            }
            x.mouseWheel("down", random(5, 8));
            x.sleep(random(3000, 4000));
        }
    }

    public String postOnGroupDesk(AutoItX x, String url, String caption, int ppostlinkorimage, int psellordiscussion) throws AWTException, InterruptedException, IOException, UnsupportedFlavorException {
        waitChromeLoaded();
        String groupId = getLineFromFile(GROUP_ID, random(1, getFinalLineNumber(GROUP_ID)));
        while (groupId.length() < 5) {
            groupId = getLineFromFile(GROUP_ID, random(1, getFinalLineNumber(GROUP_ID)));
        }
        String sell_position = getLineFromFile(SELL_POSITION, random(1, getFinalLineNumber(SELL_POSITION)));
        String praise = getLineFromFile(PRAISE, random(1, getFinalLineNumber(PRAISE)));
        String emoticon = getLineFromFile(EMOTICON, random(1, getFinalLineNumber(EMOTICON)));

        int postlinkorimage = random(1, ppostlinkorimage);
        String geturl = groupId + "-nothing";
        String link = "https://facebook.com/groups/" + groupId;
        gotoUrl(x, link);
        waitChromeLoaded();
        x.mouseMove(random(440, 800), random(247, 370), random(10, 30));
        x.mouseWheel("up", random(7, 11));
        x.sleep(random(1000, 2000));
        Position p = new Scanner().scanImageOnAllScreen(image.JOIN_GROUP, 40, 15);
        if (p != null) {
            click(x, p.getX() + random(20, 100), p.getY() + random(5, 15));
            x.sleep(random(1000, 2000));
            geturl = groupId + "-joinGroup";
        } else {
            Position pending = new Scanner().scanImageOnAllScreen(image.PENDING, 40, 15);//### thay anh
            if (pending != null) {
                geturl = groupId + "-pending";
            }
        }
        if (checkImageLoaded(image.WRITE_SELL_DESK, 15, 15)) {
            int sellordiscussion = random(1, psellordiscussion);
            if (sellordiscussion != 2) {
                Position write_post_desk = new Scanner().scanImageOnAllScreen(image.WRITE_POST_DESK, 15, 15);
                if (write_post_desk != null) {
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(1000, 2000));
                    click(x, write_post_desk.getX() + random(10, 30), write_post_desk.getY() + random(2, 10));
                    x.sleep(random(5000, 7000));
                    typeMessage(x, caption);
                    x.sleep(random(500, 1000));
                    typeMessage(x, praise);
                    x.sleep(random(500, 1000));
                    typeMessage(x, emoticon);
                    x.send(" ");
                    x.sleep(random(1000, 2000));
                    if (postlinkorimage == 2) {
                        Position add_photo_group = new Scanner().scanImageOnAllScreen(image.ADD_PHOTO_GROUP, 15, 15);
                        if (add_photo_group != null) {
                            click(x, add_photo_group.getX() + random(1, 10), add_photo_group.getY() + random(2, 10));
                            x.sleep(random(4000, 5000));
                            Position folder_address = new Scanner().scanImageOnAllScreen(image.FOLDER_ADDRESS, 15, 15);
                            if (folder_address != null) {
                                click(x, folder_address.getX() - 50 + random(1, 15), folder_address.getY() + random(2, 10));
                                x.sleep(random(1000, 2000));
                                x.send(IMG_SELL);
                                x.send("{enter}!n", false);
                                x.sleep(random(1000, 2000));
                                Position file_name = new Scanner().scanImageOnAllScreen(image.FILE_NAME, 15, 15);
                                if (file_name != null) {
                                    click(x, file_name.getX() + 150 + random(1, 15), file_name.getY() + random(1, 15));
                                    x.sleep(random(500, 1500));
                                    x.send("1 (" + random(1, 150) + ")");
                                    x.send("{enter}!n", false);
                                    x.sleep(random(13000, 16000));

                                }
                            } else {
                                Position cancel = new Scanner().scanImageOnAllScreen(image.CANCEL, 15, 15);
                                if (cancel != null) {
                                    click(x, cancel.getX() + random(1, 15), cancel.getY() + random(1, 15));
                                    x.sleep(random(2000, 3000));
                                }
                            }
                        } else {
                            postlinkorimage = 1;
                        }
                    }
                    if (postlinkorimage != 2) {
                        x.sleep(random(1000, 2000));
                        x.send("{ENTER}!n", false);
                        x.sleep(random(1000, 2000));
                        StringSelection stringSelection = new StringSelection(url);
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        x.send("{CTRLDOWN}v{CTRLUP}!n", false);
                        x.sleep(random(1000, 2000));
                    }
                    for (int i = 1; i < 5; i++) {
                        Position post_desk = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                        if (post_desk != null) {

                            click(x, post_desk.getX() + random(1, 20), post_desk.getY() + random(2, 10));
                            x.sleep(random(2000, 3000));
                        } else {
                            x.mouseWheel("down", 1);
                        }
                    }
                    for (int l = 1; l < 9; l++) {
                        Position right_now_desk = new Scanner().scanImageOnAllScreen(image.RIGHT_NOW, 40, 15);
                        if (right_now_desk != null) {
                            click(x, right_now_desk.getX() + random(1, 20), right_now_desk.getY() + random(2, 10));
                            x.sleep(random(10000, 15000));
                            geturl = getUrl(x);
                            break;
                        } else {
                            x.mouseMove(random(440, 800), random(247, 448), random(10, 30));
                            x.sleep(random(1000, 2000));
                            x.mouseWheel("up", 1);
                            x.sleep(random(1000, 1500));
                            Position submitted_admin = new Scanner().scanImageOnAllScreen(image.SUBMITTED_ADMIN, 40, 15);
                            if (submitted_admin != null) {
                                geturl = groupId + "-admin";
                                break;
                            }
                            if (l == 8) {
                                geturl = groupId + "-IDK";
                            }
                        }
                    }
                } else {
                    sellordiscussion = 2;
                }
            }
            if (sellordiscussion == 2) {
                Position write_sell_desk = new Scanner().scanImageOnAllScreen(image.WRITE_SELL_DESK, 15, 15);
                if (write_sell_desk != null) {
                    //NỘI DUNG HÀM POST BÁN HÀNG TRONG GROUP
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(1000, 2000));
                    click(x, write_sell_desk.getX() + random(10, 30), write_sell_desk.getY() + random(2, 10));
                    x.sleep(random(5000, 7000));
                    x.send(caption);
                    x.sleep(random(2000, 3000));
                    click(x, write_sell_desk.getX() + random(1, 30), write_sell_desk.getY() + 85 + random(1, 10));//clink cost
                    x.sleep(random(2000, 4000));
                    int th = random(1, 5);
                    switch (th) {
                        case 1:
                            x.send("0");
                            break;
                        case 2:
                            x.send("9");
                            break;
                        case 3:
                            x.send("99");
                            break;
                        case 4:
                            x.send("999");
                            break;
                        case 5:
                            x.send("9999");
                            break;
                    }
                    x.sleep(random(2000, 3000));
                    click(x, write_sell_desk.getX() + 50 + random(1, 30), write_sell_desk.getY() + 130 + random(1, 10));//cliCk cost
                    x.sleep(random(2000, 4000));
                    x.send(sell_position);
                    x.sleep(random(2000, 4000));
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(2000, 3000));
                    click(x, write_sell_desk.getX() + random(1, 30), write_sell_desk.getY() + 180 + random(1, 10));//cliCk position
                    x.sleep(random(2000, 4000));
                    StringSelection stringSelection = new StringSelection(url);
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    x.send("{CTRLDOWN}v{CTRLUP}!n", false);
                    x.sleep(random(1000, 2000));
                    for (int i = 1; i < 5; i++) {
                        Position post_desk = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                        if (post_desk != null) {

                            click(x, post_desk.getX() + random(1, 20), post_desk.getY() + random(2, 10));
                            x.sleep(random(2000, 3000));
                        } else {
                            x.mouseWheel("down", 1);
                        }
                    }
                    for (int m = 1; m < 5; m++) {
                        Position right_now_desk = new Scanner().scanImageOnAllScreen(image.RIGHT_NOW, 40, 15);
                        if (right_now_desk != null) {
                            click(x, right_now_desk.getX() + random(1, 20), right_now_desk.getY() + random(2, 10));
                            x.sleep(random(10000, 15000));
                            geturl = getUrl(x);
                            break;
                        } else {
                            x.mouseMove(random(440, 800), random(247, 448), random(10, 30));
                            x.sleep(random(1000, 2000));
                            x.mouseWheel("up", 1);
                            x.sleep(random(1000, 1500));
                            Position submitted_admin = new Scanner().scanImageOnAllScreen(image.SUBMITTED_ADMIN, 40, 15);
                            if (submitted_admin != null) {
                                geturl = groupId + "-admin";
                                break;
                            }
                            if (m == 8) {
                                geturl = groupId + "-IDK";
                            }
                        }
                    }
                }
            }
        } else {
            Position write_post_desk = new Scanner().scanImageOnAllScreen(image.WRITE_POST_DESK, 15, 15);
            if (write_post_desk != null) {
                click(x, random(1, 20), random(650, 700));//click cancel photo
                x.sleep(random(1000, 2000));
                click(x, write_post_desk.getX() + random(10, 30), write_post_desk.getY() + random(2, 10));
                x.sleep(random(5000, 7000));
                typeMessage(x, caption);
                x.sleep(random(500, 1000));
                typeMessage(x, praise);
                x.sleep(random(500, 1000));
                typeMessage(x, emoticon);
                x.send(" ");
                x.sleep(random(1000, 2000));
                if (postlinkorimage == 2) {
                    Position add_photo_group = new Scanner().scanImageOnAllScreen(image.ADD_PHOTO_GROUP, 15, 15);
                    if (add_photo_group != null) {
                        click(x, add_photo_group.getX() + random(1, 10), add_photo_group.getY() + random(2, 10));
                        x.sleep(random(4000, 5000));
                        Position folder_address = new Scanner().scanImageOnAllScreen(image.FOLDER_ADDRESS, 15, 15);
                        if (folder_address != null) {
                            click(x, folder_address.getX() - 50 + random(1, 15), folder_address.getY() + random(2, 10));
                            x.sleep(random(1000, 2000));
                            x.send(IMG_SELL);
                            x.send("{enter}!n", false);
                            x.sleep(random(1000, 2000));
                            Position file_name = new Scanner().scanImageOnAllScreen(image.FILE_NAME, 15, 15);
                            if (file_name != null) {
                                click(x, file_name.getX() + 150 + random(1, 15), file_name.getY() + random(1, 15));
                                x.sleep(random(500, 1500));
                                x.send("1 (" + random(1, 150) + ")");
                                x.send("{enter}!n", false);
                                x.sleep(random(13000, 16000));

                            }
                        } else if (folder_address == null) {
                            Position cancel = new Scanner().scanImageOnAllScreen(image.CANCEL, 15, 15);
                            if (cancel != null) {
                                click(x, cancel.getX() + random(1, 15), cancel.getY() + random(1, 15));
                                x.sleep(random(2000, 3000));
                            }
                        }
                    } else {
                        postlinkorimage = 1;
                    }
                }
                if (postlinkorimage != 2) {
                    x.sleep(random(1000, 2000));
                    x.send("{ENTER}!n", false);
                    x.sleep(random(1000, 2000));
                    StringSelection stringSelection = new StringSelection(url);
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    x.send("{CTRLDOWN}v{CTRLUP}!n", false);
                    x.sleep(random(5000, 7000));
                }
                for (int i = 1; i < 5; i++) {
                    Position post_desk = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                    if (post_desk != null) {

                        click(x, post_desk.getX() + random(1, 20), post_desk.getY() + random(2, 10));
                        x.sleep(random(2000, 3000));
                    } else {
                        x.mouseWheel("down", 1);
                    }
                }
                for (int j = 1; j < 9; j++) {
                    Position right_now_desk = new Scanner().scanImageOnAllScreen(image.RIGHT_NOW, 40, 15);
                    if (right_now_desk != null) {
                        click(x, right_now_desk.getX() + random(1, 20), right_now_desk.getY() + random(2, 10));
                        x.sleep(random(10000, 15000));
                        geturl = getUrl(x);
                        break;
                    } else {
                        x.mouseMove(random(440, 800), random(247, 448), random(10, 30));
                        x.sleep(random(1000, 2000));
                        x.mouseWheel("up", 1);
                        x.sleep(random(1000, 1500));
                        Position submitted_admin = new Scanner().scanImageOnAllScreen(image.SUBMITTED_ADMIN, 40, 15);
                        if (submitted_admin != null) {
                            geturl = groupId + "-admin";
                            break;
                        }
                        if (j == 8) {
                            geturl = groupId + "-IDK";
                        }
                    }
                }
            }
        }
        return geturl;
    }

    public void testing(AutoItX x) throws AWTException, InterruptedException, IOException {
        Position testing = new Scanner().scanImageOnAllScreen(image.ADD_PHOTO_GROUP, 15, 15);
        System.out.println(testing.getX());
    }

    public void interactTarget(AutoItX x, String linktarget, String cmt, int plike, int pshare, int pcmt) throws AWTException, InterruptedException, IOException {
//        String linktarget = getLineFromFile(TARGET, random(1, getFinalLineNumber(TARGET)));
        gotoUrl(x, linktarget);
        waitChromeLoaded();
        x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
        x.sleep(random(1000, 2000));
        Position like_page = new Scanner().scanImageOnAllScreen(image.LIKE_PAGE, 15, 15);
        if (like_page != null) {
            click(x, like_page.getX() + random(1, 30), like_page.getY() + random(1, 10));
            x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
            x.sleep(random(2000, 4000));
        } else {
            //wait join group button loaded
            waitChromeLoaded();
            x.mouseWheel("up", random(5, 9));
            x.sleep(random(1000, 2000));
            Position p = new Scanner().scanImageOnAllScreen(image.JOIN_GROUP, 40, 15);
            if (p != null) {
                click(x, p.getX() + random(20, 100), p.getY() + random(5, 15));
                x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
                x.sleep(random(1000, 2000));
            }
        }
        int loops = 0;
//        int likeornot = random(1, 10);
//        int cmtornot = 20;
//        int shareornot = random(10, 30);
        int likeornot = random(1, plike);
        int cmtornot = random(1, pcmt);
        int shareornot = random(1, pshare);
        int whileloop = 0;
        while (!checkImageLoaded(image.CMT_NF, 15, 15)) {
            if (loops < 10) {
                x.mouseWheel("down", random(1, 4));
                x.sleep(random(1500, 3000));
                loops++;
                whileloop++;
            } else {
                gotoUrl(x, linktarget);
                x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
                x.sleep(random(1000, 2000));
                loops = 0;
            }
            if (whileloop > 25) {
                x.send("{f5}!n", false);
                waitChromeLoaded();
                x.mouseWheel("up", random(7, 11));
                x.sleep(random(1000, 2000));
                Position p = new Scanner().scanImageOnAllScreen(image.JOIN_GROUP, 40, 15);
                if (p != null) {
                    click(x, p.getX() + random(20, 100), p.getY() + random(5, 15));
                    x.sleep(random(1000, 2000));
                }
                break;
            }
        }
        Position like_nf = new Scanner().scanImageOnAllScreen(image.LIKE_NF, 15, 15);
        if (like_nf != null) {
            int d = random(1, 6);
//        System.out.println(like_nf.getX());
            if (likeornot < 4) {
                click(x, like_nf.getX() + random(1, 30), like_nf.getY() + random(1, 10));
                x.sleep(random(2000, 4000));
                click(x, random(1, 20), random(650, 700));//click cancel photo
                x.sleep(random(2000, 3000));
            } else if (likeornot > 4) {
                x.mouseMove(like_nf.getX() + random(1, 30), like_nf.getY() + random(1, 10), random(10, 30));
                x.sleep(random(2000, 4000));
                Position love_nf = new Scanner().scanImageOnAllScreen(image.LOVE_NF, 15, 15);
                if (love_nf != null) {
                    switch (d) {
                        case 1:
                            x.mouseClick("left", love_nf.getX() + 0 + random(1, 20), love_nf.getY() + random(1, 10), 1, random(10, 30));
                            break;
                        case 2:
                            x.mouseClick("left", love_nf.getX() + 50 + random(1, 20), love_nf.getY() + random(1, 10), 1, random(10, 30));
                            break;
                        case 3:
                            x.mouseClick("left", love_nf.getX() + 100 + random(1, 20), love_nf.getY() + random(1, 10), 1, random(10, 30));
                            break;
                        case 4:
                            x.mouseClick("left", love_nf.getX() + 150 + random(1, 20), love_nf.getY() + random(1, 10), 1, random(10, 30));
                            break;
                        case 5:
                            x.mouseClick("left", love_nf.getX() + 200 + random(1, 20), love_nf.getY() + random(1, 10), 1, random(10, 30));
                            break;
                        case 6:
                            x.mouseClick("left", love_nf.getX() + 250 + random(1, 20), love_nf.getY() + random(1, 10), 1, random(10, 30));
                            break;
                    }
                }
//                if (!checkImageLoaded(image.LOVE_NF, 15, 15)) {
//                    likeornot = 4;
//                }
                click(x, random(1, 20), random(650, 700));//click cancel photo
                x.sleep(random(1000, 3000));
            } else if (likeornot == 4) {
                x.mouseWheel("down", random(1, 4));
                x.sleep(random(2000, 4000));
            }
        }
        if (cmtornot == 1) {
            if (checkImageLoaded(image.CMT_NF, 15, 15)) {
                Position cmt_nf = new Scanner().scanImageOnAllScreen(image.CMT_NF, 15, 15);
                if (cmt_nf != null) {
                    click(x, cmt_nf.getX() + random(1, 30), cmt_nf.getY() + random(1, 10));
                    x.sleep(random(2000, 4000));
                    String cmtl = getLineFromFile(COMMENT, random(1, 788));
                    String emo = getLineFromFile(EMOTICON, random(1, 108));
                    x.send(cmtl);
                    x.sleep(random(500, 1000));
                    x.send(emo);
                    x.sleep(random(1000, 2000));
                    x.send(" ");
                    x.sleep(random(1000, 3000));
                    x.send("{enter}!n", false);
                    x.sleep(random(1000, 2000));
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(1000, 3000));
                }
            }
//            int tagfr = random(1, 20);
//            if (tagfr == 10) {
//                x.send("@");
//                String tag = randomSimpleString(1);
//                x.send(tag);//send char
//                x.sleep(3000);
//                x.send("{enter}!n", false);
//                x.sleep(2000);
//                x.send("{enter}!n", false);
//                x.sleep(random(2000, 4000));
//                click(x, random(1, 20), random(650, 700));//click cancel photo
//                x.sleep(random(1000, 3000));
//            }// TAG FRIEND
            int cmtsticker = random(3, 7);
            if (cmtsticker == 5) {
                Position sticker_nf = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
                if (sticker_nf != null) {
                    if (sticker_nf.getY() > 550) {
                        click(x, sticker_nf.getX() + random(1, 10), sticker_nf.getY() + random(1, 10));
                        x.sleep(random(1000, 3000));
                        click(x, sticker_nf.getX() - 195 + random(1, 60), sticker_nf.getY() - 361 + random(1, 10));
                        x.sleep(random(1000, 3000));
                        click(x, sticker_nf.getX() - 227 + (random(0, 3)) * 68 + random(1, 20), sticker_nf.getY() - 309 + (random(0, 3)) * 72 + random(1, 20));
                        x.sleep(random(1000, 3000));
                        click(x, random(1, 20), random(650, 700));//click cancel photo
                        x.sleep(random(1000, 3000));
                    }
                }
            }
        }//comment function
        if (shareornot == 1) {
            Position share_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NF, 15, 15);
            if (share_nf != null) {
                while (share_nf.getY() > 540) {
                    x.mouseWheel("down", 1);
                    x.sleep(random(1000, 2000));
                    share_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NF, 15, 15);
                    x.sleep(1000);
                }
                if (share_nf != null) {
                    click(x, share_nf.getX() + random(1, 30), share_nf.getY() + random(1, 10));
                    x.sleep(random(1000, 3000));
                    x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
                    x.sleep(random(1000, 2000));
                    int sharenow = random(1, 3);
                    if (sharenow == 2) {
                        click(x, share_nf.getX() + random(30, 60), share_nf.getY() + 38 + random(1, 6));
                        x.sleep(random(10000, 13000));
                    } else {
                        Position share_with_nf = new Scanner().scanImageOnAllScreen(image.SHARE_WITH, 40, 15);
                        if (share_with_nf != null) {
                            click(x, share_with_nf.getX() + random(1, 30), share_with_nf.getY() + random(1, 10));
                            for (int sh = 1; sh < 5; sh++) {
                                Position share_CL = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                                if (share_CL == null) {
                                    x.sleep(random(2000, 3000));
                                } else {
                                    break;
                                }
                            }
                            Position write_sth = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                            if (write_sth != null) {
                                click(x, write_sth.getX() - 150 + random(1, 30), write_sth.getY() + 50 + random(1, 10));
                                x.sleep(random(1000, 2000));
//                                String cmt = getLineFromFile(COMMENT, random(1, getFinalLineNumber(COMMENT)));
                                typeMessage(x, cmt);
                                x.sleep(random(2000, 4000));
                                Position share_with_post_nf = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                                if (share_with_post_nf != null) {
                                    click(x, share_with_post_nf.getX() + random(1, 30), share_with_post_nf.getY() + random(1, 10));
                                    x.sleep(random(1000, 3000));
                                    for (int sh = 1; sh < 5; sh++) {
                                        Position share_fb = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 30, 30);
                                        if (share_fb == null) {
                                            x.sleep(random(2000, 3000));
                                        } else {
                                            break;
                                        }
                                    }
                                    click(x, random(1, 20), random(650, 700));//click cancel photo
                                    x.sleep(random(1000, 3000));
                                }
                            }
                        }
                    }
                }
            }
        }//share now function
    }

    public void inboxTarget(AutoItX x) throws IOException, AWTException, InterruptedException {
        String targetLink = getLineFromFile(INBOX_TARGET, random(1, getFinalLineNumber(INBOX_TARGET)));
        gotoUrl(x, targetLink);
        waitChromeLoaded();
        x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
        x.sleep(random(1000, 2000));

        if (checkImageLoaded(image.INBOX_MSG, 15, 15)) {
            Position p = new Scanner().scanImageOnAllScreen(image.INBOX_MSG, 15, 15);
            if (p != null) {
                click(x, p.getX() + random(1, 15), p.getY() + random(1, 15));
                x.sleep(random(1000, 2000));
                String mess = getLineFromFile(MESS, random(1, getFinalLineNumber(MESS)));
                typeMessage(x, mess);
                x.sleep(random(1000, 3000));
                x.send("{enter}!n", false);
                x.sleep(random(1000, 2000));
                if (checkImageLoaded(image.CLOSE_MESSAGER_BOX, 15, 15)) {
                    Position close_messager_box = new Scanner().scanImageOnAllScreen(image.CLOSE_MESSAGER_BOX, 15, 15);
                    if (close_messager_box != null) {
                        click(x, close_messager_box.getX() + random(1, 8), close_messager_box.getY() + random(1, 8));
                        x.sleep(random(1000, 2000));
                    }
                }
            }
//            Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
//            if (fb_symbol != null) {
//                click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
//                waitChromeLoaded();
//            }
        }
    }

    public void addFriend(AutoItX x) throws AWTException, InterruptedException, IOException {
        String userID = getLineFromFile(FRIEND_TOBE_ADDED, random(1, getFinalLineNumber(FRIEND_TOBE_ADDED)));
//        userID = "100007716853799";
        String link = "https://facebook.com/" + userID;
        gotoUrl(x, link);
        waitChromeLoaded();
        x.mouseMove(random(360, 590), random(190, 258), random(10, 50));
        x.sleep(random(1000, 2000));
        Position accept_friend_request = new Scanner().scanImageOnAllScreen(image.ACCEPT_FRIEND_REQUEST, 15, 15);
        if (accept_friend_request != null) {

            click(x, accept_friend_request.getX() + random(1, 10), accept_friend_request.getY() + random(1, 10));
            x.sleep(random(1000, 2000));
            click(x, accept_friend_request.getX() + random(1, 10), accept_friend_request.getY() + random(1, 5) + 40);
        }
    }

    public void testing2(AutoItX x) throws AWTException, InterruptedException, IOException {
//    Position setting = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
//    System.out.println(setting.getX());
//for(int i=1;i <10; i++){
//    System.out.println(random(1,2));
//}
    }

    public void checkNotification(AutoItX x) throws AWTException, IOException, InterruptedException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol == null) {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        if (!checkImageLoaded(image.NEW_NOTIFICATION, 15, 15)) {
            Position setting = new Scanner().scanImageOnAllScreen(image.SETTING, 15, 15);
            if (setting != null) {
                click(x, setting.getX() - 78 + random(1, 8), setting.getY() + random(1, 8));
                x.sleep(random(2000, 3000));
                int check_notification = new Scanner().scanImageOnScreen(952, 15, 15, image.CHECK_NOTIFICATION);
                if (check_notification > 0) {
                    click(x, random(756, 900), check_notification + random(1, 10));
                    x.sleep(random(3000, 5000));
                    waitChromeLoaded();
                    Thread.sleep(3000);
                    Position like_nf = new Scanner().scanImageOnAllScreen(image.LIKE_NF, 15, 15);
                    if (like_nf != null) {
                        click(x, like_nf.getX() + random(1, 30), like_nf.getY() + random(1, 10));
                        x.sleep(random(2000, 4000));
                    }
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(1000, 3000));
                    Position sticker_nf = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
                    if (sticker_nf != null) {
                        click(x, sticker_nf.getX() - 315 + random(1, 30), sticker_nf.getY() + random(1, 10));
                        x.sleep(random(1000, 3000));
                        String cmtl = getLineFromFile(COMMENT, random(1, 788));
                        String emo = getLineFromFile(EMOTICON, random(1, 108));
                        x.send(cmtl);
                        x.sleep(random(500, 1000));
                        x.send(emo);
                        x.sleep(random(1000, 2000));
                        x.send(" ");
                        x.sleep(random(1000, 3000));
                        x.send("{enter}!n", false);
                        x.sleep(random(1000, 2000));
                        click(x, random(1, 20), random(650, 700));//click cancel photo
                        x.sleep(random(1000, 3000));
                    }
                    int cmtsticker = random(3, 7);
                    if (cmtsticker == 5) {
                        sticker_nf = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
                        if (sticker_nf != null) {
                            if (sticker_nf.getY() > 550) {
                                click(x, sticker_nf.getX() + random(1, 10), sticker_nf.getY() + random(1, 10));
                                x.sleep(random(1000, 3000));
                                click(x, sticker_nf.getX() - 195 + random(1, 60), sticker_nf.getY() - 361 + random(1, 10));
                                x.sleep(random(1000, 3000));
                                click(x, sticker_nf.getX() - 227 + (random(0, 3)) * 68 + random(1, 20), sticker_nf.getY() - 309 + (random(0, 3)) * 72 + random(1, 20));
                                x.sleep(random(1000, 3000));
                                click(x, random(1, 20), random(650, 700));//click cancel photo
                                x.sleep(random(1000, 3000));
                            }
                        }
                    }
                }
            }
        }
    }

    public void handleInbox(AutoItX x) throws AWTException, IOException, InterruptedException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol == null) {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        if (!checkImageLoaded(image.CHECK_INBOX, 15, 15)) {
            Position setting = new Scanner().scanImageOnAllScreen(image.SETTING, 15, 15);
            if (setting != null) {
                click(x, setting.getX() - 113 + random(1, 8), setting.getY() + random(1, 8));
//            waitImageLoaded(image.OLD_MESSAGE, 15, 15);
                Position new_message = new Scanner().scanImageOnAllScreen(image.NEW_MESSAGE, 15, 15);
                if (new_message != null) {

                    click(x, new_message.getX() - 100 + random(1, 30), new_message.getY() + random(1, 10));
                    x.sleep(random(1000, 2000));
                    String mess = getLineFromFile(MESS, random(1, getFinalLineNumber(MESS)));
                    typeMessage(x, mess);
                    x.sleep(random(1000, 3000));
                    x.send("{enter}!n", false);
                    x.sleep(random(1000, 2000));
                    Position close_messager_box = new Scanner().scanImageOnAllScreen(image.CLOSE_MESSAGER_BOX, 15, 15);
                    if (close_messager_box != null) {

                        click(x, close_messager_box.getX() + random(1, 8), close_messager_box.getY() + random(1, 8));
                        x.sleep(random(1000, 2000));
                    }
                }
            }
        }
        Position close_messager_box2 = new Scanner().scanImageOnAllScreen(image.CLOSE_MESSAGER_BOX2, 15, 15);
        if (close_messager_box2 != null) {
            click(x, close_messager_box2.getX() + random(1, 8), close_messager_box2.getY() + random(1, 8));
            waitChromeLoaded();
        }
//        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
//        if (fb_symbol != null) {
//            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
//            waitChromeLoaded();
//        }
    }

    public void happyBirthday(AutoItX x) throws AWTException, InterruptedException, IOException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        }
        waitChromeLoaded();
        if (checkImageLoaded(image.HAPPY_BIRTHDAY, 15, 15)) {
            Position happy_birthday = new Scanner().scanImageOnAllScreen(image.HAPPY_BIRTHDAY, 15, 15);
            if (happy_birthday != null) {
                click(x, happy_birthday.getX() + random(1, 50), happy_birthday.getY() + random(1, 15));
                x.sleep(random(2000, 3000));
                for (int i = 1; i < 5; i++) {
                    if (checkImageLoaded(image.CLOSE, 15, 15)) {
                        break;
                    } else {
                        x.sleep(2000);
                    }
                }
                if (checkImageLoaded(image.CLOSE, 15, 15)) {
                    if (checkImageLoaded(image.HAPPY_BIRTHDAY_ADD_PHOTO, 15, 15)) {
                        String wish = getLineFromFile(WISH, random(1, getFinalLineNumber(WISH)));
                        typeMessage(x, wish);
                        x.sleep(random(1000, 2000));
                        if (checkImageLoaded(image.HAPPY_BIRTHDAY_ADD_PHOTO, 15, 15)) {
                            Position happy_birthday_add_photo = new Scanner().scanImageOnAllScreen(image.HAPPY_BIRTHDAY_ADD_PHOTO, 15, 15);
                            if (happy_birthday_add_photo != null) {
                                click(x, happy_birthday_add_photo.getX() + random(1, 15), happy_birthday_add_photo.getY() + random(1, 15));
                                for (int j = 1; j < 5; j++) {
                                    if (checkImageLoaded(image.CLOSE, 15, 15)) {
                                        break;
                                    } else {
                                        x.sleep(2000);
                                    }
                                }
                                if (checkImageLoaded(image.HAPPY_BIRTHDAY_UPLOAD_PHOTO, 40, 15)) {
                                    Position happy_birthday_upload_photo = new Scanner().scanImageOnAllScreen(image.HAPPY_BIRTHDAY_UPLOAD_PHOTO, 40, 15);
                                    if (happy_birthday_upload_photo != null) {
                                        click(x, happy_birthday_upload_photo.getX() + random(1, 50), happy_birthday_upload_photo.getY() + random(1, 10));

                                        for (int m = 1; m < 5; m++) {
                                            if (checkImageLoaded(image.FOLDER_ADDRESS, 15, 15)) {
                                                break;
                                            } else {
                                                x.sleep(2000);
                                            }
                                        }
                                        if (checkImageLoaded(image.FOLDER_ADDRESS, 15, 15)) {
                                            Position folder_address = new Scanner().scanImageOnAllScreen(image.FOLDER_ADDRESS, 15, 15);
                                            if (folder_address != null) {
                                                click(x, folder_address.getX() - 50 + random(1, 15), folder_address.getY() + random(2, 10));
                                                x.sleep(random(1000, 2000));
                                                x.send(HAPPY_BIRTHDAY_IMAGE_FOLDER);
                                                x.send("{enter}!n", false);
                                                x.sleep(random(1000, 2000));
                                                if (checkImageLoaded(image.FILE_NAME, 15, 15)) {
                                                    Position file_name = new Scanner().scanImageOnAllScreen(image.FILE_NAME, 15, 15);
                                                    if (file_name != null) {
                                                        click(x, file_name.getX() + 150 + random(1, 15), file_name.getY() + random(1, 15));
                                                        x.sleep(random(500, 1500));
                                                        x.send("1 (" + random(1, 893) + ")");
                                                        x.send("{enter}!n", false);
                                                        x.sleep(random(1000, 2000));
                                                        for (int k = 1; k < 5; k++) {
                                                            if (checkImageLoaded(image.POST_HPBD, 20, 15)) {
                                                                break;
                                                            } else {
                                                                x.sleep(2000);
                                                            }
                                                        }
                                                        if (checkImageLoaded(image.POST_HPBD, 20, 15)) {
                                                            Position post = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                                                            if (post != null) {
                                                                click(x, post.getX() + random(1, 15), post.getY() + random(1, 15));
                                                                x.sleep(random(5000, 7000));
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (folder_address == null) {
                                                Position cancel = new Scanner().scanImageOnAllScreen(image.CANCEL, 15, 15);
                                                if (cancel != null) {
                                                    click(x, cancel.getX() + random(1, 15), cancel.getY() + random(1, 15));
                                                    x.sleep(random(2000, 3000));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                click(x, random(1, 20), random(650, 700));//click cancel photo
                x.sleep(random(1000, 2000));
            }
        }
    }

    public void acceptFriend(AutoItX x) throws AWTException, IOException, InterruptedException {

        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        }
        if (checkImageLoaded(image.FRIEND_INVITES, 15, 15)) {
            Position friend_invites = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES, 15, 15);
            if (friend_invites != null) {
                click(x, friend_invites.getX() + random(1, 15), friend_invites.getY() + random(1, 15));
                x.sleep(random(1000, 2000));
                x.mouseMove(random(758, 944), random(200, 400), random(10, 30));
                for (int i = 1; i < 5; i++) {
                    if (checkImageLoaded(image.FRIEND_INVITES_ADD, 15, 15)) {
                        break;
                    } else {
                        x.mouseWheel("down", 1);
                    }
                }
                Position friend_invites_add = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES_ADD, 15, 15);
                if (friend_invites_add != null) {
                    click(x, friend_invites_add.getX() + random(1, 15), friend_invites_add.getY() + random(1, 15));
                }
            }
            if (checkImageLoaded(image.FRIEND_INVITES_ACCEPT, 15, 15)) {
                Position friend_invites_accept_0 = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES_ACCEPT, 15, 15);
                if (friend_invites_accept_0 != null) {
                    click(x, friend_invites_accept_0.getX() - 242 + random(1, 15), friend_invites_accept_0.getY() + random(1, 15));
                    waitChromeLoaded();
                    x.mouseMove(random(400, 670), random(200, 250), random(10, 30));
                    x.sleep(random(2000, 3000));
                    x.mouseWheel("down", random(5, 8));
                    x.sleep(random(3000, 4000));
                    x.mouseWheel("down", random(1, 2));
                    x.sleep(random(1000, 2000));
                    Position friend_invites_accept = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES_ACCEPT, 15, 15);
                    if (friend_invites_accept != null) {
                        click(x, friend_invites_accept.getX() + random(1, 15), friend_invites_accept.getY() + random(1, 15));
                    } else if (checkImageLoaded(image.FRIEND_INVITES_ACCEPT, 15, 15)) {
                        Position accept_friend_request = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES_ACCEPT, 15, 15);
                        if (accept_friend_request != null) {
                            click(x, accept_friend_request.getX() + random(1, 10), accept_friend_request.getY() + random(1, 10));
                            x.sleep(random(1000, 2000));
                            click(x, accept_friend_request.getX() + random(1, 10), accept_friend_request.getY() + random(1, 5) + 40);
                        }
                    }
                }
            }
        } else if (!checkImageLoaded(image.FRIEND_INVITES, 15, 15)) {
            Position setting = new Scanner().scanImageOnAllScreen(image.SETTING, 15, 15);
            if (setting != null) {
                click(x, setting.getX() - 147 + random(1, 15), setting.getY() + random(1, 15));
                x.sleep(random(1000, 2000));
                Position friend_invites_accept_0 = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES_ACCEPT, 15, 15);
                if (friend_invites_accept_0 != null) {
                    click(x, friend_invites_accept_0.getX() - 242 + random(1, 15), friend_invites_accept_0.getY() + random(1, 15));
                    waitChromeLoaded();
                    x.mouseMove(random(400, 670), random(200, 250), random(10, 30));
                    x.sleep(random(2000, 3000));
                    x.mouseWheel("down", random(5, 8));
                    x.sleep(random(3000, 4000));
                    x.mouseWheel("down", random(1, 2));
                    x.sleep(random(1000, 2000));
                    Position friend_invites_accept = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES_ACCEPT, 15, 15);
                    if (friend_invites_accept != null) {
                        click(x, friend_invites_accept.getX() + random(1, 15), friend_invites_accept.getY() + random(1, 15));
                    } else if (checkImageLoaded(image.FRIEND_INVITES_ACCEPT, 15, 15)) {
                        Position accept_friend_request = new Scanner().scanImageOnAllScreen(image.FRIEND_INVITES_ACCEPT, 15, 15);
                        if (accept_friend_request != null) {
                            click(x, accept_friend_request.getX() + random(1, 10), accept_friend_request.getY() + random(1, 10));
                            x.sleep(random(1000, 2000));
                            click(x, accept_friend_request.getX() + random(1, 10), accept_friend_request.getY() + random(1, 5) + 40);
                        }
                    }
                }
            }
        }
        fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 30, 30);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        }
        click(x, random(1, 20), random(650, 700));//click cancel photo
        x.sleep(random(1000, 2000));
    }

    public void shopping(AutoItX x) throws AWTException, InterruptedException, IOException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        } else {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        if (checkImageLoaded(image.SHOPPING, 15, 15)) {
            Position shopping = new Scanner().scanImageOnAllScreen(image.SHOPPING, 15, 15);
            if (shopping != null) {
                click(x, shopping.getX() + 30 + random(1, 15), shopping.getY() + random(1, 15));
                x.sleep(random(500, 1200));
                x.send("{f5}!n", false);
                x.sleep(random(2000, 3000));
                waitChromeLoaded();
                int wheeltime = 10;//random(2, 3);
                for (int wtime = 1; wtime < wheeltime; wtime++) {
                    x.sleep(random(1000, 2000));
                    x.mouseWheel("down", random(1, 7));
                    x.sleep(random(2000, 3000));
                    Position go_to_shop = new Scanner().scanImageOnAllScreen(image.GO_TO_SHOP, 15, 15);
                    if (go_to_shop != null) {
                        if (go_to_shop.getY() > 500) {
                            int rdimg = random(1, 3);
                            switch (rdimg) {
                                case 1:
                                    click(x, go_to_shop.getX() - 50 + random(1, 15), go_to_shop.getY() - 105 + random(1, 15));
                                    break;
                                case 2:
                                    click(x, go_to_shop.getX() - 50 + random(1, 15), go_to_shop.getY() - 284 + random(1, 15));
                                    break;
                                case 3:
                                    click(x, go_to_shop.getX() - 300 + random(1, 15), go_to_shop.getY() - 105 + random(1, 15));
                                    break;
                            }
                            x.sleep(random(4000, 5000));
                            Position close = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                            if (close != null) {
                                click(x, close.getX() + random(1, 8), close.getY() + random(1, 8));
                                x.sleep(random(1000, 2000));
                                x.mouseMove(random(279, 816), random(250, 600), random(10, 30));
                            }
                        } else {
                            click(x, go_to_shop.getX() + random(3, 13), go_to_shop.getY() + random(3, 13));
                            x.sleep(random(2000, 3000));
                            waitChromeLoaded();
                            x.mouseWheel("down", random(1, 4));
                            x.sleep(random(1000, 2000));
                            x.mouseWheel("down", random(1, 4));
                            x.sleep(random(1000, 2000));
                            break;
                        }
                    }
                }
//                fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
//                if (fb_symbol != null) {
//                    click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
//                    waitChromeLoaded();
//                }
                click(x, random(1, 20), random(650, 700));//click cancel photo
                x.sleep(random(1000, 2000));
            }
        }
    }

    public void liveVideo(AutoItX x) throws AWTException, InterruptedException, IOException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        } else {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        if (checkImageLoaded(image.LIVE_VIDEO, 15, 15)) {
            Position live_video = new Scanner().scanImageOnAllScreen(image.LIVE_VIDEO, 15, 15);
            if (live_video != null) {
                click(x, live_video.getX() + 30 + random(1, 15), live_video.getY() + random(1, 15));
                x.sleep(random(500, 1200));
                x.send("{f5}!n", false);
                x.sleep(random(2000, 3000));
                if (checkImageLoaded(image.FB_SYMBOL, 20, 20)) {
                    fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
                    if (fb_symbol != null) {
                        click(x, fb_symbol.getX() + 100 + random(1, 15), fb_symbol.getY() + 142 + random(1, 15));
                        waitChromeLoaded();
                        x.sleep(random(20000, 25000));
                        click(x, random(1, 20), random(550, 600));//click cancel photo
                        x.sleep(random(2000, 3000));
//                        click(x, fb_symbol.getX() + random(1, 15), fb_symbol.getY() + random(1, 15));
//                        x.sleep(random(1000, 2000));
                        waitChromeLoaded();
                    }
                }
            }
        }
    }

    public void game(AutoItX x) throws AWTException, InterruptedException, IOException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        } else {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        Position game = new Scanner().scanImageOnAllScreen(image.GAME, 15, 15);
        if (game != null) {
            click(x, game.getX() + 2 + random(1, 15), game.getY() + 2 + random(1, 15));
            x.sleep(random(1000, 2000));
            waitChromeLoaded();
            x.mouseMove(random(336, 900), random(275, 598));
            x.sleep(random(1000, 2000));
            int g = random(1, 3);
            if (g == 2) {
                int gg = random(5, 6);
                for (int ggg = 1; ggg < gg; ggg++) {
                    int du = random(1, 5);
                    if (du == 2) {
                        x.mouseWheel("up", random(3, 4));
                        x.sleep(random(500, 1500));
                        x.mouseMove(random(336, 900), random(275, 598));
                        x.sleep(random(1000, 2000));
                    } else {
                        x.mouseWheel("down", random(3, 4));
                        x.sleep(random(500, 1500));
                        x.mouseMove(random(336, 900), random(275, 598));
                        x.sleep(random(1000, 2000));
                    }
                }
            } else {
                Position fb_symbol2 = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
                if (fb_symbol2 != null) {
                    click(x, fb_symbol2.getX() + 145 + random(1, 15), fb_symbol2.getY() + 48 + random(1, 15));
                    x.sleep(random(1000, 2000));
                    waitChromeLoaded();
                    x.mouseMove(random(336, 900), random(275, 598));
                    x.sleep(random(2000, 3000));
                    click(x, fb_symbol2.getX() + 80 + random(1, 15), fb_symbol2.getY() + 100 + random(1, 15));
                    x.sleep(random(1000, 2000));
                    x.mouseMove(random(336, 900), random(275, 598));
                    x.sleep(random(2000, 3000));
                    int gg1 = random(5, 6);
                    for (int ggg1 = 1; ggg1 < gg1; ggg1++) {
                        int du = random(1, 5);
                        if (du == 2) {
                            x.mouseWheel("up", random(3, 4));
                            x.sleep(random(500, 1500));
                            x.mouseMove(random(336, 900), random(275, 598));
                            x.sleep(random(1000, 2000));
                        } else {
                            x.mouseWheel("down", random(3, 4));
                            x.sleep(random(500, 1500));
                            x.mouseMove(random(336, 900), random(275, 598));
                            x.sleep(random(1000, 2000));
                        }
                    }
                }
            }
//            fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
//            if (fb_symbol != null) {
//                click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
//                waitChromeLoaded();
//            } else if (fb_symbol == null) {
//                gotoUrl(x, FACEBOOK_HOMPAGE);
//            }
        }
    }

    public void activity(AutoItX x) throws AWTException, InterruptedException, IOException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol != null) {
            click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
            waitChromeLoaded();
        } else {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        Position setting = new Scanner().scanImageOnAllScreen(image.SETTING, 15, 15);
        if (setting != null) {
            x.mouseMove(setting.getX() + 145 + random(1, 60), setting.getY() + 45 + random(1, 80), random(10, 30));
            x.sleep(random(2000, 3000));
            int loops = 0;
            int likeornot = random(1, 10);
            int cmtornot = random(15, 25);
            int shareornot = random(13, 27);
            int d = random(1, 6);
            Position like_nf = new Scanner().scanImageOnAllScreen(image.LIKE_NF, 15, 15);
            if (like_nf == null) {
                x.mouseWheel("down", random(2, 3));
                x.sleep(random(1000, 2000));
                like_nf = new Scanner().scanImageOnAllScreen(image.LIKE_NF, 15, 15);
                if (like_nf == null) {
                    x.mouseMove(random(791, 963), random(300, 400));
                    x.sleep(random(1000, 2000));
                    x.mouseWheel("down", random(2, 3));
                    x.sleep(random(1000, 2000));
                }
            }
            if (like_nf != null) {
                if (likeornot < 4) {
                    click(x, like_nf.getX() + random(1, 30), like_nf.getY() + random(1, 10));
                    x.sleep(random(2000, 4000));
                    click(x, random(1, 20), random(650, 700));//click cancel photo
                    x.sleep(random(1000, 3000));
                } else if (likeornot == 4) {
                    x.mouseMove(like_nf.getX() + random(1, 30), like_nf.getY() + random(1, 10), random(20, 50));
                    x.sleep(random(2000, 4000));
                    Position love_nf = new Scanner().scanImageOnAllScreen(image.LOVE_NF, 15, 15);
                    if (love_nf != null) {
                        switch (d) {
                            case 1:
                                click(x, love_nf.getX() + 0 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 2:
                                click(x, love_nf.getX() + 50 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 3:
                                click(x, love_nf.getX() + 100 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 4:
                                click(x, love_nf.getX() + 150 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 5:
                                click(x, love_nf.getX() + 200 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                            case 6:
                                click(x, love_nf.getX() + 250 + random(1, 20), love_nf.getY() + random(1, 10));
                                break;
                        }
                    }
                }
            }
            if (cmtornot == 20) {
                Position cmt_nf = new Scanner().scanImageOnAllScreen(image.CMT_NF, 15, 15);
                if (cmt_nf != null) {
                    click(x, cmt_nf.getX() + random(1, 30), cmt_nf.getY() + random(1, 10));
                    x.sleep(random(2000, 4000));
                    String cmt = getLineFromFile(COMMENT, random(1, getFinalLineNumber(COMMENT)));
                    typeMessage(x, cmt);
                    x.sleep(random(1000, 3000));
                    x.send("{enter}!n", false);
                    x.sleep(random(1000, 3000));
//                    int tagfr = random(1, 20);
//                    if (tagfr == 5) {
//                        x.send(" @");
//                        String tag = randomSimpleString(1);
//                        x.send(tag);//send char
//                        x.sleep(3000);
//                        x.send("{enter}!n", false);
//                        x.sleep(2000);
//                        x.send("{enter}!n", false);
//                        x.sleep(random(2000, 4000));
//                    }// TAG FRIEND
                    int cmtsticker = random(1, 10);
                    if (cmtsticker == 5) {
//                        x.send("{enter}!n", false);
//                        x.sleep(random(1000, 2000));
                        Position sticker_nf = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
                        if (sticker_nf != null) {

                            if (sticker_nf.getY() < 550) {
//                                x.mouseClick("left", 1354 + random(1, 6), 68 + random(1, 3), 1, random(10, 30));
//                                sticker_nf = new Scanner().scanImageOnAllScreen(image.STICKER_NF, 15, 15);
//                            }
                                click(x, sticker_nf.getX() + random(1, 10), sticker_nf.getY() + random(1, 10));
                                x.sleep(random(1000, 3000));
                                click(x, sticker_nf.getX() - 195 + random(1, 60), sticker_nf.getY() - 361 + random(1, 10));
                                x.sleep(random(1000, 3000));
                                click(x, sticker_nf.getX() - 227 + (random(0, 3)) * 68 + random(1, 20), sticker_nf.getY() - 309 + (random(0, 3)) * 72 + random(1, 20));
                                x.sleep(random(1000, 3000));
                            }
                        }
                    }
//                    else {
//                        x.send("{enter}!n", false);
//                        x.sleep(random(1000, 3000));
//                    }
                }
            }
            if (shareornot == 20) {
                Position share_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NF, 15, 15);
                if (share_nf != null) {
                    click(x, share_nf.getX() + random(1, 30), share_nf.getY() + random(1, 10));
                    x.sleep(random(1000, 3000));
                    int sharenow = random(1, 3);
                    if (sharenow == 2) {
                        Position share_now_nf = new Scanner().scanImageOnAllScreen(image.SHARE_NOW, 40, 15);
                        if (share_now_nf != null) {
                            click(x, share_now_nf.getX() + random(1, 30), share_now_nf.getY() + random(1, 10));
                            x.sleep(random(1000, 3000));
                        }
                        for (int sh = 1; sh < 5; sh++) {
                            Position share_fb = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
                            if (share_fb == null) {
                                x.sleep(random(2000, 3000));
                            } else {
                                break;
                            }
                        }
                    } else {
                        Position share_with_nf = new Scanner().scanImageOnAllScreen(image.SHARE_WITH, 40, 15);
                        if (share_with_nf == null) {
                            share_with_nf = new Scanner().scanImageOnAllScreen(image.SHARE_WITH, 40, 15);
                        }
                        if (share_with_nf != null) {
                            click(x, share_with_nf.getX() + random(1, 30), share_with_nf.getY() + random(1, 10));
                            for (int sh = 1; sh < 5; sh++) {
                                Position share_CL = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                                if (share_CL == null) {
                                    x.sleep(random(2000, 3000));
                                } else {
                                    break;
                                }
                            }
                            Position write_sth = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
                            if (write_sth != null) {
                                click(x, write_sth.getX() - 150 + random(1, 30), write_sth.getY() + 50 + random(1, 10));
                                x.sleep(random(1000, 2000));
                                String cmt = getLineFromFile(COMMENT, random(1, getFinalLineNumber(COMMENT)));
                                typeMessage(x, cmt);
                                x.sleep(random(2000, 4000));
                                if (checkImageLoaded(image.POST_HPBD, 20, 15)) {
                                    Position share_with_post_nf = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                                    if (share_with_post_nf != null) {
                                        click(x, share_with_post_nf.getX() + random(1, 30), share_with_post_nf.getY() + random(1, 10));
                                        x.sleep(random(1000, 3000));
                                        for (int sh = 1; sh < 5; sh++) {
                                            Position share_fb = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
                                            if (share_fb == null) {
                                                x.sleep(random(2000, 3000));
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void changeCover(AutoItX x) throws AWTException, InterruptedException, IOException {
        gotoUrl(x, FACEBOOK_HOMPAGE);
        waitChromeLoaded();
        Position home = new Scanner().scanImageOnAllScreen(image.HOME, 15, 15);
        if (home != null) {
            click(x, home.getX() - 50 + random(1, 15), home.getY() + 5 + random(1, 15));
            x.sleep(random(1000, 2000));
            waitChromeLoaded();
            x.mouseMove(random(418, 864), random(253, 565), random(10, 30));
            x.sleep(random(1000, 2000));
            x.mouseWheel("up", random(5, 6));
            x.sleep(random(2000, 3000));
            Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
            if (fb_symbol != null) {
                click(x, fb_symbol.getX() + 22 + random(1, 15), fb_symbol.getY() + 56 + random(1, 15));
                x.sleep(random(1000, 2000));
                click(x, fb_symbol.getX() + 43 + random(1, 15), fb_symbol.getY() + 123 + random(1, 10));
                x.sleep(random(1000, 2000));
                Position folder_address = new Scanner().scanImageOnAllScreen(image.FOLDER_ADDRESS, 15, 15);
                if (folder_address != null) {
                    click(x, folder_address.getX() - 50 + random(1, 15), folder_address.getY() + random(3, 10));
                    x.sleep(random(1000, 2000));
                    x.send(COVER_IMAGE_FOLDER);
                    x.send("{enter}!n", false);
                    x.sleep(random(1000, 2000));
                    Position file_name = new Scanner().scanImageOnAllScreen(image.FILE_NAME, 15, 15);
                    if (file_name != null) {
                        click(x, file_name.getX() + 150 + random(1, 15), file_name.getY() + random(1, 15));
                        x.sleep(random(500, 1500));
                        x.send("1 (" + random(1, 752) + ")");
                        x.send("{enter}!n", false);
                        x.sleep(random(13000, 16000));
                        Position save = new Scanner().scanImageOnAllScreen(image.COVER_PUBLIC, 15, 15);
                        if (save != null) {
                            click(x, save.getX() + 160 + random(1, 15), save.getY() + random(1, 15));
                            x.sleep(random(5000, 7000));
                        }
                    }
                } else if (folder_address == null) {
                    Position cancel = new Scanner().scanImageOnAllScreen(image.CANCEL, 15, 15);
                    if (cancel != null) {
                        click(x, cancel.getX() + random(1, 15), cancel.getY() + random(1, 15));
                        x.sleep(random(2000, 3000));
                    }
                }
            }
//            fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
//            if (fb_symbol != null) {
//                click(x, fb_symbol.getX() + 5 + random(1, 15), fb_symbol.getY() + 5 + random(1, 15));
//
//                x.sleep(random(1000, 2000));
//
//            }
        }
    }

    public void postOnHome(AutoItX x) throws AWTException, InterruptedException, IOException {
        waitChromeLoaded();
        Position fb_symbol = new Scanner().scanImageOnAllScreen(image.FB_SYMBOL, 20, 20);
        if (fb_symbol == null) {
            gotoUrl(x, FACEBOOK_HOMPAGE);
            waitChromeLoaded();
        }
        Position home = new Scanner().scanImageOnAllScreen(image.HOME, 15, 15);
        if (home != null) {
            click(x, home.getX() - 50 + random(1, 15), home.getY() + 5 + random(1, 15));
            x.sleep(random(1000, 2000));
            waitChromeLoaded();
            Position post_home = new Scanner().scanImageOnAllScreen(image.POST_HOME, 15, 15);
            if (post_home != null) {
                click(x, post_home.getX() + 160 + random(1, 15), post_home.getY() + 40 + random(1, 15));
                x.sleep(random(1000, 2000));
                int quotesorstt = 3;//random(1, 3);
                if (quotesorstt == 2) {
                    String quotes = getLineFromFile(QUOTES, random(1, getFinalLineNumber(QUOTES)));
                    typeMessage(x, quotes);
                    x.sleep(random(1000, 2000));
                    Position post_wall = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                    if (post_wall != null) {
                        click(x, post_wall.getX() + 2 + random(1, 15), post_wall.getY() + 2 + random(1, 10));
                        x.sleep(random(7000, 12000));
                    }
                } else {
                    String status = getLineFromFile(STATUS, random(1, getFinalLineNumber(STATUS)));
                    typeMessage(x, status);
                    x.sleep(random(1000, 2000));
                    int img = 5;// random(1, 10);
                    if (img == 5) {

                        Position post_image_home = new Scanner().scanImageOnAllScreen(image.POST_IMAGE_HOME, 15, 15);
                        if (post_image_home != null) {
                            click(x, post_image_home.getX() + 2 + random(1, 15), post_image_home.getY() + 2 + random(1, 10));
                            x.sleep(random(4000, 5000));
                            Position folder_address = new Scanner().scanImageOnAllScreen(image.FOLDER_ADDRESS, 15, 15);
                            if (folder_address != null) {
                                click(x, folder_address.getX() - 50 + random(1, 15), folder_address.getY() + random(2, 10));
                                x.sleep(random(1000, 2000));
                                x.send(PHOTO_IMAGE_FOLDER);
                                x.send("{enter}!n", false);
                                x.sleep(random(1000, 2000));
                                Position file_name = new Scanner().scanImageOnAllScreen(image.FILE_NAME, 15, 15);
                                if (file_name != null) {
                                    click(x, file_name.getX() + 150 + random(1, 15), file_name.getY() + random(1, 15));
                                    x.sleep(random(500, 1500));
                                    x.send("1 (" + random(1, 556) + ")");
                                    x.send("{enter}!n", false);
                                    x.sleep(random(13000, 16000));
                                }
                            } else if (folder_address == null) {
                                Position cancel = new Scanner().scanImageOnAllScreen(image.CANCEL, 15, 15);
                                if (cancel != null) {
                                    click(x, cancel.getX() + random(1, 15), cancel.getY() + random(1, 15));
                                    x.sleep(random(2000, 3000));
                                }
                            }
                        }
                    }

                    Position post_wall = new Scanner().scanImageOnAllScreen(image.POST_HPBD, 20, 15);
                    if (post_wall != null) {
                        click(x, post_wall.getX() + 2 + random(1, 15), post_wall.getY() + 2 + random(1, 10));
                        x.sleep(random(7000, 12000));
                    }
                }
            }
        }
    }

    public void searchGG(AutoItX x) throws IOException, InterruptedException {
        gotoUrl(x, "google.com");
        x.sleep(random(2000, 3000));
        String search = getLineFromFile(SEARCH, random(1, getFinalLineNumber(SEARCH)));
        typeMessage(x, search);
        x.sleep(random(1000, 2000));
        x.send("{enter}!n", false);
        x.sleep(random(2000, 3000));
        int rdi = random(2, 4);
        for (int i = 1; i < rdi; i++) {
            int ud = random(1, 5);
            if (ud == 2) {
                x.mouseMove(random(500, 800), random(235, 607), random(10, 30));
                x.sleep(random(700, 1500));
                x.mouseWheel("up", random(2, 5));
                x.sleep(random(900, 1600));
            } else {
                x.mouseMove(random(500, 800), random(235, 607), random(10, 30));
                x.sleep(random(700, 1500));
                x.mouseWheel("down", random(2, 5));
                x.sleep(random(900, 1600));
            }
        }

        x.mouseMove(random(500, 800), random(235, 607), random(10, 30));
        x.sleep(random(700, 1500));
        x.mouseWheel("up", random(9, 11));
        x.sleep(random(900, 1600));
        click(x, random(207, 249), random(144, 164));
        int rdj = random(2, 4);
        for (int j = 1; j < rdj; j++) {
            int ud = random(1, 5);
            if (ud == 2) {
                x.mouseMove(random(500, 800), random(235, 607), random(10, 30));
                x.sleep(random(700, 1500));
                x.mouseWheel("up", random(2, 5));
                x.sleep(random(900, 1600));
            } else {
                x.mouseMove(random(500, 800), random(235, 607), random(10, 30));
                x.sleep(random(700, 1500));
                x.mouseWheel("down", random(2, 5));
                x.sleep(random(900, 1600));
            }
        }
        click(x, random(111, 1200), random(300, 639));
        x.sleep(random(1000, 2000));
        click(x, random(924, 964), random(366, 378));
        x.sleep(random(4000, 5000));
        int rdk = random(2, 4);
        for (int k = 1; k < rdk; k++) {
            int ud = random(1, 3);
            if (ud == 2) {
                x.mouseMove(random(500, 800), random(235, 607), random(10, 30));
                x.sleep(random(700, 1500));
                x.mouseWheel("up", random(2, 5));
                x.sleep(random(900, 1600));
            } else {
                x.mouseMove(random(500, 800), random(235, 607), random(10, 30));
                x.sleep(random(700, 1500));
                x.mouseWheel("down", random(2, 5));
                x.sleep(random(900, 1600));
            }
        }
        x.send("{CTRLDOWN}w{CTRLUP}!n", false);
        x.sleep(random(500, 1000));
        x.send("{CTRLDOWN}w{CTRLUP}!n", false);
        x.sleep(random(500, 1000));
        x.send("{CTRLDOWN}w{CTRLUP}!n", false);
        x.sleep(random(1000, 2000));
        click(x, random(600, 976), random(40, 48));
        x.sleep(random(1000, 2000));
    }

    public boolean checkLive(AutoItX x) throws AWTException, InterruptedException, IOException {
        gotoUrl(x, FACEBOOK_HOMPAGE);
        waitChromeLoaded();
        Position home = new Scanner().scanImageOnAllScreen(image.HOME, 15, 15);
        if (home != null) {
            return true;
        }
        return false;
    }

    public void closePin(AutoItX x) throws AWTException, InterruptedException, IOException {
//        click(x, random(700, 820), random(739, 752));
//        x.sleep(random(700, 1000));
        Position close_pin = new Scanner().scanImageOnAllScreen(image.CLOSE_PIN, 10, 10);
        if (close_pin != null) {
            click(x, close_pin.getX() + random(2, 9), close_pin.getY() + random(2, 9));
            x.sleep(random(1000, 2000));

        }
        Position decline_call = new Scanner().scanImageOnAllScreen(image.CLOSE_CALLING, 15, 15);
        if (decline_call != null) {
            click(x, decline_call.getX() + random(1, 15), decline_call.getY() + random(1, 13));
            x.sleep(random(1000, 2000));
        }
        Position close_call = new Scanner().scanImageOnAllScreen(image.DECLINE_CALLING, 15, 15);
        if (close_call != null) {
            click(x, close_call.getX() + random(1, 15), close_call.getY() + random(1, 13));
            x.sleep(random(1000, 2000));
        }

        Position close_mes = new Scanner().scanImageOnAllScreen(image.CLOSE_MES, 10, 10);
        if (close_mes != null) {
            click(x, close_mes.getX() + 175 + random(1, 7), close_mes.getY() - 303 + random(1, 7));
            x.sleep(random(1000, 2000));
        }

        x.mouseMove(random(440, 550), random(258, 359), random(10, 30));
        x.sleep(random(1000, 2000));

    }

    public void closeMesAndCall(AutoItX x) {

    }

    public void testimg(AutoItX x) throws AWTException, InterruptedException, IOException {
//        click(x, random(924, 976), random(366, 378));
        Position happy_birthday = new Scanner().scanImageOnAllScreen(image.CLOSE, 15, 15);
        System.out.println(happy_birthday.getY());
//        int post_type = random(1, 3);//1=post image, 2=normal post, 3=sell
//        System.out.println("p=" + post_type);
//x.send("1 ("+random(1,10)+")");
    }

    public boolean handleSpamWarning(AutoItX x) throws AWTException, IOException, InterruptedException {
        if (checkImageLoaded(image.SPAM_START, 40, 15)) {
            Position p = new Scanner().scanImageOnAllScreen(image.SPAM_START, 40, 15);
            click(x, p.getX() + random(5, 50), p.getY() + random(5, 15));
            x.sleep(1000);
            for (int i = 0; i < 3; i++) {
                waitImageLoaded(image.SPAM_SKIP, 20, 15);
                Position p_skip = new Scanner().scanImageOnAllScreen(image.SPAM_SKIP, 20, 15);
                if (p_skip != null) {
                    click(x, p_skip.getX() + random(5, 50), p_skip.getY() + random(5, 15));
                    x.sleep(1000);
                    x.mouseMove(p_skip.getX() + random(5, 50) + 100, p_skip.getY() + random(5, 15) + 100);
                    x.sleep(1000);
                }
            }
            Position p_done = new Scanner().scanImageOnAllScreen(image.SPAM_DONE, 20, 15);
            if (p_done != null) {
                x.mouseWheel("down", random(15, 20));
                x.sleep(random(4000, 5000));
                click(x, p_done.getX() + random(5, 50), p_done.getY() + random(5, 15));
                x.sleep(random(1000, 2000));
            }
            Thread.sleep(1000);
            gotoUrl(x, FACEBOOK_HOMPAGE);
            return true;
        }
        return false;
    }

    public void gotoUrl(AutoItX x, String link) {
        StringSelection stringSelection = new StringSelection(link);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        click(x, 417 + random(0, 30), 40 + random(0, 5));
        x.sleep(random(1000, 2000));

        x.send("{CTRLDOWN}a{CTRLUP}!n", false);
        x.sleep(1000);
        x.send("{CTRLDOWN}v{CTRLUP}!n", false);
        x.sleep(random(500, 1000));
        x.send("{ENTER}!n", false);
        x.sleep(random(2000, 3000));
        x.send("{ENTER}!n", false);
    }

    public String getUrl(AutoItX x) throws UnsupportedFlavorException, IOException {
        click(x, 217 + random(0, 30), 40 + random(0, 5));
        x.sleep(random(1000, 2000));
        x.send("{CTRLDOWN}c{CTRLUP}!n", false);
        //get postlink from clipboard
        String postlink = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
        System.out.println("getUrl: " + postlink);
        return postlink;
    }

    public void waitImageLoaded(BufferedImage image, int w, int h) throws InterruptedException, AWTException, IOException {
        int loops = 0;
        while (!checkImageLoaded(image, w, h)) {
            Thread.sleep(1000);
            loops++;
            if (loops > 10) {
                break;
            }
        }
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

    public void waitChromeLoaded() throws AWTException, InterruptedException, IOException {
        int w = 1;
        while (!chromeWindowLoaded()) {
            Thread.sleep(1000);
            w++;
            if (w == 15) {
                break;
            }
        }
    }

    public void click(AutoItX auto, int x, int y) {
        auto.mouseClick("left", x, y, 1, random(10, 30));
    }

    public void clickLikeHuman(AutoItX a, int x, int y) {
        a.sleep(3000);
        a.mouseDown("left");

        int iStart_X = a.mouseGetPosX();
        int iStart_Y = a.mouseGetPosY();

        float nIncrement_X = (x - iStart_X) / (y - iStart_Y);
        float nIncrement_Y = (y - iStart_Y) / (x - iStart_X);

        int nMouse_X = iStart_X;
        int nMouse_Y = iStart_Y;
        do {
            nMouse_X += nIncrement_X * (random(0, 1) + 0.5);
            nMouse_Y += nIncrement_Y * (random(0, 1) + 0.5);
            a.mouseMove((int) nMouse_X, (int) nMouse_Y, random(10, 30));
            a.sleep(100);
        } while (nMouse_X >= x || nMouse_Y >= y);
        a.mouseUp("left");
    }

    public int random(int from, int to) {
        if (from == to) {
            return from;
        } else {
            from = from - 1;
            Random rand = new Random();
            int n = rand.nextInt(to - from) + 1;
            return from + n;
        }
    }

    public void removeGroupFromDB(int profileNum, String groupId) throws IOException {
        java.io.File f = new java.io.File(GlobalVars.TXT_FOLDER + "groupid.txt");
        List<String> lines = FileUtils.readLines(f);
        List<String> updatedLines = lines.stream().filter(s -> !s.contains(groupId)).collect(Collectors.toList());
        FileUtils.writeLines(f, updatedLines, false);
    }

    static final String SIMPLE = "qwertyuiopadfghjklzxcvbnmABCDEFGHIJKLMNOPQRSTUVXY";
    static SecureRandom rnd = new SecureRandom();

    public String randomSimpleString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(SIMPLE.charAt(rnd.nextInt(SIMPLE.length())));
        }
        return sb.toString();
    }

    public void typeMessage(AutoItX x, String s) throws InterruptedException {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            x.send(String.valueOf(chars[i]));
            int delay = random(100, 300);
            x.sleep(delay);
            Thread.sleep(delay);
        }
    }
}
