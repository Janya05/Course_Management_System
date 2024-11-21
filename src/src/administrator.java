package src;

import java.util.ArrayList;
import java.util.List;


public class administrator {
    private String id;
    private String email;
    private static String password= "fixed";
    private static List<course> availablecourses;
    private static List<student> studentrec;
    private List<complaint> complaints;

    public administrator(String id, String email, String password){
        this.id=id;
        this.email=email;
        this.password=password;
        this.availablecourses= new ArrayList<>();
        this.studentrec= new ArrayList<>();
        this.complaints= new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public static String getPassword(){
        return password;
    }


    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public static void viewcourses(){
        System.out.println("Course Catalog");
        if(availablecourses.isEmpty()){
            System.out.println("No courses available");
        }
        else{
            for(course c:availablecourses){
                System.out.println(c.getTitle());
            }
        }

    }

    public void addcourses(course newcourse){
        availablecourses.add(newcourse);
        System.out.println((newcourse.getTitle() + "is added"));
    }

    public void deletecourses(course coursedel){
        if(availablecourses.remove(coursedel)){
            System.out.println(coursedel.getTitle() + "is deleted");
        }
        else{
            System.out.println("Course not found");
        }
    }

    public static void viewstudentrecords(List<student> students){
        for(student c: studentrec){
            System.out.println(c);
        }
    }

    public void updaterecords( student sname, String info){
        System.out.println(sname.getId() + "has been updated");
    }

    public void updategrade( student sname,  course course, String grade){
        sname.Coursecompleted(course.getTitle(), grade);
        System.out.println(sname.getId() + "'s marks has been update for course" + course.getTitle());
    }

    public void updateinfo( student sname, String pinfo){

    }

    public static void assignprofessor(professors professor, course course){
        professor.addCourse(course);
        System.out.println(professor.getId() + "has been assigned to" + course.getTitle());
    }

    public static void viewcomp(List<complaint> complaints){
        for(complaint c:complaints){
            System.out.println((c));
        }
    }

    public void update(complaint comp, String status){
        comp.setStatus(status);
        System.out.println("complaint status" + status);
    }

    public void filterstatus(List<complaint> comp, String status){
        System.out.println("filtered complaints by status");
        for(complaint c: comp){
            if(c.getStatus().equals(status)){
                System.out.println((c));
            }
        }
    }

    public void filterdate(List<complaint> comp, String date){
        System.out.println("filtered complaints by date");
        for(complaint c: comp){
            if(c.getDate().equals(date)){
                System.out.println(c);
            }
        }
    }

    public void addcomplaint(complaint comp){
        complaints.add(comp);
        System.out.println("complaint added");
    }
    @Override
    public String toString(){
        return "Admin ID" + id + "Email" + email;
    }

}

