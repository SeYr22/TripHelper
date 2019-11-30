package com.example.triphelper.struct;

public class LongDescription {
    String name, longDescription, adress;
    int imageID;
    public LongDescription(String name, String longDescription, String adress, int imageID){
        this.name = name;
        this.longDescription = longDescription;
        this.adress = adress;
        this.imageID = imageID;
    }
   public void setName(String name){
        this.name = name;
    }
    public    void setLongDescription(String longDescription){
        this.longDescription = longDescription;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    public void setImageID(int imageID){
        this.imageID = imageID;
    }
    public String getName(){
        return name;
    }
    public  String getLongDescription(){
        return  longDescription;
    }
    public   String getAdress(){
        return adress;
    }
    public  int getImageID(){
        return imageID;
    }

}
