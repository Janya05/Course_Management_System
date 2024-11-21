package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class student {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phonenumber;
    private List<course> courses;
    private List<String> grades;
    private List<String> coursescompleted;
    private List<complaint> complaints;


    public student(String id, String name, String email, String password) {
        this.id = id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.phonenumber=phonenumber;
        this.courses = new ArrayList<>();
        this.grades= new ArrayList<>();
        this.coursescompleted= new ArrayList<>();
        this.complaints= new ArrayList<>();
    }



    // Getter for student ID
    public String getId() {
        return id;
    }

    // Setter for student ID
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Getter and Setter for emailId
    public String getEmailId() {
        return email;
    }

    public void setEmailId(String email) {
        this.email= email;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    // Getter and Setter for phoneNumber
    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phonenumber;
    }

    // Getter for the list of courses the student is registered in
    public List<course> getCourses() {
        return courses;
    }

    // Method to add a course to the student's list of courses
    public void addCourse(course course) {
        this.courses.add(course);
    }

    public void viewschedule(){
        for(course c: courses){
            System.out.println((c));
        }
    }

    public void Coursecompleted(String courseTitle, String grade){
        this.coursescompleted.add(courseTitle);
        this.grades.add(grade);
    }

    public double  calcGPA(){
        if(grades.isEmpty()){
            return 0.0;
        }

        double total= 0.0;
        for(String gr:grades){
            total= total+ gradetopoints(gr);
        }
        return total/grades.size();
    }

    private double gradetopoints(String grade){
        if(Objects.equals(grade, "A")){
            return 10.0;
        }
        else if(Objects.equals(grade, "A-")){
            return 9.0;
        }
        else if(Objects.equals(grade, "B")){
            return 8.0;
        }
        else if(Objects.equals(grade, "B-")){
            return 7.0;
        }
        else if(Objects.equals(grade, "C")){
            return 6.0;
        }
        else if(Objects.equals(grade, "C-")){
            return 5.0;
        }
        else if(Objects.equals(grade, "D")){
            return 4.0;
        }
        else {
            return 0.0;
        }
    }

    public void viewcCoursescompleted(){
        for(int i=0; i< coursescompleted.size(); i++){
            System.out.println(("Course:" + coursescompleted.get(i) + " Grade:" + grades.get(i)));
        }
    }



    public void submitComplaint(String description){
        complaint comp= new complaint(this.id, description);
        complaints.add(comp);
        System.out.println("Complaint submitted");
    }

    public void viewcomplaints(){
        if(complaints.isEmpty()){
            System.out.println("No complaints");
        }
        else{
            for(complaint c:complaints){
                System.out.println((c));
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder courseList = new StringBuilder();
        for (course c : courses) {
            courseList.append(c.getTitle()).append(" (").append(c.getCode()).append("), ");
        }
        if (courseList.length() > 0) {
            courseList.setLength(courseList.length() - 2);  // Remove trailing comma and space
        }
        return "Student ID: " + id + ", Name: " + name + ",Email:" + email ;
    }
}


