public abstract class Student implements Payment {
    private final String firstName;
    private final String lastName;
    private final String studentID;

    // constructor
    public Student(String firstName, String lastName, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    // return first name
    public String getFirstName() {
        return firstName;
    }

    // return last name
    public String getLastName() {
        return lastName;
    }

    // return student ID
    public String getStudentID() {
        return studentID;
    }

    // return String representation of Student object
    @Override
    public String toString() {
        return String.format("name: " + getLastName() + getFirstName() + ", ID: " + getStudentID());
    }
}
