package Bugeei;
public class Income {
    private String date;
    private String source;
    private double amount;

    // Constructor
    public Income(String date, String source, double amount) {
        this.date = date;
        this.source = source;
        this.amount = amount;
    }

    // Getters
    public String getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Save object as one line in text file
    @Override
    public String toString() {
        return date + "," + source + "," + amount;
    }
}