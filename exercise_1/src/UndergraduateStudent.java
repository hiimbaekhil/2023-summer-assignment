public class UndergraduateStudent extends Student {

    // constructor
    public UndergraduateStudent(String firstName, String lastName, String studentID) {
        super(firstName, lastName, studentID);
    }

    // method required to carry out contract with interface Payment
    @Override
    public int getPaymentAmount() {
        return 30000;
    }
}
