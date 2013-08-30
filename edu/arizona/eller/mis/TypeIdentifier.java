package edu.arizona.eller.mis;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/26/13
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TypeIdentifier {
    public static void main(String args[]){
        testType(Integer.class);
        testType(int.class);
    }

    private static void testType(Class<?> c){
        System.out.println(c.isPrimitive());
    }
}
