package src;

import java.util.ArrayList;
import java.util.List;

public class course{
    private String coursecode;
    private static String title;
    private String professor;
    private int credits;
    private String prereq;
    private String timings;
    private String location;
    private String syllabus;
    private String officehours;
    private int enrollmentlimit;
    private List<student> enrolledstudents;

    public course(String coursecode, String title, String professor, int credits, String prereq, String timings, String location) {
        this.coursecode= coursecode;
        this.title =title;
        this.professor=professor;
        this.credits=credits;
        this.prereq=prereq;
        this.timings=timings;
        this.location = location;
        this.enrolledstudents= new ArrayList<>();
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public String getsyllabus(){
        return syllabus;
    }

    public void setsyllabus(String syllabus){
        this.syllabus=syllabus;
    }


    public String getofficehours() {
        return officehours;
    }

    public void setofficehours(String officehours) {
        this.officehours = officehours;
    }

    public int getenrollmentlimit(){
        return enrollmentlimit;
    }

    public void setenrollmentlimit(int enrollmentlimit){
        this.enrollmentlimit= enrollmentlimit;
    }

    public List<student> getenrolledstudents(){
        return enrolledstudents;
    }

    public void enrolledstudents(student stud){
        if(enrolledstudents.size() < enrollmentlimit){
            enrolledstudents.add(stud);
        }
        else{
            System.out.println("Enrollment limit exceeded");
        }
    }

    public void addStudent(student s){
        this.enrolledstudents(s);
    }



    @Override
    public String toString() {
        return String.format("Course Code: %s\nTitle: %s\nProfessor: %s\nCredits: %d\nPrerequisites: %s\nTimings: %s\nLocation:%s\n", coursecode, title, professor, credits, prereq, timings, location);
    }

    public char[] getCode() {
        return new char[0];
    }



}


