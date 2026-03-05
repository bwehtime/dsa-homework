import java.util.ArrayList;

/**
 * Manages courses in an ArrayList
 */

public class CourseManager {

    ArrayList<Course> courses;

    /**
     * Constructor
     */
    public CourseManager(){
        this.courses = new ArrayList<>();
    }

    /**
     * Adds a course
     * @param course to add to ArrayList
     */
    public void addCourse(Course course){
        if (courses.isEmpty()){
            courses.add(course);
        }
        else if (course == null){
            System.out.println("Error: Null course");
        }
        else {
            Course courseChecker = findCourse(course.getCourseCode());
            if (courseChecker != null){
                System.out.println("Course already exists.");
                return;
            }
            courses.add(course);
        }
    }

    /**
     * Finds a course
     * @param courseCode to find the course using code
     * @return course if found, null otherwise
     */
    public Course findCourse(String courseCode){
        if (courses.isEmpty()){
            return null;
        }
        else {
            for (Course course : courses){
                if (course.getCourseCode().equals(courseCode)){
                    return course;
                }
            }
        }
        return null;
    }

    /**
     * Finds courses an instructor teaches
     * @param instructor instructor to filter by
     * @return ArrayList of courses taught by instructor
     */

    public ArrayList<Course> getCoursesByInstructor(String instructor){
        ArrayList<Course> coursesByInstructor = new ArrayList<>();
        if (courses.isEmpty()){
            return coursesByInstructor;
        }
        else {
            for (Course course : courses){
                if (course.getInstructor().equals(instructor)){
                    coursesByInstructor.add(course);
                }
            }
        }
        return coursesByInstructor;
    }

    /**
     * Finds what courses a student can take
     * @param studentId student ID
     * @param studentManager Manager where the student is
     * @param enrollmentManager to register enrollment
     * @return ArrayList of available courses
     */
    ArrayList<Course> getAvailableCourses(String studentId, StudentManager studentManager, EnrollmentManager enrollmentManager){
        ArrayList<Course> availableCourses = new ArrayList<>();
        if (studentManager.getTotalStudents() == 0){
            return availableCourses;
        }
        else {
            Student wantedStudent = studentManager.findStudent(studentId);
            if (wantedStudent != null){
                ArrayList<Enrollment> studentClasses = enrollmentManager.getEnrollmentsByStudent(studentId);
                for (Course course : courses){
                    if (studentClasses.containsAll(course.prerequisites)){
                        availableCourses.add(course);
                    }
                }
            }
        }
        return availableCourses;
    }
}
