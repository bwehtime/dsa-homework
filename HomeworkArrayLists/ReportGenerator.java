import java.util.ArrayList;

public class ReportGenerator {

    /**
     * Generates a student report
     * @param studentId the student found
     * @param sm where to find the student
     * @param em where to student's enrollments
     */
    public void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em){
        Student student = sm.findStudent(studentId);
        if (student == null){
            System.out.println("Student does not exist");
            return;
        }

        System.out.println(student);
        System.out.println("---ENROLLMENTS---");
        System.out.println(em.getEnrollmentsByStudent(studentId));

        System.out.println("GPA: " + em.calculateStudentGpa(studentId));
    }

    /**
     * Generates course report
     * @param courseCode the course code
     * @param cm course manager to find course
     * @param em enrollment manager to find enrollments
     */
    public void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em){
        Course course = cm.findCourse(courseCode);
        if (course == null){
            System.out.println("Course does not exist");
        }
        System.out.println(course);

        System.out.println("---ENROLLMENTS---");
        ArrayList<Enrollment> courseEnrollments = em.getEnrollmentsByCourse(courseCode);
        System.out.println(courseEnrollments);

        double avgGPA = 0;
        for (Enrollment enrollment : courseEnrollments){
            avgGPA += enrollment.getGradePoints();
            avgGPA = avgGPA / courseEnrollments.size();
        }
        System.out.println("Average GPA: " + avgGPA);
    }

    /**
     * Generates student major reports
     * @param major the major to find
     * @param sm the student manager
     */
    public void generateMajorReport(String major, StudentManager sm){
        ArrayList<Student> studentsInMajor = sm.getStudentsByMajor(major);
        if (studentsInMajor.isEmpty()){
            System.out.println("No students");
            return;
        }

        System.out.println(studentsInMajor);

        double avgGPA = 0;
        for (Student student : studentsInMajor){
            avgGPA += student.getGpa();
            avgGPA = avgGPA / studentsInMajor.size();
        }
        System.out.println("Average GPA: " + avgGPA);
    }

    /**
     * Generates honor students
     * @param sm student manager
     * @param minGpa threshold to be honor student
     */
    public void generateHonorRollReport(StudentManager sm, double minGpa){
        ArrayList<Student> honorStudents = sm.getHonorStudents(minGpa);
        System.out.println(honorStudents);
    }
}
