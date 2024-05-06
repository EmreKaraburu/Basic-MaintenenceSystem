package Data_StructerMaintenence;

//Emre Karaburu 

// Country class represents a country with its properties
public class Country {

    private String name;
    private int population;
    private String capitalCity;
    private String largestCity;
    private String language;
    private String currency;

    public Country(String name, int population, String capitalCity, String largestCity, String language, String currency) {
        this.name = name;
        this.population = population;
        this.capitalCity = capitalCity;
        this.largestCity = largestCity;
        this.language = language;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public void setLargestCity(String largestCity) {
        this.largestCity = largestCity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
