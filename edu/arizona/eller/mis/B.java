package edu.arizona.eller.mis;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/26/13
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class B {
    private int value;
    public B () {
        value = 3;
    }
    public int getD() {
        return 2 * value;
    }
    public void setV(int v) {
        value = v + value;
    }

    public static void main(String[] args) {
        int value = 3;
        B mymy = new B();  //create instance of self
        mymy.setV(value);  //call setV and pass it 3. This will assign value = to 3 + 3 in mymy.
        System.out.println(value + mymy.getD()); //value is currently 3 on the running instance. mymy.getD() will return  2*6. Together, they equal 15.
    }

}
