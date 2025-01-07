public class Office extends Property {

    public Office(String address, double area, double price) {
        super(address, area, price);
    }

    @Override
    public void taxIt() {
        double tax = getPrice() * 0.05;
        System.out.printf("Office tax to pay: %.2f%n", tax);
    }

    @Override
    public String toString() {
        return "Office: " + super.toString();
    }
}
