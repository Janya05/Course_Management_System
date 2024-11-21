import src.*;
import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Coursefullexception {
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;

        while (choice) {
            System.out.println("Welcome to IIIT Course Registration System");
            System.out.println("1. Enter the Application ");
            System.out.println("2.  Exit the Application ");
            System.out.println(" Choose 1 or 2 ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                enterapp(scanner);
            } else if (option == 2) {
                System.out.println("Exiting the application");
                choice = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
        scanner.close();
    }

    private static void enterapp(Scanner scanner) throws Coursefullexception {
        System.out.println("Login as:");
        System.out.println("1. Student");
        System.out.println("2. Professor");
        System.out.println("3. Administrator");
        System.out.println("4. Teaching Assistant");
        System.out.println("5. Return to Main Menu");

        int useroption = scanner.nextInt();
        scanner.nextLine();

        if (useroption == 1) {
            studentLogin(scanner);
        } else if (useroption == 2) {
            professorLogin(scanner);
        } else if (useroption == 3) {
            adminLogin(scanner);
        } else if (useroption == 4) {
            TAlogin(scanner, ta);
        } else if (useroption == 5) {
            System.out.println("Returning to Main Menu");
        } else {
            System.out.println("Invalid Choice");
        }
    }

    private static void studentLogin(Scanner scanner) throws Coursefullexception {
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            studentSignup(scanner);
        } else if (choice == 2) {
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            student stud = authenticateStudent(email, password);
            if (stud != null) {
                System.out.println("Login successful!");
                studentmain(scanner, students);
            } else {
                System.out.println("Invalid credentials.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void studentSignup(Scanner scanner) {
        System.out.println("Enter your id:");
        String id = scanner.nextLine();
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Create a password:");
        String password = scanner.nextLine();
        students.add(new student(id, name, email, password));
        System.out.println("Signup successful! You can now log in.");
    }

    private static student authenticateStudent(String email, String password) {
        for (student stud : students) {
            if (stud.getEmailId().equals(email) && stud.getPassword().equals(password) && stud.getEmailId() != null && stud.getPassword() != null) {
                return stud;
            }
        }
        return null;
    }


    private static List<student> students = new ArrayList<>();
    private static List<professors> professor = new ArrayList<>();
    private static List<complaint> complaints = new ArrayList<>();
    private static List<course> availablecourses = new ArrayList<>();
    private static List<administrator> admins = new ArrayList<>();
    feedbackmanager feedbmanager = new feedbackmanager();
    private static List<TA> ta = new ArrayList<>();

    static {
        availablecourses.add(new course("SPP201", "Sociology", "Arohan Jain", 4, " None", "MF 12:30-2", "C101", LocalDate.of(2024,10,10), 2));
        availablecourses.add(new course("SNS132", "Signals and Systems", "Anubha Gupta", 4, "Linear Algebra", "TF 4:30-6", "C102", LocalDate.of(2024,10,1),3));
        availablecourses.add(new course("ELD102", "Embedded Logic Design", "Sumit Darak", 4, " None", "WTH 4:30-6", "C201",LocalDate.of(2024,11,3),5));
        availablecourses.add(new course("CTD203", "Circuit Theory and Devices", "Pragya Kosta", 4, " None", "MTh 8:30-10", "C01",LocalDate.of(2024,10,20),4));
        availablecourses.add(new course("OS103", "Operating Systems", "Arun Balaji", 4, " None", "MW 8:30-10", "C10",LocalDate.of(2024,10,30), 5));
        availablecourses.add(new course("CSE112", "Advanced Programming", "Sambuddho Chakravarty", 4, " None", "TTh 12:30-2", "B006",LocalDate.of(2024,11,8),8));
        availablecourses.add(new course("MTH101", "Multivariate Calculus", "Satish Pandey", 4, " None", "MW 4:30-6", "B007",LocalDate.of(2024,12,2), 0));

        students.add(new student("2023123 ", "abc", "abc@iiitd.com", "abc@1234"));
        students.add(new student("2021345", "janya", "janya@iiitd.ac.in", "Janya@1234"));
        students.add(new student("2022232 ", "parth", "parth@iiitd.ac.in", "Parth@2024"));

        professor.add(new professors("professor1", "Anubha Gupta", "aaa@iiitd.edu.in", "aaa@1234", "Multivariate Calculus"));
        professor.add(new professors("professor2", "Arun Balaji", "arun@iiitd.edu.in", "Arun@1234", "Operating Systems"));

        admins.add(new administrator("admin1", "admin1@iiitd.ac.in", "admin@123"));

        ta.add(new TA("1", "ta1", "ta1@iiitd.ac.in", "ta1234"));
    }


    private static void studentmain(Scanner scanner, List<student> Student) throws Coursefullexception {
        boolean stayin = true;
        while (stayin) {
            System.out.println("Student:");
            System.out.println("1.View Available Courses");
            System.out.println("2.Register for Courses");
            System.out.println("3.View Schedule");
            System.out.println("4.Academic Progress");
            System.out.println("5.Drop Courses");
            System.out.println("6.Submit Complaints");
            System.out.println("7. Submit feedback");
            System.out.println("8.Logout");

            int studentoption = scanner.nextInt();
            scanner.nextLine();


            student stud = findstudent("2021345");
            if (studentoption == 1) {
                viewavailablecourses();
            } else if (studentoption == 2) {
                registerforcourses(scanner, stud);
            } else if (studentoption == 3) {
                assert stud != null;
                viewschedule(stud);
            } else if (studentoption == 4) {
                assert stud != null;
                academicprogress(stud);
            } else if (studentoption == 5) {
                dropCourse(scanner, stud);

            } else if (studentoption == 6) {
                assert stud != null;
                submitcomplaints(scanner, stud);

            } else if (studentoption == 7) {
                assert stud != null;
                System.out.println("Enter course for which you want to give feedback");
                String courseTitle = scanner.nextLine();


                System.out.println("Enter textual feedback ");
                String comment = scanner.nextLine();
                feedbackmanager.addFB(stud.getId(), courseTitle, comment);


                System.out.println("Enter rating from (1-5)");
                String rating = scanner.nextLine();
                feedbackmanager.addFB(stud.getId(), courseTitle, rating);


                System.out.println("Feedback submitted!");
            } else if (studentoption == 8) {
                System.out.println("Logging out");
                enterapp(scanner);
            } else {
                System.out.println("Invalid Choice");
            }
        }


    }

    private static void viewavailablecourses() {
        System.out.println("Available Courses:");
        for (course courses : availablecourses) {
            System.out.println(courses);
        }
    }

    private static void registerforcourses(Scanner scanner, student stud) throws Coursefullexception {
        System.out.println("Enter course to register");
        String coursecode = scanner.nextLine().trim().toLowerCase();

        course foundCourse = null;
        for (course c : availablecourses) {
            if (c.getCoursecode().trim().toLowerCase().equals(coursecode)) {
                foundCourse = c;
                break;

            }
        }


        if (foundCourse != null) {
            try{
                if(foundCourse.getenrolledstudents().size()>=foundCourse.getenrollmentlimit()){
                    throw new Coursefullexception("enrollment limit to course already reached, you cannot register for this course.");
                }
                stud.addCourse(foundCourse);
                foundCourse.addStudent(stud);
                System.out.println(coursecode + " " + "registered successfully");
            }
            catch (Coursefullexception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println(("Course not found"));
        }



    }

//    public static void dropCourse(Scanner scanner, student stud) {
//        System.out.println("Enter course code to drop");
//        String coursecode = scanner.nextLine().trim().toLowerCase();
//        course torem = null;
//        for (course c : availablecourses) {
//            if (c.getCoursecode().equalsIgnoreCase(coursecode)) {
//                torem = c;
//                break;
//            }
//        }
//        if (torem != null) {
//            try {
//                if (deadlinepassed(torem)) {
//                    throw new Dropdeadlineexception("Deadline has passed,cannot drop course");
//                }
//                availablecourses.remove(torem);
//                System.out.println(coursecode + " " + "dropped");
//            } catch (Dropdeadlineexception e) {
//                System.out.println(e.getMessage());
//            }
//
//        }
//        else {
//            System.out.println("Course not found");
//        }
//    }
public static void dropCourse(Scanner scanner, student stud) {
    System.out.println("Enter course code to drop");
    String coursecode = scanner.nextLine().trim().toLowerCase();
    course torem = null;

    // Look in student's registered courses, not available courses
    for (course c : stud.getCourses()) {
        if (c.getCoursecode().equalsIgnoreCase(coursecode)) {
            torem = c;
            break;
        }
    }

    if (torem != null) {
        try {
            if (deadlinepassed(torem)) {
                throw new Dropdeadlineexception("Deadline has passed, cannot drop course");
            }
            // Remove course from student's registered courses
            stud.getCourses().remove(torem);
            System.out.println(coursecode + " " + "dropped");
        } catch (Dropdeadlineexception e) {
            System.out.println(e.getMessage());
        }
    } else {
        System.out.println("Course not found in your registered courses");
    }
}


    public static boolean deadlinepassed( course c ){
        LocalDate today= LocalDate.now();
        return today.isAfter(c.getDropdeadline());
    }


//    private static void viewschedule(student stud) {
//        System.out.println("Schedule");
//        stud.viewschedule();
//    }

    private static void viewschedule(student stud) {
        System.out.println("Schedule");

        // Check if the student has any registered courses
        if (stud.getCourses().isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            // If courses are registered, display the schedule
            stud.viewschedule();
        }
    }


    private static void academicprogress(student stud) {
        System.out.println("Your Progress");
        stud.viewcCoursescompleted();
        double gpa = stud.calcGPA();
        System.out.println("Your GPA" + gpa);
    }


    private static void submitcomplaints(Scanner scanner, student stud) {
        System.out.println("Write your complaint");
        String comp = scanner.nextLine();
        stud.submitComplaint(comp);

        complaint com = new complaint(stud.getId(), comp);
        complaints.add(com);
//        System.out.println("Complaint submitted");

    }

    private static student findstudent(String id) {
        for (student stud : students) {
            if (Objects.equals(stud.getId(), id)) {
                return stud;
            }
        }
        System.out.println("Student not found");
        return null;
    }

    private static void professorLogin(Scanner scanner) throws Coursefullexception {
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            professorSignup(scanner);
        } else if (choice == 2) {
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            professors prof = authenticateProfessor(email, password);
            if (prof != null) {
                System.out.println("Login successful!");
                professormain(scanner, professor);
            } else {
                System.out.println("Invalid credentials.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void professorSignup(Scanner scanner) {
        System.out.println("Enter your id:");
        String id = scanner.nextLine();
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Create a password:");
        String password = scanner.nextLine();
        System.out.println("Your course");
        String course = scanner.nextLine();
        professor.add(new professors(id, name, email, password, course));
        System.out.println("Signup successful, You can now log in.");
    }

    private static professors authenticateProfessor(String email, String password) {
        for (professors prof : professor) {
            if (prof.getEmail().equals(email) && prof.getPassword().equals(password)) {
                return prof;
            }
        }
        return null;
    }


    private static void professormain(Scanner scanner, List<professors> professor) throws Coursefullexception {
        boolean stayin = true;
        while (stayin) {
            System.out.println("Professor:");
            System.out.println("1.View Courses");
            System.out.println("2.Update Courses");
            System.out.println("3.View Enrolled Students");
            System.out.println("4.View Feedbacks");
            System.out.println("5.Logout");

            int profoption = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter name to check if professor exists");
            String professorName = scanner.nextLine();
            professors prof = findprofessor(professorName);

            if (profoption == 1) {
                viewcourses(scanner, professor);
            } else if (profoption == 2) {

                assert prof != null;
                updatecourses(scanner, prof);

            } else if (profoption == 3) {
                assert prof != null;
                viewenrolledstudents(scanner, prof);

            } else if (profoption == 4) {
                assert prof != null;
                System.out.println("Enter the course title to view feedback");
                String courseTitle = scanner.nextLine();
                feedbackmanager.viewfeedback(courseTitle);

            } else if (profoption == 5) {
                System.out.println("Logging Out");
                enterapp(scanner);

            } else {
                System.out.println("Invalid Option");
            }
        }


    }

    private static void viewcourses(Scanner scanner, List<professors> professor) {
        System.out.println("Enter professor's name");
        String profname = scanner.nextLine().trim().toLowerCase();

        boolean foundprof = false;
        for (professors prof : professor) {
            for (course c : availablecourses) {
                if (c.getProfessor().trim().toLowerCase().equals(profname)) {
                    System.out.println(c);

                }
            }
            foundprof = true;
            break;
        }
    }


    private static void updatecourses(Scanner scanner, professors prof) {
        System.out.println("Enter course you wish to update");
        String code = scanner.nextLine().trim();

        course foundCourse = null;
        for (course c : availablecourses) {
            if (c.getCoursecode().equals(code)) {
                foundCourse = c;
                break;
            }
        }

        if (foundCourse == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Enter new syllabus:");
        String syllabus = scanner.nextLine();
        System.out.println("Enter new credits:");
        int credits = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new class timings:");
        String classTimings = scanner.nextLine();
        System.out.println("Enter new office hours:");
        String officeHours = scanner.nextLine();
        System.out.println("Enter new prerequisites:");
        String prerequisites = scanner.nextLine();
        System.out.println("Enter new enrollment limit:");
        int enrollmentLimit = scanner.nextInt();
        scanner.nextLine();


        prof.updateDetails(foundCourse, syllabus, credits, classTimings, officeHours, prerequisites, enrollmentLimit);
        System.out.println("Course details updated successfully");
    }


    private static void viewenrolledstudents(Scanner scanner, professors prof) {
        System.out.println("Enter the course code to view enrolled students");
        String code = scanner.nextLine().trim();

        // Search for the course by its code from the professor's course list
        course foundCourse = null;
        for (course c : prof.getCourses()) {
            if (c.getCoursecode().equals(code)) {  // Case-insensitive comparison
                foundCourse = c;
                break;
            }
        }

        if (foundCourse == null) {
            System.out.println("Course not found.");
            return;
        }

        // If the course is found, display enrolled students
        System.out.println("Students enrolled in the course: " + foundCourse.getTitle());
        List<student> enrolledStudents = foundCourse.getenrolledstudents();

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students are enrolled in this course.");
        } else {
            for (student stud : enrolledStudents) {
                System.out.println("Student Name: " + stud.getName());
            }
        }
    }


    private static professors findprofessor(String name) {
        for (professors proff : professor) {
            if (proff.getName() != null && proff.getName().equalsIgnoreCase(name)) {
                return proff;
            }
        }
        System.out.println("Professor not found");
        return null;

    }

    private static void adminLogin(Scanner scanner) throws Coursefullexception {
        System.out.println("Enter admin password:");
        String password = scanner.nextLine();
        if (administrator.getPassword().equals(password)) {
            System.out.println("Login successful!");
            administratormain(scanner);
        } else {
            System.out.println("Invalid password.");
        }
    }


    private static void administratormain(Scanner scanner) throws Coursefullexception {
        boolean stayin = true;
        while (stayin) {
            System.out.println("Administrator:");
            System.out.println("1. View Courses");
            System.out.println("2. Add Courses");
            System.out.println("3. Delete Courses");
            System.out.println("4. View Student Records");
            System.out.println("5. Update Student Records");
            System.out.println("6. Update Student Grades");
            System.out.println("7. Assign Professor to Course");
            System.out.println("8. View Complaints");
            System.out.println("9. Update Complaint Status");
            System.out.println("10. Logout");

            int adminoption = scanner.nextInt();
            scanner.nextLine();

            if (adminoption == 1) {
                System.out.println(availablecourses);
            } else if (adminoption == 2) {
                addcourse(scanner);
            } else if (adminoption == 3) {
                delcourse(scanner);
            } else if (adminoption == 4) {
                System.out.println(students);
            } else if (adminoption == 5) {
                updatesrec(scanner);
            } else if (adminoption == 6) {
                updatesgrades(scanner);
            } else if (adminoption == 7) {
                assignprof(scanner);
            } else if (adminoption == 8) {
                administrator.viewcomp(complaints);
            } else if (adminoption == 9) {
                updatecompstatus(scanner);
            } else if (adminoption == 10) {
                System.out.println("Logging out");
                enterapp(scanner);
            } else {
                System.out.println("Invalid option");
            }

        }


    }

    private static void addcourse(Scanner scanner) {
        System.out.println("Enter course code:");
        String coursecode = scanner.nextLine();

        System.out.println("Enter course title:");
        String title = scanner.nextLine();

        System.out.println("Enter professor's name:");
        String profname = scanner.nextLine();

        System.out.println("Enter number of credits:");
        int credits = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter prerequisites:");
        String prereq = scanner.nextLine();

        System.out.println("Enter location:");
        String location = scanner.nextLine();

        System.out.println("Enter timings:");
        String timings = scanner.nextLine();

        System.out.println("Enter dropdeadline for course in YYYY-MM-DD format");
        LocalDate dropdeadline= LocalDate.parse(scanner.nextLine());

        System.out.println("Enter enrollment limit");
        int enrollmentlimit= scanner.nextInt();
        scanner.nextLine();
        course ncourse = new course(coursecode, title, profname, credits, prereq, location, timings,dropdeadline,enrollmentlimit);
        availablecourses.add(ncourse);
        System.out.println("Course added");

    }

    private static void delcourse(Scanner scanner) {
        System.out.println("Enter course code to delete:");
        String code = scanner.nextLine();

        course courser = null;
        for (course c : availablecourses) {
            if (c.getCoursecode().equals(code)) {
                courser = c;
                break;
            }
        }

        if (courser != null) {
            availablecourses.remove(courser);
            System.out.println("Course deleted");
        } else {
            System.out.println("Course not found");
        }
    }

    private static void updatesrec(Scanner scanner) {
        System.out.println("Enter student ID to update:");
        String sid = scanner.nextLine();

        student stud = findstudent(sid);

        if (stud == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.println("Enter details to update");

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter emailid");
        String emailid = scanner.nextLine();

        System.out.println("Enter phone number");
        String phonenumber = scanner.nextLine();

        System.out.println("Details updated");

    }

    private static void updatesgrades(Scanner scanner) {
        System.out.println("Enter student ID to update grades:");
        String sid = scanner.nextLine();

        student stud = findstudent(sid);

        if (stud == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.println("Enter course to update grades");
        String code = scanner.nextLine();

        course update = null;
        for (course c : availablecourses) {
            if (c.getCoursecode().equals(code)) {
                update = c;
                break;
            }
        }

        if (update == null) {
            System.out.println("Course not found");
            return;
        }

        System.out.println("Enter new grade");
        String grade = scanner.nextLine();
        stud.Coursecompleted(update.getTitle(), grade);

        System.out.println("Grade updated");
    }

    private static void assignprof(Scanner scanner) {
        System.out.println("Enter course assign professor");
        String courseCode = scanner.nextLine().trim();

        course assign = null;
        for (course c : availablecourses) {
            if (c.getCoursecode().equalsIgnoreCase(courseCode)) {
                assign = c;
                break;
            }
        }

        if (assign == null) {
            System.out.println("Course not found");
            return;
        }

        System.out.println("Enter professor name to assign");
        String pname = scanner.nextLine();

        professors prof = findprofessor(pname);

        if (prof == null) {
            System.out.println("Professor not found");
            return;
        }

        prof.addCourse(assign);
        System.out.println("Professor assigned to course");

    }

    private static complaint findcomplaint(String StudId) {
        for (complaint c : complaints) {
            if (c.getStudentId().equals(StudId)) {
                return c;
            }
        }
        if (StudId == null) {
            System.out.println(("Student id cannot be null"));
            return null;
        }
        return null;
    }


    private static void updatecompstatus(Scanner scanner) {
        System.out.println("Enter student ID to update status:");
        String studentid = scanner.nextLine();

        complaint comp = findcomplaint(studentid);

        if (comp == null) {
            System.out.println("Complaint not found");
            return;
        }

        System.out.println("Current status: " + comp.getStatus());
        System.out.println("Enter new status (e.g., 'Resolved', 'Pending'):");
        String newStatus = scanner.nextLine();

        // Update the complaint status
        comp.setStatus(newStatus);

        // Optional: If you want to mark the complaint as resolved automatically
        if ("Resolved".equalsIgnoreCase(newStatus)) {
            comp.resolve();
        }

        System.out.println("Complaint status updated");
    }

    private static void TAlogin(Scanner scanner, List<TA> ta) throws Coursefullexception {
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            TASignup(scanner, ta);
        } else if (choice == 2) {
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            TA ta1 = authenticateTA(email, password, ta);
            if (ta1 != null) {
                System.out.println("Login successful!");
                TAmain(scanner, ta, students);
            } else {
                System.out.println("Invalid credentials.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void TASignup(Scanner scanner, List<TA> ta) {
        System.out.println("Enter your id:");
        String id = scanner.nextLine();
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Create a password:");
        String password = scanner.nextLine();
        ta.add(new TA(id, name, email, password));
        System.out.println("Signup successful! You can now log in.");
    }

    private static TA authenticateTA(String email, String password, List<TA> ta) {
        for (TA ta1 : ta) {
            if (ta1.getEmailId().equals(email) && ta1.getPassword().equals(password)) {
                return ta1;
            }
        }
        return null;
    }

    private static void TAmain(Scanner scanner, List<TA> ta, List<student> students ) throws Coursefullexception {

        boolean stayin =true;
        while(stayin) {
            System.out.println("TA:");
            System.out.println("1. View Student Grades");
            System.out.println("2. Update Student Grades");
            System.out.println("3. Logout");

            int taoption = scanner.nextInt();
            scanner.nextLine();

            TA ta1 = findTA("1");



            if (taoption == 1) {
                System.out.println("Enter student ID to view grade");
                String sid= scanner.nextLine();
                student stud=findstudent(sid);

                if(stud==null){
                    System.out.println("Student not found");
                    continue;
                }

                ta1.viewSgrades(stud);
            }
            else if(taoption==2){
                System.out.println("Enter student ID to view grade");
                String Sid= scanner.nextLine();
                student stu=findstudent(Sid);

                if(stu==null){
                    System.out.println("Student not found");
                    continue;
                }

                System.out.println("Enter course title");
                String courseTitle= scanner.nextLine();

                System.out.println("Enter grade");
                String grade= scanner.nextLine();

                ta1.addSgrades(stu, courseTitle, grade);
                System.out.println("Grade added");
            }

            else if(taoption==3){
                System.out.println("Logging Out");
                enterapp(scanner);
            }
            else {
                System.out.println("Invalid Option");
            }

        }

    }

    private static TA findTA(String id) {
        for (TA  ta1 : ta) {
            if (Objects.equals(ta1.getId(), id)) {
                return ta1;
            }
        }
        System.out.println("TA not found");
        return null;
    }

}
