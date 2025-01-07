public class MainJ {
    private static RealEstateManager manager = new RealEstateManager("Moshe Cohen");

    public static void main(String[] args) {


        Property[] initialProps = DataManager.getProperties();
        for (Property p : initialProps) {
            manager.addProperty(p);
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("בחר פעולה:");
            System.out.println("1) חיפוש נכסים עד מחיר");
            System.out.println("2) דו\"ח פיננסי (כמה מס שולם)");
            System.out.println("3) תשואת נדל\"ן מסחרי");
            System.out.println("4) נכסים לפי עיר");
            System.out.println("5) כמות ערים");
            System.out.println("-1) יציאה מהתוכנית");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("אנא הזן מספר תקין.");
                continue;
            }

            switch (choice) {
                case 1:
                    propertiesList(sc);
                    break;
                case 2:
                    financialReport();
                    break;
                case 3:
                    commercialYield();
                    break;
                case 4:
                    propertiesByCity(sc);
                    break;
                case 5:
                    numberOfCities();
                    break;
                case -1:
                    System.out.println("יציאה... להתראות!");
                    sc.close();
                    return;
                default:
                    System.out.println("בחירה לא תקינה.");
                    break;
            }
        }
    }


    public static void propertiesList(Scanner sc) {
        System.out.print("הכנס מחיר מקסימלי: ");
        try {
            double maxPrice = Double.parseDouble(sc.nextLine());
            Property[] result = manager.searchByPrice(maxPrice);
            if (result.length == 0) {
                System.out.println("לא נמצאו נכסים עד מחיר זה.");
            } else {
                System.out.println("נכסים עד מחיר " + maxPrice + ":");
                for (Property p : result) {
                    System.out.println("  " + p);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("אנא הזן ערך מספרי תקין.");
        } catch (PriceException pe) {
            System.out.println("שגיאה: " + pe.getMessage());
        }
    }


    public static void financialReport() {
        System.out.println("דו\"ח פיננסי - מס רכישה עבור כל נכס:");
        for (Property p : manager.getProperties()) {
            System.out.println(p);
            p.taxIt();  // קריאה למימוש הספציפי של כל נכס
            System.out.println("------------------------");
        }
    }

    /**
     * (12) תשואת נדל״ן מסחרי: פונקציה הסוכמת את התשואה הכוללת
     * של כל הנכסים מסוג נדל"ן מסחרי.
     */
    public static void commercialYield() {
        double sumYield = manager.sumCommercialYield();
        System.out.printf("סכום התשואה הכוללת של כל הנכסים המסחריים: %.2f%%\n", sumYield);
    }

    /**
     * (13) נכסים לפי עיר
     */
    public static void propertiesByCity(Scanner sc) {
        System.out.print("הכנס שם עיר לחיפוש: ");
        String cityInput = sc.nextLine();
        Property[] result = manager.propertiesByCity(cityInput);
        if (result.length == 0) {
            System.out.println("לא נמצאו נכסים בעיר המבוקשת.");
        } else {
            System.out.println("נכסים שנמצאו בעיר (" + cityInput + "):");
            for (Property p : result) {
                System.out.println("  " + p);
            }
        }
    }

    /**
     * (14) כמות ערים שונות
     */
    public static void numberOfCities() {
        manager.numberOfCities();
    }
}
