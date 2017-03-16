package com.redoangecom.dialog.roictintern.redorangeprofile.models;

/**
 * Created by roictintern on 14-Dec-16.
 */

public class OurClient {

    private int logoId;
    private int urlId;

    public OurClient(int logoId, int urlId) {
        this.logoId = logoId;
        this.urlId = urlId;
    }

    public int getLogoId() {
        return logoId;
    }

    public int getUrlId() {
        return urlId;
    }
}
