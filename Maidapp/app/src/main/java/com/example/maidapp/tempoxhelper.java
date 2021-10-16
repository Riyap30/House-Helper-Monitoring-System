package com.example.maidapp;

public class tempoxhelper {
 String soci, temperature, oxyg;

public tempoxhelper(){

}
    public tempoxhelper( String soci, String temperature, String oxyg) {

this.soci =soci;
        this.temperature = temperature;
        this.oxyg = oxyg;
        
    }

    public String getsoci() {
        return soci;
    }

    public void setsoci(String soci) {
        this.soci = soci;
    }
    public String gettemperature() {
        return temperature;
    }

    public void settemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getoxyg() {
        return oxyg;
    }

    public void setoxyg(String oxyg) {
        this.oxyg = oxyg;
    }
}

   
