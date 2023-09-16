public class GraduateStudent extends Student {

    private final int numberOfCourses;

    // constructor
    public GraduateStudent(String firstName, String lastName, String studentID, int numberOfCourses) {

        super(firstName, lastName, studentID);

        if (numberOfCourses < 0) { // validate numberOfCourses
            throw new IllegalArgumentException("Number of courses must be >= 0");
        }

        this.numberOfCourses = numberOfCourses;
    }

    // return number of courses
    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    // method required to carry out contract with interface Payment
    @Override
    public int getPaymentAmount() {
        return 4500 * getNumberOfCourses();
    }
}
