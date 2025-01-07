public class Vacation extends Residential {


    private int guests;


    public Vacation(String address, double area, double price, int parkingLots, int guests) {
        super(address, area, price, parkingLots);
        setGuests(guests);
    }


    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        if (guests < 1) {
            this.guests = 1;
        } else {
            this.guests = guests;
        }
    }


    @Override
    public void taxIt() {
        double tax = getPrice() * 0.25;
        System.out.printf("Vacation tax to pay: %.2f%n", tax);
    }


    @Override
    public String toString() {
        return "Vacation: " + super.toString() + ", Guests: " + getGuests();
    }
}