public class Commercial extends Property {

    private boolean storeroom;
    private double yield;


    public Commercial(String address, double area, double price, double yield) {
        super(address, area, price);
        setYield(yield);
        this.storeroom = false;
    }


    public Commercial(String address, double area, double price, double yield, boolean storeroom) {
        super(address, area, price);
        setYield(yield);
        this.storeroom = storeroom;
    }

    public boolean isStoreroom() {
        return storeroom;
    }

    public void setStoreroom(boolean storeroom) {
        this.storeroom = storeroom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if (yield < 0) {
            this.yield = 0;
        } else {
            this.yield = yield;
        }
    }


    @Override
    public void taxIt() {
        double tax = getPrice() * 0.05; // 5%
        System.out.printf("Commercial tax to pay: %.2f%n", tax);
    }


    public void printMonthlyProfit() {
        double profit = getPrice() * (getYield() / 100.0) / 12.0;
        System.out.printf("Monthly profit for commercial property: %.2f%n", profit);
    }


    @Override
    public String toString() {
        return "Commercial: " + super.toString() +
                ", Storeroom: " + isStoreroom() +
                ", Yield: " + getYield();
    }
}