import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Manages enrollments using an ArrayList
 */

public class EnrollmentManager {

    ArrayList<Enrollment> enrollments;

    /**
     * Constructor
     */
    public EnrollmentManager(){
        enrollments = new ArrayList<>();
    }

    /**
     * Enrolls a student
     * @param studentId
     * @param courseCode
     * @param semester
     */
    public void enrollStudent(String studentId, String courseCode, String semester){
        enrollments.add(new Enrollment(studentId, courseCode, semester));
    }

    /**
     * Drops enrollment
     * @param enrollmentId to find student
     * @return true if removed, false otherwise
     */
    public boolean dropEnrollment(String enrollmentId){
        Enrollment wantedEnrollment = findEnrollment(enrollmentId);
        if (wantedEnrollment != null){
            enrollments.remove(wantedEnrollment);
            return true;
        }
        return false;
    }

    /**
     * Finds enrollment
     * @param enrollmentId to find enrollment using ID
     * @return enrollment if found, null otherwise
     */
    public Enrollment findEnrollment(String enrollmentId){
        if (enrollments.isEmpty() || enrollmentId == null){
            return null;
        }
        else {
            for (Enrollment enrollment : enrollments){
                if (enrollment.getEnrollmentId().equals(enrollmentId)){
                    return enrollment;
                }
            }
        }
        return null;
    }

    /**
     * Sorts enrollments by student
     * @param studentId finds student using ID and their enrollments
     * @return ArrayList of enrollments with the student's ID
     */
    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId){
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        if (enrollments.isEmpty()){
            return studentEnrollments;
        }
        else {
            for (Enrollment enrollment : enrollments){
                if ((enrollment.getStudentId()).equals(studentId)){
                    studentEnrollments.add(enrollment);
                }
            }
        }
        return studentEnrollments;
    }

    /**
     * Sorts enrollment by course
     * @param courseCode finds enrollments using course code
     * @return ArrayList of enrollments sorted by course code
     */
    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode){
        ArrayList<Enrollment> courseEnrollment = new ArrayList<>();
        if (enrollments.isEmpty()){
            return courseEnrollment;
        }
        else {
            for (Enrollment enrollment : enrollments){
                if (enrollment.getCourseCode().equals(courseCode)){
                    courseEnrollment.add(enrollment);
                }
            }
        }
        return courseEnrollment;
    }

    /**
     * Assigns a grade
     * @param enrollmentId to find the enrollment using ID
     * @param grade to assign the grade
     */
    public void assignGrade(String enrollmentId, String grade){
        Enrollment enrollment = findEnrollment(enrollmentId);
        if (enrollment != null){
            if (grade.length() == 1) {
                char letterGrade = grade.charAt(0);
                if (letterGrade >= 'A' && letterGrade <= 'F') {
                    enrollment.setGrade(grade);
                    System.out.println("Grade updated.");
                } else {
                    System.out.println("Not a valid grade.");
                }
            }
        }
    }

    /**
     * Calculates a student's GPA
     * @param studentId to find student by ID
     * @return student's GPA calculated from all courses
     */
    public double calculateStudentGpa(String studentId){
        double studentGPA = 0;
        ArrayList<Enrollment> studentCourses = getEnrollmentsByStudent(studentId);
        if (studentCourses.size() != 0){
            for (Enrollment enrollment : studentCourses){
                 studentGPA += enrollment.getGradePoints();
            }
            studentGPA = studentGPA / studentCourses.size();
        }
        return studentGPA;
    }

    /**
     * Finds all students in a course
     * @param courseCode to find course using its code
     * @return ArrayList of students taking that course
     */
    public ArrayList<String> getStudentsInCourse(String courseCode){
        ArrayList<String> courseStudents = new ArrayList<>();
        if (enrollments.isEmpty()){
            return courseStudents;
        }
        else {
            for (Enrollment enrollment : enrollments){
                if (enrollment.getCourseCode().equals(courseCode)){
                    courseStudents.add(enrollment.getStudentId());
                }
            }
        }
        return courseStudents;
    }

    /**
     * Finds amount of students in a course
     * @param courseCode finds course using its code
     * @return amount of students in that course
     */
    public int getEnrollmentCount(String courseCode){
        ArrayList<String> courseStudents = getStudentsInCourse(courseCode);
        return courseStudents.size();
    }

    /**
     * Prints enrollments
     */
    public void printAllEnrollments(){
        if (enrollments.isEmpty()){
            System.out.println("No enrollments");
        }
        else {
            for (Enrollment enrollment : enrollments){
                System.out.print(enrollment);
            }
        }
    }
}
