package Data_StructerMaintenence;

//Emre Karaburu

public class QueryProcessor {

   // QueryProcessor class processes queries and prints the results
    
    
    public static void processQuery(String property, String operator, String value, DoublyLinkedList countriesList) {
        switch (property) {
            case "population" -> processPopulation(operator, value, countriesList);
            case "country" -> processCountry(operator, value, countriesList);
            case "capital_city" -> processCapitalCity(operator, value, countriesList);
            case "largest_city" -> processLargestCity(operator, value, countriesList);
            case "currency" -> processCurrency(operator, value, countriesList);
            default -> System.out.println("Invalid property: " + property);
        }
    }

    private static void processPopulation(String operator, String value, DoublyLinkedList countriesList) {
        int targetPopulation = Integer.parseInt(value.replaceAll("[.,]", ""));
        Node current = countriesList.head;
        boolean found = false;
        while (current != null) {
            int population = current.data.getPopulation();
            boolean result = compareValues(population, operator, targetPopulation);
            if (result) {
                if (!found) {
                    found = true;
                }
                Country country = current.data;
                System.out.println(country.getName() + " " + country.getPopulation() + " " +
                                   country.getCapitalCity() + " " + country.getLargestCity() + " " +
                                   country.getLanguage() + " " + country.getCurrency());
            }
            current = current.next;
        }
    }

    private static void processCountry(String operator, String value, DoublyLinkedList countriesList) {
        String targetCountry = value.toUpperCase();
        Node current = countriesList.head;
        boolean found = false;
        while (current != null) {
            String countryName = current.data.getName().toUpperCase();
            boolean result = compareStrings(countryName, operator, targetCountry);
            if (result) {
                if (!found) {
                    found = true;
                }
                Country country = current.data;
                System.out.println(country.getName() + " " + country.getPopulation() + " " +
                                   country.getCapitalCity() + " " + country.getLargestCity() + " " +
                                   country.getLanguage() + " " + country.getCurrency());
            }
            current = current.next;
        }
    }

    private static void processCapitalCity(String operator, String value, DoublyLinkedList countriesList) {
        String targetCapitalCity = value.toUpperCase();
        Node current = countriesList.head;
        boolean found = false;
        while (current != null) {
            String capitalCity = current.data.getCapitalCity().toUpperCase();
            boolean result = compareStrings(capitalCity, operator, targetCapitalCity);
            if (result) {
                if (!found) {
                    found = true;
                }
                Country country = current.data;
                System.out.println(country.getName() + " " + country.getPopulation() + " " +
                                   country.getCapitalCity() + " " + country.getLargestCity() + " " +
                                   country.getLanguage() + " " + country.getCurrency());
            }
            current = current.next;
        }
    }

    private static void processLargestCity(String operator, String value, DoublyLinkedList countriesList) {
        String targetLargestCity = value.toUpperCase();
        Node current = countriesList.head;
        boolean found = false;
        while (current != null) {
            String largestCity = current.data.getLargestCity().toUpperCase();
            boolean result = compareStrings(largestCity, operator, targetLargestCity);
            if (result) {
                if (!found) {
                    found = true;
                }
                Country country = current.data;
                System.out.println(country.getName() + " " + country.getPopulation() + " " +
                                   country.getCapitalCity() + " " + country.getLargestCity() + " " +
                                   country.getLanguage() + " " + country.getCurrency());
            }
            current = current.next;
        }
    }

    private static void processCurrency(String operator, String value, DoublyLinkedList countriesList) {
        String targetCurrency = value.toUpperCase();
        Node current = countriesList.head;
        boolean found = false;
        while (current != null) {
            String currency = current.data.getCurrency().toUpperCase();
            boolean result = compareStrings(currency, operator, targetCurrency);
            if (result) {
                if (!found) {
                    found = true;
                }
                Country country = current.data;
                System.out.println(country.getName() + " " + country.getPopulation() + " " +
                                   country.getCapitalCity() + " " + country.getLargestCity() + " " +
                                   country.getLanguage() + " " + country.getCurrency());
            }
            current = current.next;
        }
    }

    private static boolean compareValues(int value1, String operator, int value2) {
        switch (operator) {
            case ">" -> {
                return value1 > value2;
            }
            case "<" -> {
                return value1 < value2;
            }
            case "=" -> {
                return value1 == value2;
            }
            default -> {
                System.out.println("Invalid operator: " + operator);
                return false;
            }
        }
    }

    private static boolean compareStrings(String str1, String operator, String str2) {
        switch (operator) {
            case ">" -> {
                return str1.compareTo(str2) > 0;
            }
            case "<" -> {
                return str1.compareTo(str2) < 0;
            }
            case "=" -> {
                return str1.equals(str2);
            }
            default -> {
                System.out.println("Invalid operator: " + operator);
                return false;
            }
        }
    }
}