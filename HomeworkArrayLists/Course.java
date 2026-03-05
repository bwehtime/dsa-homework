import java.util.ArrayList;

/**
 * Course class representing courses for students to take
 */

public class Course {

    String courseCode;
    String courseName;
    int credits;
    String instructor;
    int maxEnrollment;

    ArrayList<String> prerequisites;

    /**
     * Constructor taking all parameters
     */

    public Course(String courseCode, String courseName, int credits, String instructor, int maxEnrollment) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.maxEnrollment = maxEnrollment;

        this.prerequisites = new ArrayList<>();
    }

    //Getters
    public String getCourseCode() {
        return this.courseCode;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getCredits() {
        return this.credits;
    }

    public String getInstructor() {
        return this.instructor;
    }

    public int getMaxEnrollment() {
        return this.maxEnrollment;
    }

    //Setters
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    /**
     * Returns string representing course
     */
    @Override
    public String toString() {
        return "Course Code: " + this.courseCode + " | Course Name: " + this.courseName + " | Credits: " + this.credits + " | Instructor: " + this.getInstructor() + " | Max Enrollment: " + this.maxEnrollment + "\n";
    }

    /**
     * Adds a prerequisite course
     * @param courseCode to add a course to prerequisites using ID
     */
    public void addPrerequisite(String courseCode){
        prerequisites.add(courseCode);
    }

    /**
     * Checks if course is a prerequisite
     * @param courseCode finds course using code
     * @return true if it is a prerequisite, false otherwise
     */
    public boolean hasPrerequisite(String courseCode){
        return prerequisites.contains(courseCode);
    }

    /**
     * A copy of prerequisites
     * @return ArrayList of prerequisites
     */
    public ArrayList<String> getPrerequisites(){
        return prerequisites;
    }

}
