public class RealEstateManager {

    private String name;
    private Property[] properties;

    public RealEstateManager(String name) {
        this.name = name;
        this.properties = new Property[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Property[] getProperties() {
        return properties;
    }


    public void addProperty(Property p) {
        if (p == null) return;
        properties = Arrays.copyOf(properties, properties.length + 1);
        properties[properties.length - 1] = p;
    }


    public Property[] searchByPrice(double maxPrice) throws PriceException {
        if (maxPrice < 0) {
            throw new PriceException("price cannt be negative");
        }


        Property[] temp = new Property[properties.length];
        int index = 0;

        for (Property prop : properties) {
            if (prop.getPrice() <= maxPrice) {
                temp[index++] = prop;
            }
        }


        return Arrays.copyOf(temp, index);
    }


    public double totalValue() {
        double sum = 0;
        for (Property prop : properties) {
            sum += prop.getPrice();
        }
        return sum;
    }


    public double sumCommercialYield() {
        double totalYield = 0;
        for (Property prop : properties) {
            if (prop instanceof Commercial) {
                totalYield += ((Commercial) prop).getYield();
            }
        }
        return totalYield;
    }


    public Property[] propertiesByCity(String city) {
        if (city == null || city.isEmpty()) {
            return new Property[0];
        }


        String cityClean = city.replace("-", "").toLowerCase();

        Property[] temp = new Property[properties.length];
        int index = 0;

        for (Property prop : properties) {
            String addressClean = prop.getAddress()
                    .replace("-", "")
                    .replace(",", "")
                    .toLowerCase();
            if (addressClean.contains(cityClean)) {
                temp[index++] = prop;
            }
        }

        return Arrays.copyOf(temp, index);
    }


    public void numberOfCities() {
        java.util.Set<String> citiesSet = new java.util.HashSet<>();

        for (Property prop : properties) {
            String address = prop.getAddress();
            String city = address.split(",")[0].trim();
            citiesSet.add(city);
        }

        // כמות ערים
        System.out.println("Number of distinct cities: " + citiesSet.size());
        System.out.println("Cities list: " + citiesSet);
    }
}
