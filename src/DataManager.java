public class DataManager {
    public static Property[] getProperties() {
        Property[] props = new Property[10];

       
        props[0] = new Plot("Tel Aviv, Rothschild 1", 500, 3_000_000, PlotType.URBAN);
        props[1] = new Plot("Rishon LeZion, Hakfar 15", 1000, 2_000_000, PlotType.AGRICULTURAL);


        props[2] = new Apartment("Ramat Gan, Bialik 23", 80, 1_200_000, 1, 3);
        props[3] = new Apartment("Kfar Saba, Weitzman 18", 70, 1_000_000, 2, 4);


        props[4] = new Villa("Herzliya, Galey Techelet 5", 250, 5_500_000, 2, 2);
        props[5] = new Villa("Tel Aviv, Hadar 10", 300, 7_000_000, 3, 3);


        props[6] = new Vacation("Eilat, Princess 1", 100, 2_000_000, 2, 5);
        props[7] = new Vacation("Tiberias, LakeSide 7", 90, 1_500_000, 1, 4);


        props[8] = new Commercial("Petah Tikva, Jabotinsky 100", 120, 2_000_000, 6.0);
        props[9] = new Commercial("Jerusalem, King George 20", 200, 3_000_000, 10.0, true);


        return props;
}
