import java.util.ArrayList;

public class StudentManager {

    /**
     * list to store students
     */
    ArrayList<Student> students;

    /**
     * Constructor
     */
    public StudentManager(){
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student
     * @param student student to add
     */
    public void addStudent(Student student){
        if (students.isEmpty()){
            students.add(student);
        }
        else if (student == null){
            System.out.println("Error: Null student");
        }
        else {
            Student studentChecker = findStudent(student.getStudentId());
            if (studentChecker != null){
                System.out.println("Student already exists.");
                return;
            }
            students.add(student);
        }
    }

    /**
     * Removes a student
     * @param studentId uses StudentID to check for student to remove
     * @return true if student is removed, otherwise
     */
    public boolean removeStudent(String studentId){
        Student wantedStudent = findStudent(studentId);
        if (wantedStudent != null){
            students.remove(wantedStudent);
            return true;
        }
        return false;
    }

    /**
     * Finds a student
     * @param studentId student ID to find student
     * @return student if found, null otherwise
     */
    public Student findStudent(String studentId){
        if (students.isEmpty()){
            return null;
        }
        for (Student student : students){
            if (student.getStudentId().equals(studentId)){
                return student;
            }
        }
        return null;
    }

    /**
     * Filters students by major
     * @param major major to filter students by
     * @return ArrayList of sorted students by major
     */
    public ArrayList<Student> getStudentsByMajor(String major){
        ArrayList<Student> filteredMajor = new ArrayList<>();
        if (students.isEmpty()){
            return filteredMajor;
        }
        else {
            for (Student student : students){
                if (student.getMajor().equals(major)){
                    filteredMajor.add(student);
                }
            }
        }
        return filteredMajor;
    }

    /**
     * Filters students by year
     * @param year to filter students by year
     * @return ArrayList of students sorted by year
     */
    public ArrayList<Student> getStudentsByYear(int year){
        ArrayList<Student> filteredYear = new ArrayList<>();
        if (students.isEmpty()){
            return filteredYear;
        }
        else {
            for (Student student : students){
                if (student.getYear() == year){
                    filteredYear.add(student);
                }
            }
        }
        return filteredYear;
    }

    /**
     * Filters students by GPA
     * @param minGpa gpa threshold to check students meeting the requirement
     * @return ArrayList of students meeting GPA requirement
     */
    public ArrayList<Student> getHonorStudents(double minGpa){
        ArrayList<Student> filteredGPA = new ArrayList<>();
        if (students.isEmpty()){
            return filteredGPA;
        }
        else {
            for (Student student : students){
                if (student.getGpa() >= minGpa){
                    filteredGPA.add(student);
                }
            }
        }
        return filteredGPA;
    }

    /**
     * Calculates average GPA of all students
     * @return all students' GPAs divided by total students
     */
    public double getAverageGpa(){
        double avg = 0;
        if (students.isEmpty()){
            return 0;
        }
        for (Student student : students){
            avg += student.getGpa();
        }
        return avg / students.size();
    }

    /**
     * Prints all students
     */
    public void printAllStudents(){
        if (students.isEmpty()){
            System.out.println("No Students");
        }
        else {
            for (Student student : students) {
                System.out.print(student);
            }
        }
    }

    /**
     * Number of students
     * @return size of students in ArrayList
     */
    public int getTotalStudents(){
        return students.size();
    }

    /**
     * Prints every major
     * @return ArrayList of unique majors
     */
    public ArrayList<String> getAllMajors(){
        ArrayList<String> uniqueMajors = new ArrayList<>();
        if (students.isEmpty()){
            return uniqueMajors;
        }
        else {
            for (Student student : students){
                if (!uniqueMajors.contains(student.getMajor())){
                    uniqueMajors.add(student.getMajor());
                }
            }
        }
        return uniqueMajors;
    }

    static void main(String[] args){
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2));
        manager.addStudent(new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3));
        manager.addStudent(new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2));

        manager.printAllStudents();
        System.out.println("Average GPA: " + manager.getAverageGpa());
        System.out.println("CS Students: " + manager.getStudentsByMajor("Computer Science").size());
        System.out.println("Majors: " + manager.getAllMajors());
    }
}
