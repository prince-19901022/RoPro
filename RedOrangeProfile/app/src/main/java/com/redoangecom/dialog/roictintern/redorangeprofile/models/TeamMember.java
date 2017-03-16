package com.redoangecom.dialog.roictintern.redorangeprofile.models;


/**
 * Created by roictintern on 11-Dec-16.
 */

public class TeamMember {
    public String getmImgPath() {
        return mImgPath;
    }

    public void setmImgPath(String mImgPath) {
        this.mImgPath = mImgPath;
    }

    private String mImgPath;
    private int memName;
    private int memDesig;
    private int memDescription;



    public int getMemName() {
        return memName;
    }

    public void setMemName(int memName) {
        this.memName = memName;
    }

    public int getMemDesig() {
        return memDesig;
    }

    public void setMemDesig(int memDesig) {
        this.memDesig = memDesig;
    }

    public int getMemDescription() {
        return memDescription;
    }

    public void setMemDescription(int memDescription) {
        this.memDescription = memDescription;
    }
}
