import static jdk.incubator.foreign.MemoryAccess.setAddress;

public abstract class Property {

    private String address;
    private double area;
    private double price;
    public Property(String address, double area, double price) {
        setAddress(address);  
        setArea(area);
        setPrice(price);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        if (address == null || address.trim().isEmpty()) {
            this.address = "Na, na";
        } else {

            String[] parts = address.trim().split("\\s+");
            if (parts.length < 2) {
                this.address = "Na, na";
            } else {
                this.address = address;
            }
        }
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 0) {
            this.area = 0;
        } else {
            this.area = area;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }


    public abstract void taxIt();




    @Override
    public String toString() {
        return String.format("Address: %s, Area: %.2f, Price: %.2f",
                getAddress(), getArea(), getPrice());
    }
}
}
