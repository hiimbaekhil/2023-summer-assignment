public class PaymentTest {
    public static void main(String[] args) {
        // create six-element Payment array
        Payment[] paymentObjects = new Payment[] {
                new GraduateStudent("子偉", "林", "ID-001", 4),
                new GraduateStudent("進德", "張", "ID-002", 3),
                new UndergraduateStudent("俊麟", "郭", "ID-003"),
                new GraduateStudent("智為", "胡", "ID-004", 5),
                new UndergraduateStudent("維中", "王", "ID-005"),
                new EveningProgramStudent("偉殷", "陳", "ID-006")
        };

        int total = 0;
        // generically process each element in array paymentObjects
        for (Payment currentPayment : paymentObjects) {
            // output currentPayment and its appropriate payment amount
            System.out.println(currentPayment);
            // determine whether element is a GraduateStudent
            if (currentPayment instanceof GraduateStudent) {

                System.out.printf("original tuition: $%,d%n", currentPayment.getPaymentAmount());
                System.out.printf("new tuition: $%,d%n%n", (int) (currentPayment.getPaymentAmount() * 0.9));

                total += (int) (currentPayment.getPaymentAmount() * 0.9);

            } else {

                System.out.printf("tuition: $%,d%n%n", currentPayment.getPaymentAmount());

                total += currentPayment.getPaymentAmount();
            }
        }

        System.out.printf("%ntotal tuition income: $%,d%n", total);
    }
}
