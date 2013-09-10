package edu.arizona.eller.mis.weektwo;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 9/3/13
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class UAClass {
    String teacherFirstName;
    String teacherLastName;
    int semesterOffered;
    int numCredits;
    double gradeEarned;

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public int getSemesterOffered() {
        return semesterOffered;
    }

    public void setSemesterOffered(int semesterOffered) {
        this.semesterOffered = semesterOffered;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        this.numCredits = numCredits;
    }

    public double getGradeEarned() {
        return gradeEarned;
    }

    public void setGradeEarned(double gradeEarned) {
        this.gradeEarned = gradeEarned;
    }
}
