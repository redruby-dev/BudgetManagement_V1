package Bugeei;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private final String incomeFile = "income.txt";
    private final String expenseFile = "expense.txt";

    // ---------------- SAVE INCOME ----------------

    public void saveIncome(Income income) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(incomeFile, true));

            writer.write(income.toString());
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving income.");
        }
    }

    // ---------------- SAVE EXPENSE ----------------

    public void saveExpense(Expense expense) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(expenseFile, true));

            writer.write(expense.toString());
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving expense.");
        }
    }

    // ---------------- READ ALL INCOME ----------------

    public ArrayList<Income> readIncome() {

        ArrayList<Income> incomeList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(incomeFile));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String date = data[0];
                String source = data[1];
                double amount = Double.parseDouble(data[2]);

                incomeList.add(new Income(date, source, amount));
            }

            reader.close();

        } catch (IOException e) {
            // File may be empty
        }

        return incomeList;
    }

    // ---------------- READ ALL EXPENSE ----------------

    public ArrayList<Expense> readExpense() {

        ArrayList<Expense> expenseList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(expenseFile));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String date = data[0];
                String category = data[1];
                String description = data[2];
                double amount = Double.parseDouble(data[3]);

                expenseList.add(new Expense(date, category, description, amount));
            }

            reader.close();

        } catch (IOException e) {
            // File may be empty
        }

        return expenseList;
    }

    // ---------------- OVERWRITE INCOME FILE ----------------

    public void overwriteIncome(ArrayList<Income> incomeList) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(incomeFile));

            for (Income income : incomeList) {

                writer.write(income.toString());
                writer.newLine();

            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error updating income file.");

        }

    }

    // ---------------- OVERWRITE EXPENSE FILE ----------------

    public void overwriteExpense(ArrayList<Expense> expenseList) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(expenseFile));

            for (Expense expense : expenseList) {

                writer.write(expense.toString());
                writer.newLine();

            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error updating expense file.");

        }

    }

}