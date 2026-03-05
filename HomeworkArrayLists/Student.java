/**
 * Student class represents a student
 */

public class Student implements Comparable<Student> {

    String studentId;
    String firstName;
    String lastName;
    String email;
    double gpa;
    String major;
    int year;

    /**
     * Constructor
     */
    public Student(String studentId, String firstName, String lastName, String email, double gpa, String major, int year){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gpa = gpa;
        this.major = major;
        this.year = year;
    }

    /**
     * Empty Constructor for testing
     */
    public Student(){
        this.studentId = "00001";
        this.firstName = "John";
        this.lastName = "Doe";
        this.email = "johndoe@gmail.com";
        this.gpa = 3.0;
        this.major = "English";
        this.year = 1;
    }

    //Getters
    public String getStudentId(){
        return this.studentId;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public double getGpa(){
        return this.gpa;
    }

    public String getMajor(){
        return this.major;
    }

    public int getYear(){
        return this.year;
    }

    //Setters
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public void setYear(int year){
        this.year = year;
    }

    /**
     * A string to represent student information
     */
    @Override
    public String toString(){
        return "Student ID: " + this.studentId + " | First Name: " + this.firstName + " | Last Name: " + this.lastName + " | Email: " + this.email + " | GPA: " + this.gpa + " | Major: " + this.major + " | Year: " + this.year + "\n";
    }

    /**
     * Checks if student is same using ID
     * @param student for student to check
     * @return true if same, false otherwise
     */
    public boolean equals(Student student) {
        return getStudentId().equals(student.getStudentId());
    }

    /// Check back later
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * String of student's full name
     */
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    /**
     * Comparable
     */
    public int compareTo(Student other) {
        return this.hashCode() - other.hashCode();
    }
}
