package Data_StructerMaintenence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Emre Karaburu

public class FileProcessor {
    // Creates the query file with predefined queries
    public void createQueryFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("query.txt"); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            
            printWriter.println("Query population > 50.000.000");
            printWriter.println("Query country > HUNGARY");
            printWriter.println("Query capital_city < Canakkale");
            printWriter.println("Query largest_city = İstanbul");
            printWriter.println("Query country = USA");
            printWriter.println("Add BULGARIA 6500000 Sofia Sofia Bulgarian LEV");
            printWriter.println("Query print_all");
            printWriter.println("Delete GERMANY");
            printWriter.println("Query print_all");
            printWriter.println("Query currency < M");
            
        }
    }
    // Creates the input file with predefined country data
    public void createInputFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("input.txt"); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            
            printWriter.println("TURKEY,85000000,Ankara,Istanbul,Turkish,TRY");
            printWriter.println("GERMANY,83000000,Berlin,Berlin,German,EUR");
            printWriter.println("USA,335000000,Washington,NewYork,English,USD");
            
        }
    }
    // Reads data from the input file and stores it in the countriesList
    public void storeInput(DoublyLinkedList countriesList) throws IOException {
        try (FileReader fileReader = new FileReader("input.txt"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String name = parts[0].trim();
                    int population = Integer.parseInt(parts[1].trim().replaceAll("[.,]", ""));
                    String capitalCity = parts[2].trim();
                    String largestCity = parts[3].trim();
                    String language = parts[4].trim();
                    String currency = parts[5].trim();
                    Country country = new Country(name, population, capitalCity, largestCity, language, currency);
                    countriesList.addCountry(country);
                }
            }
            
        }
    }
    // Reads and applies queries from the query file to the countriesList
    public void readQuery(DoublyLinkedList countriesList) throws IOException {
        try (FileReader fileReader = new FileReader("query.txt"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 1) {
                    String queryType = parts[0].trim().toLowerCase();
                    switch (queryType) {
                        case "query" -> {
                            if (parts.length >= 4) {
                                String property = parts[1].trim();
                                String operator = parts[2].trim();
                                String value = parts[3].trim();
                                System.out.println("● " + line);
                                QueryProcessor.processQuery(property, operator, value, countriesList);
                            }
                        }
                        case "add" -> {
                            if (parts.length == 7) {
                                String name = parts[1].trim();
                                int population = Integer.parseInt(parts[2].trim().replaceAll("[.,]", ""));
                                String capitalCity = parts[3].trim();
                                String largestCity = parts[4].trim();
                                String language = parts[5].trim();
                                String currency = parts[6].trim();
                                Country country = new Country(name, population, capitalCity, largestCity, language, currency);
                                countriesList.addCountry(country);
                                System.out.println("Add: " + line);
                                countriesList.printAllCountries(); // Yeni ülkeyi ekledikten sonra tüm ülkeleri yazdır
                            }
                        }
                        case "delete" -> {
                            if (parts.length == 2) {
                                String countryName = parts[1].trim();
                                countriesList.deleteCountry(countryName);
                                System.out.println("Delete: " + line);
                                countriesList.printAllCountries(); // Ülkeyi sildikten sonra tüm ülkeleri yazdır
                            }
                        }
                        case "print_all" -> {
                            System.out.println("Query print_all");
                            countriesList.printAllCountries();
                        }
                        default -> System.out.println("Invalid query: " + line);
                    }
                }
            }
            
        }
    }

}