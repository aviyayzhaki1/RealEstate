public class Villa extends Residential {


    private int levels;


    public Villa(String address, double area, double price, int parkingLots, int levels) {
        super(address, area, price, parkingLots);
        setLevels(levels);
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        if (levels < 1) {
            this.levels = 1;
        } else {
            this.levels = levels;
        }
    }


    @Override
    public void taxIt() {
        double tax = getPrice() * 0.08;
        System.out.printf("Villa tax to pay: %.2f%n", tax);
    }

    @Override
    public String toString() {
        return "Villa: " + super.toString() + ", Levels: " + getLevels();
    }
}
