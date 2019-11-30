package com.example.triphelper.struct;

public class ShortDescription {
    int imageId;
    String name;
    String shortDectiprion;
    boolean isChecked = false;
    public ShortDescription(int imageId, String name, String shortDectiprion, boolean isChecked){
        this.imageId = imageId;
        this.name = name;
        this.shortDectiprion = shortDectiprion;
        this.isChecked = isChecked;
    }
    public int getImageId(){
        return imageId;
    }
    public String getName(){
        return name;
    }
    public String getShortDectiprion(){
        return shortDectiprion;
    }
    public boolean getIsChecked(){
        return isChecked;
    }
    public void setImageId(int imageId){
        this.imageId = imageId;}
    public void setName(String name){
        this.name = name;
    }
    public void setShortDectiprion(String shortDectiprion){
        this.shortDectiprion = shortDectiprion;
    }
    public void setIsChecked(boolean isChecked){
        this.isChecked = isChecked;}
}
