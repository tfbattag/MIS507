package edu.arizona.eller.mis.weektwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 9/3/13
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    String firstName;
    String lastName;
    String departmentIn;
    int yearGraduation;
    List<UAClass> classList;

    public Student(){
        classList =   new ArrayList<UAClass>();
        firstName = "Kellie";
        lastName = "Johnson";
        classList.add(0, new UAClass());
        classList.add(1, new UAClass());

        classList.get(0).setGradeEarned(4);
        classList.get(0).setNumCredits(3);
        classList.get(1).setGradeEarned(3.7);
        classList.get(1).setNumCredits(5);
    }

    public static void main(String args[]){
        Student student = new Student();
        OnlineStudent onlineStudent = new OnlineStudent();
        System.out.println("GPA for: " + student.firstName + " " + student.lastName + " is " + student.calculateGpa());
        System.out.println("GPA for: " + onlineStudent.firstName + " " + onlineStudent.lastName + " is " + onlineStudent.calculateGpa());
    }

    protected String calculateGpa(){
        double gpa = 0;
        double cumulativeGrade = 0;
        int attemptedUnits = 0;

        for(UAClass uaClass : classList){
            cumulativeGrade += uaClass.getGradeEarned() * uaClass.getNumCredits();
            attemptedUnits += uaClass.getNumCredits();
        }
        return String.valueOf(cumulativeGrade/attemptedUnits);
    }


}
