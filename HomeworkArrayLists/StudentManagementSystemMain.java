import java.util.Scanner;

public class StudentManagementSystemMain {

    private StudentManager studentManager;
    private CourseManager courseManager;
    private EnrollmentManager enrollmentManager;
    private Scanner sc;
    private ReportGenerator reportGenerator;

    public StudentManagementSystemMain(){
        this.studentManager = new StudentManager();
        this.courseManager = new CourseManager();
        this.enrollmentManager = new EnrollmentManager();
        this.sc = new Scanner(System.in);
        this.reportGenerator = new ReportGenerator();
    }
    public static void main(String[] args) {

        StudentManagementSystemMain systemMain = new StudentManagementSystemMain();
        systemMain.sampleData();
        systemMain.systemMenu();

    }

    //Sample Data
    private void sampleData(){
        //Sample Students
        studentManager.addStudent(new Student("00368", "Jessica", "Newton", "jnewton@gmail.com", 3.7, "Physics", 2));
        studentManager.addStudent(new Student("23369", "Riley", "Ren", "rren@gmail.com", 2.8, "History", 1));
        studentManager.addStudent(new Student("21355", "Flora", "Simons", "fsimons@gmail.com", 3.9, "Computer Science", 3));
        studentManager.addStudent(new Student("53340", "Erin", "Simons", "esimons@gmail.com", 3.1, "Physics", 1));
        studentManager.addStudent(new Student("47589", "Lucas", "Cobalt", "lcobalt@gmail.com", 3.6, "Computer Science", 2));
        studentManager.addStudent(new Student("38834", "Hugh", "Blanc", "hblanc@gmail.com", 2.1, "History", 1));
        studentManager.addStudent(new Student("29091", "Bella", "Rina", "brina@gmail.com", 3.0, "Music", 2));
        studentManager.addStudent(new Student("83762", "Oliver", "Gray", "ogray@gmail.com", 4.0, "Music", 3));
        studentManager.addStudent(new Student("13455", "Terra", "Toise", "ttoise@gmail.com", 3.4, "Computer Science", 4));
        studentManager.addStudent(new Student("44430", "Freya", "Lovelace", "flovelace@gmail.com", 2.7, "Computer Science", 4));

        //Sample Courses
        courseManager.addCourse(new Course("3130", "Data Structures", 4, "Thomas", 45));
        courseManager.addCourse(new Course("1012", "English", 3, "Thomas", 30));
        courseManager.addCourse(new Course("1110", "Culture", 3, "Sowers", 45));
        courseManager.addCourse(new Course("2501", "Stats", 3, "Mates", 30));
        courseManager.addCourse(new Course("2210", "Discrete Maths", 3, "Thomas", 30));

        //Sample Enrollments
        enrollmentManager.enrollStudent("00368", "1012", "Fall 2024");
        enrollmentManager.enrollStudent("00368", "3130", "Fall 2024");
        enrollmentManager.enrollStudent("00368", "2501", "Fall 2024");

        enrollmentManager.enrollStudent("53340", "1012", "Fall 2024");
        enrollmentManager.enrollStudent("53340", "2210", "Fall 2024");
        enrollmentManager.enrollStudent("53340", "1110", "Fall 2024");
        enrollmentManager.enrollStudent("53340", "2501", "Fall 2024");

        enrollmentManager.enrollStudent("83762", "3130", "Fall 2024");
        enrollmentManager.enrollStudent("83762", "1012", "Fall 2024");
        enrollmentManager.enrollStudent("83762", "1110", "Fall 2024");
        enrollmentManager.enrollStudent("83762", "2501", "Fall 2024");
        enrollmentManager.enrollStudent("83762", "2210", "Fall 2024");

        enrollmentManager.assignGrade("1528902577", "B");
        enrollmentManager.assignGrade("1927950199", "C");
        enrollmentManager.assignGrade("868693306","B");

        enrollmentManager.assignGrade("1746572565","C");
        enrollmentManager.assignGrade("989110044","B");
        enrollmentManager.assignGrade("424058530","C");
        enrollmentManager.assignGrade("321001045","A");

        enrollmentManager.assignGrade("791452441","A");
        enrollmentManager.assignGrade("834600351","A");
        enrollmentManager.assignGrade("471910020","A");
        enrollmentManager.assignGrade("531885035","A");
        enrollmentManager.assignGrade("1418481495", "A");

    }

    //Menu
    private void systemMenu(){
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Find Student");
        System.out.println("4. List All Students");
        System.out.println("5. Add Course");
        System.out.println("6. Enroll Student in Course");
        System.out.println("7. List All Enrollments");
        System.out.println("8. Assign Grade");
        System.out.println("9. Calculate Student GPA");
        System.out.println("10. Generate Reports");
        System.out.println("11. Exit");

        while (true){

            int input = getIntInput("Enter a command: ");

            switch (input){
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    findStudent();
                    break;
                case 4:
                    listAllStudents();
                    break;
                case 5:
                    addCourse();
                    break;
                case 6:
                    enrollStudentInCourse();
                    break;
                case 7:
                    listAllEnrollments();
                    break;
                case 8:
                    assignGrade();
                    break;
                case 9:
                    calculateStudentGPA();
                    break;
                case 10:
                    generateReports();
                    break;
                case 11:
                    return;
                default:
                    System.out.println();
                    System.out.println("Invalid command. Try again.");
                    break;
            }

            System.out.println();
        }
    }

    // Adds a new student
    private void addStudent(){
        String studentID = getStringInput("Student ID: ");
        String firstName = getStringInput("First name: ");
        String lastName = getStringInput("Last name: ");
        String email = getStringInput("Email: ");
        double gpa = getDoubleInput("GPA: ");
        String major = getStringInput("Major: ");
        int year = getIntInput("Year: ");

        studentManager.addStudent(new Student(studentID, firstName, lastName, email, gpa, major, year));
        System.out.println("Student Added.");
    }

    //Removes a student
    private void removeStudent(){
        String studentID = getStringInput("Enter Student ID: ");
        boolean removed = studentManager.removeStudent(studentID);
        if (removed == true){
            System.out.println("Student Removed.");
        }
        else {
            System.out.println("Student does not exist.");
        }
    }

    //Finds a student
    private void findStudent(){
        String studentID = getStringInput("Enter Student ID: ");
        Student studentWanted = studentManager.findStudent(studentID);
        if (studentWanted != null){
            System.out.println(studentWanted);
        }
        else {
            System.out.println("Student does not exist.");
        }
    }

    //Lists all students
    private void listAllStudents(){
        System.out.println("--- Students ---");
        studentManager.printAllStudents();
    }

    // Adds a course
    private void addCourse(){
        //String courseCode, String courseName, int credits, String instructor, int maxEnrollment
        String courseCode = getStringInput("Course Code: ");
        String courseName = getStringInput("Course Name: ");
        int credits = getIntInput("Credits: ");
        String instructor = getStringInput("Instructor: ");
        int maxEnrollment = getIntInput("Max Enrollment: ");

        courseManager.addCourse(new Course(courseCode, courseName, credits, instructor, maxEnrollment));
        System.out.println("Course added.");
    }

    // Enrolls a student in a course
    private void enrollStudentInCourse(){
        //String enrollmentId, String studentId, String courseCode, String grade, String semester
        String studentID = getStringInput("Student ID: ");
        if (studentID == null){
            System.out.println("Student does not exist.");
            return;
        }
        String courseCode = getStringInput("Course Code: ");
        if (courseManager.findCourse(courseCode) == null){
            System.out.println("Course does not exist.");
            return;
        }
        String semester = getStringInput("Semester: ");

        enrollmentManager.enrollStudent(studentID, courseCode, semester);
        System.out.println("Student enrolled.");
    }

    //Prints all enrollments
    private void listAllEnrollments(){
        System.out.println("---Enrollments---");
        enrollmentManager.printAllEnrollments();
    }

    // Assigns a grade to a student
    private void assignGrade(){
        String enrollmentID = getStringInput("Enrollment ID: ");
        if (enrollmentManager.findEnrollment(enrollmentID) == null){
            System.out.println("Enrollment does not exist.");
            return;
        }
        String grade = getStringInput("Enter grade: ");
        enrollmentManager.assignGrade(enrollmentID, grade);
    }

    //Calculates a student's GPA
    private void calculateStudentGPA(){
        String studentID = getStringInput("Student ID: ");
        if (studentManager.findStudent(studentID) == null){
            System.out.println("Student does not exist");
            return;
        }
        double studentGPA = enrollmentManager.calculateStudentGpa(studentID);
        System.out.println("Student GPA: " + studentGPA);
    }

    //Generates Reports
    private void generateReports(){

        System.out.println();

        System.out.println("1. Student Report");
        System.out.println("2. Course Report");
        System.out.println("3. Honor Students");
        System.out.println("4. All Majors");
        System.out.println("5. Students By Year");
        System.out.println("6. Major Report");
        System.out.println("7. Average GPA");
        System.out.println("8. Available Courses");
        System.out.println("9. Courses By Instructor");

        int input = getIntInput("Enter a command: ");

        String courseCode;
        String studentID;
        int year;
        String instructor;
        double minGPA;
        String major;

        switch (input){
            case 1:
                studentID = getStringInput("Student ID: ");
                reportGenerator.generateStudentReport(studentID, studentManager, enrollmentManager);
                break;
            case 2:
                courseCode = getStringInput("Course Code: ");
                reportGenerator.generateCourseReport(courseCode, courseManager, enrollmentManager);
                break;
            case 3:
                minGPA = getDoubleInput("Lowest GPA: ");
                reportGenerator.generateHonorRollReport(studentManager, minGPA);
                break;
            case 4:
                System.out.println(studentManager.getAllMajors());
                break;
            case 5:
                year = getIntInput("Year: ");
                System.out.println(studentManager.getStudentsByYear(year));
                break;
            case 6:
                major = getStringInput("Major: ");
                reportGenerator.generateMajorReport(major, studentManager);
                break;
            case 7:
                System.out.println("Average GPA: " + studentManager.getAverageGpa());
                break;
            case 8:
                studentID = getStringInput("Student ID: ");
                System.out.println(courseManager.getAvailableCourses(studentID, studentManager, enrollmentManager));
                break;
            case 9:
                instructor = getStringInput("Instructor: ");
                System.out.println(courseManager.getCoursesByInstructor(instructor));
                break;
        }

    }

    //Helper for string inputs
    private String getStringInput(String prompt){
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    //Helper for double inputs
    private double getDoubleInput(String prompt){
        while (true) {
            try {
                System.out.print(prompt);
                double num = Double.parseDouble(sc.nextLine().trim());
                return num;
            }
            catch (Exception e){
                System.out.println("Invalid Input. Try again.");
            }
        }
    }

    //Helper for int inputs
    private int getIntInput(String prompt){
        while (true){
            try {
                System.out.print(prompt);
                int num = Integer.parseInt(sc.nextLine().trim());
                return num;
            }
            catch (Exception e){
                System.out.println("Invalid input. Try again.");
            }
        }
    }

}
