/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Command {

    String linkYtb;
    String linkWeb;
    String target;
    String updateParam;
    boolean updateDB;
    boolean skip;

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }

    public String getLinkYtb() {
        return linkYtb;
    }

    public void setLinkYtb(String linkYtb) {
        this.linkYtb = linkYtb;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUpdateParam() {
        return updateParam;
    }

    public void setUpdateDB(boolean updateDB) {
        this.updateDB = updateDB;
    }

    public boolean isUpdateDB() {
        return updateDB;
    }

    public void setUpdateParam(String updateParam) {
        this.updateParam = updateParam;
    }

}
