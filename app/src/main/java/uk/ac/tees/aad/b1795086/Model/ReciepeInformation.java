package uk.ac.tees.aad.b1795086.Model;

import java.util.ArrayList;

public class ReciepeInformation {

    String Information;
    String Summry;
    String ImagePath;
    String Counsine;
    String TimeRequired;
    String Gluten;
    String Veg;
    String Dairy;
    String Description;


    public ReciepeInformation(String information, String summry, String imagePath, String counsine, String timeRequired, String gluten, String veg,String dairy, String description) {
        Information = information;
        Summry = summry;
        ImagePath = imagePath;
        Counsine = counsine;
        TimeRequired = timeRequired;
        Gluten = gluten;
        Veg = veg;
        Dairy = dairy;
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getGluten() {
        return Gluten;
    }

    public void setGluten(String gluten) {
        Gluten = gluten;
    }

    public String getVeg() {
        return Veg;
    }

    public void setVeg(String veg) {
        Veg = veg;
    }

    public String getDairy() {
        return Dairy;
    }

    public void setDairy(String dairy) {
        Dairy = dairy;
    }

    public String getTimeRequired() {
        return TimeRequired;
    }

    public void setTimeRequired(String timeRequired) {
        TimeRequired = timeRequired;
    }

    public String getCounsine() {
        return Counsine;
    }

    public void setCounsine(String counsine) {
        Counsine = counsine;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }


    public String getSummry() {
        return Summry;
    }

    public void setSummry(String summry) {
        Summry = summry;
    }


}
