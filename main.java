package Bugeei;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BudgetManager manager = new BudgetManager();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("      PERSONAL BUDGET TRACKER");
            System.out.println("======================================");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Income");
            System.out.println("4. View Expenses");
            System.out.println("5. Total Income");
            System.out.println("6. Total Expense");
            System.out.println("7. Show Balance");
            System.out.println("8. Monthly Report");
            System.out.println("9. Category Report");
            System.out.println("10. Search Expense");
            System.out.println("11. Edit Expense");
            System.out.println("12. Delete Expense");
            System.out.println("13. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    manager.addIncome();
                    break;

                case 2:
                    manager.addExpense();
                    break;

                case 3:
                    manager.viewIncome();
                    break;

                case 4:
                    manager.viewExpense();
                    break;

                case 5:
                    manager.totalIncome();
                    break;

                case 6:
                    manager.totalExpense();
                    break;

                case 7:
                    manager.showBalance();
                    break;

                case 8:
                    manager.monthlyReport();
                    break;

                case 9:
                    manager.categoryReport();
                    break;

                case 10:
                    manager.searchExpense();
                    break;

                case 11:
                    manager.editExpense();
                    break;

                case 12:
                    manager.deleteExpense();
                    break;

                case 13:
                    System.out.println("\nThank you for using Budget Tracker!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");

            }

        } while (choice != 13);

        sc.close();

    }

}