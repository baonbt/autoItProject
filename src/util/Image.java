/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import static util.GlobalVars.KEY_IMAGE_FOLDER;

/**
 *
 * @author Administrator
 */
public class Image {

    BufferedImage FB;
    BufferedImage JOIN_GROUP;
    BufferedImage LIKE_NF;
    BufferedImage SHARE_NF;
    BufferedImage CMT_NF;
    BufferedImage SHARE_NOW;
    BufferedImage SHARE_WITH;
    BufferedImage SPAM_START;
    BufferedImage SPAM_SKIP;
    BufferedImage SPAM_DONE;
    BufferedImage NEW_NOTIFICATION;
    BufferedImage ACCEPT_FRIEND_REQUEST;
    BufferedImage CHECK_NOTIFICATION;
    BufferedImage NEW_MESSAGE;
    BufferedImage CLOSE_MESSAGER_BOX;
    BufferedImage CLOSE_MESSAGER_BOX2;
    BufferedImage CHECK_INBOX;
    BufferedImage LIKE_PAGE;
    BufferedImage LOVE_NF;
    BufferedImage STICKER_NF;
    BufferedImage INBOX_MSG;
    BufferedImage WRITE_IMAGE_DESK;
    BufferedImage WRITE_POST_DESK;
    BufferedImage WRITE_SELL_DESK;
//    BufferedImage POST_DESK;
    BufferedImage RIGHT_NOW;
//    //happybirthday
    BufferedImage HAPPY_BIRTHDAY;
    BufferedImage HAPPY_BIRTHDAY_ADD_PHOTO;
    BufferedImage HAPPY_BIRTHDAY_UPLOAD_PHOTO;
    BufferedImage FOLDER_ADDRESS;
    BufferedImage FILE_NAME;
//    //shop
    BufferedImage SHOPPING;
    BufferedImage GO_TO_SHOP;
    BufferedImage CLOSE;
    BufferedImage FB_SYMBOL;
//    //accept friend
    BufferedImage FRIEND_INVITES;
    BufferedImage FRIEND_INVITES_ADD;
    BufferedImage FRIEND_INVITES_ACCEPT;
    BufferedImage LIVE_VIDEO;
    BufferedImage GAME;
    BufferedImage SETTING;
    BufferedImage COVER_PUBLIC;
    BufferedImage POST_HOME;
    BufferedImage POST_IMAGE_HOME;
    BufferedImage POST_HPBD;
    BufferedImage HOME;
    BufferedImage CANCEL;
    BufferedImage CLOSE_PIN;
    BufferedImage CLOSE_MES;
    BufferedImage CLOSE_CALLING;
    BufferedImage DECLINE_CALLING;
    BufferedImage LEAVE;
    BufferedImage SHARE_YT;
    BufferedImage SHARE_YT_FB;
    BufferedImage SHARE_YT_SYMBOL;
    BufferedImage SHARE_YT_POST;
    BufferedImage SHARE_YT_TRIANGLE;
    BufferedImage SHARE_YT_GROUP;
    BufferedImage ADD_PHOTO_GROUP;
    BufferedImage PENDING;
    BufferedImage SUBMITTED_ADMIN;
    

    public void loadImage() throws IOException {
        FB = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\fb.png"));
        JOIN_GROUP = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\join_group.png"));
////        POST_MOBILE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\post_mobile.png"));
////        WRITE_STH_MOBILE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\write_sth_mobile.png"));
//        RIGHT_NOW = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\right_now.png"));
        LIKE_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\like_nf.png"));
        LOVE_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\love_nf.png"));
        SHARE_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_nf.png"));
        SHARE_NOW = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_now.png"));
        SHARE_WITH = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_with.png"));
        CMT_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\cmt_nf.png"));
//        WHAT_ARE_YOU_THINKING = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\what_are_you_thinking.png"));
 
        POST_HPBD = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\post_hpbd.png"));
//        CONTENT_NOT_AVAILABLE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\content_not_available.png"));
//        RIGHT_NOW_2 = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\right_now_2.png"));
        SPAM_START = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\spam_start.png"));
        SPAM_SKIP = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\spam_skip.png"));
        SPAM_DONE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\spam_done.png"));
        NEW_NOTIFICATION = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\new_notification.png"));
        CHECK_NOTIFICATION = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\check_notification.png"));
        ACCEPT_FRIEND_REQUEST = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\accept_friend_request.png"));
        NEW_MESSAGE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\new_message.png"));
//        NEW_MESSAGE2 = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\new_message2.png"));
//        OLD_MESSAGE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\old_message.png"));
        CLOSE_MESSAGER_BOX = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\close_messager_box.png"));
        CLOSE_MESSAGER_BOX2 = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\close_messager_box2.png"));
        CHECK_INBOX = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\check_inbox.png"));
        LIKE_PAGE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\like_page.png"));
//        LOVE_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\love_nf.png"));
        STICKER_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\sticker_nf.png"));
//        SHARE_WITH_POST_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_with_post_nf.png"));
        INBOX_MSG = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\inbox_msg.png"));
//        CLOSE_BROWSER = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\close_browser.png"));
        WRITE_IMAGE_DESK = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\write_image_desk.png"));
        WRITE_POST_DESK = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\write_post_desk.png"));
        WRITE_SELL_DESK = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\write_sell_desk.png"));
//        POST_DESK = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\post_desk.png"));
        RIGHT_NOW = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\right_now.png"));
//        //HAPPY BIRTHDAY
        HAPPY_BIRTHDAY = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\happy_birthday.png"));
        HAPPY_BIRTHDAY_ADD_PHOTO = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\happy_birthday_add_photo.png"));
        HAPPY_BIRTHDAY_UPLOAD_PHOTO = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\happy_birthday_upload_photo.png"));
        FOLDER_ADDRESS = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\folder_address.png"));
        FILE_NAME = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\file_name.png"));
//        //shop
        SHOPPING = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\shopping.png"));
        GO_TO_SHOP = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\go_to_shop.png"));
        CLOSE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\close.png"));
        FB_SYMBOL = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\fb_symbol.png"));
//        //FRIEND_INVITEs
        FRIEND_INVITES = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\friend_invites.png"));
//        FRIEND_INVITES_1 = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\friend_invites_1.png"));
        FRIEND_INVITES_ADD = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\friend_invites_add.png"));
        FRIEND_INVITES_ACCEPT = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\friend_invites_accept.png"));
//        //live video
        LIVE_VIDEO = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\live_video.png"));
//        //INTERACT
        SHARE_NOW = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\SHARE_NOW.png"));
//        SHARE_NOW_LOVE_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\SHARE_NOW_LOVE_NF.png"));
        SHARE_WITH = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\SHARE_WITH.png"));
//        SHARE_WITH_LOVE_NF = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\SHARE_WITH_LOVE_NF.png"));
//        //GAME
        GAME = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\game.png"));
//        //activity
        SETTING = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\setting.png"));
//        //COVER
        COVER_PUBLIC = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\cover_public.png"));
        POST_HOME = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\post_home.png"));
        POST_IMAGE_HOME = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\post_image_home.png"));
        HOME = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\home.png"));
        CANCEL = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\cancel.png"));
        CLOSE_PIN = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\close_pin.png"));
        CLOSE_MES = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\close_mes.png"));
        CLOSE_CALLING = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\close_calling.png"));
        DECLINE_CALLING = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\decline_calling.png"));
        LEAVE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\leave.png"));
        SHARE_YT = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_yt.png"));
        SHARE_YT_FB = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_yt_fb.png"));
        SHARE_YT_SYMBOL = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_yt_fb_symbol.png"));
        SHARE_YT_POST = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_yt_fb_post.png"));
        SHARE_YT_TRIANGLE = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_yt_triangle.png"));
        SHARE_YT_GROUP = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\share_yt_fb_group.png"));
        ADD_PHOTO_GROUP = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\add_photo_group.png"));
        PENDING = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\pending.png"));
        SUBMITTED_ADMIN = ImageIO.read(new java.io.File(KEY_IMAGE_FOLDER + "\\submitted_admin.png"));
    }

    public boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
