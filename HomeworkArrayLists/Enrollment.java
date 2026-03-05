/**
 * Enrollment class represents an enrollment in a course
 */

public class Enrollment {

    String enrollmentId;
    String studentId;
    String courseCode;
    String grade;
    String semester;

    /**
     * Constructors
     */
    public Enrollment(String enrollmentId, String studentId, String courseCode, String grade, String semester){
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
        this.semester = semester;
    }

    public Enrollment(String studentId, String courseCode, String semester){
        this.enrollmentId = String.valueOf(hashCode());
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
    }

    /**
     * Getters
     */
    public String getEnrollmentId(){
        return this.enrollmentId;
    }

    public String getStudentId(){
        return this.studentId;
    }

    public String getCourseCode(){
        return this.courseCode;
    }

    public String getGrade(){
        return this.grade;
    }

    public String getSemester(){
        return this.semester;
    }

    /**
     * Setters
     */
    public void setEnrollmentId(String enrollmentId){
        this.enrollmentId = enrollmentId;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public void setSemester(String semester){
        this.semester = semester;
    }

    /**
     * Converts grade letter to value
     * @return grade as a double
     */
    public double getGradePoints(){
        switch (this.grade){
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            case null:
                return 0.0;
            default:
                return 0;
        }
    }

    /**
     * checks if grade is passing by threshold
     * @return true if yes, false otherwise
     */
    public boolean isPassing(){
        if (getGradePoints() >= 1){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Enrollment ID: " + this.enrollmentId + " | Student ID: " + this.studentId + " | Course Code: " + this.courseCode + " | Grade: " + this.grade + " | Semester: " + this.semester + "\n";
    }
}
