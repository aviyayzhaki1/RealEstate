public class Apartment extends Residential {



    private int rooms;


    public Apartment(String address, double area, double price, int parkingLots, int rooms) {
        super(address, area, price, parkingLots);
        setRooms(rooms);
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if (rooms <= 1) {
            this.rooms = 1;
        } else {
            this.rooms = rooms;
        }
    }


    @Override
    public void taxIt() {
        double tax = getPrice() * 0.08;
        System.out.printf("Apartment tax to pay: %.2f%n", tax);
    }

    @Override
    public String toString() {
        return "Apartment: " + super.toString() + ", Rooms: " + getRooms();
    }
}
