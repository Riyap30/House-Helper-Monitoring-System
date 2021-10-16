package com.example.maidapp;

public class memberhelper {

    String namemem,citymem,socmem,phonemem,passmem;

    public memberhelper() {

    }

    public memberhelper(String namemem, String citymem, String socmem, String phonemem, String passmem) {
        this.namemem = namemem;
        this.citymem = citymem;
        this.socmem = socmem;
        this.phonemem = phonemem;
        this.passmem = passmem;
    }

    public String getNamemem() {
        return namemem;
    }

    public void setNamemem(String namemem) {
        this.namemem = namemem;
    }

    public String getCitymem() {
        return citymem;
    }

    public void setCitymem(String citymem) {
        this.citymem = citymem;
    }

    public String getSocmem() {
        return socmem;
    }

    public void setSocmem(String socmem) {
        this.socmem = socmem;
    }

    public String getPhonemem() {
        return phonemem;
    }

    public void setPhonemem(String phonemem) {
        this.phonemem = phonemem;
    }

    public String getPassmem() {
        return passmem;
    }

    public void setPassmem(String passmem) {
        this.passmem = passmem;
    }
}
