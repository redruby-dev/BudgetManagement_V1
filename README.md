# BudgetManagement_V1
# Personal Budget Tracker

A console-based Java application designed to help users track their personal finances by managing income, expenses, and viewing detailed financial reports.

## Features

- **Income Management:** Add income sources, view income history, and calculate total income.
- **Expense Tracking:** Log expenses by category, view expense logs, search by category, and calculate total expenses.
- **Financial Health:** Real-time balance calculation (Total Income - Total Expenses).
- **Reporting:** 
  - **Monthly Report:** Filter financial data by a specific month.
  - **Category Report:** Breakdown of spending habits using HashMaps.
- **Data Persistence:** Automatically saves, edits, and deletes records locally using a dedicated `FileManager`.

## Project Structure

The application is structured within the `Bugeei` package and consists of the following components:

- `main.java`: Entry point containing the interactive user console menu.
- `BudgetManager.java`: Core engine handling the business logic, calculations, and reporting.
- `FileManager.java`: Interface handling local file read/write operations.
- `Income.java` & `Expense.java`: Model classes representing financial data structures.
- `expense.txt` & `income.txt`: These are the text files that keeps track of data.

## How to Run

1. Ensure you have the Java Development Kit (JDK) installed.
2. Clone the repository.
3. Compile and run the `main.java` file through your preferred IDE (Eclipse, VS Code, IntelliJ) or terminal:
   ```bash
   javac Bugeei/main.java
   java Bugeei.main
