package Bugeei;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BudgetManager {

    private FileManager fileManager = new FileManager();
    private Scanner sc = new Scanner(System.in);

    // ---------------- ADD INCOME ----------------

    public void addIncome() {

        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter Income Source: ");
        String source = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Income income = new Income(date, source, amount);

        fileManager.saveIncome(income);

        System.out.println("Income Added Successfully!");
    }

    // ---------------- ADD EXPENSE ----------------

    public void addExpense() {

        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Expense expense = new Expense(date, category, description, amount);

        fileManager.saveExpense(expense);

        System.out.println("Expense Added Successfully!");
    }

    // ---------------- VIEW INCOME ----------------

    public void viewIncome() {

        ArrayList<Income> list = fileManager.readIncome();

        if (list.isEmpty()) {
            System.out.println("No Income Records Found.");
            return;
        }

        System.out.println("\n========== INCOME ==========");

        for (Income income : list) {

            System.out.println("----------------------------");
            System.out.println("Date   : " + income.getDate());
            System.out.println("Source : " + income.getSource());
            System.out.println("Amount : ₹" + income.getAmount());

        }
    }

    // ---------------- VIEW EXPENSE ----------------

    public void viewExpense() {

        ArrayList<Expense> list = fileManager.readExpense();

        if (list.isEmpty()) {
            System.out.println("No Expense Records Found.");
            return;
        }

        System.out.println("\n========== EXPENSES ==========");

        for (Expense expense : list) {

            System.out.println("----------------------------");
            System.out.println("Date        : " + expense.getDate());
            System.out.println("Category    : " + expense.getCategory());
            System.out.println("Description : " + expense.getDescription());
            System.out.println("Amount      : ₹" + expense.getAmount());

        }
    }

    // ---------------- TOTAL INCOME ----------------

    public void totalIncome() {

        ArrayList<Income> list = fileManager.readIncome();

        double total = 0;

        for (Income income : list) {

            total += income.getAmount();

        }

        System.out.println("Total Income : ₹" + total);

    }

    // ---------------- TOTAL EXPENSE ----------------

    public void totalExpense() {

        ArrayList<Expense> list = fileManager.readExpense();

        double total = 0;

        for (Expense expense : list) {

            total += expense.getAmount();

        }

        System.out.println("Total Expense : ₹" + total);

    }

    // ---------------- BALANCE ----------------

    public void showBalance() {

        ArrayList<Income> incomeList = fileManager.readIncome();
        ArrayList<Expense> expenseList = fileManager.readExpense();

        double totalIncome = 0;
        double totalExpense = 0;

        for (Income income : incomeList) {

            totalIncome += income.getAmount();

        }

        for (Expense expense : expenseList) {

            totalExpense += expense.getAmount();

        }

        double balance = totalIncome - totalExpense;

        System.out.println("\n========== BALANCE ==========");
        System.out.println("Total Income  : ₹" + totalIncome);
        System.out.println("Total Expense : ₹" + totalExpense);
        System.out.println("Current Balance : ₹" + balance);

    }

    // ---------------- MONTHLY REPORT ----------------

    public void monthlyReport() {

        System.out.print("Enter Month (MM): ");
        String month = sc.nextLine();

        double incomeTotal = 0;
        double expenseTotal = 0;

        ArrayList<Income> incomeList = fileManager.readIncome();

        for (Income income : incomeList) {

            String[] parts = income.getDate().split("-");

            if (parts[1].equals(month)) {

                incomeTotal += income.getAmount();

            }

        }

        ArrayList<Expense> expenseList = fileManager.readExpense();

        for (Expense expense : expenseList) {

            String[] parts = expense.getDate().split("-");

            if (parts[1].equals(month)) {

                expenseTotal += expense.getAmount();

            }

        }

        System.out.println("\n====== MONTHLY REPORT ======");
        System.out.println("Income  : ₹" + incomeTotal);
        System.out.println("Expense : ₹" + expenseTotal);
        System.out.println("Savings : ₹" + (incomeTotal - expenseTotal));

    }

    // ---------------- CATEGORY REPORT ----------------

    public void categoryReport() {

        ArrayList<Expense> expenseList = fileManager.readExpense();

        HashMap<String, Double> map = new HashMap<>();

        for (Expense expense : expenseList) {

            String category = expense.getCategory();

            if (map.containsKey(category)) {

                map.put(category, map.get(category) + expense.getAmount());

            } else {

                map.put(category, expense.getAmount());

            }

        }

        System.out.println("\n===== CATEGORY REPORT =====");

        for (String category : map.keySet()) {

            System.out.println(category + " : ₹" + map.get(category));

        }

    }

    // ---------------- SEARCH EXPENSE ----------------

    public void searchExpense() {

        System.out.print("Enter Category: ");
        String search = sc.nextLine();

        ArrayList<Expense> expenseList = fileManager.readExpense();

        boolean found = false;

        for (Expense expense : expenseList) {

            if (expense.getCategory().equalsIgnoreCase(search)) {

                found = true;

                System.out.println("----------------------------");
                System.out.println("Date : " + expense.getDate());
                System.out.println("Category : " + expense.getCategory());
                System.out.println("Description : " + expense.getDescription());
                System.out.println("Amount : ₹" + expense.getAmount());

            }

        }

        if (!found) {

            System.out.println("No Record Found.");

        }

    }

    // ---------------- EDIT EXPENSE ----------------

    public void editExpense() {

        ArrayList<Expense> list = fileManager.readExpense();

        if (list.isEmpty()) {

            System.out.println("No Expense Records.");

            return;
        }

        for (int i = 0; i < list.size(); i++) {

            Expense e = list.get(i);

            System.out.println((i + 1) + ". "
                    + e.getCategory()
                    + " - ₹"
                    + e.getAmount());

        }

        System.out.print("Select Record: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > list.size()) {

            System.out.println("Invalid Choice.");

            return;
        }

        Expense expense = list.get(choice - 1);

        System.out.print("New Date: ");
        expense.setDate(sc.nextLine());

        System.out.print("New Category: ");
        expense.setCategory(sc.nextLine());

        System.out.print("New Description: ");
        expense.setDescription(sc.nextLine());

        System.out.print("New Amount: ");
        expense.setAmount(sc.nextDouble());
        sc.nextLine();

        fileManager.overwriteExpense(list);

        System.out.println("Expense Updated Successfully.");

    }

    // ---------------- DELETE EXPENSE ----------------

    public void deleteExpense() {

        ArrayList<Expense> list = fileManager.readExpense();

        if (list.isEmpty()) {

            System.out.println("No Expense Records.");

            return;
        }

        for (int i = 0; i < list.size(); i++) {

            Expense e = list.get(i);

            System.out.println((i + 1) + ". "
                    + e.getCategory()
                    + " - ₹"
                    + e.getAmount());

        }

        System.out.print("Enter Record Number to Delete: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > list.size()) {

            System.out.println("Invalid Choice.");

            return;
        }

        list.remove(choice - 1);

        fileManager.overwriteExpense(list);

        System.out.println("Expense Deleted Successfully.");

    }

}