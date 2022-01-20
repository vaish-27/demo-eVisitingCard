package com.example.helloapp;

import com.google.gson.annotations.SerializedName;

public class CompanyModelClass {

    @SerializedName("name")
    private String cname;
    private String catchPhrase;
    private String bs;

    public CompanyModelClass(String cname, String catchPhrase, String bs) {
        this.cname = cname;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getCname() {
        return cname;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
