package core.midtermexam1;

public class Taxi {
    private String model = "not empty string :)";
    private String country = "not empty string :)";
    private int year = 1903;
    private int milage;
    private boolean sport;
    private int weight = 1000;
    private int topSpeed;
    private int seats;
    private double cost;

    public Taxi(String model, String country, int year, int milage,
                boolean sport, int weight, int topSpeed, int seats, double cost) {
        if (!model.equals(""))
            this.model = model;
        if (!country.equals(""))
            this.country = country;
        if (year > 1903 && year <= 2020)
            this.year = year;
        if (milage > 0 && milage <= 999999)
            this.milage = milage;
        this.sport = sport;
        if (weight > 1000 && weight <= 3000)
        this.weight = weight;
        if (topSpeed > 0 && topSpeed <= 220)
            this.topSpeed = topSpeed;
        if (seats > 0)
            this.seats = seats;
        if (cost > 0.0)
            this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public int getMilage() {
        return milage;
    }

    public boolean isSport() {
        return sport;
    }

    public int getWeight() {
        return weight;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public double getCost() {
        return cost;
    }

    public void setModel(String model) {
        if (!model.equals(""))
            this.model = model;
    }

    public void setCountry(String country) {
        if (!country.equals(""))
            this.country = country;
    }

    public void setYear(int year) {
        if (year > 1903 && year <= 2020)
            this.year = year;
    }

    public void setMilage(int milage) {
        if (milage > 0 && milage <= 999999)
            this.milage = milage;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public void setWeight(int weight) {
        if (weight > 1000 && weight <= 3000)
            this.weight = weight;
    }

    public void setTopSpeed(int topSpeed) {
        if (topSpeed > 0 && topSpeed <= 220)
            this.topSpeed = topSpeed;
    }

    public void setSeats(int seats) {
        if (seats > 0)
            this.seats = seats;
    }

    public void setCost(double cost) {
        if (cost > 0.0)
            this.cost = cost;
    }
}
