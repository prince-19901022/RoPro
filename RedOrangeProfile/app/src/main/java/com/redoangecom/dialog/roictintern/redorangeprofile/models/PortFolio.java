package com.redoangecom.dialog.roictintern.redorangeprofile.models;

/**
 * Created by roictintern on 01-Jan-17.
 */

public class PortFolio {

    private String bannerPath;
    private String thumbnailPath;
    private int header;
    private int desc;
    private int siteURL;
    private int videoURL;
    private String tag;
    private int generalDesc;

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    public int getSiteURL() {
        return siteURL;
    }

    public void setSiteURL(int siteURL) {
        this.siteURL = siteURL;
    }

    public int getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(int videoURL) {
        this.videoURL = videoURL;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getGeneralDesc() {
        return generalDesc;
    }

    public void setGeneralDesc(int generalDesc) {
        this.generalDesc = generalDesc;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }
}
