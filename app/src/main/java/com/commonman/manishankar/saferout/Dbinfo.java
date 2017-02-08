package com.commonman.manishankar.saferout;

/**
 * Created by MANISHANKAR on 8/31/2016.
 */
public class Dbinfo {
    private String username;
    private Double latti;
    private Double longi;
    private int crimerate;
    private int lightrate;
    private int roadrate;

    public Dbinfo(String username,Double latti,Double longi,int crimerate,int lightrate,int roadrate){
        this.setCrimerate(crimerate);
        this.setRoadrate(roadrate);
        this.setUsername(username);
        this.setLatti(latti);
        this.setLongi(longi);
        this.setLightrate(lightrate);

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getLatti() {
        return latti;
    }

    public void setLatti(Double latti) {
        this.latti = latti;
    }

    public Double getLongi() {
        return longi;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    public int getCrimerate() {
        return crimerate;
    }

    public void setCrimerate(int crimerate) {
        this.crimerate = crimerate;
    }

    public int getLightrate() {
        return lightrate;
    }

    public void setLightrate(int lightrate) {
        this.lightrate = lightrate;
    }

    public int getRoadrate() {
        return roadrate;
    }

    public void setRoadrate(int roadrate) {
        this.roadrate = roadrate;
    }
}
