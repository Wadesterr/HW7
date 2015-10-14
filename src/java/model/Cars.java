/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Wade
 */
public class Cars {
    
    private int vinID;
    private int year;
    private String make;
    private String model;
    private String color;
    
    
    public Cars() {
        this.vinID = 0;
        this.year = 0;
        this.make = "";
        this.model = "";
        this.color = "";
    }
    
    
    

    public Cars(int vinID, int year, String make, String model, String color) {
        this.vinID = vinID;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public int getVinID() {
        return vinID;
    }

    public void setVinID(int vinID) {
        this.vinID = vinID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cars{" + "vinID=" + vinID + ", year=" + year + ", make=" + make + ", model=" + model + ", color=" + color + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
