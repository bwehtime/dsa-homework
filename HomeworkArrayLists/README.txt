Classes:
    Student.java
        -Represents a student with ID, name, major, gpa, email, and year
        -Implements Comparable<Product> for use with generic methods
        -Includes equals(), hashCode(), and toString() methods
    StudentManager.java
        -Manages students using ArrayList<Student>
        -Provides methods for adding, removing, finding, and sorting students
    Course.java
        -Represents a course with course code, name, instructor, and max enrollments
        -Has an ArrayList of prerequisites to take before course can be enrolled
    CourseManager.java
        -Manages Courses using ArrayList<Course>
        -Provides methods for adding, finding, and filtering courses
    Enrollment.java
        -Represents enrollments with student ID, course code, grade, and semester
        -Converts grade to a double and checks if students are passing
    EnrollmentManager.java
        -Manages enrollments with ArrayList<Enrollment>
        -Provides methods for adding, finding, and filtering enrollments
        -Calculates GPA for students or courses
    ArrayListUtils.java
        -Generic Utility methods for ArrayLists
    GenericList.java
        -Generic list that works with any type
    GenericStack.java
        -Generic stack that works with any type
    GenericQueue.java
        -Generic queue that works with any type
    Pair.java
        -Contains a key and a value
        -Uses key to obtain value
    StudentReporter.java
        -Generates various reports such as student, course, and major reports
    StudentManagementSystemMain.java
        -The interactive menu that demonstrates the features in this program
    ArrayListOperationsDemo.java
        -Demonstration of the various methods in an ArrayList

    Compiling and Running
        Compile all java files
        Run StudentManagementSystemMain.java
        Run ArrayListOperationsDemo.java

    Assumptions:
        All strings are entered correctly (ex. Semester = "Spring 2024")
        GPAs go from 0.0 - 4.0
        Student IDs are unique identifiers
        Course codes are unique identifiers