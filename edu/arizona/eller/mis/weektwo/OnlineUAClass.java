package edu.arizona.eller.mis.weektwo;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 9/3/13
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class OnlineUAClass extends UAClass{
    String onlineTAFirstName;
    String onlineTALastName;

    public OnlineUAClass(){
        super();
    }

    public String getOnlineTAFirstName() {
        return onlineTAFirstName;
    }

    public void setOnlineTAFirstName(String onlineTAFirstName) {
        this.onlineTAFirstName = onlineTAFirstName;
    }

    public String getOnlineTALastName() {
        return onlineTALastName;
    }

    public void setOnlineTALastName(String onlineTALastName) {
        this.onlineTALastName = onlineTALastName;
    }
}
