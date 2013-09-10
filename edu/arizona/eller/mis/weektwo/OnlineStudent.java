package edu.arizona.eller.mis.weektwo;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 9/3/13
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class OnlineStudent extends Student{
    String currentLocation;
    String currentAffiliation;

    public OnlineStudent(){
        super();
        currentAffiliation = "Eller College";
        currentLocation = "Online";
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getCurrentAffiliation() {
        return currentAffiliation;
    }

    public void setCurrentAffiliation(String currentAffiliation) {
        this.currentAffiliation = currentAffiliation;
    }

    @Override
    protected String calculateGpa(){
        return super.calculateGpa() + " -- RECEIVED FROM: " + this.currentAffiliation + ", " + this.currentLocation;
    }
}
