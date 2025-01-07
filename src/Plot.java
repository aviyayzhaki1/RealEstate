public class Plot extends Property {

    private PlotType type;


    public Plot(String address, double area, double price, PlotType type) {
        super(address, area, price);
        setType(type);
    }

    public PlotType getType() {
        return type;
    }

    public void setType(PlotType type) {
        if (type == null) {
            this.type = PlotType.URBAN;
        } else {
            this.type = type;
        }
    }


    @Override
    public void taxIt() {
        double price = getPrice();
        double tax = 0;

        switch (getType()) {
            case URBAN:
                tax = price * 0.10; // 10%
                break;
            case INDUSTRIAL:
                tax = price * 0.05; // 5%
                break;
            case AGRICULTURAL:
                tax = price * 0.02; // 2%
                break;
        }

        System.out.printf("Plot tax to pay (Type=%s): %.2f%n", getType(), tax);
    }


    @Override
    public String toString() {
        return "Plot: " + super.toString() + ", Type: " + getType();
    }
}
